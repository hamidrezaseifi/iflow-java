package com.pth.iflow.gui.controller.data;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pth.iflow.common.enums.EInvoiceWorkflowTypeItems;
import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.authentication.GuiAuthenticationToken;
import com.pth.iflow.gui.controller.GuiSocketControllerBase;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSetting;
import com.pth.iflow.gui.models.ui.GuiSocketMessage;
import com.pth.iflow.gui.models.ui.enums.ESocketCommands;
import com.pth.iflow.gui.models.ui.ocr.OcrResultValueType;
import com.pth.iflow.gui.models.ui.ocr.OcrResultWord;
import com.pth.iflow.gui.models.ui.ocr.OcrResults;
import com.pth.iflow.gui.services.ICompanyHandler;
import com.pth.iflow.gui.services.IProfileAccess;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Controller
@RequestMapping(value = "/")
public class SocketDataController extends GuiSocketControllerBase {

  @Autowired
  SimpMessagingTemplate simpMessagingTemplate;

  @Autowired
  private IProfileAccess profileValidator;

  @Autowired
  private ICompanyHandler companyHandler;

  @MessageMapping("/start")
  @SendTo("/socket/test")
  public GuiSocketMessage greeting(final GuiSocketMessage message) throws Exception {

    final String sentMessage = message.containsKey("sentMessage") ? message.get("sentMessage").toString() : "not found!";

    final GuiSocketMessage result = GuiSocketMessage.generate("received");

    result.put("msg", sentMessage);

    Thread.sleep(100);
    return result;
  }

  @MessageMapping("/resetmessage")
  @SendToUser("/socket/messages")
  @SubscribeMapping("/messages")
  public GuiSocketMessage resetMessageSocket(final GuiSocketMessage message, final Principal principal,
      final SimpMessageHeaderAccessor headerAccessor) throws Exception {

    final GuiSocketMessage result = GuiSocketMessage.generate("processing");

    if (this.isPrincipalValidAndLoggedIn(principal)) {
      // final GuiAuthenticationToken guiAuth = (GuiAuthenticationToken) principal;

      result.setCommand(ESocketCommands.MESSAGE_RELOAD.getValue());
      result.setStatus("done");
    }

    return result;
  }

  @MessageMapping("/ocrprocess")
  @SendToUser("/socket/ocrprocess")
  public GuiSocketMessage processInvoiceFile(final GuiSocketMessage message, final Principal principal,
      final SimpMessageHeaderAccessor headerAccessor) {

    final GuiSocketMessage result = message.clone();
    result.setStatus("processing");

    if (this.isPrincipalValidAndLoggedIn(principal) && message.hasFileHash() && message.hasHocrFileHash()) {

      final String filePath = message.getFileNotHash();
      final String hocrPath = message.getHocrFileNotHash();

      final File file = new File(filePath);
      if (file.exists()) {

        try {
          final Tesseract tesseract = new Tesseract();
          tesseract.setDatapath("F://Softwares//Tess4J//tessdata");
          tesseract.setLanguage("deu");
          tesseract.setHocr(true);
          final String hocrResult = tesseract.doOCR(file);

          final BufferedWriter writer = new BufferedWriter(new FileWriter(hocrPath));
          writer.write(hocrResult);

          writer.close();

          // final OcrResults results = OcrResults.loadFromHocrFile(hocrPath);
          final OcrResults ocrResults = OcrResults.loadFromHocrText(hocrResult);

          final Map<String, Set<OcrResultWord>> words = this.retreiveInvoiceDetailWords(ocrResults, (GuiAuthenticationToken) principal);

          result.setWords(words);
          result.setPageCount(ocrResults.getPages().size());

          result.setImageWidth(300);
          result.setImageHeight(500);
          if (result.getIsFileImage()) {
            final BufferedImage bimg = ImageIO.read(file);
            result.setImageWidth(bimg.getWidth());
            result.setImageHeight(bimg.getHeight());
          }

          if (result.getIsFilePdf() && ocrResults.getPages().size() > 0) {
            result.setImageWidth(ocrResults.getPages().get(0).getBox().getWidth());
            result.setImageHeight(ocrResults.getPages().get(0).getBox().getHeight());
          }

          result.setStatus("done");
        }
        catch (final IOException e) {

          result.setStatus("error");
          result.setErrorMessage(e.getLocalizedMessage());
          result.setErrorDetail(e.getStackTrace());
        }
        catch (final TesseractException e) {

          result.setStatus("error");
          result.setErrorMessage(e.getLocalizedMessage());
          result.setErrorDetail(e.getStackTrace());
        }
        catch (final NoClassDefFoundError e) {

          result.setStatus("error");
          result.setErrorMessage(e.getLocalizedMessage());
          result.setErrorDetail(e.getStackTrace());
          System.out.println(e);
        }
        catch (final Exception e) {

          result.setStatus("error");
          result.setErrorMessage(e.getLocalizedMessage());
          result.setErrorDetail(e.getStackTrace());
        }

      }
      else {
        result.setStatus("file not found!");
      }

    }

    return result;
  }

  private Map<String, Set<OcrResultWord>> retreiveInvoiceDetailWords(final OcrResults ocrResults, final GuiAuthenticationToken token)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String,
        List<CompanyWorkflowtypeItemOcrSetting>> map = this.companyHandler
            .readCompanyWorkflowtypeItemOcrSettings(token.getCompanyId(), token.getToken());

    final List<CompanyWorkflowtypeItemOcrSetting> list = map.get(EWorkflowType.INVOICE_WORKFLOW_TYPE.getIdentity());

    final Map<String, Set<OcrResultWord>> words = new HashMap<>();

    Set<OcrResultWord> results = this
        .extractSearchItems(ocrResults, list, EInvoiceWorkflowTypeItems.PAYMENT_AMOUNT.getIdentity(), OcrResultValueType.FLOAT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.PAYMENT_AMOUNT.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, list, EInvoiceWorkflowTypeItems.INVOCIE_SENDER.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.INVOCIE_SENDER.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, list, EInvoiceWorkflowTypeItems.INVOCIE_NUMBER.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.INVOCIE_NUMBER.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, list, EInvoiceWorkflowTypeItems.INVOCIE_DATE.getIdentity(), OcrResultValueType.DATE);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.INVOCIE_DATE.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, list, EInvoiceWorkflowTypeItems.PARTNER_CODE.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.PARTNER_CODE.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, list, EInvoiceWorkflowTypeItems.VENDOR_NUMBER.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.VENDOR_NUMBER.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, list, EInvoiceWorkflowTypeItems.VENDOR_NAME.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.VENDOR_NAME.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, list, EInvoiceWorkflowTypeItems.IS_DIRECT_DEBIT_PERMISSION.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.IS_DIRECT_DEBIT_PERMISSION.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, list, EInvoiceWorkflowTypeItems.INVOICE_TYPE.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.INVOICE_TYPE.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, list, EInvoiceWorkflowTypeItems.DISCOUNT_ENTERDATE.getIdentity(), OcrResultValueType.DATE);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.DISCOUNT_ENTERDATE.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, list, EInvoiceWorkflowTypeItems.DISCOUNT_DEADLINE.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.DISCOUNT_DEADLINE.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, list, EInvoiceWorkflowTypeItems.DISCOUNT_RATE.getIdentity(), OcrResultValueType.FLOAT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.DISCOUNT_RATE.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, list, EInvoiceWorkflowTypeItems.DISCOUNT_DATE.getIdentity(), OcrResultValueType.DATE);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.DISCOUNT_DATE.getIdentity(), results);
    }

    final Set<OcrResultWord> amountWorldList = ocrResults.findWord("betrag", false, false, OcrResultValueType.FLOAT);
    final Set<OcrResultWord> senderWorldList = ocrResults.findWord("sender", false, false, OcrResultValueType.TEXT);
    final Set<OcrResultWord> numberWorldList = ocrResults
        .findWords(new String[] { "R.-Nr.", "Rg-Nr", "R. Nummer", "Rg-Nummer", "Rechnungsnummer", "nr." }, false,
            false,
            OcrResultValueType.TEXT);
    final Set<OcrResultWord> dateWorldList = ocrResults.findWord("Datum", false, false, OcrResultValueType.DATE);
    final Set<OcrResultWord> testList = ocrResults.findWords(new String[] { "ident", "heinstadt" }, false, false, OcrResultValueType.TEXT);

    /*
     * words.put("invoice-paymentamount", amountWorldList); words.put("invoice-sender", senderWorldList); words.put("invoice-invoicenumber",
     * numberWorldList); words.put("invoice-invoicedate", dateWorldList); words.put("test", testList);
     */
    return words;
  }

  private Set<OcrResultWord> extractSearchItems(final OcrResults ocrResults, final List<CompanyWorkflowtypeItemOcrSetting> list,
      final String propertyName, final OcrResultValueType valueType) {

    final Optional<CompanyWorkflowtypeItemOcrSetting> property = list
        .stream()
        .filter(p -> p.getPropertyName().equals(propertyName))
        .findAny();

    Set<OcrResultWord> results = null;
    if (property.isPresent()) {
      final String[] searchWords = property.get().getValue().split(";");
      results = ocrResults.findWords(searchWords, false, false, valueType);
      results = results.isEmpty() ? null : results;
    }

    return results;
  }

  @MessageExceptionHandler
  public String handleException(final Throwable exception) {

    return exception.getMessage();
  }

}

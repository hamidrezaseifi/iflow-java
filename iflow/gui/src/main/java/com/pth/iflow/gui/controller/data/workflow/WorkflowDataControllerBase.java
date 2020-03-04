package com.pth.iflow.gui.controller.data.workflow;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.enums.EInvoiceWorkflowTypeItems;
import com.pth.iflow.common.enums.EOcrType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.controller.data.GuiDataControllerBase;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.CompanyWorkflowTypeController;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSettingPresetItem;
import com.pth.iflow.gui.models.ui.GuiSocketMessage;
import com.pth.iflow.gui.models.ui.ocr.OcrResultValueType;
import com.pth.iflow.gui.models.ui.ocr.OcrResultWord;
import com.pth.iflow.gui.models.ui.ocr.OcrResults;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.IWorkflowSaveRequest;
import com.pth.iflow.gui.services.ICompanyHandler;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IWorkflowHandler;

@Controller
public abstract class WorkflowDataControllerBase<W extends IWorkflow, WS extends IWorkflowSaveRequest<W>> extends GuiDataControllerBase {

  @Autowired
  private IWorkflowHandler<W, WS> workflowHandler;

  @Autowired
  protected IUploadFileManager uploadFileManager;

  @Autowired
  private ICompanyHandler companyHandler;

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/initcreate" })
  @ResponseBody
  public Map<String, Object> loadWorkflowCreateData()
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();

    final W newWorkflow = this.generateInitialWorkflow(this.getLoggedUser().getIdentity());

    this.setWorkflowController(newWorkflow);

    final WS workflowReq = this
        .generateInitialWorkflowSaveRequest(newWorkflow,
            newWorkflow.getHasActiveAction() ? newWorkflow.getActiveAction().getCurrentStep().getExpireDays() : 15);

    map.put("workflowSaveRequest", workflowReq);
    map
        .put("ocrPresetList",
            this.companyHandler.readCompanyWorkflowtypeItemOcrSettings(this.getLoggedCompany().getIdentity(), this.getLoggedToken()));

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/initedit/{workflowIdentity}" })
  @ResponseBody
  public Map<String, Object> loadWorkflowEditData(@PathVariable final String workflowIdentity)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();

    final W workflow = this.workflowHandler.readWorkflow(workflowIdentity);

    final Integer expireDays = workflow.getHasActiveAction() ? workflow.getActiveAction().getCurrentStep().getExpireDays() : 0;

    final WS saveRequest = this.generateInitialWorkflowSaveRequest(workflow, expireDays);

    this.setWorkflowController(workflow);

    map.put("workflowSaveRequest", saveRequest);
    map
        .put("ocrPresetList",
            this.companyHandler.readCompanyWorkflowtypeItemOcrSettings(this.getLoggedCompany().getIdentity(), this.getLoggedToken()));

    return map;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/create" })
  @ResponseBody
  public List<W> createWorkflow(@RequestBody final WS createRequest, final HttpSession session)
      throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {

    createRequest.getWorkflow().setCompanyIdentity(this.getLoggedCompany().getIdentity());

    this.setWorkflowController(createRequest.getWorkflow());

    return this.workflowHandler.createWorkflow(createRequest);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/save" })
  @ResponseBody
  public void saveWorkflow(@RequestBody final WS saveRequest, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    saveRequest.getWorkflow().setCompanyIdentity(this.getLoggedCompany().getIdentity());

    this.setWorkflowController(saveRequest.getWorkflow());

    this.workflowHandler.saveWorkflow(saveRequest);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/archive" })
  @ResponseBody
  public void archiveWorkflow(@RequestBody final W workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    this.setWorkflowController(workflow);

    this.workflowHandler.archiveWorkflow(workflow);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/done" })
  @ResponseBody
  public void makeDoneWorkflow(@RequestBody final WS saveRequest, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    saveRequest.getWorkflow().setCompanyIdentity(this.getLoggedCompany().getIdentity());

    this.setWorkflowController(saveRequest.getWorkflow());

    this.workflowHandler.doneWorkflow(saveRequest);

  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/assign/{workflowIdentity}" })
  @ResponseBody
  public W assignWorkflow(@PathVariable final String workflowIdentity)
      throws GuiCustomizedException, IFlowMessageConversionFailureException, IOException {

    final W workflow = this.workflowHandler.assignWorkflow(workflowIdentity);

    this.setWorkflowController(workflow);

    return workflow;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/processdoc" })
  @ResponseBody
  public GuiSocketMessage processDocument(@RequestBody final GuiSocketMessage message)
      throws IOException, IFlowMessageConversionFailureException {

    final GuiSocketMessage result = message.clone();

    final String selectedPreset = message.getSelectedOcrPreset();
    if (StringUtils.isEmpty(selectedPreset)) {
      result.setStatus("error");
      result.setErrorMessage("Invalid Preset!");

      return result;
    }

    final String filePath = message.getFileNotHash();
    final String hocrPath = message.getHocrFileNotHash();

    final File file = new File(filePath);

    final OcrResults ocrResults = OcrResults.loadFromHocrFile(hocrPath);

    final Map<String,
        Set<OcrResultWord>> words = this.retreiveInvoiceDetailWords(ocrResults, selectedPreset);

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

    return result;
  }

  private Map<String, Set<OcrResultWord>> retreiveInvoiceDetailWords(final OcrResults ocrResults,
      final String selectedPreset) throws MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, CompanyWorkflowtypeItemOcrSettingPresetItem> presetItems = this.companyHandler
        .readPresetAllItems(selectedPreset, this.getLoggedCompany().getIdentity(), this.getLoggedToken());

    final Map<String, Set<OcrResultWord>> words = new HashMap<>();

    Set<OcrResultWord> results = this
        .extractSearchItems(ocrResults, presetItems, EInvoiceWorkflowTypeItems.PAYMENT_AMOUNT.getIdentity(), OcrResultValueType.FLOAT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.PAYMENT_AMOUNT.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, presetItems, EInvoiceWorkflowTypeItems.INVOCIE_SENDER.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.INVOCIE_SENDER.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, presetItems, EInvoiceWorkflowTypeItems.INVOCIE_NUMBER.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.INVOCIE_NUMBER.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, presetItems, EInvoiceWorkflowTypeItems.INVOCIE_DATE.getIdentity(), OcrResultValueType.DATE);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.INVOCIE_DATE.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, presetItems, EInvoiceWorkflowTypeItems.PARTNER_CODE.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.PARTNER_CODE.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, presetItems, EInvoiceWorkflowTypeItems.VENDOR_NUMBER.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.VENDOR_NUMBER.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, presetItems, EInvoiceWorkflowTypeItems.VENDOR_NAME.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.VENDOR_NAME.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, presetItems, EInvoiceWorkflowTypeItems.IS_DIRECT_DEBIT_PERMISSION.getIdentity(),
            OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.IS_DIRECT_DEBIT_PERMISSION.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, presetItems, EInvoiceWorkflowTypeItems.INVOICE_TYPE.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.INVOICE_TYPE.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, presetItems, EInvoiceWorkflowTypeItems.DISCOUNT_ENTERDATE.getIdentity(), OcrResultValueType.DATE);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.DISCOUNT_ENTERDATE.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, presetItems, EInvoiceWorkflowTypeItems.DISCOUNT_DEADLINE.getIdentity(), OcrResultValueType.TEXT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.DISCOUNT_DEADLINE.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, presetItems, EInvoiceWorkflowTypeItems.DISCOUNT_RATE.getIdentity(), OcrResultValueType.FLOAT);
    if (results != null) {
      words.put(EInvoiceWorkflowTypeItems.DISCOUNT_RATE.getIdentity(), results);
    }

    results = this
        .extractSearchItems(ocrResults, presetItems, EInvoiceWorkflowTypeItems.DISCOUNT_DATE.getIdentity(), OcrResultValueType.DATE);
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

  private Set<OcrResultWord> extractSearchItems(final OcrResults ocrResults,
      final Map<String, CompanyWorkflowtypeItemOcrSettingPresetItem> presetItems,
      final String propertyName, final OcrResultValueType valueType) {

    Set<OcrResultWord> results = null;
    if (presetItems.containsKey(propertyName)) {
      final CompanyWorkflowtypeItemOcrSettingPresetItem property = presetItems.get(propertyName);

      if (property.getOcrTypeEnum() == EOcrType.SEARCH_WORD) {

        final String[] searchWords = property.getValue().trim().split(";");
        results = ocrResults.findWords(searchWords, false, false, valueType);
        results = results.isEmpty() ? null : results;

      }

    }

    return results;
  }

  private void setWorkflowController(final W newWorkflow) {

    final List<CompanyWorkflowTypeController> workflowTypeControllers = this
        .getSessionUserInfo()
        .getControllerForWorkflowType(newWorkflow.getWorkflowTypeIdentity());

    if (workflowTypeControllers == null || workflowTypeControllers.isEmpty()) {
      throw new GuiCustomizedException("Invalid-Company-Setting:Workflow-Controller-Not-Found!");
    }

    newWorkflow.setControllerIdentity(workflowTypeControllers.get(0).getUserIdentity());
  }

  protected abstract W generateInitialWorkflow(String userIdentity);

  protected abstract WS generateInitialWorkflowSaveRequest(W workflow, int expireDays);

}

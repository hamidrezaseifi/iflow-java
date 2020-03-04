package com.pth.iflow.gui.controller.data;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
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

import com.pth.iflow.gui.controller.GuiSocketControllerBase;
import com.pth.iflow.gui.models.ui.GuiSocketMessage;
import com.pth.iflow.gui.models.ui.enums.ESocketCommands;
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

          result.setStatus("done");

          final OcrResults ocrResults = OcrResults.loadFromHocrText(hocrResult);

          result.setWords(new HashMap<String, Set<OcrResultWord>>());
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

  @MessageExceptionHandler
  public String handleException(final Throwable exception) {

    return exception.getMessage();
  }

}

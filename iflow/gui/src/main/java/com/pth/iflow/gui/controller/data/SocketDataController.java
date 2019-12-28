package com.pth.iflow.gui.controller.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pth.iflow.gui.controller.GuiSocketControllerBase;
import com.pth.iflow.gui.models.ui.GuiSocketMessage;
import com.pth.iflow.gui.models.ui.enums.ESocketCommands;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Controller
@RequestMapping(value = "/")
public class SocketDataController extends GuiSocketControllerBase {

  @Autowired
  SimpMessagingTemplate simpMessagingTemplate;

  @MessageMapping("/start")
  @SendTo("/socket/test")
  public GuiSocketMessage greeting(final GuiSocketMessage message) throws Exception {

    final String sentMessage = message.containsKey("sentMessage") ? message.get("sentMessage") : "not found!";

    final GuiSocketMessage result = GuiSocketMessage.generate("received");

    result.put("msg", sentMessage);

    Thread.sleep(100);
    return result;
  }

  @MessageMapping("/resetmessage")
  @SendToUser("/socket/messages")
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

}

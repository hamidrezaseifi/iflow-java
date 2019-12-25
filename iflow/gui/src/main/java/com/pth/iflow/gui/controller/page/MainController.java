package com.pth.iflow.gui.controller.page;

import java.io.File;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Controller
public class MainController {

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/", "/about", "/workflow/*", "/workflow/**" })
  public String index() {

    return "ang/index";
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/testfileUpload" })
  @ResponseBody
  public String testUploadFile(@RequestParam(value = "files") final MultipartFile[] files) throws IllegalStateException, IOException {

    if (files.length > 0) {
      final MultipartFile file   = files[0];
      final File          output = new File("e:/" + file.getOriginalFilename());

      file.transferTo(output);
    }

    return "ok";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/testocr" })
  @ResponseBody
  public String testOcr() throws IllegalStateException, IOException, TesseractException {

    final File      file      = new File("E:\\TestRechnung\\Unbenannt.png");
    final Tesseract tesseract = new Tesseract();
    tesseract.setDatapath("F://Softwares//Tess4J//tessdata");
    tesseract.setLanguage("deu");
    tesseract.setHocr(true);
    final String res = tesseract.doOCR(file);

    return res;
  }

}

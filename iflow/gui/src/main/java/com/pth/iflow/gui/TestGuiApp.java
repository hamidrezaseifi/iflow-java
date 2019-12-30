package com.pth.iflow.gui;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pth.iflow.gui.models.ui.ocr.OcrResults;

@SpringBootApplication
public class TestGuiApp {

  public static void main(final String[] args) throws IOException {

    final OcrResults results = OcrResults.loadFromHocrFile("E:/TestRechnung/2_ohne OCR.xml");

    System.out.println(results);
  }

}

package com.pth.iflow.gui.models;

public class UploadedFile {

  private String fileName;
  private String filePath;

  public UploadedFile() {

  }

  public UploadedFile(final String fileName, final String filePath) {

    this.fileName = fileName;
    this.filePath = filePath;
  }

  public String getFileName() {

    return this.fileName;
  }

  public void setFileName(final String fileName) {

    this.fileName = fileName;
  }

  public String getFilePath() {

    return this.filePath;
  }

  public void setFilePath(final String filePath) {

    this.filePath = filePath;
  }

}

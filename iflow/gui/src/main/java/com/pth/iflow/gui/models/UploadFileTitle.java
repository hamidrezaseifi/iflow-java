package com.pth.iflow.gui.models;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileTitle {

  private MultipartFile file;
  private String        title;

  /**
   * @return the file
   */
  public MultipartFile getFile() {
    return this.file;
  }

  /**
   * @param file the file to set
   */
  public void setFile(final MultipartFile file) {
    this.file = file;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(final String title) {
    this.title = title;
  }

}

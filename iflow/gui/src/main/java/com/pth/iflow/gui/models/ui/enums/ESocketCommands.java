package com.pth.iflow.gui.models.ui.enums;

public enum ESocketCommands {

  STATUS("status"),
  COMMAND("command"),
  ERROR_MESSAGE("errorMessage"),
  ERROR_DETAIL("errorDetail"),
  FILE_NAME("fileName"),
  FILE_HASH("fileHash"),
  HOCRFILE_HASH("hocrFileHash"),
  WORDS("words"),
  IS_FILE_IMAGE("isFileImage"),
  IS_FILE_PDF("isFilePdf"),
  PAGE_COUNT("pageCount"),
  IMAGE_WIDTH("imageWidth"),
  IMAGE_HEIGHT("imageHeight"),
  SELECTED_OCR_PRESET("selected_preset"),

  MESSAGE_RELOAD("message-reload");

  private final String value;

  ESocketCommands(final String value) {

    this.value = value;
  }

  public String getValue() {

    return this.value;
  }

}

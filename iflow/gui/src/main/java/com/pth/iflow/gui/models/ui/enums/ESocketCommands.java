package com.pth.iflow.gui.models.ui.enums;

public enum ESocketCommands {

  STATUS("status"),
  COMMAND("command"),
  ERROR_MESSAGE("errorMessage"),
  ERROR_DETAIL("errorDetail"),
  FILE_HASH("fileHash"),
  HOCRFILE_HASH("hocrFileHash"),
  WORDS("words"),
  MESSAGE_RELOAD("message-reload");

  private final String value;

  ESocketCommands(final String value) {

    this.value = value;
  }

  public String getValue() {

    return this.value;
  }

}

package com.pth.iflow.gui.models.ui;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.pth.iflow.common.response.IFlowErrorRestResponse;
import com.pth.iflow.gui.models.ui.enums.ESocketCommands;
import com.pth.iflow.gui.models.ui.ocr.OcrResultWord;

public class GuiSocketMessage extends HashMap<String, Object> {

  private static final long serialVersionUID = 3425395554514027407L;

  public GuiSocketMessage() {

  }

  public GuiSocketMessage(final int initialCapacity) {

    super(initialCapacity);
  }

  public GuiSocketMessage(final Map<? extends String, ? extends String> m) {

    super(m);

  }

  public GuiSocketMessage(final int initialCapacity, final float loadFactor) {

    super(initialCapacity,loadFactor);
  }

  public boolean hasFileHash() {

    return this.containsKey(ESocketCommands.FILE_HASH.getValue());
  }

  public String getFileNotHash() {

    final String encodedString = this.get(ESocketCommands.FILE_HASH.getValue()).toString();

    final String decodedString = GuiSocketMessage.decodeHashPath(encodedString);

    return decodedString;

  }

  public void setFileNotHash(final String filepath) {

    final String encodedString = Base64.getEncoder().encodeToString(filepath.getBytes());

    this.put(ESocketCommands.FILE_HASH.getValue(), encodedString);
  }

  public boolean hasHocrFileHash() {

    return this.containsKey(ESocketCommands.HOCRFILE_HASH.getValue());
  }

  public String getHocrFileNotHash() {

    final String encodedString = this.get(ESocketCommands.HOCRFILE_HASH.getValue()).toString();

    final String decodedString = GuiSocketMessage.decodeHashPath(encodedString);

    return decodedString;

  }

  public void setHocrFileNotHash(final String filepath) {

    final String encodedString = Base64.getEncoder().encodeToString(filepath.getBytes());

    this.put(ESocketCommands.HOCRFILE_HASH.getValue(), encodedString);
  }

  public boolean hasMessageReload() {

    return this.containsKey(ESocketCommands.MESSAGE_RELOAD.getValue());
  }

  public String getStatus() {

    return this.get(ESocketCommands.STATUS.getValue()).toString();
  }

  public void setStatus(final String status) {

    this.put(ESocketCommands.STATUS.getValue(), status);
  }

  public String getCommand() {

    return this.get(ESocketCommands.COMMAND.getValue()).toString();
  }

  public void setCommand(final String command) {

    this.put(ESocketCommands.COMMAND.getValue(), command);
  }

  public void setWords(final Map<String, Set<OcrResultWord>> words) {

    this.put(ESocketCommands.WORDS.getValue(), words);
  }

  public String getErrorMessage() {

    return this.get(ESocketCommands.ERROR_MESSAGE.getValue()).toString();
  }

  public void setErrorMessage(final String error) {

    this.put(ESocketCommands.ERROR_MESSAGE.getValue(), error);
  }

  public String getErrorDetail() {

    return this.get(ESocketCommands.ERROR_DETAIL.getValue()).toString();
  }

  public void setErrorDetail(final String error) {

    this.put(ESocketCommands.ERROR_DETAIL.getValue(), error);
  }

  public void setErrorDetail(final StackTraceElement[] stackTraces) {

    this.put(ESocketCommands.ERROR_DETAIL.getValue(), IFlowErrorRestResponse.stackListToString(stackTraces));
  }

  public static GuiSocketMessage generate(final String status) {

    final GuiSocketMessage message = new GuiSocketMessage();
    message.put(ESocketCommands.STATUS.getValue(), status);
    return message;
  }

  public static String decodeHashPath(final String encodedString) {

    final String decodedString = new String(Base64.getDecoder().decode(encodedString));

    return decodedString;
  }

  @Override
  public GuiSocketMessage clone() {

    final GuiSocketMessage message = new GuiSocketMessage();
    for (final String key : this.keySet()) {
      message.put(key, this.get(key));
    }

    return message;

  }

}

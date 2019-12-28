package com.pth.iflow.gui.models.ui;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.pth.iflow.gui.models.ui.enums.ESocketCommands;

public class GuiSocketMessage extends HashMap<String, String> {

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

    final String encodedString = this.get(ESocketCommands.FILE_HASH.getValue());

    final String decodedString = new String(Base64.getDecoder().decode(encodedString));

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

    final String encodedString = this.get(ESocketCommands.HOCRFILE_HASH.getValue());

    final String decodedString = new String(Base64.getDecoder().decode(encodedString));

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

    return this.get(ESocketCommands.STATUS.getValue());
  }

  public void setStatus(final String status) {

    this.put(ESocketCommands.STATUS.getValue(), status);
  }

  public String getCommand() {

    return this.get(ESocketCommands.COMMAND.getValue());
  }

  public void setCommand(final String command) {

    this.put(ESocketCommands.COMMAND.getValue(), command);
  }

  public static GuiSocketMessage generate(final String status) {

    final GuiSocketMessage message = new GuiSocketMessage();
    message.put(ESocketCommands.STATUS.getValue(), status);
    return message;
  }
}

package com.pth.iflow.gui.exceptions;

import javax.validation.ValidationException;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;

public class GuiSessionException extends ValidationException {

  private static final long     serialVersionUID = 1L;
  private final String          moduleName;
  private final EIFlowErrorType errorType;

  public GuiSessionException(final String message) {
    super(message);
    this.moduleName = EModule.GUI.getModuleName();
    this.errorType = EIFlowErrorType.GUI_INVALID_SESSION;
  }

  public String getModuleName() {
    return this.moduleName;
  }

  public EIFlowErrorType getErrorType() {
    return this.errorType;
  }

}

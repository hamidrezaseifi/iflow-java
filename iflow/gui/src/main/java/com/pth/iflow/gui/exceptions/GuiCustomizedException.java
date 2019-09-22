package com.pth.iflow.gui.exceptions;

import javax.validation.ValidationException;

import com.pth.iflow.common.exceptions.EIFlowErrorType;

public class GuiCustomizedException extends ValidationException {

  private static final long serialVersionUID = 1L;
  private final String      detailes;
  private final String      moduleName;
  private final Integer     errorType;

  public GuiCustomizedException(final String message, final String detailes, final String moduleName) {
    super(message);
    this.detailes = detailes;
    this.moduleName = moduleName;
    this.errorType = EIFlowErrorType.NONE.getValue();
  }

  public GuiCustomizedException(final String message, final String detailes, final String moduleName,
      final EIFlowErrorType errorType) {
    super(message);
    this.detailes = detailes;
    this.moduleName = moduleName;
    this.errorType = errorType.getValue();
  }

  public String getDetailes() {
    return this.detailes;
  }

  public String getModuleName() {
    return this.moduleName;
  }

  /**
   * @return the errorType
   */
  public Integer getErrorType() {
    return this.errorType;
  }

}

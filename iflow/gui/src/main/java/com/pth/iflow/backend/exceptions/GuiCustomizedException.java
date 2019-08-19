package com.pth.iflow.backend.exceptions;

import javax.validation.ValidationException;

import com.pth.iflow.common.exceptions.EIFlowErrorType;

public class GuiCustomizedException extends ValidationException {

  private static final long serialVersionUID = 1L;
  private final String detailes;
  private final String moduleName;
  private final Long errorType;

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
    return detailes;
  }

  public String getModuleName() {
    return moduleName;
  }

  /**
   * @return the errorType
   */
  public Long getErrorType() {
    return errorType;
  }

}

package com.pth.iflow.common.exceptions;

import javax.validation.ValidationException;

public class IFlowCustomeException extends ValidationException {

  private static final long serialVersionUID = 1L;
  private Integer           errorType;

  public IFlowCustomeException(final EIFlowErrorType errorType) {
    super();
    this.errorType = errorType.getValue();
  }

  public IFlowCustomeException(final String message, final EIFlowErrorType errorType) {
    super(message);
    this.errorType = errorType.getValue();
  }

  public IFlowCustomeException(final String message, final Exception causedby, final EIFlowErrorType errorType) {
    super(message, causedby);
    this.errorType = errorType.getValue();
  }

  public Integer getErrorType() {
    return this.errorType;
  }

  public void setErrorType(final Integer errorType) {
    this.errorType = errorType;
  }

}

package com.pth.iflow.common.exceptions;

import javax.validation.ValidationException;

public class IFlowCustomeException extends ValidationException {

  private static final long serialVersionUID = 1L;
  private Long errorType;

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

  public Long getErrorType() {
    return errorType;
  }

  public void setErrorType(final Long errorType) {
    this.errorType = errorType;
  }

}

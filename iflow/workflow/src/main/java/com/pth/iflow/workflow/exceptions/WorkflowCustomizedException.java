package com.pth.iflow.workflow.exceptions;

import javax.validation.ValidationException;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.response.IFlowErrorRestResponse;

public class WorkflowCustomizedException extends ValidationException {
  private static final long     serialVersionUID = 1L;
  private final String          detailes;
  private final String          moduleName;
  private final EIFlowErrorType errorType;

  public WorkflowCustomizedException(final String message, final EIFlowErrorType errorType) {
    super(message);
    this.detailes = "";
    this.moduleName = EModule.WORKFLOW.getModuleName();
    this.errorType = errorType;
  }

  public WorkflowCustomizedException(final String message, final String detailes, final String moduleName,
      final EIFlowErrorType errorType) {
    super(message);
    this.detailes = detailes;
    this.moduleName = moduleName;
    this.errorType = errorType;
  }

  public WorkflowCustomizedException(final String message, final Exception exception, final String moduleName,
      final EIFlowErrorType errorType) {
    super(message);
    this.detailes = IFlowErrorRestResponse.stackListToString(exception.getStackTrace());
    this.moduleName = moduleName;
    this.errorType = errorType;
  }

  public String getDetailes() {
    return detailes;
  }

  public String getModuleName() {
    return moduleName;
  }

  public EIFlowErrorType getErrorType() {
    return errorType;
  }

}

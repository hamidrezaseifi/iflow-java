package com.pth.ifow.workflow.exceptions;

import javax.validation.ValidationException;

public class WorkflowCustomizedException extends ValidationException {
  private static final long serialVersionUID = 1L;
  private final String detailes;
  private final String moduleName;

  public WorkflowCustomizedException(final String message, final String detailes, final String moduleName) {
    super(message);
    this.detailes = detailes;
    this.moduleName = moduleName;
  }

  public String getDetailes() {
    return detailes;
  }

  public String getModuleName() {
    return moduleName;
  }
}

package com.pth.iflow.common.response;

import org.springframework.http.HttpStatus;

import com.pth.iflow.common.exceptions.EIFlowErrorType;

public class IFlowErrorRestResponse {

  private final HttpStatus      status;
  private final EIFlowErrorType errorType;
  private final String          message;
  private final String          details;

  public IFlowErrorRestResponse() {
    this.status = HttpStatus.OK;
    this.errorType = EIFlowErrorType.NONE;
    this.message = "";
    this.details = "";

  }

  public IFlowErrorRestResponse(final HttpStatus status, final Exception ex, final EIFlowErrorType errorType) {
    this.status = status;
    this.errorType = errorType;
    this.message = ex.getMessage();
    this.details = stackListToString(ex.getStackTrace());

  }

  public HttpStatus getStatus() {
    return this.status;
  }

  public EIFlowErrorType getErrorType() {
    return this.errorType;
  }

  public boolean hasError() {
    return !this.errorType.equals(EIFlowErrorType.NONE);
  }

  public String getMessage() {
    return this.message;
  }

  public static String stackListToString(final StackTraceElement[] list) {
    String res = "";
    for (final StackTraceElement el : list) {
      res += el.toString() + "\n";
    }

    return res;
  }

  public String getDetails() {
    return this.details;
  }

  @Override
  public String toString() {
    return "ApiErrorResponse{" + "status=" + this.status + ", code=" + this.errorType + ", message=" + this.message + '}';
  }
}

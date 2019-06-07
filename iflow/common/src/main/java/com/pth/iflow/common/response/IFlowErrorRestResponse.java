package com.pth.iflow.common.response;

import org.springframework.http.HttpStatus;

public class IFlowErrorRestResponse {

  private final HttpStatus status;
  private final String errorType;
  private final String message;
  private final Long errorId;

  public static String NoError = "NoError";

  public IFlowErrorRestResponse() {
    this.status = HttpStatus.OK;
    this.errorType = NoError;
    this.message = "";
    this.errorId = 0L;

  }

  public IFlowErrorRestResponse(final HttpStatus status, final String errorType, final String message) {
    this.status = status;
    this.errorType = errorType;
    this.errorId = 0L;
    this.message = message;

  }

  public IFlowErrorRestResponse(final HttpStatus status, final String errorType, final String message,
      final Long errorId) {
    this.status = status;
    this.errorType = errorType;
    this.message = message;
    this.errorId = errorId;

  }

  public IFlowErrorRestResponse(final HttpStatus status, final Exception ex) {
    this.status = status;
    this.errorType = ex.getMessage();
    this.message = ex.getMessage(); // stackListToString(ex.getStackTrace());
    this.errorId = 0L;

  }

  public HttpStatus getStatus() {
    return status;
  }

  public String getErrorType() {
    return errorType;
  }

  public boolean hasError() {
    return !errorType.equals(NoError);
  }

  public String getMessage() {
    return message;
  }

  /**
   * @return the errorId
   */
  public Long getErrorId() {
    return errorId;
  }

  public static String stackListToString(final StackTraceElement[] list) {
    String res = "";
    for (final StackTraceElement el : list) {
      res += el.toString() + "\n";
    }

    return res;
  }

  @Override
  public String toString() {
    return "ApiErrorResponse{" + "status=" + status + ", code=" + errorType + ", message=" + message + '}';
  }
}

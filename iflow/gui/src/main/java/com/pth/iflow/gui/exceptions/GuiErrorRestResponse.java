package com.pth.iflow.gui.exceptions;

import org.springframework.http.HttpStatus;

import com.pth.iflow.common.response.IFlowErrorRestResponse;

public class GuiErrorRestResponse extends IFlowErrorRestResponse {

  public GuiErrorRestResponse() {
    // TODO Auto-generated constructor stub
  }

  public GuiErrorRestResponse(final HttpStatus status, final GuiCustomizedException ex) {
    super(status, ex, ex.getModuleName(), ex.getErrorType());

  }

  public GuiErrorRestResponse(final HttpStatus status, final String message, final GuiCustomizedException ex) {
    super(status, message, ex.getDetailes(), ex.getErrorType());

  }

}

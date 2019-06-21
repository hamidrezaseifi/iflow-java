package com.pth.ifow.workflow.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.response.IFlowErrorRestResponse;

@ControllerAdvice
public class IFlowWorkflowControllerExceptionHandler {

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  protected ResponseEntity<IFlowErrorRestResponse> handleConflict(final RuntimeException ex, final WebRequest request) {

    final HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", ControllerHelper.getMediaTypeFromRequest(request).toString());
    return new ResponseEntity<>(new IFlowErrorRestResponse(HttpStatus.CONFLICT, ex), headers, HttpStatus.CONFLICT);
  }
}

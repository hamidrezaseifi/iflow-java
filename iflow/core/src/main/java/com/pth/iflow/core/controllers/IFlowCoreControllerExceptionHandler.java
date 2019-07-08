package com.pth.iflow.core.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.response.IFlowErrorRestResponse;

@ControllerAdvice
public class IFlowCoreControllerExceptionHandler {
  
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  protected ResponseEntity<IFlowErrorRestResponse> handleConflict(final Exception ex, final HttpServletRequest request) {
    // return new FBRestResponse(HttpStatus.CONFLICT, ex);
    final HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", MediaType.APPLICATION_XML_VALUE + ";charset=UTF-8");
    return new ResponseEntity<>(new IFlowErrorRestResponse(HttpStatus.CONFLICT, ex), headers, HttpStatus.CONFLICT);
  }
}

package com.pth.ifow.profile.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.pth.iflow.common.response.IFlowErrorRestResponse;
import com.pth.ifow.profile.exceptions.ProfileCustomizedException;

@ControllerAdvice
public class IFlowProfileControllerExceptionHandler {

  @ExceptionHandler(ProfileCustomizedException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  protected ResponseEntity<IFlowErrorRestResponse> handleProfileCustomizedException(final ProfileCustomizedException ex,
      final WebRequest request) {
    // return new FBRestResponse(HttpStatus.CONFLICT, ex);
    final HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
    return new ResponseEntity<>(new IFlowErrorRestResponse(HttpStatus.CONFLICT, "", ex.getMessage(), ex.getErrorType()),
        headers, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  protected ResponseEntity<IFlowErrorRestResponse> handleConflict(final RuntimeException ex, final WebRequest request) {
    // return new FBRestResponse(HttpStatus.CONFLICT, ex);
    final HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", MediaType.APPLICATION_XML_VALUE + ";charset=UTF-8");
    return new ResponseEntity<>(new IFlowErrorRestResponse(HttpStatus.CONFLICT, ex), headers, HttpStatus.CONFLICT);
  }
}

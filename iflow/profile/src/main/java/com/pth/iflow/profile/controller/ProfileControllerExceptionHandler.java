package com.pth.iflow.profile.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.response.IFlowErrorRestResponse;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;

@ControllerAdvice
public class ProfileControllerExceptionHandler {

  @ExceptionHandler(ProfileCustomizedException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  protected ResponseEntity<IFlowErrorRestResponse> handleProfileCustomizedException(final ProfileCustomizedException ex,
      final HttpServletRequest request) {

    final IFlowErrorRestResponse errorResponse = new IFlowErrorRestResponse(HttpStatus.CONFLICT, ex, ex.getModuleName(),
        ex.getErrorType());

    return ControllerHelper.createErrorResponseEntity(request, errorResponse, HttpStatus.CONFLICT);

  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  protected ResponseEntity<IFlowErrorRestResponse> handleConflict(final RuntimeException ex, final HttpServletRequest request) {

    final IFlowErrorRestResponse errorResponse = new IFlowErrorRestResponse(HttpStatus.CONFLICT, ex, EModule.PROFILE.getModuleName(),
        EIFlowErrorType.RUNTIME_UNKNOWN);
    return ControllerHelper.createErrorResponseEntity(request, errorResponse, HttpStatus.CONFLICT);

  }
}

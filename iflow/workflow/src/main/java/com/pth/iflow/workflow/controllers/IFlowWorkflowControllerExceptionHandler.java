package com.pth.iflow.workflow.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.response.IFlowErrorRestResponse;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;

@ControllerAdvice
public class IFlowWorkflowControllerExceptionHandler {

  @ExceptionHandler(WorkflowCustomizedException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  protected ResponseEntity<IFlowErrorRestResponse> handleConflict(final WorkflowCustomizedException ex,
      final HttpServletRequest request) {

    final IFlowErrorRestResponse errorResponse = new IFlowErrorRestResponse(HttpStatus.CONFLICT, ex, ex.getErrorType());

    return ControllerHelper.createErrorResponseEntity(request, errorResponse, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  protected ResponseEntity<IFlowErrorRestResponse> handleConflict(final RuntimeException ex, final HttpServletRequest request) {

    final IFlowErrorRestResponse errorResponse = new IFlowErrorRestResponse(HttpStatus.CONFLICT, ex, EIFlowErrorType.RUNTIME_UNKNOWN);

    return ControllerHelper.createErrorResponseEntity(request, errorResponse, HttpStatus.CONFLICT);
  }
}

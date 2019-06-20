package com.pth.iflow.core.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

public class ControllerHelper {
  
  private static final String PRODUCES_PARAM_KEY        = "produces";
  private static final String PRODUCES_PARAM_VALUE_JSON = "json";
  
  public static <T> ResponseEntity<T> createResponseEntity(final HttpServletRequest request, @Nullable final T model, final HttpStatus status) {
    
    final HttpHeaders header = new HttpHeaders();
    header.setContentType(MediaType.APPLICATION_XML);
    
    if (request.getParameterMap().keySet().contains(PRODUCES_PARAM_KEY)
        && request.getParameter(PRODUCES_PARAM_KEY).toLowerCase().equals(PRODUCES_PARAM_VALUE_JSON)) {
      header.setContentType(MediaType.APPLICATION_JSON_UTF8);
    }
    
    return new ResponseEntity<>(model, header, status);
  }
}

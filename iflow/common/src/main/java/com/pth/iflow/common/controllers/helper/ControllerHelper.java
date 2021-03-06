package com.pth.iflow.common.controllers.helper;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.context.request.WebRequest;

import com.pth.iflow.common.response.IFlowErrorRestResponse;

public class ControllerHelper {
  
  private static final String  PRODUCES_PARAM_KEY        = "produces";
  private static final String  PRODUCES_PARAM_VALUE_JSON = "json";
  private static final boolean ALLOW_GENERATE_JSON_MODEL       = false;
  
  public static <T> ResponseEntity<T> createResponseEntity(final HttpServletRequest request, @Nullable final T model,
      final HttpStatus status) {
    
    final HttpHeaders header = new HttpHeaders();
    header.setContentType(getMediaTypeFromRequest(request));
    
    return new ResponseEntity<>(model, header, status);
  }
  
  public static ResponseEntity<IFlowErrorRestResponse> createErrorResponseEntity(final HttpServletRequest request,
      @Nullable final IFlowErrorRestResponse model,
      final HttpStatus status) {
    
    final HttpHeaders header = new HttpHeaders();
    header.setContentType(getMediaTypeFromRequest(request));
    
    return new ResponseEntity<>(model, header, status);
  }
  
  public static MediaType getMediaTypeFromRequest(final HttpServletRequest request) {
    
    MediaType m = MediaType.APPLICATION_XML;

    /*
     * currently we generate just xml and no json because of conflict between xml & json model
     */

    if (isJsonRequest(request)) {
      m = MediaType.APPLICATION_JSON_UTF8;
    }
    
    return m;
  }
  
  public static MediaType getMediaTypeFromRequest(final WebRequest request) {
    
    MediaType m = MediaType.APPLICATION_XML;
    if (isJsonRequest(request)) {
      m = MediaType.APPLICATION_JSON_UTF8;
    }
    
    return m;
  }
  
  public static boolean isJsonRequest(final HttpServletRequest request) {
    return request.getParameterMap().keySet().contains(PRODUCES_PARAM_KEY)
        && request.getParameter(PRODUCES_PARAM_KEY).toLowerCase().equals(PRODUCES_PARAM_VALUE_JSON) && ALLOW_GENERATE_JSON_MODEL;
  }
  
  public static boolean isJsonRequest(final WebRequest request) {
    return request.getParameterMap().keySet().contains(PRODUCES_PARAM_KEY)
        && request.getParameter(PRODUCES_PARAM_KEY).toLowerCase().equals(PRODUCES_PARAM_VALUE_JSON);
  }
  
  public static String addJsonQueryString(final String url) {
    String res = url;
    res += url.contains("?") ? "&" : "?";
    res += PRODUCES_PARAM_KEY + "=" + PRODUCES_PARAM_VALUE_JSON;
    
    return res;
  }
  
}

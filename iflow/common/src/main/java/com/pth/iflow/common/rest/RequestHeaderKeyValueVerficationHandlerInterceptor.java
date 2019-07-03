package com.pth.iflow.common.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pth.iflow.common.controllers.helper.ControllerHelper;

public class RequestHeaderKeyValueVerficationHandlerInterceptor extends HandlerInterceptorAdapter {
  private final Logger log = LoggerFactory.getLogger(getClass());

  private final String invalidValueUrl;

  private final String headerKey;

  private final String headerValue;

  public RequestHeaderKeyValueVerficationHandlerInterceptor(final String invalidValueUrl, final String headerKey,
      final String headerValue) {
    this.invalidValueUrl = invalidValueUrl;
    this.headerKey = headerKey;
    this.headerValue = headerValue;
  }

  @Override
  public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
      throws Exception {

    verifayTokenIdInHeader(request, response, handler);

    return super.preHandle(request, response, handler);
  }

  private void verifayTokenIdInHeader(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
      throws IOException {
    final String value = request.getHeader(headerKey);
    if (StringUtils.isEmpty(value) || headerValue.equals(value) == false) {
      log.error("Invalid value for {} in request header.", headerKey);
      final String url = ControllerHelper.isJsonRequest(request) ? ControllerHelper.addJsonQueryString(invalidValueUrl)
          : invalidValueUrl;
      response.sendRedirect(url);
    }
  }

}

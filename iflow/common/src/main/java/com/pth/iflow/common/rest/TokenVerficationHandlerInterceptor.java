package com.pth.iflow.common.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pth.iflow.common.controllers.helper.ControllerHelper;

public class TokenVerficationHandlerInterceptor extends HandlerInterceptorAdapter {
  private final Logger log = LoggerFactory.getLogger(getClass());

  public static final String IFLOW_TOKENID_HEADER_KEY = "iftkid";

  private final String invalidTokenUrl;

  public TokenVerficationHandlerInterceptor(final String invalidTokenUrl) {
    this.invalidTokenUrl = invalidTokenUrl;
  }

  @Override
  public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
      throws Exception {

    verifayTokenIdInHeader(request, response, handler);

    return super.preHandle(request, response, handler);
  }

  private void verifayTokenIdInHeader(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
      throws IOException {
    final String tokenid = request.getHeader(IFLOW_TOKENID_HEADER_KEY);
    if (StringUtils.isEmpty(tokenid)) {
      log.error("Invalid token in request header.");
      final String url = ControllerHelper.isJsonRequest(request) ? ControllerHelper.addJsonQueryString(invalidTokenUrl) : invalidTokenUrl;
      response.sendRedirect(url);
    }
  }

}

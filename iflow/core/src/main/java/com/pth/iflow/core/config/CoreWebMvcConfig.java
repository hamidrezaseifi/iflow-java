package com.pth.iflow.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pth.iflow.common.rest.RequestHeaderKeyValueVerficationHandlerInterceptor;

@Configuration
public class CoreWebMvcConfig implements WebMvcConfigurer {

  private static final String HEADER_VALUE_INNER_MODULE = "inner-module";
  private static final String HEADER_KEY_INNER_MODULE = "iflow-inner-module";
  RequestHeaderKeyValueVerficationHandlerInterceptor verficationHandlerInterceptor;

  @Override
  public void addInterceptors(final InterceptorRegistry registry) {

    verficationHandlerInterceptor = new RequestHeaderKeyValueVerficationHandlerInterceptor(CoreConfiguration.INVALID_TOKEN_URL,
        HEADER_KEY_INNER_MODULE, HEADER_VALUE_INNER_MODULE);

    registry.addInterceptor(verficationHandlerInterceptor).excludePathPatterns(CoreConfiguration.NOAUTHENTICATED_URL_LIST);

  }
}

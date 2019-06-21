package com.pth.ifow.workflow.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  TokenVerficationHandlerInterceptor authenticationVerficationHandler;

  @Override
  public void addInterceptors(final InterceptorRegistry registry) {

    authenticationVerficationHandler = new TokenVerficationHandlerInterceptor(WorkflowConfiguration.INVALID_TOKEN_URL);

    registry.addInterceptor(authenticationVerficationHandler).excludePathPatterns(WorkflowConfiguration.NOAUTHENTICATED_URL_LIST);

  }
}

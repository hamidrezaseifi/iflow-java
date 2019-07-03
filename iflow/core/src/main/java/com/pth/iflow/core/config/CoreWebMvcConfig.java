package com.pth.iflow.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pth.iflow.common.rest.RequestHeaderKeyValueVerficationHandlerInterceptor;
import com.pth.iflow.common.rest.XmlRestConfig;

@Configuration
public class CoreWebMvcConfig implements WebMvcConfigurer {

  @Value("${iflow.common.rest.api.security.client-id.internal:iflow-inner-module}")
  private String innerModulesRequestHeaderValue;
  
  RequestHeaderKeyValueVerficationHandlerInterceptor verficationHandlerInterceptor;

  @Override
  public void addInterceptors(final InterceptorRegistry registry) {

    this.verficationHandlerInterceptor = new RequestHeaderKeyValueVerficationHandlerInterceptor(CoreConfiguration.INVALID_TOKEN_URL,
        XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue);

    registry.addInterceptor(this.verficationHandlerInterceptor).excludePathPatterns(CoreConfiguration.NOAUTHENTICATED_URL_LIST);

  }
}

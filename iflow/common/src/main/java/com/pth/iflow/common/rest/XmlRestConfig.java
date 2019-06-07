package com.pth.iflow.common.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

/**
 * contains configs for XML Rest-Controller
 */
@Configuration
public class XmlRestConfig {

  private final Logger log = LoggerFactory.getLogger(getClass());

  /**
   * needed so that jackson understands the JAXB Annotations.
   *
   * @return the module
   */
  @Bean
  public Module enableJaxbForJackson() {
    log.info("JAXB Annotations enabled");
    final JaxbAnnotationModule jaxbAnnotationModule = new JaxbAnnotationModule();
    return jaxbAnnotationModule;
  }

  @Bean
  public CommonsRequestLoggingFilter logFilter() {
    final CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
    filter.setIncludeQueryString(true);
    filter.setIncludePayload(true);
    filter.setMaxPayloadLength(10 * 1000);
    filter.setIncludeHeaders(false);
    filter.setAfterMessagePrefix("REQUEST DATA: ");
    return filter;
  }

  /**
   * threadsafe once created
   *
   * @see https://spring.io/blog/2009/03/27/rest-in-spring-3-resttemplate
   *
   * @lazy i marked this lazy b/c ResTemplate is not needed for all unit tests but
   *       this config is; in fact those unit test often dont have the dependant
   *       {@link MappingJackson2XmlHttpMessageConverter} in its spring context
   *       causing the context startup to fail.
   */
  @Lazy
  @Bean
  public RestTemplate jaxbRestTemplate(final MappingJackson2XmlHttpMessageConverter converter) {
    /*
     * BETTER: there is likely a more spring way of configuring the rest template to
     * use the JAXB stuff...| TM @ 21.07.2018
     */
    final RestTemplate restTemplate = new RestTemplate();
    final List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
    for (int i = 0; i < messageConverters.size(); i++) {
      /*
       * if (messageConverters.get(i).canRead(CustomerEdo.class,
       * MediaType.APPLICATION_XML)) { messageConverters.set(i, converter); }
       */
    }

    return restTemplate;
  }

}

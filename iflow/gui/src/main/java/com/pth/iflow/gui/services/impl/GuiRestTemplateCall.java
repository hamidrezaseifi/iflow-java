package com.pth.iflow.gui.services.impl;

import java.io.IOException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.response.IFlowErrorRestResponse;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.services.IGuiRestTemplateCall;

@Component
public class GuiRestTemplateCall implements IGuiRestTemplateCall {

  protected final Logger                         log = LoggerFactory.getLogger(GuiRestTemplateCall.class);

  @Autowired
  private RestTemplate                           restTemplate;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter converter;

  @PostConstruct
  public void init() {

  }

  @Override
  public <I, O> O callRestPost(final URL url, final String token, final EModule service, final I edo, final Class<O> responseClass,
      final boolean throwError) throws GuiCustomizedException {

    final HttpEntity<I> request = new HttpEntity<>(edo, this.generateTokenHeader(token));

    try {
      if (responseClass.equals(Void.class)) {

        this.restTemplate.postForEntity(url.toURI(), request, responseClass);

        return null;
      } else {
        final ResponseEntity<O> responseEntity = this.restTemplate.postForEntity(url.toURI(), request, responseClass);

        return responseEntity.getBody();
      }
    } catch (final RestClientResponseException e) {
      final String resp = e.getResponseBodyAsString();
      this.log.error("ERROR in connection with \"{}\" through url \"{}\" and response is {} ", service.getModuleName(), url, resp, e);

      if (!throwError) {
        return null;
      }

      IFlowErrorRestResponse response = null;
      try {
        response = this.converter.getObjectMapper().readValue(resp, IFlowErrorRestResponse.class);
      } catch (final IOException e1) {
        final GuiCustomizedException uiCustomizedException = new GuiCustomizedException("failed to POST: " + url, e1.getMessage(),
            service.name(), e.getStackTrace());
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }

      throw new GuiCustomizedException(response.getMessage(), response.getErrorType(), service.getModuleName(), e.getStackTrace());
    } catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), url, e);

      if (!throwError) {
        return null;
      }
      throw new GuiCustomizedException("Service " + service.getModuleName() + " is not availeable.", "", EModule.GUI.getModuleName(),
          e.getStackTrace());
    } catch (final Exception e) {

      throw new GuiCustomizedException(e.getMessage(), "", service.getModuleName(), e.getStackTrace());
    }
  }

  private MultiValueMap<String, String> generateTokenHeader(final String token) {
    final MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    headers.add(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, token);
    headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE);
    return headers;
  }

  @Override
  public <O> O callRestGet(final URL url, final String token, final EModule service, final Class<O> responseClass,
      final boolean throwError, final Object... args) throws GuiCustomizedException {

    try {
      final HttpEntity<Object> requestEntity = new HttpEntity<>(this.generateTokenHeader(token));
      final ResponseEntity<O> resp = this.restTemplate.exchange(url.toString(), HttpMethod.GET, requestEntity, responseClass, args);
      return resp.getBody();

    } catch (final RestClientResponseException e) {
      final String resp = e.getResponseBodyAsString();
      this.log.error("ERROR in connection with \"{}\" through url \"{}\" and response is {} ", service.getModuleName(), url, resp, e);

      if (!throwError) {
        return null;
      }

      IFlowErrorRestResponse response = null;
      try {
        response = this.converter.getObjectMapper().readValue(resp, IFlowErrorRestResponse.class);
      } catch (final IOException e1) {
        final GuiCustomizedException uiCustomizedException = new GuiCustomizedException("failed to POST: " + url, e1.getMessage(),
            service.name(), e.getStackTrace());
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }

      throw new GuiCustomizedException(response.getMessage(), response.getErrorType(), service.getModuleName(), e.getStackTrace());
    } catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), url, e);

      if (!throwError) {
        return null;
      }
      throw new GuiCustomizedException("Service " + service.getModuleName() + " is not availeable.", "", EModule.GUI.getModuleName(),
          e.getStackTrace());
    } catch (final Exception e) {

      throw new GuiCustomizedException(e.getMessage(), "", service.getModuleName(), e.getStackTrace());
    }

  }

}

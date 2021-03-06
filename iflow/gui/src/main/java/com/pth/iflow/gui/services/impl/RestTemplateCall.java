package com.pth.iflow.gui.services.impl;

import java.io.IOException;
import java.net.URI;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.response.IFlowErrorRestResponse;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.services.IRestTemplateCall;

@Service
public class RestTemplateCall implements IRestTemplateCall {

  protected final Logger                         log = LoggerFactory.getLogger(RestTemplateCall.class);

  @Autowired
  private RestTemplate                           restTemplate;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter converter;

  @PostConstruct
  public void init() {

  }

  @Override
  public <I, O> O callRestPost(final URI uri, final EModule service, final I edo, final Class<O> responseClass, final String token,
      final boolean throwError) throws GuiCustomizedException {

    final HttpEntity<I> request = this.prepareRequest(edo, token);

    try {
      if (responseClass.equals(Void.class)) {

        this.restTemplate.postForEntity(uri, request, responseClass);

        return null;
      } else {
        final ResponseEntity<O> responseEntity = this.restTemplate.postForEntity(uri, request, responseClass);

        return responseEntity.getBody();
      }
    } catch (final RestClientResponseException e) {
      final String resp = e.getResponseBodyAsString();
      this.log.error("ERROR in connection with \"{}\" through url \"{}\" and response is {} ", service.getModuleName(), uri, resp, e);

      if (!throwError) {
        return null;
      }

      IFlowErrorRestResponse response = null;
      try {
        response = this.converter.getObjectMapper().readValue(resp, IFlowErrorRestResponse.class);
      } catch (final IOException e1) {
        final GuiCustomizedException uiCustomizedException = new GuiCustomizedException(
            "failed to POST: " + uri + "(" + e1.getMessage() + ")", e1.getStackTrace());
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }

      throw new GuiCustomizedException(response.getMessage(), response.getModuleName(), response.getErrorType(), e.getStackTrace());
    } catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), uri, e);

      if (!throwError) {
        return null;
      }
      throw new GuiCustomizedException("Service " + service.getModuleName() + " is not availeable.", service.getModuleName(),
          EIFlowErrorType.SERVICE_NOT_FOUND);
    } catch (final Exception e) {

      throw new GuiCustomizedException(e.getMessage(), e.getStackTrace());
    }
  }

  @Override
  public <O> O callRestGet(final URI uri, final EModule service, final Class<O> responseClass, final String token,
      final boolean throwError) throws GuiCustomizedException {

    try {
      final HttpEntity<Object> requestEntity = this.prepareEntity(token);
      final ResponseEntity<O> resp = this.restTemplate.exchange(uri, HttpMethod.GET, requestEntity, responseClass);
      return resp.getBody();

    } catch (final RestClientResponseException e) {
      final String resp = e.getResponseBodyAsString();
      this.log.error("ERROR in connection with \"{}\" through url \"{}\" and response is {} ", service.getModuleName(), uri, resp, e);

      if (!throwError) {
        return null;
      }

      IFlowErrorRestResponse response = null;
      try {
        response = this.converter.getObjectMapper().readValue(resp, IFlowErrorRestResponse.class);
      } catch (final IOException e1) {
        final GuiCustomizedException uiCustomizedException = new GuiCustomizedException(
            "failed to Get: " + uri + "(" + e1.getMessage() + ")", service.getModuleName(), EIFlowErrorType.SERVICE_NOT_FOUND,
            e1.getStackTrace());
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }

      throw new GuiCustomizedException(response.getMessage(), response.getModuleName(), response.getErrorType(), e.getStackTrace());
    } catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), uri, e);

      if (!throwError) {
        return null;
      }
      throw new GuiCustomizedException("Service " + service.getModuleName() + " is not availeable.", service.getModuleName(),
          EIFlowErrorType.SERVICE_NOT_FOUND);
    } catch (final Exception e) {

      throw new GuiCustomizedException(e.getMessage(), e.getStackTrace());
    }

  }

  private MultiValueMap<String, String> generateTokenHeader(final String token) {
    final MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    if (StringUtils.isNoneEmpty(token)) {
      headers.add(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, token);
    }
    headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE);
    return headers;
  }

  private HttpEntity<Object> prepareEntity(final String token) {
    final HttpEntity<Object> requestEntity = new HttpEntity<>(this.generateTokenHeader(token));
    return requestEntity;
  }

  private <I> HttpEntity<I> prepareRequest(final I edo, final String token) {
    final HttpEntity<I> request = new HttpEntity<>(edo, this.generateTokenHeader(token));
    return request;
  }

}

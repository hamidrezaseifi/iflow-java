package com.pth.iflow.backend.services.impl;

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

import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.backend.services.IRestTemplateCall;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.response.IFlowErrorRestResponse;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;

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
      final boolean throwError) throws BackendCustomizedException {

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
        final BackendCustomizedException uiCustomizedException = new BackendCustomizedException("failed to POST: " + uri,
            e1.getMessage(), service.name());
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }

      throw new BackendCustomizedException(response.getMessage(), response.getDetails(), service.getModuleName(),
          response.getErrorType());
    } catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), uri, e);

      if (!throwError) {
        return null;
      }
      throw new BackendCustomizedException("Service " + service.getModuleName() + " is not availeable.", "",
          EModule.GUI.getModuleName());
    } catch (final Exception e) {

      throw new BackendCustomizedException(e.getMessage(), "", service.getModuleName());
    }
  }

  @Override
  public <O> O callRestGet(final URI uri, final EModule service, final Class<O> responseClass, final String token,
      final boolean throwError) throws BackendCustomizedException {

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
        final BackendCustomizedException uiCustomizedException = new BackendCustomizedException("failed to POST: " + uri,
            e1.getMessage(), service.name());
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }

      throw new BackendCustomizedException(response.getMessage(), response.getDetails(), service.getModuleName(),
          response.getErrorType());
    } catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), uri, e);

      if (!throwError) {
        return null;
      }
      throw new BackendCustomizedException("Service " + service.getModuleName() + " is not availeable.", "",
          EModule.GUI.getModuleName());
    } catch (final Exception e) {

      throw new BackendCustomizedException(e.getMessage(), "", service.getModuleName());
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

package com.pth.iflow.workflow.services.impl;

import java.io.IOException;
import java.net.URI;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.response.IFlowErrorRestResponse;
import com.pth.iflow.common.rest.IRestTemplateCall;
import com.pth.iflow.common.rest.RestTemplateException;
import com.pth.iflow.common.rest.RestTemplateHelper;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;

@Service
public class RestTemplateCall extends RestTemplateHelper implements IRestTemplateCall {

  protected final Logger log = LoggerFactory.getLogger(RestTemplateCall.class);

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter converter;

  @PostConstruct
  public void init() {

  }

  @Override
  public <I, O> O callRestPost(final URI uri, final EModule service, final I edo, final Class<O> responseClass,
      final String token,
      final boolean throwError) throws RestTemplateException {

    final HttpEntity<I> request = new HttpEntity<I>(edo, generateTokenHeader(token));

    try {
      if (responseClass.equals(Void.class)) {

        this.restTemplate.postForEntity(uri, request, responseClass);

        return null;
      }
      else {
        final ResponseEntity<O> responseEntity = this.restTemplate.postForEntity(uri, request, responseClass);

        return responseEntity.getBody();
      }
    }
    catch (final RestClientResponseException e) {
      final String resp = e.getResponseBodyAsString();
      this.log.error("ERROR in connection with \"{}\" through url \"{}\" and response is {} ", service.getModuleName(), uri, resp, e);

      if (!throwError) {
        return null;
      }

      IFlowErrorRestResponse response = null;
      try {
        response = this.converter.getObjectMapper().readValue(resp, IFlowErrorRestResponse.class);
      }
      catch (final IOException e1) {
        final WorkflowCustomizedException uiCustomizedException = new WorkflowCustomizedException("failed to POST: " + uri, e1,
            service.name(), EIFlowErrorType.SERVICE_NOT_FOUND);
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }

      throw new WorkflowCustomizedException(response.getMessage(), response.getDetails(), service.getModuleName(),
          response.getErrorType());
    }
    catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), uri, e);

      if (!throwError) {
        return null;
      }
      throw new WorkflowCustomizedException("Service " + service.getModuleName() + " is not availeable.", e, service.getModuleName(),
          EIFlowErrorType.SERVICE_NOT_FOUND);
    }
  }

  @Override
  public <O> O callRestGet(final URI uri, final EModule service, final Class<O> responseClass, final String token,
      final boolean throwError)
      throws RestTemplateException {

    try {
      final HttpEntity<Object> requestEntity = new HttpEntity<Object>(generateTokenHeader(token));

      final ResponseEntity<O> response = this.restTemplate.exchange(uri, HttpMethod.GET, requestEntity, responseClass);
      return response.getBody();

    }
    catch (final RestClientResponseException e) {
      final String resp = e.getResponseBodyAsString();
      this.log.error("ERROR in connection with \"{}\" through url \"{}\" and response is {} ", service.getModuleName(), uri, resp, e);

      if (!throwError) {
        return null;
      }

      IFlowErrorRestResponse response = null;
      try {
        response = this.converter.getObjectMapper().readValue(resp, IFlowErrorRestResponse.class);
      }
      catch (final IOException e1) {
        final WorkflowCustomizedException uiCustomizedException = new WorkflowCustomizedException("failed to POST: " + uri, e1,
            service.name(), EIFlowErrorType.SERVICE_NOT_FOUND);
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }

      throw new WorkflowCustomizedException(response.getMessage(), response.getDetails(), service.getModuleName(),
          response.getErrorType());
    }
    catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), uri, e);

      if (!throwError) {
        return null;
      }
      throw new WorkflowCustomizedException("Service " + service.getModuleName() + " is not availeable.", e, service.getModuleName(),
          EIFlowErrorType.SERVICE_NOT_FOUND);
    }

  }

}

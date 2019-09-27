package com.pth.iflow.workflow.services.impl;

import java.io.IOException;
import java.net.URI;

import javax.annotation.PostConstruct;

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
import com.pth.iflow.common.response.IFlowErrorRestResponse;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.services.IRestTemplateCall;

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
  public <I, O> O callRestPost(final URI url, final String token, final EModule service, final I edo, final Class<O> responseClass,
      final boolean throwError) throws WorkflowCustomizedException {

    final HttpEntity<I> request = new HttpEntity<I>(edo, generateTokenHeader(token));

    try {
      if (responseClass.equals(Void.class)) {

        this.restTemplate.postForEntity(url, request, responseClass);

        return null;
      } else {
        final ResponseEntity<O> responseEntity = this.restTemplate.postForEntity(url, request, responseClass);

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
        final WorkflowCustomizedException uiCustomizedException = new WorkflowCustomizedException("failed to POST: " + url,
            e1.getMessage(), service.name());
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }

      throw new WorkflowCustomizedException(response.getMessage(), response.getErrorType(), service.getModuleName());
    } catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), url, e);

      if (!throwError) {
        return null;
      }
      throw new WorkflowCustomizedException("Service " + service.getModuleName() + " is not availeable.", "",
          EModule.GUI.getModuleName());
    } catch (final Exception e) {

      throw new WorkflowCustomizedException(e.getMessage(), "", service.getModuleName());
    }
  }

  private MultiValueMap<String, String> generateTokenHeader(final String token) {
    final MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
    headers.add(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, token);
    headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE);
    return headers;
  }

  @Override
  public <O> O callRestGet(final URI url, final String token, final EModule service, final Class<O> responseClass,
      final boolean throwError, final Object... args) throws WorkflowCustomizedException {

    try {
      final HttpEntity<Object> requestEntity = new HttpEntity<Object>(generateTokenHeader(token));
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
        final WorkflowCustomizedException uiCustomizedException = new WorkflowCustomizedException("failed to POST: " + url,
            e1.getMessage(), service.name());
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }

      throw new WorkflowCustomizedException(response.getMessage(), response.getErrorType(), service.getModuleName());
    } catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), url, e);

      if (!throwError) {
        return null;
      }
      throw new WorkflowCustomizedException("Service " + service.getModuleName() + " is not availeable.", "",
          EModule.GUI.getModuleName());
    } catch (final Exception e) {

      throw new WorkflowCustomizedException(e.getMessage(), "", service.getModuleName());
    }

  }

}

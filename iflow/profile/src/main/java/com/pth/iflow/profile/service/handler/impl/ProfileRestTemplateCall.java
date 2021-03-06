package com.pth.iflow.profile.service.handler.impl;

import java.io.IOException;
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.response.IFlowErrorRestResponse;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.service.handler.IProfileRestTemplateCall;

@Component
public class ProfileRestTemplateCall implements IProfileRestTemplateCall {

  protected final Logger log = LoggerFactory.getLogger(ProfileRestTemplateCall.class);

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter converter;

  @Override
  public <I, O> O callRestPost(final URI uri, final EModule service, final I edo, final Class<O> responseClass,
      final boolean throwError) throws ProfileCustomizedException {

    try {

      if (responseClass.equals(Void.class)) {
        this.restTemplate.postForObject(uri, edo, responseClass);
        return null;
      }
      else {
        return this.restTemplate.postForObject(uri, edo, responseClass);
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
        final ProfileCustomizedException uiCustomizedException = new ProfileCustomizedException("failed to POST: " + uri,
            e1.getMessage(), service.name());
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }

      throw new ProfileCustomizedException(response.getMessage(), "", service.getModuleName(), response.getErrorType());
    }
    catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), uri, e);

      if (!throwError) {
        return null;
      }
      throw new ProfileCustomizedException("Service " + service.getModuleName() + " is not availeable.", "",
          EModule.GUI.getModuleName());
    }

  }

  @Override
  public <O> O callRestGet(final URI uri, final EModule service, final Class<O> responseClass, final boolean throwError)
      throws ProfileCustomizedException {

    try {

      if (responseClass.equals(Void.class)) {
        this.restTemplate.getForEntity(uri, responseClass);
        return null;
      }
      else {
        final ResponseEntity<O> response = this.restTemplate.getForEntity(uri, responseClass);
        return response.getBody();
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
        final ProfileCustomizedException uiCustomizedException = new ProfileCustomizedException("failed to POST: " + uri,
            e1.getMessage(), service.name());
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }

      throw new ProfileCustomizedException(response.getMessage(), response.getDetails(), service.getModuleName(),
          response.getErrorType());
    }
    catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), uri, e);

      if (!throwError) {
        return null;
      }
      throw new ProfileCustomizedException("Service " + service.getModuleName() + " is not availeable.", "", service.getModuleName(),
          EIFlowErrorType.SERVICE_NOT_FOUND);
    }
    catch (final Exception e) {
      if (!throwError) {
        return null;
      }

      throw new ProfileCustomizedException(this.generateServiceErrorMessage(uri.toString(), service),
          IFlowErrorRestResponse.stackListToString(e.getStackTrace()), EModule.PROFILE.getModuleName());
    }

  }

  @Override
  public <I, O> O callRestPost(final URI url, final EModule service, final I edo, final ParameterizedTypeReference<O> responseType,
      final boolean throwError) throws ProfileCustomizedException {

    try {

      final HttpEntity<I> request = new HttpEntity<>(edo);
      final ResponseEntity<O> response = this.restTemplate.exchange(url, HttpMethod.POST, request, responseType);
      return response.getBody();

    }
    catch (final RestClientResponseException e) {
      if (!throwError) {
        return null;
      }
      final String resp = e.getResponseBodyAsString();

      IFlowErrorRestResponse response = null;
      try {
        response = this.converter.getObjectMapper().readValue(resp, IFlowErrorRestResponse.class);
      }
      catch (final IOException e1) {

      }

      throw new ProfileCustomizedException(response.getMessage(), response.getDetails(), service.getModuleName(),
          response.getErrorType());
    }
    catch (final RestClientException e) {
      if (!throwError) {
        return null;
      }

      throw new ProfileCustomizedException(this.generateServiceErrorMessage(url.toString(), service),
          IFlowErrorRestResponse.stackListToString(e.getStackTrace()), service.getModuleName());
    }
  }

  private String generateServiceErrorMessage(final String url, final EModule service) {

    return String.format("Invalid Service Status : %s  or URL: %s ", service.getModuleName(), url);
  }

}

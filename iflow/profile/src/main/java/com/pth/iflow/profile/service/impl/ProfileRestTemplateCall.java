package com.pth.iflow.profile.service.impl;

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
import com.pth.iflow.common.response.IFlowErrorRestResponse;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.service.IProfileRestTemplateCall;

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
            e1.getMessage(),
            service.name());
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }

      throw new ProfileCustomizedException(response.getMessage(), response.getErrorType(), service.getModuleName());
    }
    catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), uri, e);

      if (!throwError) {
        return null;
      }
      throw new ProfileCustomizedException("Service " + service.getModuleName() + " is not availeable.", "", EModule.GUI.getModuleName());
    }
    
  }

  @Override
  public <I, O> O callRestPost(final String url, final EModule service, final I edo, final Class<O> response,
      final boolean throwError) throws ProfileCustomizedException {

    if (response.equals(Void.class)) {
      callRestPost(URI.create(url), service, edo, response, throwError);
      return null;
    }
    else {
      return callRestPost(URI.create(url), service, edo, response, throwError);
    }
  }

  @Override
  public <O> O callRestGet(final String url, final EModule service, final Class<O> responseClass,
      final boolean throwError, final Object... args) throws ProfileCustomizedException {
    try {

      if (responseClass.equals(Void.class)) {
        this.restTemplate.getForObject(url, responseClass, args);
        return null;
      }
      else {
        return this.restTemplate.getForObject(url, responseClass, args);
      }

    }
    catch (final RestClientResponseException e) {
      final String resp = e.getResponseBodyAsString();
      this.log.error("ERROR in connection with \"{}\" through url \"{}\" and response is {} ", service.getModuleName(), url, resp, e);
      
      if (!throwError) {
        return null;
      }
      
      IFlowErrorRestResponse response = null;
      try {
        response = this.converter.getObjectMapper().readValue(resp, IFlowErrorRestResponse.class);
      }
      catch (final IOException e1) {
        final ProfileCustomizedException uiCustomizedException = new ProfileCustomizedException("failed to POST: " + url,
            e1.getMessage(),
            service.name());
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }
      
      throw new ProfileCustomizedException(response.getMessage(), response.getErrorType(), service.getModuleName());
    }
    catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), url, e);
      
      if (!throwError) {
        return null;
      }
      throw new ProfileCustomizedException("Service " + service.getModuleName() + " is not availeable.", "", EModule.GUI.getModuleName());
    }
    catch (final Exception e) {
      if (!throwError) {
        return null;
      }

      throw new ProfileCustomizedException(generateServiceErrorMessage(url, service),
          IFlowErrorRestResponse.stackListToString(e.getStackTrace()), EModule.GUI.getModuleName());
    }
  }

  @Override
  public <O> O callRestGet(final URI uri, final EModule service, final Class<O> responseClass, final boolean throwError,
      final Object... args) throws ProfileCustomizedException {

    if (responseClass.equals(Void.class)) {
      callRestGet(uri.toString(), service, responseClass, throwError, args);
      return null;
    }
    else {
      return callRestGet(uri.toString(), service, responseClass, throwError, args);
    }

  }

  private boolean exceptionHasUrl(final RestClientException e) {
    return e.getMessage().trim().startsWith("I/O error") && e.getMessage().contains("\"http:");
  }

  private String retreiveUrlFromError(final RestClientException e, final String defaultUrl) {
    String propUrl = defaultUrl;
    try {
      final int idx = e.getMessage().indexOf("\"http:");
      propUrl = e.getMessage().substring(idx, e.getMessage().indexOf("\"", idx + 5) + 1);
    }
    catch (final Exception ex) {

    }
    return propUrl;
  }

  @Override
  public <O> O callRestGet(final String url, final EModule service, final ParameterizedTypeReference<O> responseType,
      final boolean throwError, final Object... args) throws ProfileCustomizedException {
    try {

      final ResponseEntity<O> response = this.restTemplate.exchange(url, HttpMethod.GET, null, responseType, args);
      return response.getBody();

    }
    catch (final RestClientResponseException e) {
      final String resp = e.getResponseBodyAsString();
      this.log.error("ERROR in connection with \"{}\" through url \"{}\" and response is {} ", service.getModuleName(), url, resp, e);
      
      if (!throwError) {
        return null;
      }
      
      IFlowErrorRestResponse response = null;
      try {
        response = this.converter.getObjectMapper().readValue(resp, IFlowErrorRestResponse.class);
      }
      catch (final IOException e1) {
        final ProfileCustomizedException uiCustomizedException = new ProfileCustomizedException("failed to POST: " + url,
            e1.getMessage(),
            service.name());
        uiCustomizedException.initCause(e1);
        throw uiCustomizedException;
      }
      
      throw new ProfileCustomizedException(response.getMessage(), response.getErrorType(), service.getModuleName());
    }
    catch (final RestClientException e) {
      this.log.error("ERROR in connection with \"{}\" through url \"{}\": ", service.getModuleName(), url, e);
      
      if (!throwError) {
        return null;
      }
      throw new ProfileCustomizedException("Service " + service.getModuleName() + " is not availeable.", "", EModule.GUI.getModuleName());
    }

  }

  @Override
  public <I, O> O callRestPost(final String url, final EModule service, final I edo,
      final ParameterizedTypeReference<O> responseType, final boolean throwError) throws ProfileCustomizedException {
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

      throw new ProfileCustomizedException(response.getErrorType(), response.getMessage(), service.getModuleName());
    }
    catch (final RestClientException e) {
      if (!throwError) {
        return null;
      }
      String propUrl = url;
      if (exceptionHasUrl(e)) {
        propUrl = retreiveUrlFromError(e, url);
      }

      throw new ProfileCustomizedException(generateServiceErrorMessage(url, service),
          IFlowErrorRestResponse.stackListToString(e.getStackTrace()), EModule.GUI.getModuleName());
    }
  }

  @Override
  public <I, O> O callRestPost(final URI url, final EModule service, final I edo,
      final ParameterizedTypeReference<O> responseType, final boolean throwError) throws ProfileCustomizedException {
    return callRestPost(url, service, edo, responseType, throwError);
  }

  private String generateServiceErrorMessage(final String url, final EModule service) {
    return String.format("Invalid Service Status : %s  or URL: %s ", service.getModuleName(), url);
  }

}

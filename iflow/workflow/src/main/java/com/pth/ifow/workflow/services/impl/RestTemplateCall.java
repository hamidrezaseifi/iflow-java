package com.pth.ifow.workflow.services.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pth.iflow.common.enums.EModule;
import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.services.IRestTemplateCall;

@Service
public class RestTemplateCall implements IRestTemplateCall {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter converter;

  @Override
  public <I, O> O callRestPost(final URI uri, final EModule service, final I edo, final Class<O> responseClass,
      final boolean throwError) throws WorkflowCustomizedException {

    if (responseClass.equals(Void.class)) {
      restTemplate.postForObject(uri, edo, responseClass);
      return null;
    } else {
      return restTemplate.postForObject(uri, edo, responseClass);
    }

  }

  @Override
  public <I, O> O callRestPost(final String url, final EModule service, final I edo, final Class<O> response, final boolean throwError)
      throws WorkflowCustomizedException {

    if (response.equals(Void.class)) {
      callRestPost(URI.create(url), service, edo, response, throwError);
      return null;
    } else {
      return callRestPost(URI.create(url), service, edo, response, throwError);
    }
  }

  @Override
  public <O> O callRestGet(final String url, final EModule service, final Class<O> responseClass, final boolean throwError,
      final Object... args) throws WorkflowCustomizedException {

    if (responseClass.equals(Void.class)) {
      restTemplate.getForObject(url, responseClass, args);
      return null;
    } else {
      return restTemplate.getForObject(url, responseClass, args);
    }

  }

  @Override
  public <O> O callRestGet(final URI uri, final EModule service, final Class<O> responseClass, final boolean throwError,
      final Object... args) throws WorkflowCustomizedException {

    if (responseClass.equals(Void.class)) {
      callRestGet(uri.toString(), service, responseClass, throwError, args);
      return null;
    } else {
      return callRestGet(uri.toString(), service, responseClass, throwError, args);
    }

  }

  @Override
  public <O> O callRestGet(final String url, final EModule service, final ParameterizedTypeReference<O> responseType,
      final boolean throwError, final Object... args) throws WorkflowCustomizedException {

    final ResponseEntity<O> response = restTemplate.exchange(url, HttpMethod.GET, null, responseType, args);
    return response.getBody();

  }

  @Override
  public <I, O> O callRestPost(final String url, final EModule service, final I edo, final ParameterizedTypeReference<O> responseType,
      final boolean throwError) throws WorkflowCustomizedException {

    final HttpEntity<I> request = new HttpEntity<>(edo);
    final ResponseEntity<O> response = restTemplate.exchange(url, HttpMethod.POST, request, responseType);
    return response.getBody();

  }

  @Override
  public <I, O> O callRestPost(final URI url, final EModule service, final I edo, final ParameterizedTypeReference<O> responseType,
      final boolean throwError) throws WorkflowCustomizedException {
    return callRestPost(url, service, edo, responseType, throwError);
  }

}

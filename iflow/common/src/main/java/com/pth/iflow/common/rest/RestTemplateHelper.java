package com.pth.iflow.common.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class RestTemplateHelper {

  protected MultiValueMap<String, String> generateTokenHeader(final String token) {

    final MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    if (token != null) {
      headers.add("Authorization", "Bearer " + token);

    }
    headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE);
    return headers;
  }

  protected HttpEntity<Object> prepareEntity(final String token) {

    final HttpEntity<Object> requestEntity = new HttpEntity<>(this.generateTokenHeader(token));
    return requestEntity;
  }

  protected <I> HttpEntity<I> prepareRequest(final I edo, final String token) {

    final HttpEntity<I> request = new HttpEntity<>(edo, this.generateTokenHeader(token));
    return request;
  }

}

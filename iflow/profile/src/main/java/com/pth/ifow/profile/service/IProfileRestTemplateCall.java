package com.pth.ifow.profile.service;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;

import com.pth.iflow.common.enums.EModule;
import com.pth.ifow.profile.exceptions.ProfileCustomizedException;

/**
 * @author rezasei
 *
 */
public interface IProfileRestTemplateCall {

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @return
   * @throws ProfileCustomizedException
   */
  <I, O> O callRestPost(final String url, final EModule service, final I edo, final Class<O> response,
      boolean throwError) throws ProfileCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @return
   * @throws ProfileCustomizedException
   */
  <I, O> O callRestPost(final URI url, final EModule service, final I edo, final Class<O> response, boolean throwError)
      throws ProfileCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @param args
   * @return
   * @throws ProfileCustomizedException
   */
  <O> O callRestGet(final String url, final EModule service, final Class<O> responseClass, boolean throwError,
      final Object... args) throws ProfileCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @param args
   * @return
   * @throws ProfileCustomizedException
   */
  <O> O callRestGet(final URI url, final EModule service, final Class<O> responseClass, boolean throwError,
      final Object... args) throws ProfileCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @param args
   * @return
   * @throws ProfileCustomizedException
   */
  <O> O callRestGet(final String url, final EModule service, final ParameterizedTypeReference<O> responseType,
      boolean throwError, final Object... args) throws ProfileCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @return
   * @throws ProfileCustomizedException
   */
  <I, O> O callRestPost(final String url, final EModule service, final I edo,
      final ParameterizedTypeReference<O> responseType, boolean throwError) throws ProfileCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @return
   * @throws ProfileCustomizedException
   */
  <I, O> O callRestPost(final URI url, final EModule service, final I edo,
      final ParameterizedTypeReference<O> responseType, boolean throwError) throws ProfileCustomizedException;

}

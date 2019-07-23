package com.pth.iflow.backend.services;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;

import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.common.enums.EModule;

/**
 * @author rezasei
 *
 */
public interface IBackendRestTemplateCall {
  
  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @return
   * @throws BackendCustomizedException
   */
  <I, O> O callRestPost(final String url, final EModule service, final I edo, final Class<O> response,
      boolean throwError) throws BackendCustomizedException;
  
  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @return
   * @throws BackendCustomizedException
   */
  <I, O> O callRestPost(final URI url, final EModule service, final I edo, final Class<O> response, boolean throwError)
      throws BackendCustomizedException;
  
  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @param args
   * @return
   * @throws BackendCustomizedException
   */
  <O> O callRestGet(final String url, final EModule service, final Class<O> responseClass, boolean throwError,
      final Object... args) throws BackendCustomizedException;
  
  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @param args
   * @return
   * @throws BackendCustomizedException
   */
  <O> O callRestGet(final URI url, final EModule service, final Class<O> responseClass, boolean throwError,
      final Object... args) throws BackendCustomizedException;
  
  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @param args
   * @return
   * @throws BackendCustomizedException
   */
  <O> O callRestGet(final String url, final EModule service, final ParameterizedTypeReference<O> responseType,
      boolean throwError, final Object... args) throws BackendCustomizedException;
  
  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @return
   * @throws BackendCustomizedException
   */
  <I, O> O callRestPost(final String url, final EModule service, final I edo,
      final ParameterizedTypeReference<O> responseType, boolean throwError) throws BackendCustomizedException;
  
  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @return
   * @throws BackendCustomizedException
   */
  <I, O> O callRestPost(final URI url, final EModule service, final I edo,
      final ParameterizedTypeReference<O> responseType, boolean throwError) throws BackendCustomizedException;
  
}

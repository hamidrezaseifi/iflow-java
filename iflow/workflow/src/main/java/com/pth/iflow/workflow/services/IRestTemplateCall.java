package com.pth.iflow.workflow.services;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;

/**
 * @author rezasei
 *
 */
public interface IRestTemplateCall {

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @return
   * @throws WorkflowCustomizedException
   */
  <I, O> O callRestPost(final String url, final EModule service, final I edo, final Class<O> response, boolean throwError) throws WorkflowCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @return
   * @throws WorkflowCustomizedException
   */
  <I, O> O callRestPost(final URI url, final EModule service, final I edo, final Class<O> response, boolean throwError) throws WorkflowCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @param args
   * @return
   * @throws WorkflowCustomizedException
   */
  <O> O callRestGet(final String url, final EModule service, final Class<O> responseClass, boolean throwError, final Object... args)
      throws WorkflowCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @param args
   * @return
   * @throws WorkflowCustomizedException
   */
  <O> O callRestGet(final URI url, final EModule service, final Class<O> responseClass, boolean throwError, final Object... args)
      throws WorkflowCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @param args
   * @return
   * @throws WorkflowCustomizedException
   */
  <O> O callRestGet(final String url, final EModule service, final ParameterizedTypeReference<O> responseType, boolean throwError,
      final Object... args) throws WorkflowCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @return
   * @throws WorkflowCustomizedException
   */
  <I, O> O callRestPost(final String url, final EModule service, final I edo, final ParameterizedTypeReference<O> responseType,
      boolean throwError) throws WorkflowCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @return
   * @throws WorkflowCustomizedException
   */
  <I, O> O callRestPost(final URI url, final EModule service, final I edo, final ParameterizedTypeReference<O> responseType,
      boolean throwError) throws WorkflowCustomizedException;

}

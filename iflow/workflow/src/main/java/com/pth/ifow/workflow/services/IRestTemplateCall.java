package com.pth.ifow.workflow.services;

import com.pth.iflow.common.enums.EModule;
import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;

/**
 * @author rezasei
 *
 */
public interface IRestTemplateCall {

  <I, O> O callRestPost(final String url, final EModule service, final I edo, final Class<O> response, boolean throwError)
      throws WorkflowCustomizedException;

  <I, O> O callRestPostWithToken(final String url, final EModule service, final I edo, final Class<O> response, boolean throwError)
      throws WorkflowCustomizedException;

  <O> O callRestGet(final String url, final EModule service, final Class<O> responseClass, boolean throwError, final Object... args)
      throws WorkflowCustomizedException;

  <O> O callRestGetWithToken(final String url, final EModule service, final Class<O> responseClass, boolean throwError,
      final Object... args) throws WorkflowCustomizedException;

}

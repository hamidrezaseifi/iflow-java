package com.pth.iflow.workflow.services;

import java.net.URI;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;

/**
 * @author rezasei
 *
 */
public interface IRestTemplateCall {

  <I, O> O callRestPost(final URI url, String token, final EModule service, final I edo, final Class<O> response, boolean throwError)
      throws WorkflowCustomizedException;

  <O> O callRestGet(final URI url, String token, final EModule service, final Class<O> responseClass, boolean throwError,
      final Object... args) throws WorkflowCustomizedException;

}

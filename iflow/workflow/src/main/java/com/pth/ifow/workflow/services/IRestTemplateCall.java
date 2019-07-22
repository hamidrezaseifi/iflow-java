package com.pth.ifow.workflow.services;

import java.net.URL;

import com.pth.iflow.common.enums.EModule;
import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;

/**
 * @author rezasei
 *
 */
public interface IRestTemplateCall {
  
  <I, O> O callRestPost(final URL url, String token, final EModule service, final I edo, final Class<O> response, boolean throwError)
      throws WorkflowCustomizedException;
  
  <O> O callRestGet(final URL url, String token, final EModule service, final Class<O> responseClass, boolean throwError,
      final Object... args) throws WorkflowCustomizedException;
  
}

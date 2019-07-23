package com.pth.iflow.backend.services;

import java.net.URL;

import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.common.enums.EModule;

/**
 * @author rezasei
 *
 */
public interface IBackendRestTemplateCall {
  
  <I, O> O callRestPost(final URL url, String token, final EModule service, final I edo, final Class<O> response, boolean throwError)
      throws BackendCustomizedException;
  
  <O> O callRestGet(final URL url, String token, final EModule service, final Class<O> responseClass, boolean throwError,
      final Object... args) throws BackendCustomizedException;
  
}

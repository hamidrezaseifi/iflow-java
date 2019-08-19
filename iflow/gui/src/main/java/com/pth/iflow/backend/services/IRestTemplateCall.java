package com.pth.iflow.backend.services;

import java.net.URI;

import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.common.enums.EModule;

/**
 * @author rezasei
 *
 */
public interface IRestTemplateCall {

  <I, O> O callRestPost(final URI uri, final EModule service, final I edo, final Class<O> response, final String token,
      boolean throwError) throws BackendCustomizedException;

  <O> O callRestGet(final URI uri, final EModule service, final Class<O> responseClass, final String token, boolean throwError)
      throws BackendCustomizedException;

}

package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.xml.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.xml.TokenProfileRequestEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.ITokenValidator;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.ProfileResponse;
import com.pth.iflow.workflow.services.IRestTemplateCall;

@Service
public class TokenValidator implements ITokenValidator {

  private static final Logger logger = LoggerFactory.getLogger(TokenValidator.class);

  private final IRestTemplateCall                        restTemplate;
  private final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  public TokenValidator(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public ProfileResponse isTokenValid(final String token) throws WorkflowCustomizedException, MalformedURLException {

    logger.debug("Validate token {} from profile service", token);

    final TokenProfileRequestEdo profileRequest = new TokenProfileRequestEdo();
    profileRequest.setToken(token);

    final ProfileResponseEdo responseEdo = this.restTemplate.callRestPost(
        this.moduleAccessConfig.generateProfileUrl(IflowRestPaths.ProfileModule.PROFILE_READ_TOKENINFO), token, EModule.PROFILE,
        profileRequest, ProfileResponseEdo.class, true);

    return new ProfileResponse().fromEdo(responseEdo);
  }

}

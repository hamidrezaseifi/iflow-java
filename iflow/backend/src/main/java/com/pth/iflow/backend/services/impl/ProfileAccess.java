package com.pth.iflow.backend.services.impl;

import java.net.MalformedURLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.backend.configurations.BackendConfiguration;
import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.backend.models.ProfileResponse;
import com.pth.iflow.backend.models.UserAuthenticationResponse;
import com.pth.iflow.backend.models.mapper.BackendModelEdoMapper;
import com.pth.iflow.backend.services.IProfileAccess;
import com.pth.iflow.backend.services.IRestTemplateCall;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.models.edo.ProfileResponseEdo;
import com.pth.iflow.common.models.edo.TokenProfileRequestEdo;
import com.pth.iflow.common.models.edo.UserAuthenticationRequestEdo;
import com.pth.iflow.common.models.edo.UserAuthenticationResponseEdo;

@Service
public class ProfileAccess implements IProfileAccess {

  private static final Logger logger = LoggerFactory.getLogger(ProfileAccess.class);

  private final IRestTemplateCall                       restTemplate;
  private final BackendConfiguration.ModuleAccessConfig moduleAccessConfig;

  public ProfileAccess(@Autowired final IRestTemplateCall restTemplate,
                       @Autowired final BackendConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public ProfileResponse isTokenValid(final String token) throws BackendCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Validate token {} from profile service", token);

    final TokenProfileRequestEdo profileRequest = new TokenProfileRequestEdo();
    profileRequest.setToken(token);

    final ProfileResponseEdo responseEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getReadTokenInfoUri(),
                                                                          EModule.PROFILE,
                                                                          profileRequest,
                                                                          ProfileResponseEdo.class,
                                                                          token,
                                                                          true);

    return BackendModelEdoMapper.fromEdo(responseEdo);
  }

  @Override
  public UserAuthenticationResponse authenticate(final String username, final String password, final String companyIdentity) throws BackendCustomizedException, MalformedURLException {
    logger.debug("Authenticate user {} from profile service", username);

    final UserAuthenticationRequestEdo request = new UserAuthenticationRequestEdo();
    request.setCompanyIdentity(companyIdentity);
    request.setEmail(username);
    request.setPassword(password);

    final UserAuthenticationResponseEdo responseEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getAuthenticationUri(),
                                                                                     EModule.PROFILE,
                                                                                     request,
                                                                                     UserAuthenticationResponseEdo.class,
                                                                                     "",
                                                                                     true);

    return UserAuthenticationResponse.fromEdo(responseEdo);
  }

  @Override
  public ProfileResponse readProfile(final String username, final String token) throws BackendCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Read profile for user {} from profile service", username);

    final AuthenticatedProfileRequestEdo request = new AuthenticatedProfileRequestEdo();
    request.setToken(token);
    request.setEmail(username);

    final ProfileResponseEdo responseEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getReadAuthenticationInfoUri(),
                                                                          EModule.PROFILE,
                                                                          request,
                                                                          ProfileResponseEdo.class,
                                                                          token,
                                                                          true);

    return BackendModelEdoMapper.fromEdo(responseEdo);
  }

}

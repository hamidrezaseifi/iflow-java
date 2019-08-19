package com.pth.iflow.backend.services.impl;

import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.backend.configurations.GuiConfiguration;
import com.pth.iflow.backend.exceptions.GuiCustomizedException;
import com.pth.iflow.backend.models.GuiProfileResponse;
import com.pth.iflow.backend.models.GuiUserAuthenticationResponse;
import com.pth.iflow.backend.services.IProfileAccess;
import com.pth.iflow.backend.services.IRestTemplateCall;
import com.pth.iflow.common.edo.models.xml.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.edo.models.xml.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.xml.TokenProfileRequestEdo;
import com.pth.iflow.common.edo.models.xml.UserAuthenticationRequestEdo;
import com.pth.iflow.common.edo.models.xml.UserAuthenticationResponseEdo;
import com.pth.iflow.common.enums.EModule;

@Service
public class ProfileAccess implements IProfileAccess {

  private static final Logger                           logger = LoggerFactory.getLogger(ProfileAccess.class);

  private final IRestTemplateCall                       restTemplate;
  private final GuiConfiguration.ModuleAccessConfig moduleAccessConfig;

  public ProfileAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public GuiProfileResponse isTokenValid(final String token) throws GuiCustomizedException, MalformedURLException {

    logger.debug("Validate token {} from profile service", token);

    final TokenProfileRequestEdo profileRequest = new TokenProfileRequestEdo();
    profileRequest.setToken(token);

    final ProfileResponseEdo responseEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getReadTokenInfoUri(),
        EModule.PROFILE, profileRequest, ProfileResponseEdo.class, token, true);

    return GuiProfileResponse.fromEdo(responseEdo);
  }

  @Override
  public GuiUserAuthenticationResponse authenticate(final String username, final String password, final String companyIdentity)
      throws GuiCustomizedException, MalformedURLException {
    logger.debug("Authenticate user {} from profile service", username);

    final UserAuthenticationRequestEdo request = new UserAuthenticationRequestEdo();
    request.setCompanyIdentity(companyIdentity);
    request.setEmail(username);
    request.setPassword(password);

    final UserAuthenticationResponseEdo responseEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getAuthenticationUri(),
        EModule.PROFILE, request, UserAuthenticationResponseEdo.class, "", true);

    return GuiUserAuthenticationResponse.fromEdo(responseEdo);
  }

  @Override
  public GuiProfileResponse readProfile(final String username, final String token)
      throws GuiCustomizedException, MalformedURLException {
    logger.debug("Read profile for user {} from profile service", username);

    final AuthenticatedProfileRequestEdo request = new AuthenticatedProfileRequestEdo();
    request.setToken(token);
    request.setEmail(username);

    final ProfileResponseEdo responseEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getReadAuthenticationInfoUri(),
        EModule.PROFILE, request, ProfileResponseEdo.class, token, true);

    return GuiProfileResponse.fromEdo(responseEdo);
  }

}

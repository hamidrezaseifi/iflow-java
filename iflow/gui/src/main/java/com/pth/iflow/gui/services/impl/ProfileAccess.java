package com.pth.iflow.gui.services.impl;

import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.xml.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.edo.models.xml.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.xml.TokenProfileRequestEdo;
import com.pth.iflow.common.edo.models.xml.UserAuthenticationRequestEdo;
import com.pth.iflow.common.edo.models.xml.UserAuthenticationResponseEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiProfileResponse;
import com.pth.iflow.gui.models.GuiUserAuthenticationResponse;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.services.IProfileAccess;
import com.pth.iflow.gui.services.IRestTemplateCall;

@Service
public class ProfileAccess implements IProfileAccess {

  private static final Logger                       logger = LoggerFactory.getLogger(ProfileAccess.class);

  private final IRestTemplateCall                   restTemplate;
  private final GuiConfiguration.ModuleAccessConfig moduleAccessConfig;

  public ProfileAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public GuiProfileResponse isTokenValid(final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Validate token {} from profile service", token);

    final TokenProfileRequestEdo profileRequest = new TokenProfileRequestEdo();
    profileRequest.setToken(token);

    final ProfileResponseEdo responseEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getReadTokenInfoUri(),
        EModule.PROFILE, profileRequest, ProfileResponseEdo.class, token, true);

    return GuiModelEdoMapper.fromEdo(responseEdo);
  }

  @Override
  public GuiUserAuthenticationResponse authenticate(final String username, final String password, final String companyIdentity)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Authenticate user {} from profile service", username);

    final UserAuthenticationRequestEdo request = new UserAuthenticationRequestEdo();
    request.setCompanyIdentity(companyIdentity);
    request.setEmail(username);
    request.setPassword(password);

    final UserAuthenticationResponseEdo responseEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getAuthenticationUri(),
        EModule.PROFILE, request, UserAuthenticationResponseEdo.class, "", true);

    return GuiModelEdoMapper.fromEdo(responseEdo);
  }

  @Override
  public GuiProfileResponse readProfile(final String username, final String token)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Read profile for user {} from profile service", username);

    final AuthenticatedProfileRequestEdo request = new AuthenticatedProfileRequestEdo();
    request.setToken(token);
    request.setEmail(username);

    final ProfileResponseEdo responseEdo = this.restTemplate.callRestPost(this.moduleAccessConfig.getReadAuthenticationInfoUri(),
        EModule.PROFILE, request, ProfileResponseEdo.class, token, true);

    return GuiModelEdoMapper.fromEdo(responseEdo);
  }

}

package com.pth.ifow.profile.service.impl;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.ifow.profile.config.ProfileConfiguration;
import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.model.UserAuthenticationRequest;
import com.pth.ifow.profile.service.IProfileRestTemplateCall;
import com.pth.ifow.profile.service.IUsersService;

@Service
public class UsersService implements IUsersService {

  private static final Logger logger = LoggerFactory.getLogger(UsersService.class);

  final IProfileRestTemplateCall restTemplate;
  final ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  UsersService(@Autowired final IProfileRestTemplateCall restTemplate,
      @Autowired final ProfileConfiguration.CoreAccessConfig coreAccessConfig) {
    this.restTemplate = restTemplate;
    this.coreAccessConfig = coreAccessConfig;
  }

  @Override
  public User getUserByEmail(final UserAuthenticationRequest user)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    logger.debug("Request user data for email {}", user.getEmail());

    final UserEdo edo = restTemplate.callRestGet(coreAccessConfig.getReadUserByEmailUrl().toString(), EModule.CORE,
        UserEdo.class, true, user.getEmail());

    return User.fromEdo(edo);
  }

}

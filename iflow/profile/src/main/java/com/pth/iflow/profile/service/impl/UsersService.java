package com.pth.iflow.profile.service.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.ProfileResponseEdo;
import com.pth.iflow.common.models.edo.UserEdo;
import com.pth.iflow.common.models.edo.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.IProfileRestTemplateCall;
import com.pth.iflow.profile.service.IUsersService;

@Service
public class UsersService implements IUsersService {

  private static final Logger                 logger = LoggerFactory.getLogger(UsersService.class);

  final IProfileRestTemplateCall              restTemplate;
  final ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  public UsersService(@Autowired final IProfileRestTemplateCall restTemplate,
      @Autowired final ProfileConfiguration.CoreAccessConfig coreAccessConfig) {
    this.restTemplate = restTemplate;
    this.coreAccessConfig = coreAccessConfig;
  }

  @Override
  public User getUserByEmail(final String email)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request user data for email {}", email);

    final UserEdo edo = this.restTemplate.callRestGet(
        this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_USER_BY_EMAIL(email)).toString(), EModule.CORE,
        UserEdo.class, true);

    return ProfileModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<User> getUserListByCompanyIdentity(final String companyId)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request user data list for company identity {}", companyId);

    final UserListEdo edo = this.restTemplate.callRestGet(
        this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_USER_USER_LIST_BY_COMPANY(companyId)).toString(),
        EModule.CORE, UserListEdo.class, true);

    return ProfileModelEdoMapper.fromUserEdoList(edo.getUsers());
  }

  @Override
  public ProfileResponse getUserProfileByEmail(final String email)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Request user data for email {}", email);

    final ProfileResponseEdo edo = this.restTemplate.callRestGet(
        this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_USERPROFILE_BY_EMAIL(email)).toString(), EModule.CORE,
        ProfileResponseEdo.class, true);

    return ProfileModelEdoMapper.fromEdo(edo);
  }

}

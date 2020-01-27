package com.pth.iflow.profile.service.access.impl;

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
import com.pth.iflow.profile.service.access.IUsersAccessService;
import com.pth.iflow.profile.service.handler.IProfileRestTemplateCall;

@Service
public class UsersAccessService implements IUsersAccessService {

  private static final Logger logger = LoggerFactory.getLogger(UsersAccessService.class);

  final IProfileRestTemplateCall restTemplate;
  final ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  public UsersAccessService(@Autowired final IProfileRestTemplateCall restTemplate,
      @Autowired final ProfileConfiguration.CoreAccessConfig coreAccessConfig) {

    this.restTemplate = restTemplate;
    this.coreAccessConfig = coreAccessConfig;
  }

  @Override
  public User getUserByIdentity(final String useridentity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request user data for useridentity {}", useridentity);

    final UserEdo edo = this.restTemplate
        .callRestGet(
            this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_USER_BY_IDENTITY(useridentity)), EModule.CORE,
            UserEdo.class, true);

    return ProfileModelEdoMapper.fromEdo(edo);
  }

  @Override
  public List<User> getUserListByCompanyIdentity(final String companyId)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request user data list for company identity {}", companyId);

    final UserListEdo edo = this.restTemplate
        .callRestGet(
            this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_USER_USER_LIST_BY_COMPANY(companyId)),
            EModule.CORE, UserListEdo.class, true);

    return ProfileModelEdoMapper.fromUserEdoList(edo.getUsers());
  }

  @Override
  public ProfileResponse getUserProfileByIdentity(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request user data for useridentity {}", identity);

    final ProfileResponseEdo edo = this.restTemplate
        .callRestGet(
            this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_USERPROFILE_BY_IDENTITY(identity)), EModule.CORE,
            ProfileResponseEdo.class, true);

    return ProfileModelEdoMapper.fromEdo(edo);
  }

  @Override
  public ProfileResponse getUserProfileByEmail(final String email)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Request user data for user email {}", email);

    final ProfileResponseEdo edo = this.restTemplate
        .callRestGet(
            this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.READ_USERPROFILE_BY_EMAIL(email)), EModule.CORE,
            ProfileResponseEdo.class, true);

    return ProfileModelEdoMapper.fromEdo(edo);
  }

  @Override
  public User saveUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Save workflow");

    final UserEdo userEdo = this.restTemplate
        .callRestPost(
            this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.SAVE_USER_URIBUILDER()), EModule.CORE,
            ProfileModelEdoMapper.toEdo(user),
            UserEdo.class, true);

    return ProfileModelEdoMapper.fromEdo(userEdo);
  }

  @Override
  public void deleteUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Delete workflow");

    this.restTemplate
        .callRestPost(
            this.coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModule.DELETE_USER_URIBUILDER()), EModule.CORE,
            ProfileModelEdoMapper.toEdo(user),
            Void.class, true);

  }

}

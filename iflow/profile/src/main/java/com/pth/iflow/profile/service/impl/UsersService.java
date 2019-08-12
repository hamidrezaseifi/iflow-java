package com.pth.iflow.profile.service.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.xml.UserEdo;
import com.pth.iflow.common.edo.models.xml.UserListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.User;
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
  public User getUserByEmail(final String email) throws ProfileCustomizedException, MalformedURLException {

    logger.debug("Request user data for email {}", email);

    final UserEdo edo = restTemplate.callRestGet(
        coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModul.USER_READ_BY_EMAIL).toString(), EModule.CORE, UserEdo.class, true,
        email);

    return new User().fromEdo(edo);
  }

  @Override
  public User getUserById(final Long id) throws ProfileCustomizedException, MalformedURLException {
    logger.debug("Request user data for id {}", id);

    final UserEdo edo = restTemplate.callRestGet(coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModul.USER_READ_BY_ID).toString(),
        EModule.CORE, UserEdo.class, true, id);

    return new User().fromEdo(edo);
  }

  @Override
  public List<User> getUserListByCompanyId(final Long companyId) throws ProfileCustomizedException, MalformedURLException {
    logger.debug("Request user data list for company id {}", companyId);

    final UserListEdo edo = restTemplate.callRestGet(
        coreAccessConfig.prepareCoreUrl(IflowRestPaths.CoreModul.USER_USER_LIST_BY_COMPANY).toString(), EModule.CORE,
        UserListEdo.class, true, companyId);

    return new User().fromEdoList(edo.getUsers());
  }

}

package com.pth.iflow.backend.services.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.backend.configurations.BackendConfiguration;
import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.backend.models.BackendUser;
import com.pth.iflow.backend.services.IRestTemplateCall;
import com.pth.iflow.backend.services.IUserAccess;
import com.pth.iflow.common.edo.models.xml.UserListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.rest.IflowRestPaths;

@Service
public class UserAccess implements IUserAccess {

  private static final Logger logger = LoggerFactory.getLogger(UserAccess.class);

  private final IRestTemplateCall                       restTemplate;
  private final BackendConfiguration.ModuleAccessConfig moduleAccessConfig;

  public UserAccess(@Autowired final IRestTemplateCall restTemplate,
                    @Autowired final BackendConfiguration.ModuleAccessConfig moduleAccessConfig) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
  }

  @Override
  public BackendUser readUser(final Long userId, final String token) throws BackendCustomizedException, MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BackendUser saveUser(final BackendUser user, final String token) throws BackendCustomizedException, MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<BackendUser> readCompanyUserList(final Long companyId, final String token) throws BackendCustomizedException,
                                                                                         MalformedURLException {
    logger.debug("Read user list for company id {}", companyId);

    final UserListEdo responseEdo = this.restTemplate.callRestGet(
                                                                  this.moduleAccessConfig.generateProfileUrl(IflowRestPaths.ProfileModule.COMPANY_READ_USER_LIST),
                                                                  token,
                                                                  EModule.PROFILE,
                                                                  UserListEdo.class,
                                                                  true,
                                                                  companyId);

    return new BackendUser().fromEdoList(responseEdo.getUsers());
  }

}

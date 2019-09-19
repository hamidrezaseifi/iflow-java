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
import com.pth.iflow.backend.models.mapper.BackendModelEdoMapper;
import com.pth.iflow.backend.models.ui.BackendSessionUserInfo;
import com.pth.iflow.backend.services.IRestTemplateCall;
import com.pth.iflow.backend.services.IUserAccess;
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;

@Service
public class UserAccess implements IUserAccess {

  private static final Logger logger = LoggerFactory.getLogger(UserAccess.class);

  private final IRestTemplateCall                       restTemplate;
  private final BackendConfiguration.ModuleAccessConfig moduleAccessConfig;

  private final BackendSessionUserInfo sessionUserInfo;

  public UserAccess(@Autowired final IRestTemplateCall restTemplate,
                    @Autowired final BackendConfiguration.ModuleAccessConfig moduleAccessConfig,
                    @Autowired final BackendSessionUserInfo sessionUserInfo) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public BackendUser readUser(final Long userId) throws BackendCustomizedException, MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BackendUser saveUser(final BackendUser user) throws BackendCustomizedException, MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<BackendUser> readCompanyUserList(final Long companyId) throws MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Read user list for company id {}", companyId);

    final UserListEdo responseEdo = this.restTemplate.callRestGet(this.moduleAccessConfig.getReadCompanyUserListUri(companyId),
                                                                  EModule.PROFILE,
                                                                  UserListEdo.class,
                                                                  this.sessionUserInfo.isLoggedIn() ? this.sessionUserInfo.getToken() : "",
                                                                  true);

    return BackendModelEdoMapper.fromUserEdoList(responseEdo.getUsers());
  }

}

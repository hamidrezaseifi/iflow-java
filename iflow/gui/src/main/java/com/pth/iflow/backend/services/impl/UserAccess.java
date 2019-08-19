package com.pth.iflow.backend.services.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.backend.configurations.GuiConfiguration;
import com.pth.iflow.backend.exceptions.GuiCustomizedException;
import com.pth.iflow.backend.models.GuidUser;
import com.pth.iflow.backend.models.ui.GuiSessionUserInfo;
import com.pth.iflow.backend.services.IRestTemplateCall;
import com.pth.iflow.backend.services.IUserAccess;
import com.pth.iflow.common.edo.models.xml.UserListEdo;
import com.pth.iflow.common.enums.EModule;

@Service
public class UserAccess implements IUserAccess {

  private static final Logger                           logger = LoggerFactory.getLogger(UserAccess.class);

  private final IRestTemplateCall                       restTemplate;
  private final GuiConfiguration.ModuleAccessConfig moduleAccessConfig;

  private final GuiSessionUserInfo                  sessionUserInfo;

  public UserAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.ModuleAccessConfig moduleAccessConfig,
      @Autowired final GuiSessionUserInfo sessionUserInfo) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public GuidUser readUser(final Long userId) throws GuiCustomizedException, MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public GuidUser saveUser(final GuidUser user) throws GuiCustomizedException, MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<GuidUser> readCompanyUserList(final Long companyId) throws GuiCustomizedException, MalformedURLException {
    logger.debug("Read user list for company id {}", companyId);

    final UserListEdo responseEdo = this.restTemplate.callRestGet(this.moduleAccessConfig.getReadCompanyUserListUri(companyId),
        EModule.PROFILE, UserListEdo.class, this.sessionUserInfo.isLoggedIn() ? this.sessionUserInfo.getToken() : "", true);

    return new GuidUser().fromEdoList(responseEdo.getUsers());
  }

}

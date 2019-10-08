package com.pth.iflow.gui.services.impl;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiUser;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.ui.GuiSessionUserInfo;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IUserAccess;

@Service
public class UserAccess implements IUserAccess {

  private static final Logger                              logger = LoggerFactory.getLogger(UserAccess.class);

  private final IRestTemplateCall                          restTemplate;
  private final GuiConfiguration.ProfileModuleAccessConfig moduleAccessConfig;

  private final GuiSessionUserInfo                         sessionUserInfo;

  public UserAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.ProfileModuleAccessConfig moduleAccessConfig,
      @Autowired final GuiSessionUserInfo sessionUserInfo) {
    this.restTemplate = restTemplate;
    this.moduleAccessConfig = moduleAccessConfig;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public GuiUser readUser(final Long userId) throws GuiCustomizedException, MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public GuiUser saveUser(final GuiUser user) throws GuiCustomizedException, MalformedURLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<GuiUser> getCompanyUserList(final String companyIdentity)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Read user list for company id {}", companyIdentity);

    final UserListEdo responseEdo = this.restTemplate.callRestGet(this.moduleAccessConfig.getReadCompanyUserListUri(companyIdentity),
        EModule.PROFILE, UserListEdo.class, this.sessionUserInfo.isLoggedIn() ? this.sessionUserInfo.getToken() : "", true);

    return GuiModelEdoMapper.fromUserEdoList(responseEdo.getUsers());
  }

}

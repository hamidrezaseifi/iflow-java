package com.pth.iflow.gui.services.impl.access;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.UserEdo;
import com.pth.iflow.common.models.edo.UserListEdo;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IUserAccess;

@Service
public class UserAccess implements IUserAccess {

  private static final Logger logger = LoggerFactory.getLogger(UserAccess.class);

  private final IRestTemplateCall restTemplate;
  private final GuiConfiguration.ProfileModuleAccessConfig profileModuleAccessConfig;

  private final SessionUserInfo sessionUserInfo;

  public UserAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.ProfileModuleAccessConfig profileModuleAccessConfig,
      @Autowired final SessionUserInfo sessionUserInfo) {

    this.restTemplate = restTemplate;
    this.profileModuleAccessConfig = profileModuleAccessConfig;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public User saveUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Save workflow");

    final UserEdo userEdo = this.restTemplate
        .callRestPost(
            this.profileModuleAccessConfig.getSaveUserUri(), EModule.CORE, GuiModelEdoMapper.toEdo(user), UserEdo.class, "", true);

    return GuiModelEdoMapper.fromEdo(userEdo);
  }

  @Override
  public List<User> getCompanyUserList(final String companyIdentity)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Read user list for company id from core {}", companyIdentity);

    final UserListEdo responseEdo = this.restTemplate
        .callRestGet(this.profileModuleAccessConfig.getReadCompanyUserListUri(companyIdentity),
            EModule.CORE, UserListEdo.class, this.sessionUserInfo.isLoggedIn() ? this.sessionUserInfo.getToken() : "", true);

    return GuiModelEdoMapper.fromUserEdoList(responseEdo.getUsers());
  }

  @Override
  public void deleteUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("Delete workflow");

    this.restTemplate
        .callRestPost(
            this.profileModuleAccessConfig.getDeleteUserUri(), EModule.CORE, GuiModelEdoMapper.toEdo(user), Void.class, "", true);

  }

}

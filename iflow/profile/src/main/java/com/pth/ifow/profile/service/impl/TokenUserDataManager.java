package com.pth.ifow.profile.service.impl;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.Company;
import com.pth.ifow.profile.model.Department;
import com.pth.ifow.profile.model.ProfileResponse;
import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.model.UserAuthenticationSession;
import com.pth.ifow.profile.model.UserGroup;
import com.pth.ifow.profile.service.ICompanyService;
import com.pth.ifow.profile.service.IDepartmentService;
import com.pth.ifow.profile.service.ISessionManager;
import com.pth.ifow.profile.service.ITokenUserDataManager;
import com.pth.ifow.profile.service.IUserGroupService;
import com.pth.ifow.profile.service.IUsersService;

@Service
public class TokenUserDataManager implements ITokenUserDataManager {

  private final ISessionManager    sessionManager;

  private final IUsersService      usersService;

  private final ICompanyService    companyService;

  private final IUserGroupService  userGroupService;

  private final IDepartmentService departmentService;

  public TokenUserDataManager(@Autowired final ISessionManager sessionManager, @Autowired final IUsersService usersService,
      @Autowired final ICompanyService companyService, @Autowired final IUserGroupService userGroupService,
      @Autowired final IDepartmentService departmentService) {

    this.sessionManager = sessionManager;
    this.usersService = usersService;
    this.companyService = companyService;
    this.userGroupService = userGroupService;
    this.departmentService = departmentService;
  }

  @Override
  public ProfileResponse getProfileByToken(final String token)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException {
    if (StringUtils.isEmpty(token)) {
      throw new ProfileCustomizedException("Invalid Token!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_TOKEN);
    }

    final UserAuthenticationSession session = this.sessionManager.findByToken(token);

    if (session == null) {
      throw new ProfileCustomizedException("Token is not authenticated!", "", EModule.PROFILE.getModuleName(),
          EIFlowErrorType.NO_SESSION_FOUND);
    }

    final User user = this.usersService.getUserByEmail(session.getEmail());

    if (user == null) {
      throw new ProfileCustomizedException("User not found!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.USER_NOTFOUND);
    }

    final Company company = this.companyService.getById(user.getCompanyId());

    if (company == null) {
      throw new ProfileCustomizedException("Company not found!", "", EModule.PROFILE.getModuleName(),
          EIFlowErrorType.COMPANY_NOTFOUND);
    }

    return new ProfileResponse(user, company, session.getSessionid());
  }

  @Override
  public ProfileResponse getProfileByTokenEmail(final String email, final String token)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException {
    if (StringUtils.isEmpty(token)) {
      throw new ProfileCustomizedException("Invalid Token!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_TOKEN);
    }

    final UserAuthenticationSession session = this.sessionManager.findByToken(token);

    if ((session == null) || (session.getEmail().equals(email) == false)) {
      throw new ProfileCustomizedException("Invalid session!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.NO_SESSION_FOUND);
    }

    final User user = this.usersService.getUserByEmail(session.getEmail());

    if (user == null) {
      throw new ProfileCustomizedException("User not found!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.USER_NOTFOUND);
    }

    final Company company = this.companyService.getById(user.getCompanyId());

    if (company == null) {
      throw new ProfileCustomizedException("Company not found!", "", EModule.PROFILE.getModuleName(),
          EIFlowErrorType.COMPANY_NOTFOUND);
    }

    return new ProfileResponse(user, company, session.getSessionid());
  }

  @Override
  public List<User> getUserListByToken(final String token, final Long companyId)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException {
    if (StringUtils.isEmpty(token)) {
      throw new ProfileCustomizedException("Invalid Token!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_TOKEN);
    }

    final ProfileResponse profile = getProfileByToken(token);

    if (profile.getCompany().getId() != companyId) {
      throw new ProfileCustomizedException("Invalid Company!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_COMPANY);
    }

    return usersService.getUserListByComaonyId(companyId);
  }

  @Override
  public List<UserGroup> getUserGroupListByToken(final String token, final Long companyId)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException {
    if (StringUtils.isEmpty(token)) {
      throw new ProfileCustomizedException("Invalid Token!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_TOKEN);
    }

    final ProfileResponse profile = getProfileByToken(token);

    if (profile.getCompany().getId() != companyId) {
      throw new ProfileCustomizedException("Invalid Company!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_COMPANY);
    }

    return userGroupService.getListByComaonyId(companyId);
  }

  @Override
  public List<Department> getDepartmentListByToken(final String token, final Long companyId)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException {
    if (StringUtils.isEmpty(token)) {
      throw new ProfileCustomizedException("Invalid Token!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_TOKEN);
    }

    final ProfileResponse profile = getProfileByToken(token);

    if (profile.getCompany().getId() != companyId) {
      throw new ProfileCustomizedException("Invalid Company!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_COMPANY);
    }

    return departmentService.getListByComaonyId(companyId);
  }

}

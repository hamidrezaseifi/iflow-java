package com.pth.iflow.profile.service.handler.impl;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserAuthenticationSession;
import com.pth.iflow.profile.model.UserGroup;
import com.pth.iflow.profile.service.access.ICompanyAccessService;
import com.pth.iflow.profile.service.access.IDepartmentAccessService;
import com.pth.iflow.profile.service.access.IUserGroupAccessService;
import com.pth.iflow.profile.service.access.IUsersAccessService;
import com.pth.iflow.profile.service.handler.ISessionManager;
import com.pth.iflow.profile.service.handler.ITokenUserDataManager;

@Service
public class TokenUserDataManager implements ITokenUserDataManager {

  private final ISessionManager sessionManager;

  private final IUsersAccessService usersService;

  private final ICompanyAccessService companyService;

  private final IUserGroupAccessService userGroupService;

  private final IDepartmentAccessService departmentService;

  public TokenUserDataManager(@Autowired final ISessionManager sessionManager,
      @Autowired final IUsersAccessService usersService,
      @Autowired final ICompanyAccessService companyService,
      @Autowired final IUserGroupAccessService userGroupService,
      @Autowired final IDepartmentAccessService departmentService) {

    this.sessionManager = sessionManager;
    this.usersService = usersService;
    this.companyService = companyService;
    this.userGroupService = userGroupService;
    this.departmentService = departmentService;
  }

  @Override
  public ProfileResponse getProfileByToken(final String appIdentity, final String token)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    final UserAuthenticationSession session = this.validateToken(token);

    final ProfileResponse profile = this.usersService.getUserProfileByIdentity(appIdentity, session.getUserIdentity());
    if (profile == null) {
      throw new ProfileCustomizedException("Profile not found!",
          "",
          EModule.PROFILE.getModuleName(),
          EIFlowErrorType.USERPROFILE_NOTFOUND);
    }
    profile.setSessionid(session.getSessionid());

    return profile;
  }

  @Override
  public ProfileResponse getProfileByTokenAndCheckCompany(final String appIdentity, final String token, final String companyIdentity)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    final ProfileResponse profile = this.getProfileByToken(appIdentity, token);

    if (profile.getCompanyProfile().getCompany().hasSameIdentity(companyIdentity) == false) {
      throw new ProfileCustomizedException("Invalid Company!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_COMPANY);
    }

    return profile;
  }

  @Override
  public ProfileResponse getProfileByTokenUserIdentity(final String appIdentity, final String userIdentity, final String token)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    if (StringUtils.isEmpty(token)) {
      throw new ProfileCustomizedException("Invalid Token!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_TOKEN);
    }

    final UserAuthenticationSession session = this.sessionManager.findByToken(token);

    if ((session == null) || (session.hasUserIdentity(userIdentity) == false)) {
      throw new ProfileCustomizedException("Invalid session!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.NO_SESSION_FOUND);
    }

    final ProfileResponse profile = this.usersService.getUserProfileByIdentity(appIdentity, session.getUserIdentity());
    if (profile == null) {
      throw new ProfileCustomizedException("Profile not found!",
          "",
          EModule.PROFILE.getModuleName(),
          EIFlowErrorType.USERPROFILE_NOTFOUND);
    }
    profile.setSessionid(session.getSessionid());

    return profile;
  }

  @Override
  public List<User> getUserListByToken(final String token, final String companyIdentity)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    this.validateTokenAndCompany(token, companyIdentity);

    return this.usersService.getUserListByCompanyIdentity(companyIdentity);
  }

  @Override
  public List<UserGroup> getUserGroupListByToken(final String token, final String companyIdentity)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    this.validateTokenAndCompany(token, companyIdentity);

    return this.userGroupService.getListByCompanyIdentity(companyIdentity);
  }

  @Override
  public List<Department> getDepartmentListByToken(final String token, final String companyIdentity)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    this.validateTokenAndCompany(token, companyIdentity);

    return this.departmentService.getListByCompanyIdentity(companyIdentity);
  }

  @Override
  public List<User> getAllUserListByDepartmentId(final String token, final String identity)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    this.validateToken(token);

    return this.departmentService.getAllUserListByDepartmentId(identity);
  }

  @Override
  public UserAuthenticationSession validateToken(final String token) throws ProfileCustomizedException {

    if (StringUtils.isEmpty(token)) {
      throw new ProfileCustomizedException("Invalid Token!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_TOKEN);
    }

    final UserAuthenticationSession session = this.sessionManager.findByToken(token);

    if (session == null) {
      throw new ProfileCustomizedException("Token is not authenticated!",
          "",
          EModule.PROFILE.getModuleName(),
          EIFlowErrorType.NO_SESSION_FOUND);
    }

    if (session.isValid() == Boolean.FALSE) {

      this.sessionManager.removeAllExpiredSessions();
      throw new ProfileCustomizedException("Token is not authenticated!",
          "",
          EModule.PROFILE.getModuleName(),
          EIFlowErrorType.NO_SESSION_FOUND);
    }

    return session;
  }

  @Override
  public void validateTokenAndCompany(final String token, final String companyIdentity)
      throws ProfileCustomizedException, IFlowMessageConversionFailureException {

    final UserAuthenticationSession session = this.validateToken(token);

    if (session.hasCompanyIdentity(companyIdentity) == false) {
      throw new ProfileCustomizedException("Company not found!",
          "",
          EModule.PROFILE.getModuleName(),
          EIFlowErrorType.COMPANY_NOTFOUND);
    }

  }

}

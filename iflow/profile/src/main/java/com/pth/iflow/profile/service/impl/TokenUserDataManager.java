package com.pth.iflow.profile.service.impl;

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
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.DepartmentGroup;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserAuthenticationSession;
import com.pth.iflow.profile.model.UserGroup;
import com.pth.iflow.profile.service.ICompanyService;
import com.pth.iflow.profile.service.IDepartmentGroupService;
import com.pth.iflow.profile.service.IDepartmentService;
import com.pth.iflow.profile.service.ISessionManager;
import com.pth.iflow.profile.service.ITokenUserDataManager;
import com.pth.iflow.profile.service.IUserGroupService;
import com.pth.iflow.profile.service.IUsersService;

@Service
public class TokenUserDataManager implements ITokenUserDataManager {

  private final ISessionManager sessionManager;

  private final IUsersService usersService;

  private final ICompanyService companyService;

  private final IUserGroupService userGroupService;

  private final IDepartmentService departmentService;

  private final IDepartmentGroupService departmentGroupService;

  public TokenUserDataManager(@Autowired final ISessionManager sessionManager,
                              @Autowired final IUsersService usersService,
                              @Autowired final ICompanyService companyService,
                              @Autowired final IUserGroupService userGroupService,
                              @Autowired final IDepartmentService departmentService,
                              @Autowired final IDepartmentGroupService departmentGroupService) {

    this.sessionManager = sessionManager;
    this.usersService = usersService;
    this.companyService = companyService;
    this.userGroupService = userGroupService;
    this.departmentService = departmentService;
    this.departmentGroupService = departmentGroupService;
  }

  @Override
  public ProfileResponse getProfileByToken(final String token) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {
    final UserAuthenticationSession session = this.validateToken(token);

    final User user = this.usersService.getUserByEmail(session.getEmail());

    if (user == null) {
      throw new ProfileCustomizedException("User not found!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.USER_NOTFOUND);
    }

    final Company company = this.companyService.getByIdentity(user.getCompanyIdentity());

    if (company == null) {
      throw new ProfileCustomizedException("Company not found!",
                                           "",
                                           EModule.PROFILE.getModuleName(),
                                           EIFlowErrorType.COMPANY_NOTFOUND);
    }

    final List<Department> departmentList = this.departmentService.getListByCompanyIdentity(user.getCompanyIdentity());
    final List<UserGroup> groupList = this.userGroupService.getListByCompanyIdentity(user.getCompanyIdentity());

    return new ProfileResponse(user, company, departmentList, groupList, session.getSessionid());
  }

  @Override
  public ProfileResponse getProfileByTokenAndCheckCompany(final String token, final String companyIdentity) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {
    final ProfileResponse profile = this.getProfileByToken(token);

    if (profile.getCompanyProfile().getCompany().hasSameIdentity(companyIdentity) == false) {
      throw new ProfileCustomizedException("Invalid Company!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_COMPANY);
    }

    return profile;
  }

  @Override
  public ProfileResponse getProfileByTokenEmail(final String email, final String token) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {
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

    final Company company = this.companyService.getByIdentity(user.getCompanyIdentity());

    if (company == null) {
      throw new ProfileCustomizedException("Company not found!",
                                           "",
                                           EModule.PROFILE.getModuleName(),
                                           EIFlowErrorType.COMPANY_NOTFOUND);
    }

    final List<Department> departmentList = this.departmentService.getListByCompanyIdentity(user.getCompanyIdentity());
    final List<UserGroup> groupList = this.userGroupService.getListByCompanyIdentity(user.getCompanyIdentity());

    return new ProfileResponse(user, company, departmentList, groupList, session.getSessionid());
  }

  @Override
  public List<User> getUserListByToken(final String token, final String companyId) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    this.getProfileByTokenAndCheckCompany(token, companyId);

    return this.usersService.getUserListByCompanyIdentity(companyId);
  }

  @Override
  public List<UserGroup> getUserGroupListByToken(final String token, final String companyId) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    this.getProfileByTokenAndCheckCompany(token, companyId);

    return this.userGroupService.getListByCompanyIdentity(companyId);
  }

  @Override
  public List<Department> getDepartmentListByToken(final String token, final String companyId) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    this.getProfileByTokenAndCheckCompany(token, companyId);

    return this.departmentService.getListByCompanyIdentity(companyId);
  }

  @Override
  public Department getDepartmentById(final String token, final String identity) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    this.validateToken(token);

    return this.departmentService.getByIdentity(identity);
  }

  @Override
  public List<DepartmentGroup> getDepartmentGroupListByDepartmentId(final String token, final String identity) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    this.validateToken(token);

    return this.departmentService.getDepartmentGroupListByDepartmentId(identity);
  }

  @Override
  public List<User> getAllUserListByDepartmentId(final String token, final String identity) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    this.validateToken(token);

    return this.departmentService.getAllUserListByDepartmentId(identity);
  }

  @Override
  public DepartmentGroup getDepartmentGroupById(final String token, final String identity) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    this.validateToken(token);

    return this.departmentGroupService.getByIdentity(identity);
  }

  @Override
  public List<User> getAllUserListByDepartmentGroupId(final String token, final String identity) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException {

    this.validateToken(token);

    return this.departmentGroupService.getAllUserListByDepartmentGroupId(identity);
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

}

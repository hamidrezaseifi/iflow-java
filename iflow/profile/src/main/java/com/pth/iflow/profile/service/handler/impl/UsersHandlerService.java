package com.pth.iflow.profile.service.handler.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.enums.EUserDepartmentMemberType;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserDepartment;
import com.pth.iflow.profile.model.UserDepartmentGroup;
import com.pth.iflow.profile.service.access.IDepartmentAccessService;
import com.pth.iflow.profile.service.access.IDepartmentGroupAccessService;
import com.pth.iflow.profile.service.access.IUsersAccessService;
import com.pth.iflow.profile.service.handler.IUsersHandlerService;

@Service
public class UsersHandlerService implements IUsersHandlerService {

  private final IUsersAccessService usersService;
  private final IDepartmentAccessService departmentAccessService;
  private final IDepartmentGroupAccessService departmentGroupAccessService;

  public UsersHandlerService(@Autowired final IUsersAccessService usersService,
      @Autowired final IDepartmentAccessService departmentAccessService,
      @Autowired final IDepartmentGroupAccessService departmentGroupAccessService) {

    this.usersService = usersService;
    this.departmentAccessService = departmentAccessService;
    this.departmentGroupAccessService = departmentGroupAccessService;
  }

  @Override
  public User getUserByIdentity(final String identity)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    return this.usersService.getUserByIdentity(identity);
  }

  @Override
  public List<User> getUserListByCompanyIdentity(final String companyId)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    return this.usersService.getUserListByCompanyIdentity(companyId);
  }

  @Override
  public ProfileResponse getUserProfileByIdentity(final String email)
      throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    return this.usersService.getUserProfileByIdentity(email);
  }

  @Override
  public User saveUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    this.verifayDepartmentManager(user);

    this.verifyDepartmentDeputy(user);

    this.verifyDepartmentrGroupManager(user);

    this.verifyDepartmentrGroupDeputy(user);

    return this.usersService.saveUser(user);
  }

  @Override
  public void deleteUser(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    this.usersService.deleteUser(user);

  }

  private void verifyDepartmentrGroupManager(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    final List<String> departmentGroupIdentityWithManagerMemberType = this
        .findDepartmentGroupsWithMemberType(user, EUserDepartmentMemberType.MANAGER);

    for (final String identity : departmentGroupIdentityWithManagerMemberType) {
      final User manager = this.departmentGroupAccessService.getDepartmentGroupManager(identity);
      if (manager != null && manager.hasNotSameIdentity(user.getIdentity())) {
        throw new ProfileCustomizedException("Manager for departmentgroup exists!", "", EModule.PROFILE.getModuleName(),
            EIFlowErrorType.PROFILE_MANAGER_FOR_DEPARTMENTGROUP_EXISTS);
      }
    }
  }

  private void verifyDepartmentrGroupDeputy(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    final List<String> departmentGroupIdentityWithDeputyMemberType = this
        .findDepartmentGroupsWithMemberType(user, EUserDepartmentMemberType.DEPUTY);

    for (final String identity : departmentGroupIdentityWithDeputyMemberType) {
      final User deputy = this.departmentGroupAccessService.getDepartmentGroupDeputy(identity);
      if (deputy != null && deputy.hasNotSameIdentity(user.getIdentity())) {
        throw new ProfileCustomizedException("Deputy for departmentgroup exists!", "", EModule.PROFILE.getModuleName(),
            EIFlowErrorType.PROFILE_DEPUTY_FOR_DEPARTMENTGROUP_EXISTS);
      }
    }
  }

  private void verifyDepartmentDeputy(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    final List<String> departmentIdentityWithDeputyMemberType = this.findDepartmentsWithMemberType(user, EUserDepartmentMemberType.DEPUTY);
    for (final String identity : departmentIdentityWithDeputyMemberType) {
      final User manager = this.departmentAccessService.getDepartmentDeputy(identity);
      if (manager != null && manager.hasNotSameIdentity(user.getIdentity())) {
        throw new ProfileCustomizedException("Deputy for department exists!", "", EModule.PROFILE.getModuleName(),
            EIFlowErrorType.PROFILE_DEPUTY_FOR_DEPARTMENT_EXISTS);
      }
    }
  }

  private void verifayDepartmentManager(final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    final List<
        String> departmentIdentityWithManagerMemberType = this.findDepartmentsWithMemberType(user, EUserDepartmentMemberType.MANAGER);
    for (final String identity : departmentIdentityWithManagerMemberType) {
      final User manager = this.departmentAccessService.getDepartmentManager(identity);
      if (manager != null && manager.hasNotSameIdentity(user.getIdentity())) {
        throw new ProfileCustomizedException("Manager for department exists!", "", EModule.PROFILE.getModuleName(),
            EIFlowErrorType.PROFILE_MANAGER_FOR_DEPARTMENT_EXISTS);
      }
    }
  }

  private List<String> findDepartmentsWithMemberType(final User user, final EUserDepartmentMemberType memberType) {

    final List<String> departmentIdentityWithManagerMemberType = new ArrayList<>();
    for (final UserDepartment userDepartment : user.getUserDepartments()) {
      if (userDepartment.getMemberType() == memberType) {
        departmentIdentityWithManagerMemberType.add(userDepartment.getDepartmentIdentity());
      }
    }
    return departmentIdentityWithManagerMemberType;
  }

  private List<String> findDepartmentGroupsWithMemberType(final User user, final EUserDepartmentMemberType memberType) {

    final List<String> departmentGroupIdentityWithManagerMemberType = new ArrayList<>();
    for (final UserDepartmentGroup userDepartmentGroup : user.getUserDepartmentGroups()) {
      if (userDepartmentGroup.getMemberType() == memberType) {
        departmentGroupIdentityWithManagerMemberType.add(userDepartmentGroup.getDepartmentGroupIdentity());
      }
    }
    return departmentGroupIdentityWithManagerMemberType;
  }

}

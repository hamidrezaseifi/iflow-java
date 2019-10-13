package com.pth.iflow.profile;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pth.iflow.common.edo.models.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.edo.models.CompanyEdo;
import com.pth.iflow.common.edo.models.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.TokenProfileRequestEdo;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.CompanyProfile;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.DepartmentGroup;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserAuthenticationRequest;
import com.pth.iflow.profile.model.UserAuthenticationSession;
import com.pth.iflow.profile.model.UserGroup;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;

public class TestDataProducer {

  protected Company getTestCompany() {
    final Company company = new Company();
    company.setCompanyName("companyName");
    company.setIdentity("identifyid");
    company.setStatus(1);
    company.setVersion(1);

    return company;
  }

  protected CompanyProfile getTestCompanyProfile() {

    final CompanyProfile companyProfile = new CompanyProfile(this.getTestCompany(), this.getTestDepartmentList(),
        this.getTestUserGroupList());

    return companyProfile;
  }

  protected User getTestUser() {
    final User model = new User();
    model.setCompanyIdentity("companyIdentity");
    model.setEmail("email");
    model.setBirthDate(LocalDate.now());
    model.setFirstName("firstName");
    model.setLastName("lastName");
    model.setStatus(1);
    model.setVersion(1);
    model.setPermission(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupIdSet());
    model.setDepartments(this.getTestDepartmentIdSet());
    model.setDeputies(this.getTestDeputiyIdSet());
    model.setGroups(this.getTestUserGroupIdSet());
    model.setCompanyIdentity("companyIdentity");

    return model;
  }

  protected User getTestUser(final String fname, final String lname, final String email) {
    final User model = new User();
    model.setCompanyIdentity("companyIdentity");
    model.setCompanyIdentity("companyIdentity");
    model.setEmail(email);
    model.setBirthDate(LocalDate.now());
    model.setFirstName(fname);
    model.setLastName(lname);
    model.setStatus(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupIdSet());
    model.setDepartments(this.getTestDepartmentIdSet());
    model.setDeputies(this.getTestDeputiyIdSet());
    model.setGroups(this.getTestUserGroupIdSet());

    return model;
  }

  protected List<User> getTestUserList() {
    final List<User> list = Arrays.asList(this.getTestUser("fname 1", "lname 1", "email 1"),
        this.getTestUser("fname 2", "lname 2", "email 2"), this.getTestUser("fname 3", "lname 3", "email 3"));

    return list;
  }

  protected UserGroup getTestUserGroup(final String identity, final String title) {
    final UserGroup model = new UserGroup();
    model.setCompanyIdentity("companyIdentity");
    model.setIdentity(identity);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected UserGroup getTestUserGroup() {
    final UserGroup model = new UserGroup();
    model.setCompanyIdentity("companyIdentity");
    model.setIdentity("identity");
    model.setTitle("title");
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected List<UserGroup> getTestUserGroupList() {
    final List<UserGroup> list = Arrays.asList(this.getTestUserGroup("usergrp1", "UserGroup 1"),
        this.getTestUserGroup("usergrp2", "UserGroup 2"), this.getTestUserGroup("usergrp3", "UserGroup 3"));

    return list;
  }

  protected Department getTestDepartment(final String identity, final String title) {
    final Department model = new Department();
    model.setCompanyIdentity("companyIdentity");
    model.setIdentity(identity);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupList());

    return model;
  }

  protected List<DepartmentGroup> getTestDepartmentGroupList() {
    final List<DepartmentGroup> list = Arrays.asList(this.getTestDepartmentGroup("depgrp1", "DepartmentGroup 1"),
        this.getTestDepartmentGroup("depgrp2", "DepartmentGroup 2"), this.getTestDepartmentGroup("depgrp3", "DepartmentGroup 3"));

    return list;
  }

  protected DepartmentGroup getTestDepartmentGroup(final String identity, final String title) {
    final DepartmentGroup model = new DepartmentGroup();
    model.setDepartmentIdentity("departmentIdentity");
    model.setIdentity(identity);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected UserAuthenticationSession getTestUserAuthenticationSession() {
    final UserAuthenticationSession model = new UserAuthenticationSession(this.getSessionMaxAgeInSeconds());

    model.setEmail("email");
    model.setSessionid("sessionid");
    model.setToken("token");

    return model;
  }

  protected AuthenticatedProfileRequestEdo getTestAuthenticatedProfileRequestEdo() {
    final AuthenticatedProfileRequestEdo model = new AuthenticatedProfileRequestEdo();
    model.setEmail("");
    model.setToken("token");

    return model;
  }

  protected TokenProfileRequestEdo getTokenProfileRequestEdo(final String email) {
    final TokenProfileRequestEdo model = new TokenProfileRequestEdo();
    model.setToken(email);

    return model;
  }

  protected ProfileResponseEdo getTestProfileResponseEdo(final String sessionid, final UserEdo user, final CompanyEdo company) {
    final ProfileResponseEdo model = new ProfileResponseEdo();
    model.setCompanyProfile(ProfileModelEdoMapper.toEdo(this.getTestCompanyProfile()));
    model.setSessionid(sessionid);
    model.setUser(user);

    return model;
  }

  protected AuthenticatedProfileRequestEdo getTestAuthenticatedProfileRequestEdo(final String email, final String token) {
    final AuthenticatedProfileRequestEdo model = new AuthenticatedProfileRequestEdo();
    model.setEmail(email);
    model.setToken(token);

    return model;
  }

  protected UserAuthenticationRequest getTestUserAuthenticationRequest() {
    final UserAuthenticationRequest model = new UserAuthenticationRequest();
    model.setCompanyIdentity("companyIdentity");
    model.setPassword("password");
    model.setEmail("email");

    return model;
  }

  protected List<Department> getTestDepartmentList() {
    final List<Department> list = Arrays.asList(this.getTestDepartment("dep1", "Department 1"),
        this.getTestDepartment("dep2", "Department 2"), this.getTestDepartment("dep3", "Department 3"));

    return list;
  }

  protected int getSessionMaxAgeInSeconds() {
    return 1000;
  }

  protected Set<String> getTestUserGroupIdSet() {
    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

  protected Set<String> getTestDepartmentIdSet() {
    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

  protected Set<String> getTestDepartmentGroupIdSet() {
    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

  protected Set<String> getTestDeputiyIdSet() {
    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

  protected Set<String> getTestUserIdSet() {
    return new HashSet<>(Arrays.asList("identity1", "identity2", "identity3"));
  }

}

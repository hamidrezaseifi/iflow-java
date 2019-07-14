package com.pth.ifow.profile;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.pth.iflow.common.edo.models.xml.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.edo.models.xml.CompanyEdo;
import com.pth.iflow.common.edo.models.xml.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.xml.TokenProfileRequestEdo;
import com.pth.iflow.common.edo.models.xml.UserEdo;
import com.pth.ifow.profile.model.Company;
import com.pth.ifow.profile.model.Department;
import com.pth.ifow.profile.model.DepartmentGroup;
import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.model.UserAuthenticationRequest;
import com.pth.ifow.profile.model.UserAuthenticationSession;
import com.pth.ifow.profile.model.UserGroup;

public class TestDataProducer {

  protected Company getTestCompany() {
    final Company company = new Company();
    company.setCompanyName("companyName");
    company.setId(1L);
    company.setIdentifyid("identifyid");
    company.setStatus(1);
    company.setVersion(1);

    return company;
  }

  protected UserGroup getTestUserGroup() {
    final UserGroup model = new UserGroup();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected UserGroup getTestUserGroup(final Long id, final String title) {
    final UserGroup model = new UserGroup();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected List<UserGroup> getTestUserGroupList() {
    final List<UserGroup> list = Arrays.asList(this.getTestUserGroup(1L, "UserGroup 1"), this.getTestUserGroup(2L, "UserGroup 2"),
        this.getTestUserGroup(3L, "UserGroup 3"));

    return list;
  }

  protected User getTestUser() {
    final User model = new User();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setEmail("email");
    model.setBirthDate(new Date());
    model.setFirstName("firstName");
    model.setLastName("lastName");
    model.setStatus(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupIdList());
    model.setDepartments(this.getTestDepartmentIdList());
    model.setDeputies(this.getTestDeputiyIdList());
    model.setGroups(this.getTestUserGroupIdList());

    return model;
  }

  protected User getTestUser(final Long id, final String fname, final String lname, final String email) {
    final User model = new User();
    model.setCompanyId(1L);
    model.setId(id);
    model.setEmail(email);
    model.setBirthDate(new Date());
    model.setFirstName(fname);
    model.setLastName(lname);
    model.setStatus(1);
    model.setDepartmentGroups(this.getTestDepartmentGroupIdList());
    model.setDepartments(this.getTestDepartmentIdList());
    model.setDeputies(this.getTestDeputiyIdList());
    model.setGroups(this.getTestUserGroupIdList());

    return model;
  }

  protected Department getTestDepartment() {
    final Department model = new Department();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);
    model.setGroups(this.getTestDepartmentGroupIdList());

    return model;
  }

  protected Department getTestDepartment(final Long id, final String title) {
    final Department model = new Department();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setGroups(this.getTestDepartmentGroupIdList());

    return model;
  }

  protected List<Department> getTestDepartmentList() {
    final List<Department> list = Arrays.asList(this.getTestDepartment(1L, "Department 1"), this.getTestDepartment(2L, "Department 2"),
        this.getTestDepartment(3L, "Department 3"));

    return list;
  }

  protected DepartmentGroup getTestDepartmentGroup() {
    final DepartmentGroup model = new DepartmentGroup();
    model.setDepartmentId(1L);
    model.setId(1L);
    model.setTitle("utest title");
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected DepartmentGroup getTestDepartmentGroup(final Long id, final String title) {
    final DepartmentGroup model = new DepartmentGroup();
    model.setDepartmentId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }

  protected List<DepartmentGroup> getTestDepartmentGroupList() {
    final List<DepartmentGroup> list = Arrays.asList(this.getTestDepartmentGroup(1L, "DepartmentGroup 1"),
        this.getTestDepartmentGroup(2L, "DepartmentGroup 2"), this.getTestDepartmentGroup(3L, "DepartmentGroup 3"));

    return list;
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
    model.setCompany(company);
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

  protected int getSessionMaxAgeInSeconds() {
    return 1000;
  }

  protected List<User> getTestUserList() {
    final List<User> list = Arrays.asList(this.getTestUser(1L, "fname 1", "lname 1", "email 1"),
        this.getTestUser(2L, "fname 2", "lname 2", "email 2"), this.getTestUser(3L, "fname 3", "lname 3", "email 3"));

    return list;
  }

  protected List<Long> getTestUserIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestDepartmentGroupIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestDepartmentIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestDeputiyIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

  protected List<Long> getTestUserGroupIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

}

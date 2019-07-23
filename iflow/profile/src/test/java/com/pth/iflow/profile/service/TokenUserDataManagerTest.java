package com.pth.iflow.profile.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.Department;
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
import com.pth.iflow.profile.service.impl.TokenUserDataManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenUserDataManagerTest extends TestDataProducer {

  private ITokenUserDataManager     tokenUserDataManager;

  @Autowired
  private ISessionManager           sessionManager;

  @Mock
  private IUsersService             usersService;

  @Mock
  private ICompanyService           companyService;

  @Mock
  private IUserGroupService         userGroupService;

  @Mock
  private IDepartmentService        departmentService;

  @Mock
  private IDepartmentGroupService   departmentGroupService;

  private String                    validToken;

  private final String              validEmail   = "valid-email";

  private UserAuthenticationSession validSession;

  private Company                   validCompany;

  private User                      validUser;

  private final String              inValidToken = "invalid-token";

  private final String              inValidEmail = "invalid-email";

  @Before
  public void setUp() throws Exception {

    this.tokenUserDataManager = new TokenUserDataManager(this.sessionManager, this.usersService, this.companyService,
        this.userGroupService, this.departmentService, this.departmentGroupService);

    this.validSession = this.sessionManager.addSession(this.validEmail);
    this.validToken = this.validSession.getToken();

    this.validCompany = this.getTestCompany();
    this.validUser = this.getTestUser(1L, "userfn", "userln", this.validEmail);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test(expected = ProfileCustomizedException.class)
  public void testGetProfileByTokenEmptyToken() throws Exception {

    this.tokenUserDataManager.getProfileByToken("");

  }

  @Test(expected = ProfileCustomizedException.class)
  public void testGetProfileByTokenInvalidToken() throws Exception {

    this.tokenUserDataManager.getProfileByToken(this.inValidToken);

  }

  @Test
  public void testGetProfileByTokenEmail() throws Exception {

    when(this.usersService.getUserByEmail(any(String.class))).thenReturn(this.validUser);
    when(this.companyService.getById(any(Long.class))).thenReturn(this.validCompany);

    final ProfileResponse response = this.tokenUserDataManager.getProfileByToken(this.validToken);

    verify(this.usersService, times(1)).getUserByEmail(any(String.class));
    verify(this.companyService, times(1)).getById(any(Long.class));

    Assert.assertNotNull("Result response is not null!", response);
    Assert.assertNotNull("Result user is not null!", response.getUser());
    Assert.assertNotNull("Result company is not null!", response.getCompany());
    Assert.assertEquals("Result user has the same id as valid-user!", response.getUser().getId(), this.validUser.getId());
    Assert.assertEquals("Result company has the same id as valid-company!", response.getCompany().getId(), this.validCompany.getId());

    Assert.assertEquals("Result user has the same name as valid-user!",
        response.getUser().getFirstName() + response.getUser().getLastName(),
        this.validUser.getFirstName() + this.validUser.getLastName());
    Assert.assertEquals("Result company has the same name as valid-company!", response.getCompany().getCompanyName(),
        this.validCompany.getCompanyName());

  }

  @Test
  public void testGetUserListByToken() throws Exception {

    final List<User> users = this.getTestUserList();

    when(this.usersService.getUserListByComaonyId(any(Long.class))).thenReturn(users);
    when(this.usersService.getUserByEmail(any(String.class))).thenReturn(this.validUser);

    when(this.companyService.getById(any(Long.class))).thenReturn(this.validCompany);

    final List<User> resultUsers = this.tokenUserDataManager.getUserListByToken(this.validToken, 1L);

    verify(this.usersService, times(1)).getUserByEmail(any(String.class));
    verify(this.usersService, times(1)).getUserListByComaonyId(any(Long.class));
    verify(this.companyService, times(1)).getById(any(Long.class));

    Assert.assertNotNull("Result response list is not null!", resultUsers);
    Assert.assertEquals("Result response list has the " + users.size() + " items!", resultUsers.size(), users.size());

  }

  @Test
  public void testGetUserGroupListByToken() throws Exception {

    final List<UserGroup> userGroups = this.getTestUserGroupList();

    when(this.userGroupService.getListByComaonyId(any(Long.class))).thenReturn(userGroups);
    when(this.usersService.getUserByEmail(any(String.class))).thenReturn(this.validUser);
    when(this.companyService.getById(any(Long.class))).thenReturn(this.validCompany);

    final List<UserGroup> resultUserGroups = this.tokenUserDataManager.getUserGroupListByToken(this.validToken, 1L);

    verify(this.usersService, times(1)).getUserByEmail(any(String.class));
    verify(this.userGroupService, times(1)).getListByComaonyId(any(Long.class));
    verify(this.companyService, times(1)).getById(any(Long.class));

    Assert.assertNotNull("Result response list is not null!", resultUserGroups);
    Assert.assertEquals("Result response list has the " + userGroups.size() + " items!", resultUserGroups.size(), userGroups.size());

  }

  @Test
  public void testGetDepartmentListByToken() throws Exception {
    final List<Department> departments = this.getTestDepartmentList();

    when(this.departmentService.getListByCompanyId(any(Long.class))).thenReturn(departments);
    when(this.usersService.getUserByEmail(any(String.class))).thenReturn(this.validUser);
    when(this.companyService.getById(any(Long.class))).thenReturn(this.validCompany);

    final List<Department> resultDepartments = this.tokenUserDataManager.getDepartmentListByToken(this.validToken, 1L);

    verify(this.usersService, times(1)).getUserByEmail(any(String.class));
    verify(this.departmentService, times(1)).getListByCompanyId(any(Long.class));
    verify(this.companyService, times(1)).getById(any(Long.class));

    Assert.assertNotNull("Result response list is not null!", resultDepartments);
    Assert.assertEquals("Result response list has the " + departments.size() + " items!", resultDepartments.size(),
        departments.size());
  }

}

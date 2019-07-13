package com.pth.ifow.profile.service;

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

import com.pth.ifow.profile.TestDataProducer;
import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.Company;
import com.pth.ifow.profile.model.Department;
import com.pth.ifow.profile.model.ProfileResponse;
import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.model.UserAuthenticationSession;
import com.pth.ifow.profile.model.UserGroup;
import com.pth.ifow.profile.service.impl.TokenUserDataManager;

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
        this.userGroupService, this.departmentService);

    this.validSession = this.sessionManager.addSession(validEmail);
    this.validToken = this.validSession.getToken();

    this.validCompany = getTestCompany();
    this.validUser = getTestUser(1L, "userfn", "userln", validEmail);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test(expected = ProfileCustomizedException.class)
  public void testGetProfileByTokenEmptyToken() throws Exception {

    tokenUserDataManager.getProfileByToken("");

  }

  @Test(expected = ProfileCustomizedException.class)
  public void testGetProfileByTokenInvalidToken() throws Exception {

    tokenUserDataManager.getProfileByToken(inValidToken);

  }

  @Test
  public void testGetProfileByTokenEmail() throws Exception {

    when(this.usersService.getUserByEmail(any(String.class))).thenReturn(validUser);
    when(this.companyService.getById(any(Long.class))).thenReturn(validCompany);

    final ProfileResponse response = tokenUserDataManager.getProfileByToken(validToken);

    verify(this.usersService, times(1)).getUserByEmail(any(String.class));
    verify(this.companyService, times(1)).getById(any(Long.class));

    Assert.assertNotNull("Result response is not null!", response);
    Assert.assertNotNull("Result user is not null!", response.getUser());
    Assert.assertNotNull("Result company is not null!", response.getCompany());
    Assert.assertEquals("Result user has the same id as valid-user!", response.getUser().getId(), validUser.getId());
    Assert.assertEquals("Result company has the same id as valid-company!", response.getCompany().getId(), validCompany.getId());

    Assert.assertEquals("Result user has the same name as valid-user!",
        response.getUser().getFirstName() + response.getUser().getLastName(), validUser.getFirstName() + validUser.getLastName());
    Assert.assertEquals("Result company has the same name as valid-company!", response.getCompany().getCompanyName(),
        validCompany.getCompanyName());

  }

  @Test
  public void testGetUserListByToken() throws Exception {

    final List<User> users = getTestUserList();

    when(this.usersService.getUserListByComaonyId(any(Long.class))).thenReturn(users);
    when(this.usersService.getUserByEmail(any(String.class))).thenReturn(validUser);

    when(this.companyService.getById(any(Long.class))).thenReturn(validCompany);

    final List<User> resultUsers = tokenUserDataManager.getUserListByToken(validToken, 1L);

    verify(this.usersService, times(1)).getUserByEmail(any(String.class));
    verify(this.usersService, times(1)).getUserListByComaonyId(any(Long.class));
    verify(this.companyService, times(1)).getById(any(Long.class));

    Assert.assertNotNull("Result response list is not null!", resultUsers);
    Assert.assertEquals("Result response list has the " + users.size() + " items!", resultUsers.size(), users.size());

  }

  @Test
  public void testGetUserGroupListByToken() throws Exception {

    final List<UserGroup> userGroups = getTestUserGroupList();

    when(this.userGroupService.getListByComaonyId(any(Long.class))).thenReturn(userGroups);
    when(this.usersService.getUserByEmail(any(String.class))).thenReturn(validUser);
    when(this.companyService.getById(any(Long.class))).thenReturn(validCompany);

    final List<UserGroup> resultUserGroups = tokenUserDataManager.getUserGroupListByToken(validToken, 1L);

    verify(this.usersService, times(1)).getUserByEmail(any(String.class));
    verify(this.userGroupService, times(1)).getListByComaonyId(any(Long.class));
    verify(this.companyService, times(1)).getById(any(Long.class));

    Assert.assertNotNull("Result response list is not null!", resultUserGroups);
    Assert.assertEquals("Result response list has the " + userGroups.size() + " items!", resultUserGroups.size(), userGroups.size());

  }

  @Test
  public void testGetDepartmentListByToken() throws Exception {
    final List<Department> departments = getTestDepartmentList();

    when(this.departmentService.getListByComaonyId(any(Long.class))).thenReturn(departments);
    when(this.usersService.getUserByEmail(any(String.class))).thenReturn(validUser);
    when(this.companyService.getById(any(Long.class))).thenReturn(validCompany);

    final List<Department> resultDepartments = tokenUserDataManager.getDepartmentListByToken(validToken, 1L);

    verify(this.usersService, times(1)).getUserByEmail(any(String.class));
    verify(this.departmentService, times(1)).getListByComaonyId(any(Long.class));
    verify(this.companyService, times(1)).getById(any(Long.class));

    Assert.assertNotNull("Result response list is not null!", resultDepartments);
    Assert.assertEquals("Result response list has the " + departments.size() + " items!", resultDepartments.size(),
        departments.size());
  }

}

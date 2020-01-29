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
import com.pth.iflow.profile.service.access.ICompanyAccessService;
import com.pth.iflow.profile.service.access.IDepartmentAccessService;
import com.pth.iflow.profile.service.access.IUserGroupAccessService;
import com.pth.iflow.profile.service.access.IUsersAccessService;
import com.pth.iflow.profile.service.handler.ISessionManager;
import com.pth.iflow.profile.service.handler.ITokenUserDataManager;
import com.pth.iflow.profile.service.handler.impl.TokenUserDataManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenUserDataManagerTest extends TestDataProducer {

  private ITokenUserDataManager tokenUserDataManager;

  @Autowired
  private ISessionManager sessionManager;

  @Mock
  private IUsersAccessService usersService;

  @Mock
  private ICompanyAccessService companyService;

  @Mock
  private IUserGroupAccessService userGroupService;

  @Mock
  private IDepartmentAccessService departmentService;

  private String validToken;

  private final String validEmail = "valid-email";

  private final String validCompanyIdentity = "valid-company";

  private UserAuthenticationSession validSession;

  private Company validCompany;

  private User validUser;

  private final String inValidToken = "invalid-token";

  @Before
  public void setUp() throws Exception {

    this.tokenUserDataManager = new TokenUserDataManager(this.sessionManager, this.usersService, this.companyService,
        this.userGroupService, this.departmentService);

    this.validSession = this.sessionManager.addSession(this.validEmail, this.validCompanyIdentity);
    this.validToken = this.validSession.getToken();

    this.validCompany = this.getTestCompany();
    this.validUser = this.getTestUser("userfn", "userln", this.validEmail);

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

    final ProfileResponse profile = this.getTestProfileResponse(this.validSession.getSessionid());

    when(this.usersService.getUserProfileByIdentity(any(String.class))).thenReturn(profile);

    final ProfileResponse response = this.tokenUserDataManager.getProfileByToken(this.validToken);

    verify(this.usersService, times(1)).getUserProfileByIdentity(any(String.class));

    Assert.assertNotNull("Result response is not null!", response);
    Assert.assertNotNull("Result user is not null!", response.getUser());
    Assert.assertNotNull("Result company is not null!", response.getCompanyProfile());
    Assert
        .assertEquals("Result user has the same id as valid-user!", response.getUser().getIdentity(),
            profile.getUser().getIdentity());
    Assert
        .assertEquals("Result company has the same id as valid-company!", response.getCompanyProfile().getCompany().getIdentity(),
            profile.getCompanyProfile().getCompany().getIdentity());

    Assert
        .assertEquals("Result user has the same name as valid-user!",
            response.getUser().getFirstName() + response.getUser().getLastName(),
            profile.getUser().getFirstName() + profile.getUser().getLastName());
    Assert
        .assertEquals("Result company has the same name as valid-company!",
            response.getCompanyProfile().getCompany().getCompanyName(), profile.getCompanyProfile().getCompany().getCompanyName());

  }

  @Test
  public void testGetUserListByToken() throws Exception {

    final List<User> users = this.getTestUserList();

    when(this.usersService.getUserListByCompanyIdentity(any(String.class))).thenReturn(users);

    final List<User> resultUsers = this.tokenUserDataManager.getUserListByToken(this.validToken, this.validCompanyIdentity);

    verify(this.usersService, times(1)).getUserListByCompanyIdentity(any(String.class));

    Assert.assertNotNull("Result response list is not null!", resultUsers);
    Assert.assertEquals("Result response list has the " + users.size() + " items!", resultUsers.size(), users.size());

  }

  @Test
  public void testGetUserGroupListByToken() throws Exception {

    final List<UserGroup> userGroups = this.getTestUserGroupList();

    when(this.userGroupService.getListByCompanyIdentity(any(String.class))).thenReturn(userGroups);

    final List<UserGroup> resultUserGroups = this.tokenUserDataManager
        .getUserGroupListByToken(this.validToken,
            this.validCompanyIdentity);

    verify(this.userGroupService, times(1)).getListByCompanyIdentity(any(String.class));

    Assert.assertNotNull("Result response list is not null!", resultUserGroups);
    Assert.assertEquals("Result response list has the " + userGroups.size() + " items!", resultUserGroups.size(), userGroups.size());

  }

  @Test
  public void testGetDepartmentListByToken() throws Exception {

    final List<Department> departments = this.getTestDepartmentList();

    when(this.departmentService.getListByCompanyIdentity(any(String.class))).thenReturn(departments);

    final List<Department> resultDepartments = this.tokenUserDataManager
        .getDepartmentListByToken(this.validToken,
            this.validCompanyIdentity);

    verify(this.departmentService, times(1)).getListByCompanyIdentity(any(String.class));

    Assert.assertNotNull("Result response list is not null!", resultDepartments);
    Assert
        .assertEquals("Result response list has the " + departments.size() + " items!", resultDepartments.size(),
            departments.size());
  }

}

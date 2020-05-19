package com.pth.iflow.profile.test.service.handler;

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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.enums.EApplication;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserAuthenticationRequest;
import com.pth.iflow.profile.model.UserDashboardMenu;
import com.pth.iflow.profile.model.UserPasswordChangeRequest;
import com.pth.iflow.profile.service.access.IDepartmentAccessService;
import com.pth.iflow.profile.service.access.IUsersAccessService;
import com.pth.iflow.profile.service.handler.IAuthenticationService;
import com.pth.iflow.profile.service.handler.IUsersHandlerService;
import com.pth.iflow.profile.service.handler.impl.UsersHandlerService;
import com.pth.iflow.profile.test.TestDataProducer;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UsersHandlerServiceTest extends TestDataProducer {

  private IUsersHandlerService usersHandlerService;

  @Mock
  private IUsersAccessService usersAccessService;

  @Mock
  private IDepartmentAccessService departmentAccessService;

  @MockBean
  private IAuthenticationService authenticationService;

  @Before
  public void setUp() throws Exception {

    this.usersHandlerService = new UsersHandlerService(this.usersAccessService, this.departmentAccessService, this.authenticationService);

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetUserByIdentity() throws Exception {

    final User user = this.getTestUser();

    when(this.usersAccessService.getUserByIdentity(any(String.class))).thenReturn(user);

    final User resUser = this.usersHandlerService.getUserByIdentity(user.getIdentity());

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getIdentity(), user.getIdentity());
    Assert.assertEquals("Result user has fname '" + user.getFirstName() + "'!", resUser.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());

  }

  @Test
  public void testGetUserListByComaonyId() throws Exception {

    final List<User> list = this.getTestUserList();

    when(this.usersAccessService.getUserListByCompanyIdentity(any(String.class))).thenReturn(list);

    final List<User> resList = this.usersHandlerService.getUserListByCompanyIdentity("companyId");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetUserProfileByIdentity() throws Exception {

    final ProfileResponse profile = this.getTestProfileResponse("sessionid");

    when(this.usersAccessService.getUserProfileByIdentity(any(String.class), any(String.class))).thenReturn(profile);

    final ProfileResponse resProfile = this.usersHandlerService.getUserProfileByIdentity(EApplication.IFLOW.getIdentity(), "userIdentity");

    Assert.assertNotNull("Result profile is not null!", resProfile);
    Assert.assertEquals("Result profile has the same sessionid as source!", profile.getSessionid(), resProfile.getSessionid());
    Assert
        .assertEquals("Result profile's user has fname like source!", profile.getUser().getFirstName(),
            resProfile.getUser().getFirstName());
    Assert.assertEquals("Result profile's user has status 1!", profile.getUser().getStatus(), resProfile.getUser().getStatus());

  }

  @Test
  public void testSaveUser() throws Exception {

    final User user = this.getTestUser();

    when(this.usersAccessService.saveUser(any(User.class))).thenReturn(user);

    final User resUser = this.usersHandlerService.saveUser(user);

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getIdentity(), user.getIdentity());
    Assert.assertEquals("Result user has fname '" + user.getFirstName() + "'!", resUser.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());

  }

  @Test
  public void testDeleteUser() throws Exception {

    final User user = this.getTestUser();

    this.usersHandlerService.deleteUser(user);

    verify(this.usersAccessService, times(1)).deleteUser(any(User.class));

  }

  @Test
  public void testResetUserPassword() throws Exception {

    final UserPasswordChangeRequest request = this.getTestUserPasswordChangeRequest();

    this.usersHandlerService.resetUserPassword(request);

    verify(this.authenticationService, times(1)).setAuthentication(any(UserAuthenticationRequest.class));

  }

  @Test
  public void testDeleteUserAuthentication() throws Exception {

    final UserPasswordChangeRequest request = this.getTestUserPasswordChangeRequest();

    this.usersHandlerService.deleteUserAuthentication(request);

    verify(this.authenticationService, times(1)).deleteAuthentication(any(UserAuthenticationRequest.class));

  }

  @Test
  public void testGetUserDashboardMenuListByUserIdentity() throws Exception {

    final List<UserDashboardMenu> list = this.getTestUserDashboardMenuList("userIdentity");

    when(this.usersAccessService.getUserDashboardMenuListByUserIdentity(any(String.class), any(String.class))).thenReturn(list);

    final List<UserDashboardMenu> resList = this.usersHandlerService.getUserDashboardMenuListByUserIdentity("appIdentity", "userIdentity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", list.size(), resList.size());

  }

  @Test
  public void testSaveUserDashboardMenuListByUserIdentity() throws Exception {

    final List<UserDashboardMenu> list = this.getTestUserDashboardMenuList("userIdentity");

    when(this.usersAccessService.saveUserDashboardMenuListByUserIdentity(any(String.class), any(String.class), any(List.class)))
        .thenReturn(list);

    final List<
        UserDashboardMenu> resList = this.usersHandlerService.saveUserDashboardMenuListByUserIdentity("appIdentity", "userIdentity", list);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", list.size(), resList.size());

  }

}

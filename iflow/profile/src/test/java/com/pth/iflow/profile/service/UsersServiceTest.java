package com.pth.iflow.profile.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.models.edo.UserEdo;
import com.pth.iflow.common.models.edo.UserListEdo;
import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.access.IUsersAccessService;
import com.pth.iflow.profile.service.access.impl.UsersAccessService;
import com.pth.iflow.profile.service.handler.IProfileRestTemplateCall;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsersServiceTest extends TestDataProducer {

  private IUsersAccessService usersService;

  @Mock
  private IProfileRestTemplateCall restTemplate;

  @MockBean
  private ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  @Before
  public void setUp() throws Exception {

    this.usersService = new UsersAccessService(this.restTemplate, this.coreAccessConfig);

    when(this.coreAccessConfig.prepareCoreUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetUserByEmail() throws Exception {

    final User user = this.getTestUser();
    final UserEdo userEdo = ProfileModelEdoMapper.toEdo(user);

    when(this.restTemplate.callRestGet(any(URI.class), any(EModule.class), any(Class.class), any(boolean.class)))
        .thenReturn(userEdo);

    final User resUser = this.usersService.getUserByIdentity(user.getIdentity());

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getIdentity(), user.getIdentity());
    Assert.assertEquals("Result user has fname '" + user.getFirstName() + "'!", resUser.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());

  }

  @Test
  public void testGetUserListByComaonyId() throws Exception {

    final List<User> list = this.getTestUserList();
    final UserListEdo listEdo = new UserListEdo(ProfileModelEdoMapper.toUserEdoList(list));

    when(this.restTemplate.callRestGet(any(URI.class), any(EModule.class), eq(UserListEdo.class), any(boolean.class)))
        .thenReturn(listEdo);

    final List<User> resList = this.usersService.getUserListByCompanyIdentity("companyId");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testSaveUser() throws Exception {

    final User user = this.getTestUser();
    final UserEdo userEdo = ProfileModelEdoMapper.toEdo(user);

    when(this.restTemplate.callRestPost(any(URI.class), eq(EModule.CORE), any(UserEdo.class), any(Class.class), any(boolean.class)))
        .thenReturn(userEdo);

    final User resUser = this.usersService.saveUser(user);

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getIdentity(), user.getIdentity());
    Assert.assertEquals("Result user has fname '" + user.getFirstName() + "'!", resUser.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());

  }

  @Test
  public void testDeleteUser() throws Exception {

    final User user = this.getTestUser();
    final UserEdo userEdo = ProfileModelEdoMapper.toEdo(user);

    when(this.restTemplate.callRestPost(any(URI.class), eq(EModule.CORE), any(UserEdo.class), any(Class.class), any(boolean.class)))
        .thenReturn(userEdo);

    this.usersService.deleteUser(user);

    verify(this.restTemplate, times(1))
        .callRestPost(any(URI.class), eq(EModule.CORE), any(UserEdo.class), eq(Void.class), any(boolean.class));

  }

}

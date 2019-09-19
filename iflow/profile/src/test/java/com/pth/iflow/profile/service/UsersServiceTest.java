package com.pth.iflow.profile.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import java.net.URL;
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

import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.impl.UsersService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsersServiceTest extends TestDataProducer {

  private IUsersService usersService;

  @Mock
  private IProfileRestTemplateCall restTemplate;

  @MockBean
  private ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  @Before
  public void setUp() throws Exception {
    this.usersService = new UsersService(this.restTemplate, this.coreAccessConfig);

    when(this.coreAccessConfig.prepareCoreUrl(any(String.class))).thenReturn(new URL("http://any-string"));

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetUserById() throws Exception {

    final User user = getTestUser();
    final UserEdo userEdo = ProfileModelEdoMapper.toEdo(user);

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), any(Class.class), any(boolean.class), any()))
                                                                                                                           .thenReturn(userEdo);

    final User resUser = this.usersService.getUserById(user.getId());

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getId(), user.getId());
    Assert.assertEquals("Result user has fname '" + user.getFirstName() + "'!", resUser.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());

  }

  @Test
  public void testGetUserByEmail() throws Exception {

    final User user = getTestUser();
    final UserEdo userEdo = ProfileModelEdoMapper.toEdo(user);

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), any(Class.class), any(boolean.class), any()))
                                                                                                                           .thenReturn(userEdo);

    final User resUser = this.usersService.getUserByEmail(user.getEmail());

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getId(), user.getId());
    Assert.assertEquals("Result user has fname '" + user.getFirstName() + "'!", resUser.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());

  }

  @Test
  public void testGetUserListByComaonyId() throws Exception {

    final List<User> list = getTestUserList();
    final UserListEdo listEdo = new UserListEdo(ProfileModelEdoMapper.toUserEdoList(list));

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), eq(UserListEdo.class), any(boolean.class), any()))
                                                                                                                                .thenReturn(listEdo);

    final List<User> resList = this.usersService.getUserListByCompanyId(1L);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

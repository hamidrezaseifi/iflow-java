package com.pth.iflow.gui.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.models.edo.UserEdo;
import com.pth.iflow.common.models.edo.UserListEdo;
import com.pth.iflow.gui.TestDataProducer;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.services.impl.UserAccess;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserAccessTest extends TestDataProducer {

  private IUserAccess                                 userAccess;

  @MockBean
  private IRestTemplateCall                           restTemplate;

  @MockBean
  private GuiConfiguration.WorkflowModuleAccessConfig workflowModuleAccessConfig;

  @MockBean
  private GuiConfiguration.ProfileModuleAccessConfig  profileModuleAccessConfig;

  @MockBean
  private SessionUserInfo                             sessionUserInfo;

  private URI                                         testUri;

  private String                                      validTocken;

  @Before
  public void setUp() throws Exception {

    this.testUri = new URI("test-uri");

    this.validTocken = "validTocken";

    when(this.profileModuleAccessConfig.getAuthenticationUri()).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadAuthenticationInfoUri()).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadCompanyUserListUri(any(String.class))).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadTokenInfoUri()).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getReadWorkflowTypeListUri(any(String.class))).thenReturn(this.testUri);

    when(this.sessionUserInfo.getToken()).thenReturn(this.validTocken);
    when(this.sessionUserInfo.getUserByIdentity(any(String.class))).thenReturn(this.getTestUser());
    when(this.sessionUserInfo.getWorkflowTypeByIdentity(any(String.class))).thenReturn(this.getTestWorkflowType());

    this.userAccess = new UserAccess(this.restTemplate, this.profileModuleAccessConfig, this.sessionUserInfo);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  @Ignore
  public void testReadUser() throws Exception {

    final User user = this.getTestUser();

    when(this.restTemplate.callRestGet(any(URI.class), any(EModule.class), eq(UserEdo.class), any(String.class), any(boolean.class)))
        .thenReturn(GuiModelEdoMapper.toEdo(user));

    final User resUser = this.userAccess.readUser("useridentity");

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getIdentity(), user.getIdentity());
    Assert.assertEquals("Result user has title '" + user.getFullName() + "'!", resUser.getFullName(), user.getFullName());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());

  }

  @Test
  @Ignore
  public void testSaveUser() throws Exception {

    final User user = this.getTestUser();

    when(this.restTemplate.callRestPost(any(URI.class), any(EModule.class), any(UserEdo.class), eq(UserEdo.class), any(String.class),
        any(boolean.class))).thenReturn(GuiModelEdoMapper.toEdo(user));

    final User resUser = this.userAccess.saveUser(user);

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getIdentity(), user.getIdentity());
    Assert.assertEquals("Result user has title '" + user.getFullName() + "'!", resUser.getFullName(), user.getFullName());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());

  }

  @Test
  public void testGetCompanyUserList() throws Exception {
    final List<User> userList = this.getTestUserList();
    final UserListEdo listEdo = new UserListEdo(GuiModelEdoMapper.toUserEdoList(userList));

    when(this.restTemplate.callRestGet(any(URI.class), any(EModule.class), eq(UserListEdo.class), any(String.class),
        any(boolean.class))).thenReturn(listEdo);

    final List<User> resUserList = this.userAccess.getCompanyUserList("test-company");

    Assert.assertNotNull("Result result-list is not null!", resUserList);
    Assert.assertEquals("Result result-list has the same size as expected!", resUserList.size(), userList.size());

  }

}

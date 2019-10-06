package com.pth.iflow.profile.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
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

import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.edo.models.UserGroupListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.model.UserGroup;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.impl.UserGroupService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserGroupServiceTest extends TestDataProducer {

  private IUserGroupService                     userGroupService;

  @Mock
  private IProfileRestTemplateCall              restTemplate;

  @MockBean
  private ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  @Before
  public void setUp() throws Exception {
    this.userGroupService = new UserGroupService(this.restTemplate, this.coreAccessConfig);

    when(this.coreAccessConfig.prepareCoreUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final UserGroup userGroup = this.getTestUserGroup();
    final UserGroupEdo userGroupEdo = ProfileModelEdoMapper.toEdo(userGroup);

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), any(Class.class), any(boolean.class), any()))
        .thenReturn(userGroupEdo);

    final UserGroup resUserGroup = this.userGroupService.getById(userGroup.getId());

    Assert.assertNotNull("Result user-group is not null!", resUserGroup);
    Assert.assertEquals("Result user-group has id 1!", resUserGroup.getId(), userGroup.getId());
    Assert.assertEquals("Result user-group has title '" + userGroup.getTitle() + "'!", resUserGroup.getTitle(), userGroup.getTitle());
    Assert.assertEquals("Result user-group has status 1!", resUserGroup.getStatus(), userGroup.getStatus());

  }

  @Test
  public void testGetListByComaonyId() throws Exception {

    final List<UserGroup> list = this.getTestUserGroupList();
    final UserGroupListEdo listEdo = new UserGroupListEdo(ProfileModelEdoMapper.toUserGroupEdoList(list));

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), eq(UserGroupListEdo.class), any(boolean.class), any()))
        .thenReturn(listEdo);

    final List<UserGroup> resList = this.userGroupService.getListByCompanyId(1L);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

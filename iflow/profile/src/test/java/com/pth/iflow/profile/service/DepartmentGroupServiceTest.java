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

import com.pth.iflow.common.edo.models.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.model.DepartmentGroup;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.impl.DepartmentGroupService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentGroupServiceTest extends TestDataProducer {

  private IDepartmentGroupService departmentGroupService;

  @Mock
  private IProfileRestTemplateCall restTemplate;

  @MockBean
  private ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  @Before
  public void setUp() throws Exception {
    this.departmentGroupService = new DepartmentGroupService(this.restTemplate, this.coreAccessConfig);

    when(this.coreAccessConfig.prepareCoreUrl(any(String.class))).thenReturn(new URL("http://any-string"));

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final DepartmentGroup departmentGroup = this.getTestDepartmentGroup();
    final DepartmentGroupEdo departmentGroupEdo = ProfileModelEdoMapper.toEdo(departmentGroup);

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), any(Class.class), any(boolean.class), any()))
                                                                                                                           .thenReturn(departmentGroupEdo);

    final DepartmentGroup resDepartment = this.departmentGroupService.getById(departmentGroup.getId());

    Assert.assertNotNull("Result department-group is not null!", resDepartment);
    Assert.assertEquals("Result department-group has id 1!", resDepartment.getId(), departmentGroup.getId());
    Assert.assertEquals("Result department-group has title '" + departmentGroup.getTitle() + "'!",
                        resDepartment.getTitle(),
                        departmentGroup.getTitle());
    Assert.assertEquals("Result department-group has status 1!", resDepartment.getStatus(), departmentGroup.getStatus());

  }

  @Test
  public void testGetAllUserListByDepartmentGroupId() throws Exception {

    final List<User> list = this.getTestUserList();
    final UserListEdo listEdo = new UserListEdo(ProfileModelEdoMapper.toUserEdoList(list));

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), eq(UserListEdo.class), any(boolean.class), any()))
                                                                                                                                .thenReturn(listEdo);

    final List<User> resList = this.departmentGroupService.getAllUserListByDepartmentGroupId(1L);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

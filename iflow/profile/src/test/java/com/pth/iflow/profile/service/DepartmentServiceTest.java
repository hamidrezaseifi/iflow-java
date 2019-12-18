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

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.models.DepartmentEdo;
import com.pth.iflow.common.models.DepartmentListEdo;
import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.impl.DepartmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentServiceTest extends TestDataProducer {

  private IDepartmentService                    departmentService;

  @Mock
  private IProfileRestTemplateCall              restTemplate;

  @MockBean
  private ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  @Before
  public void setUp() throws Exception {
    this.departmentService = new DepartmentService(this.restTemplate, this.coreAccessConfig);

    when(this.coreAccessConfig.prepareCoreUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final Department department = this.getTestDepartment("dep1", "department 1");
    final DepartmentEdo departmentEdo = ProfileModelEdoMapper.toEdo(department);

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), any(Class.class), any(boolean.class), any()))
        .thenReturn(departmentEdo);

    final Department resDepartment = this.departmentService.getByIdentity(department.getIdentity());

    Assert.assertNotNull("Result department is not null!", resDepartment);
    Assert.assertEquals("Result department has id 1!", resDepartment.getIdentity(), department.getIdentity());
    Assert.assertEquals("Result department has title '" + department.getTitle() + "'!", resDepartment.getTitle(),
        department.getTitle());
    Assert.assertEquals("Result department has status 1!", resDepartment.getStatus(), department.getStatus());

  }

  @Test
  public void testGetListByComaonyId() throws Exception {

    final List<Department> list = this.getTestDepartmentList();
    final DepartmentListEdo listEdo = new DepartmentListEdo(ProfileModelEdoMapper.toDepartmentEdoList(list));

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), eq(DepartmentListEdo.class), any(boolean.class), any()))
        .thenReturn(listEdo);

    final List<Department> resList = this.departmentService.getListByCompanyIdentity("company1");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

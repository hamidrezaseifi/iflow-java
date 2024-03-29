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
import com.pth.iflow.common.models.edo.DepartmentEdo;
import com.pth.iflow.common.models.edo.DepartmentListEdo;
import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.access.IDepartmentAccessService;
import com.pth.iflow.profile.service.access.impl.DepartmentAccessService;
import com.pth.iflow.profile.service.handler.IProfileRestTemplateCall;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentServiceTest extends TestDataProducer {

  private IDepartmentAccessService departmentService;

  @Mock
  private IProfileRestTemplateCall restTemplate;

  @MockBean
  private ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  @Before
  public void setUp() throws Exception {

    this.departmentService = new DepartmentAccessService(this.restTemplate, this.coreAccessConfig);

    when(this.coreAccessConfig.prepareCoreUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetById() throws Exception {

    final Department department = this.getTestDepartment("dep1", "department 1");
    final DepartmentEdo departmentEdo = ProfileModelEdoMapper.toEdo(department);

    when(this.restTemplate.callRestGet(any(URI.class), any(EModule.class), any(Class.class), any(boolean.class)))
        .thenReturn(departmentEdo);

    final Department resDepartment = this.departmentService.getByIdentity(department.getIdentity());

    Assert.assertNotNull("Result department is not null!", resDepartment);
    Assert.assertEquals("Result department has id 1!", resDepartment.getIdentity(), department.getIdentity());
    Assert
        .assertEquals("Result department has title '" + department.getTitle() + "'!", resDepartment.getTitle(),
            department.getTitle());
    Assert.assertEquals("Result department has status 1!", resDepartment.getStatus(), department.getStatus());

  }

  @Test
  public void testGetListByComaonyId() throws Exception {

    final List<Department> list = this.getTestDepartmentList();
    final DepartmentListEdo listEdo = new DepartmentListEdo(ProfileModelEdoMapper.toDepartmentEdoList(list));

    when(this.restTemplate.callRestGet(any(URI.class), any(EModule.class), eq(DepartmentListEdo.class), any(boolean.class)))
        .thenReturn(listEdo);

    final List<Department> resList = this.departmentService.getListByCompanyIdentity("company1");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testSaveDepartment() throws Exception {

    final Department department = this.getTestDepartment("dep1", "department 1");
    final DepartmentEdo departmentEdo = ProfileModelEdoMapper.toEdo(department);

    when(this.restTemplate
        .callRestPost(any(URI.class), eq(EModule.CORE), any(DepartmentEdo.class), eq(DepartmentEdo.class), any(boolean.class)))
            .thenReturn(departmentEdo);

    final Department resDepartment = this.departmentService.saveDepartment(department);

    Assert.assertNotNull("Result department is not null!", resDepartment);
    Assert.assertEquals("Result department has id 1!", resDepartment.getIdentity(), department.getIdentity());
    Assert
        .assertEquals("Result department has title '" + department.getTitle() + "'!", resDepartment.getTitle(),
            department.getTitle());
    Assert.assertEquals("Result department has status 1!", resDepartment.getStatus(), department.getStatus());

  }

  @Test
  public void testDeleteDepartment() throws Exception {

    final Department department = this.getTestDepartment("dep1", "department 1");
    final DepartmentEdo departmentEdo = ProfileModelEdoMapper.toEdo(department);

    when(this.restTemplate.callRestPost(any(URI.class), eq(EModule.CORE), any(DepartmentEdo.class), any(Class.class), any(boolean.class)))
        .thenReturn(departmentEdo);

    this.departmentService.deleteDepartment(department);

    verify(this.restTemplate, times(1))
        .callRestPost(any(URI.class), eq(EModule.CORE), any(DepartmentEdo.class), eq(Void.class), any(boolean.class));

  }

}

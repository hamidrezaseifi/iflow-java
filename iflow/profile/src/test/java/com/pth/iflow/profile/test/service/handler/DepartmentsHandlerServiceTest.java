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
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.service.access.IDepartmentAccessService;
import com.pth.iflow.profile.service.handler.IDepartmentsHandlerService;
import com.pth.iflow.profile.service.handler.impl.DepartmentsHandlerService;
import com.pth.iflow.profile.test.TestDataProducer;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class DepartmentsHandlerServiceTest extends TestDataProducer {

  private IDepartmentsHandlerService departmentsHandlerService;

  @Mock
  private IDepartmentAccessService departmentAccessService;

  @Before
  public void setUp() throws Exception {

    this.departmentsHandlerService = new DepartmentsHandlerService(this.departmentAccessService);

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetById() throws Exception {

    final Department department = this.getTestDepartment("dep1", "department 1");

    when(this.departmentAccessService.getByIdentity(any(String.class))).thenReturn(department);

    final Department resDepartment = this.departmentsHandlerService.getDepartmentByIdentity(department.getIdentity());

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

    when(this.departmentAccessService.getListByCompanyIdentity(any(String.class))).thenReturn(list);

    final List<Department> resList = this.departmentsHandlerService.getDepartmentListByCompanyIdentity("company1");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testSaveDepartment() throws Exception {

    final Department department = this.getTestDepartment("dep1", "department 1");

    when(this.departmentAccessService.saveDepartment(any(Department.class))).thenReturn(department);

    final Department resDepartment = this.departmentsHandlerService.saveDepartment(department);

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

    this.departmentsHandlerService.deleteDepartment(department);

    verify(this.departmentAccessService, times(1)).deleteDepartment(any(Department.class));

  }

}

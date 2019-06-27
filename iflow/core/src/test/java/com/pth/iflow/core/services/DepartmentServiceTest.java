package com.pth.iflow.core.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.service.IDepartmentService;
import com.pth.iflow.core.service.impl.DepartmentService;
import com.pth.iflow.core.storage.dao.IDepartmentDao;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentServiceTest extends TestDataProducer {
  
  private IDepartmentService departmentService;
  
  @MockBean
  private IDepartmentDao departmentDao;
  
  @MockBean
  private IDepartmentGroupDao departmentGroupDao;
  
  @Before
  public void setUp() throws Exception {
    this.departmentService = new DepartmentService(this.departmentDao, this.departmentGroupDao);
  }
  
  @After
  public void tearDown() throws Exception {
  }
  
  @Test
  public void testGetById() throws Exception {
    
    final Department department = getTestDepartment();
    when(this.departmentDao.getById(any(Long.class))).thenReturn(department);
    
    final Department resDepartment = this.departmentService.getById(department.getId());
    
    Assert.assertNotNull("Result department is not null!", resDepartment);
    Assert.assertEquals("Result department has id 1!", resDepartment.getId(), department.getId());
    Assert.assertEquals("Result department has title '" + department.getTitle() + "'!", resDepartment.getTitle(), department.getTitle());
    Assert.assertEquals("Result department has status 1!", resDepartment.getStatus(), department.getStatus());
    
  }
  
  @Test
  public void testGetListByIdList() throws Exception {
    
    final List<Long> idList = getTestDepartmentIdList();
    final List<Department> list = getTestDepartmentList();
    when(this.departmentDao.getListByIdList(any(List.class))).thenReturn(list);
    
    final List<Department> resList = this.departmentService.getListByIdList(idList);
    
    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());
    
  }

  @Test
  public void testGetListByIdCompanyId() throws Exception {
    
    final List<Department> list = getTestDepartmentList();
    when(this.departmentDao.getListByCompanyId(any(Long.class))).thenReturn(list);
    
    final List<Department> resList = this.departmentService.getListByIdCompanyId(1L);
    
    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());
    
  }

  @Test
  public void testGetDepartmentGroups() throws Exception {
    
    final Department department = getTestDepartment();

    final List<DepartmentGroup> list = getTestDepartmentGroupList();
    when(this.departmentDao.getById(any(Long.class))).thenReturn(department);
    when(this.departmentGroupDao.getListByIdList(any(List.class))).thenReturn(list);

    final List<DepartmentGroup> resList = this.departmentService.getDepartmentGroups(1L);
    
    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());
    
  }

}

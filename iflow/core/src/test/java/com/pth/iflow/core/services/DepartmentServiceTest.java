package com.pth.iflow.core.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.service.impl.DepartmentService;
import com.pth.iflow.core.service.interfaces.IDepartmentService;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentDao;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentServiceTest extends TestDataProducer {

  private IDepartmentService  departmentService;

  @MockBean
  private IDepartmentDao      departmentDao;

  @MockBean
  private IDepartmentGroupDao departmentGroupDao;

  @MockBean
  private IUserDao            userDao;

  @Before
  public void setUp() throws Exception {
    this.departmentService = new DepartmentService(this.departmentDao, this.departmentGroupDao, this.userDao);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final Department department = this.getTestDepartment();
    when(this.departmentDao.getByIdentity(any(String.class))).thenReturn(department);

    final Department resDepartment = this.departmentService.getByIdentity(department.getIdentity());

    Assert.assertNotNull("Result department is not null!", resDepartment);
    Assert.assertEquals("Result department has id 1!", resDepartment.getId(), department.getId());
    Assert.assertEquals("Result department has title '" + department.getTitle() + "'!", resDepartment.getTitle(),
        department.getTitle());
    Assert.assertEquals("Result department has status 1!", resDepartment.getStatus(), department.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = this.getTestDepartmentIdSet();
    final List<Department> list = this.getTestDepartmentList();
    when(this.departmentDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final List<Department> resList = this.departmentService.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByIdCompanyId() throws Exception {

    final List<Department> list = this.getTestDepartmentList();
    when(this.departmentDao.getListByCompanyIdentity(any(String.class))).thenReturn(list);

    final List<Department> resList = this.departmentService.getListByIdCompanyIdentity("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetDepartmentGroups() throws Exception {

    final Department department = this.getTestDepartment();

    final List<DepartmentGroupEntity> list = this.getTestDepartmentGroupList();
    when(this.departmentDao.getByIdentity(any(String.class))).thenReturn(department);

    final List<DepartmentGroupEntity> resList = this.departmentService.getDepartmentGroups("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetAllUserListByDepartmentId() throws Exception {

    final Set<String> list = new HashSet<>(Arrays.asList("item-1", "item-2", "item-3"));
    final List<User> userList = this.getTestUserList();
    final List<DepartmentGroupEntity> departmentGroupList = this.getTestDepartmentGroupList();
    final Department department = this.getTestDepartment();

    when(this.departmentDao.getByIdentity(any(String.class))).thenReturn(department);
    when(this.userDao.getListByIdentityList(any(Set.class))).thenReturn(userList);
    when(this.departmentGroupDao.getAllUserIdentityListByDepartmentGroupId(any(Long.class))).thenReturn(list);
    when(this.departmentDao.getAllUserIdentityListByDepartmentId(any(Long.class))).thenReturn(list);

    final List<User> resList = this.departmentService.getAllUserListByDepartmentIdentity("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }
}

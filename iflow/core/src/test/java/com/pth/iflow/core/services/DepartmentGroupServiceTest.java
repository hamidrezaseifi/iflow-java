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
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.service.IDepartmentGroupService;
import com.pth.iflow.core.service.impl.DepartmentGroupService;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.IUserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentGroupServiceTest extends TestDataProducer {

  private IDepartmentGroupService departmentGroupService;

  @MockBean
  private IDepartmentGroupDao     departmentGroupDao;

  @MockBean
  private IUserDao                userDao;

  @Before
  public void setUp() throws Exception {
    this.departmentGroupService = new DepartmentGroupService(this.departmentGroupDao, this.userDao);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final DepartmentGroup departmentGroup = this.getTestDepartmentGroup();
    when(this.departmentGroupDao.getById(any(Long.class))).thenReturn(departmentGroup);

    final DepartmentGroup resDepartmentGroup = this.departmentGroupService.getById(departmentGroup.getId());

    Assert.assertNotNull("Result department group is not null!", resDepartmentGroup);
    Assert.assertEquals("Result department group has id 1!", resDepartmentGroup.getId(), departmentGroup.getId());
    Assert.assertEquals("Result department group has title '" + departmentGroup.getTitle() + "'!", resDepartmentGroup.getTitle(),
        departmentGroup.getTitle());
    Assert.assertEquals("Result department group has status 1!", resDepartmentGroup.getStatus(), departmentGroup.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final List<Long> idList = this.getTestDepartmentIdList();
    final List<DepartmentGroup> list = this.getTestDepartmentGroupList();
    when(this.departmentGroupDao.getListByIdList(any(List.class))).thenReturn(list);

    final List<DepartmentGroup> resList = this.departmentGroupService.getListByIdList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByDepartmentId() throws Exception {

    final List<DepartmentGroup> list = this.getTestDepartmentGroupList();
    when(this.departmentGroupDao.getListByDepartmentId(any(Long.class))).thenReturn(list);

    final List<DepartmentGroup> resList = this.departmentGroupService.getListByDepartmentId(1L);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetAllUserIdListByDepartmentGroupId() throws Exception {

    final List<Long> list = this.getTestUserIdList();
    final List<User> userList = this.getTestUserList();

    when(this.departmentGroupDao.getAllUserIdListByDepartmentGroupId(any(Long.class))).thenReturn(list);
    when(this.userDao.getListByIdList(any(List.class))).thenReturn(userList);

    final List<User> resList = this.departmentGroupService.getAllUserListByDepartmentGroupId(1L);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());
    ;

  }

}

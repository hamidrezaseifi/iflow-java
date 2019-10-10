package com.pth.iflow.core.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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

    final DepartmentGroup resDepartmentGroup = this.departmentGroupService.getByIdentity(departmentGroup.getIdentity());

    Assert.assertNotNull("Result department group is not null!", resDepartmentGroup);
    Assert.assertEquals("Result department group has id 1!", resDepartmentGroup.getId(), departmentGroup.getId());
    Assert.assertEquals("Result department group has title '" + departmentGroup.getTitle() + "'!", resDepartmentGroup.getTitle(),
        departmentGroup.getTitle());
    Assert.assertEquals("Result department group has status 1!", resDepartmentGroup.getStatus(), departmentGroup.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = this.getTestDepartmentIdSet();
    final List<DepartmentGroup> list = this.getTestDepartmentGroupList();
    when(this.departmentGroupDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final List<DepartmentGroup> resList = this.departmentGroupService.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByDepartmentId() throws Exception {

    final List<DepartmentGroup> list = this.getTestDepartmentGroupList();
    when(this.departmentGroupDao.getListByDepartmentIdentity(any(String.class))).thenReturn(list);

    final List<DepartmentGroup> resList = this.departmentGroupService.getListByDepartmentIdentity("departmentIdentity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetAllUserIdListByDepartmentGroupId() throws Exception {

    final Set<String> list = this.getTestUserIdSet();
    final List<User> userList = this.getTestUserList();
    final DepartmentGroup departmentGroup = getTestDepartmentGroup();

    when(this.departmentGroupDao.getAllUserIdentityListByDepartmentGroupId(any(Long.class))).thenReturn(list);
    when(this.userDao.getListByIdentityList(any(Set.class))).thenReturn(userList);
    when(this.departmentGroupDao.getByIdentity(any(String.class))).thenReturn(departmentGroup);

    final List<User> resList = this.departmentGroupService.getAllUserListByDepartmentGroupId("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());
    ;

  }

}

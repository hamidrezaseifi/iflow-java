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
import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.service.impl.UsersService;
import com.pth.iflow.core.service.interfaces.IUsersService;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentDao;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;
import com.pth.iflow.core.storage.dao.interfaces.IUserGroupDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest extends TestDataProducer {

  private IUsersService       userService;

  @MockBean
  private ICompanyDao         companyDao;

  @MockBean
  private IUserDao            userDao;

  @MockBean
  private IUserGroupDao       userGroupDao;

  @MockBean
  private IDepartmentDao      departmentDao;

  @MockBean
  private IDepartmentGroupDao departmentGroupDao;

  @Before
  public void setUp() throws Exception {
    this.userService = new UsersService(this.companyDao, this.userDao, this.userGroupDao, this.departmentDao, this.departmentGroupDao);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadUserById() throws Exception {

    final User user = getTestUser();
    when(this.userDao.getByIdentity(any(String.class))).thenReturn(user);

    final User resUser = this.userService.getUserByEmail("email");

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getId(), user.getId());
    Assert.assertEquals("Result user has firstname '" + user.getFirstName() + "'!", resUser.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has lastname '" + user.getLastName() + "'!", resUser.getLastName(), user.getLastName());
    Assert.assertEquals("Result user has email '" + user.getEmail() + "'!", resUser.getEmail(), user.getEmail());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());

  }

  @Test
  public void testReadUserByEmail() throws Exception {

    final User user = getTestUser();
    when(this.userDao.getByIdentity(any(String.class))).thenReturn(user);

    final User resUser = this.userService.getUserByEmail(user.getEmail());

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getId(), user.getId());
    Assert.assertEquals("Result user has firstname '" + user.getFirstName() + "'!", resUser.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has lastname '" + user.getLastName() + "'!", resUser.getLastName(), user.getLastName());
    Assert.assertEquals("Result user has email '" + user.getEmail() + "'!", resUser.getEmail(), user.getEmail());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());

  }

  @Test
  public void testGetUserDepartmentGroups() throws Exception {

    final User user = getTestUser();
    final List<DepartmentGroupEntity> list = getTestDepartmentGroupList();

    when(this.userDao.getByIdentity(any(String.class))).thenReturn(user);
    when(this.departmentGroupDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final List<DepartmentGroupEntity> resList = this.userService.getUserDepartmentGroups("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetUserDepartments() throws Exception {

    final User user = getTestUser();
    final List<Department> list = getTestDepartmentList();

    when(this.userDao.getByIdentity(any(String.class))).thenReturn(user);
    when(this.departmentDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final List<Department> resList = this.userService.getUserDepartments("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetUserDeputies() throws Exception {

    final User user = getTestUser();
    final List<User> list = getTestUserList();

    when(this.userDao.getByIdentity(any(String.class))).thenReturn(user);
    when(this.userDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final List<User> resList = this.userService.getUserDeputies("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetUserGroups() throws Exception {

    final User user = getTestUser();
    final List<UserGroup> list = getTestUserGroupList();

    when(this.userDao.getByIdentity(any(String.class))).thenReturn(user);
    when(this.userGroupDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final List<UserGroup> resList = this.userService.getUserGroups("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetProfileResponseByEmail() throws Exception {

    final User user = getTestUser();
    final Company company = this.getTestCompany();
    final List<UserGroup> grouplist = getTestUserGroupList();
    final List<Department> deplist = getTestDepartmentList();

    when(this.userDao.getByIdentity(any(String.class))).thenReturn(user);
    when(this.userGroupDao.getListByIdentityList(any(Set.class))).thenReturn(grouplist);
    when(this.departmentDao.getListByIdentityList(any(Set.class))).thenReturn(deplist);
    when(this.companyDao.getByIdentity(any(String.class))).thenReturn(company);

    final ProfileResponse result = this.userService.getProfileResponseByEmail("identity");

    Assert.assertNotNull("Result not null!", result);
    Assert.assertEquals("Result company has title '" + company.getCompanyName() + "'", company.getCompanyName(),
        result.getCompanyProfile().getCompany().getCompanyName());
    Assert.assertEquals("Result user has fname '" + user.getFirstName() + "'", user.getFirstName(), result.getUser().getFirstName());
    Assert.assertEquals("Result user has lname '" + user.getLastName() + "'", user.getLastName(), result.getUser().getLastName());
    Assert.assertEquals("Result user has '" + grouplist.size() + "' usergroups", grouplist.size(),
        result.getCompanyProfile().getUserGroups().size());
    Assert.assertEquals("Result user has '" + deplist.size() + "' departments", deplist.size(),
        result.getCompanyProfile().getDepartments().size());

  }

}

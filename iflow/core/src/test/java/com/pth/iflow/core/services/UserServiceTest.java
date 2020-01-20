package com.pth.iflow.core.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.service.impl.UsersService;
import com.pth.iflow.core.service.interfaces.IUsersService;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentDao;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;
import com.pth.iflow.core.storage.dao.interfaces.IUserGroupDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest extends TestDataProducer {

  private IUsersService userService;

  @MockBean
  private ICompanyDao companyDao;

  @MockBean
  private IUserDao userDao;

  @MockBean
  private IUserGroupDao userGroupDao;

  @MockBean
  private IDepartmentDao departmentDao;

  @MockBean
  private IDepartmentGroupDao departmentGroupDao;

  @MockBean
  private IWorkflowTypeDao workflowTypeDao;

  @Before
  public void setUp() throws Exception {

    this.userService = new UsersService(this.companyDao, this.userDao, this.userGroupDao, this.departmentDao, this.departmentGroupDao,
        this.workflowTypeDao);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testReadUserById() throws Exception {

    final UserEntity user = getTestUser();
    when(this.userDao.getByIdentity(any(String.class))).thenReturn(user);

    final UserEntity resUser = this.userService.getUserByIdentity("email");

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getId(), user.getId());
    Assert.assertEquals("Result user has firstname '" + user.getFirstName() + "'!", resUser.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has lastname '" + user.getLastName() + "'!", resUser.getLastName(), user.getLastName());
    Assert.assertEquals("Result user has email '" + user.getEmail() + "'!", resUser.getEmail(), user.getEmail());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());

  }

  @Test
  public void testReadUserByEmail() throws Exception {

    final UserEntity user = getTestUser();
    when(this.userDao.getByIdentity(any(String.class))).thenReturn(user);

    final UserEntity resUser = this.userService.getUserByIdentity(user.getEmail());

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getId(), user.getId());
    Assert.assertEquals("Result user has firstname '" + user.getFirstName() + "'!", resUser.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has lastname '" + user.getLastName() + "'!", resUser.getLastName(), user.getLastName());
    Assert.assertEquals("Result user has email '" + user.getEmail() + "'!", resUser.getEmail(), user.getEmail());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());

  }

  @Test
  public void testGetUserDepartmentGroups() throws Exception {

    final UserEntity user = getTestUser();
    final List<DepartmentGroupEntity> list = getTestDepartmentGroupList();

    user.addUserDepartmentGroup(1L, 5);
    user.addUserDepartmentGroup(2L, 5);

    when(this.userDao.getByIdentity(any(String.class))).thenReturn(user);

    final List<DepartmentGroupEntity> resList = this.userService.getUserDepartmentGroups("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetUserDepartments() throws Exception {

    final UserEntity user = getTestUser();
    final List<DepartmentEntity> list = getTestDepartmentList();

    user.addUserDepartment(1L, 5);
    user.addUserDepartment(2L, 5);

    when(this.userDao.getByIdentity(any(String.class))).thenReturn(user);

    final List<DepartmentEntity> resList = this.userService.getUserDepartments("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetUserDeputies() throws Exception {

    final UserEntity user = getTestUser();
    final List<UserEntity> list = getTestUserList();
    user.setDeputies(list);

    when(this.userDao.getByIdentity(any(String.class))).thenReturn(user);
    when(this.userDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final List<UserEntity> resList = this.userService.getUserDeputies("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", list.size(), resList.size());

  }

  @Test
  public void testGetUserGroups() throws Exception {

    final UserEntity user = getTestUser();
    final List<UserGroupEntity> list = getTestUserGroupList();
    user.setGroups(list);

    when(this.userDao.getByIdentity(any(String.class))).thenReturn(user);
    when(this.userGroupDao.getListByIdList(any(Set.class))).thenReturn(list);

    final List<UserGroupEntity> resList = this.userService.getUserGroups("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetProfileResponseByEmail() throws Exception {

    final UserEntity user = getTestUser();
    final CompanyEntity company = this.getTestCompany();
    final List<UserGroupEntity> grouplist = getTestUserGroupList();
    final List<DepartmentEntity> deplist = getTestDepartmentList();

    user.setGroups(grouplist);
    user.addUserDepartment(1L, 5);
    user.addUserDepartment(2L, 5);

    when(this.userDao.getByIdentity(any(String.class))).thenReturn(user);
    when(this.userGroupDao.getListByIdList(any(Set.class))).thenReturn(grouplist);
    when(this.companyDao.getByIdentity(any(String.class))).thenReturn(company);

    final ProfileResponse result = this.userService.getProfileResponseByEmail("identity");

    Assert.assertNotNull("Result not null!", result);
    Assert
        .assertEquals("Result company has title '" + company.getCompanyName() + "'", company.getCompanyName(),
            result.getCompanyProfile().getCompany().getCompanyName());
    Assert.assertEquals("Result user has fname '" + user.getFirstName() + "'", user.getFirstName(), result.getUser().getFirstName());
    Assert.assertEquals("Result user has lname '" + user.getLastName() + "'", user.getLastName(), result.getUser().getLastName());
    Assert
        .assertEquals("Result user has '" + grouplist.size() + "' usergroups", grouplist.size(),
            result.getCompanyProfile().getUserGroups().size());
    Assert
        .assertEquals("Result user has '" + deplist.size() + "' departments", deplist.size(),
            result.getCompanyProfile().getDepartments().size());

  }

  @Test
  public void testGetAllUserIdListByDepartmentGroupId() throws Exception {

    final Set<String> list = this.getTestUserIdSet();
    final List<UserEntity> userList = this.getTestUserList();

    when(this.userDao.getAllUserIdentityListByDepartmentId(any(String.class))).thenReturn(userList);

    final List<UserEntity> resList = this.userService.getAllUserIdentityListByDepartmentIdentity("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());
    ;

  }

  @Test
  public void testGetAllUserListByDepartmentId() throws Exception {

    final Set<String> list = new HashSet<>(Arrays.asList("item-1", "item-2", "item-3"));
    final List<UserEntity> userList = this.getTestUserList();

    when(this.userDao.getAllUserIdentityListByDepartmentGroupId(any(String.class))).thenReturn(userList);

    final List<UserEntity> resList = this.userService.getAllUserIdentityListByDepartmentGroupIdentity("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testSaveCreate() throws Exception {

    final UserEntity testUser = this.getTestUser();
    testUser.setId(null);
    testUser.setIdentity("");
    final UserEntity savedUser = this.getTestUser();
    when(this.userDao.create(any(UserEntity.class))).thenReturn(savedUser);

    final UserEntity resUser = this.userService.save(testUser);

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getId(), savedUser.getId());
    Assert.assertEquals("Result user has firstname '" + savedUser.getFirstName() + "'!", resUser.getFirstName(), savedUser.getFirstName());
    Assert.assertEquals("Result user has lastname '" + savedUser.getLastName() + "'!", resUser.getLastName(), savedUser.getLastName());
    Assert.assertEquals("Result user has email '" + savedUser.getEmail() + "'!", resUser.getEmail(), savedUser.getEmail());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), savedUser.getStatus());

    verify(this.userDao, times(1)).create(any(UserEntity.class));
    verify(this.userDao, times(0)).update(any(UserEntity.class));

  }

  @Test
  public void testSaveUpdate() throws Exception {

    final UserEntity testUser = this.getTestUser();

    final UserEntity savedUser = this.getTestUser();
    when(this.userDao.update(any(UserEntity.class))).thenReturn(savedUser);
    when(this.userDao.getByIdentity(any(String.class))).thenReturn(savedUser);

    final UserEntity resUser = this.userService.save(testUser);

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getId(), savedUser.getId());
    Assert.assertEquals("Result user has firstname '" + savedUser.getFirstName() + "'!", resUser.getFirstName(), savedUser.getFirstName());
    Assert.assertEquals("Result user has lastname '" + savedUser.getLastName() + "'!", resUser.getLastName(), savedUser.getLastName());
    Assert.assertEquals("Result user has email '" + savedUser.getEmail() + "'!", resUser.getEmail(), savedUser.getEmail());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), savedUser.getStatus());

    verify(this.userDao, times(0)).create(any(UserEntity.class));
    verify(this.userDao, times(1)).update(any(UserEntity.class));
    verify(this.userDao, times(1)).getByIdentity(any(String.class));

  }
}

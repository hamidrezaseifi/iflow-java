package com.pth.iflow.core.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.service.IUsersService;
import com.pth.iflow.core.service.impl.UsersService;
import com.pth.iflow.core.storage.dao.IDepartmentDao;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.IUserDao;
import com.pth.iflow.core.storage.dao.IUserGroupDao;
import com.pth.iflow.core.storage.dao.IWorkflowDao;
import com.pth.iflow.core.storage.dao.IWorkflowStepDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest extends TestDataProducer {

  private IUsersService userService;

  @MockBean
  private IUserDao userDao;

  @MockBean
  private IUserGroupDao userGroupDao;

  @MockBean
  private IDepartmentDao departmentDao;

  @MockBean
  private IDepartmentGroupDao departmentGroupDao;

  @MockBean
  private IWorkflowDao workflowDao;

  @MockBean
  private IWorkflowStepDao workflowStepDao;

  @Before
  public void setUp() throws Exception {
    this.userService = new UsersService(userDao, userGroupDao, departmentDao, departmentGroupDao, workflowDao, workflowStepDao);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadUserById() throws Exception {

    final User user = getTestUser();
    when(this.userDao.getById(any(Long.class))).thenReturn(user);

    final User resUser = this.userService.getUserById(1L);

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
    when(this.userDao.getByEmail(any(String.class))).thenReturn(user);

    final User resUser = this.userService.getUserByEmail(user.getEmail());

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getId(), user.getId());
    Assert.assertEquals("Result user has firstname '" + user.getFirstName() + "'!", resUser.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has lastname '" + user.getLastName() + "'!", resUser.getLastName(), user.getLastName());
    Assert.assertEquals("Result user has email '" + user.getEmail() + "'!", resUser.getEmail(), user.getEmail());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());

  }

}

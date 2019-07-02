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
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.service.IUserGroupService;
import com.pth.iflow.core.service.impl.UserGroupService;
import com.pth.iflow.core.storage.dao.IUserDao;
import com.pth.iflow.core.storage.dao.IUserGroupDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserGroupServiceTest extends TestDataProducer {
  
  private IUserGroupService userGroupService;
  
  @MockBean
  private IUserDao userDao;
  
  @MockBean
  private IUserGroupDao userGroupDao;
  
  @Before
  public void setUp() throws Exception {
    this.userGroupService = new UserGroupService(this.userDao, this.userGroupDao);
  }
  
  @After
  public void tearDown() throws Exception {
  }
  
  @Test
  public void testGetById() throws Exception {
    
    final UserGroup userGroup = getTestUserGroup();
    when(this.userGroupDao.getById(any(Long.class))).thenReturn(userGroup);
    
    final UserGroup resUserGroup = this.userGroupService.getById(userGroup.getId());
    
    Assert.assertNotNull("Result user group is not null!", resUserGroup);
    Assert.assertEquals("Result user group has id 1!", resUserGroup.getId(), userGroup.getId());
    Assert.assertEquals("Result user group has title '" + userGroup.getTitle() + "'!", resUserGroup.getTitle(), userGroup.getTitle());
    Assert.assertEquals("Result user group has status 1!", resUserGroup.getStatus(), userGroup.getStatus());
    
  }
  
  @Test
  public void testGetListByIdList() throws Exception {
    
    final List<Long> idList = getTestUserGroupIdList();
    final List<UserGroup> list = getTestUserGroupList();
    when(this.userGroupDao.getListByIdList(any(List.class))).thenReturn(list);
    
    final List<UserGroup> resList = this.userGroupService.getListByIdList(idList);
    
    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());
    
  }

  @Test
  public void testGetListByIdCompanyId() throws Exception {
    
    final List<UserGroup> list = getTestUserGroupList();
    when(this.userGroupDao.getListByCompanyId(any(Long.class))).thenReturn(list);
    
    final List<UserGroup> resList = this.userGroupService.getListByIdCompanyId(1L);
    
    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());
    
  }

  @Test
  public void testListGroupUsers() throws Exception {
    
    final List<Long> idList = getTestUserIdList();
    final List<User> list = getTestUserList();
    when(this.userGroupDao.listGroupUserId(any(Long.class))).thenReturn(idList);
    when(this.userDao.getListByIdList(any(List.class))).thenReturn(list);

    final List<User> resList = this.userGroupService.listGroupUsers(1L);
    
    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());
    
  }

}

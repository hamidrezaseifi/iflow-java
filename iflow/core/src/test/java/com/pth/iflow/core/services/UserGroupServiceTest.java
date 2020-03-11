package com.pth.iflow.core.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.service.impl.UserGroupService;
import com.pth.iflow.core.service.interfaces.IUserGroupService;
import com.pth.iflow.core.storage.dao.interfaces.IUserGroupDao;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserGroupServiceTest extends TestDataProducer {

  private IUserGroupService userGroupService;

  @MockBean
  private IUserGroupDao userGroupDao;

  @Before
  public void setUp() throws Exception {

    this.userGroupService = new UserGroupService(userGroupDao);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetById() throws Exception {

    final UserGroupEntity userGroup = getTestUserGroup();
    when(this.userGroupDao.getByIdentity(any(String.class))).thenReturn(userGroup);

    final UserGroupEntity resUserGroup = this.userGroupService.getByIdentity(userGroup.getIdentity());

    Assert.assertNotNull("Result user group is not null!", resUserGroup);
    Assert.assertEquals("Result user group has id 1!", resUserGroup.getId(), userGroup.getId());
    Assert.assertEquals("Result user group has title '" + userGroup.getTitle() + "'!", resUserGroup.getTitle(), userGroup.getTitle());
    Assert.assertEquals("Result user group has status 1!", resUserGroup.getStatus(), userGroup.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = getTestUserGroupIdSet();
    final List<UserGroupEntity> list = getTestUserGroupList();
    when(this.userGroupDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final List<UserGroupEntity> resList = this.userGroupService.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByIdCompanyId() throws Exception {

    final List<UserGroupEntity> list = getTestUserGroupList();
    when(this.userGroupDao.getListByCompanyIdentity(any(String.class))).thenReturn(list);

    final List<UserGroupEntity> resList = this.userGroupService.getListByIdCompanyIdentity("companyIdentity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testSaveCreate() throws Exception {

    final UserGroupEntity usergroup = this.getTestUserGroup();
    usergroup.setId(null);
    usergroup.setIdentity("");
    final UserGroupEntity savedUsergroup = this.getTestUserGroup();
    when(this.userGroupDao.create(any(UserGroupEntity.class))).thenReturn(savedUsergroup);

    final UserGroupEntity result = this.userGroupService.save(usergroup);

    Assert.assertNotNull("Result user group is not null!", result);
    Assert
        .assertEquals("Result user group has title '" + savedUsergroup.getTitle() + "'!",
            result.getTitle(),
            savedUsergroup.getTitle());
    Assert.assertEquals("Result user group has status 1!", result.getStatus(), savedUsergroup.getStatus());

    verify(this.userGroupDao, times(1)).create(any(UserGroupEntity.class));
    verify(this.userGroupDao, times(0)).update(any(UserGroupEntity.class));

  }

  @Test
  public void testSaveUpdate() throws Exception {

    final UserGroupEntity usergroup = this.getTestUserGroup();

    final UserGroupEntity savedUsergroup = this.getTestUserGroup();
    when(this.userGroupDao.update(any(UserGroupEntity.class))).thenReturn(savedUsergroup);
    when(this.userGroupDao.getByIdentity(any(String.class))).thenReturn(savedUsergroup);

    final UserGroupEntity result = this.userGroupService.save(usergroup);

    Assert.assertNotNull("Result user group is not null!", result);
    Assert
        .assertEquals("Result user group has title '" + savedUsergroup.getTitle() + "'!",
            result.getTitle(),
            savedUsergroup.getTitle());
    Assert.assertEquals("Result user group has status 1!", result.getStatus(), savedUsergroup.getStatus());

    verify(this.userGroupDao, times(0)).create(any(UserGroupEntity.class));
    verify(this.userGroupDao, times(1)).update(any(UserGroupEntity.class));
    verify(this.userGroupDao, times(1)).getByIdentity(any(String.class));

  }

}

package com.pth.iflow.core.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;
import com.pth.iflow.core.storage.dao.interfaces.IUserGroupDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserDaoTest extends TestDataProducer {

  @Autowired
  private IUserDao               userDao;

  @Autowired
  private ICompanyDao            companyDao;

  @Autowired
  private IUserGroupDao          userGroupDao;

  private final List<UserEntity> createdModels = new ArrayList<>();

  @Before
  public void setUp() throws Exception {

  }

  private void createUserList() throws Exception {
    for (int i = 1; i <= 3; i++) {
      final UserEntity user = getTestNewUser();
      user.setEmail("utest email " + i);
      user.setFirstName("utest firstName " + i);
      user.setLastName("utest lastName " + i);
      user.setGroups(Arrays.asList(userGroupDao.getById(1L), userGroupDao.getById(2L)));
      final UserEntity res = userDao.create(user);
      createdModels.add(res);
    }
  }

  @After
  public void tearDown() throws Exception {

    for (final UserEntity model : createdModels) {
      userDao.deleteById(model.getId());
    }
  }

  @Test
  public void testGetById() throws Exception {

    createUserList();

    final UserEntity user    = createdModels.get(0);

    final UserEntity resUser = this.userDao.getById(createdModels.get(0).getId());

    compareUsers(user, resUser);

  }

  @Test
  public void testGetByIdentity() throws Exception {

    createUserList();

    final UserEntity user    = createdModels.get(0);

    final UserEntity resUser = this.userDao.getByIdentity(createdModels.get(0).getIdentity());

    compareUsers(user, resUser);

  }

  @Test
  public void testGetListByIdentityList() throws Exception {

    createUserList();

    final Set<String>      idList  = createdModels.stream().map(w -> w.getIdentity()).collect(Collectors.toSet());

    final List<UserEntity> resList = this.userDao.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + createdModels.size() + " items.", resList.size(), createdModels.size());

  }

  @Test
  public void testGetListByCompanyId() throws Exception {

    createUserList();

    final String           companyIdentity = companyDao.getById(createdModels.get(0).getCompanyId()).getIdentity();
    final List<UserEntity> resList         = this.userDao.getListByCompanyIdentity(companyIdentity);

    Assert.assertNotNull("Result list is not null!", resList);

    assertThat("Result list has " + createdModels.size() + " items.", resList.size(), greaterThanOrEqualTo(createdModels.size()));

  }

  @Test
  public void testCreate() throws Exception {

    final UserEntity user = getTestNewUser();
    user.setVersion(10);
    final UserEntity resUser = userDao.create(user);
    createdModels.add(resUser);

    compareUsers(user, resUser);

  }

  @Test
  public void testUpdate() throws Exception {

    final UserEntity user = getTestNewUser();
    user.setVersion(10);
    final UserEntity createdUser = userDao.create(user);
    createdModels.add(createdUser);

    Assert.assertNotNull("Result created user is not null!", createdUser);

    createdUser.setEmail("new updated email test");
    createdUser.setVersion(22);
    createdUser.setStatus(10);

    final UserEntity updatedUser = userDao.update(createdUser);

    compareUsers(createdUser, updatedUser);

    Assert.assertEquals("Result user has status 10!", updatedUser.getStatus().intValue(), 10);
    Assert.assertEquals("Result user has version 23!", updatedUser.getVersion().intValue(), 23);

  }

  @Test
  public void testDelete() throws Exception {

    final UserEntity user    = getTestNewUser();
    final UserEntity resUser = userDao.create(user);

    Assert.assertNotNull("Result user is not null!", resUser);

    userDao.deleteById(resUser.getId());

    final UserEntity deletedUser = this.userDao.getById(resUser.getId());

    Assert.assertNull("Result user is null!", deletedUser);

  }

  private void compareUsers(final UserEntity user, final UserEntity resUser) {
    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getId(), user.getId());
    Assert.assertEquals("Result user has email '" + user.getEmail() + "'!", resUser.getEmail(), user.getEmail());
    Assert.assertEquals("Result user has firstname '" + user.getFirstName() + "'!", resUser.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has lastname '" + user.getLastName() + "'!", resUser.getLastName(), user.getLastName());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());
    Assert.assertEquals("Result user has the same groups!", resUser.getGroups().size(), user.getGroups().size());
  }

}

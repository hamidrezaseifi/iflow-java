package com.pth.iflow.core.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import java.util.ArrayList;
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
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.storage.dao.IUserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserDaoTest extends TestDataProducer {

  @Autowired
  private IUserDao userDao;

  private final List<User> createdModels = new ArrayList<>();

  @Before
  public void setUp() throws Exception {

  }

  private void createUserList() throws Exception {
    for (int i = 1; i <= 3; i++) {
      final User user = getTestNewUser();
      user.setEmail("utest email " + i);
      user.setFirstName("utest firstName " + i);
      user.setLastName("utest lastName " + i);
      final User res = userDao.create(user);
      createdModels.add(res);
    }
  }

  @After
  public void tearDown() throws Exception {

    for (final User model : createdModels) {
      userDao.deleteById(model.getId());
    }
  }

  @Test
  public void testGetById() throws Exception {

    createUserList();

    final User user = createdModels.get(0);

    final User resUser = this.userDao.getById(createdModels.get(0).getId());

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has id 1!", resUser.getId(), user.getId());
    Assert.assertEquals("Result user has email '" + user.getEmail() + "'!", resUser.getEmail(), user.getEmail());
    Assert.assertEquals("Result user has firstname '" + user.getFirstName() + "'!", resUser.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has lastname '" + user.getLastName() + "'!", resUser.getLastName(), user.getLastName());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());
    Assert.assertEquals("Result user has the same groups!", resUser.getGroups(), user.getGroups());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    createUserList();

    final Set<Long> idList = createdModels.stream().map(w -> w.getId()).collect(Collectors.toSet());

    final List<User> resList = this.userDao.getListByIdList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + createdModels.size() + " items.", resList.size(), createdModels.size());

  }

  @Test
  public void testGetListByCompanyId() throws Exception {

    createUserList();

    final List<User> resList = this.userDao.getListByCompanyId(createdModels.get(0).getCompanyId());

    Assert.assertNotNull("Result list is not null!", resList);

    assertThat("Result list has " + createdModels.size() + " items.", resList.size(), greaterThanOrEqualTo(createdModels.size()));

  }

  @Test
  public void testCreate() throws Exception {

    final User user = getTestNewUser();
    user.setVersion(10);
    final User resUser = userDao.create(user);
    createdModels.add(resUser);

    Assert.assertNotNull("Result user is not null!", resUser);
    Assert.assertEquals("Result user has email '" + user.getEmail() + "'!", resUser.getEmail(), user.getEmail());
    Assert.assertEquals("Result user has firstname '" + user.getFirstName() + "'!", resUser.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has lastname '" + user.getLastName() + "'!", resUser.getLastName(), user.getLastName());
    Assert.assertEquals("Result user has status 1!", resUser.getStatus(), user.getStatus());
    Assert.assertEquals("Result user has the same groups!", resUser.getGroups(), user.getGroups());

  }

  @Test
  public void testUpdate() throws Exception {

    final User user = getTestNewUser();
    user.setVersion(10);
    final User createdUser = userDao.create(user);
    createdModels.add(createdUser);

    Assert.assertNotNull("Result created user is not null!", createdUser);

    createdUser.setEmail("new updated email test");
    createdUser.setVersion(22);
    createdUser.setStatus(10);

    final User updatedUser = userDao.update(createdUser);

    Assert.assertNotNull("Result user is not null!", updatedUser);
    Assert.assertEquals("Result user has the same id as created!", createdUser.getId(), updatedUser.getId());
    Assert.assertEquals("Result user has title '" + createdUser.getEmail() + "'!", createdUser.getEmail(), createdUser.getEmail());
    Assert.assertEquals("Result user has status 10!", updatedUser.getStatus().intValue(), 10);
    Assert.assertEquals("Result user has version 22!", updatedUser.getVersion().intValue(), 22);

  }

  @Test
  public void testDelete() throws Exception {

    final User user = getTestNewUser();
    final User resUser = userDao.create(user);

    Assert.assertNotNull("Result user is not null!", resUser);

    userDao.deleteById(resUser.getId());

    final User deletedUser = this.userDao.getById(resUser.getId());

    Assert.assertNull("Result user is null!", deletedUser);

  }
}

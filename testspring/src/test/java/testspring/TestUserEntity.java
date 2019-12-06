package testspring;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import testspring.models.UserDao;
import testspring.models.UserEntity;
import testspring.models.UserGroupEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class TestUserEntity {

  // @Autowired
  // private EntityManager entityManager;

  @Autowired
  private UserDao       userDao;

  final Set<UserEntity> createdModels = new HashSet<>();

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

    for (final UserEntity model : this.createdModels) {
      this.userDao.deleteById(model.getId());
    }
  }

  @Transactional
  @Test
  public void testGetById() throws Exception {

    // final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
    // final EntityManager entityManager = entityManagerFactory.createEntityManager();

    // final UserGroupEntity group1 = this.entityManager.find(UserGroupEntity.class, 1L);
    // final UserGroupEntity group2 = this.entityManager.find(UserGroupEntity.class, 2L);
    final UserGroupEntity      group1 = this.userDao.getUserGroupEntityById(1L);
    final UserGroupEntity      group2 = this.userDao.getUserGroupEntityById(2L);

    final Set<UserGroupEntity> groups = new HashSet<>();
    groups.add(group1);
    groups.add(group2);

    final UserEntity user1 = this.getTestNewUser();
    user1.setEmail("utest email 1");
    user1.setFirstName("utest firstName 1");
    user1.setLastName("utest lastName 1");

    final UserEntity user2 = this.getTestNewUser();
    user2.setEmail("utest email 2");
    user2.setFirstName("utest firstName 2");
    user2.setLastName("utest lastName 2");

    final Set<UserEntity> users = new HashSet<>();
    users.add(user1);
    users.add(user1);

    user1.setGroups(groups);
    user2.setGroups(groups);

    group1.setUsers(users);
    group2.setUsers(users);

    this.createdModels.add(this.userDao.create(user1));
    this.createdModels.add(this.userDao.create(user2));

  }

  private UserEntity getTestNewUser() {
    final UserEntity model = new UserEntity();
    model.setCompanyId(1L);
    model.setId(null);
    model.setEmail("utest email");
    model.setBirthDate(this.getTestBirthDate());
    model.setFirstName("utest firstName");
    model.setLastName("utest lastName");
    model.setStatus(1);
    model.setVersion(1);
    model.setPermission(1);

    return model;
  }

  private Date getTestBirthDate() {
    return new Date(Calendar.getInstance().getTime().getTime() - 30 * 365 * 24 * 60 * 60 * 100);
  }

}

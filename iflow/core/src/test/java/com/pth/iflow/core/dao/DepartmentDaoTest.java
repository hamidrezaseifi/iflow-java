package com.pth.iflow.core.dao;

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
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentDaoTest extends TestDataProducer {

  @Autowired
  private IDepartmentDao departmentDao;

  private final List<DepartmentEntity> createdModels = new ArrayList<>();

  @Before
  public void setUp() throws Exception {

  }

  private void createUserList() throws Exception {

    for (int i = 1; i <= 3; i++) {
      final DepartmentEntity model = getTestDepartment();
      model.setTitle("utest department " + i);
      model.setCompanyId(1L);
      model.setIdentity("utest-department-" + i);
      model.setId(null);

      final DepartmentEntity res = departmentDao.create(model);
      createdModels.add(res);
    }
  }

  @After
  public void tearDown() throws Exception {

    for (final DepartmentEntity model : createdModels) {
      departmentDao.deleteById(model.getId());
    }
  }

  @Test
  public void testGetById() throws Exception {

    createUserList();

    final DepartmentEntity model = createdModels.get(0);

    final DepartmentEntity res = this.departmentDao.getById(createdModels.get(0).getId());

    compareDepartments(model, res);
    Assert.assertEquals("Result model has id '" + res.getId() + "'!", res.getId(), model.getId());

  }

  @Test
  public void testGetByIdentity() throws Exception {

    createUserList();

    final DepartmentEntity model = createdModels.get(0);

    final DepartmentEntity result = this.departmentDao.getByIdentity(createdModels.get(0).getIdentity());

    compareDepartments(model, result);
    Assert.assertEquals("Result model has id '" + result.getId() + "'!", result.getId(), model.getId());

  }

  @Test
  public void testGetListByIdentityList() throws Exception {

    createUserList();

    final Set<String> idList = createdModels.stream().map(w -> w.getIdentity()).collect(Collectors.toSet());

    final List<DepartmentEntity> resList = this.departmentDao.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + createdModels.size() + " items.", resList.size(), createdModels.size());

  }

  @Test
  public void testCreate() throws Exception {

    final DepartmentEntity model = getTestDepartment();
    model.setVersion(10);
    final DepartmentEntity result = departmentDao.create(model);
    createdModels.add(result);

    compareDepartments(model, result);

  }

  @Test
  public void testUpdate() throws Exception {

    final DepartmentEntity model = getTestDepartment();
    model.setVersion(10);
    final DepartmentEntity created = departmentDao.create(model);
    createdModels.add(created);

    Assert.assertNotNull("Result created model is not null!", created);

    created.setTitle("new updated title test");
    created.setVersion(22);
    created.setStatus(10);

    final DepartmentEntity updated = departmentDao.update(created);

    compareDepartments(created, updated);

    Assert.assertEquals("Result model has status 10!", updated.getStatus(), created.getStatus());
    Assert.assertEquals("Result model has version 23!", updated.getVersion().intValue(), 23);
    Assert
        .assertEquals("Result model has title '" + created.getTitle() + "'!", updated.getTitle(),
            created.getTitle());

  }

  @Test
  public void testDelete() throws Exception {

    final DepartmentEntity model = getTestDepartment();
    final DepartmentEntity result = departmentDao.create(model);

    Assert.assertNotNull("Result model is not null!", result);

    departmentDao.deleteById(result.getId());

    final DepartmentEntity deleted = this.departmentDao.getById(result.getId());

    Assert.assertNull("Result model is null!", deleted);

  }

  private void compareDepartments(final DepartmentEntity model, final DepartmentEntity result) {

    Assert.assertNotNull("Result model is not null!", result);

    Assert.assertEquals("Result has email '" + model.getTitle() + "'!", result.getTitle(), model.getTitle());
    Assert.assertEquals("Result has identity '" + model.getIdentity() + "'!", result.getIdentity(), model.getIdentity());
    Assert.assertEquals("Result has status 1!", result.getStatus(), model.getStatus());
  }

}

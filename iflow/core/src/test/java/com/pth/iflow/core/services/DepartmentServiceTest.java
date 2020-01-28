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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.service.impl.DepartmentService;
import com.pth.iflow.core.service.interfaces.IDepartmentService;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentServiceTest extends TestDataProducer {

  private IDepartmentService departmentService;

  @MockBean
  private IDepartmentDao departmentDao;

  @Before
  public void setUp() throws Exception {

    this.departmentService = new DepartmentService(this.departmentDao);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetById() throws Exception {

    final DepartmentEntity department = this.getTestDepartment();
    when(this.departmentDao.getByIdentity(any(String.class))).thenReturn(department);

    final DepartmentEntity resDepartment = this.departmentService.getByIdentity(department.getIdentity());

    Assert.assertNotNull("Result department is not null!", resDepartment);
    Assert.assertEquals("Result department has id 1!", resDepartment.getId(), department.getId());
    Assert
        .assertEquals("Result department has title '" + department.getTitle() + "'!",
            resDepartment.getTitle(),
            department.getTitle());
    Assert.assertEquals("Result department has status 1!", resDepartment.getStatus(), department.getStatus());

  }

  @Test
  public void testSaveNew() throws Exception {

    final DepartmentEntity department = this.getTestDepartment();
    department.setId(null);
    when(this.departmentDao.create(any(DepartmentEntity.class))).thenReturn(department);

    final DepartmentEntity resDepartment = this.departmentService.save(department);

    Assert.assertNotNull("Result department is not null!", resDepartment);
    Assert.assertEquals("Result department has id 1!", resDepartment.getId(), department.getId());
    Assert
        .assertEquals("Result department has title '" + department.getTitle() + "'!",
            resDepartment.getTitle(),
            department.getTitle());
    Assert.assertEquals("Result department has status 1!", resDepartment.getStatus(), department.getStatus());

    verify(this.departmentDao, times(1)).create(any(DepartmentEntity.class));

  }

  @Test
  public void testSaveExists() throws Exception {

    final DepartmentEntity department = this.getTestDepartment();
    department.setId(1L);
    when(this.departmentDao.update(any(DepartmentEntity.class))).thenReturn(department);
    when(this.departmentDao.getByIdentity(any(String.class))).thenReturn(department);

    final DepartmentEntity resDepartment = this.departmentService.save(department);

    Assert.assertNotNull("Result department is not null!", resDepartment);
    Assert.assertEquals("Result department has id 1!", resDepartment.getId(), department.getId());
    Assert
        .assertEquals("Result department has title '" + department.getTitle() + "'!",
            resDepartment.getTitle(),
            department.getTitle());
    Assert.assertEquals("Result department has status 1!", resDepartment.getStatus(), department.getStatus());

    verify(this.departmentDao, times(1)).getByIdentity(any(String.class));
    verify(this.departmentDao, times(1)).update(any(DepartmentEntity.class));

  }

  @Test
  public void testDelete() throws Exception {

    final DepartmentEntity department = this.getTestDepartment();
    department.setId(1L);

    this.departmentService.delete(department);

    verify(this.departmentDao, times(1)).deleteById(any(Long.class));

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = this.getTestDepartmentIdSet();
    final List<DepartmentEntity> list = this.getTestDepartmentList();
    when(this.departmentDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final List<DepartmentEntity> resList = this.departmentService.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByIdCompanyId() throws Exception {

    final List<DepartmentEntity> list = this.getTestDepartmentList();
    when(this.departmentDao.getListByCompanyIdentity(any(String.class))).thenReturn(list);

    final List<DepartmentEntity> resList = this.departmentService.getListByIdCompanyIdentity("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetDepartmentGroups() throws Exception {

    final DepartmentEntity department = this.getTestDepartment();

    final List<DepartmentEntity> list = this.getTestDepartmentList();
    when(this.departmentDao.getByIdentity(any(String.class))).thenReturn(department);

    final List<DepartmentGroupEntity> resList = this.departmentService.getDepartmentGroups("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testSaveCreate() throws Exception {

    final DepartmentEntity department = this.getTestDepartment();
    department.setId(null);
    department.setIdentity("");
    final DepartmentEntity savedDepartment = this.getTestDepartment();
    when(this.departmentDao.create(any(DepartmentEntity.class))).thenReturn(savedDepartment);

    final DepartmentEntity result = this.departmentService.save(department);

    Assert.assertNotNull("Result department is not null!", result);
    Assert
        .assertEquals("Result department has title '" + savedDepartment.getTitle() + "'!",
            result.getTitle(),
            savedDepartment.getTitle());
    Assert.assertEquals("Result department has status 1!", result.getStatus(), savedDepartment.getStatus());

    verify(this.departmentDao, times(1)).create(any(DepartmentEntity.class));
    verify(this.departmentDao, times(0)).update(any(DepartmentEntity.class));

  }

  @Test
  public void testSaveUpdate() throws Exception {

    final DepartmentEntity department = this.getTestDepartment();

    final DepartmentEntity savedDepartment = this.getTestDepartment();
    when(this.departmentDao.update(any(DepartmentEntity.class))).thenReturn(savedDepartment);
    when(this.departmentDao.getByIdentity(any(String.class))).thenReturn(savedDepartment);

    final DepartmentEntity result = this.departmentService.save(department);

    Assert.assertNotNull("Result department is not null!", result);
    Assert
        .assertEquals("Result department has title '" + savedDepartment.getTitle() + "'!",
            result.getTitle(),
            savedDepartment.getTitle());
    Assert.assertEquals("Result department has status 1!", result.getStatus(), savedDepartment.getStatus());

    verify(this.departmentDao, times(0)).create(any(DepartmentEntity.class));
    verify(this.departmentDao, times(1)).update(any(DepartmentEntity.class));
    verify(this.departmentDao, times(1)).getByIdentity(any(String.class));

  }

}

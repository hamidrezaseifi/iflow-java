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
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.service.impl.DepartmentGroupService;
import com.pth.iflow.core.service.interfaces.IDepartmentGroupService;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentGroupDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentGroupServiceTest extends TestDataProducer {

  private IDepartmentGroupService departmentGroupService;

  @MockBean
  private IDepartmentGroupDao departmentGroupDao;

  @Before
  public void setUp() throws Exception {

    this.departmentGroupService = new DepartmentGroupService(this.departmentGroupDao);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetById() throws Exception {

    final DepartmentGroupEntity departmentGroup = this.getTestDepartmentGroup();
    when(this.departmentGroupDao.getByIdentity(any(String.class))).thenReturn(departmentGroup);

    final DepartmentGroupEntity resDepartmentGroup = this.departmentGroupService.getByIdentity(departmentGroup.getIdentity());

    Assert.assertNotNull("Result department group is not null!", resDepartmentGroup);
    Assert.assertEquals("Result department group has id 1!", resDepartmentGroup.getId(), departmentGroup.getId());
    Assert
        .assertEquals("Result department group has title '" + departmentGroup.getTitle() + "'!",
            resDepartmentGroup.getTitle(),
            departmentGroup.getTitle());
    Assert.assertEquals("Result department group has status 1!", resDepartmentGroup.getStatus(), departmentGroup.getStatus());

  }

  @Test
  public void testSaveNew() throws Exception {

    final DepartmentGroupEntity department = this.getTestDepartmentGroup();
    department.setId(null);
    when(this.departmentGroupDao.create(any(DepartmentGroupEntity.class))).thenReturn(department);

    final DepartmentGroupEntity resDepartment = this.departmentGroupService.save(department);

    Assert.assertNotNull("Result department is not null!", resDepartment);
    Assert.assertEquals("Result department has id 1!", resDepartment.getId(), department.getId());
    Assert
        .assertEquals("Result department has title '" + department.getTitle() + "'!",
            resDepartment.getTitle(),
            department.getTitle());
    Assert.assertEquals("Result department has status 1!", resDepartment.getStatus(), department.getStatus());

    verify(this.departmentGroupDao, times(1)).create(any(DepartmentGroupEntity.class));

  }

  @Test
  public void testSaveExists() throws Exception {

    final DepartmentGroupEntity department = this.getTestDepartmentGroup();
    department.setId(1L);
    when(this.departmentGroupDao.update(any(DepartmentGroupEntity.class))).thenReturn(department);
    when(this.departmentGroupDao.getByIdentity(any(String.class))).thenReturn(department);

    final DepartmentGroupEntity resDepartment = this.departmentGroupService.save(department);

    Assert.assertNotNull("Result department is not null!", resDepartment);
    Assert.assertEquals("Result department has id 1!", resDepartment.getId(), department.getId());
    Assert
        .assertEquals("Result department has title '" + department.getTitle() + "'!",
            resDepartment.getTitle(),
            department.getTitle());
    Assert.assertEquals("Result department has status 1!", resDepartment.getStatus(), department.getStatus());

    verify(this.departmentGroupDao, times(1)).getByIdentity(any(String.class));
    verify(this.departmentGroupDao, times(1)).update(any(DepartmentGroupEntity.class));

  }

  @Test
  public void testDelete() throws Exception {

    final DepartmentGroupEntity department = this.getTestDepartmentGroup();
    department.setId(1L);

    this.departmentGroupService.delete(department);

    verify(this.departmentGroupDao, times(1)).deleteById(any(Long.class));

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = this.getTestDepartmentIdSet();
    final List<DepartmentGroupEntity> list = this.getTestDepartmentGroupList();
    when(this.departmentGroupDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final List<DepartmentGroupEntity> resList = this.departmentGroupService.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testSaveCreate() throws Exception {

    final DepartmentGroupEntity departmentGroup = this.getTestDepartmentGroup();
    departmentGroup.setId(null);
    departmentGroup.setIdentity("");
    final DepartmentGroupEntity savedDepartmentGroup = this.getTestDepartmentGroup();
    when(this.departmentGroupDao.create(any(DepartmentGroupEntity.class))).thenReturn(savedDepartmentGroup);

    final DepartmentGroupEntity result = this.departmentGroupService.save(departmentGroup);

    Assert.assertNotNull("Result department group is not null!", result);
    Assert
        .assertEquals("Result department group has title '" + savedDepartmentGroup.getTitle() + "'!",
            result.getTitle(),
            savedDepartmentGroup.getTitle());
    Assert.assertEquals("Result department group has status 1!", result.getStatus(), savedDepartmentGroup.getStatus());

    verify(this.departmentGroupDao, times(1)).create(any(DepartmentGroupEntity.class));
    verify(this.departmentGroupDao, times(0)).update(any(DepartmentGroupEntity.class));

  }

  @Test
  public void testSaveUpdate() throws Exception {

    final DepartmentGroupEntity departmentGroup = this.getTestDepartmentGroup();

    final DepartmentGroupEntity savedDepartmentGroup = this.getTestDepartmentGroup();
    when(this.departmentGroupDao.update(any(DepartmentGroupEntity.class))).thenReturn(savedDepartmentGroup);
    when(this.departmentGroupDao.getByIdentity(any(String.class))).thenReturn(savedDepartmentGroup);

    final DepartmentGroupEntity result = this.departmentGroupService.save(departmentGroup);

    Assert.assertNotNull("Result department group is not null!", result);
    Assert
        .assertEquals("Result department group has title '" + savedDepartmentGroup.getTitle() + "'!",
            result.getTitle(),
            savedDepartmentGroup.getTitle());
    Assert.assertEquals("Result department group has status 1!", result.getStatus(), savedDepartmentGroup.getStatus());

    verify(this.departmentGroupDao, times(0)).create(any(DepartmentGroupEntity.class));
    verify(this.departmentGroupDao, times(1)).update(any(DepartmentGroupEntity.class));
    verify(this.departmentGroupDao, times(1)).getByIdentity(any(String.class));

  }

}

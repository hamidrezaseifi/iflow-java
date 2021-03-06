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
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;
import com.pth.iflow.core.service.impl.WorkflowTypeService;
import com.pth.iflow.core.service.interfaces.IWorkflowTypeService;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeStepDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeServiceTest extends TestDataProducer {

  private IWorkflowTypeService workflowTypeService;

  @MockBean
  private IWorkflowTypeDao workflowTypeDao;

  @MockBean
  private IWorkflowTypeStepDao workflowTypeStepDao;

  @Before
  public void setUp() throws Exception {
    this.workflowTypeService = new WorkflowTypeService(this.workflowTypeDao);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final WorkflowTypeEntity workflowType = getTestWorkflowType();
    when(this.workflowTypeDao.getByIdentity(any(String.class))).thenReturn(workflowType);

    final WorkflowTypeEntity resWorkflowType = this.workflowTypeService.getByIdentity("identity");

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowType.getId(), workflowType.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflowType.getTitle() + "'!",
                        resWorkflowType.getTitle(),
                        workflowType.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflowType.getStatus(), workflowType.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = getTestWorkflowTypeIdSet();
    final List<WorkflowTypeEntity> list = getTestWorkflowTypeList();
    when(this.workflowTypeDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final List<WorkflowTypeEntity> resList = this.workflowTypeService.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByIdCompanyId() throws Exception {

    final List<WorkflowTypeEntity> list = getTestWorkflowTypeList();
    when(this.workflowTypeDao.getListByCompanyIdentity(any(String.class))).thenReturn(list);

    final List<WorkflowTypeEntity> resList = this.workflowTypeService.getListByIdCompanyId("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetStepsById() throws Exception {

    final WorkflowTypeEntity workflowType = getTestWorkflowType();
    final List<WorkflowTypeStepEntity> list = getTestWorkflowTypeStepList();

    when(this.workflowTypeDao.getByIdentity(any(String.class))).thenReturn(workflowType);

    final List<WorkflowTypeStepEntity> resList = this.workflowTypeService.getStepsByIdentity("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testSaveCreate() throws Exception {

    final WorkflowTypeEntity workflowType = this.getTestWorkflowType();
    workflowType.setId(null);
    workflowType.setIdentity("");
    final WorkflowTypeEntity savedWorkflowType = this.getTestWorkflowType();
    savedWorkflowType.setId(1L);
    when(this.workflowTypeDao.create(any(WorkflowTypeEntity.class))).thenReturn(savedWorkflowType);

    final WorkflowTypeEntity resWorkflowType = this.workflowTypeService.save(workflowType);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowType.getId(), savedWorkflowType.getId());
    Assert.assertEquals("Result workflow-type has title '" + savedWorkflowType.getTitle() + "'!",
                        resWorkflowType.getTitle(),
                        savedWorkflowType.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflowType.getStatus(), savedWorkflowType.getStatus());

    verify(this.workflowTypeDao, times(1)).create(any(WorkflowTypeEntity.class));
    verify(this.workflowTypeDao, times(0)).update(any(WorkflowTypeEntity.class));

  }

  @Test
  public void testSaveUpdate() throws Exception {

    final WorkflowTypeEntity workflowType = this.getTestWorkflowType();

    final WorkflowTypeEntity savedWorkflowType = this.getTestWorkflowType();
    when(this.workflowTypeDao.update(any(WorkflowTypeEntity.class))).thenReturn(savedWorkflowType);
    when(this.workflowTypeDao.getByIdentity(any(String.class))).thenReturn(savedWorkflowType);

    final WorkflowTypeEntity resWorkflowType = this.workflowTypeService.save(workflowType);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowType.getId(), workflowType.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflowType.getTitle() + "'!",
                        resWorkflowType.getTitle(),
                        workflowType.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflowType.getStatus(), workflowType.getStatus());

    verify(this.workflowTypeDao, times(0)).create(any(WorkflowTypeEntity.class));
    verify(this.workflowTypeDao, times(1)).update(any(WorkflowTypeEntity.class));
    verify(this.workflowTypeDao, times(1)).getByIdentity(any(String.class));

  }
}

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
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;
import com.pth.iflow.core.service.impl.WorkflowTypeStepService;
import com.pth.iflow.core.service.interfaces.IWorkflowTypeStepService;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeStepDao;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class WorkflowTypeStepServiceTest extends TestDataProducer {

  private IWorkflowTypeStepService workflowTypeStepService;

  @MockBean
  private IWorkflowTypeStepDao workflowTypeStepDao;

  @MockBean
  private IWorkflowTypeDao workflowTypeDao;

  @Before
  public void setUp() throws Exception {

    this.workflowTypeStepService = new WorkflowTypeStepService(this.workflowTypeStepDao, workflowTypeDao);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetById() throws Exception {

    final WorkflowTypeStepEntity workflowType = getTestWorkflowTypeStep();
    when(this.workflowTypeStepDao.getByIdentity(any(String.class))).thenReturn(workflowType);

    final WorkflowTypeStepEntity resWorkflowType = this.workflowTypeStepService.getByIdentity(workflowType.getIdentity());

    Assert.assertNotNull("Result workflow-type-step is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type-step has id 1!", resWorkflowType.getId(), workflowType.getId());
    Assert
        .assertEquals("Result workflow-type-step has title '" + workflowType.getTitle() + "'!",
            resWorkflowType.getTitle(),
            workflowType.getTitle());
    Assert.assertEquals("Result workflow-type-step has status 1!", resWorkflowType.getStatus(), workflowType.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = getTestWorkflowTypeIdSet();
    final List<WorkflowTypeStepEntity> list = getTestWorkflowTypeStepList();
    when(this.workflowTypeStepDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final List<WorkflowTypeStepEntity> resList = this.workflowTypeStepService.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByWorkflowTypeId() throws Exception {

    final WorkflowTypeEntity type = getTestWorkflowType();
    when(this.workflowTypeDao.getByIdentity(any(String.class))).thenReturn(type);

    final List<WorkflowTypeStepEntity> resList = this.workflowTypeStepService.getListByWorkflowTypeIdentity("workflowIdentity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + type.getSteps().size() + " items.", resList.size(), type.getSteps().size());

  }

  @Test
  public void testSaveCreate() throws Exception {

    final WorkflowTypeStepEntity workflowType = this.getTestWorkflowTypeStep();
    workflowType.setId(null);
    workflowType.setIdentity("");
    final WorkflowTypeStepEntity savedWorkflowType = this.getTestWorkflowTypeStep();
    savedWorkflowType.setId(1L);
    when(this.workflowTypeStepDao.create(any(WorkflowTypeStepEntity.class))).thenReturn(savedWorkflowType);

    final WorkflowTypeStepEntity resWorkflowType = this.workflowTypeStepService.save(workflowType);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowType.getId(), savedWorkflowType.getId());
    Assert
        .assertEquals("Result workflow-type has title '" + savedWorkflowType.getTitle() + "'!",
            resWorkflowType.getTitle(),
            savedWorkflowType.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflowType.getStatus(), savedWorkflowType.getStatus());

    verify(this.workflowTypeStepDao, times(1)).create(any(WorkflowTypeStepEntity.class));
    verify(this.workflowTypeStepDao, times(0)).update(any(WorkflowTypeStepEntity.class));

  }

  @Test
  public void testSaveUpdate() throws Exception {

    final WorkflowTypeStepEntity workflowType = this.getTestWorkflowTypeStep();

    final WorkflowTypeStepEntity savedWorkflowType = this.getTestWorkflowTypeStep();
    when(this.workflowTypeStepDao.update(any(WorkflowTypeStepEntity.class))).thenReturn(savedWorkflowType);
    when(this.workflowTypeStepDao.getByIdentity(any(String.class))).thenReturn(savedWorkflowType);

    final WorkflowTypeStepEntity resWorkflowType = this.workflowTypeStepService.save(workflowType);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowType.getId(), workflowType.getId());
    Assert
        .assertEquals("Result workflow-type has title '" + workflowType.getTitle() + "'!",
            resWorkflowType.getTitle(),
            workflowType.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflowType.getStatus(), workflowType.getStatus());

    verify(this.workflowTypeStepDao, times(0)).create(any(WorkflowTypeStepEntity.class));
    verify(this.workflowTypeStepDao, times(1)).update(any(WorkflowTypeStepEntity.class));
    verify(this.workflowTypeStepDao, times(1)).getByIdentity(any(String.class));

  }

}

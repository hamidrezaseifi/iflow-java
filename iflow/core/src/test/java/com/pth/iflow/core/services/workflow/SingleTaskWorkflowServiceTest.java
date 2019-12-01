package com.pth.iflow.core.services.workflow;

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
import com.pth.iflow.core.model.entity.workflow.SingleTaskWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.service.impl.workflow.SingleTaskWorkflowService;
import com.pth.iflow.core.service.interfaces.workflow.ISingleTaskWorkflowService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.workflow.ISingleTaskWorkflowDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SingleTaskWorkflowServiceTest extends TestDataProducer {

  private ISingleTaskWorkflowService singleTaskWorkflowService;

  @MockBean
  private ISingleTaskWorkflowDao     workflowDao;

  @MockBean
  private IWorkflowService           workflowService;

  @Before
  public void setUp() throws Exception {
    this.singleTaskWorkflowService = new SingleTaskWorkflowService(this.workflowDao, this.workflowService);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSaveCreate() {
    final SingleTaskWorkflowEntity model = getTestNewSingleTaskWorkflowWorkflow();

    final SingleTaskWorkflowEntity savedModel = getTestSingleTaskWorkflow(1L);

    when(this.workflowDao.create(any(SingleTaskWorkflowEntity.class))).thenReturn(savedModel);
    when(this.workflowDao.getById(any(Long.class))).thenReturn(savedModel);
    when(this.workflowService.prepareSavingModel(any(WorkflowEntity.class))).thenReturn(savedModel.getWorkflow());

    final SingleTaskWorkflowEntity result = singleTaskWorkflowService.save(model);

    Assert.assertNotNull("Result is not null!", result);
    Assert.assertEquals("Result has " + result.getWorkflow().getIdentity() + " identity.", result.getWorkflow().getIdentity(),
        result.getWorkflow().getIdentity());
    Assert.assertEquals("Result has " + result.getWorkflow().getControllerIdentity() + " controller.",
        result.getWorkflow().getControllerIdentity(), result.getWorkflow().getControllerIdentity());
    Assert.assertEquals("Result has " + result.getWorkflow().getCurrentStep().getIdentity() + " step.",
        result.getWorkflow().getCurrentStep().getIdentity(), result.getWorkflow().getCurrentStep().getIdentity());
    Assert.assertEquals("Result has " + result.getWorkflow().getWorkflowTypeIdentity() + " workflow-type.",
        result.getWorkflow().getWorkflowTypeIdentity(), result.getWorkflow().getWorkflowTypeIdentity());

    verify(this.workflowDao, times(1)).create(any(SingleTaskWorkflowEntity.class));
    verify(this.workflowDao, times(0)).getById(any(long.class));
    verify(this.workflowService, times(1)).prepareSavingModel(any(WorkflowEntity.class));

  }

  @Test
  public void testSaveUpdate() {
    final SingleTaskWorkflowEntity model = getTestSingleTaskWorkflow(1L);

    final SingleTaskWorkflowEntity savedModel = getTestSingleTaskWorkflow(1L);

    when(this.workflowDao.update(any(SingleTaskWorkflowEntity.class))).thenReturn(savedModel);
    when(this.workflowDao.getById(any(Long.class))).thenReturn(savedModel);
    when(this.workflowService.prepareSavingModel(any(WorkflowEntity.class))).thenReturn(savedModel.getWorkflow());

    final SingleTaskWorkflowEntity result = singleTaskWorkflowService.save(model);

    Assert.assertNotNull("Result is not null!", result);
    Assert.assertEquals("Result has " + result.getWorkflow().getIdentity() + " identity.", result.getWorkflow().getIdentity(),
        result.getWorkflow().getIdentity());
    Assert.assertEquals("Result has " + result.getWorkflow().getControllerIdentity() + " controller.",
        result.getWorkflow().getControllerIdentity(), result.getWorkflow().getControllerIdentity());
    Assert.assertEquals("Result has " + result.getWorkflow().getCurrentStep().getIdentity() + " step.",
        result.getWorkflow().getCurrentStep().getIdentity(), result.getWorkflow().getCurrentStep().getIdentity());
    Assert.assertEquals("Result has " + result.getWorkflow().getWorkflowTypeIdentity() + " workflow-type.",
        result.getWorkflow().getWorkflowTypeIdentity(), result.getWorkflow().getWorkflowTypeIdentity());

    verify(this.workflowDao, times(1)).update(any(SingleTaskWorkflowEntity.class));
    verify(this.workflowDao, times(1)).getById(any(long.class));
    verify(this.workflowService, times(1)).prepareSavingModel(any(WorkflowEntity.class));
  }

  @Test
  public void testGetByIdentity() {
    final SingleTaskWorkflowEntity model = getTestSingleTaskWorkflow(1L);

    when(this.workflowDao.getByIdentity(any(String.class))).thenReturn(model);

    final SingleTaskWorkflowEntity result = singleTaskWorkflowService.getByIdentity("test-identity");

    Assert.assertNotNull("Result is not null!", result);
    Assert.assertEquals("Result has " + result.getWorkflow().getIdentity() + " identity.", result.getWorkflow().getIdentity(),
        result.getWorkflow().getIdentity());
    Assert.assertEquals("Result has " + result.getWorkflow().getControllerIdentity() + " controller.",
        result.getWorkflow().getControllerIdentity(), result.getWorkflow().getControllerIdentity());
    Assert.assertEquals("Result has " + result.getWorkflow().getCurrentStep().getIdentity() + " step.",
        result.getWorkflow().getCurrentStep().getIdentity(), result.getWorkflow().getCurrentStep().getIdentity());
    Assert.assertEquals("Result has " + result.getWorkflow().getWorkflowTypeIdentity() + " workflow-type.",
        result.getWorkflow().getWorkflowTypeIdentity(), result.getWorkflow().getWorkflowTypeIdentity());

    verify(this.workflowDao, times(1)).getByIdentity(any(String.class));

  }

  @Test
  public void testGetListForUser() {
    final List<SingleTaskWorkflowEntity> modelList = getTestSingleTaskWorkflowList();

    when(this.workflowDao.getListForUserIdentity(any(String.class), any(Integer.class))).thenReturn(modelList);

    final List<SingleTaskWorkflowEntity> resultList = singleTaskWorkflowService.getListForUser("test-identity", 1);

    Assert.assertNotNull("Result list is not null!", resultList);
    Assert.assertEquals("Result list has " + modelList.size() + " items.", resultList.size(), modelList.size());

    verify(this.workflowDao, times(1)).getListForUserIdentity(any(String.class), any(Integer.class));
  }

  @Test
  public void testGetListByIdentityList() {
    final Set<String> idList = getTestWorkflowIdentityList();
    final List<SingleTaskWorkflowEntity> modelList = getTestSingleTaskWorkflowList();

    when(this.workflowDao.getListByIdentityList(any(Set.class))).thenReturn(modelList);

    final List<SingleTaskWorkflowEntity> resultList = singleTaskWorkflowService.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resultList);
    Assert.assertEquals("Result list has " + modelList.size() + " items.", resultList.size(), modelList.size());

    verify(this.workflowDao, times(1)).getListByIdentityList(any(Set.class));
  }
}

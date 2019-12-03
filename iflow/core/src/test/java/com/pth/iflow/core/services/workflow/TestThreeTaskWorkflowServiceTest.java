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
import com.pth.iflow.core.model.entity.workflow.TestThreeTaskWorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.service.impl.workflow.TestThreeTaskWorkflowService;
import com.pth.iflow.core.service.interfaces.workflow.ITestThreeTaskWorkflowService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.workflow.ITestThreeTaskWorkflowDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestThreeTaskWorkflowServiceTest extends TestDataProducer {

  private ITestThreeTaskWorkflowService testThreeTaskWorkflowService;

  @MockBean
  private ITestThreeTaskWorkflowDao     workflowDao;

  @MockBean
  private IWorkflowService              workflowService;

  @Before
  public void setUp() throws Exception {
    this.testThreeTaskWorkflowService = new TestThreeTaskWorkflowService(this.workflowDao, this.workflowService);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSaveCreate() {
    final TestThreeTaskWorkflowEntity model = getTestNewTestThreeTaskWorkflow();

    final TestThreeTaskWorkflowEntity savedModel = getTestTestThreeTaskWorkflow(1L);

    when(this.workflowDao.create(any(TestThreeTaskWorkflowEntity.class))).thenReturn(savedModel);
    when(this.workflowDao.getById(any(Long.class))).thenReturn(savedModel);
    when(this.workflowService.prepareSavingModel(any(WorkflowEntity.class))).thenReturn(savedModel.getWorkflow());

    final TestThreeTaskWorkflowEntity result = testThreeTaskWorkflowService.save(model);

    assetWorkflow(savedModel, result);

    verify(this.workflowDao, times(1)).create(any(TestThreeTaskWorkflowEntity.class));
    verify(this.workflowDao, times(0)).getById(any(long.class));
    verify(this.workflowService, times(1)).prepareSavingModel(any(WorkflowEntity.class));

  }

  @Test
  public void testSaveUpdate() {
    final TestThreeTaskWorkflowEntity model = getTestTestThreeTaskWorkflow(1L);

    final TestThreeTaskWorkflowEntity savedModel = getTestTestThreeTaskWorkflow(1L);

    when(this.workflowDao.update(any(TestThreeTaskWorkflowEntity.class))).thenReturn(savedModel);
    when(this.workflowDao.getById(any(Long.class))).thenReturn(savedModel);
    when(this.workflowService.prepareSavingModel(any(WorkflowEntity.class))).thenReturn(savedModel.getWorkflow());

    final TestThreeTaskWorkflowEntity result = testThreeTaskWorkflowService.save(model);

    assetWorkflow(savedModel, result);

    verify(this.workflowDao, times(1)).update(any(TestThreeTaskWorkflowEntity.class));
    verify(this.workflowDao, times(1)).getById(any(long.class));
    verify(this.workflowService, times(1)).prepareSavingModel(any(WorkflowEntity.class));
  }

  @Test
  public void testGetByIdentity() {
    final TestThreeTaskWorkflowEntity model = getTestTestThreeTaskWorkflow(1L);

    when(this.workflowDao.getByIdentity(any(String.class))).thenReturn(model);

    final TestThreeTaskWorkflowEntity result = testThreeTaskWorkflowService.getByIdentity("test-identity");

    assetWorkflow(model, result);

    verify(this.workflowDao, times(1)).getByIdentity(any(String.class));

  }

  @Test
  public void testGetListForUser() {
    final List<TestThreeTaskWorkflowEntity> modelList = getTestTestThreeWorkflowList();

    when(this.workflowDao.getListForUserIdentity(any(String.class), any(Integer.class))).thenReturn(modelList);

    final List<TestThreeTaskWorkflowEntity> resultList = testThreeTaskWorkflowService.getListForUser("test-identity", 1);

    Assert.assertNotNull("Result list is not null!", resultList);
    Assert.assertEquals("Result list has " + modelList.size() + " items.", resultList.size(), modelList.size());

    verify(this.workflowDao, times(1)).getListForUserIdentity(any(String.class), any(Integer.class));
  }

  @Test
  public void testGetListByIdentityList() {
    final Set<String> idList = getTestWorkflowIdentityList();
    final List<TestThreeTaskWorkflowEntity> modelList = getTestTestThreeWorkflowList();

    when(this.workflowDao.getListByIdentityList(any(Set.class))).thenReturn(modelList);

    final List<TestThreeTaskWorkflowEntity> resultList = testThreeTaskWorkflowService.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resultList);
    Assert.assertEquals("Result list has " + modelList.size() + " items.", resultList.size(), modelList.size());

    verify(this.workflowDao, times(1)).getListByIdentityList(any(Set.class));
  }

  private void assetWorkflow(final TestThreeTaskWorkflowEntity savedModel, final TestThreeTaskWorkflowEntity result) {
    Assert.assertNotNull("Result is not null!", result);
    Assert.assertEquals("Result has " + result.getWorkflow().getIdentity() + " identity.", result.getWorkflow().getIdentity(),
        savedModel.getWorkflow().getIdentity());
    Assert.assertEquals("Result has " + result.getWorkflow().getControllerIdentity() + " controller.",
        result.getWorkflow().getControllerIdentity(), savedModel.getWorkflow().getControllerIdentity());
    Assert.assertEquals("Result has " + result.getWorkflow().getCurrentStepId() + " step.", result.getWorkflow().getCurrentStepId(),
        savedModel.getWorkflow().getCurrentStepId());
    Assert.assertEquals("Result has " + result.getWorkflow().getWorkflowTypeIdentity() + " workflow-type.",
        result.getWorkflow().getWorkflowTypeIdentity(), savedModel.getWorkflow().getWorkflowTypeIdentity());
  }

}

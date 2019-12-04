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
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;
import com.pth.iflow.core.service.impl.workflow.WorkflowService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeStepDao;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowServiceTest extends TestDataProducer {

  private IWorkflowService     workflowService;

  @MockBean
  private IWorkflowDao         workflowDao;

  @MockBean
  private IWorkflowTypeDao     workflowTypeDao;

  @MockBean
  private IWorkflowTypeStepDao workflowTypeStepDao;

  @MockBean
  private IUserDao             usersDao;

  @Before
  public void setUp() throws Exception {
    this.workflowService = new WorkflowService(this.workflowDao, workflowTypeDao, workflowTypeStepDao, usersDao);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSaveCreate() {
    final WorkflowEntity model = getTestNewWorkflow();
    final UserEntity testUser = getTestUser(1L, "fn", "ln", "email");
    final WorkflowTypeStepEntity testStep = getTestWorkflowTypeStep(1L, "step1");
    final WorkflowTypeEntity testType = getTestWorkflowType(1L, "test-type");

    final WorkflowEntity savedModel = getTestWorkflow(1L);

    when(this.workflowDao.create(any(WorkflowEntity.class))).thenReturn(savedModel);
    when(this.workflowDao.getByIdentity(any(String.class))).thenReturn(savedModel);
    when(this.usersDao.getByIdentity(any(String.class))).thenReturn(testUser);
    when(this.workflowTypeStepDao.getByIdentity(any(String.class))).thenReturn(testStep);
    when(this.workflowTypeDao.getByIdentity(any(String.class))).thenReturn(testType);

    final WorkflowEntity result = workflowService.save(model);

    assetWorkflow(savedModel, result);

    verify(this.workflowDao, times(1)).create(any(WorkflowEntity.class));

  }

  @Test
  public void testSaveUpdate() {
    final WorkflowEntity model = getTestWorkflow(1L);
    final UserEntity testUser = getTestUser(1L, "fn", "ln", "email");
    final WorkflowTypeStepEntity testStep = getTestWorkflowTypeStep(1L, "step1");
    final WorkflowTypeEntity testType = getTestWorkflowType(1L, "test-type");

    final WorkflowEntity savedModel = getTestWorkflow(1L);

    when(this.workflowDao.update(any(WorkflowEntity.class))).thenReturn(savedModel);
    when(this.workflowDao.getByIdentity(any(String.class))).thenReturn(savedModel);
    when(this.workflowDao.getById(any(Long.class))).thenReturn(savedModel);
    when(this.usersDao.getByIdentity(any(String.class))).thenReturn(testUser);
    when(this.workflowTypeStepDao.getByIdentity(any(String.class))).thenReturn(testStep);
    when(this.workflowTypeDao.getByIdentity(any(String.class))).thenReturn(testType);

    final WorkflowEntity result = workflowService.save(model);

    assetWorkflow(savedModel, result);

    verify(this.workflowDao, times(1)).update(any(WorkflowEntity.class));
    verify(this.workflowDao, times(1)).getById(any(Long.class));
  }

  @Test
  public void testGetByIdentity() {
    final WorkflowEntity model = getTestWorkflow(1L);

    when(this.workflowDao.getByIdentity(any(String.class))).thenReturn(model);

    final WorkflowEntity result = workflowService.getByIdentity("test-identity");

    assetWorkflow(model, result);

    verify(this.workflowDao, times(1)).getByIdentity(any(String.class));

  }

  @Test
  public void testGetListForUser() {
    final List<WorkflowEntity> modelList = getTestWorkflowList();

    when(this.workflowDao.getListForUserIdentity(any(String.class), any(Integer.class))).thenReturn(modelList);

    final List<WorkflowEntity> resultList = workflowService.getListForUser("test-identity", 1);

    Assert.assertNotNull("Result list is not null!", resultList);
    Assert.assertEquals("Result list has " + modelList.size() + " items.", resultList.size(), modelList.size());

    verify(this.workflowDao, times(1)).getListForUserIdentity(any(String.class), any(Integer.class));
  }

  @Test
  public void testGetListByIdentityList() {
    final Set<String> idList = getTestWorkflowIdentityList();
    final List<WorkflowEntity> modelList = getTestWorkflowList();

    when(this.workflowDao.getListByIdentityList(any(Set.class))).thenReturn(modelList);

    final List<WorkflowEntity> resultList = workflowService.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resultList);
    Assert.assertEquals("Result list has " + modelList.size() + " items.", resultList.size(), modelList.size());

    verify(this.workflowDao, times(1)).getListByIdentityList(any(Set.class));
  }

  private void assetWorkflow(final WorkflowEntity savedModel, final WorkflowEntity result) {
    Assert.assertNotNull("Result is not null!", result);
    Assert.assertEquals("Result has " + result.getIdentity() + " identity.", result.getIdentity(), savedModel.getIdentity());
    Assert.assertEquals("Result has " + result.getControllerId() + " controller.", result.getControllerId(), savedModel.getControllerId());
    Assert.assertEquals("Result has " + result.getCurrentStepId() + " step.", result.getCurrentStepId(), savedModel.getCurrentStepId());
    Assert.assertEquals("Result has " + result.getWorkflowTypeId() + " workflow-type.", result.getWorkflowTypeId(),
        savedModel.getWorkflowTypeId());
  }

}

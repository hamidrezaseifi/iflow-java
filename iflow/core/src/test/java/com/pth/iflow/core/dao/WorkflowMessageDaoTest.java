package com.pth.iflow.core.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.models.edo.WorkflowMessageEdo;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;
import com.pth.iflow.core.service.interfaces.IWorkflowMessageService;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowMessageDao;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowMessageDaoTest extends TestDataProducer {

  @Autowired
  private IWorkflowDao                      workflowDao;

  @Autowired
  private IWorkflowMessageService           workflowMessageService;

  @Autowired
  private IWorkflowMessageDao               workflowMessageDao;

  private final List<WorkflowMessageEntity> createdModels    = new ArrayList<>();
  private final List<WorkflowMessageEdo>    createdEdoModels = new ArrayList<>();

  private WorkflowEntity                    createdWorkflow  = null;

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

    for (final WorkflowMessageEntity workflowMessage : createdModels) {
      workflowMessageDao.deleteById(workflowMessage.getId());
    }

    if (createdWorkflow != null) {
      workflowDao.deleteById(createdWorkflow.getId());
    }
  }

  @Test
  public void testGetById() throws Exception {

    createWorlflowList();

    final WorkflowMessageEntity workflow    = createdModels.get(0);

    final WorkflowMessageEntity resWorkflow = this.workflowMessageDao.getById(createdModels.get(0).getId());

    compareExpectedAndResult(workflow, resWorkflow);

  }

  @Test
  public void testUpdateStatusByWorkflow() throws Exception {

    createWorlflowList();

    WorkflowMessageEntity    workflowMessage    = createdModels.get(0);
    final WorkflowMessageEdo workflowMessageEdo = createdEdoModels.get(0);

    this.workflowMessageDao.updateStatusByWorkflowIdentity(createdWorkflow.getIdentity(), workflowMessageEdo.getStepIdentity(),
        EWorkflowMessageStatus.CLOSED);
    workflowMessage = workflowMessageDao.getById(workflowMessage.getId());

    Assert.assertNotNull("Result is not null!", workflowMessage);
    Assert.assertEquals("Result has status CLOSED.", workflowMessage.getStatus(), EWorkflowMessageStatus.CLOSED.getValue());

  }

  @Test
  public void testGetListByUserId() throws Exception {

    createWorlflowList();
    final WorkflowMessageEdo          workflowMessageEdo = createdEdoModels.get(0);

    final List<WorkflowMessageEntity> resList            = this.workflowMessageDao
        .getNotClosedNotExpiredListByUserIdentity(workflowMessageEdo.getUserIdentity());

    Assert.assertNotNull("Result list is not null!", resList);

    assertThat("Result list has " + createdModels.size() + " items.", resList.size(), greaterThanOrEqualTo(createdModels.size()));

  }

  @Test
  public void testGetListByWorkflowId() throws Exception {

    createWorlflowList();

    final List<
        WorkflowMessageEntity> resList = this.workflowMessageDao.getNotClosedNotExpiredListByWorkflowIdentity(createdWorkflow.getIdentity());

    Assert.assertNotNull("Result list is not null!", resList);

    assertThat("Result list has " + createdModels.size() + " items.", resList.size(), greaterThanOrEqualTo(createdModels.size()));

  }

  @Test
  public void testCreate() throws Exception {

    createReferenceWorkflow();

    final WorkflowMessageEntity workflowMessage = getTestWorkflowMessage(createdWorkflow, "Test_Message");
    workflowMessage.setVersion(10);

    final WorkflowMessageEntity resWorkflow = workflowMessageDao.create(workflowMessage);
    createdModels.add(resWorkflow);

    compareExpectedAndResult(workflowMessage, resWorkflow);

  }

  @Test
  public void testUpdate() throws Exception {

    createReferenceWorkflow();

    final WorkflowMessageEntity workflowMessage = getTestWorkflowMessage(createdWorkflow, "Test_Message");
    workflowMessage.setVersion(10);

    final WorkflowMessageEntity createdWorkflow = workflowMessageDao.create(workflowMessage);
    createdModels.add(createdWorkflow);

    Assert.assertNotNull("Result created workflow is not null!", createdWorkflow);

    final String updatedMessage = "new updated title test";
    createdWorkflow.setMessage(updatedMessage);
    createdWorkflow.setVersion(22);
    createdWorkflow.setStatus(EWorkflowMessageStatus.ASSIGNED.getValue());

    final WorkflowMessageEntity updatedWorkflow = workflowMessageDao.update(createdWorkflow);

    compareExpectedAndResult(createdWorkflow, updatedWorkflow);

    Assert.assertEquals("Result workflow has version 22!", updatedWorkflow.getVersion().intValue(), 23);
    Assert.assertEquals("Result workflow message is '" + updatedMessage + "'", updatedWorkflow.getMessage(), updatedMessage);

  }

  @Test
  public void testDelete() throws Exception {

    createReferenceWorkflow();

    final WorkflowMessageEntity workflowMessage = getTestWorkflowMessage(createdWorkflow, "Test_Message");
    workflowMessage.setVersion(10);

    final WorkflowMessageEntity resWorkflow = workflowMessageDao.create(workflowMessage);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);

    workflowMessageDao.deleteById(resWorkflow.getId());

    final WorkflowMessageEntity deletedWorkflow = this.workflowMessageDao.getById(resWorkflow.getId());

    Assert.assertNull("Result workflow is null!", deletedWorkflow);

  }

  private void compareExpectedAndResult(final WorkflowMessageEntity workflow, final WorkflowMessageEntity resWorkflow) {
    Assert.assertNotNull("Result workflow is not null!", resWorkflow);

    Assert.assertEquals("Result workflow has message '" + workflow.getMessage() + "'!", resWorkflow.getMessage(), workflow.getMessage());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());
    Assert.assertEquals("Result workflow has message-type " + workflow.getMessageType() + "!", resWorkflow.getMessageType(),
        workflow.getMessageType());
    Assert.assertEquals("Result workflow has expiredays " + workflow.getExpireDays() + "!", resWorkflow.getExpireDays(),
        workflow.getExpireDays());
  }

  private void createReferenceWorkflow() {
    final WorkflowEntity workflow = getTestNewWorkflowForSave();

    createdWorkflow = workflowDao.create(workflow);
  }

  private void createWorlflowList() throws Exception {
    createReferenceWorkflow();

    for (int i = 1; i <= 3; i++) {
      final WorkflowMessageEntity workflowMessage = getTestWorkflowMessage(createdWorkflow, "Test_Message");
      workflowMessage.setId(null);
      workflowMessage.setMessage("message " + i);

      final WorkflowMessageEntity res = workflowMessageDao.create(workflowMessage);

      createdModels.add(res);

      final WorkflowMessageEdo edo = workflowMessageService.toEdo(res);
      createdEdoModels.add(edo);
    }
  }

}

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
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowMessage;
import com.pth.iflow.core.storage.dao.IWorkflowDao;
import com.pth.iflow.core.storage.dao.IWorkflowMessageDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowMessageDaoTest extends TestDataProducer {

  @Autowired
  private IWorkflowDao                workflowDao;

  @Autowired
  private IWorkflowMessageDao         workflowMessageDao;

  private final List<WorkflowMessage> createdModels   = new ArrayList<>();

  private Workflow                    createdWorkflow = null;

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

    for (final WorkflowMessage workflowMessage : createdModels) {
      workflowMessageDao.deleteWorkflowMessage(workflowMessage.getId());
    }

    if (createdWorkflow != null) {
      workflowDao.deleteWorkflow(createdWorkflow.getId());
    }
  }

  @Test
  public void testGetById() throws Exception {

    createWorlflowList();

    final WorkflowMessage workflow = createdModels.get(0);

    final WorkflowMessage resWorkflow = this.workflowMessageDao.getById(createdModels.get(0).getId());

    compareExpectedAndResult(workflow, resWorkflow);

  }

  @Test
  public void testUpdateStatusByWorkflow() throws Exception {

    createWorlflowList();

    WorkflowMessage workflowMessage = createdModels.get(0);
    this.workflowMessageDao.updateStatusByWorkflow(workflowMessage.getWorkflowId(), EWorkflowMessageStatus.CLOSED.getValue());
    workflowMessage = workflowMessageDao.getById(workflowMessage.getId());

    Assert.assertNotNull("Result is not null!", workflowMessage);
    Assert.assertEquals("Result has status CLOSED.", workflowMessage.getStatus(), EWorkflowMessageStatus.CLOSED);

  }

  @Test
  public void testGetListByUserId() throws Exception {

    createWorlflowList();

    final List<WorkflowMessage> resList = this.workflowMessageDao.getNotExpiredListByUserId(createdModels.get(0).getUserId(), 0);

    Assert.assertNotNull("Result list is not null!", resList);

    assertThat("Result list has " + createdModels.size() + " items.", resList.size(), greaterThanOrEqualTo(createdModels.size()));

  }

  @Test
  public void testGetListByWorkflowId() throws Exception {

    createWorlflowList();

    final List<WorkflowMessage> resList = this.workflowMessageDao.getListByWorkflowId(createdModels.get(0).getWorkflowId());

    Assert.assertNotNull("Result list is not null!", resList);

    assertThat("Result list has " + createdModels.size() + " items.", resList.size(), greaterThanOrEqualTo(createdModels.size()));

  }

  @Test
  public void testCreate() throws Exception {

    createReferenceWorkflow();

    final WorkflowMessage workflowMessage = getTestWorkflowMessage(1L, "Test_Message");
    workflowMessage.setMessage("title test");
    workflowMessage.setVersion(10);
    workflowMessage.setWorkflowId(createdWorkflow.getId());

    final WorkflowMessage resWorkflow = workflowMessageDao.create(workflowMessage);
    createdModels.add(resWorkflow);

    compareExpectedAndResult(workflowMessage, resWorkflow);

  }

  @Test
  public void testUpdate() throws Exception {

    createReferenceWorkflow();

    final WorkflowMessage workflowMessage = getTestWorkflowMessage(1L, "Test_Message");
    workflowMessage.setMessage("title test");
    workflowMessage.setVersion(10);
    workflowMessage.setWorkflowId(createdWorkflow.getId());
    final WorkflowMessage createdWorkflow = workflowMessageDao.create(workflowMessage);
    createdModels.add(createdWorkflow);

    Assert.assertNotNull("Result created workflow is not null!", createdWorkflow);

    createdWorkflow.setMessage("new updated title test");
    createdWorkflow.setVersion(22);
    createdWorkflow.setStatus(EWorkflowMessageStatus.ASSIGNED);

    final WorkflowMessage updatedWorkflow = workflowMessageDao.update(createdWorkflow);

    compareExpectedAndResult(createdWorkflow, updatedWorkflow);

    Assert.assertEquals("Result workflow has version 22!", updatedWorkflow.getVersion().intValue(), 22);

  }

  @Test
  public void testDelete() throws Exception {

    createReferenceWorkflow();

    final WorkflowMessage workflowMessage = getTestWorkflowMessage(1L, "Test_Message");
    workflowMessage.setMessage("title test");
    workflowMessage.setVersion(10);
    workflowMessage.setWorkflowId(createdWorkflow.getId());

    final WorkflowMessage resWorkflow = workflowMessageDao.create(workflowMessage);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);

    workflowMessageDao.deleteWorkflowMessage(resWorkflow.getId());

    final WorkflowMessage deletedWorkflow = this.workflowMessageDao.getById(resWorkflow.getId());

    Assert.assertNull("Result workflow is null!", deletedWorkflow);

  }

  private void compareExpectedAndResult(final WorkflowMessage workflow, final WorkflowMessage resWorkflow) {
    Assert.assertNotNull("Result workflow is not null!", resWorkflow);

    Assert.assertEquals("Result workflow has message '" + workflow.getMessage() + "'!", resWorkflow.getMessage(),
        workflow.getMessage());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());
    Assert.assertEquals("Result workflow has message-type " + workflow.getMessageType() + "!", resWorkflow.getMessageType(),
        workflow.getMessageType());
    Assert.assertEquals("Result workflow has expiredays " + workflow.getExpireDays() + "!", resWorkflow.getExpireDays(),
        workflow.getExpireDays());
  }

  private void createReferenceWorkflow() {
    final Workflow workflow = getTestNewWorkflow();
    workflow.setId(null);
    createdWorkflow = workflowDao.create(workflow);
  }

  private void createWorlflowList() throws Exception {
    createReferenceWorkflow();

    for (int i = 1; i <= 3; i++) {
      final WorkflowMessage workflowMessage = getTestWorkflowMessage(1L, "Test_Message");
      workflowMessage.setId(null);
      workflowMessage.setMessage("message " + i);
      workflowMessage.setWorkflowId(createdWorkflow.getId());
      final WorkflowMessage res = workflowMessageDao.create(workflowMessage);
      createdModels.add(res);
    }
  }

}

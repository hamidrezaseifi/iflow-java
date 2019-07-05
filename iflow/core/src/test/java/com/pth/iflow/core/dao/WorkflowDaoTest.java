package com.pth.iflow.core.dao;

import java.util.ArrayList;
import java.util.List;
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
import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.storage.dao.IWorkflowDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowDaoTest extends TestDataProducer {

  @Autowired
  private IWorkflowDao workflowDao;

  private final List<Workflow> createdWorkflows = new ArrayList<>();

  @Before
  public void setUp() throws Exception {
    for (int i = 1; i <= 3; i++) {
      final Workflow workflow = getTestWorkflow(1L);
      workflow.setId(null);
      workflow.setTitle("title " + i);
      final Workflow res = workflowDao.create(workflow);
      createdWorkflows.add(res);
    }
  }

  @After
  public void tearDown() throws Exception {

    for (final Workflow workflow : createdWorkflows) {
      workflowDao.deleteWorkflow(workflow.getId());
    }
  }

  @Test
  public void testGetById() throws Exception {

    final Workflow workflow = createdWorkflows.get(0);

    final Workflow resWorkflow = this.workflowDao.getById(createdWorkflows.get(0).getId());

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final List<Long> idList = createdWorkflows.stream().map(w -> w.getId()).collect(Collectors.toList());

    final List<Workflow> resList = this.workflowDao.getListByIdList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + createdWorkflows.size() + " items.", resList.size(), createdWorkflows.size());

  }

  @Test
  public void testGetListByIdTypeId() throws Exception {

    final List<Workflow> resList = this.workflowDao.getListByWorkflowTypeId(1L);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + createdWorkflows.size() + " items.", resList.size(), createdWorkflows.size());

  }

  @Test
  public void testCreate() throws Exception {

    final Workflow workflow = getTestWorkflow(1L);
    workflow.setId(null);
    workflow.setTitle("title test");
    workflow.setVersion(10);
    final Workflow resWorkflow = workflowDao.create(workflow);
    createdWorkflows.add(resWorkflow);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());
    Assert.assertEquals("Result workflow-type has version 22!", resWorkflow.getVersion(), workflow.getVersion());

  }

  @Test
  public void testUpdate() throws Exception {

    final Workflow workflow = getTestWorkflow(1L);
    workflow.setId(null);
    workflow.setTitle("title test");
    workflow.setVersion(10);
    Workflow resWorkflow = workflowDao.create(workflow);
    createdWorkflows.add(resWorkflow);

    resWorkflow.setTitle("new title test");
    resWorkflow.setVersion(22);

    resWorkflow = workflowDao.update(resWorkflow);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());
    Assert.assertEquals("Result workflow-type has version 22!", resWorkflow.getVersion().intValue(), 22);

  }

  @Test
  public void testDelete() throws Exception {

    final Workflow workflow = getTestWorkflow(1L);
    workflow.setId(null);
    workflow.setTitle("title test");
    workflow.setVersion(10);
    final Workflow resWorkflow = workflowDao.create(workflow);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);

    workflowDao.deleteWorkflow(resWorkflow.getId());

    final Workflow deletedWorkflow = this.workflowDao.getById(resWorkflow.getId());

    Assert.assertNotNull("Result workflow-type is null!", deletedWorkflow);

  }

}

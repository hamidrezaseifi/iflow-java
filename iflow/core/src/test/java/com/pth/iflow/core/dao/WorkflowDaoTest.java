package com.pth.iflow.core.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

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

  }

  private void createWorlflowList() throws Exception {
    for (int i = 1; i <= 3; i++) {
      final Workflow workflow = getTestNewWorkflow();
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

    createWorlflowList();

    final Workflow workflow = createdWorkflows.get(0);

    final Workflow resWorkflow = this.workflowDao.getById(createdWorkflows.get(0).getId());

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    createWorlflowList();

    final List<Long> idList = createdWorkflows.stream().map(w -> w.getId()).collect(Collectors.toList());

    final List<Workflow> resList = this.workflowDao.getListByIdList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + createdWorkflows.size() + " items.", resList.size(), createdWorkflows.size());

  }

  @Test
  public void testGetListByIdTypeId() throws Exception {

    createWorlflowList();

    final List<Workflow> resList = this.workflowDao.getListByWorkflowTypeId(createdWorkflows.get(0).getWorkflowTypeId());

    Assert.assertNotNull("Result list is not null!", resList);

    assertThat("Result list has " + createdWorkflows.size() + " items.", resList.size(),
        greaterThanOrEqualTo(createdWorkflows.size()));

  }

  @Test
  public void testCreate() throws Exception {

    final Workflow workflow = getTestNewWorkflow();
    workflow.setTitle("title test");
    workflow.setVersion(10);
    final Workflow resWorkflow = workflowDao.create(workflow);
    createdWorkflows.add(resWorkflow);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());
    Assert.assertEquals("Result workflow has version " + workflow.getVersion() + "!", resWorkflow.getVersion(), workflow.getVersion());

  }

  @Test
  public void testUpdate() throws Exception {

    final Workflow workflow = getTestNewWorkflow();
    workflow.setTitle("title test");
    workflow.setVersion(10);
    final Workflow createdWorkflow = workflowDao.create(workflow);
    createdWorkflows.add(createdWorkflow);

    Assert.assertNotNull("Result created workflow is not null!", createdWorkflow);

    createdWorkflow.setTitle("new updated title test");
    createdWorkflow.setVersion(22);
    createdWorkflow.setStatus(10);

    final Workflow updatedWorkflow = workflowDao.update(createdWorkflow);

    Assert.assertNotNull("Result workflow is not null!", updatedWorkflow);
    Assert.assertEquals("Result workflow has the same id as created!", createdWorkflow.getId(), updatedWorkflow.getId());
    Assert.assertEquals("Result workflow has title 'new updated title test'!", createdWorkflow.getTitle(), "new updated title test");
    Assert.assertEquals("Result workflow has status 10!", updatedWorkflow.getStatus().intValue(), 10);
    Assert.assertEquals("Result workflow has version 22!", updatedWorkflow.getVersion().intValue(), 22);

  }

  @Test
  public void testDelete() throws Exception {

    final Workflow workflow = getTestNewWorkflow();
    workflow.setTitle("title test");
    workflow.setVersion(10);
    final Workflow resWorkflow = workflowDao.create(workflow);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);

    workflowDao.deleteWorkflow(resWorkflow.getId());

    final Workflow deletedWorkflow = this.workflowDao.getById(resWorkflow.getId());

    Assert.assertNull("Result workflow is null!", deletedWorkflow);

  }

}

package com.pth.iflow.core.dao.workflow;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowDaoTest extends TestDataProducer {

  @Autowired
  private IWorkflowDao               workflowDao;

  @Autowired
  private IWorkflowService           workflowService;

  private final List<WorkflowEntity> createdModels = new ArrayList<>();

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

    for (final WorkflowEntity workflow : createdModels) {
      workflowDao.deleteById(workflow.getId());
    }

    // workflowDao.destroy();
  }

  @Test
  public void testGetById() throws Exception {

    createWorlflowList();

    final WorkflowEntity workflow    = createdModels.get(0);

    final WorkflowEntity resWorkflow = this.workflowDao.getById(workflow.getId());

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testGetByIdentity() throws Exception {

    createWorlflowList();

    final WorkflowEntity workflow    = createdModels.get(0);

    final WorkflowEntity resWorkflow = this.workflowDao.getByIdentity(workflow.getIdentity());

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testGetListByIdentityList() throws Exception {

    createWorlflowList();

    final Set<String>          identityList = createdModels.stream().map(w -> w.getIdentity()).collect(Collectors.toSet());

    final List<WorkflowEntity> resList      = this.workflowDao.getListByIdentityList(identityList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + createdModels.size() + " items.", resList.size(), createdModels.size());

  }

  @Test
  public void testGetListForUserIdentity() throws Exception {

    createWorlflowList();

    final List<WorkflowEntity> resList = this.workflowDao.getListForUserIdentity("admin@iflow.de", -1);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertThat("Result list has " + createdModels.size() + " items.", resList.size(), greaterThanOrEqualTo(createdModels.size()));

  }

  @Test
  public void testCreate() throws Exception {

    final WorkflowEntity workflow = getTestNewWorkflowForSave();
    workflow.setVersion(10);
    final WorkflowEntity resWorkflow = saveWorkflow(workflow);
    createdModels.add(resWorkflow);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());
    Assert.assertEquals("Result workflow has version " + workflow.getVersion() + "!", resWorkflow.getVersion(), workflow.getVersion());

  }

  @Test
  public void testUpdate() throws Exception {

    final WorkflowEntity workflow = getTestNewWorkflowForSave();
    workflow.setVersion(10);
    final WorkflowEntity createdWorkflow = saveWorkflow(workflow);
    createdModels.add(createdWorkflow);

    Assert.assertNotNull("Result created workflow is not null!", createdWorkflow);

    final String newComments = createdWorkflow.getComments() + " - updated";
    createdWorkflow.setComments(newComments);
    createdWorkflow.setVersion(22);
    createdWorkflow.setStatus(10);

    final WorkflowEntity updatedWorkflow = workflowDao.update(createdWorkflow);

    Assert.assertNotNull("Result workflow is not null!", updatedWorkflow);
    Assert.assertEquals("Result workflow has the same id as created!", createdWorkflow.getId(), updatedWorkflow.getId());
    Assert.assertEquals("Result workflow has status 10!", updatedWorkflow.getStatus().intValue(), 10);
    Assert.assertEquals("Result workflow has version 23!", updatedWorkflow.getVersion().intValue(), 23);
    Assert.assertEquals("Result workflow has version 23!", updatedWorkflow.getComments(), newComments);

  }

  @Test
  public void testDelete() throws Exception {

    final WorkflowEntity workflow = getTestNewWorkflowForSave();
    workflow.setVersion(10);
    final WorkflowEntity resWorkflow = saveWorkflow(workflow);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);

    workflowDao.deleteById(resWorkflow.getId());

    final WorkflowEntity deletedWorkflow = this.workflowDao.getById(resWorkflow.getId());

    Assert.assertNull("Result workflow is null!", deletedWorkflow);

  }

  private void createWorlflowList() throws Exception {
    for (int i = 1; i <= 3; i++) {
      final WorkflowEntity workflow = getTestNewWorkflowForSave();

      final WorkflowEntity res      = saveWorkflow(workflow);

      createdModels.add(res);
    }
  }

  private WorkflowEntity saveWorkflow(final WorkflowEntity workflow) {
    final WorkflowEntity res = workflowDao.create(workflow);
    return res;
  }

}

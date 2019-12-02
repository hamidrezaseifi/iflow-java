package com.pth.iflow.core.dao.workflow;

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

import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowDaoTest extends TestDataProducer {

  @Autowired
  private IWorkflowDao               workflowDao;

  private final List<WorkflowEntity> createdModels = new ArrayList<>();

  @Before
  public void setUp() throws Exception {

  }

  private void createWorlflowList() throws Exception {
    for (int i = 1; i <= 3; i++) {
      final WorkflowEntity workflow = getTestNewWorkflowForSave();
      workflow.setId(null);
      workflow.setIdentity(EIdentity.NOT_SET.getIdentity());
      final WorkflowEntity res = workflowDao.create(workflow);
      createdModels.add(res);
    }
  }

  @After
  public void tearDown() throws Exception {

    for (final WorkflowEntity workflow : createdModels) {
      workflowDao.deleteById(workflow.getId());
    }
  }

  @Test
  public void testGetById() throws Exception {

    createWorlflowList();

    final WorkflowEntity workflow = createdModels.get(0);

    final WorkflowEntity resWorkflow = this.workflowDao.getById(workflow.getId());

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testGetByIdentity() throws Exception {

    createWorlflowList();

    final WorkflowEntity workflow = createdModels.get(0);

    final WorkflowEntity resWorkflow = this.workflowDao.getByIdentity(workflow.getIdentity());

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testGetListByIdentityList() throws Exception {

    createWorlflowList();

    final Set<String> identityList = createdModels.stream().map(w -> w.getIdentity()).collect(Collectors.toSet());

    final List<WorkflowEntity> resList = this.workflowDao.getListByIdentityList(identityList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + createdModels.size() + " items.", resList.size(), createdModels.size());

  }

  @Test
  public void testCreate() throws Exception {

    final WorkflowEntity workflow = getTestNewWorkflowForSave();
    workflow.setVersion(10);
    final WorkflowEntity resWorkflow = workflowDao.create(workflow);
    createdModels.add(resWorkflow);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());
    Assert.assertEquals("Result workflow has version " + workflow.getVersion() + "!", resWorkflow.getVersion(), workflow.getVersion());

  }

  @Test
  public void testUpdate() throws Exception {

    final WorkflowEntity workflow = getTestNewWorkflowForSave();
    workflow.setVersion(10);
    final WorkflowEntity createdWorkflow = workflowDao.create(workflow);
    createdModels.add(createdWorkflow);

    Assert.assertNotNull("Result created workflow is not null!", createdWorkflow);

    createdWorkflow.setVersion(22);
    createdWorkflow.setStatus(10);

    final WorkflowEntity updatedWorkflow = workflowDao.update(createdWorkflow);

    Assert.assertNotNull("Result workflow is not null!", updatedWorkflow);
    Assert.assertEquals("Result workflow has the same id as created!", createdWorkflow.getId(), updatedWorkflow.getId());
    Assert.assertEquals("Result workflow has status 10!", updatedWorkflow.getStatus().intValue(), 10);
    Assert.assertEquals("Result workflow has version 22!", updatedWorkflow.getVersion().intValue(), 22);

  }

  @Test
  public void testDelete() throws Exception {

    final WorkflowEntity workflow = getTestNewWorkflowForSave();
    workflow.setVersion(10);
    final WorkflowEntity resWorkflow = workflowDao.create(workflow);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);

    workflowDao.deleteById(resWorkflow.getId());

    final WorkflowEntity deletedWorkflow = this.workflowDao.getById(resWorkflow.getId());

    Assert.assertNull("Result workflow is null!", deletedWorkflow);

  }

}

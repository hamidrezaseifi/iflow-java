package com.pth.iflow.core.dao.workflow;

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
import com.pth.iflow.core.model.entity.workflow.SingleTaskWorkflowEntity;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.workflow.ISingleTaskWorkflowDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SingleTaskWorkflowDaoTest extends TestDataProducer {

  @Autowired
  private ISingleTaskWorkflowDao               workflowDao;

  @Autowired
  private IWorkflowService                     workflowService;

  private final List<SingleTaskWorkflowEntity> createdModels = new ArrayList<>();

  @Before
  public void setUp() throws Exception {

  }

  private void createWorlflowList() throws Exception {
    for (int i = 1; i <= 3; i++) {
      final SingleTaskWorkflowEntity workflow = getTestSingleTaskWorkflowEntityForSave();

      final SingleTaskWorkflowEntity res = saveWorkflow(workflow);

      createdModels.add(res);
    }
  }

  @After
  public void tearDown() throws Exception {

    for (final SingleTaskWorkflowEntity workflow : createdModels) {
      workflowDao.deleteById(workflow.getWorkflowId());
    }
  }

  @Test
  public void testGetById() throws Exception {

    createWorlflowList();

    final SingleTaskWorkflowEntity workflow = createdModels.get(0);

    final SingleTaskWorkflowEntity resWorkflow = this.workflowDao.getById(createdModels.get(0).getWorkflowId());

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getWorkflow().getId(), workflow.getWorkflow().getId());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getWorkflow().getStatus(), workflow.getWorkflow().getStatus());

  }

  @Test
  public void testGetListByIdentityList() throws Exception {

    createWorlflowList();

    final List<String> identityList = createdModels.stream().map(w -> w.getWorkflow().getIdentity()).collect(Collectors.toList());

    final List<SingleTaskWorkflowEntity> resList = this.workflowDao.getListByIdentityList(identityList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + createdModels.size() + " items.", resList.size(), createdModels.size());

  }

  @Test
  public void testCreate() throws Exception {

    final SingleTaskWorkflowEntity workflow = getTestSingleTaskWorkflowEntityForSave();
    workflow.getWorkflow().setVersion(10);
    final SingleTaskWorkflowEntity resWorkflow = saveWorkflow(workflow);

    createdModels.add(resWorkflow);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getWorkflow().getStatus(), workflow.getWorkflow().getStatus());
    Assert.assertEquals("Result workflow has version " + workflow.getWorkflow().getVersion() + "!",
        resWorkflow.getWorkflow().getVersion(), workflow.getWorkflow().getVersion());

  }

  @Test
  public void testUpdate() throws Exception {

    final SingleTaskWorkflowEntity workflow = getTestSingleTaskWorkflowEntityForSave();
    workflow.getWorkflow().setVersion(10);
    final SingleTaskWorkflowEntity createdWorkflow = saveWorkflow(workflow);

    createdModels.add(createdWorkflow);

    Assert.assertNotNull("Result created workflow is not null!", createdWorkflow);

    createdWorkflow.getWorkflow().setVersion(22);
    createdWorkflow.getWorkflow().setStatus(10);

    final SingleTaskWorkflowEntity updatedWorkflow = workflowDao.update(createdWorkflow);

    Assert.assertNotNull("Result workflow is not null!", updatedWorkflow);
    Assert.assertEquals("Result workflow has the same id as created!", createdWorkflow.getWorkflow().getId(),
        updatedWorkflow.getWorkflow().getId());
    Assert.assertEquals("Result workflow has status 10!", updatedWorkflow.getWorkflow().getStatus().intValue(), 10);
    Assert.assertEquals("Result workflow has version 22!", updatedWorkflow.getWorkflow().getVersion().intValue(), 23);

  }

  @Test
  public void testDelete() throws Exception {

    final SingleTaskWorkflowEntity workflow = getTestSingleTaskWorkflowEntityForSave();
    workflow.getWorkflow().setVersion(10);
    final SingleTaskWorkflowEntity resWorkflow = saveWorkflow(workflow);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);

    workflowDao.deleteById(resWorkflow.getWorkflow().getId());

    final SingleTaskWorkflowEntity deletedWorkflow = this.workflowDao.getById(resWorkflow.getWorkflow().getId());

    Assert.assertNull("Result workflow is null!", deletedWorkflow);

  }

  private SingleTaskWorkflowEntity saveWorkflow(final SingleTaskWorkflowEntity workflow) {

    workflowService.prepareSavingModel(workflow.getWorkflow());

    final SingleTaskWorkflowEntity res = workflowDao.create(workflow);
    return res;
  }

}

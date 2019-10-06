package com.pth.iflow.core.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

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
import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.service.IWorkflowService;
import com.pth.iflow.core.service.impl.WorkflowService;
import com.pth.iflow.core.storage.dao.IWorkflowDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowServiceTest extends TestDataProducer {

  private IWorkflowService workflowService;

  @MockBean
  private IWorkflowDao     workflowDao;

  @Before
  public void setUp() throws Exception {
    this.workflowService = new WorkflowService(this.workflowDao);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final Workflow workflow = getTestWorkflow(1L);
    when(this.workflowDao.getById(any(Long.class))).thenReturn(workflow);

    final Workflow resWorkflow = this.workflowService.getById(workflow.getId());

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final List<Long> idList = getTestWorkflowIdList();
    final List<Workflow> list = getTestWorkflowList();
    when(this.workflowDao.getListByIdList(any(List.class))).thenReturn(list);

    final List<Workflow> resList = this.workflowService.getListByIdList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByIdTypeId() throws Exception {

    final List<Workflow> list = getTestWorkflowList();
    when(this.workflowDao.getListByWorkflowTypeId(any(Long.class))).thenReturn(list);

    final List<Workflow> resList = this.workflowService.getListByTypeId(1L);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testSave() throws Exception {

    Workflow workflow = getTestWorkflow(1L);
    workflow.setId(null);
    workflow.setVersion(21);

    when(this.workflowDao.create(any(Workflow.class))).thenReturn(workflow);
    when(this.workflowDao.update(any(Workflow.class))).thenReturn(workflow);
    when(this.workflowDao.getById(any(Long.class))).thenReturn(workflow);

    Workflow resWorkflow = this.workflowService.save(workflow);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());
    Assert.assertEquals("Result workflow-type has version 22!", resWorkflow.getVersion().intValue(), 22);

    workflow = getTestWorkflow(1L);

    when(this.workflowDao.create(any(Workflow.class))).thenReturn(workflow);
    when(this.workflowDao.update(any(Workflow.class))).thenReturn(workflow);
    when(this.workflowDao.getById(any(Long.class))).thenReturn(workflow);

    resWorkflow = this.workflowService.save(workflow);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());
    Assert.assertEquals("Result workflow-type has version 1!", resWorkflow.getVersion(), workflow.getVersion());

  }

}

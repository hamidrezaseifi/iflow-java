package com.pth.iflow.workflow.services;

import static org.mockito.ArgumentMatchers.any;
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

import com.pth.iflow.workflow.bl.IWorkflowTypeStepDataService;
import com.pth.iflow.workflow.bl.IWorkflowTypeStepProcessService;
import com.pth.iflow.workflow.bl.impl.WorkflowTypeStepProcessService;
import com.pth.iflow.workflow.models.WorkflowTypeStep;
import com.pth.iflow.workflow.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeStepProcessServiceTest extends TestDataProducer {

  private IWorkflowTypeStepProcessService workflowTypeStepProcessService;

  @MockBean
  private IWorkflowTypeStepDataService workflowTypeStepDataService;

  @Before
  public void setUp() throws Exception {

    this.workflowTypeStepProcessService = new WorkflowTypeStepProcessService(this.workflowTypeStepDataService);

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetById() throws Exception {

    final WorkflowTypeStep workflowStepType = this.getTestWorkflowTypeStep();

    when(this.workflowTypeStepDataService.getByIdentity(any(String.class), any())).thenReturn(workflowStepType);

    final WorkflowTypeStep resWorkflowType = this.workflowTypeStepProcessService
        .getByIdentity(workflowStepType.getIdentity(),
            this.getValidAuthentiocation());

    Assert.assertNotNull("Result workflow-type-step is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type-step has id 1!", resWorkflowType.getIdentity(), workflowStepType.getIdentity());
    Assert
        .assertEquals("Result workflow-type-step has title '" + workflowStepType.getTitle() + "'!", resWorkflowType.getTitle(),
            workflowStepType.getTitle());
    Assert.assertEquals("Result workflow-type-step has status 1!", resWorkflowType.getStatus(), workflowStepType.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = this.getTestWorkflowTypeIdSet();
    final List<WorkflowTypeStep> list = this.getTestWorkflowTypeStepList();

    when(this.workflowTypeStepDataService.getListByIdentityList(any(Set.class), any())).thenReturn(list);

    final List<
        WorkflowTypeStep> resList = this.workflowTypeStepProcessService.getListByIdentityList(idList, this.getValidAuthentiocation());

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByWorkflowTypeId() throws Exception {

    final List<WorkflowTypeStep> list = this.getTestWorkflowTypeStepList();

    when(this.workflowTypeStepDataService.getListByWorkflowIdentity(any(String.class), any())).thenReturn(list);

    final List<WorkflowTypeStep> resList = this.workflowTypeStepProcessService
        .getListByWorkflowIdentity("identity1",
            this.getValidAuthentiocation());

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

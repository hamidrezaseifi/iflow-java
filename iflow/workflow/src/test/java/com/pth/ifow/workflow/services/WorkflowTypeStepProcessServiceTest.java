package com.pth.ifow.workflow.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.ifow.workflow.TestDataProducer;
import com.pth.ifow.workflow.bl.ITokenValidator;
import com.pth.ifow.workflow.bl.IWorkflowTypeStepDataService;
import com.pth.ifow.workflow.bl.IWorkflowTypeStepProcessService;
import com.pth.ifow.workflow.bl.impl.WorkflowTypeStepProcessService;
import com.pth.ifow.workflow.models.ProfileResponse;
import com.pth.ifow.workflow.models.WorkflowTypeStep;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeStepProcessServiceTest extends TestDataProducer {

  private IWorkflowTypeStepProcessService workflowTypeStepProcessService;

  @MockBean
  private IWorkflowTypeStepDataService workflowTypeStepDataService;

  @Mock
  private ITokenValidator tokenValidator;

  private String validTocken;

  private String validSession;

  private ProfileResponse profileResponse;

  @Before
  public void setUp() throws Exception {
    this.workflowTypeStepProcessService = new WorkflowTypeStepProcessService(this.workflowTypeStepDataService, this.tokenValidator);

    this.validTocken = "validTocken";

    this.validSession = "validSession";

    this.profileResponse = new ProfileResponse(this.getTestUser(), this.getTestCompany(), this.validSession);

    when(this.tokenValidator.isTokenValid(this.validTocken)).thenReturn(this.profileResponse);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final WorkflowTypeStep workflowStepType = this.getTestWorkflowTypeStep();

    when(this.workflowTypeStepDataService.getById(any(Long.class), any(String.class))).thenReturn(workflowStepType);

    final WorkflowTypeStep resWorkflowType = this.workflowTypeStepProcessService.getById(workflowStepType.getId(), this.validTocken);

    Assert.assertNotNull("Result workflow-type-step is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type-step has id 1!", resWorkflowType.getId(), workflowStepType.getId());
    Assert.assertEquals("Result workflow-type-step has title '" + workflowStepType.getTitle() + "'!", resWorkflowType.getTitle(),
        workflowStepType.getTitle());
    Assert.assertEquals("Result workflow-type-step has status 1!", resWorkflowType.getStatus(), workflowStepType.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final List<Long> idList = this.getTestWorkflowTypeIdList();
    final List<WorkflowTypeStep> list = this.getTestWorkflowTypeStepList();

    when(this.workflowTypeStepDataService.getListByIdList(any(List.class), any(String.class))).thenReturn(list);

    final List<WorkflowTypeStep> resList = this.workflowTypeStepProcessService.getListByIdList(idList, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByWorkflowTypeId() throws Exception {

    final List<WorkflowTypeStep> list = this.getTestWorkflowTypeStepList();

    when(this.workflowTypeStepDataService.getListByWorkflowId(any(Long.class), any(String.class))).thenReturn(list);

    final List<WorkflowTypeStep> resList = this.workflowTypeStepProcessService.getListByWorkflowId(1L, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

package com.pth.iflow.workflow.services;

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
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.ITokenValidator;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.bl.impl.WorkflowProcessService;
import com.pth.iflow.workflow.models.ProfileResponse;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowProcessServiceTest extends TestDataProducer {

  private IWorkflowProcessService workflowProcessService;

  @Mock
  private IWorkflowDataService workflowDataService;

  @Mock
  private IWorkflowTypeDataService workflowTypeDataService;

  @Mock
  private ITokenValidator tokenValidator;

  private WorkflowType workflowType;

  private String validTocken;

  private String validSession;

  private ProfileResponse profileResponse;

  @Before
  public void setUp() throws Exception {
    this.workflowProcessService = new WorkflowProcessService(this.workflowDataService,
                                                             this.workflowTypeDataService,
                                                             this.tokenValidator);

    this.validTocken = "validTocken";

    this.validSession = "validSession";

    this.workflowType = this.getTestWorkflowType(1L, "Type 1");

    when(this.workflowTypeDataService.getById(any(Long.class), any(String.class))).thenReturn(this.workflowType);

    this.profileResponse = new ProfileResponse(this.getTestUser(), this.getTestCompanyProfile(), this.validSession);

    when(this.tokenValidator.isTokenValid(this.validTocken)).thenReturn(this.profileResponse);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final Workflow workflow = this.getTestWorkflow(1L);

    when(this.workflowDataService.getById(any(Long.class), any(String.class))).thenReturn(workflow);

    final Workflow resWorkflow = this.workflowProcessService.getById(workflow.getId(), this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test(expected = IFlowCustomeException.class)
  public void testSaveWorkflowUnknownWorkflowStatus() throws Exception {

    final Workflow workflow = this.getTestWorkflow(1L);

    when(this.workflowDataService.save(any(Workflow.class), any(String.class))).thenReturn(workflow);

    final Workflow resWorkflow = this.workflowProcessService.save(workflow, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testSaveWorkflowNewInitialize() throws Exception {

    final Workflow workflowSaveResult = this.getTestWorkflow(1L);
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);

    final Workflow workflow = this.getTestWorkflow(1L);
    workflow.setStatus(EWorkflowStatus.INITIALIZE);
    workflow.setId(null);

    when(this.workflowDataService.save(any(Workflow.class), any(String.class))).thenReturn(workflowSaveResult);

    final Workflow resWorkflow = this.workflowProcessService.save(workflow, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflowSaveResult.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflowSaveResult.getTitle() + "'!",
                        resWorkflow.getTitle(),
                        workflowSaveResult.getTitle());
    Assert.assertEquals("Result workflow-type has status '" + workflowSaveResult.getStatus() + "'!",
                        resWorkflow.getStatus(),
                        workflowSaveResult.getStatus());

  }

  @Test
  public void testSaveWorkflowAssigned() throws Exception {

    final Workflow workflowSaveResult = this.getTestWorkflow(1L);
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);

    final Workflow workflow = this.getTestWorkflow(1L);
    workflow.setStatus(EWorkflowStatus.ASSIGNED);

    when(this.workflowDataService.save(any(Workflow.class), any(String.class))).thenReturn(workflowSaveResult);

    final Workflow resWorkflow = this.workflowProcessService.save(workflow, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflowSaveResult.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflowSaveResult.getTitle() + "'!",
                        resWorkflow.getTitle(),
                        workflowSaveResult.getTitle());
    Assert.assertEquals("Result workflow-type has status '" + workflowSaveResult.getStatus() + "'!",
                        resWorkflow.getStatus(),
                        workflowSaveResult.getStatus());

  }

  @Test
  public void testSaveWorkflowNotnewNotAssignedDone() throws Exception {

    final Workflow workflowSaveResult = this.getTestWorkflow(1L);
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);

    final Workflow workflow = this.getTestWorkflow(1L);
    workflow.setStatus(EWorkflowStatus.DONE);

    when(this.workflowDataService.save(any(Workflow.class), any(String.class))).thenReturn(workflowSaveResult);

    final Workflow resWorkflow = this.workflowProcessService.save(workflow, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflowSaveResult.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflowSaveResult.getTitle() + "'!",
                        resWorkflow.getTitle(),
                        workflowSaveResult.getTitle());
    Assert.assertEquals("Result workflow-type has status '" + workflowSaveResult.getStatus() + "'!",
                        resWorkflow.getStatus(),
                        workflowSaveResult.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final List<Long> idList = this.getTestWorkflowIdList();
    final List<Workflow> list = this.getTestWorkflowList();

    when(this.workflowDataService.getListByIdList(any(List.class), any(String.class))).thenReturn(list);

    final List<Workflow> resList = this.workflowProcessService.getListByIdList(idList, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByTypeId() throws Exception {

    final List<Workflow> list = this.getTestWorkflowList();

    when(this.workflowDataService.getListByTypeId(any(Long.class), any(String.class))).thenReturn(list);

    final List<Workflow> resList = this.workflowProcessService.getListByTypeId(1L, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

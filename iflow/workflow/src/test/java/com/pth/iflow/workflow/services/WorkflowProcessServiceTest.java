package com.pth.iflow.workflow.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
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

import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.ITokenValidator;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.bl.impl.WorkflowProcessService;
import com.pth.iflow.workflow.bl.strategy.IWorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategy;
import com.pth.iflow.workflow.models.ProfileResponse;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.WorkflowType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowProcessServiceTest extends TestDataProducer {

  private IWorkflowProcessService  workflowProcessService;

  @Mock
  private IWorkflowDataService     workflowDataService;

  @Mock
  private IWorkflowTypeDataService workflowTypeDataService;

  @Mock
  private ITokenValidator          tokenValidator;

  @Mock
  IWorkStrategyFactory             workStrategyFactory;

  @Mock
  private IWorkflowSaveStrategy    saveStrategy;

  @Mock
  private IWorkflowSaveStrategy    validateStrategy;

  private WorkflowType             workflowType;

  private String                   validTocken;

  private String                   validSession;

  private ProfileResponse          profileResponse;

  @Before
  public void setUp() throws Exception {
    this.workflowProcessService = new WorkflowProcessService(this.workflowDataService, this.workflowTypeDataService,
        this.tokenValidator, this.workStrategyFactory);

    this.validTocken = "validTocken";

    this.validSession = "validSession";

    this.workflowType = this.getTestWorkflowType(1L, "Type 1");

    when(this.workflowTypeDataService.getById(any(Long.class), any(String.class))).thenReturn(this.workflowType);

    this.profileResponse = new ProfileResponse(this.getTestUser(), this.getTestCompanyProfile(), this.validSession);

    when(this.tokenValidator.isTokenValid(this.validTocken)).thenReturn(this.profileResponse);

    when(this.workStrategyFactory.selectSaveWorkStrategy(any(WorkflowSaveRequest.class), any(String.class)))
        .thenReturn(this.saveStrategy);

    when(this.workStrategyFactory.selectValidationWorkStrategy(any(WorkflowSaveRequest.class), any(String.class)))
        .thenReturn(this.validateStrategy);

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
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test(expected = IFlowCustomeException.class)
  public void testSaveWorkflowUnknownWorkflowStatus() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    request.setWorkflow(this.getTestWorkflow(1L, EWorkflowActionStatus.ERROR));

    doThrow(new IFlowCustomeException(EIFlowErrorType.INVALID_WORKFLOW_STATUS)).when(this.saveStrategy).process();

    // when(this.saveStrategy.process()).thenThrow(new
    // IFlowCustomeException(EIFlowErrorType.UNKNOWN_WORKFLOW_SAVE_STRATEGY));

    final Workflow resWorkflow = this.workflowProcessService.save(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), request.getWorkflow().getId());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), request.getWorkflow().getStatus());

  }

  @Test
  public void testSaveWorkflowNewInitialize() throws Exception {

    final Workflow workflowSaveResult = this.getTestWorkflow(1L);
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);

    final Workflow workflow = this.getTestWorkflow(1L);
    workflow.setStatus(EWorkflowStatus.INITIALIZE);
    workflow.setId(null);

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    request.setWorkflow(workflow);

    doNothing().when(this.saveStrategy).process();
    when(this.saveStrategy.getSingleProceedWorkflow()).thenReturn(workflowSaveResult);

    final Workflow resWorkflow = this.workflowProcessService.save(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflowSaveResult.getId());
    Assert.assertEquals("Result workflow-type has status '" + workflowSaveResult.getStatus() + "'!", resWorkflow.getStatus(),
        workflowSaveResult.getStatus());

  }

  @Test
  public void testSaveWorkflowAssigned() throws Exception {

    final Workflow workflowSaveResult = this.getTestWorkflow(1L);
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);

    final Workflow workflow = this.getTestWorkflow(1L);
    workflow.setStatus(EWorkflowStatus.ASSIGNED);

    doNothing().when(this.saveStrategy).process();
    when(this.saveStrategy.getSingleProceedWorkflow()).thenReturn(workflowSaveResult);

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    request.setWorkflow(workflow);

    final Workflow resWorkflow = this.workflowProcessService.save(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflowSaveResult.getId());
    Assert.assertEquals("Result workflow-type has status '" + workflowSaveResult.getStatus() + "'!", resWorkflow.getStatus(),
        workflowSaveResult.getStatus());

  }

  @Test
  public void testSaveWorkflowNotnewNotAssignedDone() throws Exception {

    final Workflow workflowSaveResult = this.getTestWorkflow(1L);
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);

    final Workflow workflow = this.getTestWorkflow(1L);
    workflow.setStatus(EWorkflowStatus.DONE);

    doNothing().when(this.saveStrategy).process();
    when(this.saveStrategy.getSingleProceedWorkflow()).thenReturn(workflowSaveResult);

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    request.setWorkflow(workflow);

    final Workflow resWorkflow = this.workflowProcessService.save(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflowSaveResult.getId());
    Assert.assertEquals("Result workflow-type has status '" + workflowSaveResult.getStatus() + "'!", resWorkflow.getStatus(),
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

  @Test
  public void testCreateWorkflow() throws Exception {

    final Workflow workflowSaveResult = this.getTestWorkflow(1L);
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);
    workflowSaveResult.setId(null);
    final List<Workflow> reultList = Arrays.asList(workflowSaveResult, workflowSaveResult, workflowSaveResult);

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    request.getWorkflow().setStatus(EWorkflowStatus.INITIALIZE);

    doNothing().when(this.saveStrategy).process();
    when(this.saveStrategy.getSingleProceedWorkflow()).thenReturn(workflowSaveResult);
    when(this.saveStrategy.getProceedWorkflowList()).thenReturn(reultList);

    final List<Workflow> resWorkflowList = this.workflowProcessService.create(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowList);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowList.size(), request.getAssigns().size());

  }

  @Test
  public void testSearchWorkflow() throws Exception {

    final List<Workflow> workflowListResult = this.getTestWorkflowList();

    final WorkflowSearchFilter filter = this.getTestWorkflowSearchFilter();

    when(this.workflowDataService.search(any(WorkflowSearchFilter.class), any(String.class))).thenReturn(workflowListResult);

    final List<Workflow> resWorkflowList = this.workflowProcessService.search(filter, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowList);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowList.size(), workflowListResult.size());

  }

  @Test
  public void testValidateWorkflow() throws Exception {

    final Workflow workflowSaveResult = this.getTestWorkflow(1L);
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);
    workflowSaveResult.setId(null);

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    request.getWorkflow().setStatus(EWorkflowStatus.INITIALIZE);

    doNothing().when(this.validateStrategy).process();

    this.workflowProcessService.validate(request, this.validTocken);

  }

}

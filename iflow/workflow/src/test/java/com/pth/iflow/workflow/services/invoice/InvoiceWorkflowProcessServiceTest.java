package com.pth.iflow.workflow.services.invoice;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.ITokenValidator;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowPrepare;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.bl.impl.workflowservice.invoice.InvoiceWorkflowProcessService;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategy;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategyFactory;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.ProfileResponse;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflowSaveRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceWorkflowProcessServiceTest extends TestDataProducer {

  private IWorkflowProcessService<InvoiceWorkflow> workflowProcessService;

  @Mock
  private IWorkflowDataService<InvoiceWorkflow>    workflowDataService;

  @Mock
  private IWorkflowPrepare<InvoiceWorkflow>        workflowPrepare;

  @Mock
  private ITokenValidator                          tokenValidator;

  @Mock
  IWorkflowSaveStrategyFactory<InvoiceWorkflow>    workStrategyFactory;

  @Mock
  private IWorkflowSaveStrategy<InvoiceWorkflow>   saveStrategy;

  @Mock
  private IWorkflowSaveStrategy<InvoiceWorkflow>   validateStrategy;

  private String                                   validTocken;

  private String                                   validSession;

  private ProfileResponse                          profileResponse;

  @Before
  public void setUp() throws Exception {
    this.workflowProcessService = new InvoiceWorkflowProcessService(this.workflowDataService, this.tokenValidator,
        this.workStrategyFactory, this.workflowPrepare);

    this.validTocken = "validTocken";

    this.validSession = "validSession";

    this.profileResponse = new ProfileResponse(this.getTestUser(), this.getTestCompanyProfile(), this.validSession);

    when(this.tokenValidator.isTokenValid(this.validTocken)).thenReturn(this.profileResponse);

    when(this.workStrategyFactory.selectSaveWorkStrategy(any(InvoiceWorkflowSaveRequest.class), any(String.class)))
        .thenReturn(this.saveStrategy);

    when(this.workStrategyFactory.selectValidationWorkStrategy(any(InvoiceWorkflowSaveRequest.class), any(String.class)))
        .thenReturn(this.validateStrategy);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final InvoiceWorkflow workflow = this.getInvoiceTestWorkflow("workflow1", EWorkflowActionStatus.OPEN);

    when(this.workflowDataService.getByIdentity(any(String.class), any(String.class))).thenReturn(workflow);
    when(this.workflowPrepare.prepareWorkflow(any(String.class), any(InvoiceWorkflow.class))).thenReturn(workflow);

    final InvoiceWorkflow resWorkflow = this.workflowProcessService.getByIdentity(workflow.getIdentity(), this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test(expected = WorkflowCustomizedException.class)
  public void testSaveWorkflowUnknownWorkflowStatus() throws Exception {

    final InvoiceWorkflowSaveRequest request = this.getTestInvoiceWorkflowSaveRequest();
    request.setWorkflow(this.getInvoiceTestWorkflow("workflow1", EWorkflowActionStatus.ERROR));

    doThrow(new WorkflowCustomizedException("", EIFlowErrorType.INVALID_WORKFLOW_STATUS)).when(this.saveStrategy).process();

    final InvoiceWorkflow resWorkflow = this.workflowProcessService.save(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), request.getWorkflow().getIdentity());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), request.getWorkflow().getStatus());

  }

  @Test
  public void testSaveWorkflowNewInitialize() throws Exception {

    final InvoiceWorkflow workflowSaveResult = this.getInvoiceTestWorkflow("workflow1", EWorkflowActionStatus.OPEN);
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);

    final InvoiceWorkflow workflow = this.getInvoiceTestWorkflow("workflow1", EWorkflowActionStatus.OPEN);
    workflow.setStatus(EWorkflowStatus.INITIALIZE);
    workflow.setIdentityToNew();

    final InvoiceWorkflowSaveRequest request = this.getTestInvoiceWorkflowSaveRequest();
    request.setWorkflow(workflow);

    doNothing().when(this.saveStrategy).process();
    when(this.saveStrategy.getSingleProceedWorkflow()).thenReturn(workflowSaveResult);

    final InvoiceWorkflow resWorkflow = this.workflowProcessService.save(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), workflowSaveResult.getIdentity());
    Assert.assertEquals("Result workflow-type has status '" + workflowSaveResult.getStatus() + "'!", resWorkflow.getStatus(),
        workflowSaveResult.getStatus());

  }

  @Test
  public void testSaveWorkflowAssigned() throws Exception {

    final InvoiceWorkflow workflowSaveResult = this.getInvoiceTestWorkflow("workflow1", EWorkflowActionStatus.OPEN);
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);

    final InvoiceWorkflow workflow = this.getInvoiceTestWorkflow("workflow1", EWorkflowActionStatus.OPEN);
    workflow.setStatus(EWorkflowStatus.ASSIGNED);

    doNothing().when(this.saveStrategy).process();
    when(this.saveStrategy.getSingleProceedWorkflow()).thenReturn(workflowSaveResult);

    final InvoiceWorkflowSaveRequest request = this.getTestInvoiceWorkflowSaveRequest();
    request.setWorkflow(workflow);

    final InvoiceWorkflow resWorkflow = this.workflowProcessService.save(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), workflowSaveResult.getIdentity());
    Assert.assertEquals("Result workflow-type has status '" + workflowSaveResult.getStatus() + "'!", resWorkflow.getStatus(),
        workflowSaveResult.getStatus());

  }

  @Test
  public void testSaveWorkflowNotnewNotAssignedDone() throws Exception {

    final InvoiceWorkflow workflowSaveResult = this.getInvoiceTestWorkflow("workflow1", EWorkflowActionStatus.OPEN);
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);

    final InvoiceWorkflow workflow = this.getInvoiceTestWorkflow("workflow1", EWorkflowActionStatus.OPEN);
    workflow.setStatus(EWorkflowStatus.DONE);

    doNothing().when(this.saveStrategy).process();
    when(this.saveStrategy.getSingleProceedWorkflow()).thenReturn(workflowSaveResult);

    final InvoiceWorkflowSaveRequest request = this.getTestInvoiceWorkflowSaveRequest();
    request.setWorkflow(workflow);

    final InvoiceWorkflow resWorkflow = this.workflowProcessService.save(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), workflowSaveResult.getIdentity());
    Assert.assertEquals("Result workflow-type has status '" + workflowSaveResult.getStatus() + "'!", resWorkflow.getStatus(),
        workflowSaveResult.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = this.getTestWorkflowIdSet();
    ;
    final List<InvoiceWorkflow> list = this.getTestInvoiceWorkflowList();

    when(this.workflowDataService.getListByIdentityList(any(Set.class), any(String.class))).thenReturn(list);
    when(this.workflowPrepare.prepareWorkflowList(any(String.class), any(List.class))).thenReturn(list);

    final List<InvoiceWorkflow> resList = this.workflowProcessService.getListByIdentityList(idList, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", list.size(), resList.size());

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final InvoiceWorkflow workflowSaveResult = this.getInvoiceTestWorkflow("workflow1", EWorkflowActionStatus.OPEN);
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);
    workflowSaveResult.setIdentityToNew();
    final List<InvoiceWorkflow> reultList = Arrays.asList(workflowSaveResult, workflowSaveResult, workflowSaveResult);

    final InvoiceWorkflowSaveRequest request = this.getTestInvoiceWorkflowSaveRequest();
    request.getWorkflow().setStatus(EWorkflowStatus.INITIALIZE);

    doNothing().when(this.saveStrategy).process();
    when(this.saveStrategy.getSingleProceedWorkflow()).thenReturn(workflowSaveResult);
    when(this.saveStrategy.getProceedWorkflowList()).thenReturn(reultList);
    when(this.workflowPrepare.prepareWorkflowList(any(String.class), any(List.class))).thenReturn(reultList);

    final List<InvoiceWorkflow> resWorkflowList = this.workflowProcessService.create(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowList);
    Assert.assertEquals("Result workflow-type has id 1!", request.getAssigns().size(), resWorkflowList.size());

  }

  @Test
  public void testValidateWorkflow() throws Exception {

    final InvoiceWorkflow workflowSaveResult = this.getInvoiceTestWorkflow("workflow1", EWorkflowActionStatus.OPEN);
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);
    workflowSaveResult.setIdentityToNew();

    final InvoiceWorkflowSaveRequest request = this.getTestInvoiceWorkflowSaveRequest();
    request.getWorkflow().setStatus(EWorkflowStatus.INITIALIZE);

    doNothing().when(this.validateStrategy).process();

    this.workflowProcessService.validate(request, this.validTocken);

  }

}

package com.pth.iflow.workflow.services.singletask;

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
import com.pth.iflow.workflow.bl.impl.workflowservice.singletask.SingleTaskWorkflowProcessService;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategyFactory;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.ProfileResponse;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflowSaveRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SingleTaskWorkflowProcessServiceTest extends TestDataProducer {

  private IWorkflowProcessService<SingleTaskWorkflow> workflowProcessService;

  @Mock
  private IWorkflowDataService<SingleTaskWorkflow> workflowDataService;

  @Mock
  private IWorkflowPrepare<SingleTaskWorkflow> workflowPrepare;

  @Mock
  private ITokenValidator tokenValidator;

  @Mock
  IWorkflowSaveStrategyFactory<SingleTaskWorkflow> workStrategyFactory;

  @Mock
  private IWorkflowSaveStrategy<SingleTaskWorkflow> saveStrategy;

  @Mock
  private IWorkflowSaveStrategy<SingleTaskWorkflow> validateStrategy;

  private String validTocken;

  private String validSession;

  private ProfileResponse profileResponse;

  @Before
  public void setUp() throws Exception {
    this.workflowProcessService = new SingleTaskWorkflowProcessService(this.workflowDataService,
                                                                       this.tokenValidator,
                                                                       this.workStrategyFactory,
                                                                       this.workflowPrepare);

    this.validTocken = "validTocken";

    this.validSession = "validSession";

    this.profileResponse = new ProfileResponse(this.getTestUser(), this.getTestCompanyProfile(), this.validSession);

    when(this.tokenValidator.isTokenValid(this.validTocken)).thenReturn(this.profileResponse);

    when(this.workStrategyFactory.selectSaveWorkStrategy(any(SingleTaskWorkflowSaveRequest.class), any(String.class)))
                                                                                                                      .thenReturn(this.saveStrategy);

    when(this.workStrategyFactory.selectValidationWorkStrategy(any(SingleTaskWorkflowSaveRequest.class), any(String.class)))
                                                                                                                            .thenReturn(this.validateStrategy);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final SingleTaskWorkflow workflow = this.getTestSingleTaskWorkflow("workflow1");

    when(this.workflowDataService.getByIdentity(any(String.class), any(String.class))).thenReturn(workflow);
    when(this.workflowPrepare.prepareWorkflow(any(String.class), any(SingleTaskWorkflow.class))).thenReturn(workflow);

    final SingleTaskWorkflow resWorkflow = this.workflowProcessService.getByIdentity(workflow.getIdentity(), this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test(expected = WorkflowCustomizedException.class)
  public void testSaveWorkflowUnknownWorkflowStatus() throws Exception {

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();
    request.setWorkflow(this.getSingleTaskTestWorkflow("workflow1", EWorkflowActionStatus.ERROR));

    doThrow(new WorkflowCustomizedException("", EIFlowErrorType.INVALID_WORKFLOW_STATUS)).when(this.saveStrategy).process();

    final SingleTaskWorkflow resWorkflow = this.workflowProcessService.save(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), request.getWorkflow().getIdentity());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), request.getWorkflow().getStatus());

  }

  @Test
  public void testSaveWorkflowNewInitialize() throws Exception {

    final SingleTaskWorkflow workflowSaveResult = this.getTestSingleTaskWorkflow("workflow1");
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);

    final SingleTaskWorkflow workflow = this.getTestSingleTaskWorkflow("workflow1");
    workflow.setStatus(EWorkflowStatus.INITIALIZE);
    workflow.setIdentityToNew();

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();
    request.setWorkflow(workflow);

    doNothing().when(this.saveStrategy).process();
    when(this.saveStrategy.getSingleProceedWorkflow()).thenReturn(workflowSaveResult);

    final SingleTaskWorkflow resWorkflow = this.workflowProcessService.save(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), workflowSaveResult.getIdentity());
    Assert.assertEquals("Result workflow-type has status '" + workflowSaveResult.getStatus() + "'!",
                        resWorkflow.getStatus(),
                        workflowSaveResult.getStatus());

  }

  @Test
  public void testSaveWorkflowAssigned() throws Exception {

    final SingleTaskWorkflow workflowSaveResult = this.getTestSingleTaskWorkflow("workflow1");
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);

    final SingleTaskWorkflow workflow = this.getTestSingleTaskWorkflow("workflow1");
    workflow.setStatus(EWorkflowStatus.ASSIGNED);

    doNothing().when(this.saveStrategy).process();
    when(this.saveStrategy.getSingleProceedWorkflow()).thenReturn(workflowSaveResult);

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();
    request.setWorkflow(workflow);

    final SingleTaskWorkflow resWorkflow = this.workflowProcessService.save(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), workflowSaveResult.getIdentity());
    Assert.assertEquals("Result workflow-type has status '" + workflowSaveResult.getStatus() + "'!",
                        resWorkflow.getStatus(),
                        workflowSaveResult.getStatus());

  }

  @Test
  public void testSaveWorkflowNotnewNotAssignedDone() throws Exception {

    final SingleTaskWorkflow workflowSaveResult = this.getTestSingleTaskWorkflow("workflow1");
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);

    final SingleTaskWorkflow workflow = this.getTestSingleTaskWorkflow("workflow1");
    workflow.setStatus(EWorkflowStatus.DONE);

    doNothing().when(this.saveStrategy).process();
    when(this.saveStrategy.getSingleProceedWorkflow()).thenReturn(workflowSaveResult);

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();
    request.setWorkflow(workflow);

    final SingleTaskWorkflow resWorkflow = this.workflowProcessService.save(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), workflowSaveResult.getIdentity());
    Assert.assertEquals("Result workflow-type has status '" + workflowSaveResult.getStatus() + "'!",
                        resWorkflow.getStatus(),
                        workflowSaveResult.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = this.getTestWorkflowIdSet();;
    final List<SingleTaskWorkflow> list = this.getTestSingleTaskWorkflowList();

    when(this.workflowDataService.getListByIdentityList(any(Set.class), any(String.class))).thenReturn(list);
    when(this.workflowPrepare.prepareWorkflowList(any(String.class), any(List.class))).thenReturn(list);

    final List<SingleTaskWorkflow> resList = this.workflowProcessService.getListByIdentityList(idList, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", list.size(), resList.size());

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final SingleTaskWorkflow workflowSaveResult = this.getTestSingleTaskWorkflow("workflow1");
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);
    workflowSaveResult.setIdentityToNew();
    final List<SingleTaskWorkflow> reultList = Arrays.asList(workflowSaveResult, workflowSaveResult, workflowSaveResult);

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();
    request.getWorkflow().setStatus(EWorkflowStatus.INITIALIZE);

    doNothing().when(this.saveStrategy).process();
    when(this.saveStrategy.getSingleProceedWorkflow()).thenReturn(workflowSaveResult);
    when(this.saveStrategy.getProceedWorkflowList()).thenReturn(reultList);
    when(this.workflowPrepare.prepareWorkflowList(any(String.class), any(List.class))).thenReturn(reultList);

    final List<SingleTaskWorkflow> resWorkflowList = this.workflowProcessService.create(request, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowList);
    Assert.assertEquals("Result workflow-type has id 1!", request.getAssigns().size(), resWorkflowList.size());

  }

  @Test
  public void testSearchWorkflow() throws Exception {

    final List<SingleTaskWorkflow> workflowListResult = this.getTestSingleTaskWorkflowList();

    final WorkflowSearchFilter filter = this.getTestWorkflowSearchFilter();

    when(this.workflowDataService.search(any(WorkflowSearchFilter.class), any(String.class))).thenReturn(workflowListResult);
    when(this.workflowPrepare.prepareWorkflowList(any(String.class), any(List.class))).thenReturn(workflowListResult);

    final List<SingleTaskWorkflow> resWorkflowList = this.workflowProcessService.search(filter, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowList);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowList.size(), workflowListResult.size());

  }

  @Test
  public void testValidateWorkflow() throws Exception {

    final SingleTaskWorkflow workflowSaveResult = this.getTestSingleTaskWorkflow("workflow1");
    workflowSaveResult.setStatus(EWorkflowStatus.ASSIGNED);
    workflowSaveResult.setIdentityToNew();

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();
    request.getWorkflow().setStatus(EWorkflowStatus.INITIALIZE);

    doNothing().when(this.validateStrategy).process();

    this.workflowProcessService.validate(request, this.validTocken);

  }

}

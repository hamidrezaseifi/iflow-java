package com.pth.iflow.workflow.services.singletask.strategy.strategies;

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
import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IProfileCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowPrepare;
import com.pth.iflow.workflow.bl.strategy.strategies.DoneExistingWorkflowStrategy;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DoneExistingWorkflowStrategyTest extends TestDataProducer {

  private DoneExistingWorkflowStrategy workflowStrategy;

  @Mock
  private IWorkflowDataService workflowDataService;

  @Mock
  private IDepartmentDataService departmentDataService;

  @Mock
  private IWorkflowMessageDataService workflowMessageDataService;

  @Mock
  private IProfileCachDataDataService cachDataDataService;

  @Mock
  private IWorkflowPrepare workflowPrepare;

  private String validTocken;

  @Before
  public void setUp() throws Exception {

    // when(this.workflowDataService.generateCoreUrl(any(String.class))).thenReturn(new
    // URL("http://any-string"));

    this.validTocken = "validTocken";
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testProccessStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequestForStrategy();
    request.setCommand(EWorkflowProcessCommand.DONE);
    final List<WorkflowAction> actions = request.getWorkflow().getActions();

    for (final WorkflowAction action : actions) {
      action.setAssignToIdentity("assignToIdentity");
      action.setStatus(EWorkflowActionStatus.DONE);
    }
    actions.get(actions.size() - 1).setStatus(EWorkflowActionStatus.OPEN);

    when(this.workflowDataService.getByIdentity(any(String.class), any(String.class))).thenReturn(request.getWorkflow());
    when(this.workflowDataService.save(any(Workflow.class), any(String.class))).thenReturn(request.getWorkflow());
    when(this.workflowPrepare.prepareWorkflow(any(String.class), any(Workflow.class))).thenReturn(request.getWorkflow());

    this.workflowStrategy = new DoneExistingWorkflowStrategy(request,
                                                             this.validTocken,
                                                             this.departmentDataService,
                                                             this.workflowMessageDataService,
                                                             this.cachDataDataService,
                                                             this.workflowDataService,
                                                             this.workflowPrepare);

    this.workflowStrategy.process();

    final Workflow resultWorkflow = this.workflowStrategy.getSingleProceedWorkflow();

    Assert.assertNotNull("Result workflow is not null!", resultWorkflow);
    Assert.assertEquals("The status of result workflow is " + EWorkflowStatus.DONE + "!",
                        EWorkflowStatus.DONE,
                        resultWorkflow.getStatus());

  }

}

package com.pth.iflow.workflow.services.singletask.strategy.strategies;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IProfileCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowPrepare;
import com.pth.iflow.workflow.bl.strategy.strategies.AssignWorkflowStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.AssignItem;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflowSaveRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AssignWorkflowStrategyTest extends TestDataProducer {

  private AssignWorkflowStrategy<SingleTaskWorkflow> workflowStrategy;

  @Mock
  private IWorkflowDataService<SingleTaskWorkflow> workflowDataService;

  @Mock
  private IDepartmentDataService departmentDataService;

  @Mock
  private IWorkflowMessageDataService workflowMessageDataService;

  @Mock
  private IProfileCachDataDataService cachDataDataService;

  @Mock
  private IWorkflowPrepare<SingleTaskWorkflow> workflowPrepare;

  private String validTocken;

  @Before
  public void setUp() throws Exception {

    this.validTocken = "validTocken";
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testProccessStrategy() throws Exception {

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();
    request.setCommand(EWorkflowProcessCommand.DONE);
    request.setAssigns(Arrays.asList(new AssignItem("user1", EAssignType.USER)));

    when(this.workflowPrepare.prepareWorkflow(any(String.class), any(SingleTaskWorkflow.class))).thenReturn(request.getWorkflow());
    when(this.workflowDataService.save(any(SingleTaskWorkflow.class), any(String.class))).thenReturn(request.getWorkflow());

    this.workflowStrategy = new AssignWorkflowStrategy<SingleTaskWorkflow>(request,
                                                                           this.validTocken,
                                                                           this.departmentDataService,
                                                                           this.workflowMessageDataService,
                                                                           this.cachDataDataService,
                                                                           this.workflowDataService,
                                                                           this.workflowPrepare);

    this.workflowStrategy.process();

    final SingleTaskWorkflow resultWorkflow = this.workflowStrategy.getSingleProceedWorkflow();

    Assert.assertNotNull("Result workflow is not null!", resultWorkflow);
    Assert.assertEquals("The status of result workflow is not changed!",
                        resultWorkflow.getStatus(),
                        request.getWorkflow().getStatus());

  }

  @Test(expected = WorkflowCustomizedException.class)
  public void testProccessStrategyError() throws Exception {

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();
    request.setCommand(EWorkflowProcessCommand.DONE);
    request.setAssigns(Arrays.asList());

    when(this.workflowDataService.save(any(SingleTaskWorkflow.class), any(String.class))).thenReturn(request.getWorkflow());

    this.workflowStrategy = new AssignWorkflowStrategy<SingleTaskWorkflow>(request,
                                                                           this.validTocken,
                                                                           this.departmentDataService,
                                                                           this.workflowMessageDataService,
                                                                           this.cachDataDataService,
                                                                           this.workflowDataService,
                                                                           this.workflowPrepare);

    this.workflowStrategy.process();

  }

}

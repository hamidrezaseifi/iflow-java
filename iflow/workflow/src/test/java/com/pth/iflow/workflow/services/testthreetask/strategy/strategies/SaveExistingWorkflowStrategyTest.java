package com.pth.iflow.workflow.services.testthreetask.strategy.strategies;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IGuiCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowPrepare;
import com.pth.iflow.workflow.bl.strategy.strategies.SaveExistingWorkflowStrategy;
import com.pth.iflow.workflow.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.workflow.models.workflow.testthree.TestThreeTaskWorkflowSaveRequest;
import com.pth.iflow.workflow.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SaveExistingWorkflowStrategyTest extends TestDataProducer {

  private SaveExistingWorkflowStrategy<TestThreeTaskWorkflow> workflowStrategy;

  @Mock
  private IWorkflowDataService<TestThreeTaskWorkflow> workflowDataService;

  @Mock
  private IDepartmentDataService departmentDataService;

  @Mock
  private IWorkflowMessageDataService workflowMessageDataService;

  @Mock
  private IGuiCachDataDataService cachDataDataService;

  @Mock
  private IWorkflowPrepare<TestThreeTaskWorkflow> workflowPrepare;

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testProccessStrategy() throws Exception {

    final TestThreeTaskWorkflowSaveRequest request = this.getTestTestThreeTaskWorkflowSaveRequest();
    request.setCommand(EWorkflowProcessCommand.DONE);
    request.getWorkflow().getActiveAction().setAssignToUser(getTestUser("fname", "lname", "email"));
    request.getWorkflow().getActiveAction().setAssignToIdentity("email");

    when(this.workflowDataService.save(any(TestThreeTaskWorkflow.class), any())).thenReturn(request.getWorkflow());
    when(this.workflowPrepare.prepareWorkflow(any(), any(TestThreeTaskWorkflow.class))).thenReturn(request.getWorkflow());

    this.workflowStrategy = new SaveExistingWorkflowStrategy<TestThreeTaskWorkflow>(request,
        this.getValidAuthentiocation(),
        this.departmentDataService,
        this.workflowMessageDataService,
        this.cachDataDataService,
        this.workflowDataService,
        this.workflowPrepare);

    this.workflowStrategy.process();

    final TestThreeTaskWorkflow resultWorkflow = this.workflowStrategy.getSingleProceedWorkflow();

    Assert.assertNotNull("Result workflow is not null!", resultWorkflow);
    Assert.assertEquals("The status of result workflow is ARCHIVED!", resultWorkflow.getStatus(), request.getWorkflow().getStatus());

  }

}

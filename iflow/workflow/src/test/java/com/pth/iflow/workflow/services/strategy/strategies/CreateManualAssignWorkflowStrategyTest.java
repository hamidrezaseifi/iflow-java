package com.pth.iflow.workflow.services.strategy.strategies;

import static org.mockito.ArgumentMatchers.any;
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

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IProfileCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategy.strategies.CreateManualAssignWorkflowStrategy;
import com.pth.iflow.workflow.models.AssignItem;
import com.pth.iflow.workflow.models.User;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CreateManualAssignWorkflowStrategyTest extends TestDataProducer {

  private CreateManualAssignWorkflowStrategy workflowStrategy;

  @Mock
  private IWorkflowDataService               workflowDataService;

  @Mock
  private IDepartmentDataService             departmentDataService;

  @Mock
  private IWorkflowMessageDataService        workflowMessageDataService;

  @Mock
  private IProfileCachDataDataService        cachDataDataService;

  private String                             validTocken;

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
    request.setAssigns(Arrays.asList(new AssignItem(1L, EAssignType.USER), new AssignItem(1L, EAssignType.DEPARTMENT)));

    final List<User> userList = getTestUserList();

    when(this.workflowDataService.save(any(Workflow.class), any(String.class))).thenReturn(request.getWorkflow());

    when(this.departmentDataService.getUserListByDepartmentId(any(Long.class), any(String.class))).thenReturn(userList);

    this.workflowStrategy = new CreateManualAssignWorkflowStrategy(request, this.validTocken, this.departmentDataService,
        this.workflowMessageDataService, this.cachDataDataService, workflowDataService);

    this.workflowStrategy.process();

    final Workflow resultWorkflow = this.workflowStrategy.getSingleProceedWorkflow();
    final List<Workflow> resultWorkflowList = this.workflowStrategy.getSavedWorkflowList();

    Assert.assertNull("SingleProceedWorkflow is null!", resultWorkflow);
    Assert.assertNotNull("SingleProceedWorkflow is null!", resultWorkflowList);
    Assert.assertEquals("The result workflow list size must be 3!", resultWorkflowList.size(), userList.size());

  }

  @Test(expected = IFlowCustomeException.class)
  public void testProccessStrategyError() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequestForStrategy();
    request.setCommand(EWorkflowProcessCommand.DONE);
    request.setAssigns(Arrays.asList());

    when(this.workflowDataService.save(any(Workflow.class), any(String.class))).thenReturn(request.getWorkflow());

    this.workflowStrategy = new CreateManualAssignWorkflowStrategy(request, this.validTocken, this.departmentDataService,
        this.workflowMessageDataService, this.cachDataDataService, workflowDataService);

    this.workflowStrategy.process();

  }

}

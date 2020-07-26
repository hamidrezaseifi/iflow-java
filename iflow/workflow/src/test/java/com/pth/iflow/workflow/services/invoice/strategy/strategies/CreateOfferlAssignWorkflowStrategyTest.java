package com.pth.iflow.workflow.services.invoice.strategy.strategies;

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
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IGuiCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowPrepare;
import com.pth.iflow.workflow.bl.strategy.strategies.CreateOfferlAssignWorkflowStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.AssignItem;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflowSaveRequest;
import com.pth.iflow.workflow.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CreateOfferlAssignWorkflowStrategyTest extends TestDataProducer {

  private CreateOfferlAssignWorkflowStrategy<InvoiceWorkflow> workflowStrategy;

  @Mock
  private IWorkflowDataService<InvoiceWorkflow> workflowDataService;

  @Mock
  private IDepartmentDataService departmentDataService;

  @Mock
  private IWorkflowMessageDataService workflowMessageDataService;

  @Mock
  private IGuiCachDataDataService cachDataDataService;

  @Mock
  private IWorkflowPrepare<InvoiceWorkflow> workflowPrepare;

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testProccessStrategy() throws Exception {

    final InvoiceWorkflowSaveRequest request = this.getTestInvoiceWorkflowSaveRequest();
    request.setCommand(EWorkflowProcessCommand.DONE);
    request.setAssigns(Arrays.asList(new AssignItem("user1", EAssignType.USER), new AssignItem("user2", EAssignType.DEPARTMENT)));

    when(this.workflowDataService.save(any(InvoiceWorkflow.class), any())).thenReturn(request.getWorkflow());
    when(this.workflowPrepare.prepareWorkflow(any(), any(InvoiceWorkflow.class))).thenReturn(request.getWorkflow());

    when(this.departmentDataService.getUserListByDepartmentIdentity(any(String.class), any()))
        .thenReturn(getTestUserList());

    this.workflowStrategy = new CreateOfferlAssignWorkflowStrategy<InvoiceWorkflow>(request,
        this.getValidAuthentiocation(),
        this.departmentDataService,
        this.workflowMessageDataService,
        this.cachDataDataService,
        this.workflowDataService,
        this.workflowPrepare);

    this.workflowStrategy.process();

    final InvoiceWorkflow resultWorkflow = this.workflowStrategy.getSingleProceedWorkflow();
    final List<InvoiceWorkflow> resultWorkflowList = this.workflowStrategy.getProceedWorkflowList();

    Assert.assertNotNull("Result workflow is not null!", resultWorkflow);
    Assert.assertEquals("The Result workflow list ahst one item!", resultWorkflowList.size(), 1);

  }

  @Test(expected = WorkflowCustomizedException.class)
  public void testProccessStrategyError() throws Exception {

    final InvoiceWorkflowSaveRequest request = this.getTestInvoiceWorkflowSaveRequest();
    request.setCommand(EWorkflowProcessCommand.DONE);
    request.setAssigns(Arrays.asList());

    when(this.workflowDataService.save(any(InvoiceWorkflow.class), any())).thenReturn(request.getWorkflow());

    this.workflowStrategy = new CreateOfferlAssignWorkflowStrategy<InvoiceWorkflow>(request,
        this.getValidAuthentiocation(),
        this.departmentDataService,
        this.workflowMessageDataService,
        this.cachDataDataService,
        this.workflowDataService,
        this.workflowPrepare);

    this.workflowStrategy.process();

  }

}

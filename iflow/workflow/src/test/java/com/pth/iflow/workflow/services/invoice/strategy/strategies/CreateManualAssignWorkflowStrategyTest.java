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

import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IGuiCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowPrepare;
import com.pth.iflow.workflow.bl.strategy.strategies.CreateManualAssignWorkflowStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.User;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflowSaveRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CreateManualAssignWorkflowStrategyTest extends TestDataProducer {

  private CreateManualAssignWorkflowStrategy<InvoiceWorkflow> workflowStrategy;

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

    final InvoiceWorkflowSaveRequest request = this.getTestInvoiceWorkflowSaveRequest();
    request.setCommand(EWorkflowProcessCommand.CREATE);
    request.setAssigns(getTestAssignedList());

    final List<User> userList = getTestUserList();

    when(this.workflowDataService.save(any(InvoiceWorkflow.class), any(String.class))).thenReturn(request.getWorkflow());
    when(this.workflowPrepare.prepareWorkflow(any(String.class), any(InvoiceWorkflow.class))).thenReturn(request.getWorkflow());

    // this.workflowDataService.save(workflow, this.token);
    // workflowPrepare.prepareWorkflow(this.token, workflow);

    when(this.departmentDataService.getUserListByDepartmentIdentity(any(String.class), any(String.class))).thenReturn(userList);

    this.workflowStrategy = new CreateManualAssignWorkflowStrategy<InvoiceWorkflow>(request,
        this.validTocken,
        this.departmentDataService,
        this.workflowMessageDataService,
        this.cachDataDataService,
        this.workflowDataService,
        this.workflowPrepare);

    this.workflowStrategy.process();

    final InvoiceWorkflow resultWorkflow = this.workflowStrategy.getSingleProceedWorkflow();
    final List<InvoiceWorkflow> resultWorkflowList = this.workflowStrategy.getProceedWorkflowList();

    Assert.assertNull("SingleProceedWorkflow is null!", resultWorkflow);
    Assert.assertNotNull("SingleProceedWorkflow is null!", resultWorkflowList);
    Assert.assertEquals("The result workflow list size must be 3!", userList.size(), resultWorkflowList.size());

  }

  @Test(expected = WorkflowCustomizedException.class)
  public void testProccessStrategyError() throws Exception {

    final InvoiceWorkflowSaveRequest request = this.getTestInvoiceWorkflowSaveRequest();
    request.setCommand(EWorkflowProcessCommand.CREATE);
    request.setAssigns(Arrays.asList());

    when(this.workflowDataService.save(any(InvoiceWorkflow.class), any(String.class))).thenReturn(request.getWorkflow());

    this.workflowStrategy = new CreateManualAssignWorkflowStrategy<InvoiceWorkflow>(request,
        this.validTocken,
        this.departmentDataService,
        this.workflowMessageDataService,
        this.cachDataDataService,
        this.workflowDataService,
        this.workflowPrepare);

    this.workflowStrategy.process();

  }

}

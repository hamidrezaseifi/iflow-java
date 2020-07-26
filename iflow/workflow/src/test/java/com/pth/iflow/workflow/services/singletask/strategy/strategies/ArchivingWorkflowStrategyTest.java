package com.pth.iflow.workflow.services.singletask.strategy.strategies;

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
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IGuiCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowPrepare;
import com.pth.iflow.workflow.bl.strategy.strategies.ArchivingWorkflowStrategy;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflowSaveRequest;
import com.pth.iflow.workflow.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ArchivingWorkflowStrategyTest extends TestDataProducer {

  private ArchivingWorkflowStrategy<SingleTaskWorkflow> workflowStrategy;

  @Mock
  private IWorkflowDataService<SingleTaskWorkflow> workflowDataService;

  @Mock
  private IDepartmentDataService departmentDataService;

  @Mock
  private IWorkflowMessageDataService workflowMessageDataService;

  @Mock
  private IGuiCachDataDataService cachDataDataService;

  @Mock
  private IWorkflowPrepare<SingleTaskWorkflow> workflowPrepare;

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testProccessStrategy() throws Exception {

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();
    request.setCommand(EWorkflowProcessCommand.ARCHIVE);

    when(this.workflowDataService.save(any(SingleTaskWorkflow.class), any())).thenReturn(request.getWorkflow());
    when(this.workflowPrepare.prepareWorkflow(any(), any(SingleTaskWorkflow.class))).thenReturn(request.getWorkflow());

    this.workflowStrategy = new ArchivingWorkflowStrategy<SingleTaskWorkflow>(request,
        this.getValidAuthentiocation(),
        this.departmentDataService,
        this.workflowMessageDataService,
        this.cachDataDataService,
        this.workflowDataService,
        this.workflowPrepare);

    this.workflowStrategy.process();

    final SingleTaskWorkflow resultWorkflow = this.workflowStrategy.getSingleProceedWorkflow();

    Assert.assertNotNull("Result workflow is not null!", resultWorkflow);
    Assert.assertEquals("The status of result workflow is ARCHIVED!", resultWorkflow.getStatus(), EWorkflowStatus.ARCHIVED);

  }

}

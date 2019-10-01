package com.pth.iflow.workflow.services.strategies;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

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
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.ICachDataDataService;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.bl.strategies.ISaveWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.IWorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategies.WorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategies.save.ArchivingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.save.DoneExistingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.save.SaveExistingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.save.SaveNewWorkflowStrategy;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowSaveStrategyFactoryTest extends TestDataProducer {

  private IWorkStrategyFactory        workStrategyFactory;

  @Mock
  private IWorkflowDataService        workflowDataService;

  @Mock
  private IWorkflowProcessService     workflowProcessService;

  @Mock
  private IDepartmentDataService      departmentDataService;

  @Mock
  private IWorkflowMessageDataService workflowMessageDataService;

  @Mock
  private ICachDataDataService        cachDataDataService;

  private String                      validTocken;

  @Before
  public void setUp() throws Exception {
    this.workStrategyFactory = new WorkStrategyFactory(this.workflowDataService, this.departmentDataService,
        this.workflowMessageDataService, this.cachDataDataService, this.workflowProcessService);

    // when(this.workflowDataService.generateCoreUrl(any(String.class))).thenReturn(new
    // URL("http://any-string"));

    this.validTocken = "validTocken";
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSelectSaveNewWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    request.getWorkflow().setId(null);
    request.setCommand(EWorkflowProcessCommand.CREATE);

    when(this.workflowProcessService.prepareWorkflow(any(String.class), any(Workflow.class))).thenReturn(request.getWorkflow());

    final ISaveWorkflowStrategy saveWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(request, this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is SaveNewWorkflowStrategy!", saveWorkflowStrategy.getClass(),
        SaveNewWorkflowStrategy.class);

  }

  @Test
  public void testSelectArchivingWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    request.setCommand(EWorkflowProcessCommand.ARCHIVE);

    when(this.workflowProcessService.prepareWorkflow(any(String.class), any(Workflow.class))).thenReturn(request.getWorkflow());

    final ISaveWorkflowStrategy saveWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(request, this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is ArchivingWorkflowStrategy!", saveWorkflowStrategy.getClass(),
        ArchivingWorkflowStrategy.class);

  }

  @Test
  public void testSelectDoneExistingWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();

    request.setCommand(EWorkflowProcessCommand.DONE);

    when(this.workflowProcessService.prepareWorkflow(any(String.class), any(Workflow.class))).thenReturn(request.getWorkflow());

    final ISaveWorkflowStrategy saveWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(request, this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is DoneExistingWorkflowStrategy!", saveWorkflowStrategy.getClass(),
        DoneExistingWorkflowStrategy.class);

  }

  @Test
  public void testSelectSaveExistingWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();

    request.setCommand(EWorkflowProcessCommand.SAVE);

    when(this.workflowProcessService.prepareWorkflow(any(String.class), any(Workflow.class))).thenReturn(request.getWorkflow());

    final ISaveWorkflowStrategy saveWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(request, this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is SaveExistingWorkflowStrategy!", saveWorkflowStrategy.getClass(),
        SaveExistingWorkflowStrategy.class);

  }

  @Test(expected = IFlowCustomeException.class)
  public void testSelectNoneStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    request.getWorkflow().setActions(new ArrayList<>());

    when(this.workflowProcessService.prepareWorkflow(any(String.class), any(Workflow.class))).thenReturn(request.getWorkflow());

    this.workStrategyFactory.selectSaveWorkStrategy(request, this.validTocken);

  }

}

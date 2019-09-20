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
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.bl.strategies.ISaveWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.IWorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategies.WorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategies.save.ArchivingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.save.DoneExistingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.save.SaveExistingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.save.SaveNewWorkflowStrategy;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowSaveStrategyFactoryTest extends TestDataProducer {

  private IWorkStrategyFactory     workStrategyFactory;

  @Mock
  private IWorkflowDataService     workflowDataService;

  @Mock
  private IWorkflowTypeDataService workflowTypeDataService;

  private String                   validTocken;

  @Before
  public void setUp() throws Exception {
    this.workStrategyFactory = new WorkStrategyFactory(this.workflowDataService, this.workflowTypeDataService);

    // when(this.workflowDataService.generateCoreUrl(any(String.class))).thenReturn(new
    // URL("http://any-string"));

    this.validTocken = "validTocken";
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSelectSaveNewWorkflowStrategy() throws Exception {

    final Workflow workflow = this.getTestWorkflow(1L);
    workflow.setId(null);
    workflow.setCommand(EWorkflowProcessCommand.CREATE);

    final WorkflowType workflowType = this.getTestWorkflowType(1L, "");
    when(this.workflowTypeDataService.getById(any(Long.class), any(String.class))).thenReturn(workflowType);

    final ISaveWorkflowStrategy saveWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(workflow, this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is SaveNewWorkflowStrategy!", saveWorkflowStrategy.getClass(),
        SaveNewWorkflowStrategy.class);

  }

  @Test
  public void testSelectArchivingWorkflowStrategy() throws Exception {

    final Workflow workflow = this.getTestWorkflow(1L);
    workflow.setCommand(EWorkflowProcessCommand.ARCHIVE);

    final WorkflowType workflowType = this.getTestWorkflowType(1L, "");
    when(this.workflowTypeDataService.getById(any(Long.class), any(String.class))).thenReturn(workflowType);

    final ISaveWorkflowStrategy saveWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(workflow, this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is ArchivingWorkflowStrategy!", saveWorkflowStrategy.getClass(),
        ArchivingWorkflowStrategy.class);

  }

  @Test
  public void testSelectDoneExistingWorkflowStrategy() throws Exception {

    final Workflow workflow = this.getTestWorkflow(1L);
    workflow.setAssignTo(1L);

    workflow.setCommand(EWorkflowProcessCommand.DONE);

    final WorkflowType workflowType = this.getTestWorkflowType(1L, "");
    when(this.workflowTypeDataService.getById(any(Long.class), any(String.class))).thenReturn(workflowType);

    final ISaveWorkflowStrategy saveWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(workflow, this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is DoneExistingWorkflowStrategy!", saveWorkflowStrategy.getClass(),
        DoneExistingWorkflowStrategy.class);

  }

  @Test
  public void testSelectSaveExistingWorkflowStrategy() throws Exception {

    final Workflow workflow = this.getTestWorkflow(1L);
    workflow.setAssignTo(1L);

    workflow.setCommand(EWorkflowProcessCommand.SAVE);

    final WorkflowType workflowType = this.getTestWorkflowType(1L, "");
    when(this.workflowTypeDataService.getById(any(Long.class), any(String.class))).thenReturn(workflowType);

    final ISaveWorkflowStrategy saveWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(workflow, this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is SaveExistingWorkflowStrategy!", saveWorkflowStrategy.getClass(),
        SaveExistingWorkflowStrategy.class);

  }

  @Test(expected = IFlowCustomeException.class)
  public void testSelectNoneStrategy() throws Exception {

    final Workflow workflow = this.getTestWorkflow(1L);
    workflow.setAssignTo(1L);
    workflow.setActions(new ArrayList<>());

    final WorkflowType workflowType = this.getTestWorkflowType(1L, "");
    when(this.workflowTypeDataService.getById(any(Long.class), any(String.class))).thenReturn(workflowType);

    this.workStrategyFactory.selectSaveWorkStrategy(workflow, this.validTocken);

  }

}

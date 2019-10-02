package com.pth.iflow.workflow.services.strategy;

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
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IProfileCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategy.IWorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategy;
import com.pth.iflow.workflow.bl.strategy.WorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategy.strategies.ArchivingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.CreateManualAssignWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.CreateOfferlAssignWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.DoneExistingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.SaveExistingWorkflowStrategy;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;
import com.pth.iflow.workflow.models.WorkflowType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowSaveStrategyFactoryTest extends TestDataProducer {

  private IWorkStrategyFactory        workStrategyFactory;

  @Mock
  private IWorkflowDataService        workflowDataService;

  @Mock
  private IDepartmentDataService      departmentDataService;

  @Mock
  private IWorkflowMessageDataService workflowMessageDataService;

  @Mock
  private IProfileCachDataDataService cachDataDataService;

  private String                      validTocken;

  @Before
  public void setUp() throws Exception {
    this.workStrategyFactory = new WorkStrategyFactory(this.workflowDataService, this.departmentDataService,
        this.workflowMessageDataService, this.cachDataDataService);

    // when(this.workflowDataService.generateCoreUrl(any(String.class))).thenReturn(new
    // URL("http://any-string"));

    this.validTocken = "validTocken";
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSelectArchivingWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    request.setCommand(EWorkflowProcessCommand.ARCHIVE);

    final IWorkflowSaveStrategy saveWorkflowStrategy = this.workStrategyFactory.selectWorkStrategy(request, this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is ArchivingWorkflowStrategy!", saveWorkflowStrategy.getClass(),
        ArchivingWorkflowStrategy.class);

  }

  @Test
  public void testSelectDoneExistingWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();

    request.setCommand(EWorkflowProcessCommand.DONE);

    final IWorkflowSaveStrategy saveWorkflowStrategy = this.workStrategyFactory.selectWorkStrategy(request, this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is DoneExistingWorkflowStrategy!", saveWorkflowStrategy.getClass(),
        DoneExistingWorkflowStrategy.class);

  }

  @Test
  public void testSelectSaveExistingWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();

    request.setCommand(EWorkflowProcessCommand.SAVE);

    final IWorkflowSaveStrategy saveWorkflowStrategy = this.workStrategyFactory.selectWorkStrategy(request, this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is SaveExistingWorkflowStrategy!", saveWorkflowStrategy.getClass(),
        SaveExistingWorkflowStrategy.class);

  }

  @Test(expected = IFlowCustomeException.class)
  public void testSelectNoneStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    request.getWorkflow().setActions(new ArrayList<>());

    this.workStrategyFactory.selectWorkStrategy(request, this.validTocken);

  }

  @Test
  public void testSelectCreateManualAssignWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest workflowCreateReq = this.getTestWorkflowCreateRequest();
    workflowCreateReq.setCommand(EWorkflowProcessCommand.CREATE);

    final WorkflowType workflowType = this.getTestWorkflowType(1L, "");
    workflowType.setAssignType(EWorkflowTypeAssignType.MANUAL);
    workflowCreateReq.getWorkflow().setWorkflowType(workflowType);
    workflowCreateReq.getWorkflow().setId(null);

    final IWorkflowSaveStrategy createWorkflowStrategy = this.workStrategyFactory.selectWorkStrategy(workflowCreateReq,
        this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", createWorkflowStrategy);
    Assert.assertEquals("Selected strategy is CreateManualAssignWorkflowStrategy!", createWorkflowStrategy.getClass(),
        CreateManualAssignWorkflowStrategy.class);

  }

  @Test
  public void testSelectCreateOfferlAssignWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest workflowCreateReq = this.getTestWorkflowCreateRequest();
    workflowCreateReq.setCommand(EWorkflowProcessCommand.CREATE);

    final WorkflowType workflowType = this.getTestWorkflowType(1L, "");
    workflowType.setAssignType(EWorkflowTypeAssignType.OFFER);
    workflowCreateReq.getWorkflow().setWorkflowType(workflowType);
    workflowCreateReq.getWorkflow().setId(null);

    final IWorkflowSaveStrategy createWorkflowStrategy = this.workStrategyFactory.selectWorkStrategy(workflowCreateReq,
        this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", createWorkflowStrategy);
    Assert.assertEquals("Selected strategy is CreateOfferlAssignWorkflowStrategy!", createWorkflowStrategy.getClass(),
        CreateOfferlAssignWorkflowStrategy.class);

  }

}
package com.pth.iflow.workflow.services.singletask.strategy;

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
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IGuiCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowPrepare;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategy;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategyFactory;
import com.pth.iflow.workflow.bl.strategy.factory.SingleTaskWorkflowSaveStrategyFactory;
import com.pth.iflow.workflow.bl.strategy.strategies.ArchivingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.CreateManualAssignWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.CreateOfferlAssignWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.DoneExistingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.SaveExistingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.validation.ArchivingWorkflowValidationStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.validation.CreateManualAssignWorkflowValidationStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.validation.CreateOfferlAssignWorkflowValidationStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.validation.DoneExistingWorkflowValidationStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.validation.SaveExistingWorkflowValidationStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflowSaveRequest;
import com.pth.iflow.workflow.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SingleTaskWorkflowSaveStrategyFactoryTest extends TestDataProducer {

  private IWorkflowSaveStrategyFactory<SingleTaskWorkflow> workStrategyFactory;

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

    this.workStrategyFactory = new SingleTaskWorkflowSaveStrategyFactory(this.workflowDataService,
        this.departmentDataService,
        this.workflowMessageDataService,
        this.cachDataDataService,
        this.workflowPrepare);

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testSelectArchivingWorkflowStrategy() throws Exception {

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();
    request.setCommand(EWorkflowProcessCommand.ARCHIVE);

    final IWorkflowSaveStrategy<SingleTaskWorkflow> saveWorkflowStrategy = this.workStrategyFactory
        .selectSaveWorkStrategy(request,
            this.getValidAuthentiocation());

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert
        .assertEquals("Selected strategy is ArchivingWorkflowStrategy!",
            saveWorkflowStrategy.getClass(),
            ArchivingWorkflowStrategy.class);

  }

  @Test
  public void testSelectDoneExistingWorkflowStrategy() throws Exception {

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();

    request.setCommand(EWorkflowProcessCommand.DONE);
    request.getWorkflow().setWorkflowType(getTestSingleTaskWorkflowType());
    final IWorkflowSaveStrategy<SingleTaskWorkflow> saveWorkflowStrategy = this.workStrategyFactory
        .selectSaveWorkStrategy(request,
            this.getValidAuthentiocation());

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert
        .assertEquals("Selected strategy is DoneExistingWorkflowStrategy!",
            saveWorkflowStrategy.getClass(),
            DoneExistingWorkflowStrategy.class);

  }

  @Test
  public void testSelectSaveExistingWorkflowStrategy() throws Exception {

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();

    request.setCommand(EWorkflowProcessCommand.SAVE);

    final IWorkflowSaveStrategy<SingleTaskWorkflow> saveWorkflowStrategy = this.workStrategyFactory
        .selectSaveWorkStrategy(request,
            this.getValidAuthentiocation());

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert
        .assertEquals("Selected strategy is SaveExistingWorkflowStrategy!",
            saveWorkflowStrategy.getClass(),
            SaveExistingWorkflowStrategy.class);

  }

  @Test(expected = WorkflowCustomizedException.class)
  public void testSelectNoneStrategy() throws Exception {

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();
    request.getWorkflow().setActions(new ArrayList<>());

    this.workStrategyFactory.selectSaveWorkStrategy(request, this.getValidAuthentiocation());

  }

  @Test
  public void testSelectCreateManualAssignWorkflowStrategy() throws Exception {

    final SingleTaskWorkflowSaveRequest workflowCreateReq = this.getTestSingleTaskWorkflowSaveRequest();
    workflowCreateReq.setCommand(EWorkflowProcessCommand.CREATE);

    final WorkflowType workflowType = this.getTestWorkflowType("type1", "");
    workflowType.setAssignType(EWorkflowTypeAssignType.MANUAL);
    workflowCreateReq.getWorkflow().setWorkflowType(workflowType);
    workflowCreateReq.getWorkflow().setIdentityToNew();

    final IWorkflowSaveStrategy<SingleTaskWorkflow> createWorkflowStrategy = this.workStrategyFactory
        .selectSaveWorkStrategy(workflowCreateReq,
            this.getValidAuthentiocation());

    Assert.assertNotNull("Result strategy is not null!", createWorkflowStrategy);
    Assert
        .assertEquals("Selected strategy is CreateManualAssignWorkflowStrategy!",
            createWorkflowStrategy.getClass(),
            CreateManualAssignWorkflowStrategy.class);

  }

  @Test
  public void testSelectCreateOfferlAssignWorkflowStrategy() throws Exception {

    final SingleTaskWorkflowSaveRequest workflowCreateReq = this.getTestSingleTaskWorkflowSaveRequest();
    workflowCreateReq.setCommand(EWorkflowProcessCommand.CREATE);
    workflowCreateReq.getWorkflow().getWorkflowType().setAssignType(EWorkflowTypeAssignType.OFFER);

    final IWorkflowSaveStrategy<SingleTaskWorkflow> createWorkflowStrategy = this.workStrategyFactory
        .selectSaveWorkStrategy(workflowCreateReq,
            this.getValidAuthentiocation());

    Assert.assertNotNull("Result strategy is not null!", createWorkflowStrategy);
    Assert
        .assertEquals("Selected strategy is CreateOfferlAssignWorkflowStrategy!",
            createWorkflowStrategy.getClass(),
            CreateOfferlAssignWorkflowStrategy.class);

  }

  // ----------------------------------------------------------------------------------------------------------------------------------

  @Test
  public void testSelectArchivingWorkflowValidationStrategy() throws Exception {

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();
    request.setCommand(EWorkflowProcessCommand.ARCHIVE);

    final IWorkflowSaveStrategy<SingleTaskWorkflow> saveWorkflowStrategy = this.workStrategyFactory
        .selectValidationWorkStrategy(request,
            this.getValidAuthentiocation());

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert
        .assertEquals("Selected strategy is ArchivingWorkflowValidationStrategy!",
            saveWorkflowStrategy.getClass(),
            ArchivingWorkflowValidationStrategy.class);

  }

  @Test
  public void testSelectDoneExistingWorkflowValidationStrategy() throws Exception {

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();

    request.setCommand(EWorkflowProcessCommand.DONE);
    request.getWorkflow().setWorkflowType(getTestSingleTaskWorkflowType());
    final IWorkflowSaveStrategy<SingleTaskWorkflow> saveWorkflowStrategy = this.workStrategyFactory
        .selectValidationWorkStrategy(request,
            this.getValidAuthentiocation());

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert
        .assertEquals("Selected strategy is DoneExistingWorkflowValidationStrategy!",
            saveWorkflowStrategy.getClass(),
            DoneExistingWorkflowValidationStrategy.class);

  }

  @Test
  public void testSelectSaveExistingWorkflowValidationStrategy() throws Exception {

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();

    request.setCommand(EWorkflowProcessCommand.SAVE);

    final IWorkflowSaveStrategy<SingleTaskWorkflow> saveWorkflowStrategy = this.workStrategyFactory
        .selectValidationWorkStrategy(request,
            this.getValidAuthentiocation());

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert
        .assertEquals("Selected strategy is SaveExistingWorkflowValidationStrategy!",
            saveWorkflowStrategy.getClass(),
            SaveExistingWorkflowValidationStrategy.class);

  }

  @Test(expected = WorkflowCustomizedException.class)
  public void testSelectNoneValidationStrategy() throws Exception {

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest();
    request.getWorkflow().setActions(new ArrayList<>());

    this.workStrategyFactory.selectValidationWorkStrategy(request, this.getValidAuthentiocation());

  }

  @Test
  public void testSelectCreateManualAssignWorkflowValidationStrategy() throws Exception {

    final SingleTaskWorkflowSaveRequest workflowCreateReq = this.getTestSingleTaskWorkflowSaveRequest();
    workflowCreateReq.setCommand(EWorkflowProcessCommand.CREATE);
    workflowCreateReq.getWorkflow().getWorkflowType().setAssignType(EWorkflowTypeAssignType.MANUAL);

    final IWorkflowSaveStrategy<SingleTaskWorkflow> createWorkflowStrategy = this.workStrategyFactory
        .selectValidationWorkStrategy(workflowCreateReq,
            this.getValidAuthentiocation());

    Assert.assertNotNull("Result strategy is not null!", createWorkflowStrategy);
    Assert
        .assertEquals("Selected strategy is CreateManualAssignWorkflowValidationStrategy!",
            createWorkflowStrategy.getClass(),
            CreateManualAssignWorkflowValidationStrategy.class);

  }

  @Test
  public void testSelectCreateOfferlAssignWorkflowValidationStrategy() throws Exception {

    final SingleTaskWorkflowSaveRequest workflowCreateReq = this.getTestSingleTaskWorkflowSaveRequest();
    workflowCreateReq.setCommand(EWorkflowProcessCommand.CREATE);

    final WorkflowType workflowType = this.getTestWorkflowType("type1", "");
    workflowType.setAssignType(EWorkflowTypeAssignType.OFFER);
    workflowCreateReq.getWorkflow().setWorkflowType(workflowType);
    workflowCreateReq.getWorkflow().setIdentityToNew();

    final IWorkflowSaveStrategy<SingleTaskWorkflow> createWorkflowStrategy = this.workStrategyFactory
        .selectValidationWorkStrategy(workflowCreateReq,
            this.getValidAuthentiocation());

    Assert.assertNotNull("Result strategy is not null!", createWorkflowStrategy);
    Assert
        .assertEquals("Selected strategy is CreateOfferlAssignWorkflowValidationStrategy!",
            createWorkflowStrategy.getClass(),
            CreateOfferlAssignWorkflowValidationStrategy.class);

  }
}

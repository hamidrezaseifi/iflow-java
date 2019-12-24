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
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IProfileCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowPrepare;
import com.pth.iflow.workflow.bl.strategy.IWorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategy;
import com.pth.iflow.workflow.bl.strategy.WorkStrategyFactory;
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

  @Mock
  private IWorkflowPrepare            workflowPrepare;

  private String                      validTocken;

  @Before
  public void setUp() throws Exception {
    this.workStrategyFactory = new WorkStrategyFactory(this.workflowDataService, this.departmentDataService,
        this.workflowMessageDataService, this.cachDataDataService, this.workflowPrepare);

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

    final IWorkflowSaveStrategy saveWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(request, this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is ArchivingWorkflowStrategy!", saveWorkflowStrategy.getClass(),
        ArchivingWorkflowStrategy.class);

  }

  @Test
  public void testSelectDoneExistingWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();

    request.setCommand(EWorkflowProcessCommand.DONE);
    request.getWorkflow().setWorkflowType(getTestWorkflowType());
    final IWorkflowSaveStrategy saveWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(request, this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is DoneExistingWorkflowStrategy!", saveWorkflowStrategy.getClass(),
        DoneExistingWorkflowStrategy.class);

  }

  @Test
  public void testSelectSaveExistingWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();

    request.setCommand(EWorkflowProcessCommand.SAVE);

    final IWorkflowSaveStrategy saveWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(request, this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is SaveExistingWorkflowStrategy!", saveWorkflowStrategy.getClass(),
        SaveExistingWorkflowStrategy.class);

  }

  @Test(expected = WorkflowCustomizedException.class)
  public void testSelectNoneStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    request.getWorkflow().setActions(new ArrayList<>());

    this.workStrategyFactory.selectSaveWorkStrategy(request, this.validTocken);

  }

  @Test
  public void testSelectCreateManualAssignWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest workflowCreateReq = this.getTestWorkflowCreateRequest();
    workflowCreateReq.setCommand(EWorkflowProcessCommand.CREATE);

    final WorkflowType workflowType = this.getTestWorkflowType("type1", "");
    workflowType.setAssignType(EWorkflowTypeAssignType.MANUAL);
    workflowCreateReq.getWorkflow().setWorkflowType(workflowType);
    workflowCreateReq.getWorkflow().setIdentityToNew();

    final IWorkflowSaveStrategy createWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(workflowCreateReq,
        this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", createWorkflowStrategy);
    Assert.assertEquals("Selected strategy is CreateManualAssignWorkflowStrategy!", createWorkflowStrategy.getClass(),
        CreateManualAssignWorkflowStrategy.class);

  }

  @Test
  public void testSelectCreateOfferlAssignWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest workflowCreateReq = this.getTestWorkflowCreateRequest();
    workflowCreateReq.setCommand(EWorkflowProcessCommand.CREATE);
    workflowCreateReq.getWorkflow().getWorkflowType().setAssignType(EWorkflowTypeAssignType.OFFER);

    final IWorkflowSaveStrategy createWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(workflowCreateReq,
        this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", createWorkflowStrategy);
    Assert.assertEquals("Selected strategy is CreateOfferlAssignWorkflowStrategy!", createWorkflowStrategy.getClass(),
        CreateOfferlAssignWorkflowStrategy.class);

  }

  // ----------------------------------------------------------------------------------------------------------------------------------

  @Test
  public void testSelectArchivingWorkflowValidationStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    request.setCommand(EWorkflowProcessCommand.ARCHIVE);

    final IWorkflowSaveStrategy saveWorkflowStrategy = this.workStrategyFactory.selectValidationWorkStrategy(request,
        this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is ArchivingWorkflowValidationStrategy!", saveWorkflowStrategy.getClass(),
        ArchivingWorkflowValidationStrategy.class);

  }

  @Test
  public void testSelectDoneExistingWorkflowValidationStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();

    request.setCommand(EWorkflowProcessCommand.DONE);
    request.getWorkflow().setWorkflowType(getTestWorkflowType());
    final IWorkflowSaveStrategy saveWorkflowStrategy = this.workStrategyFactory.selectValidationWorkStrategy(request,
        this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is DoneExistingWorkflowValidationStrategy!", saveWorkflowStrategy.getClass(),
        DoneExistingWorkflowValidationStrategy.class);

  }

  @Test
  public void testSelectSaveExistingWorkflowValidationStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();

    request.setCommand(EWorkflowProcessCommand.SAVE);

    final IWorkflowSaveStrategy saveWorkflowStrategy = this.workStrategyFactory.selectValidationWorkStrategy(request,
        this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", saveWorkflowStrategy);
    Assert.assertEquals("Selected strategy is SaveExistingWorkflowValidationStrategy!", saveWorkflowStrategy.getClass(),
        SaveExistingWorkflowValidationStrategy.class);

  }

  @Test(expected = WorkflowCustomizedException.class)
  public void testSelectNoneValidationStrategy() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    request.getWorkflow().setActions(new ArrayList<>());

    this.workStrategyFactory.selectValidationWorkStrategy(request, this.validTocken);

  }

  @Test
  public void testSelectCreateManualAssignWorkflowValidationStrategy() throws Exception {

    final WorkflowSaveRequest workflowCreateReq = this.getTestWorkflowCreateRequest();
    workflowCreateReq.setCommand(EWorkflowProcessCommand.CREATE);
    workflowCreateReq.getWorkflow().getWorkflowType().setAssignType(EWorkflowTypeAssignType.MANUAL);

    final IWorkflowSaveStrategy createWorkflowStrategy = this.workStrategyFactory.selectValidationWorkStrategy(workflowCreateReq,
        this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", createWorkflowStrategy);
    Assert.assertEquals("Selected strategy is CreateManualAssignWorkflowValidationStrategy!", createWorkflowStrategy.getClass(),
        CreateManualAssignWorkflowValidationStrategy.class);

  }

  @Test
  public void testSelectCreateOfferlAssignWorkflowValidationStrategy() throws Exception {

    final WorkflowSaveRequest workflowCreateReq = this.getTestWorkflowCreateRequest();
    workflowCreateReq.setCommand(EWorkflowProcessCommand.CREATE);

    final WorkflowType workflowType = this.getTestWorkflowType("type1", "");
    workflowType.setAssignType(EWorkflowTypeAssignType.OFFER);
    workflowCreateReq.getWorkflow().setWorkflowType(workflowType);
    workflowCreateReq.getWorkflow().setIdentityToNew();

    final IWorkflowSaveStrategy createWorkflowStrategy = this.workStrategyFactory.selectValidationWorkStrategy(workflowCreateReq,
        this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", createWorkflowStrategy);
    Assert.assertEquals("Selected strategy is CreateOfferlAssignWorkflowValidationStrategy!", createWorkflowStrategy.getClass(),
        CreateOfferlAssignWorkflowValidationStrategy.class);

  }
}
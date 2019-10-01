package com.pth.iflow.workflow.services.strategies;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.ICachDataDataService;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.bl.strategies.ICreateWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.IWorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategies.WorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategies.create.CreateManualAssignWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.create.CreateOfferlAssignWorkflowStrategy;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;
import com.pth.iflow.workflow.models.WorkflowType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowCreateStrategyFactoryTest extends TestDataProducer {

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
  public void testSelectCreateManualAssignWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest workflowCreateReq = this.getTestWorkflowCreateRequest();

    final WorkflowType workflowType = this.getTestWorkflowType(1L, "");
    workflowType.setAssignType(EWorkflowTypeAssignType.MANUAL);
    workflowCreateReq.getWorkflow().setWorkflowType(workflowType);

    final ICreateWorkflowStrategy createWorkflowStrategy = this.workStrategyFactory.selectCreateWorkStrategy(workflowCreateReq,
        this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", createWorkflowStrategy);
    Assert.assertEquals("Selected strategy is CreateManualAssignWorkflowStrategy!", createWorkflowStrategy.getClass(),
        CreateManualAssignWorkflowStrategy.class);

  }

  @Test
  public void testSelectCreateOfferlAssignWorkflowStrategy() throws Exception {

    final WorkflowSaveRequest workflowCreateReq = this.getTestWorkflowCreateRequest();

    final WorkflowType workflowType = this.getTestWorkflowType(1L, "");
    workflowType.setAssignType(EWorkflowTypeAssignType.OFFER);
    workflowCreateReq.getWorkflow().setWorkflowType(workflowType);

    final ICreateWorkflowStrategy createWorkflowStrategy = this.workStrategyFactory.selectCreateWorkStrategy(workflowCreateReq,
        this.validTocken);

    Assert.assertNotNull("Result strategy is not null!", createWorkflowStrategy);
    Assert.assertEquals("Selected strategy is CreateOfferlAssignWorkflowStrategy!", createWorkflowStrategy.getClass(),
        CreateOfferlAssignWorkflowStrategy.class);

  }

}

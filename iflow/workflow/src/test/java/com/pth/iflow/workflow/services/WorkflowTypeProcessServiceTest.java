package com.pth.iflow.workflow.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.ITokenValidator;
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.bl.IWorkflowTypeProcessService;
import com.pth.iflow.workflow.bl.impl.WorkflowTypeProcessService;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeProcessServiceTest extends TestDataProducer {

  private IWorkflowTypeProcessService workflowTypeProcessService;

  @Mock
  private IWorkflowTypeDataService workflowTypeDataService;

  @Mock
  private ITokenValidator tokenValidator;

  private String validTocken;

  private String validSession;

  @Before
  public void setUp() throws Exception {

    this.workflowTypeProcessService = new WorkflowTypeProcessService(this.workflowTypeDataService, this.tokenValidator);

    this.validTocken = "validTocken";

    this.validSession = "validSession";

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetById() throws Exception {

    final WorkflowType workflowType = this.getTestTestThreeTaskWorkflowType();

    when(this.workflowTypeDataService.getByIdentity(any(String.class), any(String.class))).thenReturn(workflowType);

    final WorkflowType resWorkflowType = this.workflowTypeProcessService.getByIdentity(workflowType.getIdentity(), this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowType.getIdentity(), workflowType.getIdentity());
    Assert
        .assertEquals("Result workflow-type has title '" + workflowType.getTitle() + "'!",
            resWorkflowType.getTitle(),
            workflowType.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflowType.getStatus(), workflowType.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = this.getTestWorkflowTypeIdSet();
    ;
    final List<WorkflowType> list = this.getTestWorkflowTypeList();

    when(this.workflowTypeDataService.getListByIdentityList(any(Set.class), any(String.class))).thenReturn(list);

    final List<WorkflowType> resList = this.workflowTypeProcessService.getListByIdentityList(idList, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByIdCompanyId() throws Exception {

    final List<WorkflowType> list = this.getTestWorkflowTypeList();

    when(this.workflowTypeDataService.getListByCompanyIdentity(any(String.class), any(String.class))).thenReturn(list);

    final List<WorkflowType> resList = this.workflowTypeProcessService.getListByCompanyIdentity("company1", this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetStepsById() throws Exception {

    final List<WorkflowTypeStep> list = this.getTestWorkflowTypeStepList();

    when(this.workflowTypeDataService.getStepsByIdentity(any(String.class), any(String.class))).thenReturn(list);

    final List<WorkflowTypeStep> resList = this.workflowTypeProcessService.getStepsByIdentity("type1", this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

package com.pth.ifow.workflow.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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

import com.pth.ifow.workflow.TestDataProducer;
import com.pth.ifow.workflow.bl.ITokenValidator;
import com.pth.ifow.workflow.bl.IWorkflowTypeDataService;
import com.pth.ifow.workflow.bl.IWorkflowTypeProcessService;
import com.pth.ifow.workflow.bl.impl.WorkflowTypeProcessService;
import com.pth.ifow.workflow.models.ProfileResponse;
import com.pth.ifow.workflow.models.WorkflowType;
import com.pth.ifow.workflow.models.WorkflowTypeStep;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeProcessServiceTest extends TestDataProducer {

  private IWorkflowTypeProcessService workflowTypeProcessService;

  @Mock
  private IWorkflowTypeDataService    workflowTypeDataService;

  @Mock
  private ITokenValidator             tokenValidator;

  private String                      validTocken;

  private String                      validSession;

  private ProfileResponse             profileResponse;

  @Before
  public void setUp() throws Exception {
    this.workflowTypeProcessService = new WorkflowTypeProcessService(this.workflowTypeDataService, this.tokenValidator);

    this.validTocken = "validTocken";

    this.validSession = "validSession";

    this.profileResponse = new ProfileResponse(this.getTestUser(), this.getTestCompany(), this.validSession);

    when(this.tokenValidator.isTokenValid(this.validTocken)).thenReturn(this.profileResponse);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final WorkflowType workflowType = this.getTestWorkflowType();

    when(this.workflowTypeDataService.getById(any(Long.class))).thenReturn(workflowType);

    final WorkflowType resWorkflowType = this.workflowTypeProcessService.getById(workflowType.getId(), this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowType.getId(), workflowType.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflowType.getTitle() + "'!", resWorkflowType.getTitle(),
        workflowType.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflowType.getStatus(), workflowType.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final List<Long> idList = this.getTestWorkflowTypeIdList();
    final List<WorkflowType> list = this.getTestWorkflowTypeList();

    when(this.workflowTypeDataService.getListByIdList(any(List.class))).thenReturn(list);

    final List<WorkflowType> resList = this.workflowTypeProcessService.getListByIdList(idList, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByIdCompanyId() throws Exception {

    final List<WorkflowType> list = this.getTestWorkflowTypeList();

    when(this.workflowTypeDataService.getListByIdCompanyId(any(Long.class))).thenReturn(list);

    final List<WorkflowType> resList = this.workflowTypeProcessService.getListByIdCompanyId(1L, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetStepsById() throws Exception {

    final List<WorkflowTypeStep> list = this.getTestWorkflowTypeStepList();

    when(this.workflowTypeDataService.getStepsById(any(Long.class))).thenReturn(list);

    final List<WorkflowTypeStep> resList = this.workflowTypeProcessService.getStepsById(1L, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

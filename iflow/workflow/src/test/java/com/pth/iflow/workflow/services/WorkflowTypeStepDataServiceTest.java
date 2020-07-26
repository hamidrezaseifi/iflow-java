package com.pth.iflow.workflow.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.models.edo.WorkflowTypeStepEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeStepListEdo;
import com.pth.iflow.common.rest.IRestTemplateCall;
import com.pth.iflow.workflow.bl.IWorkflowTypeStepDataService;
import com.pth.iflow.workflow.bl.impl.WorkflowTypeStepCoreConnectService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.models.WorkflowTypeStep;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeStepDataServiceTest extends TestDataProducer {

  private IWorkflowTypeStepDataService workflowTypeStepService;

  @MockBean
  private IRestTemplateCall restTemplate;

  @MockBean
  private WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  @Before
  public void setUp() throws Exception {

    this.workflowTypeStepService = new WorkflowTypeStepCoreConnectService(this.restTemplate, this.moduleAccessConfig);

    when(this.moduleAccessConfig.generateCoreUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

    when(this.moduleAccessConfig.generateProfileUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetById() throws Exception {

    final WorkflowTypeStep workflowStepType = this.getTestWorkflowTypeStep();

    final WorkflowTypeStepEdo workflowTypeStepEdo = WorkflowModelEdoMapper.toEdo(workflowStepType);

    when(this.restTemplate
        .callRestGet(any(URI.class), any(EModule.class), any(Class.class), any(String.class), any(boolean.class)))
            .thenReturn(workflowTypeStepEdo);

    final WorkflowTypeStep resWorkflowType = this.workflowTypeStepService
        .getByIdentity(workflowStepType.getIdentity(),
            this.getValidAuthentiocation());

    Assert.assertNotNull("Result workflow-type-step is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type-step has id 1!", resWorkflowType.getIdentity(), workflowStepType.getIdentity());
    Assert
        .assertEquals("Result workflow-type-step has title '" + workflowStepType.getTitle() + "'!", resWorkflowType.getTitle(),
            workflowStepType.getTitle());
    Assert.assertEquals("Result workflow-type-step has status 1!", resWorkflowType.getStatus(), workflowStepType.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = this.getTestWorkflowTypeIdSet();
    final List<WorkflowTypeStep> list = this.getTestWorkflowTypeStepList();
    final WorkflowTypeStepListEdo edoList = new WorkflowTypeStepListEdo(WorkflowModelEdoMapper.toWorkflowTypeStepEdoList(list));

    when(this.restTemplate
        .callRestPost(any(URI.class), any(EModule.class), any(Set.class),
            eq(WorkflowTypeStepListEdo.class), any(String.class), any(boolean.class))).thenReturn(edoList);

    final List<WorkflowTypeStep> resList = this.workflowTypeStepService.getListByIdentityList(idList, this.getValidAuthentiocation());

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByWorkflowTypeId() throws Exception {

    final List<WorkflowTypeStep> list = this.getTestWorkflowTypeStepList();
    final WorkflowTypeStepListEdo edoList = new WorkflowTypeStepListEdo(WorkflowModelEdoMapper.toWorkflowTypeStepEdoList(list));

    when(this.restTemplate
        .callRestGet(any(URI.class), any(EModule.class), eq(WorkflowTypeStepListEdo.class), any(String.class),
            any(boolean.class))).thenReturn(edoList);

    final List<
        WorkflowTypeStep> resList = this.workflowTypeStepService.getListByWorkflowIdentity("identity", this.getValidAuthentiocation());

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

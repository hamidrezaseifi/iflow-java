package com.pth.ifow.workflow.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.ifow.workflow.TestDataProducer;
import com.pth.ifow.workflow.bl.IWorkflowTypeStepDataService;
import com.pth.ifow.workflow.bl.impl.WorkflowTypeStepCoreConnectService;
import com.pth.ifow.workflow.config.WorkflowConfiguration;
import com.pth.ifow.workflow.models.WorkflowTypeStep;

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

    when(this.moduleAccessConfig.generateCoreUrl(any(String.class))).thenReturn(new URL("http://any-string"));

    when(this.moduleAccessConfig.generateProfileUrl(any(String.class))).thenReturn(new URL("http://any-string"));
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final WorkflowTypeStep workflowStepType = getTestWorkflowTypeStep();

    final WorkflowTypeStepEdo workflowTypeStepEdo = workflowStepType.toEdo();

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), any(Class.class), any(boolean.class), any()))
        .thenReturn(workflowTypeStepEdo);

    final WorkflowTypeStep resWorkflowType = this.workflowTypeStepService.getById(workflowStepType.getId());

    Assert.assertNotNull("Result workflow-type-step is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type-step has id 1!", resWorkflowType.getId(), workflowStepType.getId());
    Assert.assertEquals("Result workflow-type-step has title '" + workflowStepType.getTitle() + "'!", resWorkflowType.getTitle(),
        workflowStepType.getTitle());
    Assert.assertEquals("Result workflow-type-step has status 1!", resWorkflowType.getStatus(), workflowStepType.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final List<Long> idList = getTestWorkflowTypeIdList();
    final List<WorkflowTypeStep> list = getTestWorkflowTypeStepList();
    final List<WorkflowTypeStepEdo> edoList = ModelMapperBase.toEdoList(list);

    when(this.restTemplate.callRestPost(any(String.class), any(EModule.class), any(List.class), any(ParameterizedTypeReference.class),
        any(boolean.class))).thenReturn(edoList);

    final List<WorkflowTypeStep> resList = this.workflowTypeStepService.getListByIdList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByWorkflowTypeId() throws Exception {

    final List<WorkflowTypeStep> list = getTestWorkflowTypeStepList();
    final List<WorkflowTypeStepEdo> edoList = ModelMapperBase.toEdoList(list);

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), any(ParameterizedTypeReference.class),
        any(boolean.class), any())).thenReturn(edoList);

    final List<WorkflowTypeStep> resList = this.workflowTypeStepService.getListByWorkflowId(1L);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

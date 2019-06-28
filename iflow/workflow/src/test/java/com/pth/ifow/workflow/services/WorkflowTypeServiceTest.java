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
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.edo.models.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeStepEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.enums.EModule;
import com.pth.ifow.workflow.TestDataProducer;
import com.pth.ifow.workflow.bl.IWorkflowTypeService;
import com.pth.ifow.workflow.bl.impl.WorkflowTypeService;
import com.pth.ifow.workflow.config.WorkflowConfiguration;
import com.pth.ifow.workflow.models.WorkflowType;
import com.pth.ifow.workflow.models.WorkflowTypeStep;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeServiceTest extends TestDataProducer {

  private IWorkflowTypeService workflowTypeService;

  @Mock
  private IRestTemplateCall restTemplate;

  @MockBean
  private WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  @Before
  public void setUp() throws Exception {
    this.workflowTypeService = new WorkflowTypeService(this.restTemplate, this.moduleAccessConfig);

    when(moduleAccessConfig.generateCoreUrl(any(String.class))).thenReturn(new URL("http://any-string"));

    when(moduleAccessConfig.generateProfileUrl(any(String.class))).thenReturn(new URL("http://any-string"));
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final WorkflowType workflowType = getTestWorkflowType();
    final WorkflowTypeEdo workflowTypeEdo = workflowType.toEdo();

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), any(Class.class), any(boolean.class), any()))
        .thenReturn(workflowTypeEdo);

    final WorkflowType resWorkflowType = this.workflowTypeService.getById(workflowType.getId());

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowType.getId(), workflowType.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflowType.getTitle() + "'!", resWorkflowType.getTitle(),
        workflowType.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflowType.getStatus(), workflowType.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final List<Long> idList = getTestWorkflowTypeIdList();
    final List<WorkflowType> list = getTestWorkflowTypeList();
    final List<WorkflowTypeEdo> edoList = ModelMapperBase.toEdoList(list);

    when(this.restTemplate.callRestPost(any(String.class), any(EModule.class), any(List.class), any(ParameterizedTypeReference.class),
        any(boolean.class))).thenReturn(edoList);

    final List<WorkflowType> resList = this.workflowTypeService.getListByIdList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByIdCompanyId() throws Exception {

    final List<WorkflowType> list = getTestWorkflowTypeList();
    final List<WorkflowTypeEdo> edoList = ModelMapperBase.toEdoList(list);

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), any(ParameterizedTypeReference.class),
        any(boolean.class), any())).thenReturn(edoList);

    final List<WorkflowType> resList = this.workflowTypeService.getListByIdCompanyId(1L);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetStepsById() throws Exception {

    final List<WorkflowTypeStep> list = getTestWorkflowTypeStepList();
    final List<WorkflowTypeStepEdo> edoList = ModelMapperBase.toEdoList(list);

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), any(ParameterizedTypeReference.class),
        any(boolean.class), any())).thenReturn(edoList);

    final List<WorkflowTypeStep> resList = this.workflowTypeService.getStepsById(1L);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

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

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.ifow.workflow.TestDataProducer;
import com.pth.ifow.workflow.bl.IWorkflowDataService;
import com.pth.ifow.workflow.bl.impl.WorkflowCoreConnectService;
import com.pth.ifow.workflow.config.WorkflowConfiguration;
import com.pth.ifow.workflow.models.Workflow;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowDataServiceTest extends TestDataProducer {

  private IWorkflowDataService                     workflowDataService;

  @Mock
  private IRestTemplateCall                        restTemplate;

  @MockBean
  private WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  @Before
  public void setUp() throws Exception {
    this.workflowDataService = new WorkflowCoreConnectService(this.restTemplate, this.moduleAccessConfig);

    when(this.moduleAccessConfig.generateCoreUrl(any(String.class))).thenReturn(new URL("http://any-string"));

    when(this.moduleAccessConfig.generateProfileUrl(any(String.class))).thenReturn(new URL("http://any-string"));
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final Workflow workflow = getTestWorkflow(1L);
    final WorkflowEdo workflowEdo = workflow.toEdo();

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), any(Class.class), any(boolean.class), any()))
        .thenReturn(workflowEdo);

    final Workflow resWorkflow = this.workflowDataService.getById(workflow.getId());

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testSaveWorkflow() throws Exception {

    final Workflow workflow = getTestWorkflow(1L);
    final WorkflowEdo workflowEdo = workflow.toEdo();

    when(this.restTemplate.callRestPost(any(String.class), any(EModule.class), any(WorkflowEdo.class), any(Class.class),
        any(boolean.class))).thenReturn(workflowEdo);

    final Workflow resWorkflow = this.workflowDataService.save(workflow);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final List<Long> idList = getTestWorkflowIdList();
    final List<Workflow> list = getTestWorkflowList();
    final List<WorkflowEdo> edoList = ModelMapperBase.toEdoList(list);

    when(this.restTemplate.callRestPost(any(String.class), any(EModule.class), any(List.class), any(ParameterizedTypeReference.class),
        any(boolean.class))).thenReturn(edoList);

    final List<Workflow> resList = this.workflowDataService.getListByIdList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByTypeId() throws Exception {

    final List<Workflow> list = getTestWorkflowList();
    final List<WorkflowEdo> edoList = ModelMapperBase.toEdoList(list);

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), any(ParameterizedTypeReference.class),
        any(boolean.class), any())).thenReturn(edoList);

    final List<Workflow> resList = this.workflowDataService.getListByTypeId(1L);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

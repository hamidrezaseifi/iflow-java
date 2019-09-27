package com.pth.iflow.workflow.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.net.URI;
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
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.WorkflowListEdo;
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.impl.WorkflowCoreConnectService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowDataServiceTest extends TestDataProducer {

  private IWorkflowDataService                     workflowDataService;

  @Mock
  private IRestTemplateCall                        restTemplate;

  @MockBean
  private WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  private String                                   validTocken;

  @Before
  public void setUp() throws Exception {
    this.workflowDataService = new WorkflowCoreConnectService(this.restTemplate, this.moduleAccessConfig);

    when(this.moduleAccessConfig.generateCoreUrl(any(String.class))).thenReturn(new URI("http://any-string"));

    when(this.moduleAccessConfig.generateProfileUrl(any(String.class))).thenReturn(new URI("http://any-string"));

    this.validTocken = "validTocken";
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final Workflow workflow = this.getTestWorkflow(1L);
    final WorkflowEdo workflowEdo = WorkflowModelEdoMapper.toEdo(workflow);

    when(this.restTemplate.callRestGet(any(URI.class), any(String.class), any(EModule.class), any(Class.class), any(boolean.class),
        any())).thenReturn(workflowEdo);

    final Workflow resWorkflow = this.workflowDataService.getById(workflow.getId(), this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testSaveWorkflow() throws Exception {

    final Workflow workflow = this.getTestWorkflow(1L);
    final WorkflowEdo workflowEdo = WorkflowModelEdoMapper.toEdo(workflow);

    when(this.restTemplate.callRestPost(any(URI.class), any(String.class), any(EModule.class), any(WorkflowEdo.class),
        any(Class.class), any(boolean.class))).thenReturn(workflowEdo);

    final Workflow resWorkflow = this.workflowDataService.save(workflow, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testSearchWorkflow() throws Exception {

    final WorkflowSearchFilter filter = this.getTestWorkflowSearchFilter();
    final List<Workflow> list = this.getTestWorkflowList();
    final WorkflowListEdo edoList = new WorkflowListEdo(WorkflowModelEdoMapper.toWorkflowEdoList(list));

    when(this.restTemplate.callRestPost(any(URI.class), any(String.class), any(EModule.class), any(WorkflowSearchFilterEdo.class),
        eq(WorkflowListEdo.class), any(boolean.class))).thenReturn(edoList);

    final List<Workflow> resWorkflowList = this.workflowDataService.search(filter, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowList);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowList.size(), list.size());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final List<Long> idList = this.getTestWorkflowIdList();
    final List<Workflow> list = this.getTestWorkflowList();
    final WorkflowListEdo edoList = new WorkflowListEdo(WorkflowModelEdoMapper.toWorkflowEdoList(list));

    when(this.restTemplate.callRestPost(any(URI.class), any(String.class), any(EModule.class), any(List.class),
        eq(WorkflowListEdo.class), any(boolean.class))).thenReturn(edoList);

    final List<Workflow> resList = this.workflowDataService.getListByIdList(idList, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByTypeId() throws Exception {

    final List<Workflow> list = this.getTestWorkflowList();
    final WorkflowListEdo edoList = new WorkflowListEdo(WorkflowModelEdoMapper.toWorkflowEdoList(list));

    when(this.restTemplate.callRestGet(any(URI.class), any(String.class), any(EModule.class), eq(WorkflowListEdo.class),
        any(boolean.class), any())).thenReturn(edoList);

    final List<Workflow> resList = this.workflowDataService.getListByTypeId(1L, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

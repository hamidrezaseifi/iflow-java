package com.pth.iflow.workflow.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
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
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.edo.models.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeListEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeStepListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.bl.impl.WorkflowTypeCoreConnectService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeDataServiceTest extends TestDataProducer {

  private IWorkflowTypeDataService                 workflowTypeService;

  @Mock
  private IRestTemplateCall                        restTemplate;

  @MockBean
  private WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  private String                                   validTocken;

  @Before
  public void setUp() throws Exception {
    this.workflowTypeService = new WorkflowTypeCoreConnectService(this.restTemplate, this.moduleAccessConfig);

    when(this.moduleAccessConfig.generateCoreUrl(any(String.class))).thenReturn(new URL("http://any-string"));

    when(this.moduleAccessConfig.generateProfileUrl(any(String.class))).thenReturn(new URL("http://any-string"));

    this.validTocken = "validTocken";
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final WorkflowType workflowType = this.getTestWorkflowType();
    final WorkflowTypeEdo workflowTypeEdo = WorkflowModelEdoMapper.toEdo(workflowType);

    when(this.restTemplate.callRestGet(any(URL.class), any(String.class), any(EModule.class), any(Class.class), any(boolean.class),
        any())).thenReturn(workflowTypeEdo);

    final WorkflowType resWorkflowType = this.workflowTypeService.getById(workflowType.getId(), this.validTocken);

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
    final WorkflowTypeListEdo edoList = new WorkflowTypeListEdo(WorkflowModelEdoMapper.toWorkflowTypeEdoList(list));

    when(this.restTemplate.callRestPost(any(URL.class), any(String.class), any(EModule.class), any(List.class),
        eq(WorkflowTypeListEdo.class), any(boolean.class))).thenReturn(edoList);

    final List<WorkflowType> resList = this.workflowTypeService.getListByIdList(idList, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByIdCompanyId() throws Exception {

    final List<WorkflowType> list = this.getTestWorkflowTypeList();
    final WorkflowTypeListEdo edoList = new WorkflowTypeListEdo(WorkflowModelEdoMapper.toWorkflowTypeEdoList(list));

    when(this.restTemplate.callRestGet(any(URL.class), any(String.class), any(EModule.class), eq(WorkflowTypeListEdo.class),
        any(boolean.class), any())).thenReturn(edoList);

    final List<WorkflowType> resList = this.workflowTypeService.getListByIdCompanyId(1L, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetStepsById() throws Exception {

    final List<WorkflowTypeStep> list = this.getTestWorkflowTypeStepList();
    final WorkflowTypeStepListEdo edoList = new WorkflowTypeStepListEdo(WorkflowModelEdoMapper.toWorkflowTypeStepEdoList(list));

    when(this.restTemplate.callRestGet(any(URL.class), any(String.class), any(EModule.class), eq(WorkflowTypeStepListEdo.class),
        any(boolean.class), any())).thenReturn(edoList);

    final List<WorkflowTypeStep> resList = this.workflowTypeService.getStepsById(1L, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

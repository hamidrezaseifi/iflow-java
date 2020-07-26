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
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.models.edo.WorkflowTypeEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeListEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeStepListEdo;
import com.pth.iflow.common.rest.IRestTemplateCall;
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.bl.impl.WorkflowTypeCoreConnectService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeDataServiceTest extends TestDataProducer {

  private IWorkflowTypeDataService workflowTypeService;

  @Mock
  private IRestTemplateCall restTemplate;

  @MockBean
  private WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  @Before
  public void setUp() throws Exception {

    this.workflowTypeService = new WorkflowTypeCoreConnectService(this.restTemplate, this.moduleAccessConfig);

    when(this.moduleAccessConfig.generateCoreUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

    when(this.moduleAccessConfig.generateProfileUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetById() throws Exception {

    final WorkflowType workflowType = this.getTestTestThreeTaskWorkflowType();
    final WorkflowTypeEdo workflowTypeEdo = WorkflowModelEdoMapper.toEdo(workflowType);

    when(this.restTemplate
        .callRestGet(any(URI.class),
            any(EModule.class),
            any(Class.class),
            any(String.class),
            any(boolean.class))).thenReturn(workflowTypeEdo);

    final WorkflowType resWorkflowType = this.workflowTypeService.getByIdentity(workflowType.getIdentity(), this.getValidAuthentiocation());

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
    final WorkflowTypeListEdo edoList = new WorkflowTypeListEdo(WorkflowModelEdoMapper.toWorkflowTypeEdoList(list));

    when(this.restTemplate
        .callRestPost(any(URI.class),
            any(EModule.class),
            any(Set.class),
            eq(WorkflowTypeListEdo.class),
            any(String.class),
            any(boolean.class))).thenReturn(edoList);

    final List<WorkflowType> resList = this.workflowTypeService.getListByIdentityList(idList, this.getValidAuthentiocation());

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByIdCompanyId() throws Exception {

    final List<WorkflowType> list = this.getTestWorkflowTypeList();
    final WorkflowTypeListEdo edoList = new WorkflowTypeListEdo(WorkflowModelEdoMapper.toWorkflowTypeEdoList(list));

    when(this.restTemplate
        .callRestGet(any(URI.class),
            any(EModule.class),
            eq(WorkflowTypeListEdo.class),
            any(String.class),
            any(boolean.class))).thenReturn(edoList);

    final List<WorkflowType> resList = this.workflowTypeService.getListByCompanyIdentity("company1", this.getValidAuthentiocation());

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetStepsById() throws Exception {

    final List<WorkflowTypeStep> list = this.getTestWorkflowTypeStepList();
    final WorkflowTypeStepListEdo edoList = new WorkflowTypeStepListEdo(WorkflowModelEdoMapper.toWorkflowTypeStepEdoList(list));

    when(this.restTemplate
        .callRestGet(any(URI.class),
            any(EModule.class),
            eq(WorkflowTypeStepListEdo.class),
            any(String.class),
            any(boolean.class))).thenReturn(edoList);

    final List<WorkflowTypeStep> resList = this.workflowTypeService.getStepsByIdentity("type1", this.getValidAuthentiocation());

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

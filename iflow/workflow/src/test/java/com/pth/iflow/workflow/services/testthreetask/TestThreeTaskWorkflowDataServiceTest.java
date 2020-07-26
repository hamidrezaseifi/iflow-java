package com.pth.iflow.workflow.services.testthreetask;

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
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowEdo;
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowListEdo;
import com.pth.iflow.common.rest.IRestTemplateCall;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.impl.workflowservice.testthreetask.TestThreeTaskWorkflowCoreConnectService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.workflow.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestThreeTaskWorkflowDataServiceTest extends TestDataProducer {

  private IWorkflowDataService<TestThreeTaskWorkflow> workflowDataService;

  @Mock
  private IRestTemplateCall restTemplate;

  @MockBean
  private WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  @Before
  public void setUp() throws Exception {

    this.workflowDataService = new TestThreeTaskWorkflowCoreConnectService(this.restTemplate, this.moduleAccessConfig);

    when(this.moduleAccessConfig.generateCoreUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

    when(this.moduleAccessConfig.generateProfileUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetById() throws Exception {

    final TestThreeTaskWorkflow workflow = this.getTestTestThreeTaskWorkflow("workflow1");
    final TestThreeTaskWorkflowEdo workflowEdo = WorkflowModelEdoMapper.toEdo(workflow);

    when(this.restTemplate
        .callRestGet(any(URI.class), any(EModule.class), any(Class.class), any(String.class), any(boolean.class))).thenReturn(workflowEdo);

    final TestThreeTaskWorkflow resWorkflow = this.workflowDataService
        .getByIdentity(workflow.getIdentity(), this.getValidAuthentiocation());

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testSaveWorkflow() throws Exception {

    final TestThreeTaskWorkflow workflow = this.getTestTestThreeTaskWorkflow("workflow1");
    final TestThreeTaskWorkflowEdo workflowEdo = WorkflowModelEdoMapper.toEdo(workflow);

    when(this.restTemplate
        .callRestPost(any(URI.class), any(EModule.class), any(TestThreeTaskWorkflowEdo.class),
            any(Class.class), any(String.class), any(boolean.class))).thenReturn(workflowEdo);

    final TestThreeTaskWorkflow resWorkflow = this.workflowDataService.save(workflow, this.getValidAuthentiocation());

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = this.getTestWorkflowIdSet();
    final List<TestThreeTaskWorkflow> list = this.getTestTestThreeTaskWorkflowList();
    final TestThreeTaskWorkflowListEdo edoList = new TestThreeTaskWorkflowListEdo(
        WorkflowModelEdoMapper.toTestThreeTaskWorkflowEdoList(list));

    when(this.restTemplate
        .callRestPost(any(URI.class), any(EModule.class), any(Set.class),
            eq(TestThreeTaskWorkflowListEdo.class), any(String.class), any(boolean.class))).thenReturn(edoList);

    final List<TestThreeTaskWorkflow> resList = this.workflowDataService.getListByIdentityList(idList, this.getValidAuthentiocation());

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

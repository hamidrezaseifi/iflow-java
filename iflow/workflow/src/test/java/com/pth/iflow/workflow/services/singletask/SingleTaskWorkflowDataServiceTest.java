package com.pth.iflow.workflow.services.singletask;

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
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.impl.workflowservice.singletask.SingleTaskWorkflowCoreConnectService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.workflow.services.IRestTemplateCall;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SingleTaskWorkflowDataServiceTest extends TestDataProducer {

  private IWorkflowDataService<SingleTaskWorkflow> workflowDataService;

  @Mock
  private IRestTemplateCall restTemplate;

  @MockBean
  private WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  private String validTocken;

  @Before
  public void setUp() throws Exception {
    this.workflowDataService = new SingleTaskWorkflowCoreConnectService(this.restTemplate, this.moduleAccessConfig);

    when(this.moduleAccessConfig.generateCoreUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

    when(this.moduleAccessConfig.generateProfileUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

    this.validTocken = "validTocken";
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final SingleTaskWorkflow workflow = this.getTestSingleTaskWorkflow("workflow1");
    final SingleTaskWorkflowEdo workflowEdo = WorkflowModelEdoMapper.toEdo(workflow);

    when(this.restTemplate.callRestGet(any(URI.class),
                                       any(String.class),
                                       any(EModule.class),
                                       any(Class.class),
                                       any(boolean.class),
                                       any())).thenReturn(workflowEdo);

    final SingleTaskWorkflow resWorkflow = this.workflowDataService.getByIdentity(workflow.getIdentity(), this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testSaveWorkflow() throws Exception {

    final SingleTaskWorkflow workflow = this.getTestSingleTaskWorkflow("workflow1");
    final SingleTaskWorkflowEdo workflowEdo = WorkflowModelEdoMapper.toEdo(workflow);

    when(this.restTemplate.callRestPost(any(URI.class),
                                        any(String.class),
                                        any(EModule.class),
                                        any(SingleTaskWorkflowEdo.class),
                                        any(Class.class),
                                        any(boolean.class))).thenReturn(workflowEdo);

    final SingleTaskWorkflow resWorkflow = this.workflowDataService.save(workflow, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testSearchWorkflow() throws Exception {

    final WorkflowSearchFilter filter = this.getTestWorkflowSearchFilter();
    final List<SingleTaskWorkflow> list = this.getTestSingleTaskWorkflowList();
    final SingleTaskWorkflowListEdo edoList = new SingleTaskWorkflowListEdo(WorkflowModelEdoMapper.toSingleTaskWorkflowEdoList(list));

    when(this.restTemplate.callRestPost(any(URI.class),
                                        any(String.class),
                                        any(EModule.class),
                                        any(WorkflowSearchFilterEdo.class),
                                        eq(SingleTaskWorkflowListEdo.class),
                                        any(boolean.class))).thenReturn(edoList);

    final List<SingleTaskWorkflow> resWorkflowList = this.workflowDataService.search(filter, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowList);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowList.size(), list.size());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = this.getTestWorkflowIdSet();
    final List<SingleTaskWorkflow> list = this.getTestSingleTaskWorkflowList();
    final SingleTaskWorkflowListEdo edoList = new SingleTaskWorkflowListEdo(WorkflowModelEdoMapper.toSingleTaskWorkflowEdoList(list));

    when(this.restTemplate.callRestPost(any(URI.class),
                                        any(String.class),
                                        any(EModule.class),
                                        any(Set.class),
                                        eq(SingleTaskWorkflowListEdo.class),
                                        any(boolean.class))).thenReturn(edoList);

    final List<SingleTaskWorkflow> resList = this.workflowDataService.getListByIdentityList(idList, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}

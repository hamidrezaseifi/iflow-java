package com.pth.iflow.gui.services.singletask;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowListEdo;
import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowSaveRequestEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.gui.TestDataProducer;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflowSaveRequest;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IWorkflowAccess;
import com.pth.iflow.gui.services.impl.workflow.singletask.SingleTaskWorkflowAccess;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SingleTaskWorkflowAccessTest extends TestDataProducer {

  private IWorkflowAccess<SingleTaskWorkflow, SingleTaskWorkflowSaveRequest> workflowAccess;

  @MockBean
  private IRestTemplateCall                                                  restTemplate;

  @MockBean
  private GuiConfiguration.WorkflowModuleAccessConfig                        workflowModuleAccessConfig;

  @MockBean
  private GuiConfiguration.ProfileModuleAccessConfig                         profileModuleAccessConfig;

  private URI                                                                testUri;

  private final String                                                       testToken = "test-token";

  @Before
  public void setUp() throws Exception {

    this.testUri = new URI("test-uri");

    when(this.profileModuleAccessConfig.getAuthenticationUri()).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getCreateSingleTaskWorkflowUri()).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadAuthenticationInfoUri()).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadCompanyUserListUri(any(String.class))).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadTokenInfoUri()).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getReadWorkflowTypeListUri(any(String.class))).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getReadSingleTaskWorkflowUri(any(String.class))).thenReturn(this.testUri);

    this.workflowAccess = new SingleTaskWorkflowAccess(this.restTemplate, this.workflowModuleAccessConfig);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflow() throws Exception {

    final SingleTaskWorkflow workflow = this.getTestSingleTaskWorkflow("identity1");

    when(this.restTemplate.callRestGet(any(URI.class), any(EModule.class), eq(SingleTaskWorkflowEdo.class), any(String.class),
        any(boolean.class))).thenReturn(GuiModelEdoMapper.toEdo(workflow));

    final SingleTaskWorkflow resWorkflow = this.workflowAccess.readWorkflow(workflow.getIdentity(), this.testToken);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final SingleTaskWorkflowSaveRequest createRequest = this.getTestSingleTaskWorkflowSaveRequest();

    final List<SingleTaskWorkflow> workflowList = this.getTestSingleTaskWorkflowList();

    when(this.restTemplate.callRestPost(any(URI.class), any(EModule.class), any(SingleTaskWorkflowSaveRequestEdo.class),
        eq(SingleTaskWorkflowListEdo.class), any(String.class), any(boolean.class)))
            .thenReturn(new SingleTaskWorkflowListEdo(GuiModelEdoMapper.toSingleTaskWorkflowEdoList(workflowList)));

    final List<SingleTaskWorkflow> resWorkflowList = this.workflowAccess.createWorkflow(createRequest, this.testToken);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

  @Test
  @Ignore
  public void testSaveWorkflow() throws Exception {
    final SingleTaskWorkflow workflow = this.getTestSingleTaskWorkflow("identity1");

    final SingleTaskWorkflowSaveRequest request = this.getTestSingleTaskWorkflowSaveRequest(workflow);

    when(this.restTemplate.callRestPost(any(URI.class), any(EModule.class), any(SingleTaskWorkflowEdo.class),
        eq(SingleTaskWorkflowEdo.class), any(String.class), any(boolean.class))).thenReturn(GuiModelEdoMapper.toEdo(workflow));

    final SingleTaskWorkflow resWorkflow = this.workflowAccess.saveWorkflow(request, this.testToken);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

}

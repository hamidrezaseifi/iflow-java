package com.pth.iflow.gui.services.testthree;

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

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowEdo;
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowListEdo;
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowSaveRequestEdo;
import com.pth.iflow.gui.TestDataProducer;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflowSaveRequest;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IWorkflowAccess;
import com.pth.iflow.gui.services.impl.workflow.testthree.TestThreeTaskWorkflowAccess;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestThreeTaskWorkflowAccessTest extends TestDataProducer {

  private IWorkflowAccess<TestThreeTaskWorkflow, TestThreeTaskWorkflowSaveRequest> workflowAccess;

  @MockBean
  private IRestTemplateCall                                                        restTemplate;

  @MockBean
  private GuiConfiguration.WorkflowModuleAccessConfig                              workflowModuleAccessConfig;

  @MockBean
  private GuiConfiguration.ProfileModuleAccessConfig                               profileModuleAccessConfig;

  private URI                                                                      testUri;

  private final String                                                             testToken = "test-token";

  @Before
  public void setUp() throws Exception {

    this.testUri = new URI("test-uri");

    when(this.profileModuleAccessConfig.getAuthenticationUri()).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getCreateTestThreeTaskWorkflowUri()).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadAuthenticationInfoUri()).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadCompanyUserListUri(any(String.class))).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadTokenInfoUri()).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getReadWorkflowTypeListUri(any(String.class))).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getReadTestThreeTaskWorkflowUri(any(String.class))).thenReturn(this.testUri);

    this.workflowAccess = new TestThreeTaskWorkflowAccess(this.restTemplate, this.workflowModuleAccessConfig);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflow() throws Exception {

    final TestThreeTaskWorkflow workflow = this.getTestTestThreeTaskWorkflow("identity1");

    when(this.restTemplate.callRestGet(any(URI.class), any(EModule.class), eq(TestThreeTaskWorkflowEdo.class), any(String.class),
        any(boolean.class))).thenReturn(GuiModelEdoMapper.toEdo(workflow));

    final TestThreeTaskWorkflow resWorkflow = this.workflowAccess.readWorkflow(workflow.getIdentity(), this.testToken);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final TestThreeTaskWorkflowSaveRequest createRequest = this.getTestTestThreeTaskWorkflowSaveRequest();

    final List<TestThreeTaskWorkflow> workflowList = this.getTestTestThreeTaskWorkflowList();

    when(this.restTemplate.callRestPost(any(URI.class), any(EModule.class), any(TestThreeTaskWorkflowSaveRequestEdo.class),
        eq(TestThreeTaskWorkflowListEdo.class), any(String.class), any(boolean.class)))
            .thenReturn(new TestThreeTaskWorkflowListEdo(GuiModelEdoMapper.toTestThreeTaskWorkflowEdoList(workflowList)));

    final List<TestThreeTaskWorkflow> resWorkflowList = this.workflowAccess.createWorkflow(createRequest, this.testToken);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

  @Test
  @Ignore
  public void testSaveWorkflow() throws Exception {
    final TestThreeTaskWorkflow workflow = this.getTestTestThreeTaskWorkflow("identity1");

    final TestThreeTaskWorkflowSaveRequest request = this.getTestTestThreeTaskWorkflowSaveRequest(workflow);

    when(this.restTemplate.callRestPost(any(URI.class), any(EModule.class), any(TestThreeTaskWorkflowEdo.class),
        eq(TestThreeTaskWorkflowEdo.class), any(String.class), any(boolean.class))).thenReturn(GuiModelEdoMapper.toEdo(workflow));

    final TestThreeTaskWorkflow resWorkflow = this.workflowAccess.saveWorkflow(request, this.testToken);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

}

package com.pth.iflow.gui.services;

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

import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.WorkflowListEdo;
import com.pth.iflow.common.edo.models.WorkflowSaveRequestEdo;
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.gui.TestDataProducer;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.models.Workflow;
import com.pth.iflow.gui.models.WorkflowSaveRequest;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.services.impl.WorkflowAccess;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowAccessTest extends TestDataProducer {

  private IWorkflowAccess                             workflowAccess;

  @MockBean
  private IRestTemplateCall                           restTemplate;

  @MockBean
  private GuiConfiguration.WorkflowModuleAccessConfig workflowModuleAccessConfig;

  @MockBean
  private GuiConfiguration.ProfileModuleAccessConfig  profileModuleAccessConfig;

  private URI                                         testUri;

  private final String                                testToken = "test-token";

  @Before
  public void setUp() throws Exception {

    this.testUri = new URI("test-uri");

    when(this.profileModuleAccessConfig.getAuthenticationUri()).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getCreateWorkflowUri()).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadAuthenticationInfoUri()).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadCompanyUserListUri(any(String.class))).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadTokenInfoUri()).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getReadWorkflowTypeListUri(any(String.class))).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getReadWorkflowUri(any(String.class))).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getSearchWorkflowUri()).thenReturn(this.testUri);

    this.workflowAccess = new WorkflowAccess(this.restTemplate, this.workflowModuleAccessConfig);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflow() throws Exception {

    final Workflow workflow = this.getTestGuiWorkflow(1L);

    when(this.restTemplate.callRestGet(any(URI.class), any(EModule.class), eq(WorkflowEdo.class), any(String.class),
        any(boolean.class))).thenReturn(GuiModelEdoMapper.toEdo(workflow));

    final Workflow resWorkflow = this.workflowAccess.readWorkflow(workflow.getIdentity(), this.testToken);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final WorkflowSaveRequest createRequest = this.getTestGuiWorkflowSaveRequest();

    final List<Workflow> workflowList = this.getTestGuiWorkflowList();

    when(this.restTemplate.callRestPost(any(URI.class), any(EModule.class), any(WorkflowSaveRequestEdo.class),
        eq(WorkflowListEdo.class), any(String.class), any(boolean.class)))
            .thenReturn(new WorkflowListEdo(GuiModelEdoMapper.toWorkflowEdoList(workflowList)));

    final List<Workflow> resWorkflowList = this.workflowAccess.createWorkflow(createRequest, this.testToken);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

  @Test
  @Ignore
  public void testSaveWorkflow() throws Exception {
    final Workflow workflow = this.getTestGuiWorkflow(1L);

    final WorkflowSaveRequest request = this.getTestGuiWorkflowSaveRequest(workflow);

    when(this.restTemplate.callRestPost(any(URI.class), any(EModule.class), any(WorkflowEdo.class), eq(WorkflowEdo.class),
        any(String.class), any(boolean.class))).thenReturn(GuiModelEdoMapper.toEdo(workflow));

    final Workflow resWorkflow = this.workflowAccess.saveWorkflow(request, this.testToken);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testReadWorkflowTypeList() throws Exception {

    final List<WorkflowType> workflowTypeList = this.getTestGuiWorkflowTypeList();

    final WorkflowTypeListEdo typeListEdo = new WorkflowTypeListEdo(GuiModelEdoMapper.toWorkflowTypeEdoList(workflowTypeList));

    when(this.restTemplate.callRestGet(any(URI.class), any(EModule.class), eq(WorkflowTypeListEdo.class), any(String.class),
        any(boolean.class))).thenReturn(typeListEdo);

    final List<WorkflowType> resWorkflowList = this.workflowAccess.readWorkflowTypeList("test-company", this.testToken);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowTypeList.size());

  }

  @Test
  public void testSearchWorkflow() throws Exception {
    final WorkflowSearchFilter searchFilter = this.getTestGuiWorkflowSearchFilter();

    final List<Workflow> workflowList = this.getTestGuiWorkflowList();

    when(this.restTemplate.callRestPost(any(URI.class), any(EModule.class), any(WorkflowSearchFilterEdo.class),
        eq(WorkflowListEdo.class), any(String.class), any(boolean.class)))
            .thenReturn(new WorkflowListEdo(GuiModelEdoMapper.toWorkflowEdoList(workflowList)));

    final List<Workflow> resWorkflowList = this.workflowAccess.searchWorkflow(searchFilter, this.testToken);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

}

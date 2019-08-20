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

import com.pth.iflow.common.edo.models.xml.WorkflowCreateRequestEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowListEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.gui.TestDataProducer;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowCreateRequest;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.services.impl.WorkflowAccess;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowAccessTest extends TestDataProducer {

  private IWorkflowAccess workflowAccess;

  @MockBean
  private IRestTemplateCall restTemplate;

  @MockBean
  private GuiConfiguration.ModuleAccessConfig moduleAccessConfig;

  private URI testUri;

  private final String testToken = "test-token";

  @Before
  public void setUp() throws Exception {

    this.testUri = new URI("test-uri");

    when(this.moduleAccessConfig.getAuthenticationUri()).thenReturn(this.testUri);
    when(this.moduleAccessConfig.getCreateWorkflowUri()).thenReturn(this.testUri);
    when(this.moduleAccessConfig.getReadAuthenticationInfoUri()).thenReturn(this.testUri);
    when(this.moduleAccessConfig.getReadCompanyUserListUri(any(Long.class))).thenReturn(this.testUri);
    when(this.moduleAccessConfig.getReadTokenInfoUri()).thenReturn(this.testUri);
    when(this.moduleAccessConfig.getReadWorkflowTypeListUri(any(Long.class))).thenReturn(this.testUri);
    when(this.moduleAccessConfig.getReadWorkflowUri(any(Long.class))).thenReturn(this.testUri);
    when(this.moduleAccessConfig.getSearchWorkflowUri()).thenReturn(this.testUri);

    this.workflowAccess = new WorkflowAccess(this.restTemplate, this.moduleAccessConfig);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflow() throws Exception {

    final GuiWorkflow workflow = this.getTestGuiWorkflow(1L);

    when(this.restTemplate.callRestGet(any(URI.class),
                                       any(EModule.class),
                                       eq(WorkflowEdo.class),
                                       any(String.class),
                                       any(boolean.class))).thenReturn(workflow.toEdo());

    final GuiWorkflow resWorkflow = this.workflowAccess.readWorkflow(workflow.getId(), this.testToken);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final GuiWorkflowCreateRequest createRequest = getTestGuiWorkflowCreateRequest();

    final List<GuiWorkflow> workflowList = this.getTestGuiWorkflowList();

    when(this.restTemplate.callRestPost(any(URI.class),
                                        any(EModule.class),
                                        any(WorkflowCreateRequestEdo.class),
                                        eq(WorkflowListEdo.class),
                                        any(String.class),
                                        any(boolean.class))).thenReturn(new WorkflowListEdo(GuiWorkflow.toEdoList(workflowList)));

    final List<GuiWorkflow> resWorkflowList = this.workflowAccess.createWorkflow(createRequest, this.testToken);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

  @Test
  @Ignore
  public void testSaveWorkflow() throws Exception {
    final GuiWorkflow workflow = this.getTestGuiWorkflow(1L);

    when(this.restTemplate.callRestPost(any(URI.class),
                                        any(EModule.class),
                                        any(WorkflowEdo.class),
                                        eq(WorkflowEdo.class),
                                        any(String.class),
                                        any(boolean.class))).thenReturn(workflow.toEdo());

    final GuiWorkflow resWorkflow = this.workflowAccess.saveWorkflow(workflow, this.testToken);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testReadWorkflowTypeList() throws Exception {

    final List<GuiWorkflowType> workflowTypeList = this.getTestGuiWorkflowTypeList();

    final WorkflowTypeListEdo typeListEdo = new WorkflowTypeListEdo(GuiWorkflowType.toEdoList(workflowTypeList));

    when(this.restTemplate.callRestGet(any(URI.class),
                                       any(EModule.class),
                                       eq(WorkflowTypeListEdo.class),
                                       any(String.class),
                                       any(boolean.class))).thenReturn(typeListEdo);

    final List<GuiWorkflowType> resWorkflowList = this.workflowAccess.readWorkflowTypeList(1L, this.testToken);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowTypeList.size());

  }

  @Test
  public void testSearchWorkflow() throws Exception {
    final GuiWorkflowSearchFilter searchFilter = getTestGuiWorkflowSearchFilter();

    final List<GuiWorkflow> workflowList = this.getTestGuiWorkflowList();

    when(this.restTemplate.callRestPost(any(URI.class),
                                        any(EModule.class),
                                        any(WorkflowSearchFilterEdo.class),
                                        eq(WorkflowListEdo.class),
                                        any(String.class),
                                        any(boolean.class))).thenReturn(new WorkflowListEdo(GuiWorkflow.toEdoList(workflowList)));

    final List<GuiWorkflow> resWorkflowList = this.workflowAccess.searchWorkflow(searchFilter, this.testToken);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

}

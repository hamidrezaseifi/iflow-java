package com.pth.iflow.gui.services.invoice;

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

import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowListEdo;
import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowSaveRequestEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.gui.TestDataProducer;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflowSaveRequest;
import com.pth.iflow.gui.services.IRestTemplateCall;
import com.pth.iflow.gui.services.IWorkflowAccess;
import com.pth.iflow.gui.services.impl.workflow.invoice.InvoiceWorkflowAccess;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceWorkflowAccessTest extends TestDataProducer {

  private IWorkflowAccess<InvoiceWorkflow, InvoiceWorkflowSaveRequest> workflowAccess;

  @MockBean
  private IRestTemplateCall                                            restTemplate;

  @MockBean
  private GuiConfiguration.WorkflowModuleAccessConfig                  workflowModuleAccessConfig;

  @MockBean
  private GuiConfiguration.ProfileModuleAccessConfig                   profileModuleAccessConfig;

  private URI                                                          testUri;

  private final String                                                 testToken = "test-token";

  @Before
  public void setUp() throws Exception {

    this.testUri = new URI("test-uri");

    when(this.profileModuleAccessConfig.getAuthenticationUri()).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getCreateInvoiceWorkflowUri()).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadAuthenticationInfoUri()).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadCompanyUserListUri(any(String.class))).thenReturn(this.testUri);
    when(this.profileModuleAccessConfig.getReadTokenInfoUri()).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getReadWorkflowTypeListUri(any(String.class))).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getReadInvoiceWorkflowUri(any(String.class))).thenReturn(this.testUri);
    when(this.workflowModuleAccessConfig.getSearchInvoiceWorkflowUri()).thenReturn(this.testUri);

    this.workflowAccess = new InvoiceWorkflowAccess(this.restTemplate, this.workflowModuleAccessConfig);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflow() throws Exception {

    final InvoiceWorkflow workflow = this.getTestInvoiceWorkflow("identity1");

    when(this.restTemplate.callRestGet(any(URI.class), any(EModule.class), eq(InvoiceWorkflowEdo.class), any(String.class),
        any(boolean.class))).thenReturn(GuiModelEdoMapper.toEdo(workflow));

    final InvoiceWorkflow resWorkflow = this.workflowAccess.readWorkflow(workflow.getIdentity(), this.testToken);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final InvoiceWorkflowSaveRequest createRequest = this.getTestInvoiceWorkflowSaveRequest();

    final List<InvoiceWorkflow> workflowList = this.getTestInvoiceWorkflowList();

    when(this.restTemplate.callRestPost(any(URI.class), any(EModule.class), any(InvoiceWorkflowSaveRequestEdo.class),
        eq(InvoiceWorkflowListEdo.class), any(String.class), any(boolean.class)))
            .thenReturn(new InvoiceWorkflowListEdo(GuiModelEdoMapper.toInvoiceWorkflowEdoList(workflowList)));

    final List<InvoiceWorkflow> resWorkflowList = this.workflowAccess.createWorkflow(createRequest, this.testToken);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

  @Test
  @Ignore
  public void testSaveWorkflow() throws Exception {
    final InvoiceWorkflow workflow = this.getTestInvoiceWorkflow("identity1");

    final InvoiceWorkflowSaveRequest request = this.getTestInvoiceWorkflowSaveRequest(workflow);

    when(this.restTemplate.callRestPost(any(URI.class), any(EModule.class), any(InvoiceWorkflowEdo.class),
        eq(InvoiceWorkflowEdo.class), any(String.class), any(boolean.class))).thenReturn(GuiModelEdoMapper.toEdo(workflow));

    final InvoiceWorkflow resWorkflow = this.workflowAccess.saveWorkflow(request, this.testToken);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testSearchWorkflow() throws Exception {
    final WorkflowSearchFilter searchFilter = this.getTestWorkflowSearchFilter();

    final List<InvoiceWorkflow> workflowList = this.getTestInvoiceWorkflowList();

    when(this.restTemplate.callRestPost(any(URI.class), any(EModule.class), any(WorkflowSearchFilterEdo.class),
        eq(InvoiceWorkflowListEdo.class), any(String.class), any(boolean.class)))
            .thenReturn(new InvoiceWorkflowListEdo(GuiModelEdoMapper.toInvoiceWorkflowEdoList(workflowList)));

    final List<InvoiceWorkflow> resWorkflowList = this.workflowAccess.searchWorkflow(searchFilter, this.testToken);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

}

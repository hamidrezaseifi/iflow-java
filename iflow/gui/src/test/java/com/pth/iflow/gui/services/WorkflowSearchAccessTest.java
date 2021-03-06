package com.pth.iflow.gui.services;

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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.models.edo.WorkflowSearchFilterEdo;
import com.pth.iflow.common.models.edo.workflow.WorkflowListEdo;
import com.pth.iflow.gui.TestDataProducer;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.WorkflowTypeStep;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.gui.models.workflow.workflow.Workflow;
import com.pth.iflow.gui.services.impl.workflow.WorkflowSearchAccess;
import com.pth.iflow.gui.services.impl.workflow.invoice.InvoiceWorkflowHandler;
import com.pth.iflow.gui.services.impl.workflow.singletask.SingleTaskWorkflowHandler;
import com.pth.iflow.gui.services.impl.workflow.testthree.TestThreeTaskWorkflowHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowSearchAccessTest extends TestDataProducer {

  private IWorkflowSearchAccess                       workflowSearchAccess;

  @MockBean
  private IRestTemplateCall                           restTemplate;

  @MockBean
  private SessionUserInfo                             sessionUserInfo;

  @MockBean
  private GuiConfiguration.WorkflowModuleAccessConfig workflowModuleAccessConfig;

  @MockBean
  private GuiConfiguration.ProfileModuleAccessConfig  profileModuleAccessConfig;

  @MockBean
  private InvoiceWorkflowHandler                      invoiceWorkflowHandler;

  @MockBean
  private SingleTaskWorkflowHandler                   singleTaskWorkflowHandler;

  @MockBean
  private TestThreeTaskWorkflowHandler                testThreeTaskWorkflowHandler;

  private URI                                         testUri;

  private final String                                testToken = "test-token";

  @Before
  public void setUp() throws Exception {

    this.testUri = new URI("test-uri");

    when(this.sessionUserInfo.getToken()).thenReturn(this.testToken);

    when(this.workflowModuleAccessConfig.getSearchWorkflowUri()).thenReturn(this.testUri);

    this.workflowSearchAccess = new WorkflowSearchAccess(this.restTemplate, this.workflowModuleAccessConfig, this.sessionUserInfo,
        this.invoiceWorkflowHandler, this.singleTaskWorkflowHandler, this.testThreeTaskWorkflowHandler);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSearchWorkflow() throws Exception {
    final WorkflowSearchFilter searchFilter           = this.getTestWorkflowSearchFilter();
    final WorkflowType         testSingleTaskType     = this.getTestSingleTaskWorkflowType();
    final WorkflowTypeStep     testWorkflowTypeStep   = this.getTestWorkflowTypeStep();
    final User                 testUser               = this.getTestUser();
    final SingleTaskWorkflow   testSingleTaskWorkflow = this.getTestSingleTaskWorkflow("identity");

    final List<Workflow>       workflowList           = this.getTestWorkflowList();

    when(this.restTemplate.callRestPost(any(URI.class), any(EModule.class), any(WorkflowSearchFilterEdo.class), eq(WorkflowListEdo.class),
        any(String.class), any(boolean.class))).thenReturn(new WorkflowListEdo(GuiModelEdoMapper.toWorkflowEdoList(workflowList)));

    when(this.sessionUserInfo.getWorkflowTypeByIdentity(any(String.class))).thenReturn(testSingleTaskType);
    when(this.sessionUserInfo.getWorkflowStepTypeByIdentity(any(String.class), any(String.class))).thenReturn(testWorkflowTypeStep);
    when(this.sessionUserInfo.getUser()).thenReturn(testUser);
    when(this.singleTaskWorkflowHandler.readWorkflow(any(String.class))).thenReturn(testSingleTaskWorkflow);

    final List<Workflow> resWorkflowList = this.workflowSearchAccess.searchWorkflow(searchFilter);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

}

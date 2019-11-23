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

import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.workflow.results.WorkflowResultListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.gui.TestDataProducer;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.models.workflow.WorkflowResult;
import com.pth.iflow.gui.services.impl.workflow.WorkflowSearchAccess;

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

  private URI                                         testUri;

  private final String                                testToken = "test-token";

  @Before
  public void setUp() throws Exception {

    this.testUri = new URI("test-uri");

    when(this.sessionUserInfo.getToken()).thenReturn(this.testToken);

    when(this.workflowModuleAccessConfig.getSearchWorkflowUri()).thenReturn(this.testUri);

    this.workflowSearchAccess = new WorkflowSearchAccess(this.restTemplate, this.workflowModuleAccessConfig, this.sessionUserInfo);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSearchWorkflow() throws Exception {
    final WorkflowSearchFilter searchFilter = this.getTestWorkflowSearchFilter();

    final List<WorkflowResult> workflowList = this.getTestWorkflowResultList();

    when(this.restTemplate.callRestPost(any(URI.class), any(EModule.class), any(WorkflowSearchFilterEdo.class),
        eq(WorkflowResultListEdo.class), any(String.class), any(boolean.class)))
            .thenReturn(new WorkflowResultListEdo(GuiModelEdoMapper.toWorkflowResultEdoList(workflowList)));

    final List<WorkflowResult> resWorkflowList = this.workflowSearchAccess.searchWorkflow(searchFilter);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

}

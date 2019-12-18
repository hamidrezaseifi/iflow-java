package com.pth.iflow.workflow.services;

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
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.edo.models.workflow.results.WorkflowResultListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.models.edo.WorkflowSearchFilterEdo;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IWorkflowSearchService;
import com.pth.iflow.workflow.bl.impl.workflowservice.workflow.WorkflowSearchService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.WorkflowResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowDataServiceTest extends TestDataProducer {

  private IWorkflowSearchService                   workflowSearchService;

  @Mock
  private IRestTemplateCall                        restTemplate;

  @MockBean
  private WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  private String                                   validTocken;

  @Before
  public void setUp() throws Exception {
    this.workflowSearchService = new WorkflowSearchService(this.restTemplate, this.moduleAccessConfig);

    when(this.moduleAccessConfig.generateCoreUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

    when(this.moduleAccessConfig.generateProfileUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

    this.validTocken = "validTocken";
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSearchWorkflow() throws Exception {

    final WorkflowSearchFilter filter = this.getTestWorkflowSearchFilter();
    final List<WorkflowResult> list = this.getTestWorkflowResultList();
    final WorkflowResultListEdo edoList = new WorkflowResultListEdo(WorkflowModelEdoMapper.toWorkflowResultEdoList(list));

    when(this.restTemplate.callRestPost(any(URI.class), any(String.class), any(EModule.class), any(WorkflowSearchFilterEdo.class),
        eq(WorkflowResultListEdo.class), any(boolean.class))).thenReturn(edoList);

    final List<WorkflowResult> resWorkflowList = this.workflowSearchService.search(filter, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowList);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowList.size(), list.size());

  }

}

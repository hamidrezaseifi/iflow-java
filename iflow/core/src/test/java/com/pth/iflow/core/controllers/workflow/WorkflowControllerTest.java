package com.pth.iflow.core.controllers.workflow;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pth.iflow.common.edo.models.workflow.results.WorkflowResultEdo;
import com.pth.iflow.common.edo.models.workflow.results.WorkflowResultListEdo;
import com.pth.iflow.common.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.models.workflow.WorkflowEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowResultEntity;
import com.pth.iflow.core.service.interfaces.IWorkflowSearchService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IWorkflowSearchService                 workflowSearchService;

  @MockBean
  private IWorkflowService                       workflowService;

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String                                 innerModulesRequestHeaderValue;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflow() throws Exception {
    final WorkflowEntity model = this.getTestWorkflow(1L);

    final WorkflowEdo modelEdo = getTestWorkflowEdo();

    when(this.workflowService.getByIdentity(any(String.class))).thenReturn(model);
    when(this.workflowService.toEdo(any(WorkflowEntity.class))).thenReturn(modelEdo);

    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc.perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.READ_WORKFLOW_BY_IDENTITY("test-identity"))

        .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue)).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE)).andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).getByIdentity(any(String.class));
  }

  @Test
  public void testSearchWorkflow() throws Exception {
    final WorkflowSearchFilter model = this.getTestWorkflowSearchFilter();
    final WorkflowSearchFilterEdo modelEdo = getTestWorkflowSearchFilterEdo();

    final List<WorkflowResultEntity> modelList = getTestWorkflowResultList();
    final List<WorkflowResultEdo> modelEdoList = getTestWorkflowResultEdoList();
    final WorkflowResultListEdo modelListEdo = new WorkflowResultListEdo(modelEdoList);

    when(this.workflowSearchService.search(any(WorkflowSearchFilter.class))).thenReturn(modelList);
    when(this.workflowSearchService.fromWorkflowSearchFilterEdo(any(WorkflowSearchFilterEdo.class))).thenReturn(model);
    when(this.workflowSearchService.toEdoList(any(List.class))).thenReturn(modelEdoList);

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelListEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.WORKFLOW_SEARCH).content(modelAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isAccepted()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowSearchService, times(1)).search(any(WorkflowSearchFilter.class));
  }

}

package com.pth.iflow.core.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.service.IWorkflowActionService;
import com.pth.iflow.core.service.IWorkflowFileService;
import com.pth.iflow.core.service.IWorkflowService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IWorkflowService                       workflowService;

  @MockBean
  private IWorkflowActionService                 workflowActionService;

  @MockBean
  private IWorkflowFileService                   workflowFileService;

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
    final Workflow model = this.getTestWorkflow(1L);

    when(this.workflowService.getById(any(Long.class))).thenReturn(model);

    final WorkflowEdo modelEdo = model.toEdo();
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.WORKFLOW_READ_BY_ID, model.getId())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowService, times(1)).getById(any(Long.class));
  }

  @Test
  public void testReadWorkflowAction() throws Exception {

  }

  @Test
  public void testReadWorkflowActionListByWorkflow() throws Exception {

  }

  @Test
  public void testReadWorkflowFile() throws Exception {

  }

  @Test
  public void testReadWorkflowFileListbyWorkflow() throws Exception {

  }

  @Test
  public void testReadWorkflowList() throws Exception {

  }

  @Test
  public void testReadWorkflowListbyType() throws Exception {

  }

  @Test
  public void testReadWorkflowListforUser() throws Exception {

  }

  @Test
  public void testSaveWorkflow() throws Exception {

  }

  @Test
  public void testSaveWorkflowAction() throws Exception {

  }

  @Test
  public void testSaveWorkflowFile() throws Exception {

  }

  @Test
  public void testSearchWorkflow() throws Exception {

  }

}

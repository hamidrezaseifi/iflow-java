package com.pth.iflow.core.controllers;

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

import com.pth.iflow.common.models.edo.WorkflowMessageEdo;
import com.pth.iflow.common.models.edo.WorkflowMessageListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;
import com.pth.iflow.core.service.interfaces.IWorkflowMessageService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowMessageControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IWorkflowMessageService                workflowMessageService;

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String                                 innerModulesRequestHeaderValue;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflowMessage() throws Exception {

    final WorkflowEntity workflow = getTestWorkflow(1L);
    final List<WorkflowMessageEntity> modelList = getTestWorkflowMessageList(workflow);
    final List<WorkflowMessageEdo> edoList = getTestWorkflowMessageEdoist(workflow);
    final WorkflowMessageListEdo modelListEdo = new WorkflowMessageListEdo(edoList);

    when(this.workflowMessageService.getNotClosedNotExpiredListByUserEmail(any(String.class))).thenReturn(modelList);
    when(this.workflowMessageService.toEdoList(any(List.class))).thenReturn(edoList);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelListEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.READ_WORKFLOWMESSAGE_READ_BY_USER("email", 1))
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowMessageService, times(1)).getNotClosedNotExpiredListByUserEmail(any(String.class));

  }

  @Test
  public void testSaveWorkflowMessage() throws Exception {
    final WorkflowEntity workflow = getTestWorkflow(1L);
    final WorkflowMessageEntity model = this.getTestWorkflowMessage(workflow, "Test-Message");

    final WorkflowMessageEdo modelEdo = getTestWorkflowMessageEdo(workflow, "Test-Message");

    when(this.workflowMessageService.save(any(WorkflowMessageEntity.class))).thenReturn(model);
    when(this.workflowMessageService.toEdo(any(WorkflowMessageEntity.class))).thenReturn(modelEdo);
    when(this.workflowMessageService.fromEdo(any(WorkflowMessageEdo.class))).thenReturn(model);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.WORKFLOWMESSAGE_SAVE).content(listAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowMessageService, times(1)).save(any(WorkflowMessageEntity.class));
  }

}

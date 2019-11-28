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
import com.pth.iflow.common.edo.models.WorkflowMessageEdo;
import com.pth.iflow.common.edo.models.WorkflowMessageListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.model.workflow.Workflow;
import com.pth.iflow.core.model.workflow.WorkflowMessage;
import com.pth.iflow.core.service.IWorkflowMessageService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowMessageControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IWorkflowMessageService workflowMessageService;

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String innerModulesRequestHeaderValue;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflowMessage() throws Exception {

    final Workflow workflow = getTestWorkflow(1L);
    final List<WorkflowMessage> modelList = getTestWorkflowMessageList(workflow);
    final WorkflowMessageListEdo modelListEdo = new WorkflowMessageListEdo(CoreModelEdoMapper.toWorkflowMessageEdoList(modelList));

    when(this.workflowMessageService.getNotClosedNotExpiredListByUserEmail(any(String.class))).thenReturn(modelList);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelListEdo);

    System.out.println("listAsXmlString:   " + listAsXmlString);

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.READ_WORKFLOWMESSAGE_READ_BY_USER("email", 1))
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.workflowMessageService, times(1)).getNotClosedNotExpiredListByUserEmail(any(String.class));

  }

  @Test
  public void testSaveWorkflowMessage() throws Exception {
    final Workflow workflow = getTestWorkflow(1L);
    final WorkflowMessage model = this.getTestWorkflowMessage(workflow, "Test-Message");
    final WorkflowMessageEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    when(this.workflowMessageService.save(any(WorkflowMessage.class))).thenReturn(model);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.WORKFLOWMESSAGE_SAVE)
                                               .content(listAsXmlString)
                                               .contentType(MediaType.APPLICATION_XML_VALUE)
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.workflowMessageService, times(1)).save(any(WorkflowMessage.class));
  }

}

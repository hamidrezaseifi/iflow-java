package com.pth.iflow.workflow.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Set;

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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pth.iflow.common.models.edo.workflow.invoice.InvoiceWorkflowListEdo;
import com.pth.iflow.common.models.edo.workflow.invoice.InvoiceWorkflowSaveRequestEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflowSaveRequest;
import com.pth.iflow.workflow.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceWorkflowControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IWorkflowProcessService<InvoiceWorkflow> workflowService;

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String innerModulesRequestHeaderValue;

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = "USER")
  public void testReadWorkflowById() throws Exception {

    final InvoiceWorkflow model = this.getTestInvoiceWorkflow("workflow1");
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(WorkflowModelEdoMapper.toEdo(model));

    System.out.println("resultAsXmlString: " + resultAsXmlString);
    when(this.workflowService.getByIdentity(any(String.class), any())).thenReturn(model);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.WorkflowModule.INVOICEWORKFLOW_READ_BY_IDENTITY, model.getIdentity())
        /* .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken") */)
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).getByIdentity(any(String.class), any());

  }

  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = "USER")
  public void testCreateWorkflow() throws Exception {

    final InvoiceWorkflowSaveRequest request = this.getTestInvoiceWorkflowSaveRequest();
    final InvoiceWorkflowSaveRequestEdo requestEdo = WorkflowModelEdoMapper.toEdo(request);
    final List<InvoiceWorkflow> list = this.getTestInvoiceWorkflowList();
    final InvoiceWorkflowListEdo listEdo = new InvoiceWorkflowListEdo(WorkflowModelEdoMapper.toInvoiceWorkflowEdoList(list));

    when(this.workflowService.create(any(InvoiceWorkflowSaveRequest.class), any())).thenReturn(list);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(requestEdo);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.WorkflowModule.INVOICEWORKFLOW_CREATE)
            .content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
        /* .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken") */)
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).create(any(InvoiceWorkflowSaveRequest.class), any());

  }

  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = "USER")
  public void testSaveWorkflow() throws Exception {

    final InvoiceWorkflowSaveRequest requestModel = this.getTestInvoiceWorkflowSaveRequest();
    final InvoiceWorkflow result = this.getTestInvoiceWorkflow("workflow1");
    requestModel.setWorkflow(result);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(WorkflowModelEdoMapper.toEdo(result));

    when(this.workflowService.save(any(InvoiceWorkflowSaveRequest.class), any())).thenReturn(result);

    final InvoiceWorkflowSaveRequestEdo requestModelEdo = WorkflowModelEdoMapper.toEdo(requestModel);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(requestModelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.WorkflowModule.INVOICEWORKFLOW_SAVE)
            .content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
        /* .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken") */)
        .andExpect(status().isAccepted())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).save(any(InvoiceWorkflowSaveRequest.class), any());

  }

  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = "USER")
  public void testReadWorkflowList() throws Exception {

    final Set<String> idList = this.getTestWorkflowIdSet();
    final List<InvoiceWorkflow> list = this.getTestInvoiceWorkflowList();
    final InvoiceWorkflowListEdo listEdo = new InvoiceWorkflowListEdo(WorkflowModelEdoMapper.toInvoiceWorkflowEdoList(list));

    when(this.workflowService.getListByIdentityList(any(Set.class), any())).thenReturn(list);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(idList);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.WorkflowModule.INVOICEWORKFLOW_READ_LIST)
            .content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
        /* .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken") */)
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).getListByIdentityList(any(Set.class), any());

  }

  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = "USER")
  public void testValidateWorkflow() throws Exception {

    final InvoiceWorkflowSaveRequest request = this.getTestInvoiceWorkflowSaveRequest();
    final InvoiceWorkflowSaveRequestEdo requestEdo = WorkflowModelEdoMapper.toEdo(request);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(requestEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.WorkflowModule.INVOICEWORKFLOW_VALIDATE)
            .content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
        /* .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken") */)
        .andExpect(status().isAccepted());

    verify(this.workflowService, times(1)).validate(any(InvoiceWorkflowSaveRequest.class), any());

  }

}

package com.pth.iflow.core.controllers;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pth.iflow.common.edo.models.IdentityListEdo;
import com.pth.iflow.common.edo.models.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.WorkflowActionListEdo;
import com.pth.iflow.common.edo.models.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.WorkflowFileListEdo;
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.invoice.InvoiceWorkflowEdo;
import com.pth.iflow.common.edo.models.invoice.InvoiceWorkflowListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.InvoiceWorkflow;
import com.pth.iflow.core.model.WorkflowAction;
import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.IInvoiceWorkflowService;
import com.pth.iflow.core.service.IWorkflowActionService;
import com.pth.iflow.core.service.IWorkflowFileService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceWorkflowControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IInvoiceWorkflowService                invoiceWorkflowService;

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
    final InvoiceWorkflow model = this.getTestInvoiceWorkflow(1L);

    when(this.invoiceWorkflowService.getByIdentity(any(String.class))).thenReturn(model);

    final InvoiceWorkflowEdo modelEdo = CoreModelEdoMapper.toEdo(model);
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    // System.out.println("listAsXmlString: \n" + listAsXmlString);
    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.INVOICEWORKFLOW_READ_BY_IDENTITY, model.getIdentity())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.invoiceWorkflowService, times(1)).getByIdentity(any(String.class));
  }

  @Test
  public void testReadWorkflowAction() throws Exception {
    final WorkflowAction model = this.getTestWorkflowAction(1L, 1L);
    final WorkflowActionEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    when(this.workflowActionService.getByIdentity(any(String.class))).thenReturn(model);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.INVOICEWORKFLOW_ACTION_READ_BY_IDENTITY, model.getIdentity())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowActionService, times(1)).getByIdentity(any(String.class));

  }

  @Test
  public void testReadWorkflowActionListByWorkflow() throws Exception {
    final List<WorkflowAction> modelList = this.getTestWorkflowActionList(1L);
    final WorkflowActionListEdo modelListEdo = new WorkflowActionListEdo(CoreModelEdoMapper.toWorkflowActionEdoList(modelList));

    when(this.workflowActionService.getListByIdWorkflowIdentity(any(String.class))).thenReturn(modelList);

    final String listEdoAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelListEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.INVOICEWORKFLOW_ACTION_READ_LIST_BY_WORKFLOWIDENTITY, "identity")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listEdoAsXmlString));

    verify(this.workflowActionService, times(1)).getListByIdWorkflowIdentity(any(String.class));

  }

  @Test
  public void testReadWorkflowFile() throws Exception {
    final WorkflowFile model = this.getTestWorkflowFile(1L, 1L);
    final WorkflowFileEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    when(this.workflowFileService.getByIdentity(any(String.class))).thenReturn(model);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.INVOICEWORKFLOW_FILE_READ_BY_IDENTITY, model.getIdentity())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowFileService, times(1)).getByIdentity(any(String.class));

  }

  @Test
  public void testReadWorkflowFileListbyWorkflow() throws Exception {
    final List<WorkflowFile> modelList = this.getTestWorkflowFileList(1L);
    final WorkflowFileListEdo modelListEdo = new WorkflowFileListEdo(CoreModelEdoMapper.toWorkflowFileEdoList(modelList));

    when(this.workflowFileService.getListByIdWorkflowIdentity(any(String.class))).thenReturn(modelList);

    final String listEdoAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelListEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.INVOICEWORKFLOW_FILE_READ_LIST_BY_WORKFLOWIDENTITY, "identity")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listEdoAsXmlString));

    verify(this.workflowFileService, times(1)).getListByIdWorkflowIdentity(any(String.class));

  }

  @Test
  public void testReadWorkflowList() throws Exception {
    final Set<String> list = this.getTestWorkflowIdentityList();
    final IdentityListEdo edoList = new IdentityListEdo(list);

    final List<InvoiceWorkflow> modelList = getTestInvoiceWorkflowList();
    final InvoiceWorkflowListEdo modelListEdo = new InvoiceWorkflowListEdo(CoreModelEdoMapper.toInvoiceWorkflowEdoList(modelList));

    when(this.invoiceWorkflowService.getListByIdentityList(any(Set.class))).thenReturn(modelList);

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelListEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.INVOICEWORKFLOW_READ_LIST).content(modelAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.invoiceWorkflowService, times(1)).getListByIdentityList(any(Set.class));

  }

  @Test
  public void testSaveWorkflow() throws Exception {
    final InvoiceWorkflow model = this.getTestInvoiceWorkflow(1L);
    final InvoiceWorkflowEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    when(this.invoiceWorkflowService.save(any(InvoiceWorkflow.class))).thenReturn(model);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.INVOICEWORKFLOW_SAVE).content(listAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isAccepted()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.invoiceWorkflowService, times(1)).save(any(InvoiceWorkflow.class));
  }

  @Test
  public void testSaveWorkflowAction() throws Exception {
    final WorkflowAction model = this.getTestWorkflowAction(1L, 1L);
    final WorkflowActionEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    when(this.workflowActionService.save(any(WorkflowAction.class))).thenReturn(model);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.INVOICEWORKFLOW_ACTION_SAVE).content(listAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isAccepted()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowActionService, times(1)).save(any(WorkflowAction.class));

  }

  @Test
  public void testSaveWorkflowFile() throws Exception {
    final WorkflowFile model = this.getTestWorkflowFile(1L, 1L);
    final WorkflowFileEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    when(this.workflowFileService.save(any(WorkflowFile.class))).thenReturn(model);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.INVOICEWORKFLOW_FILE_SAVE).content(listAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isAccepted()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowFileService, times(1)).save(any(WorkflowFile.class));

  }

  @Test
  public void testSearchWorkflow() throws Exception {
    final WorkflowSearchFilter model = this.getTestWorkflowSearchFilter();
    final WorkflowSearchFilterEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    final List<InvoiceWorkflow> modelList = getTestInvoiceWorkflowList();
    final InvoiceWorkflowListEdo modelListEdo = new InvoiceWorkflowListEdo(CoreModelEdoMapper.toInvoiceWorkflowEdoList(modelList));

    when(this.invoiceWorkflowService.search(any(WorkflowSearchFilter.class))).thenReturn(modelList);

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelListEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.INVOICEWORKFLOW_SEARCH).content(modelAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isAccepted()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.invoiceWorkflowService, times(1)).search(any(WorkflowSearchFilter.class));
  }

}

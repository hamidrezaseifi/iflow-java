package com.pth.iflow.core.controllers.workflow;

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

import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowListEdo;
import com.pth.iflow.common.models.edo.IdentityListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;
import com.pth.iflow.core.service.interfaces.workflow.IInvoiceWorkflowService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceWorkflowControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IInvoiceWorkflowService                workflowService;

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
    final InvoiceWorkflowEntity model = this.getTestInvoiceWorkflow(1L);
    final InvoiceWorkflowEdo modelEdo = this.getTestInvoiceWorkflowEdo();

    when(this.workflowService.getByIdentity(any(String.class))).thenReturn(model);
    when(this.workflowService.toEdo(any(InvoiceWorkflowEntity.class))).thenReturn(modelEdo);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    // System.out.println("listAsXmlString: \n" + listAsXmlString);
    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.INVOICEWORKFLOW_READ_BY_IDENTITY, model.getWorkflow().getIdentity())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowService, times(1)).getByIdentity(any(String.class));
  }

  @Test
  public void testReadWorkflowForUser() throws Exception {
    final List<InvoiceWorkflowEntity> modelList = getTestInvoiceWorkflowList();
    final List<InvoiceWorkflowEdo> modelEdoList = getTestInvoiceWorkflowEdoList();

    final InvoiceWorkflowListEdo modelListEdo = new InvoiceWorkflowListEdo(modelEdoList);

    when(this.workflowService.getListForUser(any(String.class), any(Integer.class))).thenReturn(modelList);
    when(this.workflowService.toEdoList(any(List.class))).thenReturn(modelEdoList);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelListEdo);

    // System.out.println("listAsXmlString: \n" + listAsXmlString);
    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.READ_INVOICEWORKFLOW_LIST_BY_USERIDENTITY("test-user-identity", 1))
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowService, times(1)).getListForUser(any(String.class), any(Integer.class));
  }

  @Test
  public void testReadWorkflowList() throws Exception {
    final Set<String> list = this.getTestWorkflowIdentityList();
    final IdentityListEdo edoList = new IdentityListEdo(list);

    final List<InvoiceWorkflowEntity> modelList = getTestInvoiceWorkflowList();
    final List<InvoiceWorkflowEdo> modelEdoList = getTestInvoiceWorkflowEdoList();

    final InvoiceWorkflowListEdo modelListEdo = new InvoiceWorkflowListEdo(modelEdoList);

    when(this.workflowService.getListByIdentityList(any(Set.class))).thenReturn(modelList);
    when(this.workflowService.toEdoList(any(List.class))).thenReturn(modelEdoList);

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelListEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.INVOICEWORKFLOW_READ_LIST).content(modelAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowService, times(1)).getListByIdentityList(any(Set.class));

  }

  @Test
  public void testSaveWorkflow() throws Exception {
    final InvoiceWorkflowEntity model = this.getTestInvoiceWorkflow(1L);
    final InvoiceWorkflowEdo modelEdo = this.getTestInvoiceWorkflowEdo();

    when(this.workflowService.save(any(InvoiceWorkflowEntity.class))).thenReturn(model);
    when(this.workflowService.toEdo(any(InvoiceWorkflowEntity.class))).thenReturn(modelEdo);
    when(this.workflowService.fromEdo(any(InvoiceWorkflowEdo.class))).thenReturn(model);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.INVOICEWORKFLOW_SAVE).content(listAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isAccepted()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowService, times(1)).save(any(InvoiceWorkflowEntity.class));
  }
}

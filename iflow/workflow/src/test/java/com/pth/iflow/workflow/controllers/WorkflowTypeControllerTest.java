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

import com.pth.iflow.common.models.edo.WorkflowTypeEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IWorkflowTypeProcessService;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IWorkflowTypeProcessService workflowTypeProcessService;

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
  public void testReadWorkflowTypeById() throws Exception {

    final WorkflowType model = getTestInvoiceWorkflowType();
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(WorkflowModelEdoMapper.toEdo(model));
    when(this.workflowTypeProcessService.getByIdentity(any(String.class), any())).thenReturn(model);

    final WorkflowTypeEdo modelEdo = WorkflowModelEdoMapper.toEdo(model);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.WorkflowModule.WORKFLOWTYPE_BY_ID_URIBUILDER(model.getIdentity()))
        /* .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken") */ )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowTypeProcessService, times(1)).getByIdentity(any(String.class), any());

  }

  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = "USER")
  public void testReadWorkflowTypeList() throws Exception {

    final Set<String> idList = this.getTestWorkflowTypeIdSet();
    final List<WorkflowType> list = this.getTestWorkflowTypeList();
    final WorkflowTypeListEdo listEdo = new WorkflowTypeListEdo(WorkflowModelEdoMapper.toWorkflowTypeEdoList(list));

    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    when(this.workflowTypeProcessService.getListByIdentityList(any(Set.class), any())).thenReturn(list);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(idList).replace("ArrayList", "List");

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.CoreModule.READ_WORKFLOWTYPE_LIST())
            .content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
        /* .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken") */)
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowTypeProcessService, times(1)).getListByIdentityList(any(Set.class), any());

  }

  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = "USER")
  public void testReadWorkflowTypeListByCompany() throws Exception {

    final List<WorkflowType> list = this.getTestWorkflowTypeList();
    final WorkflowTypeListEdo listEdo = new WorkflowTypeListEdo(WorkflowModelEdoMapper.toWorkflowTypeEdoList(list));

    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    when(this.workflowTypeProcessService.getListByCompanyIdentity(any(String.class), any())).thenReturn(list);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.CoreModule.READ_WORKFLOWTYPE_LIST_BY_COMPANY("companyidentity"))
        /* .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken") */)
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowTypeProcessService, times(1)).getListByCompanyIdentity(any(String.class), any());

  }
}

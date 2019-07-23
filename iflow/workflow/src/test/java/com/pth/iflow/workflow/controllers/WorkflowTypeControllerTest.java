package com.pth.iflow.workflow.controllers;

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

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.models.WorkflowType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IWorkflowTypeDataService               workflowTypeService;

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String                                 innerModulesRequestHeaderValue;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflowTypeById() throws Exception {

    final WorkflowType model = this.getTestWorkflowType();
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(model.toEdo());
    when(this.workflowTypeService.getById(any(Long.class))).thenReturn(model);

    final WorkflowTypeEdo modelEdo = model.toEdo();

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_BY_ID, model.getId())
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowTypeService, times(1)).getById(any(Long.class));

  }

  @Test
  public void testReadWorkflowTypeList() throws Exception {

    final List<Long> idList = this.getTestWorkflowTypeIdList();
    final List<WorkflowType> list = this.getTestWorkflowTypeList();
    final WorkflowTypeListEdo listEdo = new WorkflowTypeListEdo(ModelMapperBase.toEdoList(list));

    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    when(this.workflowTypeService.getListByIdList(any(List.class))).thenReturn(list);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(idList).replace("ArrayList", "List");

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_LIST).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowTypeService, times(1)).getListByIdList(any(List.class));

  }

  @Test
  public void testReadWorkflowTypeListByCompany() throws Exception {

    final List<WorkflowType> list = this.getTestWorkflowTypeList();
    final WorkflowTypeListEdo listEdo = new WorkflowTypeListEdo(ModelMapperBase.toEdoList(list));

    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    when(this.workflowTypeService.getListByIdCompanyId(any(Long.class))).thenReturn(list);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_LIST_BY_COMPANY, 1L)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowTypeService, times(1)).getListByIdCompanyId(any(Long.class));

  }
}

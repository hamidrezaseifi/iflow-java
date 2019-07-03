package com.pth.ifow.workflow.controllers;

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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pth.iflow.common.edo.models.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.ifow.workflow.TestDataProducer;
import com.pth.ifow.workflow.bl.IWorkflowTypeService;
import com.pth.ifow.workflow.models.WorkflowType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeControllerTest extends TestDataProducer {
  
  @Autowired
  private MockMvc mockMvc;
  
  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;
  
  @Autowired
  private ObjectMapper mapper;
  
  @MockBean
  private IWorkflowTypeService workflowService;
  
  @Before
  public void setUp() throws Exception {
  }
  
  @After
  public void tearDown() throws Exception {
  }
  
  @Test
  public void testReadWorkflowTypeById() throws Exception {
    
    final WorkflowType model = getTestWorkflowType();
    when(this.workflowService.getById(any(Long.class))).thenReturn(model);
    
    final WorkflowTypeEdo modelEdo = model.toEdo();
    
    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);
    
    this.mockMvc.perform(MockMvcRequestBuilders.get(IflowRestPaths.WorkflowModule.WORKFLOWTYPE_READ_BY_ID, model.getId())
        .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(modelAsXmlString));
    
    verify(this.workflowService, times(1)).getById(any(Long.class));
    
    final String modelAsJsonString = this.mapper.writeValueAsString(modelEdo);
    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.WorkflowModule.WORKFLOWTYPE_READ_BY_ID + "?produces=json", model.getId())
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(modelAsJsonString));
    
  }
  
  @Test
  public void testReadWorkflowTypeList() throws Exception {
    
    final List<Long> idList = getTestWorkflowTypeIdList();
    final List<WorkflowType> list = getTestWorkflowTypeList();
    when(this.workflowService.getListByIdList(any(List.class))).thenReturn(list);
    
    final List<WorkflowTypeEdo> edoList = ModelMapperBase.toEdoList(list);
    
    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(idList).replace("ArrayList", "List");
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList).replace("ArrayList", "List");
    
    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.WORKFLOWTYPE_READ_LIST).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE).header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));
    
    verify(this.workflowService, times(1)).getListByIdList(any(List.class));
    
    final String contentAsJsonString = this.mapper.writeValueAsString(idList);
    final String listAsJsonString = this.mapper.writeValueAsString(edoList);
    
    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.WORKFLOWTYPE_READ_LIST + "?produces=json")
            .content(contentAsJsonString).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(listAsJsonString));
    
  }
  
  @Test
  public void testReadWorkflowTypeListByCompany() throws Exception {
    
    final List<WorkflowType> list = getTestWorkflowTypeList();
    when(this.workflowService.getListByIdCompanyId(any(Long.class))).thenReturn(list);
    
    final List<WorkflowTypeEdo> edoList = ModelMapperBase.toEdoList(list);
    
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList).replace("ArrayList", "List");
    
    this.mockMvc.perform(MockMvcRequestBuilders.get(IflowRestPaths.WorkflowModule.WORKFLOWTYPE_READ_LIST_BY_COMPANY, 1L)
        .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));
    
    verify(this.workflowService, times(1)).getListByIdCompanyId(any(Long.class));
    
    final String listAsJsonString = this.mapper.writeValueAsString(edoList);
    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.WorkflowModule.WORKFLOWTYPE_READ_LIST_BY_COMPANY + "?produces=json", 1L)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(listAsJsonString));
    
  }
  
}
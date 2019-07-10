package com.pth.ifow.workflow.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.ifow.workflow.TestDataProducer;
import com.pth.ifow.workflow.bl.IWorkflowTypeDataService;
import com.pth.ifow.workflow.models.WorkflowType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeControllerTest extends TestDataProducer {
  
  @Autowired
  private MockMvc mockMvc;
  
  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;
  
  @MockBean
  private IWorkflowTypeDataService workflowService;
  
  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String innerModulesRequestHeaderValue;
  
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
    
    final MvcResult result = this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_BY_ID, model.getId())
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE)).andReturn();
    
    final String contentAsString = result.getResponse().getContentAsString();
    final WorkflowTypeEdo resEdo = this.xmlConverter.getObjectMapper().readValue(contentAsString, WorkflowTypeEdo.class);
    
    Assert.assertNotNull("Result workflow-type is not null!", resEdo);
    Assert.assertEquals("Result workflow-type has id 1!", modelEdo.getId(), resEdo.getId());
    Assert.assertEquals("Result workflow-type has title '" + modelEdo.getTitle() + "'!", resEdo.getTitle(), modelEdo.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", modelEdo.getStatus(), resEdo.getStatus());
    Assert.assertEquals("Result workflow-type has the same steps count!", modelEdo.getSteps().size(), resEdo.getSteps().size());
    
    verify(this.workflowService, times(1)).getById(any(Long.class));

  }
  
  @Test
  public void testReadWorkflowTypeList() throws Exception {
    
    final List<Long> idList = getTestWorkflowTypeIdList();
    final List<WorkflowType> list = getTestWorkflowTypeList();
    when(this.workflowService.getListByIdList(any(List.class))).thenReturn(list);
    
    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(idList).replace("ArrayList", "List");
    
    final MvcResult result = this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_LIST).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE)).andReturn();
    
    final String contentAsString = result.getResponse().getContentAsString();
    
    final ObjectMapper oMapper = this.xmlConverter.getObjectMapper();
    
    final List<WorkflowTypeEdo> resEdoList = oMapper.readValue(contentAsString,
        oMapper.getTypeFactory().constructCollectionType(List.class, WorkflowTypeEdo.class));
    
    Assert.assertNotNull("Result type-list is not null!", resEdoList);
    Assert.assertEquals("Result type-list has the same size as input list!", list.size(), resEdoList.size());
    Assert.assertEquals("First item of result type-list has title '" + list.get(0).getTitle() + "'!",
        resEdoList.get(0).getTitle(),
        list.get(0).getTitle());
    
    verify(this.workflowService, times(1)).getListByIdList(any(List.class));

  }
  
  @Test
  public void testReadWorkflowTypeListByCompany() throws Exception {
    
    final List<WorkflowType> list = getTestWorkflowTypeList();
    when(this.workflowService.getListByIdCompanyId(any(Long.class))).thenReturn(list);
    
    final MvcResult result = this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.WORKFLOWTYPE_READ_LIST_BY_COMPANY, 1L)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE)).andReturn();
    
    final String contentAsString = result.getResponse().getContentAsString();
    
    final ObjectMapper oMapper = this.xmlConverter.getObjectMapper();
    
    final List<WorkflowTypeEdo> resEdoList = oMapper.readValue(contentAsString,
        oMapper.getTypeFactory().constructCollectionType(List.class, WorkflowTypeEdo.class));
    
    Assert.assertNotNull("Result type-list is not null!", resEdoList);
    Assert.assertEquals("Result type-list has the same size as input list!", list.size(), resEdoList.size());
    Assert.assertEquals("First item of result type-list has title '" + list.get(0).getTitle() + "'!",
        resEdoList.get(0).getTitle(),
        list.get(0).getTitle());
    
    verify(this.workflowService, times(1)).getListByIdCompanyId(any(Long.class));

  }
}

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
import com.pth.iflow.common.edo.models.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IWorkflowTypeProcessService;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;

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
  public void testReadWorkflowTypeById() throws Exception {

    final WorkflowType model = this.getTestWorkflowType();
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(WorkflowModelEdoMapper.toEdo(model));
    when(this.workflowTypeProcessService.getById(any(Long.class), any(String.class))).thenReturn(model);

    final WorkflowTypeEdo modelEdo = WorkflowModelEdoMapper.toEdo(model);

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.WorkflowModule.WORKFLOWTYPE_BY_ID_URIBUILDER(model.getId()))
                                               .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowTypeProcessService, times(1)).getById(any(Long.class), any(String.class));

  }

  @Test
  public void testReadWorkflowTypeList() throws Exception {

    final List<Long> idList = this.getTestWorkflowTypeIdList();
    final List<WorkflowType> list = this.getTestWorkflowTypeList();
    final WorkflowTypeListEdo listEdo = new WorkflowTypeListEdo(WorkflowModelEdoMapper.toWorkflowTypeEdoList(list));

    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    when(this.workflowTypeProcessService.getListByIdList(any(List.class), any(String.class))).thenReturn(list);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(idList).replace("ArrayList", "List");

    this.mockMvc
                .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.READ_WORKFLOWTYPE_LIST())
                                               .content(contentAsXmlString)
                                               .contentType(MediaType.APPLICATION_XML_VALUE)
                                               .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowTypeProcessService, times(1)).getListByIdList(any(List.class), any(String.class));

  }

  @Test
  public void testReadWorkflowTypeListByCompany() throws Exception {

    final List<WorkflowType> list = this.getTestWorkflowTypeList();
    final WorkflowTypeListEdo listEdo = new WorkflowTypeListEdo(WorkflowModelEdoMapper.toWorkflowTypeEdoList(list));

    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    when(this.workflowTypeProcessService.getListByIdCompanyId(any(Long.class), any(String.class))).thenReturn(list);

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.READ_WORKFLOWTYPE_LIST_BY_COMPANY(1L))
                                               .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowTypeProcessService, times(1)).getListByIdCompanyId(any(Long.class), any(String.class));

  }
}

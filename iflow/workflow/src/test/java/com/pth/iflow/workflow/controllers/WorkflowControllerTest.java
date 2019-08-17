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
import com.pth.iflow.common.edo.models.xml.WorkflowCreateRequestEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowListEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowSearchFilterEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowCreateRequest;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IWorkflowProcessService                workflowService;

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String                                 innerModulesRequestHeaderValue;

  private String                                 validTocken;

  @Before
  public void setUp() throws Exception {

    this.validTocken = "validTocken";
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflowById() throws Exception {

    final Workflow model = this.getTestWorkflow(1L);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(model.toEdo());

    System.out.println("resultAsXmlString: " + resultAsXmlString);
    when(this.workflowService.getById(any(Long.class), any(String.class))).thenReturn(model);

    final WorkflowEdo modelEdo = model.toEdo();

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.WorkflowModule.WORKFLOW_READ_BY_ID, model.getId())
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).getById(any(Long.class), any(String.class));

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final WorkflowCreateRequest request = this.getTestWorkflowCreateRequest();
    final WorkflowCreateRequestEdo requestEdo = request.toEdo();
    final List<Workflow> list = this.getTestWorkflowList();
    final WorkflowListEdo listEdo = new WorkflowListEdo(ModelMapperBase.toEdoList(list));

    when(this.workflowService.create(any(WorkflowCreateRequest.class), any(String.class))).thenReturn(list);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(requestEdo);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.WORKFLOW_CREATE).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).create(any(WorkflowCreateRequest.class), any(String.class));

  }

  @Test
  public void testSaveWorkflow() throws Exception {

    final Workflow model = this.getTestWorkflow(1L);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(model.toEdo());

    when(this.workflowService.save(any(Workflow.class), any(String.class))).thenReturn(model);

    final WorkflowEdo modelEdo = model.toEdo();

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.WORKFLOW_SAVE).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isAccepted()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).save(any(Workflow.class), any(String.class));

  }

  @Test
  public void testReadWorkflowList() throws Exception {

    final List<Long> idList = this.getTestWorkflowIdList();
    final List<Workflow> list = this.getTestWorkflowList();
    final WorkflowListEdo listEdo = new WorkflowListEdo(ModelMapperBase.toEdoList(list));

    when(this.workflowService.getListByIdList(any(List.class), any(String.class))).thenReturn(list);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(idList);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.WORKFLOW_READ_LIST).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).getListByIdList(any(List.class), any(String.class));

  }

  @Test
  public void testSearchWorkflow() throws Exception {

    final WorkflowSearchFilter filter = this.getTestWorkflowSearchFilter();
    final WorkflowSearchFilterEdo filterEdo = filter.toEdo();
    final List<Workflow> list = this.getTestWorkflowList();
    final WorkflowListEdo listEdo = new WorkflowListEdo(ModelMapperBase.toEdoList(list));

    when(this.workflowService.search(any(WorkflowSearchFilter.class), any(String.class))).thenReturn(list);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(filterEdo);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.WORKFLOW_SEARCH).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).search(any(WorkflowSearchFilter.class), any(String.class));

  }

  @Test
  public void testReadWorkflowTypeListByCompany() throws Exception {

    final List<Workflow> list = this.getTestWorkflowList();
    final WorkflowListEdo listEdo = new WorkflowListEdo(ModelMapperBase.toEdoList(list));
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    when(this.workflowService.getListByTypeId(any(Long.class), any(String.class))).thenReturn(list);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.WorkflowModule.WORKFLOW_READ_LIST_BY_TYPE, 1L)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).getListByTypeId(any(Long.class), any(String.class));

  }
}

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pth.iflow.common.edo.models.WorkflowListEdo;
import com.pth.iflow.common.edo.models.WorkflowSaveRequestEdo;
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;

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

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflowById() throws Exception {

    final Workflow model = this.getTestWorkflow("workflow1");
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(WorkflowModelEdoMapper.toEdo(model));

    System.out.println("resultAsXmlString: " + resultAsXmlString);
    when(this.workflowService.getByIdentity(any(String.class), any(String.class))).thenReturn(model);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.WorkflowModule.WORKFLOW_READ_BY_IDENTITY, model.getIdentity())
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).getByIdentity(any(String.class), any(String.class));

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    final WorkflowSaveRequestEdo requestEdo = WorkflowModelEdoMapper.toEdo(request);
    final List<Workflow> list = this.getTestWorkflowList();
    final WorkflowListEdo listEdo = new WorkflowListEdo(WorkflowModelEdoMapper.toWorkflowEdoList(list));

    when(this.workflowService.create(any(WorkflowSaveRequest.class), any(String.class))).thenReturn(list);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(requestEdo);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.WORKFLOW_CREATE).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).create(any(WorkflowSaveRequest.class), any(String.class));

  }

  @Test
  public void testSaveWorkflow() throws Exception {

    final WorkflowSaveRequest requestModel = this.getTestWorkflowCreateRequest();
    final Workflow result = this.getTestWorkflow("workflow1");
    requestModel.setWorkflow(result);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(WorkflowModelEdoMapper.toEdo(result));

    when(this.workflowService.save(any(WorkflowSaveRequest.class), any(String.class))).thenReturn(result);

    final WorkflowSaveRequestEdo requestModelEdo = WorkflowModelEdoMapper.toEdo(requestModel);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(requestModelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.WORKFLOW_SAVE).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isAccepted()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).save(any(WorkflowSaveRequest.class), any(String.class));

  }

  @Test
  public void testReadWorkflowList() throws Exception {

    final Set<String> idList = this.getTestWorkflowIdSet();
    final List<Workflow> list = this.getTestWorkflowList();
    final WorkflowListEdo listEdo = new WorkflowListEdo(WorkflowModelEdoMapper.toWorkflowEdoList(list));

    when(this.workflowService.getListByIdentityList(any(Set.class), any(String.class))).thenReturn(list);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(idList);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.WORKFLOW_READ_LIST).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).getListByIdentityList(any(Set.class), any(String.class));

  }

  @Test
  public void testSearchWorkflow() throws Exception {

    final WorkflowSearchFilter filter = this.getTestWorkflowSearchFilter();
    final WorkflowSearchFilterEdo filterEdo = WorkflowModelEdoMapper.toEdo(filter);
    final List<Workflow> list = this.getTestWorkflowList();
    final WorkflowListEdo listEdo = new WorkflowListEdo(WorkflowModelEdoMapper.toWorkflowEdoList(list));

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
    final WorkflowListEdo listEdo = new WorkflowListEdo(WorkflowModelEdoMapper.toWorkflowEdoList(list));
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    when(this.workflowService.getListByTypeIdentity(any(String.class), any(String.class))).thenReturn(list);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.WorkflowModule.WORKFLOW_READ_LIST_BY_TYPEIDENTITY, "type1")
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).getListByTypeIdentity(any(String.class), any(String.class));

  }

  @Test
  public void testValidateWorkflow() throws Exception {

    final WorkflowSaveRequest request = this.getTestWorkflowCreateRequest();
    final WorkflowSaveRequestEdo requestEdo = WorkflowModelEdoMapper.toEdo(request);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(requestEdo);

    this.mockMvc.perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.WORKFLOW_VALIDATE).content(contentAsXmlString)
        .contentType(MediaType.APPLICATION_XML_VALUE)
        .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken")).andExpect(status().isAccepted());

    verify(this.workflowService, times(1)).validate(any(WorkflowSaveRequest.class), any(String.class));

  }

}

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

import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowListEdo;
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowSaveRequestEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.workflow.models.workflow.testthree.TestThreeTaskWorkflowSaveRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestThreeTaskWorkflowControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                        mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter         xmlConverter;

  @MockBean
  private IWorkflowProcessService<TestThreeTaskWorkflow> workflowService;

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String                                         innerModulesRequestHeaderValue;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflowById() throws Exception {

    final TestThreeTaskWorkflow model = this.getTestTestThreeTaskWorkflow("workflow1");
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(WorkflowModelEdoMapper.toEdo(model));

    System.out.println("resultAsXmlString: " + resultAsXmlString);
    when(this.workflowService.getByIdentity(any(String.class), any(String.class))).thenReturn(model);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.WorkflowModule.TESTTHREETASKWORKFLOW_READ_BY_IDENTITY, model.getIdentity())
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).getByIdentity(any(String.class), any(String.class));

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final TestThreeTaskWorkflowSaveRequest request = this.getTestTestThreeTaskWorkflowSaveRequest();
    final TestThreeTaskWorkflowSaveRequestEdo requestEdo = WorkflowModelEdoMapper.toEdo(request);
    final List<TestThreeTaskWorkflow> list = this.getTestTestThreeTaskWorkflowList();
    final TestThreeTaskWorkflowListEdo listEdo = new TestThreeTaskWorkflowListEdo(
        WorkflowModelEdoMapper.toTestThreeTaskWorkflowEdoList(list));

    when(this.workflowService.create(any(TestThreeTaskWorkflowSaveRequest.class), any(String.class))).thenReturn(list);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(requestEdo);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.TESTTHREETASKWORKFLOW_CREATE).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).create(any(TestThreeTaskWorkflowSaveRequest.class), any(String.class));

  }

  @Test
  public void testSaveWorkflow() throws Exception {

    final TestThreeTaskWorkflowSaveRequest requestModel = this.getTestTestThreeTaskWorkflowSaveRequest();
    final TestThreeTaskWorkflow result = this.getTestTestThreeTaskWorkflow("workflow1");
    requestModel.setWorkflow(result);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(WorkflowModelEdoMapper.toEdo(result));

    when(this.workflowService.save(any(TestThreeTaskWorkflowSaveRequest.class), any(String.class))).thenReturn(result);

    final TestThreeTaskWorkflowSaveRequestEdo requestModelEdo = WorkflowModelEdoMapper.toEdo(requestModel);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(requestModelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.TESTTHREETASKWORKFLOW_SAVE).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isAccepted()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).save(any(TestThreeTaskWorkflowSaveRequest.class), any(String.class));

  }

  @Test
  public void testReadWorkflowList() throws Exception {

    final Set<String> idList = this.getTestWorkflowIdSet();
    final List<TestThreeTaskWorkflow> list = this.getTestTestThreeTaskWorkflowList();
    final TestThreeTaskWorkflowListEdo listEdo = new TestThreeTaskWorkflowListEdo(
        WorkflowModelEdoMapper.toTestThreeTaskWorkflowEdoList(list));

    when(this.workflowService.getListByIdentityList(any(Set.class), any(String.class))).thenReturn(list);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(idList);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.TESTTHREETASKWORKFLOW_READ_LIST).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).getListByIdentityList(any(Set.class), any(String.class));

  }

  @Test
  public void testValidateWorkflow() throws Exception {

    final TestThreeTaskWorkflowSaveRequest request = this.getTestTestThreeTaskWorkflowSaveRequest();
    final TestThreeTaskWorkflowSaveRequestEdo requestEdo = WorkflowModelEdoMapper.toEdo(request);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(requestEdo);

    this.mockMvc.perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.TESTTHREETASKWORKFLOW_VALIDATE)
        .content(contentAsXmlString).contentType(MediaType.APPLICATION_XML_VALUE)
        .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken")).andExpect(status().isAccepted());

    verify(this.workflowService, times(1)).validate(any(TestThreeTaskWorkflowSaveRequest.class), any(String.class));

  }

}

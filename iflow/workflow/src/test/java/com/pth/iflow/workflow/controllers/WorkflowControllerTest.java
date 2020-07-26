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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pth.iflow.common.models.edo.WorkflowSearchFilterEdo;
import com.pth.iflow.common.models.edo.workflow.WorkflowListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.bl.IWorkflowSearchService;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.Workflow;
import com.pth.iflow.workflow.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IWorkflowSearchService workflowSearchService;

  @MockBean
  private IWorkflowProcessService<Workflow> workflowService;

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
  public void testSearchSingleTaskWorkflow() throws Exception {

    final WorkflowSearchFilter filter = this.getTestWorkflowSearchFilter();
    final WorkflowSearchFilterEdo filterEdo = WorkflowModelEdoMapper.toEdo(filter);
    final List<Workflow> list = this.getTestWorkflowList();
    final WorkflowListEdo listEdo = new WorkflowListEdo(WorkflowModelEdoMapper.toWorkflowEdoList(list));

    when(this.workflowSearchService.search(any(WorkflowSearchFilter.class), any())).thenReturn(list);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(filterEdo);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.WorkflowModule.WORKFLOW_SEARCH)
            .content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)/*
                                                          * .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY,
                                                          * "test-roken")
                                                          */)
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowSearchService, times(1)).search(any(WorkflowSearchFilter.class), any());

  }

  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = "USER")
  public void testReadWorkflowById() throws Exception {

    final Workflow model = this.getTestWorkflow("workflow1");
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(WorkflowModelEdoMapper.toEdo(model));

    System.out.println("resultAsXmlString: " + resultAsXmlString);
    when(this.workflowService.getByIdentity(any(String.class), any())).thenReturn(model);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.WorkflowModule.READ_WORKFLOW_BY_IDENTITY_URIBUILDER(model.getIdentity()))
        /* .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken") */)
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.workflowService, times(1)).getByIdentity(any(String.class), any());

  }

}

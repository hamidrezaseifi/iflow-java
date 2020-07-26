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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.pth.iflow.common.models.edo.WorkflowTypeStepEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeStepListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.workflow.bl.IWorkflowTypeStepProcessService;
import com.pth.iflow.workflow.models.WorkflowTypeStep;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeStepControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IWorkflowTypeStepProcessService workflowStepProcessService;

  @Before
  public void setUp() throws Exception {

    final JaxbAnnotationModule jaxbAnnotationModule = new JaxbAnnotationModule();
    this.xmlConverter.getObjectMapper().registerModule(jaxbAnnotationModule);

  }

  @After
  public void tearDown() throws Exception {

  }

//BearerTokenAuthenticationToken
  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = "USER")
  public void testReadWorkflowTypeStepById() throws Exception {

    final WorkflowTypeStep model = this.getTestWorkflowTypeStep();
    when(this.workflowStepProcessService.getByIdentity(any(String.class), any())).thenReturn(model);

    final WorkflowTypeStepEdo modelEdo = WorkflowModelEdoMapper.toEdo(model);

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    System.out.println("modelAsXmlString : " + modelAsXmlString);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.WorkflowModule.WORKFLOWTYPESTEP_READ_BY_IDENTITY, model.getIdentity())
            .principal(null)
        // .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken")
        )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(modelAsXmlString));

    verify(this.workflowStepProcessService, times(1)).getByIdentity(any(String.class), any());

  }

  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = "USER")
  public void testReadWorkflowTypeStepList() throws Exception {

    final Set<String> idList = this.getTestWorkflowTypeStepIdSet();
    final List<WorkflowTypeStep> list = this.getTestWorkflowTypeStepList();
    when(this.workflowStepProcessService.getListByIdentityList(any(Set.class), any())).thenReturn(list);

    final WorkflowTypeStepListEdo edoList = new WorkflowTypeStepListEdo(WorkflowModelEdoMapper.toWorkflowTypeStepEdoList(list));

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(idList).replace("ArrayList", "List");
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList).replace("ArrayList", "List");

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.WorkflowModule.WORKFLOWTYPESTEP_READ_LIST)
            .content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
        // .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken")
        )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowStepProcessService, times(1)).getListByIdentityList(any(Set.class), any());

  }

  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = "USER")
  public void testReadWorkflowTypeStepListByWorkflow() throws Exception {

    final List<WorkflowTypeStep> list = this.getTestWorkflowTypeStepList();
    when(this.workflowStepProcessService.getListByWorkflowIdentity(any(String.class), any())).thenReturn(list);

    final WorkflowTypeStepListEdo edoList = new WorkflowTypeStepListEdo(WorkflowModelEdoMapper.toWorkflowTypeStepEdoList(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList).replace("ArrayList", "List");

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.WorkflowModule.WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOWIDENTITY, "identity")
        // .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken")
        )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowStepProcessService, times(1)).getListByWorkflowIdentity(any(String.class), any());

  }

}

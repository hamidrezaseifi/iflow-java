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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IWorkflowTypeStepDataService;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeStepControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IWorkflowTypeStepDataService           workflowStepService;

  @Before
  public void setUp() throws Exception {

    final JaxbAnnotationModule jaxbAnnotationModule = new JaxbAnnotationModule();
    this.xmlConverter.getObjectMapper().registerModule(jaxbAnnotationModule);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflowTypeStepById() throws Exception {

    final WorkflowTypeStep model = this.getTestWorkflowTypeStep();
    when(this.workflowStepService.getById(any(Long.class))).thenReturn(model);

    final WorkflowTypeStepEdo modelEdo = model.toEdo();

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    System.out.println("modelAsXmlString : " + modelAsXmlString);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.WorkflowModule.WORKFLOWTYPESTEP_READ_BY_ID, model.getId())
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(modelAsXmlString));

    verify(this.workflowStepService, times(1)).getById(any(Long.class));

  }

  @Test
  public void testReadWorkflowTypeStepList() throws Exception {

    final List<Long> idList = this.getTestWorkflowTypeStepIdList();
    final List<WorkflowTypeStep> list = this.getTestWorkflowTypeStepList();
    when(this.workflowStepService.getListByIdList(any(List.class))).thenReturn(list);

    final WorkflowTypeStepListEdo edoList = new WorkflowTypeStepListEdo(ModelMapperBase.toEdoList(list));

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(idList).replace("ArrayList", "List");
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList).replace("ArrayList", "List");

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.WorkflowModule.WORKFLOWTYPESTEP_READ_LIST).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowStepService, times(1)).getListByIdList(any(List.class));

  }

  @Test
  public void testReadWorkflowTypeStepListByWorkflow() throws Exception {

    final List<WorkflowTypeStep> list = this.getTestWorkflowTypeStepList();
    when(this.workflowStepService.getListByWorkflowId(any(Long.class))).thenReturn(list);

    final WorkflowTypeStepListEdo edoList = new WorkflowTypeStepListEdo(ModelMapperBase.toEdoList(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList).replace("ArrayList", "List");

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.WorkflowModule.WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOW, 1L)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, "test-roken"))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowStepService, times(1)).getListByWorkflowId(any(Long.class));

  }

}

package com.pth.iflow.core.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.HashSet;
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

import com.pth.iflow.common.models.edo.IdentityListEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeStepEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeStepListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeStepEntity;
import com.pth.iflow.core.service.interfaces.IWorkflowTypeStepService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeStepControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IWorkflowTypeStepService               workflowStepService;

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String                                 innerModulesRequestHeaderValue;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflowTypeStepById() throws Exception {

    final WorkflowTypeStepEntity model = this.getTestWorkflowTypeStep();
    final WorkflowTypeStepEdo modelEdo = getTestWorkflowTypeStepEdo();

    when(this.workflowStepService.getByIdentity(any(String.class))).thenReturn(model);
    when(this.workflowStepService.toEdo(any(WorkflowTypeStepEntity.class))).thenReturn(modelEdo);

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.WORKFLOWTYPESTEP_READ_BY_IDENTITY, model.getIdentity())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(modelAsXmlString));

    verify(this.workflowStepService, times(1)).getByIdentity(any(String.class));

  }

  @Test
  public void testReadWorkflowTypeStepList() throws Exception {

    final Set<String> idList = new HashSet<>(Arrays.asList("item-1", "item-2", "item-3"));
    final List<WorkflowTypeStepEdo> edoList = getTestWorkflowTypeStepEdoList();

    final IdentityListEdo edoIdentityList = new IdentityListEdo(idList);
    final List<WorkflowTypeStepEntity> list = this.getTestWorkflowTypeStepList();

    when(this.workflowStepService.getListByIdentityList(any(Set.class))).thenReturn(list);
    when(this.workflowStepService.toEdoList(any(List.class))).thenReturn(edoList);

    final WorkflowTypeStepListEdo edoResultList = new WorkflowTypeStepListEdo(edoList);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoIdentityList);
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoResultList);

    System.out.println("listAsXmlString:\n" + listAsXmlString);
    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.WORKFLOWTYPESTEP_READ_LIST).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowStepService, times(1)).getListByIdentityList(any(Set.class));

  }

  @Test
  public void testReadWorkflowTypeStepListByWorkflow() throws Exception {

    final List<WorkflowTypeStepEntity> list = this.getTestWorkflowTypeStepList();
    final List<WorkflowTypeStepEdo> edoConvertedList = getTestWorkflowTypeStepEdoList();

    when(this.workflowStepService.getListByWorkflowTypeIdentity(any(String.class))).thenReturn(list);
    when(this.workflowStepService.toEdoList(any(List.class))).thenReturn(edoConvertedList);

    final WorkflowTypeStepListEdo edoList = new WorkflowTypeStepListEdo(edoConvertedList);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOWIDENTITY, 1L)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowStepService, times(1)).getListByWorkflowTypeIdentity(any(String.class));

  }

}

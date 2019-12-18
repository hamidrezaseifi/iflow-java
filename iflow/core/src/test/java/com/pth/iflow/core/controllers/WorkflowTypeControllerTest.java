package com.pth.iflow.core.controllers;

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

import com.pth.iflow.common.models.edo.IdentityListEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.service.interfaces.IWorkflowTypeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IWorkflowTypeService                   workflowService;

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String                                 innerModulesRequestHeaderValue;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflowTypeById() throws Exception {

    final WorkflowTypeEntity model = this.getTestWorkflowType();
    final WorkflowTypeEdo modelEdo = getTestWorkflowTypeEdo();
    when(this.workflowService.getByIdentity(any(String.class))).thenReturn(model);
    when(this.workflowService.toEdo(any(WorkflowTypeEntity.class))).thenReturn(modelEdo);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.WORKFLOWTYPE_READ_BY_IDENTITY, model.getIdentity())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowService, times(1)).getByIdentity(any(String.class));

  }

  @Test
  public void testReadWorkflowTypeList() throws Exception {

    final Set<String> idList = this.getTestWorkflowTypeIdSet();
    final IdentityListEdo edoIdentityList = new IdentityListEdo(idList);
    final List<WorkflowTypeEntity> list = this.getTestWorkflowTypeList();

    final List<WorkflowTypeEdo> edoList = getTestWorkflowTypeEdoList();

    when(this.workflowService.getListByIdentityList(any(Set.class))).thenReturn(list);
    when(this.workflowService.toEdoList(any(List.class))).thenReturn(edoList);

    final WorkflowTypeListEdo edoResultList = new WorkflowTypeListEdo(edoList);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoIdentityList);
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoResultList);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.WORKFLOWTYPE_READ_LIST).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowService, times(1)).getListByIdentityList(any(Set.class));

  }

  @Test
  public void testReadWorkflowTypeListByCompany() throws Exception {

    final List<WorkflowTypeEntity> list = this.getTestWorkflowTypeList();
    final List<WorkflowTypeEdo> edoConvertedList = getTestWorkflowTypeEdoList();

    when(this.workflowService.getListByIdCompanyId(any(String.class))).thenReturn(list);
    when(this.workflowService.toEdoList(any(List.class))).thenReturn(edoConvertedList);

    final WorkflowTypeListEdo edoList = new WorkflowTypeListEdo(edoConvertedList);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.WORKFLOWTYPE_READ_LIST_BY_COMPANYIDENTITY, "companyidentity")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.workflowService, times(1)).getListByIdCompanyId(any(String.class));

  }

}

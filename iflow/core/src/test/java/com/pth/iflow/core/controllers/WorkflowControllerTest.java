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
import com.pth.iflow.common.edo.models.IdentityListEdo;
import com.pth.iflow.common.edo.models.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.WorkflowActionListEdo;
import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.WorkflowFileListEdo;
import com.pth.iflow.common.edo.models.WorkflowListEdo;
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowAction;
import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.IWorkflowActionService;
import com.pth.iflow.core.service.IWorkflowFileService;
import com.pth.iflow.core.service.IWorkflowService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IWorkflowService workflowService;

  @MockBean
  private IWorkflowActionService workflowActionService;

  @MockBean
  private IWorkflowFileService workflowFileService;

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String innerModulesRequestHeaderValue;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflow() throws Exception {
    final Workflow model = this.getTestWorkflow(1L);

    when(this.workflowService.getByIdentity(any(String.class))).thenReturn(model);

    final WorkflowEdo modelEdo = CoreModelEdoMapper.toEdo(model);
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    // System.out.println("listAsXmlString: \n" + listAsXmlString);
    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.WORKFLOW_READ_BY_IDENTITY, model.getIdentity())
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.workflowService, times(1)).getByIdentity(any(String.class));
  }

  @Test
  public void testReadWorkflowAction() throws Exception {
    final WorkflowAction model = this.getTestWorkflowAction(1L, 1L);
    final WorkflowActionEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    when(this.workflowActionService.getByIdentity(any(String.class))).thenReturn(model);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.WORKFLOW_ACTION_READ_BY_IDENTITY, model.getIdentity())
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.workflowActionService, times(1)).getByIdentity(any(String.class));

  }

  @Test
  public void testReadWorkflowActionListByWorkflow() throws Exception {
    final List<WorkflowAction> modelList = this.getTestWorkflowActionList(1L);
    final WorkflowActionListEdo modelListEdo = new WorkflowActionListEdo(CoreModelEdoMapper.toWorkflowActionEdoList(modelList));

    when(this.workflowActionService.getListByIdWorkflowIdentity(any(String.class))).thenReturn(modelList);

    final String listEdoAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelListEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.WORKFLOW_ACTION_READ_LIST_BY_WORKFLOWIDENTITY, "identity")
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listEdoAsXmlString));

    verify(this.workflowActionService, times(1)).getListByIdWorkflowIdentity(any(String.class));

  }

  @Test
  public void testReadWorkflowFile() throws Exception {
    final WorkflowFile model = this.getTestWorkflowFile(1L, 1L);
    final WorkflowFileEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    when(this.workflowFileService.getByIdentity(any(String.class))).thenReturn(model);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.WORKFLOW_FILE_READ_BY_IDENTITY, model.getIdentity())
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.workflowFileService, times(1)).getByIdentity(any(String.class));

  }

  @Test
  public void testReadWorkflowFileListbyWorkflow() throws Exception {
    final List<WorkflowFile> modelList = this.getTestWorkflowFileList(1L);
    final WorkflowFileListEdo modelListEdo = new WorkflowFileListEdo(CoreModelEdoMapper.toWorkflowFileEdoList(modelList));

    when(this.workflowFileService.getListByIdWorkflowIdentity(any(String.class))).thenReturn(modelList);

    final String listEdoAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelListEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.WORKFLOW_FILE_READ_LIST_BY_WORKFLOWIDENTITY, "identity")
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listEdoAsXmlString));

    verify(this.workflowFileService, times(1)).getListByIdWorkflowIdentity(any(String.class));

  }

  @Test
  public void testReadWorkflowList() throws Exception {
    final Set<String> list = this.getTestWorkflowIdentityList();
    final IdentityListEdo edoList = new IdentityListEdo(list);

    final List<Workflow> modelList = getTestWorkflowList();
    final WorkflowListEdo modelListEdo = new WorkflowListEdo(CoreModelEdoMapper.toWorkflowEdoList(modelList));

    when(this.workflowService.getListByIdentityList(any(Set.class))).thenReturn(modelList);

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelListEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.WORKFLOW_READ_LIST)
                                               .content(modelAsXmlString)
                                               .contentType(MediaType.APPLICATION_XML_VALUE)
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.workflowService, times(1)).getListByIdentityList(any(Set.class));

  }

  @Test
  public void testReadWorkflowListByType() throws Exception {

    final List<Workflow> modelList = getTestWorkflowList();
    final WorkflowListEdo modelListEdo = new WorkflowListEdo(CoreModelEdoMapper.toWorkflowEdoList(modelList));

    when(this.workflowService.getListByTypeId(any(String.class))).thenReturn(modelList);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelListEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.WORKFLOW_READ_LIST_BY_WORKFLOWTYPEIDENTITY, "identity")
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.workflowService, times(1)).getListByTypeId(any(String.class));

  }

  @Test
  public void testReadWorkflowListforUser() throws Exception {

  }

  @Test
  public void testSaveWorkflow() throws Exception {
    final Workflow model = this.getTestWorkflow(1L);
    final WorkflowEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    when(this.workflowService.save(any(Workflow.class))).thenReturn(model);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.WORKFLOW_SAVE)
                                               .content(listAsXmlString)
                                               .contentType(MediaType.APPLICATION_XML_VALUE)
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isAccepted())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.workflowService, times(1)).save(any(Workflow.class));
  }

  @Test
  public void testSaveWorkflowAction() throws Exception {
    final WorkflowAction model = this.getTestWorkflowAction(1L, 1L);
    final WorkflowActionEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    when(this.workflowActionService.save(any(WorkflowAction.class))).thenReturn(model);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.WORKFLOW_ACTION_SAVE)
                                               .content(listAsXmlString)
                                               .contentType(MediaType.APPLICATION_XML_VALUE)
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isAccepted())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.workflowActionService, times(1)).save(any(WorkflowAction.class));

  }

  @Test
  public void testSaveWorkflowFile() throws Exception {
    final WorkflowFile model = this.getTestWorkflowFile(1L, 1L);
    final WorkflowFileEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    when(this.workflowFileService.save(any(WorkflowFile.class))).thenReturn(model);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.WORKFLOW_FILE_SAVE)
                                               .content(listAsXmlString)
                                               .contentType(MediaType.APPLICATION_XML_VALUE)
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isAccepted())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.workflowFileService, times(1)).save(any(WorkflowFile.class));

  }

  @Test
  public void testSearchWorkflow() throws Exception {
    final WorkflowSearchFilter model = this.getTestWorkflowSearchFilter();
    final WorkflowSearchFilterEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    final List<Workflow> modelList = getTestWorkflowList();
    final WorkflowListEdo modelListEdo = new WorkflowListEdo(CoreModelEdoMapper.toWorkflowEdoList(modelList));

    when(this.workflowService.search(any(WorkflowSearchFilter.class))).thenReturn(modelList);

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelListEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.WORKFLOW_SEARCH)
                                               .content(modelAsXmlString)
                                               .contentType(MediaType.APPLICATION_XML_VALUE)
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isAccepted())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.workflowService, times(1)).search(any(WorkflowSearchFilter.class));
  }

}
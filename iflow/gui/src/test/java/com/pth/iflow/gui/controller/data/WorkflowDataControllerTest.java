package com.pth.iflow.gui.controller.data;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.pth.iflow.gui.TestDataProducer;
import com.pth.iflow.gui.models.GuiUser;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowCreateRequest;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.models.ui.GuiSessionUserInfo;
import com.pth.iflow.gui.services.IUserAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowDataControllerTest extends TestDataProducer {

  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2HttpMessageConverter jsonConverter;

  @Autowired
  private WebApplicationContext context;

  @MockBean
  private GuiSessionUserInfo sessionUserInfo;

  @MockBean
  private IWorkflowHandler workflowHandler;

  @MockBean
  private IUserAccess userAccess;

  @Before
  public void setUp() throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();

    Mockito.when(this.sessionUserInfo.isValid()).thenReturn(true);
    Mockito.when(this.sessionUserInfo.getCompanyProfile()).thenReturn(getTestCompanyProfile());
    Mockito.when(this.sessionUserInfo.getUser()).thenReturn(getTestUser());
    Mockito.when(this.sessionUserInfo.getToken()).thenReturn("test-token");
    Mockito.when(this.sessionUserInfo.getSessionId()).thenReturn("test-sessionid");

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testLoadWorkflowInitialData() throws Exception {

    final List<GuiWorkflowType> workflowTypeList = this.getTestGuiWorkflowTypeList();

    Mockito.when(this.workflowHandler.readWorkflowTypeList(ArgumentMatchers.any(Long.class))).thenReturn(workflowTypeList);

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/workflow/data/workflowlist/init");

    this.mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

  }

  @Test
  public void testSearchWorkflows() throws Exception {

    final List<GuiWorkflow> resultList = getTestGuiWorkflowList();

    final GuiWorkflowSearchFilter workflowSearchFilter = getTestGuiWorkflowSearchFilter();

    final String contentAsXmlString = this.jsonConverter.getObjectMapper().writeValueAsString(workflowSearchFilter);

    final String resultAsXmlString = this.jsonConverter.getObjectMapper().writeValueAsString(resultList);

    Mockito.when(this.workflowHandler.searchWorkflow(ArgumentMatchers.any(GuiWorkflowSearchFilter.class))).thenReturn(resultList);

    final MockHttpServletRequestBuilder builder =
                                                MockMvcRequestBuilders.post("/workflow/data/workflowlist/search")
                                                                      .content(contentAsXmlString)
                                                                      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

    this.mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(resultAsXmlString));

  }

  @Test
  public void testListCompanyUsers() throws Exception {

    final List<GuiUser> userList = this.getTestUserList();

    final String resultAsXmlString = this.jsonConverter.getObjectMapper().writeValueAsString(userList);

    Mockito.when(this.userAccess.getCompanyUserList(ArgumentMatchers.any(Long.class))).thenReturn(userList);

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/workflow/data/companyusers");

    this.mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(resultAsXmlString));

  }

  @Test
  public void testLoadWorkflowCreateData() throws Exception {

    final Map<String, Object> map = new HashMap<>();

    final List<GuiUser> userList = this.getTestUserList();
    final List<GuiWorkflowType> workflowTypeList = this.getTestGuiWorkflowTypeList();

    final GuiWorkflow newWorkflow = GuiWorkflow.generateInitial(1L);

    final GuiWorkflowCreateRequest workflowReq = new GuiWorkflowCreateRequest(newWorkflow);

    map.put("users", userList);
    map.put("workflowTypes", workflowTypeList);
    map.put("workflowCreateRequest", workflowReq);

    final String resultAsXmlString = this.jsonConverter.getObjectMapper().writeValueAsString(map);

    Mockito.when(this.userAccess.getCompanyUserList(ArgumentMatchers.any(Long.class))).thenReturn(userList);
    Mockito.when(this.workflowHandler.readWorkflowTypeList(ArgumentMatchers.any(Long.class))).thenReturn(workflowTypeList);

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/workflow/data/workflowcreate/init");

    this.mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(resultAsXmlString));

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final GuiWorkflowCreateRequest createRequest = getTestGuiWorkflowCreateRequest();

    final String contentAsXmlString = this.jsonConverter.getObjectMapper().writeValueAsString(createRequest);

    Mockito.when(this.workflowHandler.createWorkflow(ArgumentMatchers.any(GuiWorkflowCreateRequest.class))).thenReturn(null);

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/workflow/data/workflowcreate/create")
                                                                        .content(contentAsXmlString)
                                                                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

    this.mockMvc.perform(builder)
                .andExpect(status().isCreated());

  }

}

package com.pth.iflow.gui.controller.data;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
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
import com.pth.iflow.gui.models.Department;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.Workflow;
import com.pth.iflow.gui.models.WorkflowSaveRequest;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
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
  private SessionUserInfo sessionUserInfo;

  @MockBean
  private IWorkflowHandler workflowHandler;

  @MockBean
  private IUserAccess userAccess;

  @Before
  public void setUp() throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();

    Mockito.when(this.sessionUserInfo.isValid()).thenReturn(true);
    Mockito.when(this.sessionUserInfo.getCompanyProfile()).thenReturn(this.getTestCompanyProfile());
    Mockito.when(this.sessionUserInfo.getUser()).thenReturn(this.getTestUser());
    Mockito.when(this.sessionUserInfo.getToken()).thenReturn("test-token");
    Mockito.when(this.sessionUserInfo.getSessionId()).thenReturn("test-sessionid");

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testLoadWorkflowInitialData() throws Exception {

    final List<WorkflowType> workflowTypeList = this.getTestWorkflowTypeList();

    Mockito.when(this.workflowHandler.readWorkflowTypeList(ArgumentMatchers.any(String.class))).thenReturn(workflowTypeList);

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/workflow/data/workflowlist/init");

    this.mockMvc.perform(builder).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

  }

  @Test
  public void testSearchWorkflows() throws Exception {

    final List<Workflow> resultList = this.getTestWorkflowList();

    final WorkflowSearchFilter workflowSearchFilter = this.getTestWorkflowSearchFilter();

    final String contentAsJsonString = this.jsonConverter.getObjectMapper().writeValueAsString(workflowSearchFilter);

    final String resultAsJsonString = this.jsonConverter.getObjectMapper().writeValueAsString(resultList);

    Mockito.when(this.workflowHandler.searchWorkflow(ArgumentMatchers.any(WorkflowSearchFilter.class))).thenReturn(resultList);

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/workflow/data/workflowlist/search")
                                                                        .content(contentAsJsonString)
                                                                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

    this.mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(resultAsJsonString));

  }

  @Test
  public void testListCompanyUsers() throws Exception {

    final List<User> userList = this.getTestUserList();

    final String resultAsJsonString = this.jsonConverter.getObjectMapper().writeValueAsString(userList);

    Mockito.when(this.userAccess.getCompanyUserList(ArgumentMatchers.any(String.class))).thenReturn(userList);

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/workflow/data/companyusers");

    this.mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(resultAsJsonString));

  }

  @Test
  public void testLoadWorkflowCreateData() throws Exception {

    final Map<String, Object> map = new HashMap<>();

    final List<User> userList = this.getTestUserList();
    final List<WorkflowType> workflowTypeList = this.getTestWorkflowTypeList();

    final Workflow newWorkflow = Workflow.generateInitial(sessionUserInfo.getUser().getIdentity());

    final WorkflowSaveRequest workflowReq = WorkflowSaveRequest.generateNewWihExpireDays(newWorkflow, 15);

    map.put("users", userList);
    map.put("workflowTypes", workflowTypeList);
    map.put("workflowCreateRequest", workflowReq);

    final String resultAsJsonString = this.jsonConverter.getObjectMapper().writeValueAsString(map);

    Mockito.when(this.userAccess.getCompanyUserList(ArgumentMatchers.any(String.class))).thenReturn(userList);
    Mockito.when(this.workflowHandler.readWorkflowTypeList(ArgumentMatchers.any(String.class))).thenReturn(workflowTypeList);

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/workflow/data/workflowcreate/init");

    this.mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(resultAsJsonString));

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final WorkflowSaveRequest createRequest = this.getTestWorkflowSaveRequest();

    final String contentAsJsonString = this.jsonConverter.getObjectMapper().writeValueAsString(createRequest);

    Mockito.when(this.workflowHandler.createWorkflow(ArgumentMatchers.any(WorkflowSaveRequest.class),
                                                     ArgumentMatchers.any(HttpSession.class)))
           .thenReturn(null);

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/workflow/data/workflowcreate/create")
                                                                        .content(contentAsJsonString)
                                                                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

    this.mockMvc.perform(builder).andExpect(status().isCreated());

  }

  @Test
  public void testLoadWorkflowEditData() throws Exception {

    final Map<String, Object> map = new HashMap<>();

    final List<User> userList = this.getTestUserList();
    final Workflow workflow = this.getTestWorkflow("workflow1");

    final WorkflowType workflowType = this.getTestWorkflowType();
    workflow.setWorkflowType(workflowType);
    workflow.setWorkflowTypeIdentity(workflowType.getIdentity());
    workflow.getActiveAction().setCurrentStep(this.getTestWorkflowTypeStep());
    workflow.getActiveAction().getCurrentStep().setExpireDays(15);

    final List<Department> departmentList = this.getTestDepartmentList();

    final WorkflowSaveRequest saveRequest = WorkflowSaveRequest.generateNewWihExpireDays(workflow, 15);

    map.put("users", userList);
    map.put("workflow", workflow);
    map.put("saveRequest", saveRequest);
    map.put("departments", departmentList);

    final String resultAsJsonString = this.jsonConverter.getObjectMapper().writeValueAsString(map);

    Mockito.when(this.userAccess.getCompanyUserList(ArgumentMatchers.any(String.class))).thenReturn(userList);
    Mockito.when(this.workflowHandler.readWorkflow(ArgumentMatchers.any(String.class))).thenReturn(workflow);
    Mockito.when(this.sessionUserInfo.getCompanyDepartments()).thenReturn(departmentList);

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/workflow/data/workflow/edit/1");

    this.mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(resultAsJsonString));

  }

}

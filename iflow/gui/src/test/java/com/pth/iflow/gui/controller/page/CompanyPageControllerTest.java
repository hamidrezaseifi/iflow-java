package com.pth.iflow.gui.controller.page;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.pth.iflow.gui.TestDataProducer;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.models.ui.GuiSessionUserInfo;
import com.pth.iflow.gui.services.IWorkflowHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyPageControllerTest extends TestDataProducer {

  private MockMvc               mockMvc;

  private GuiSessionUserInfo    userAdmin;

  @Autowired
  private WebApplicationContext context;

  @MockBean
  private GuiSessionUserInfo    sessionUserInfo;

  @MockBean
  private IWorkflowHandler      workflowHandler;

  @Before
  public void setUp() throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();

    this.userAdmin = this.createGuiSessionUserInfo();

    Mockito.when(this.sessionUserInfo.isValid()).thenReturn(true);
    Mockito.when(this.sessionUserInfo.getCompanyProfile()).thenReturn(this.getTestCompanyProfile());

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  @WithMockUser(value = "admin", roles = "ADMIN")
  public void testShowCompanyIndex() throws Exception {

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/companies/index")
        .sessionAttr(GuiSessionUserInfo.SESSION_LOGGEDUSERINFO_KEY, this.userAdmin);

    this.mockMvc.perform(builder).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"));

  }

  @Test
  @WithMockUser(value = "admin", roles = "ADMIN")
  public void testShowWorkflowTypeList() throws Exception {

    final List<GuiWorkflowType> workflowTypeList = this.getTestGuiWorkflowTypeList();

    Mockito.when(this.workflowHandler.readWorkflowTypeList(ArgumentMatchers.any(String.class))).thenReturn(workflowTypeList);

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/companies/workflowtype")
        .sessionAttr(GuiSessionUserInfo.SESSION_LOGGEDUSERINFO_KEY, this.userAdmin);

    this.mockMvc.perform(builder).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"));

  }

}

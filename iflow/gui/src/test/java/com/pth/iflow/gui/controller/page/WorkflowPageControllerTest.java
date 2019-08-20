package com.pth.iflow.gui.controller.page;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.pth.iflow.gui.TestDataProducer;
import com.pth.iflow.gui.models.ui.GuiSessionUserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowPageControllerTest extends TestDataProducer {

  private MockMvc mockMvc;

  private GuiSessionUserInfo userAdmin;

  @Autowired
  private WebApplicationContext context;

  @MockBean
  private GuiSessionUserInfo sessionUserInfo;

  @Before
  public void setUp() throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();

    this.userAdmin = createGuiSessionUserInfo();

    Mockito.when(this.sessionUserInfo.isValid()).thenReturn(true);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testShowWorkflowList() throws Exception {

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/workflow/list")
                                                                        .sessionAttr(GuiSessionUserInfo.SESSION_LOGGEDUSERINFO_KEY,
                                                                                     this.userAdmin);

    this.mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"));

  }

  @Test
  public void testShowWorkflowCreate() throws Exception {

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/workflow/create")
                                                                        .sessionAttr(GuiSessionUserInfo.SESSION_LOGGEDUSERINFO_KEY,
                                                                                     this.userAdmin);

    this.mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"));

  }

  @Test
  public void testShowWorkflowEdit() throws Exception {

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/workflow/create")
                                                                        .sessionAttr(GuiSessionUserInfo.SESSION_LOGGEDUSERINFO_KEY,
                                                                                     this.userAdmin);

    this.mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"));

  }

}

package com.pth.iflow.gui.controller.page;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.Cookie;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.pth.iflow.gui.TestDataProducer;
import com.pth.iflow.gui.configurations.GuiSecurityConfigurations;
import com.pth.iflow.gui.services.impl.MessagesHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationControllerTest extends TestDataProducer {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext context;

  @MockBean
  private MessagesHelper messages;

  @Before
  public void setUp() throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();

    Mockito.when(this.messages.get(ArgumentMatchers.any(String.class))).thenReturn("");

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testShowLogin() throws Exception {

    final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/auth/login")
                                                                        .cookie(new Cookie(GuiSecurityConfigurations.COMPANYINDICATOR_COOKIE_KEY,
                                                                                           ""));

    this.mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"));

  }

}

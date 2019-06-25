package com.pth.iflow.core.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Assert;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.service.IUsersService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;
  
  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;
  
  @Autowired
  private ObjectMapper mapper;
  
  @MockBean
  private IUsersService usersService;
  
  @Before
  public void setUp() throws Exception {
  }
  
  @After
  public void tearDown() throws Exception {
  }
  
  @Test
  public void testReadCompany() throws Exception {
    
    final User user = getTestUser();
    when(this.usersService.getUserById(any(Long.class))).thenReturn(user);

    final UserEdo userEdo = user.toEdo();
    
    final String userAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USER_READ_BY_ID, user.getId()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(userAsXmlString));
    
    verify(this.usersService, times(1)).getUserById(any(Long.class));

    final String userAsJsonString = this.mapper.writeValueAsString(userEdo);
    final MvcResult res = this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USER_READ_BY_ID + "?produces=json", user.getId()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(userAsJsonString))
        .andReturn();

    final String contentAsString = res.getResponse().getContentAsString();
    System.out.println(contentAsString);

    final UserEdo resUserEdo = this.mapper.readValue(contentAsString, UserEdo.class);

    Assert.assertNotNull("Result user is not null!", resUserEdo);
    Assert.assertEquals("Result user has id 1!", resUserEdo.getId(), (Long) 1L);
    Assert.assertEquals("Result user has companyName 'companyName'!", resUserEdo.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has identifyid 'identifyid'!", resUserEdo.getLastName(), user.getLastName());
    Assert.assertEquals("Result user has status 1!", resUserEdo.getStatus(), (Integer) 1);

  }
  
}

package com.pth.ifow.profile.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pth.iflow.common.edo.models.xml.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.edo.models.xml.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.xml.TokenProfileRequestEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.ifow.profile.TestDataProducer;
import com.pth.ifow.profile.model.Company;
import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.model.UserAuthenticationSession;
import com.pth.ifow.profile.service.ICompanyService;
import com.pth.ifow.profile.service.ISessionManager;
import com.pth.ifow.profile.service.IUsersService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProfileControllerTest extends TestDataProducer {
  
  @Autowired
  private MockMvc mockMvc;
  
  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;
  
  @Autowired
  private ObjectMapper mapper;
  
  @Autowired
  private ISessionManager sessionManager;

  @MockBean
  private IUsersService usersService;

  @MockBean
  private ICompanyService companyService;
  
  private UserAuthenticationSession authenticatedSession = null;

  private User user;

  private Company company;
  
  @Before
  public void setUp() throws Exception {
    
    this.authenticatedSession = this.sessionManager.addSession("email@test.de");

    this.user = getTestUser();
    this.company = getTestCompany();
    
    when(this.usersService.getUserByEmail(any(String.class))).thenReturn(this.user);
    when(this.companyService.getById(any(Long.class))).thenReturn(this.company);

  }
  
  @After
  public void tearDown() throws Exception {
  }
  
  @Test
  public void testReadAuthenticatedInfo() throws Exception {
    
    final AuthenticatedProfileRequestEdo profReq = getTestAuthenticatedProfileRequestEdo(this.authenticatedSession.getEmail(),
        this.authenticatedSession.getToken());

    final ProfileResponseEdo responseEdo = getTestProfileResponseEdo(this.authenticatedSession.getSessionid(), this.user.toEdo(),
        this.company.toEdo());
    
    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(profReq);
    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(responseEdo);
    
    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.ProfileModule.AUTHENTICATION_READ_AUTHENTOCATEDINFO).content(modelAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.authenticatedSession.getToken()))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));
    
    verify(this.usersService, times(1)).getUserByEmail(any(String.class));
    verify(this.companyService, times(1)).getById(any(Long.class));
    
    final String contentAsJsonString = this.mapper.writeValueAsString(profReq);
    final String responseAsJsonString = this.mapper.writeValueAsString(responseEdo);
    
    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.ProfileModule.AUTHENTICATION_READ_AUTHENTOCATEDINFO + "?produces=json")
            .content(contentAsJsonString).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.authenticatedSession.getToken()))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(responseAsJsonString));
    
  }

  @Test
  public void testReadTokenInfo() throws Exception {
    
    final TokenProfileRequestEdo tokenInoRequest = getTokenProfileRequestEdo(this.authenticatedSession.getToken());

    final ProfileResponseEdo responseEdo = getTestProfileResponseEdo(this.authenticatedSession.getSessionid(), this.user.toEdo(),
        this.company.toEdo());
    
    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(tokenInoRequest);
    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(responseEdo);
    
    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.ProfileModule.AUTHENTICATION_READ_TOKENINFO).content(modelAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.authenticatedSession.getToken()))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));
    
    verify(this.usersService, times(1)).getUserByEmail(any(String.class));
    verify(this.companyService, times(1)).getById(any(Long.class));
    
    final String contentAsJsonString = this.mapper.writeValueAsString(tokenInoRequest);
    final String responseAsJsonString = this.mapper.writeValueAsString(responseEdo);
    
    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.ProfileModule.AUTHENTICATION_READ_TOKENINFO + "?produces=json")
            .content(contentAsJsonString).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.authenticatedSession.getToken()))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(responseAsJsonString));
    
  }
  
}

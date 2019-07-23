package com.pth.iflow.profile.controller;

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

import com.pth.iflow.common.edo.models.xml.UserAuthenticationRequestEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.model.UserAuthenticationRequest;
import com.pth.iflow.profile.model.UserAuthenticationSession;
import com.pth.iflow.profile.service.IAuthenticationService;
import com.pth.iflow.profile.service.ISessionManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationControllerTest extends TestDataProducer {
  
  @Autowired
  private MockMvc mockMvc;
  
  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;
  
  @MockBean
  private IAuthenticationService authService;
  
  @MockBean
  private ISessionManager sessionManager;
  
  @Before
  public void setUp() throws Exception {
  }
  
  @After
  public void tearDown() throws Exception {
  }
  
  @Test
  public void testAuthenticate() throws Exception {
    
    final UserAuthenticationSession authenticationSession = getTestUserAuthenticationSession();
    final UserAuthenticationRequest authRes = getTestUserAuthenticationRequest();
    final UserAuthenticationRequest authRequest = getTestUserAuthenticationRequest();
    
    when(this.authService.authenticate(any(UserAuthenticationRequest.class))).thenReturn(authRes);
    when(this.sessionManager.findValidateByEmail(any(String.class), any(Boolean.class))).thenReturn(authenticationSession);
    
    final UserAuthenticationRequestEdo authRequestEdo = authRequest.toEdo();
    
    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(authRequestEdo);
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(authenticationSession.toEdo());
    
    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.ProfileModule.AUTHENTICATION_AUTHENTICATE).content(modelAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(status().isAccepted()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));
    
    verify(this.authService, times(1)).authenticate(any(UserAuthenticationRequest.class));
    verify(this.sessionManager, times(1)).findValidateByEmail(any(String.class), any(Boolean.class));
    
  }
  
}

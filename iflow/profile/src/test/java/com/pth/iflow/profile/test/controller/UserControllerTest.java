package com.pth.iflow.profile.test.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
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

import com.pth.iflow.common.models.edo.UserEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.CompanyProfile;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.access.IUsersAccessService;
import com.pth.iflow.profile.service.handler.ITokenUserDataManager;
import com.pth.iflow.profile.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private ITokenUserDataManager tokenUserDataManager;

  @MockBean
  private IUsersAccessService usersAccessService;

  private User user;

  private Company company;

  private CompanyProfile companyProfile;

  String TestToken = "test-roken";

  @Before
  public void setUp() throws Exception {

    this.user = this.getTestUser();
    this.company = this.getTestCompany();
    this.companyProfile = this.getTestCompanyProfile();

    // doNothing().when(this.tokenUserDataManager).validateToken(any(String.class));

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testReadUserByIdentity() throws Exception {

    final UserEdo userEdo = ProfileModelEdoMapper.toEdo(this.user);

    when(this.usersAccessService.getUserByIdentity(any(String.class))).thenReturn(this.user);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.ProfileModule.READ_USER_BY_IDENTITY_URIBUILDER("identity"))
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).validateToken(any(String.class));
    verify(this.usersAccessService, times(1)).getUserByIdentity(any(String.class));
  }

  @Test
  public void testSaveUser() throws Exception {

    final UserEdo userEdo = ProfileModelEdoMapper.toEdo(this.user);

    when(this.usersAccessService.saveUser(any(User.class))).thenReturn(this.user);

    final String requestAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdo);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.ProfileModule.SAVE_USER_URIBUILDER())
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken)
            .content(requestAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).validateToken(any(String.class));
    verify(this.usersAccessService, times(1)).saveUser(any(User.class));
  }

  @Test
  public void testDeleteUser() throws Exception {

    final UserEdo userEdo = ProfileModelEdoMapper.toEdo(this.user);
    final String requestAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdo);

    doNothing().when(this.usersAccessService).deleteUser(any(User.class));

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.ProfileModule.DELETE_USER_URIBUILDER())
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken)
            .content(requestAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(status().isAccepted());

    verify(this.tokenUserDataManager, times(1)).validateToken(any(String.class));
    verify(this.usersAccessService, times(1)).deleteUser(any(User.class));
  }

}

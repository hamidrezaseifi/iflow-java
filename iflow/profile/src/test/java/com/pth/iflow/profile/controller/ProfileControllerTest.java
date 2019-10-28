package com.pth.iflow.profile.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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

import com.pth.iflow.common.edo.models.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.edo.models.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.TokenProfileRequestEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserAuthenticationSession;
import com.pth.iflow.profile.model.UserGroup;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.ICompanyService;
import com.pth.iflow.profile.service.IDepartmentService;
import com.pth.iflow.profile.service.ISessionManager;
import com.pth.iflow.profile.service.IUserGroupService;
import com.pth.iflow.profile.service.IUsersService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProfileControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @Autowired
  private ISessionManager                        sessionManager;

  @MockBean
  private IUsersService                          usersService;

  @MockBean
  private ICompanyService                        companyService;

  @MockBean
  private IUserGroupService                      userGroupService;

  @MockBean
  private IDepartmentService                     departmentService;

  private UserAuthenticationSession              authenticatedSession = null;

  private User                                   user;

  private Company                                company;

  private List<Department>                       departmentList;

  private List<UserGroup>                        groupList;

  @Before
  public void setUp() throws Exception {

    this.authenticatedSession = this.sessionManager.addSession("email@test.de", "valid-company");

    this.user = this.getTestUser();
    this.company = this.getTestCompany();
    this.departmentList = this.getTestDepartmentList();
    this.groupList = this.getTestUserGroupList();

    when(this.usersService.getUserByEmail(any(String.class))).thenReturn(this.user);
    when(this.companyService.getByIdentity(any(String.class))).thenReturn(this.company);
    when(this.departmentService.getListByCompanyIdentity(any(String.class))).thenReturn(this.departmentList);
    when(this.userGroupService.getListByCompanyIdentity(any(String.class))).thenReturn(this.groupList);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadAuthenticatedInfo() throws Exception {

    final AuthenticatedProfileRequestEdo profReq = this
        .getTestAuthenticatedProfileRequestEdo(this.authenticatedSession.getUserIdentity(), this.authenticatedSession.getToken());

    final ProfileResponseEdo responseEdo = this.getTestProfileResponseEdo(this.authenticatedSession.getSessionid(),
        ProfileModelEdoMapper.toEdo(this.user), ProfileModelEdoMapper.toEdo(this.company));

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(profReq);
    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(responseEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.ProfileModule.PROFILE_READ_AUTHENTOCATEDINFO).content(modelAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.authenticatedSession.getToken()))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.usersService, times(1)).getUserByEmail(any(String.class));
    verify(this.companyService, times(1)).getByIdentity(any(String.class));

  }

  @Test
  public void testReadTokenInfo() throws Exception {

    final TokenProfileRequestEdo tokenInoRequest = this.getTokenProfileRequestEdo(this.authenticatedSession.getToken());

    final ProfileResponseEdo responseEdo = this.getTestProfileResponseEdo(this.authenticatedSession.getSessionid(),
        ProfileModelEdoMapper.toEdo(this.user), ProfileModelEdoMapper.toEdo(this.company));

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(tokenInoRequest);
    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(responseEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.ProfileModule.PROFILE_READ_TOKENINFO).content(modelAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.authenticatedSession.getToken()))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.usersService, times(1)).getUserByEmail(any(String.class));
    verify(this.companyService, times(1)).getByIdentity(any(String.class));

  }

}

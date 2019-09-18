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
import com.pth.iflow.common.edo.models.xml.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.edo.models.xml.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.xml.TokenProfileRequestEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserAuthenticationSession;
import com.pth.iflow.profile.model.UserGroup;
import com.pth.iflow.profile.model.mapper.ModelEdoMapper;
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
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @Autowired
  private ISessionManager sessionManager;

  @MockBean
  private IUsersService usersService;

  @MockBean
  private ICompanyService companyService;

  @MockBean
  private IUserGroupService userGroupService;

  @MockBean
  private IDepartmentService departmentService;

  private UserAuthenticationSession authenticatedSession = null;

  private User user;

  private Company company;

  private List<Department> departmentList;

  private List<UserGroup> groupList;

  @Before
  public void setUp() throws Exception {

    this.authenticatedSession = this.sessionManager.addSession("email@test.de");

    this.user = getTestUser();
    this.company = getTestCompany();
    this.departmentList = getTestDepartmentList();
    this.groupList = getTestUserGroupList();

    when(this.usersService.getUserByEmail(any(String.class))).thenReturn(this.user);
    when(this.companyService.getById(any(Long.class))).thenReturn(this.company);
    when(this.departmentService.getListByCompanyId(any(Long.class))).thenReturn(this.departmentList);
    when(this.userGroupService.getListByCompanyId(any(Long.class))).thenReturn(this.groupList);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadAuthenticatedInfo() throws Exception {

    final AuthenticatedProfileRequestEdo profReq = getTestAuthenticatedProfileRequestEdo(this.authenticatedSession.getEmail(),
                                                                                         this.authenticatedSession.getToken());

    final ProfileResponseEdo responseEdo = getTestProfileResponseEdo(this.authenticatedSession.getSessionid(),
                                                                     ModelEdoMapper.toEdo(this.user),
                                                                     ModelEdoMapper.toEdo(this.company));

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(profReq);
    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(responseEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.post(IflowRestPaths.ProfileModule.PROFILE_READ_AUTHENTOCATEDINFO)
                                               .content(modelAsXmlString)
                                               .contentType(MediaType.APPLICATION_XML_VALUE)
                                               .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY,
                                                       this.authenticatedSession.getToken()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(responseAsXmlString));

    verify(this.usersService, times(1)).getUserByEmail(any(String.class));
    verify(this.companyService, times(1)).getById(any(Long.class));

  }

  @Test
  public void testReadTokenInfo() throws Exception {

    final TokenProfileRequestEdo tokenInoRequest = getTokenProfileRequestEdo(this.authenticatedSession.getToken());

    final ProfileResponseEdo responseEdo = getTestProfileResponseEdo(this.authenticatedSession.getSessionid(),
                                                                     ModelEdoMapper.toEdo(this.user),
                                                                     ModelEdoMapper.toEdo(this.company));

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(tokenInoRequest);
    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(responseEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.post(IflowRestPaths.ProfileModule.PROFILE_READ_TOKENINFO)
                                               .content(modelAsXmlString)
                                               .contentType(MediaType.APPLICATION_XML_VALUE)
                                               .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY,
                                                       this.authenticatedSession.getToken()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(responseAsXmlString));

    verify(this.usersService, times(1)).getUserByEmail(any(String.class));
    verify(this.companyService, times(1)).getById(any(Long.class));

  }

}

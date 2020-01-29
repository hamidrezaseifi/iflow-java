package com.pth.iflow.core.controllers;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pth.iflow.common.models.edo.DepartmentEdo;
import com.pth.iflow.common.models.edo.DepartmentListEdo;
import com.pth.iflow.common.models.edo.ProfileResponseEdo;
import com.pth.iflow.common.models.edo.UserEdo;
import com.pth.iflow.common.models.edo.UserGroupEdo;
import com.pth.iflow.common.models.edo.UserGroupListEdo;
import com.pth.iflow.common.models.edo.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.service.interfaces.IDepartmentService;
import com.pth.iflow.core.service.interfaces.IUserGroupService;
import com.pth.iflow.core.service.interfaces.IUsersService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IUsersService usersService;

  @MockBean
  private IUserGroupService userGroupService;

  @MockBean
  private IDepartmentService departmentService;

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String innerModulesRequestHeaderValue;

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testReadUserById() throws Exception {

    final UserEntity user = this.getTestUser();
    final UserEdo userEdo = getTestUserEdo();

    when(this.usersService.getUserByIdentity(any(String.class))).thenReturn(user);
    when(this.usersService.toEdo(any(UserEntity.class))).thenReturn(userEdo);

    final String userAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.CoreModule.USER_READ_BY_IDENTITY, user.getEmail())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(userAsXmlString));

    verify(this.usersService, times(1)).getUserByIdentity(any(String.class));

  }

  @Test
  public void testReadUserByEmail() throws Exception {

    final UserEntity user = this.getTestUser();
    final UserEdo userEdo = getTestUserEdo();
    when(this.usersService.getUserByIdentity(any(String.class))).thenReturn(user);
    when(this.usersService.toEdo(any(UserEntity.class))).thenReturn(userEdo);

    final String userAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.CoreModule.USER_READ_BY_IDENTITY, user.getEmail())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(content().xml(userAsXmlString));

    verify(this.usersService, times(1)).getUserByIdentity(any(String.class));

  }

  @Test
  public void testReadUserDepartments() throws Exception {

    final List<DepartmentEntity> list = this.getTestDepartmentList();
    final List<DepartmentEdo> mappedEdolist = this.getTestDepartmentEdoList();

    when(this.usersService.getUserDepartments(any(String.class))).thenReturn(list);
    when(this.departmentService.toEdoList(any(List.class))).thenReturn(mappedEdolist);

    final DepartmentListEdo edoList = new DepartmentListEdo(mappedEdolist);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.CoreModule.USER_DEPARTMENTS_LIST_BY_IDENTITY, "useridentity")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getUserDepartments(any(String.class));

  }

  @Test
  public void testReadUserGroups() throws Exception {

    final List<UserGroupEntity> list = this.getTestUserGroupList();
    final List<UserGroupEdo> mappedEdolist = getTestUserGroupEdoList();

    when(this.usersService.getUserGroups(any(String.class))).thenReturn(list);
    when(this.userGroupService.toEdoList(any(List.class))).thenReturn(mappedEdolist);

    final UserGroupListEdo edoList = new UserGroupListEdo(mappedEdolist);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.CoreModule.USER_USERGROUPS_LIST_BY_IDENTITY, "useridentity")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getUserGroups(any(String.class));

  }

  @Test
  public void testReadUserDeputies() throws Exception {

    final List<UserEntity> list = this.getTestUserList();
    final List<UserEdo> mappedEdolist = this.getTestUserEdoList();

    when(this.usersService.getUserDeputies(any(String.class))).thenReturn(list);
    when(this.usersService.toEdoList(any(List.class))).thenReturn(mappedEdolist);

    final UserListEdo listEdo = new UserListEdo();
    listEdo.setUsers(mappedEdolist);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.CoreModule.USER_DEPUTIES_LIST_BY_IDENTITY, "useridentity")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getUserDeputies(any(String.class));

  }

  @Test
  public void testReadCompanyUsers() throws Exception {

    final List<UserEntity> list = this.getTestUserList();
    final List<UserEdo> mappedEdolist = this.getTestUserEdoList();

    when(this.usersService.getCompanyUsers(any(String.class))).thenReturn(list);
    when(this.usersService.toEdoList(any(List.class))).thenReturn(mappedEdolist);

    final UserListEdo listEdo = new UserListEdo();
    listEdo.setUsers(mappedEdolist);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.CoreModule.USER_USER_LIST_BY_COMPANYIDENTITY, "companyidentity")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getCompanyUsers(any(String.class));

  }

  @Test
  public void testReadDepartmentUsers() throws Exception {

    final List<UserEntity> list = this.getTestUserList();
    final List<UserEdo> mappedEdolist = this.getTestUserEdoList();
    when(this.usersService.getAllUserIdentityListByDepartmentIdentity(any(String.class))).thenReturn(list);
    when(this.usersService.toEdoList(any(List.class))).thenReturn(mappedEdolist);

    final UserListEdo listEdo = new UserListEdo();
    listEdo.setUsers(mappedEdolist);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.CoreModule.USER_USER_LIST_BY_DEPARTMENTIDENTITY, "companyidentity")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getAllUserIdentityListByDepartmentIdentity(any(String.class));

  }

  @Test
  public void testReadUserProfileByEmail() throws Exception {

    final ProfileResponse profile = this.getTestProfileResponse();
    final ProfileResponseEdo edo = getTestProfileResponseEdo();

    when(this.usersService.getProfileResponseByEmail(any(String.class))).thenReturn(profile);
    when(this.usersService.toProfileResponseEdo(any(ProfileResponse.class))).thenReturn(edo);

    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.CoreModule.USERPROFILE_READ_BY_EMAIL, "identity")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.usersService, times(1)).getProfileResponseByEmail(any(String.class));

  }

}

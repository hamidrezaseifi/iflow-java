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

import com.pth.iflow.common.edo.models.DepartmentGroupListEdo;
import com.pth.iflow.common.edo.models.DepartmentListEdo;
import com.pth.iflow.common.edo.models.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.edo.models.UserGroupListEdo;
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.interfaces.IUsersService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IUsersService                          usersService;

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String                                 innerModulesRequestHeaderValue;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadUserById() throws Exception {

    final UserEntity user = this.getTestUser();
    when(this.usersService.getUserByIdentity(any(String.class))).thenReturn(user);

    final UserEdo userEdo = CoreModelEdoMapper.toEdo(user);

    final String userAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_READ_BY_EMAIL, user.getEmail())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(userAsXmlString));

    verify(this.usersService, times(1)).getUserByIdentity(any(String.class));

  }

  @Test
  public void testReadUserByEmail() throws Exception {

    final UserEntity user = this.getTestUser();
    when(this.usersService.getUserByIdentity(any(String.class))).thenReturn(user);

    final UserEdo userEdo = CoreModelEdoMapper.toEdo(user);

    final String userAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_READ_BY_EMAIL, user.getEmail())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(content().xml(userAsXmlString));

    verify(this.usersService, times(1)).getUserByIdentity(any(String.class));

  }

  @Test
  public void testReadUserDepartments() throws Exception {

    final List<DepartmentEntity> list = this.getTestDepartmentList();
    when(this.usersService.getUserDepartments(any(String.class))).thenReturn(list);

    final DepartmentListEdo edoList = new DepartmentListEdo(CoreModelEdoMapper.toDepartmentEdoList(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_DEPARTMENTS_LIST_BY_EMAIL, "email")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getUserDepartments(any(String.class));

  }

  @Test
  public void testReadUserDepartmentGroups() throws Exception {

    final List<DepartmentGroupEntity> list = this.getTestDepartmentGroupList();
    when(this.usersService.getUserDepartmentGroups(any(String.class))).thenReturn(list);

    final DepartmentGroupListEdo edoList = new DepartmentGroupListEdo(CoreModelEdoMapper.toDepartmentGroupEdoList(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_DEPARTMENTGROUPS_LIST_BY_EMAIL, "email")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getUserDepartmentGroups(any(String.class));

  }

  @Test
  public void testReadUserGroups() throws Exception {

    final List<UserGroupEntity> list = this.getTestUserGroupList();
    when(this.usersService.getUserGroups(any(String.class))).thenReturn(list);

    final UserGroupListEdo edoList = new UserGroupListEdo(CoreModelEdoMapper.toUserGroupEdoList(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_USERGROUPS_LIST_BY_EMAIL, "email")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getUserGroups(any(String.class));

  }

  @Test
  public void testReadUserDeputies() throws Exception {

    final List<UserEntity> list = this.getTestUserList();
    when(this.usersService.getUserDeputies(any(String.class))).thenReturn(list);

    final UserListEdo listEdo = new UserListEdo();
    listEdo.setUsers(CoreModelEdoMapper.toUserEdoList(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_DEPUTIES_LIST_BY_EMAIL, "email")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getUserDeputies(any(String.class));

  }

  @Test
  public void testReadCompanyUsers() throws Exception {

    final List<UserEntity> list = this.getTestUserList();
    when(this.usersService.getCompanyUsers(any(String.class))).thenReturn(list);

    final UserListEdo listEdo = new UserListEdo();
    listEdo.setUsers(CoreModelEdoMapper.toUserEdoList(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_USER_LIST_BY_COMPANYIDENTITY, "companyidentity")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getCompanyUsers(any(String.class));

  }

  @Test
  public void testReadDepartmentUsers() throws Exception {

    final List<UserEntity> list = this.getTestUserList();
    when(this.usersService.getAllUserIdentityListByDepartmentIdentity(any(String.class))).thenReturn(list);

    final UserListEdo listEdo = new UserListEdo();
    listEdo.setUsers(CoreModelEdoMapper.toUserEdoList(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_USER_LIST_BY_DEPARTMENTIDENTITY, "companyidentity")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getAllUserIdentityListByDepartmentIdentity(any(String.class));

  }

  @Test
  public void testReadDepartmentGroupUsers() throws Exception {

    final List<UserEntity> list = this.getTestUserList();
    when(this.usersService.getAllUserIdentityListByDepartmentGroupIdentity(any(String.class))).thenReturn(list);

    final UserListEdo listEdo = new UserListEdo();
    listEdo.setUsers(CoreModelEdoMapper.toUserEdoList(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_USER_LIST_BY_DEPARTMENTGROUPIDENTITY, "companyidentity")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getAllUserIdentityListByDepartmentGroupIdentity(any(String.class));

  }

  @Test
  public void testReadUserProfileByEmail() throws Exception {

    final ProfileResponse profile = this.getTestProfileResponse();
    when(this.usersService.getProfileResponseByEmail(any(String.class))).thenReturn(profile);

    final ProfileResponseEdo edo = CoreModelEdoMapper.toEdo(profile);

    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USERPROFILE_READ_BY_EMAIL, "useridentity")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.usersService, times(1)).getProfileResponseByEmail(any(String.class));

  }

}

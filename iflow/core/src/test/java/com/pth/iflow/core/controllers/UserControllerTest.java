package com.pth.iflow.core.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Set;

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
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.edo.models.UserGroupListEdo;
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.IUsersService;

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

    final User user = this.getTestUser();
    when(this.usersService.getUserById(any(Long.class))).thenReturn(user);

    final UserEdo userEdo = CoreModelEdoMapper.toEdo(user);

    final String userAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_READ_BY_ID, user.getId())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(userAsXmlString));

    verify(this.usersService, times(1)).getUserById(any(Long.class));

  }

  @Test
  public void testReadUserByEmail() throws Exception {

    final User user = this.getTestUser();
    when(this.usersService.getUserByEmail(any(String.class))).thenReturn(user);

    final UserEdo userEdo = CoreModelEdoMapper.toEdo(user);

    final String userAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_READ_BY_EMAIL, user.getEmail())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(content().xml(userAsXmlString));

    verify(this.usersService, times(1)).getUserByEmail(any(String.class));

  }

  @Test
  public void testReadUserDepartments() throws Exception {

    final Set<Department> list = this.getTestDepartmentList();
    when(this.usersService.getUserDepartments(any(Long.class))).thenReturn(list);

    final DepartmentListEdo edoList = new DepartmentListEdo(CoreModelEdoMapper.toDepartmentEdoSet(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_DEPARTMENTS_LIST, 1L)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getUserDepartments(any(Long.class));

  }

  @Test
  public void testReadUserDepartmentGroups() throws Exception {

    final Set<DepartmentGroup> list = this.getTestDepartmentGroupList();
    when(this.usersService.getUserDepartmentGroups(any(Long.class))).thenReturn(list);

    final DepartmentGroupListEdo edoList = new DepartmentGroupListEdo(CoreModelEdoMapper.toDepartmentGroupEdoSet(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_DEPARTMENTGROUPS_LIST, 1L)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getUserDepartmentGroups(any(Long.class));

  }

  @Test
  public void testReadUserGroups() throws Exception {

    final Set<UserGroup> list = this.getTestUserGroupList();
    when(this.usersService.getUserGroups(any(Long.class))).thenReturn(list);

    final UserGroupListEdo edoList = new UserGroupListEdo(CoreModelEdoMapper.toUserGroupEdoSet(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_USERGROUPS_LIST, 1L)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getUserGroups(any(Long.class));

  }

  @Test
  public void testReadUserDeputies() throws Exception {

    final Set<User> list = this.getTestUserList();
    when(this.usersService.getUserDeputies(any(Long.class))).thenReturn(list);

    final UserListEdo listEdo = new UserListEdo();
    listEdo.setUsers(CoreModelEdoMapper.toUserEdoSet(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_DEPUTIES_LIST, 1L)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getUserDeputies(any(Long.class));

  }

  @Test
  public void testReadCompanyUsers() throws Exception {

    final Set<User> list = this.getTestUserList();
    when(this.usersService.getCompanyUsers(any(Long.class))).thenReturn(list);

    final UserListEdo listEdo = new UserListEdo();
    listEdo.setUsers(CoreModelEdoMapper.toUserEdoSet(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.USER_USER_LIST_BY_COMPANY, 1L)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.usersService, times(1)).getCompanyUsers(any(Long.class));

  }

}

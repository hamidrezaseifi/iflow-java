package com.pth.iflow.core.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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
import com.pth.iflow.common.edo.models.DepartmentEdo;
import com.pth.iflow.common.edo.models.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;
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
  public void testReadUserById() throws Exception {
    
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

    final UserEdo resUserEdo = this.mapper.readValue(contentAsString, UserEdo.class);

    Assert.assertNotNull("Result user is not null!", resUserEdo);
    Assert.assertEquals("Result user has id 1!", resUserEdo.getId(), (Long) 1L);
    Assert.assertEquals("Result user has companyName 'companyName'!", resUserEdo.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has identifyid 'identifyid'!", resUserEdo.getLastName(), user.getLastName());
    Assert.assertEquals("Result user has status 1!", resUserEdo.getStatus(), (Integer) 1);

  }
  
  @Test
  public void testReadUserByEmail() throws Exception {
    
    final User user = getTestUser();
    when(this.usersService.getUserByEmail(any(String.class))).thenReturn(user);

    final UserEdo userEdo = user.toEdo();
    
    final String userAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USER_READ_BY_EMAIL, user.getEmail()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(userAsXmlString));
    
    verify(this.usersService, times(1)).getUserByEmail(any(String.class));

    final String userAsJsonString = this.mapper.writeValueAsString(userEdo);
    final MvcResult res = this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USER_READ_BY_EMAIL + "?produces=json", user.getEmail()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(userAsJsonString))
        .andReturn();

    final String contentAsString = res.getResponse().getContentAsString();

    final UserEdo resUserEdo = this.mapper.readValue(contentAsString, UserEdo.class);

    Assert.assertNotNull("Result user is not null!", resUserEdo);
    Assert.assertEquals("Result user has id 1!", resUserEdo.getId(), (Long) 1L);
    Assert.assertEquals("Result user has companyName 'companyName'!", resUserEdo.getFirstName(), user.getFirstName());
    Assert.assertEquals("Result user has identifyid 'identifyid'!", resUserEdo.getLastName(), user.getLastName());
    Assert.assertEquals("Result user has status 1!", resUserEdo.getStatus(), (Integer) 1);

  }

  @Test
  public void testReadUserDepartments() throws Exception {

    final List<Department> list = getTestDepartmentList();
    when(this.usersService.getUserDepartments(any(Long.class))).thenReturn(list);

    final List<DepartmentEdo> edoList = Department.toEdoList(list);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList).replace("ArrayList", "List");

    final MvcResult res = this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USER_DEPARTMENTS_LIST, 1L))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString))
        .andReturn();

    final String contentAsString = res.getResponse().getContentAsString();

    verify(this.usersService, times(1)).getUserDepartments(any(Long.class));

    final String listAsJsonString = this.mapper.writeValueAsString(edoList);
    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USER_DEPARTMENTS_LIST + "?produces=json", 1L))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(listAsJsonString));

  }

  @Test
  public void testReadUserDepartmentGroups() throws Exception {
    
    final List<DepartmentGroup> list = getTestDepartmentGroupList();
    when(this.usersService.getUserDepartmentGroups(any(Long.class))).thenReturn(list);

    final List<DepartmentGroupEdo> edoList = DepartmentGroup.toEdoList(list);
    
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList).replace("ArrayList", "List");

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USER_DEPARTMENTGROUPS_LIST, 1L))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));
    
    verify(this.usersService, times(1)).getUserDepartmentGroups(any(Long.class));

    final String listAsJsonString = this.mapper.writeValueAsString(edoList);
    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USER_DEPARTMENTGROUPS_LIST + "?produces=json", 1L))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(listAsJsonString));
    
  }

  @Test
  public void testReadUserGroups() throws Exception {
    
    final List<UserGroup> list = getTestUserGroupList();
    when(this.usersService.getUserGroups(any(Long.class))).thenReturn(list);

    final List<UserGroupEdo> edoList = UserGroup.toEdoList(list);
    
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList).replace("ArrayList", "List");

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USER_USERGROUPS_LIST, 1L))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));
    
    verify(this.usersService, times(1)).getUserGroups(any(Long.class));

    final String listAsJsonString = this.mapper.writeValueAsString(edoList);
    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USER_USERGROUPS_LIST + "?produces=json", 1L))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(listAsJsonString));
    
  }

  @Test
  public void testReadUserDeputies() throws Exception {
    
    final List<User> list = getTestUserList();
    when(this.usersService.getUserDeputies(any(Long.class))).thenReturn(list);

    final List<UserEdo> edoList = UserGroup.toEdoList(list);
    
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList).replace("ArrayList", "List");

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USER_DEPUTIES_LIST, 1L))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));
    
    verify(this.usersService, times(1)).getUserDeputies(any(Long.class));

    final String listAsJsonString = this.mapper.writeValueAsString(edoList);
    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USER_DEPUTIES_LIST + "?produces=json", 1L))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(listAsJsonString));
    
  }

}

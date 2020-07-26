package com.pth.iflow.profile.test.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pth.iflow.common.models.edo.DepartmentEdo;
import com.pth.iflow.common.models.edo.UserListEdo;
import com.pth.iflow.common.moduls.security.RestAccessRoles;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.handler.IDepartmentsHandlerService;
import com.pth.iflow.profile.service.handler.ITokenUserDataManager;
import com.pth.iflow.profile.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private ITokenUserDataManager tokenUserDataManager;

  @MockBean
  private IDepartmentsHandlerService departmentsHandlerService;

  String TestToken = "test-roken";

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = RestAccessRoles.General.USER_ROLE)
  public void testReadById() throws Exception {

    final Department department = this.getTestDepartment("dep1", "department 1");
    final DepartmentEdo departmentEdo = ProfileModelEdoMapper.toEdo(department);

    when(this.departmentsHandlerService.getDepartmentByIdentity(any(String.class))).thenReturn(department);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(departmentEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.ProfileModule.READ_DEPARTMENT_BY_ID_URIBUILDER("ident1")))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.departmentsHandlerService, times(1)).getDepartmentByIdentity(any(String.class));

  }

  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = RestAccessRoles.General.USER_ROLE)
  public void testReadUserList() throws Exception {

    final List<User> userList = this.getTestUserList();
    final UserListEdo userEdoList = new UserListEdo(ProfileModelEdoMapper.toUserEdoList(userList));

    when(this.tokenUserDataManager.getAllUserListByDepartmentId(any(), any(String.class))).thenReturn(userList);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.ProfileModule.READ_ALLUSERS_BY_DEPARTMENTID_URIBUILDER("identity2")))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).getAllUserListByDepartmentId(any(), any(String.class));
  }

  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = RestAccessRoles.Departments.DEPARTMENTS_SAVE)
  public void testSaveDepartment() throws Exception {

    final Department department = this.getTestDepartment("dep1", "department 1");
    final DepartmentEdo departmentEdo = ProfileModelEdoMapper.toEdo(department);

    when(this.departmentsHandlerService.saveDepartment(any(Department.class))).thenReturn(department);

    final String requestAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(departmentEdo);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(departmentEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.ProfileModule.SAVE_DEPARTMENT_URIBUILDER())

            .content(requestAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.departmentsHandlerService, times(1)).saveDepartment(any(Department.class));
  }

  @Test
  @WithMockUser(username = "user1", password = "pwd", roles = RestAccessRoles.Departments.DEPARTMENTS_DELETE)
  public void testDeleteDepartment() throws Exception {

    final Department department = this.getTestDepartment("dep1", "department 1");
    final DepartmentEdo departmentEdo = ProfileModelEdoMapper.toEdo(department);
    final String requestAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(departmentEdo);

    doNothing().when(this.departmentsHandlerService).deleteDepartment(any(Department.class));

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.ProfileModule.DELETE_DEPARTMENT_URIBUILDER())

            .content(requestAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(status().isAccepted());

    verify(this.departmentsHandlerService, times(1)).deleteDepartment(any(Department.class));
  }

}

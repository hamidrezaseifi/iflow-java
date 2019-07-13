package com.pth.ifow.profile.controller;

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

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.DepartmentEdo;
import com.pth.iflow.common.edo.models.xml.DepartmentGroupListEdo;
import com.pth.iflow.common.edo.models.xml.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.ifow.profile.TestDataProducer;
import com.pth.ifow.profile.model.Department;
import com.pth.ifow.profile.model.DepartmentGroup;
import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.service.ITokenUserDataManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private ITokenUserDataManager                  tokenUserDataManager;

  String                                         TestToken = "test-roken";

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadById() throws Exception {

    final Department department = this.getTestDepartment();
    final DepartmentEdo departmentEdo = department.toEdo();

    when(this.tokenUserDataManager.getDepartmentById(any(String.class), any(Long.class))).thenReturn(department);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(departmentEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.ProfileModule.DEPARTMENT_READ_BY_ID, 1L)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).getDepartmentById(any(String.class), any(Long.class));
  }

  @Test
  public void testReadDepartmentGroupList() throws Exception {

    final List<DepartmentGroup> departmentGroupList = this.getTestDepartmentGroupList();
    final DepartmentGroupListEdo departmentGroupListEdo = new DepartmentGroupListEdo(ModelMapperBase.toEdoList(departmentGroupList));

    when(this.tokenUserDataManager.getDepartmentGroupListByDepartmentId(any(String.class), any(Long.class)))
        .thenReturn(departmentGroupList);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(departmentGroupListEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.ProfileModule.DEPARTMENT_READ_DEPARTMENTGROUP_LIST, 1L)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).getDepartmentGroupListByDepartmentId(any(String.class), any(Long.class));
  }

  @Test
  public void testReadUserList() throws Exception {

    final List<User> userList = this.getTestUserList();
    final UserListEdo userEdoList = new UserListEdo(ModelMapperBase.toEdoList(userList));

    when(this.tokenUserDataManager.getAllUserListByDepartmentId(any(String.class), any(Long.class))).thenReturn(userList);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.ProfileModule.DEPARTMENT_READ_ALLUSERS_LIST, 1L)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).getAllUserListByDepartmentId(any(String.class), any(Long.class));
  }

}

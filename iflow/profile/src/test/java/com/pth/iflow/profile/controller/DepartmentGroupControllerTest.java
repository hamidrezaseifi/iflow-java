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

import com.pth.iflow.common.edo.models.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.model.DepartmentGroup;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.ITokenUserDataManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentGroupControllerTest extends TestDataProducer {

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

    final DepartmentGroup departmentGroup = this.getTestDepartmentGroup("depgrp1", "deparment-grp 1");
    final DepartmentGroupEdo departmentGroupEdo = ProfileModelEdoMapper.toEdo(departmentGroup);

    when(this.tokenUserDataManager.getDepartmentGroupById(any(String.class), any(String.class))).thenReturn(departmentGroup);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(departmentGroupEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.ProfileModule.READ_DEPARTMENTGROUP_BY_ID_URIBUILDER("identity"))
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).getDepartmentGroupById(any(String.class), any(String.class));
  }

  @Test
  public void testReadUserList() throws Exception {

    final List<User> userList = this.getTestUserList();
    final UserListEdo userEdoList = new UserListEdo(ProfileModelEdoMapper.toUserEdoList(userList));

    when(this.tokenUserDataManager.getAllUserListByDepartmentGroupId(any(String.class), any(String.class))).thenReturn(userList);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.ProfileModule.READ_ALLUSERS_BY_DEPARTMENTGROUPID_URIBUILDER("identity"))
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).getAllUserListByDepartmentGroupId(any(String.class), any(String.class));
  }

}

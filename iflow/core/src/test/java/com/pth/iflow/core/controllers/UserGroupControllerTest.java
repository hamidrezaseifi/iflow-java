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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.service.IUserGroupService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserGroupControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;
  
  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;
  
  @Autowired
  private ObjectMapper mapper;
  
  @MockBean
  private IUserGroupService userGroupService;
  
  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String innerModulesRequestHeaderValue;

  @Before
  public void setUp() throws Exception {
  }
  
  @After
  public void tearDown() throws Exception {
  }
  
  @Test
  public void testReadUserGroupById() throws Exception {
    
    final UserGroup model = getTestUserGroup();
    when(this.userGroupService.getById(any(Long.class))).thenReturn(model);

    final UserGroupEdo modelEdo = model.toEdo();
    
    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USERGROUP_READ_BY_ID, model.getId())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(modelAsXmlString));
    
    verify(this.userGroupService, times(1)).getById(any(Long.class));

    final String modelAsJsonString = this.mapper.writeValueAsString(modelEdo);
    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USERGROUP_READ_BY_ID + "?produces=json", model.getId())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(modelAsJsonString));
    
  }

  @Test
  public void testReadUserGroupList() throws Exception {

    final List<Long> idList = getTestUserGroupIdList();
    final List<UserGroup> list = getTestUserGroupList();
    when(this.userGroupService.getListByIdList(any(List.class))).thenReturn(list);

    final List<UserGroupEdo> edoList = UserGroup.toEdoList(list);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(idList).replace("ArrayList", "List");
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList).replace("ArrayList", "List");

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModul.USERGROUP_READ_LIST)
            .content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE).header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.userGroupService, times(1)).getListByIdList(any(List.class));

    final String contentAsJsonString = this.mapper.writeValueAsString(idList);
    final String listAsJsonString = this.mapper.writeValueAsString(edoList);

    this.mockMvc
        .perform(
            MockMvcRequestBuilders.post(IflowRestPaths.CoreModul.USERGROUP_READ_LIST + "?produces=json")
                .content(contentAsJsonString)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(listAsJsonString));

  }

  @Test
  public void testReadUserGroupListByCompany() throws Exception {

    final List<UserGroup> list = getTestUserGroupList();
    when(this.userGroupService.getListByIdCompanyId(any(Long.class))).thenReturn(list);

    final List<UserGroupEdo> edoList = UserGroup.toEdoList(list);

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList).replace("ArrayList", "List");

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USERGROUP_READ_LIST_BY_COMPANY, 1L)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));
    
    verify(this.userGroupService, times(1)).getListByIdCompanyId(any(Long.class));

    final String listAsJsonString = this.mapper.writeValueAsString(edoList);
    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.USERGROUP_READ_LIST_BY_COMPANY + "?produces=json", 1L)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(listAsJsonString));

  }
  
}
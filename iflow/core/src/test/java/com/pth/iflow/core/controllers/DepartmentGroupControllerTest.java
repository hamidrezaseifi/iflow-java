package com.pth.iflow.core.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
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
import com.pth.iflow.common.edo.models.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.DepartmentGroupListEdo;
import com.pth.iflow.common.edo.models.IdentityListEdo;
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.IDepartmentGroupService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentGroupControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IDepartmentGroupService departmentGroupService;

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String innerModulesRequestHeaderValue;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadDepartmentGroupById() throws Exception {

    final DepartmentGroupEntity model = this.getTestDepartmentGroup();
    when(this.departmentGroupService.getByIdentity(any(String.class))).thenReturn(model);

    final DepartmentGroupEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_BY_IDENTITY, model.getIdentity())
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(modelAsXmlString));

    verify(this.departmentGroupService, times(1)).getByIdentity(any(String.class));

  }

  @Test
  public void testReadDepartmentGroupList() throws Exception {

    final Set<String> idList = this.getTestDepartmentGroupIdSet();
    final IdentityListEdo edoList = new IdentityListEdo(idList);
    final List<DepartmentGroupEntity> list = this.getTestDepartmentGroupList();

    when(this.departmentGroupService.getListByIdentityList(any(Set.class))).thenReturn(list);

    final DepartmentGroupListEdo edoResultList = new DepartmentGroupListEdo(CoreModelEdoMapper.toDepartmentGroupEdoList(list));

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoResultList);

    this.mockMvc
                .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_LIST)
                                               .content(contentAsXmlString)
                                               .contentType(MediaType.APPLICATION_XML_VALUE)
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.departmentGroupService, times(1)).getListByIdentityList(any(Set.class));

  }

  @Test
  public void testReadDepartmentGroupListByCompany() throws Exception {

    final List<DepartmentGroupEntity> list = this.getTestDepartmentGroupList();
    when(this.departmentGroupService.getListByDepartmentIdentity(any(String.class))).thenReturn(list);

    final DepartmentGroupListEdo edoList = new DepartmentGroupListEdo(CoreModelEdoMapper.toDepartmentGroupEdoList(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList).replace("ArrayList", "Set");

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_LIST_BY_DEPARTMENTIDENTITY, "identity")
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.departmentGroupService, times(1)).getListByDepartmentIdentity(any(String.class));

  }

  @Test
  public void testReadAllUserListByDepartmentGroup() throws Exception {

    final List<User> list = this.getTestUserList();
    when(this.departmentGroupService.getAllUserListByDepartmentGroupId(any(String.class))).thenReturn(list);

    final UserListEdo edoList = new UserListEdo(CoreModelEdoMapper.toUserEdoList(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
                .perform(MockMvcRequestBuilders
                                               .get(IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_ALLUSERLIST_BY_DEPARTMENTGROUPIDENTITY,
                                                    "identity")
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.departmentGroupService, times(1)).getAllUserListByDepartmentGroupId(any(String.class));

  }

}

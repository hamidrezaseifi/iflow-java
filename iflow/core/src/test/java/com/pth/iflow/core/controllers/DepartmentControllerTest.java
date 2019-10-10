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
import com.pth.iflow.common.edo.models.DepartmentEdo;
import com.pth.iflow.common.edo.models.DepartmentListEdo;
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.IDepartmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

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
  public void testReadDepartmentById() throws Exception {

    final Department model = this.getTestDepartment();
    when(this.departmentService.getById(any(Long.class))).thenReturn(model);

    final DepartmentEdo modelEdo = CoreModelEdoMapper.toEdo(model);

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.DEPARTMENT_READ_BY_ID, model.getId())
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(modelAsXmlString));

    verify(this.departmentService, times(1)).getById(any(Long.class));

  }

  @Test
  public void testReadDepartmentList() throws Exception {

    final Set<String> idList = this.getTestDepartmentIdSet();
    final List<Department> list = this.getTestDepartmentList();
    when(this.departmentService.getListByIdentityList(any(Set.class))).thenReturn(list);

    final DepartmentListEdo edoList = new DepartmentListEdo(CoreModelEdoMapper.toDepartmentEdoList(list));

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(idList);
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
                .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.DEPARTMENT_READ_LIST)
                                               .content(contentAsXmlString)
                                               .contentType(MediaType.APPLICATION_XML_VALUE)
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.departmentService, times(1)).getListByIdentityList(any(Set.class));

  }

  @Test
  public void testReadDepartmentListByCompany() throws Exception {

    final List<Department> list = this.getTestDepartmentList();
    when(this.departmentService.getListByIdCompanyId(any(Long.class))).thenReturn(list);

    final DepartmentListEdo edoList = new DepartmentListEdo(CoreModelEdoMapper.toDepartmentEdoList(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.DEPARTMENT_READ_LIST_BY_COMPANY, 1L)
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.departmentService, times(1)).getListByIdCompanyId(any(Long.class));

  }

  @Test
  public void testReadAllUserListByDepartmentGroup() throws Exception {

    final List<User> list = this.getTestUserList();
    when(this.departmentService.getAllUserListByDepartmentId(any(Long.class))).thenReturn(list);

    final UserListEdo edoList = new UserListEdo(CoreModelEdoMapper.toUserEdoList(list));

    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.DEPARTMENT_READ_ALLUSERLIST_BY_DEPARTMENT, 1L)
                                               .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(listAsXmlString));

    verify(this.departmentService, times(1)).getAllUserListByDepartmentId(any(Long.class));

  }

}

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

import com.pth.iflow.common.models.DepartmentGroupEdo;
import com.pth.iflow.common.models.DepartmentGroupListEdo;
import com.pth.iflow.common.models.IdentityListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.service.interfaces.IDepartmentGroupService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentGroupControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private IDepartmentGroupService                departmentGroupService;

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String                                 innerModulesRequestHeaderValue;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadDepartmentGroupById() throws Exception {

    final DepartmentGroupEntity model = this.getTestDepartmentGroup();
    final DepartmentGroupEdo modelEdo = getTestDepartmentGroupEdo();
    when(this.departmentGroupService.getByIdentity(any(String.class))).thenReturn(model);
    when(this.departmentGroupService.toEdo(any(DepartmentGroupEntity.class))).thenReturn(modelEdo);

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(modelEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_BY_IDENTITY, model.getIdentity())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(modelAsXmlString));

    verify(this.departmentGroupService, times(1)).getByIdentity(any(String.class));

  }

  @Test
  public void testReadDepartmentGroupList() throws Exception {

    final Set<String> idList = this.getTestDepartmentGroupIdSet();
    final List<DepartmentGroupEdo> edoConvertedList = getTestDepartmentGroupEdoList();

    final IdentityListEdo edoList = new IdentityListEdo(idList);
    final List<DepartmentGroupEntity> list = this.getTestDepartmentGroupList();

    when(this.departmentGroupService.getListByIdentityList(any(Set.class))).thenReturn(list);
    when(this.departmentGroupService.toEdoList(any(List.class))).thenReturn(edoConvertedList);

    final DepartmentGroupListEdo edoResultList = new DepartmentGroupListEdo(edoConvertedList);

    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);
    final String listAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoResultList);

    this.mockMvc
        .perform(MockMvcRequestBuilders.post(IflowRestPaths.CoreModule.DEPARTMENTGRPUP_READ_LIST).content(contentAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(listAsXmlString));

    verify(this.departmentGroupService, times(1)).getListByIdentityList(any(Set.class));

  }

}

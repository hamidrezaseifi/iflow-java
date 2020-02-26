package com.pth.iflow.core.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
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

import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetItemEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingPresetItemEntity;
import com.pth.iflow.core.service.interfaces.ICompanyService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private ICompanyService companyService;

  @Before
  public void setUp() throws Exception {

  }

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String innerModulesRequestHeaderValue;

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testReadCompany() throws Exception {

    final CompanyEntity company = getTestCompany();
    final CompanyEdo companyEdo = getTestCompanyEdo();

    when(this.companyService.getByIdentity(any(String.class))).thenReturn(company);
    when(this.companyService.toEdo(any(CompanyEntity.class))).thenReturn(companyEdo);

    final String companyAsString = this.xmlConverter.getObjectMapper().writeValueAsString(companyEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.CoreModule.COMPANY_READ_BY_IDENTITY, company.getIdentity())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(companyAsString));

    verify(this.companyService, times(1)).getByIdentity(any(String.class));

  }

  @Test
  public void testSaveDepartment() throws Exception {

    final CompanyEntity company = getTestCompany();
    final CompanyEdo companyEdo = getTestCompanyEdo();

    when(this.companyService.getByIdentity(any(String.class))).thenReturn(company);
    when(this.companyService.save(any(CompanyEntity.class))).thenReturn(company);
    when(this.companyService.toEdo(any(CompanyEntity.class))).thenReturn(companyEdo);
    when(this.companyService.fromEdo(any(CompanyEdo.class))).thenReturn(company);

    final String conetntAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(companyEdo);
    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(companyEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.CoreModule.COMPANY_SAVE)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue)
            .content(conetntAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.companyService, times(1)).save(any(CompanyEntity.class));
    verify(this.companyService, times(1)).fromEdo(any(CompanyEdo.class));
    verify(this.companyService, times(1)).toEdo(any(CompanyEntity.class));

  }

  @Test
  public void testReadCompanyWorkflowtypeItemOcrSettings() throws Exception {

    final List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> modelList = Arrays
        .asList(getTestCompanyWorkflowtypeItemOcrSettingEntity("propName1"), getTestCompanyWorkflowtypeItemOcrSettingEntity("propName2"),
            getTestCompanyWorkflowtypeItemOcrSettingEntity("propName3"));

    final List<CompanyWorkflowtypeItemOcrSettingPresetItemEdo> edoList = Arrays
        .asList(getTestCompanyWorkflowtypeItemOcrSettingEdo("propName1"), getTestCompanyWorkflowtypeItemOcrSettingEdo("propName2"),
            getTestCompanyWorkflowtypeItemOcrSettingEdo("propName3"));

    when(this.companyService.readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(any(String.class))).thenReturn(modelList);
    when(this.companyService.toCompanyWorkflowtypeItemOcrSettingEdoList(any(List.class))).thenReturn(edoList);

    final String resultAsXmlString = this.xmlConverter
        .getObjectMapper()
        .writeValueAsString(new CompanyWorkflowtypeItemOcrSettingPresetListEdo(edoList));

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.CoreModule.COMPANY_READ_WORKFLOWTYPE_ITEMS_OCR_SETTINGS_BY_IDENTITY, "identity")
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.companyService, times(1)).readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(any(String.class));
    verify(this.companyService, times(1)).toCompanyWorkflowtypeItemOcrSettingEdoList(any(List.class));

  }

  @Test
  public void testSaveCompanyWorkflowtypeItemOcrSettings() throws Exception {

    final List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> modelList = Arrays
        .asList(getTestCompanyWorkflowtypeItemOcrSettingEntity("propName1"), getTestCompanyWorkflowtypeItemOcrSettingEntity("propName2"),
            getTestCompanyWorkflowtypeItemOcrSettingEntity("propName3"));

    final List<CompanyWorkflowtypeItemOcrSettingPresetItemEdo> edoList = Arrays
        .asList(getTestCompanyWorkflowtypeItemOcrSettingEdo("propName1"), getTestCompanyWorkflowtypeItemOcrSettingEdo("propName2"),
            getTestCompanyWorkflowtypeItemOcrSettingEdo("propName3"));

    final CompanyWorkflowtypeItemOcrSettingPresetListEdo listEdo = new CompanyWorkflowtypeItemOcrSettingPresetListEdo(edoList);

    when(this.companyService.saveCompanyWorkflowtypeItemOcrSettings(any(List.class))).thenReturn(modelList);
    when(this.companyService.toCompanyWorkflowtypeItemOcrSettingEdoList(any(List.class))).thenReturn(edoList);
    when(this.companyService.fromCompanyWorkflowtypeItemOcrSettingEdoList(any(List.class))).thenReturn(modelList);

    final String resultAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    final String conetntAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(listEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.CoreModule.COMPANY_SAVE_WORKFLOWTYPE_ITEMS_OCR_SETTINGS)
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue)
            .content(conetntAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(resultAsXmlString));

    verify(this.companyService, times(1)).saveCompanyWorkflowtypeItemOcrSettings(any(List.class));
    verify(this.companyService, times(1)).toCompanyWorkflowtypeItemOcrSettingEdoList(any(List.class));
    verify(this.companyService, times(1)).fromCompanyWorkflowtypeItemOcrSettingEdoList(any(List.class));

  }

}

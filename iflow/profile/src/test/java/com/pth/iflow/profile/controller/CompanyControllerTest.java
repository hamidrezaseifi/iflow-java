package com.pth.iflow.profile.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
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

import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetListEdo;
import com.pth.iflow.common.models.edo.DepartmentListEdo;
import com.pth.iflow.common.models.edo.UserGroupListEdo;
import com.pth.iflow.common.models.edo.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.CompanyWorkflowtypeItemOcrSettingPreset;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserGroup;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.handler.ICompaniesHandlerService;
import com.pth.iflow.profile.service.handler.ITokenUserDataManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private ITokenUserDataManager tokenUserDataManager;

  @MockBean
  private ICompaniesHandlerService companiesHandlerService;

  private User user;

  private Company company;

  String TestToken = "test-roken";

  @Before
  public void setUp() throws Exception {

    this.user = this.getTestUser();
    this.company = this.getTestCompany();

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testReadById() throws Exception {

    final CompanyEdo companyEdo = ProfileModelEdoMapper.toEdo(this.company);

    final ProfileResponse profile = this.getTestProfileResponse("sessionid", this.user);
    when(this.tokenUserDataManager.getProfileByToken(any(String.class))).thenReturn(profile);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(companyEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.ProfileModule.COMPANY_READ_BY_IDENTITY, profile.getCompanyProfile().getCompany().getIdentity())
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).getProfileByToken(any(String.class));
  }

  @Test
  public void testReadUserList() throws Exception {

    final List<User> userList = this.getTestUserList();
    // final List<UserEdo> userEdoList = DataModelBase.toEdoList(userList);
    final UserListEdo userEdoList = new UserListEdo(ProfileModelEdoMapper.toUserEdoList(userList));

    when(this.tokenUserDataManager.getUserListByToken(any(String.class), any(String.class))).thenReturn(userList);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(userEdoList);

    final URI uri = IflowRestPaths.ProfileModule.READ_USERLIST_BY_COMPANYID_URIBUILDER("ident1");
    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(uri)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).getUserListByToken(any(String.class), any(String.class));
  }

  @Test
  public void testReadUserGroupList() throws Exception {

    final List<UserGroup> list = this.getTestUserGroupList();
    final UserGroupListEdo edoList = new UserGroupListEdo(ProfileModelEdoMapper.toUserGroupEdoList(list));

    when(this.tokenUserDataManager.getUserGroupListByToken(any(String.class), any(String.class))).thenReturn(list);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.ProfileModule.COMPANY_READ_USERGROUP_LIST, "ident1")
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).getUserGroupListByToken(any(String.class), any(String.class));
  }

  @Test
  public void testReadDepartmentList() throws Exception {

    final List<Department> list = this.getTestDepartmentList();
    final DepartmentListEdo edoList = new DepartmentListEdo(ProfileModelEdoMapper.toDepartmentEdoList(list));

    when(this.tokenUserDataManager.getDepartmentListByToken(any(String.class), any(String.class))).thenReturn(list);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoList);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.ProfileModule.COMPANY_READ_DEPARTMENT_LIST, "ident1")
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).getDepartmentListByToken(any(String.class), any(String.class));
  }

  @Test
  public void testSaveCompany() throws Exception {

    final CompanyEdo companyEdo = ProfileModelEdoMapper.toEdo(this.company);

    when(this.companiesHandlerService.saveCompany(any(Company.class))).thenReturn(this.company);

    final String requestAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(companyEdo);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(companyEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.ProfileModule.COMPANY_SAVE)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken)
            .content(requestAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).validateToken(any(String.class));
    verify(this.companiesHandlerService, times(1)).saveCompany(any(Company.class));
  }

  @Test
  public void testReadCompanyWorkflowtypeItemOcrSettings() throws Exception {

    final List<CompanyWorkflowtypeItemOcrSettingPreset> listSettings = this.getTestCompanyWorkflowtypeItemOcrSettingPresetList();

    final List<
        CompanyWorkflowtypeItemOcrSettingPresetEdo> listEdoSettings = this.getTestCompanyWorkflowtypeItemOcrSettingPresetEdoList();

    final CompanyWorkflowtypeItemOcrSettingPresetListEdo edoListSettings = new CompanyWorkflowtypeItemOcrSettingPresetListEdo(
        listEdoSettings);

    when(this.companiesHandlerService.readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(any(String.class))).thenReturn(listSettings);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoListSettings);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(IflowRestPaths.ProfileModule.COMPANY_READ_WORKFLOWTYPE_ITEMS_OCR_SETTINGS_BY_IDENTITY, "ident1")
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).validateToken(any(String.class));
    verify(this.companiesHandlerService, times(1)).readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(any(String.class));
  }

  @Test
  public void testSaveCompanyWorkflowtypeItemOcrSettings() throws Exception {

    final CompanyWorkflowtypeItemOcrSettingPreset preset = this.getTestCompanyWorkflowtypeItemOcrSettingPreset("presetName");

    final CompanyWorkflowtypeItemOcrSettingPresetEdo edoSettings = this.getTestCompanyWorkflowtypeItemOcrSettingPresetEdo("presetName");

    when(this.companiesHandlerService.saveCompanyWorkflowtypeItemOcrSettings(any(CompanyWorkflowtypeItemOcrSettingPreset.class)))
        .thenReturn(preset);

    final String requestAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoSettings);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edoSettings);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.ProfileModule.COMPANY_SAVE_WORKFLOWTYPE_ITEMS_OCR_SETTINGS)
            .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken)
            .content(requestAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).validateToken(any(String.class));
    verify(this.companiesHandlerService, times(1))
        .saveCompanyWorkflowtypeItemOcrSettings(any(CompanyWorkflowtypeItemOcrSettingPreset.class));
  }

}

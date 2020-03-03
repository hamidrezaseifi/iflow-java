package com.pth.iflow.profile.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetListEdo;
import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.CompanyWorkflowtypeItemOcrSettingPreset;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.access.ICompanyAccessService;
import com.pth.iflow.profile.service.access.impl.CompanyAccessService;
import com.pth.iflow.profile.service.handler.IProfileRestTemplateCall;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyServiceTest extends TestDataProducer {

  private ICompanyAccessService companyService;

  @Mock
  private IProfileRestTemplateCall restTemplate;

  @MockBean
  private ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  @Before
  public void setUp() throws Exception {

    this.companyService = new CompanyAccessService(this.restTemplate, this.coreAccessConfig);

    when(this.coreAccessConfig.prepareCoreUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetCompanyById() throws Exception {

    final Company company = this.getTestCompany();
    final CompanyEdo companyEdo = ProfileModelEdoMapper.toEdo(company);

    when(this.restTemplate.callRestGet(any(URI.class), any(EModule.class), any(Class.class), any(boolean.class)))
        .thenReturn(companyEdo);

    final Company resCompany = this.companyService.getByIdentity(company.getIdentity());

    Assert.assertNotNull("Result company is not null!", resCompany);
    Assert.assertEquals("Result company has id 1!", resCompany.getIdentity(), company.getIdentity());
    Assert
        .assertEquals("Result company has name '" + company.getCompanyName() + "'!", resCompany.getCompanyName(),
            company.getCompanyName());
    Assert.assertEquals("Result company has status 1!", resCompany.getStatus(), company.getStatus());

  }

  @Test
  public void testSaveCompany() throws Exception {

    final Company company = this.getTestCompany();
    final CompanyEdo companyEdo = ProfileModelEdoMapper.toEdo(company);

    when(this.restTemplate
        .callRestPost(any(URI.class), eq(EModule.CORE), any(CompanyEdo.class), eq(CompanyEdo.class), any(boolean.class)))
            .thenReturn(companyEdo);

    final Company resCompany = this.companyService.saveCompany(company);

    Assert.assertNotNull("Result company is not null!", resCompany);
    Assert.assertEquals("Result company has the same identity as source!", company.getIdentity(), resCompany.getIdentity());
    Assert
        .assertEquals("Result company has name '" + company.getCompanyName() + "'!", company.getCompanyName(),
            resCompany.getCompanyName());

  }

  @Test
  public void testReadCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity() throws Exception {

    final List<
        CompanyWorkflowtypeItemOcrSettingPresetEdo> listEdoSettings = this.getTestCompanyWorkflowtypeItemOcrSettingPresetEdoList();

    final CompanyWorkflowtypeItemOcrSettingPresetListEdo edoListSettings = new CompanyWorkflowtypeItemOcrSettingPresetListEdo(
        listEdoSettings);

    when(this.restTemplate
        .callRestGet(any(URI.class), any(EModule.class), eq(CompanyWorkflowtypeItemOcrSettingPresetListEdo.class), any(boolean.class)))
            .thenReturn(edoListSettings);

    final List<CompanyWorkflowtypeItemOcrSettingPreset> resList = this.companyService
        .readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has size 3!", 3, resList.size());
    Assert
        .assertEquals("The third item from result list has " + listEdoSettings.get(2).getItems().size() + " items!",
            listEdoSettings.get(2).getItems().size(), resList.get(2).getItems().size());

  }

  @Test
  public void testSaveCompanyWorkflowtypeItemOcrSettings() throws Exception {

    final CompanyWorkflowtypeItemOcrSettingPreset preset = this.getTestCompanyWorkflowtypeItemOcrSettingPreset("presetName");

    final CompanyWorkflowtypeItemOcrSettingPresetEdo edoSettings = this.getTestCompanyWorkflowtypeItemOcrSettingPresetEdo("presetName");

    when(this.restTemplate
        .callRestPost(any(URI.class), eq(EModule.CORE), any(CompanyWorkflowtypeItemOcrSettingPresetEdo.class),
            eq(CompanyWorkflowtypeItemOcrSettingPresetEdo.class), any(boolean.class)))
                .thenReturn(edoSettings);

    final CompanyWorkflowtypeItemOcrSettingPreset resultPreset = this.companyService.saveCompanyWorkflowtypeItemOcrSettings(preset);

    Assert.assertNotNull("Result company is not null!", resultPreset);
    Assert
        .assertEquals("Result item 3 has propertyname '" + preset.getPresetName() + "'", preset.getPresetName(),
            resultPreset.getPresetName());
    Assert
        .assertEquals("Result preset has the same items count '" + preset.getItems().size() + "'",
            preset.getItems().size(),
            resultPreset.getItems().size());
  }

}

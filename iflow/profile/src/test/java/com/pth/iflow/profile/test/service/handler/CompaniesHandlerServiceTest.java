package com.pth.iflow.profile.test.service.handler;

import static org.mockito.ArgumentMatchers.any;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.CompanyWorkflowtypeItemOcrSettingPreset;
import com.pth.iflow.profile.service.access.ICompanyAccessService;
import com.pth.iflow.profile.service.handler.ICompaniesHandlerService;
import com.pth.iflow.profile.service.handler.impl.CompaniesHandlerService;
import com.pth.iflow.profile.test.TestDataProducer;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CompaniesHandlerServiceTest extends TestDataProducer {

  private ICompaniesHandlerService companiesHandler;

  @Mock
  private ICompanyAccessService companyAccessService;

  @MockBean
  private ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  @Before
  public void setUp() throws Exception {

    this.companiesHandler = new CompaniesHandlerService(this.companyAccessService);

    when(this.coreAccessConfig.prepareCoreUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetCompanyById() throws Exception {

    final Company company = this.getTestCompany();

    when(this.companyAccessService.getByIdentity(any(String.class))).thenReturn(company);

    final Company resCompany = this.companiesHandler.getCompanyByIdentity(company.getIdentity());

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

    when(this.companyAccessService.saveCompany(any(Company.class))).thenReturn(company);

    final Company resCompany = this.companiesHandler.saveCompany(company);

    Assert.assertNotNull("Result company is not null!", resCompany);
    Assert.assertEquals("Result company has the same identity as source!", company.getIdentity(), resCompany.getIdentity());
    Assert
        .assertEquals("Result company has name '" + company.getCompanyName() + "'!", company.getCompanyName(),
            resCompany.getCompanyName());

  }

  @Test
  public void testReadCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity() throws Exception {

    final List<
        CompanyWorkflowtypeItemOcrSettingPreset> listSettings = this.getTestCompanyWorkflowtypeItemOcrSettingPresetList();

    when(this.companyAccessService.readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(any(String.class))).thenReturn(listSettings);

    final List<CompanyWorkflowtypeItemOcrSettingPreset> resList = this.companiesHandler
        .readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity("identity");

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has size 3!", 3, resList.size());
    Assert
        .assertEquals("The third item from result list has " + listSettings.get(2).getItems().size() + " items!",
            listSettings.get(2).getItems().size(), resList.get(2).getItems().size());

  }

  @Test
  public void testSaveCompanyWorkflowtypeItemOcrSettings() throws Exception {

    final CompanyWorkflowtypeItemOcrSettingPreset preset = this.getTestCompanyWorkflowtypeItemOcrSettingPreset("presetName");

    when(this.companyAccessService.saveCompanyWorkflowtypeItemOcrSettings(any(CompanyWorkflowtypeItemOcrSettingPreset.class)))
        .thenReturn(preset);

    final CompanyWorkflowtypeItemOcrSettingPreset resultPreset = this.companiesHandler.saveCompanyWorkflowtypeItemOcrSettings(preset);

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

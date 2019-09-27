package com.pth.iflow.profile.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.net.URI;

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

import com.pth.iflow.common.edo.models.CompanyEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.impl.CompanyService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyServiceTest extends TestDataProducer {

  private ICompanyService                       companyService;

  @Mock
  private IProfileRestTemplateCall              restTemplate;

  @MockBean
  private ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  @Before
  public void setUp() throws Exception {
    this.companyService = new CompanyService(this.restTemplate, this.coreAccessConfig);

    when(this.coreAccessConfig.prepareCoreUrl(any(String.class))).thenReturn(new URI("http://any-string"));

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetUserById() throws Exception {

    final Company company = this.getTestCompany();
    final CompanyEdo companyEdo = ProfileModelEdoMapper.toEdo(company);

    when(this.restTemplate.callRestGet(any(String.class), any(EModule.class), any(Class.class), any(boolean.class), any()))
        .thenReturn(companyEdo);

    final Company resCompany = this.companyService.getById(company.getId());

    Assert.assertNotNull("Result company is not null!", resCompany);
    Assert.assertEquals("Result company has id 1!", resCompany.getId(), company.getId());
    Assert.assertEquals("Result company has name '" + company.getCompanyName() + "'!", resCompany.getCompanyName(),
        company.getCompanyName());
    Assert.assertEquals("Result company has status 1!", resCompany.getStatus(), company.getStatus());

  }

}

package com.pth.iflow.core.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.service.ICompanyService;
import com.pth.iflow.core.service.impl.CompanyService;
import com.pth.iflow.core.storage.dao.ICompanyDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyServiceTest extends TestDataProducer {

  private ICompanyService companyService;

  @MockBean
  private ICompanyDao     companyDao;

  @Before
  public void setUp() throws Exception {
    this.companyService = new CompanyService(this.companyDao);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadCompany() throws Exception {

    final Company company = getTestCompany();
    when(this.companyDao.getById(any(Long.class))).thenReturn(company);

    final Company resCompany = this.companyService.getByIdentity("identifyId");

    Assert.assertNotNull("Result company is not null!", resCompany);
    Assert.assertEquals("Result company has id 1!", resCompany.getId(), company.getId());
    Assert.assertEquals("Result company has companyName 'companyName'!", resCompany.getCompanyName(), company.getCompanyName());
    Assert.assertEquals("Result company has identifyid 'identifyid'!", resCompany.getIdentity(), company.getIdentity());
    Assert.assertEquals("Result company has status 1!", resCompany.getStatus(), company.getStatus());

  }

}

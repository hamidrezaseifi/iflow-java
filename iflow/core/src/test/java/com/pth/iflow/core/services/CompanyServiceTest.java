package com.pth.iflow.core.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

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
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingEntity;
import com.pth.iflow.core.service.impl.CompanyService;
import com.pth.iflow.core.service.interfaces.ICompanyService;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyServiceTest extends TestDataProducer {

  private ICompanyService companyService;

  @MockBean
  private ICompanyDao companyDao;

  @MockBean
  private IWorkflowTypeDao workflowTypeDao;

  @Before
  public void setUp() throws Exception {

    this.companyService = new CompanyService(this.companyDao, this.workflowTypeDao);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testReadCompany() throws Exception {

    final CompanyEntity company = getTestCompany();
    when(this.companyDao.getByIdentity(any(String.class))).thenReturn(company);

    final CompanyEntity resCompany = this.companyService.getByIdentity("identifyId");

    Assert.assertNotNull("Result company is not null!", resCompany);
    Assert.assertEquals("Result company has id 1!", resCompany.getId(), company.getId());
    Assert.assertEquals("Result company has companyName 'companyName'!", resCompany.getCompanyName(), company.getCompanyName());
    Assert.assertEquals("Result company has identifyid 'identifyid'!", resCompany.getIdentity(), company.getIdentity());
    Assert.assertEquals("Result company has status 1!", resCompany.getStatus(), company.getStatus());

  }

  @Test
  public void testCreateCompany() throws Exception {

    final CompanyEntity company = getTestCompany();
    company.setId(null);
    company.setIdentity("");
    when(this.companyDao.create(any(CompanyEntity.class))).thenReturn(company);

    final CompanyEntity resCompany = this.companyService.save(company);

    Assert.assertNotNull("Result company is not null!", resCompany);
    Assert.assertEquals("Result company has id 1!", resCompany.getId(), company.getId());
    Assert.assertEquals("Result company has companyName 'companyName'!", resCompany.getCompanyName(), company.getCompanyName());
    Assert.assertEquals("Result company has identifyid 'identifyid'!", resCompany.getIdentity(), company.getIdentity());
    Assert.assertEquals("Result company has status 1!", resCompany.getStatus(), company.getStatus());
  }

  @Test
  public void testUpdateCompany() throws Exception {

    final CompanyEntity company = getTestCompany();
    company.setId(100L);
    company.setVersion(10);
    company.setIdentity("identity");
    when(this.companyDao.update(any(CompanyEntity.class))).thenReturn(company);
    when(this.companyDao.getByIdentity(any(String.class))).thenReturn(company);

    final CompanyEntity resCompany = this.companyService.save(company);

    final Integer newVersion = 11;
    Assert.assertNotNull("Result company is not null!", resCompany);
    Assert.assertEquals("Result company has id 1!", resCompany.getId(), company.getId());
    Assert.assertEquals("Result company has companyName 'companyName'!", resCompany.getCompanyName(), company.getCompanyName());
    Assert.assertEquals("Result company has identifyid 'identifyid'!", resCompany.getIdentity(), company.getIdentity());
    Assert.assertEquals("Result company has status 1!", resCompany.getStatus(), company.getStatus());
    Assert.assertEquals("Result company has version 11!", newVersion, resCompany.getVersion());
  }

  @Test
  public void testReadCompanyWorkflowtypeItemOcrSettings() throws Exception {

    final List<CompanyWorkflowtypeItemOcrSettingEntity> list = Arrays
        .asList(getTestCompanyWorkflowtypeItemOcrSettingEntity("prop1"), getTestCompanyWorkflowtypeItemOcrSettingEntity("prop2"),
            getTestCompanyWorkflowtypeItemOcrSettingEntity("prop3"));

    when(this.companyDao.readCompanyWorkflowtypeItemOcrSettings(any(Long.class))).thenReturn(list);

    final List<CompanyWorkflowtypeItemOcrSettingEntity> resList = this.companyService.readCompanyWorkflowtypeItemOcrSettings(1L);

    Assert.assertNotNull("Result company is not null!", resList);
    Assert.assertEquals("Result list has 3 items", 3, resList.size());
    Assert.assertEquals("Result item 3 has propertyname 'prop3'", "prop3", resList.get(2).getPropertyName());
    Assert.assertEquals("Result item 2 has value 'prop3'", "value", resList.get(1).getValue());
  }

  @Test
  public void testReadCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity() throws Exception {

    final List<CompanyWorkflowtypeItemOcrSettingEntity> list = Arrays
        .asList(getTestCompanyWorkflowtypeItemOcrSettingEntity("prop1"), getTestCompanyWorkflowtypeItemOcrSettingEntity("prop2"),
            getTestCompanyWorkflowtypeItemOcrSettingEntity("prop3"));

    when(this.companyDao.readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(any(String.class))).thenReturn(list);

    final List<CompanyWorkflowtypeItemOcrSettingEntity> resList = this.companyService
        .readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity("identity");

    Assert.assertNotNull("Result company is not null!", resList);
    Assert.assertEquals("Result list has 3 items", 3, resList.size());
    Assert.assertEquals("Result item 3 has propertyname 'prop3'", "prop3", resList.get(2).getPropertyName());
    Assert.assertEquals("Result item 2 has value 'prop3'", "value", resList.get(1).getValue());
  }

  @Test
  public void testSaveCompanyWorkflowtypeItemOcrSettings() throws Exception {

    final List<CompanyWorkflowtypeItemOcrSettingEntity> list = Arrays
        .asList(getTestCompanyWorkflowtypeItemOcrSettingEntity("prop1"), getTestCompanyWorkflowtypeItemOcrSettingEntity("prop2"),
            getTestCompanyWorkflowtypeItemOcrSettingEntity("prop3"));

    when(this.companyDao.saveCompanyWorkflowtypeItemOcrSettings(any(List.class))).thenReturn(list);

    final List<CompanyWorkflowtypeItemOcrSettingEntity> resList = this.companyService.saveCompanyWorkflowtypeItemOcrSettings(list);

    Assert.assertNotNull("Result company is not null!", resList);
    Assert.assertEquals("Result list has 3 items", 3, resList.size());
    Assert.assertEquals("Result item 3 has propertyname 'prop3'", "prop3", resList.get(2).getPropertyName());
    Assert.assertEquals("Result item 2 has value 'prop3'", "value", resList.get(1).getValue());

  }

}

package com.pth.iflow.core.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.enums.ECompanyType;
import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowTypeControllerEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowTypeOcrSettingPresetEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowTypeEntity;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyDaoTest extends TestDataProducer {

  @Autowired
  private ICompanyDao companyDao;

  @Autowired
  private IWorkflowTypeDao workflowTypeDao;

  private final List<CompanyEntity> createdModels = new ArrayList<>();

  @Before
  public void setUp() throws Exception {

  }

  private void createCompanyList() throws Exception {

    for (int i = 1; i <= 3; i++) {
      final CompanyEntity comapny = getTestCompany();
      comapny.setCompanyName("companyName " + i);
      comapny.setCompanyType(ECompanyType.EINZELUNTERNEHMEN.getEnumValue());
      comapny.setCompanyTypeCustome("");
      comapny.setId(null);
      comapny.setIdentity("compaynyidentity-" + i);
      comapny.setStatus(1);
      comapny.setVersion(1);

      final CompanyEntity res = companyDao.create(comapny);
      createdModels.add(res);
    }
  }

  @After
  public void tearDown() throws Exception {

    for (final CompanyEntity model : createdModels) {
      companyDao.deleteById(model.getId());
    }
  }

  @Test
  public void testGetById() throws Exception {

    createCompanyList();

    final CompanyEntity comapny = createdModels.get(0);

    final CompanyEntity resCompany = this.companyDao.getById(createdModels.get(0).getId());

    compareCompanies(comapny, resCompany);
    Assert.assertEquals("Result comapny has id '" + resCompany.getId() + "'!", resCompany.getId(), comapny.getId());

  }

  @Test
  public void testGetByIdentity() throws Exception {

    createCompanyList();

    final CompanyEntity comapny = createdModels.get(0);

    final CompanyEntity resUser = this.companyDao.getByIdentity(createdModels.get(0).getIdentity());

    compareCompanies(comapny, resUser);
    Assert.assertEquals("Result comapny has id '" + resUser.getId() + "'!", resUser.getId(), comapny.getId());

  }

  @Test
  public void testReadCompanyWorkflowTypeController() throws Exception {

    createCompanyList();

    final List<CompanyWorkflowTypeControllerEntity> resList = companyDao.readCompanyWorkflowTypeController(createdModels.get(0).getId());

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertTrue("Result list is empty!", resList.isEmpty());

  }

  @Test
  public void testCreate() throws Exception {

    final CompanyEntity comapny = getTestCompany();
    comapny.setCompanyName("Test CompanyName");
    comapny.setCompanyType(ECompanyType.EINZELUNTERNEHMEN.getEnumValue());
    comapny.setCompanyTypeCustome("");
    comapny.setId(null);
    comapny.setIdentity("test-compaynyidentity-");
    comapny.setStatus(1);
    comapny.setVersion(10);

    final CompanyEntity resUser = companyDao.create(comapny);
    createdModels.add(resUser);

    compareCompanies(comapny, resUser);

  }

  @Test
  public void testUpdate() throws Exception {

    final CompanyEntity comapny = getTestCompany();
    comapny.setCompanyName("Test CompanyName");
    comapny.setCompanyType(ECompanyType.EINZELUNTERNEHMEN.getEnumValue());
    comapny.setCompanyTypeCustome("");
    comapny.setId(null);
    comapny.setIdentity("test-compaynyidentity-");
    comapny.setStatus(1);
    comapny.setVersion(10);

    final CompanyEntity createdCompany = companyDao.create(comapny);
    createdModels.add(createdCompany);

    Assert.assertNotNull("Result created comapny is not null!", createdCompany);

    createdCompany.setCompanyName("new updated name test");
    createdCompany.setVersion(22);
    createdCompany.setStatus(10);
    createdCompany.setCompanyTypeCustome("update CompanyTypeCustome");

    final CompanyEntity updatedCompany = companyDao.update(createdCompany);

    compareCompanies(createdCompany, updatedCompany);

    Assert.assertEquals("Result comapny has status 10!", updatedCompany.getStatus(), createdCompany.getStatus());
    Assert.assertEquals("Result comapny has version 22!", 22, updatedCompany.getVersion().intValue());
    Assert
        .assertEquals("Result comapny has CompanyName 'new updated name test'!", updatedCompany.getCompanyName(),
            createdCompany.getCompanyName());
    Assert
        .assertEquals("Result comapny has CompanyTypeCustome '" + createdCompany.getCompanyTypeCustome() + "'!",
            updatedCompany.getCompanyTypeCustome(),
            createdCompany.getCompanyTypeCustome());

  }

  @Test
  public void testDelete() throws Exception {

    final CompanyEntity comapny = getTestCompany();
    final CompanyEntity resUser = companyDao.create(comapny);

    Assert.assertNotNull("Result comapny is not null!", resUser);

    companyDao.deleteById(resUser.getId());

    final CompanyEntity deletedUser = this.companyDao.getById(resUser.getId());

    Assert.assertNull("Result comapny is null!", deletedUser);
  }

  @Test
  public void testSaveAndReadAndDeleteCompanyWorkflowtypeItemOcrSettings() throws Exception {

    final CompanyEntity comapny = getTestCompany();
    comapny.setCompanyName("Test CompanyName");
    comapny.setCompanyType(ECompanyType.EINZELUNTERNEHMEN.getEnumValue());
    comapny.setCompanyTypeCustome("");
    comapny.setId(null);
    comapny.setIdentity("test-compaynyidentity-");
    comapny.setStatus(1);
    comapny.setVersion(1);

    final CompanyEntity resCompany = companyDao.create(comapny);
    createdModels.add(resCompany);

    compareCompanies(comapny, resCompany);

    EWorkflowType.INVOICE_WORKFLOW_TYPE.getIdentity();

    final WorkflowTypeEntity workflowType = workflowTypeDao.getByIdentity(EWorkflowType.INVOICE_WORKFLOW_TYPE.getIdentity());

    final CompanyWorkflowTypeOcrSettingPresetEntity preset = getTestCompanyWorkflowtypeItemOcrSettingPresetEntity("preset-1", workflowType,
        resCompany);

    final CompanyWorkflowTypeOcrSettingPresetEntity resPreset = companyDao.saveCompanyWorkflowtypeItemOcrSetting(preset);

    Assert.assertNotNull("Result company is not null!", resPreset);
    Assert
        .assertEquals("Result item 3 has propertyname '" + preset.getPresetName() + "'", preset.getPresetName(),
            resPreset.getPresetName());
    Assert
        .assertEquals("Result preset has the same items count '" + preset.getItems().size() + "'",
            preset.getItems().size(),
            resPreset.getItems().size());

    List<CompanyWorkflowTypeOcrSettingPresetEntity> resList = companyDao.readCompanyWorkflowtypeItemOcrSettings(comapny.getId());

    Assert.assertNotNull("Result company is not null!", resList);
    Assert.assertEquals("Result list has 1 items", 1, resList.size());
    Assert
        .assertEquals("Result item 3 has propertyname '" + resPreset.getPresetName() + "'", resPreset.getPresetName(),
            resList.get(0).getPresetName());
    Assert
        .assertEquals("Result second item from second preset has value '" + resPreset.getItems().get(0).getValue() + "'",
            resPreset.getItems().get(1).getValue(),
            resList.get(0).getItems().get(1).getValue());

    companyDao.deleteCompanyWorkflowtypeItemOcrSetting(resList.get(0));
    resList = companyDao.readCompanyWorkflowtypeItemOcrSettings(comapny.getId());

    Assert.assertNotNull("Result company is not null!", resList);
    Assert.assertEquals("Result list has 0 items", 0, resList.size());

  }

  private void compareCompanies(final CompanyEntity comapny, final CompanyEntity resCompany) {

    Assert.assertNotNull("Result comapny is not null!", resCompany);

    Assert
        .assertEquals("Result comapny has name '" + comapny.getCompanyName() + "'!", resCompany.getCompanyName(), comapny.getCompanyName());
    Assert
        .assertEquals("Result comapny has type '" + comapny.getCompanyType() + "'!", resCompany.getCompanyType(), comapny.getCompanyType());
    Assert.assertEquals("Result comapny has identity '" + comapny.getIdentity() + "'!", resCompany.getIdentity(), comapny.getIdentity());
    Assert.assertEquals("Result comapny has status 1!", resCompany.getStatus(), comapny.getStatus());
    Assert.assertEquals("Result comapny has the same version!", resCompany.getVersion(), comapny.getVersion());
  }

}

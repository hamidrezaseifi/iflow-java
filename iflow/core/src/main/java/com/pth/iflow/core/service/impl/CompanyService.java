package com.pth.iflow.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingEdo;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.ICompanyService;
import com.pth.iflow.core.storage.dao.helper.ICoreEntityVersion;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;

@Service
public class CompanyService extends CoreModelEdoMapperService<CompanyEntity, CompanyEdo> implements ICompanyService {

  private final ICompanyDao companyDao;
  private final IWorkflowTypeDao workflowTypeDao;

  public CompanyService(@Autowired final ICompanyDao companyDao, @Autowired final IWorkflowTypeDao workflowDao) {

    this.companyDao = companyDao;
    this.workflowTypeDao = workflowDao;

  }

  @Override
  public CompanyEntity getByIdentity(final String identity) {

    return this.companyDao.getByIdentity(identity);
  }

  @Override
  public CompanyEntity save(final CompanyEntity model) {

    if (model.isNew()) {

      return companyDao.create(model);
    }

    final CompanyEntity exists = companyDao.getByIdentity(model.getIdentity());
    model.verifyVersion(exists);
    model.increaseVersion();

    return companyDao.update(model);
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingEntity> readCompanyWorkflowtypeItemOcrSettings(final Long id) {

    return companyDao.readCompanyWorkflowtypeItemOcrSettings(id);
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingEntity> readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(final String identity) {

    return companyDao.readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(identity);
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingEntity> saveCompanyWorkflowtypeItemOcrSettings(
      final List<CompanyWorkflowtypeItemOcrSettingEntity> list) {

    return companyDao.saveCompanyWorkflowtypeItemOcrSettings(list);
  }

  protected CompanyEntity prepareSavingModel(final CompanyEntity model) {

    return model;
  }

  @Override
  public CompanyEntity fromEdo(final CompanyEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final CompanyEntity model = new CompanyEntity();

    this.setIdFromIdentity(model, edo.getIdentity(), (EntityDaoBase<ICoreEntityVersion>) this.companyDao);

    model.setCompanyName(edo.getCompanyName());
    model.setIdentity(edo.getIdentity());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setCompanyType(edo.getCompanyType());
    model.setCompanyTypeCustome(edo.getCompanyTypeCustome());

    return model;
  }

  @Override
  public CompanyEdo toEdo(final CompanyEntity model) {

    final CompanyEdo edo = new CompanyEdo();
    edo.setCompanyName(model.getCompanyName());
    edo.setIdentity(model.getIdentity());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());
    edo.setCompanyType(model.getCompanyType());
    edo.setCompanyTypeCustome(model.getCompanyTypeCustome());

    return edo;
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingEntity>
      fromCompanyWorkflowtypeItemOcrSettingEdoList(final List<CompanyWorkflowtypeItemOcrSettingEdo> edoList) {

    final List<CompanyWorkflowtypeItemOcrSettingEntity> modelList = new ArrayList<>();
    for (final CompanyWorkflowtypeItemOcrSettingEdo edo : edoList) {
      modelList.add(fromCompanyWorkflowtypeItemOcrSettingEdo(edo));
    }

    return modelList;
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingEdo>
      toCompanyWorkflowtypeItemOcrSettingEdoList(final List<CompanyWorkflowtypeItemOcrSettingEntity> modelList) {

    final List<CompanyWorkflowtypeItemOcrSettingEdo> edoList = new ArrayList<>();
    for (final CompanyWorkflowtypeItemOcrSettingEntity model : modelList) {
      edoList.add(toCompanyWorkflowtypeItemOcrSettingEdo(model));
    }

    return edoList;
  }

  private CompanyWorkflowtypeItemOcrSettingEntity fromCompanyWorkflowtypeItemOcrSettingEdo(final CompanyWorkflowtypeItemOcrSettingEdo edo) {

    final CompanyWorkflowtypeItemOcrSettingEntity model = new CompanyWorkflowtypeItemOcrSettingEntity();
    model.setCompany(this.companyDao.getByIdentity(edo.getCompanyIdentity()));
    model.setPropertyName(edo.getPropertyName());
    model.setStatus(edo.getStatus());
    model.setValue(edo.getValue());
    model.setVersion(edo.getVersion());
    model.setWorkflowType(workflowTypeDao.getByIdentity(edo.getWorkflowTypeIdentity()));

    return model;
  }

  private CompanyWorkflowtypeItemOcrSettingEdo toCompanyWorkflowtypeItemOcrSettingEdo(final CompanyWorkflowtypeItemOcrSettingEntity model) {

    final CompanyWorkflowtypeItemOcrSettingEdo edo = new CompanyWorkflowtypeItemOcrSettingEdo();
    edo.setCompanyIdentity(model.getCompany().getIdentity());
    edo.setPropertyName(model.getPropertyName());
    edo.setStatus(model.getStatus());
    edo.setValue(model.getValue());
    edo.setVersion(model.getVersion());
    edo.setWorkflowTypeIdentity(model.getWorkflowType().getIdentity());

    return edo;
  }

}

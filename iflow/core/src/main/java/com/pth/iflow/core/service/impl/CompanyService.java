package com.pth.iflow.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.CompanyEdo;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.ICompanyService;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;

@Service
public class CompanyService extends CoreModelEdoMapperService<CompanyEntity, CompanyEdo> implements ICompanyService {

  private final ICompanyDao companyDao;

  public CompanyService(@Autowired final ICompanyDao companyDao) {
    this.companyDao = companyDao;
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

    return companyDao.update(model);
  }

  protected CompanyEntity prepareSavingModel(final CompanyEntity model) {
    return model;
  }

  @Override
  public CompanyEntity fromEdo(final CompanyEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final CompanyEntity model = new CompanyEntity();
    model.setCompanyName(edo.getCompanyName());
    model.setIdentity(edo.getIdentity());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());

    return model;
  }

  @Override
  public CompanyEdo toEdo(final CompanyEntity model) {
    final CompanyEdo edo = new CompanyEdo();
    edo.setCompanyName(model.getCompanyName());
    edo.setIdentity(model.getIdentity());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());

    return edo;
  }
}

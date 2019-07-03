package com.pth.iflow.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.service.ICompanyService;
import com.pth.iflow.core.storage.dao.ICompanyDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

@Service
public class CompanyService implements ICompanyService {

  private final ICompanyDao companyDao;

  public CompanyService(@Autowired final ICompanyDao companyDao) {
    this.companyDao = companyDao;
  }

  @Override
  public Company getById(final Long id) {

    return this.companyDao.getById(id);
  }

  @Override
  public Company getByIdentifyId(final String identifyId) {

    return this.companyDao.getByIdentifyId(identifyId);
  }

  @Override
  public Company save(final Company model) {
    if (model.isNew()) {
      return companyDao.create(model);
    }

    final Company exists = companyDao.getById(model.getId());
    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("Company with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return companyDao.update(model);
  }

}

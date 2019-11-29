package com.pth.iflow.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.service.interfaces.ICompanyService;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;

@Service
public class CompanyService implements ICompanyService {

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
      model.increaseVersion();
      return companyDao.create(model);
    }

    final CompanyEntity exists = companyDao.getById(model.getId());
    model.verifyVersion(exists);

    return companyDao.update(model);
  }

}

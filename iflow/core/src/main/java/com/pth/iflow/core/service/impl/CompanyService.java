package com.pth.iflow.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.service.ICompanyService;
import com.pth.iflow.core.storage.dao.ICompanyDao;

@Service
public class CompanyService implements ICompanyService {

  private final ICompanyDao companyDao;

  CompanyService(@Autowired final ICompanyDao companyDao) {
    this.companyDao = companyDao;
  }

  @Override
  public Company getById(final Long id) {

    return companyDao.getById(id);
  }

  @Override
  public Company getByIdentifyId(final String identifyId) {

    return companyDao.getByIdentifyId(identifyId);
  }

}

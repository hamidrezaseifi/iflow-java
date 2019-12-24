package com.pth.iflow.core.storage.dao.impl;

import org.springframework.stereotype.Repository;

import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;

@Repository
public class CompanyDao extends EntityDaoBase<CompanyEntity> implements ICompanyDao {

  public CompanyDao() {

  }

  @Override
  protected Class<CompanyEntity> entityClass() {
    return CompanyEntity.class;
  }

}

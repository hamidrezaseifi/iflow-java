package com.pth.iflow.core.storage.dao.interfaces;

import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface ICompanyDao {

  public CompanyEntity create(CompanyEntity model) throws IFlowStorageException;

  public CompanyEntity update(CompanyEntity model) throws IFlowStorageException;

  public CompanyEntity getById(Long id) throws IFlowStorageException;

  public CompanyEntity getByIdentity(final String identity);

}
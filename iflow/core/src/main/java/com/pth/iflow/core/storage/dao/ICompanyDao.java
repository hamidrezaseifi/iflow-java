package com.pth.iflow.core.storage.dao;

import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface ICompanyDao {

  public Company create(Company model) throws IFlowStorageException;

  public Company update(Company model) throws IFlowStorageException;

  public Company getById(Long id) throws IFlowStorageException;

  public Company getByIdentity(final String identity);

}

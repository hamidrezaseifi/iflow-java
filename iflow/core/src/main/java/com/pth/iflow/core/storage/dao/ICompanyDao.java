package com.pth.iflow.core.storage.dao;

import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface ICompanyDao {

  public Company getById(Long id) throws IFlowStorageException;

  public Company getByIdentifyId(final String identifyId);

}

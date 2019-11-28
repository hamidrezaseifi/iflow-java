package com.pth.iflow.core.storage.dao.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IDepartmentDao {

  public DepartmentEntity create(DepartmentEntity model) throws IFlowStorageException;

  public DepartmentEntity update(DepartmentEntity model) throws IFlowStorageException;

  public DepartmentEntity getById(Long id) throws IFlowStorageException;

  public DepartmentEntity getByIdentity(String identity) throws IFlowStorageException;

  public List<DepartmentEntity> getListByCompanyIdentity(final String identity) throws IFlowStorageException;

  public List<DepartmentEntity> getListByIdentityList(Collection<String> idList) throws IFlowStorageException;

}

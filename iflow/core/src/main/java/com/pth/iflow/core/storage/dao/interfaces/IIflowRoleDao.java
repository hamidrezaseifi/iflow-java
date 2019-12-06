package com.pth.iflow.core.storage.dao.interfaces;

import com.pth.iflow.core.model.entity.IflowRoleEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IIflowRoleDao {

  public IflowRoleEntity create(IflowRoleEntity model) throws IFlowStorageException;

  public IflowRoleEntity update(IflowRoleEntity model) throws IFlowStorageException;

  public IflowRoleEntity getById(Long id) throws IFlowStorageException;

  void deleteById(Long id) throws IFlowStorageException;

}

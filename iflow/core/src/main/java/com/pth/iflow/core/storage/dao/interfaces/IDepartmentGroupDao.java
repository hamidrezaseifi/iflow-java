package com.pth.iflow.core.storage.dao.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IDepartmentGroupDao {

  public DepartmentGroupEntity create(DepartmentGroupEntity model) throws IFlowStorageException;

  public DepartmentGroupEntity update(DepartmentGroupEntity model) throws IFlowStorageException;

  public DepartmentGroupEntity getById(Long id) throws IFlowStorageException;

  public DepartmentGroupEntity getByIdentity(String identity) throws IFlowStorageException;

  public List<DepartmentGroupEntity> getListByIdentityList(Collection<String> idList) throws IFlowStorageException;

  void deleteById(Long id) throws IFlowStorageException;

  public UserEntity getDepartmentGroupManager(final String identity);

  public UserEntity getDepartmentGroupDeputy(final String identity);

}

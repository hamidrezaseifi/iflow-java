package com.pth.iflow.core.storage.dao.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IUserGroupDao {

  public UserGroupEntity create(UserGroupEntity model) throws IFlowStorageException;

  public UserGroupEntity update(UserGroupEntity model) throws IFlowStorageException;

  public UserGroupEntity getById(Long id) throws IFlowStorageException;

  public UserGroupEntity getByIdentity(String identity) throws IFlowStorageException;

  public List<UserGroupEntity> getListByIdentityList(Collection<String> idList) throws IFlowStorageException;

  public List<UserGroupEntity> getListByIdList(Collection<Long> idList) throws IFlowStorageException;

  public List<UserGroupEntity> getListByCompanyIdentity(String identity) throws IFlowStorageException;

  void deleteById(Long id) throws IFlowStorageException;

}

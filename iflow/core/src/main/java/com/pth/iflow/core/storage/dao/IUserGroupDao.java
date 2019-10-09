package com.pth.iflow.core.storage.dao;

import java.util.Set;

import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IUserGroupDao {

  public UserGroup create(UserGroup model) throws IFlowStorageException;

  public UserGroup update(UserGroup model) throws IFlowStorageException;

  public UserGroup getById(Long id) throws IFlowStorageException;

  public UserGroup getByIdentity(String identity) throws IFlowStorageException;

  public Set<UserGroup> getListByIdList(Set<Long> idList) throws IFlowStorageException;

  public Set<UserGroup> getListByIdentityList(Set<String> idList) throws IFlowStorageException;

  public Set<UserGroup> getListByCompanyId(Long companyId) throws IFlowStorageException;

}

package com.pth.iflow.core.storage.dao.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IUserDao {

  public UserEntity create(UserEntity model) throws IFlowStorageException;

  public UserEntity update(UserEntity model) throws IFlowStorageException;

  public UserEntity getById(Long id) throws IFlowStorageException;

  public void deleteById(Long id) throws IFlowStorageException;

  public UserEntity getByIdentity(final String email) throws IFlowStorageException;

  public UserEntity getByEmail(final String email);

  public List<UserEntity> getListByIdentityList(Collection<String> idList) throws IFlowStorageException;

  public List<UserEntity> getListByCompanyIdentity(String identity) throws IFlowStorageException;

  public List<UserEntity> getAllUserIdentityListByDepartmentId(final String identity) throws IFlowStorageException;

  public UserEntity getLastIdentity(Long companyId) throws IFlowStorageException;

}

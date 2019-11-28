package com.pth.iflow.core.storage.dao.interfaces;

import java.util.List;
import java.util.Set;

import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IUserDao {

  public UserEntity create(UserEntity model) throws IFlowStorageException;

  public UserEntity update(UserEntity model) throws IFlowStorageException;

  public UserEntity getById(Long id) throws IFlowStorageException;

  public void deleteById(Long id) throws IFlowStorageException;

  public UserEntity getByEmail(final String email) throws IFlowStorageException;

  public List<UserEntity> getListByIdentityList(Set<String> idList) throws IFlowStorageException;

  public List<UserEntity> getListByCompanyIdentity(String identity) throws IFlowStorageException;

  public Set<String> getAllUserIdentityListByDepartmentId(final Long id) throws IFlowStorageException;

  public Set<String> getAllUserIdentityListByDepartmentGroupId(final Long id) throws IFlowStorageException;

}

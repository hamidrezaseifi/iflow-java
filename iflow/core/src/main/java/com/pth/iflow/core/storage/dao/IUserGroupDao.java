package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IUserGroupDao {
  
  public UserGroup getById(Long id) throws IFlowStorageException;
  
  public List<UserGroup> getListByIdList(List<Long> idList) throws IFlowStorageException;
  
  public List<UserGroup> getListByCompanyId(Long companyId) throws IFlowStorageException;
  
  public List<Long> listGroupUserId(Long groupId) throws IFlowStorageException;
  
}

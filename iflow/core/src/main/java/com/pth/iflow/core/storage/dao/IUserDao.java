package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.User;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IUserDao {

  public User getById(Long id) throws IFlowStorageException;

  public User getByEmail(final String email) throws IFlowStorageException;

  public List<User> getListByIdList(List<Long> idList) throws IFlowStorageException;

}

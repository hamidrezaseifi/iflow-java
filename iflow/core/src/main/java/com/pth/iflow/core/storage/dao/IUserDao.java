package com.pth.iflow.core.storage.dao;

import com.pth.iflow.core.model.User;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IUserDao {

  public User getById(Long id) throws IFlowStorageException;

  public User getUserByUsername(final String username);

  public User getByEmail(final String email) throws IFlowStorageException;

}

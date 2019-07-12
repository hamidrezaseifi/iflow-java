package com.pth.iflow.core.storage.dao;

import java.util.List;

import com.pth.iflow.core.model.User;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface IUserDao {

  public User create(User model) throws IFlowStorageException;

  public User update(User model) throws IFlowStorageException;

  public User getById(Long id) throws IFlowStorageException;

  public void deleteById(Long id) throws IFlowStorageException;

  public User getByEmail(final String email) throws IFlowStorageException;

  public List<User> getListByIdList(List<Long> idList) throws IFlowStorageException;

  public List<User> getListByCompanyId(Long id) throws IFlowStorageException;

}

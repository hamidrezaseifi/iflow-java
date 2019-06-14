package com.pth.iflow.core.storage.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.storage.dao.IUserGroupDao;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

@Transactional
@Repository
public class UserGroupDao implements IUserGroupDao {

  @Override
  public UserGroup getById(final Long id) throws IFlowStorageException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<UserGroup> getListByIdList(final List<Long> idList) throws IFlowStorageException {
    // TODO Auto-generated method stub
    return null;
  }

}

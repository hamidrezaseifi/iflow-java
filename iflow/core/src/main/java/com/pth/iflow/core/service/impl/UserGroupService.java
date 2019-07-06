package com.pth.iflow.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.service.IUserGroupService;
import com.pth.iflow.core.storage.dao.IUserDao;
import com.pth.iflow.core.storage.dao.IUserGroupDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

@Service
public class UserGroupService implements IUserGroupService {

  private final IUserDao userDao;
  private final IUserGroupDao userGroupDao;

  public UserGroupService(@Autowired final IUserDao userDao, @Autowired final IUserGroupDao userGroupDao) {
    this.userDao = userDao;
    this.userGroupDao = userGroupDao;
  }

  @Override
  public UserGroup getById(final Long id) {
    return this.userGroupDao.getById(id);
  }

  @Override
  public List<UserGroup> getListByIdList(final List<Long> idList) {
    return this.userGroupDao.getListByIdList(idList);
  }

  @Override
  public List<UserGroup> getListByIdCompanyId(final Long companyId) {
    return this.userGroupDao.getListByCompanyId(companyId);
  }

  @Override
  public List<User> listGroupUsers(final Long id) {
    final List<Long> list = this.userGroupDao.listGroupUserId(id);

    return this.userDao.getListByIdList(list);
  }

  @Override
  public UserGroup save(final UserGroup model) {
    if (model.isNew()) {
      model.increaseVersion();
      return userGroupDao.create(model);
    }

    final UserGroup exists = userGroupDao.getById(model.getId());
    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("UserGroup with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return userGroupDao.update(model);
  }

}

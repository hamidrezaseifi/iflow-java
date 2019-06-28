package com.pth.iflow.core.model.cahced;

import org.springframework.beans.factory.annotation.Autowired;

import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.storage.dao.IUserGroupDao;

public class UserGroupCached extends UserGroup implements ICachedModel {

  private final IUserGroupDao userGroupDao;

  public UserGroupCached(@Autowired final IUserGroupDao userGroupDao) {
    this.userGroupDao = userGroupDao;

  }

  @Override
  public void reload() {

    if (!isNew()) {
      this.fromExists(userGroupDao.getById(getId()));
    }

  }

}

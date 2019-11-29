package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.service.interfaces.IUserGroupService;
import com.pth.iflow.core.storage.dao.interfaces.IUserGroupDao;

@Service
public class UserGroupService implements IUserGroupService {

  private final IUserGroupDao userGroupDao;

  public UserGroupService(@Autowired final IUserGroupDao userGroupDao) {
    this.userGroupDao = userGroupDao;
  }

  @PostConstruct
  public void test() {

  }

  @Override
  public UserGroupEntity getByIdentity(final String identity) {

    return this.userGroupDao.getByIdentity(identity);
  }

  @Override
  public List<UserGroupEntity> getListByIdentityList(final Collection<String> idList) {

    return this.userGroupDao.getListByIdentityList(idList);
  }

  @Override
  public List<UserGroupEntity> getListByIdCompanyIdentity(final String companyIdentity) {

    return this.userGroupDao.getListByCompanyIdentity(companyIdentity);
  }

  @Override
  public UserGroupEntity save(final UserGroupEntity model) {
    if (model.isNew()) {
      return userGroupDao.create(model);
    }

    final UserGroupEntity exists = userGroupDao.getById(model.getId());
    model.verifyVersion(exists);

    return userGroupDao.update(model);
  }

  protected UserGroupEntity prepareSavingModel(final UserGroupEntity model) {
    return model;
  }
}

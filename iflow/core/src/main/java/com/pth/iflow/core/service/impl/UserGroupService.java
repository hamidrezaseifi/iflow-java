package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.service.IUserGroupService;
import com.pth.iflow.core.storage.dao.IUserGroupDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;
import com.pth.iflow.core.storage.dao.impl.UserGroupDaoRepository;

@Service
public class UserGroupService implements IUserGroupService {

  @Autowired
  private IUserGroupDao          userGroupDao;

  @Autowired
  private UserGroupDaoRepository repository;

  public UserGroupService() {

  }

  @PostConstruct
  public void test() {

  }

  @Override
  public UserGroup getByIdentity(final String identity) {
    // final UserGroupEntity u = repository.findByIdentity(identity);

    return this.userGroupDao.getByIdentity(identity);
  }

  @Override
  public List<UserGroup> getListByIdentityList(final Collection<String> idList) {

    return this.userGroupDao.getListByIdentityList(idList);
  }

  @Override
  public List<UserGroup> getListByIdCompanyIdentity(final String companyIdentity) {

    // final List<UserGroupEntity> list =
    // repository.findAllByCompanyIdentity(companyIdentity);
    return this.userGroupDao.getListByCompanyIdentity(companyIdentity);
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

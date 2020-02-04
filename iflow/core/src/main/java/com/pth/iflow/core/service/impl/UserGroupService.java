package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.UserGroupEdo;
import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.IUserGroupService;
import com.pth.iflow.core.storage.dao.helper.ICoreEntityVersion;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IUserGroupDao;

@Service
public class UserGroupService extends CoreModelEdoMapperService<UserGroupEntity, UserGroupEdo> implements IUserGroupService {

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

    final UserGroupEntity exists = userGroupDao.getByIdentity(model.getIdentity());
    model.verifyVersion(exists);
    model.increaseVersion();

    return userGroupDao.update(model);
  }

  protected UserGroupEntity prepareSavingModel(final UserGroupEntity model) {

    return model;
  }

  @Override
  public UserGroupEntity fromEdo(final UserGroupEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final UserGroupEntity model = new UserGroupEntity();

    this.setIdFromIdentity(model, edo.getIdentity(), (EntityDaoBase<ICoreEntityVersion>) this.userGroupDao);

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setVersion(edo.getVersion());
    model.setIdentity(edo.getIdentity());
    model.getCompany().setIdentity(edo.getCompanyIdentity());

    return model;
  }

  @Override
  public UserGroupEdo toEdo(final UserGroupEntity model) {

    final UserGroupEdo edo = new UserGroupEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setVersion(model.getVersion());
    edo.setIdentity(model.getIdentity());
    edo.setCompanyIdentity(model.getCompany().getIdentity());

    return edo;
  }
}

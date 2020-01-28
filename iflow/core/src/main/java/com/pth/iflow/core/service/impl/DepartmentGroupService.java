package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.DepartmentGroupEdo;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.IDepartmentGroupService;
import com.pth.iflow.core.storage.dao.helper.ICoreEntityVersion;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentGroupDao;

@Service
public class DepartmentGroupService extends CoreModelEdoMapperService<DepartmentGroupEntity,
    DepartmentGroupEdo> implements IDepartmentGroupService {

  private final IDepartmentGroupDao departmentGroupDao;

  public DepartmentGroupService(@Autowired final IDepartmentGroupDao departmentGroupDao) {

    this.departmentGroupDao = departmentGroupDao;
  }

  @Override
  public DepartmentGroupEntity getByIdentity(final String identity) {

    return this.departmentGroupDao.getByIdentity(identity);
  }

  @Override
  public List<DepartmentGroupEntity> getListByIdentityList(final Collection<String> idList) {

    return this.departmentGroupDao.getListByIdentityList(idList);
  }

  @Override
  public DepartmentGroupEntity save(final DepartmentGroupEntity model) {

    if (model.isNew()) {
      return departmentGroupDao.create(model);
    }

    final DepartmentGroupEntity exists = departmentGroupDao.getByIdentity(model.getIdentity());
    model.verifyVersion(exists);
    model.increaseVersion();

    return departmentGroupDao.update(model);
  }

  @Override
  public void delete(final DepartmentGroupEntity model) {

    this.departmentGroupDao.deleteById(model.getId());
  }

  protected DepartmentGroupEntity prepareSavingModel(final DepartmentGroupEntity model) {

    return model;
  }

  @Override
  public DepartmentGroupEntity fromEdo(final DepartmentGroupEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final DepartmentGroupEntity model = new DepartmentGroupEntity();

    this.setIdFromIdentity(model, edo.getIdentity(), (EntityDaoBase<ICoreEntityVersion>) this.departmentGroupDao);

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setVersion(edo.getVersion());

    return model;
  }

  @Override
  public DepartmentGroupEdo toEdo(final DepartmentGroupEntity model) {

    final DepartmentGroupEdo edo = new DepartmentGroupEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setVersion(model.getVersion());

    return edo;
  }

  @Override
  public UserEntity getDepartmentGroupManager(final String identity) {

    return this.departmentGroupDao.getDepartmentGroupManager(identity);
  }

  @Override
  public UserEntity getDepartmentGroupDeputy(final String identity) {

    return this.departmentGroupDao.getDepartmentGroupDeputy(identity);
  }
}

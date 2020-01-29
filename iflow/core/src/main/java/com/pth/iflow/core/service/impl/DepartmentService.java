package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.DepartmentEdo;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.IDepartmentService;
import com.pth.iflow.core.storage.dao.helper.ICoreEntityVersion;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentDao;

@Service
public class DepartmentService extends CoreModelEdoMapperService<DepartmentEntity, DepartmentEdo> implements IDepartmentService {

  private final IDepartmentDao departmentDao;

  public DepartmentService(@Autowired final IDepartmentDao departmentDao) {

    this.departmentDao = departmentDao;

  }

  @Override
  public DepartmentEntity getByIdentity(final String identity) {

    return this.departmentDao.getByIdentity(identity);
  }

  @Override
  public List<DepartmentEntity> getListByIdentityList(final Collection<String> idList) {

    return this.departmentDao.getListByIdentityList(idList);
  }

  @Override
  public List<DepartmentEntity> getListByIdCompanyIdentity(final String identity) {

    return this.departmentDao.getListByCompanyIdentity(identity);
  }

  @Override
  public DepartmentEntity save(final DepartmentEntity model) {

    if (model.isNew()) {
      return this.departmentDao.create(model);
    }

    final DepartmentEntity exists = this.departmentDao.getByIdentity(model.getIdentity());
    model.verifyVersion(exists);
    model.increaseVersion();

    return this.departmentDao.update(model);
  }

  @Override
  public void delete(final DepartmentEntity model) {

    this.departmentDao.deleteById(model.getId());
  }

  protected DepartmentEntity prepareSavingModel(final DepartmentEntity model) {

    return model;
  }

  @Override
  public UserEntity getDepartmentManager(final String identity) {

    return this.departmentDao.getDepartmentManager(identity);
  }

  @Override
  public UserEntity getDepartmentDeputy(final String identity) {

    return this.departmentDao.getDepartmentDeputy(identity);
  }

  @Override
  public DepartmentEntity fromEdo(final DepartmentEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final DepartmentEntity model = new DepartmentEntity();

    this.setIdFromIdentity(model, edo.getIdentity(), (EntityDaoBase<ICoreEntityVersion>) this.departmentDao);

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setIdentity(edo.getIdentity());
    model.setVersion(edo.getVersion());

    return model;
  }

  @Override
  public DepartmentEdo toEdo(final DepartmentEntity model) {

    final DepartmentEdo edo = new DepartmentEdo();
    edo.setTitle(model.getTitle());
    edo.setStatus(model.getStatus());
    edo.setIdentity(model.getIdentity());
    edo.setVersion(model.getVersion());

    return edo;
  }

}

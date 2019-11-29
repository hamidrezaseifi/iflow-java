package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.service.interfaces.IDepartmentService;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentDao;

@Service
public class DepartmentService implements IDepartmentService {

  private final IDepartmentDao departmentDao;

  public DepartmentService(@Autowired final IDepartmentDao departmentDao) {
    this.departmentDao = departmentDao;

  }

  @Override
  public DepartmentEntity getByIdentity(final String identity) {
    return this.departmentDao.getByIdentity(identity);
  }

  @Override
  public List<DepartmentGroupEntity> getDepartmentGroups(final String identity) {
    final DepartmentEntity department = this.getByIdentity(identity);

    return department.getDepartmentGroups();
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

    final DepartmentEntity exists = this.departmentDao.getById(model.getId());
    model.verifyVersion(exists);

    return this.departmentDao.update(model);
  }

  protected DepartmentEntity prepareSavingModel(final DepartmentEntity model) {
    return model;
  }
}

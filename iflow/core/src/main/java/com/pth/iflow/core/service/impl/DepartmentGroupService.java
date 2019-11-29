package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.service.interfaces.IDepartmentGroupService;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentGroupDao;

@Service
public class DepartmentGroupService implements IDepartmentGroupService {

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

    final DepartmentGroupEntity exists = departmentGroupDao.getById(model.getId());
    model.verifyVersion(exists);

    return departmentGroupDao.update(model);
  }

  protected DepartmentGroupEntity prepareSavingModel(final DepartmentGroupEntity model) {
    return model;
  }
}

package com.pth.iflow.core.model.cahced;

import org.springframework.beans.factory.annotation.Autowired;

import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;

public class DepartmentGroupCached extends DepartmentGroup implements ICachedModel {

  private final IDepartmentGroupDao departmentGroupDao;

  public DepartmentGroupCached(@Autowired final IDepartmentGroupDao departmentGroupDao) {
    this.departmentGroupDao = departmentGroupDao;

  }

  @Override
  public void reload() {

    if (!isNew()) {
      this.fromExists(departmentGroupDao.getById(getId()));
    }

  }
}

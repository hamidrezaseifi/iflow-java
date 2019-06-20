package com.pth.iflow.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.service.IDepartmentGroupService;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;

@Service
public class DepartmentGroupService implements IDepartmentGroupService {

  private final IDepartmentGroupDao departmentGroupDao;

  DepartmentGroupService(@Autowired final IDepartmentGroupDao departmentGroupDao) {
    this.departmentGroupDao = departmentGroupDao;
  }

  @Override
  public DepartmentGroup getById(final Long id) {
    return this.departmentGroupDao.getById(id);
  }

  @Override
  public List<DepartmentGroup> getListByIdList(final List<Long> idList) {
    return this.departmentGroupDao.getListByIdList(idList);
  }

  @Override
  public List<DepartmentGroup> getListByDepartmentId(final Long departmentId) {
    // TODO Auto-generated method stub
    return this.departmentGroupDao.getListByDepartmentId(departmentId);
  }

}

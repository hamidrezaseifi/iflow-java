package com.pth.iflow.core.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.service.IDepartmentService;
import com.pth.iflow.core.storage.dao.IDepartmentDao;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;

@Service
public class DepartmentService implements IDepartmentService {

  private final IDepartmentDao departmentDao;
  private final IDepartmentGroupDao departmentGroupDao;

  DepartmentService(@Autowired final IDepartmentDao departmentDao,
      @Autowired final IDepartmentGroupDao departmentGroupDao) {
    this.departmentDao = departmentDao;
    this.departmentGroupDao = departmentGroupDao;
  }

  @Override
  public Department getById(final Long id) {
    return departmentDao.getById(id);
  }

  @Override
  public List<DepartmentGroup> getDepartmentGroups(final Long id) {
    final Department department = getById(id);

    return departmentGroupDao.getListByIdList(department.getGroups().stream().collect(Collectors.toList()));
  }

  @Override
  public List<Department> getListByIdList(final List<Long> idList) {

    return departmentDao.getListByIdList(idList);
  }

  @Override
  public List<Department> getListByIdCompanyId(final Long id) {
    return departmentDao.getListByCompanyId(id);
  }

}

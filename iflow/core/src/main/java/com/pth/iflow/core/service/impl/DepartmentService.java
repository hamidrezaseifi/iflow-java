package com.pth.iflow.core.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.service.IDepartmentService;
import com.pth.iflow.core.storage.dao.IDepartmentDao;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.IUserDao;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

@Service
public class DepartmentService implements IDepartmentService {

  private final IDepartmentDao      departmentDao;
  private final IDepartmentGroupDao departmentGroupDao;
  private final IUserDao            userDao;

  public DepartmentService(@Autowired final IDepartmentDao departmentDao, @Autowired final IDepartmentGroupDao departmentGroupDao,
      @Autowired final IUserDao userDao) {
    this.departmentDao = departmentDao;
    this.departmentGroupDao = departmentGroupDao;
    this.userDao = userDao;
  }

  @Override
  public Department getById(final Long id) {
    return this.departmentDao.getById(id);
  }

  @Override
  public List<DepartmentGroup> getDepartmentGroups(final Long id) {
    final Department department = this.getById(id);

    return this.departmentGroupDao.getListByIdList(department.getGroups().stream().collect(Collectors.toList()));
  }

  @Override
  public List<Department> getListByIdList(final List<Long> idList) {

    return this.departmentDao.getListByIdList(idList);
  }

  @Override
  public List<Department> getListByIdCompanyId(final Long id) {
    return this.departmentDao.getListByCompanyId(id);
  }

  @Override
  public Department save(final Department model) {
    if (model.isNew()) {
      model.increaseVersion();
      return this.departmentDao.create(model);
    }

    final Department exists = this.departmentDao.getById(model.getId());
    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("Department with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return this.departmentDao.update(model);
  }

  @Override
  public List<User> getAllUserListByDepartmentId(final Long id) {

    final List<Long> idList = this.departmentDao.getAllUserIdListByDepartmentId(id);

    final Set<Long> idSet = idList.stream().collect(Collectors.toSet());

    final List<DepartmentGroup> groups = this.getDepartmentGroups(id);
    for (final DepartmentGroup group : groups) {
      idSet.addAll(this.departmentGroupDao.getAllUserIdListByDepartmentGroupId(group.getId()));
    }

    return this.userDao.getListByIdList(idSet.stream().collect(Collectors.toList()));
  }

}

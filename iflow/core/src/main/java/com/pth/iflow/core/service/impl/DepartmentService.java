package com.pth.iflow.core.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.helper.ICoreIdentityModel;
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
  public Department getByIdentity(final String identity) {
    return this.departmentDao.getByIdentity(identity);
  }

  @Override
  public List<DepartmentGroup> getDepartmentGroups(final String identity) {
    final Department department = this.getByIdentity(identity);

    return department.getDepartmentGroups();
  }

  @Override
  public List<Department> getListByIdentityList(final Set<String> idList) {

    return this.departmentDao.getListByIdentityList(idList);
  }

  @Override
  public List<Department> getListByIdCompanyIdentity(final String identity) {
    return this.departmentDao.getListByCompanyIdentity(identity);
  }

  @Override
  public ICoreIdentityModel save(final Department model) {
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
  public List<User> getAllUserListByDepartmentIdentity(final String identity) {

    final Department department = getByIdentity(identity);
    final Set<String> idList = this.departmentDao.getAllUserIdentityListByDepartmentId(department.getId());

    final List<DepartmentGroup> groups = department.getDepartmentGroups();
    for (final DepartmentGroup group : groups) {
      idList.addAll(this.departmentGroupDao.getAllUserIdentityListByDepartmentGroupId(group.getId()));
    }

    return this.userDao.getListByIdentityList(idList);
  }

}

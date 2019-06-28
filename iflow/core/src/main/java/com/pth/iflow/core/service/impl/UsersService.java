package com.pth.iflow.core.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.service.IUsersService;
import com.pth.iflow.core.storage.dao.IDepartmentDao;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.IUserDao;
import com.pth.iflow.core.storage.dao.IUserGroupDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;

@Service
public class UsersService implements IUsersService {

  private final IUserDao userDao;
  private final IUserGroupDao userGroupDao;
  private final IDepartmentDao departmentDao;
  private final IDepartmentGroupDao departmentGroupDao;
  private final IWorkflowTypeDao workflowTypeDao;
  private final IWorkflowTypeStepDao workflowTypeStepDao;

  public UsersService(@Autowired final IUserDao userDao, @Autowired final IUserGroupDao userGroupDao,
      @Autowired final IDepartmentDao departmentDao, @Autowired final IDepartmentGroupDao departmentGroupDao,
      @Autowired final IWorkflowTypeDao workflowDao, @Autowired final IWorkflowTypeStepDao workflowStepDao) {
    this.userDao = userDao;
    this.userGroupDao = userGroupDao;
    this.departmentDao = departmentDao;
    this.departmentGroupDao = departmentGroupDao;
    this.workflowTypeDao = workflowDao;
    this.workflowTypeStepDao = workflowStepDao;
  }

  @Override
  public User getUserById(final Long id) {

    return userDao.getById(id);
  }

  @Override
  public User getUserByEmail(final String email) {

    return userDao.getByEmail(email);
  }

  @Override
  public List<UserGroup> getUserGroups(final Long id) {
    final User user = getUserById(id);
    final List<UserGroup> list = userGroupDao.getListByIdList(user.getGroupIds().stream().collect(Collectors.toList()));
    return list;
  }

  @Override
  public List<Department> getUserDepartments(final Long id) {
    final User user = getUserById(id);
    final List<Department> list = departmentDao.getListByIdList(user.getDepartmentIds().stream().collect(Collectors.toList()));
    return list;
  }

  @Override
  public List<DepartmentGroup> getUserDepartmentGroups(final Long id) {
    final User user = getUserById(id);
    final List<DepartmentGroup> list = departmentGroupDao
        .getListByIdList(user.getDepartmentGroupIds().stream().collect(Collectors.toList()));
    return list;
  }

  @Override
  public List<User> getUserDeputies(final Long id) {
    final User user = getUserById(id);
    final List<User> list = userDao.getListByIdList(user.getDeputyIds().stream().collect(Collectors.toList()));
    return list;
  }

}

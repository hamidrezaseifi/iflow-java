package com.pth.iflow.core.service.impl;

import java.util.List;
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
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;

@Service
public class UsersService implements IUsersService {

  private final IUserDao            userDao;
  private final IUserGroupDao       userGroupDao;
  private final IDepartmentDao      departmentDao;
  private final IDepartmentGroupDao departmentGroupDao;

  public UsersService(@Autowired final IUserDao userDao,
                      @Autowired final IUserGroupDao userGroupDao,
                      @Autowired final IDepartmentDao departmentDao,
                      @Autowired final IDepartmentGroupDao departmentGroupDao) {
    this.userDao = userDao;
    this.userGroupDao = userGroupDao;
    this.departmentDao = departmentDao;
    this.departmentGroupDao = departmentGroupDao;
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
    final List<UserGroup> list = userGroupDao.getListByIdentityList(user.getGroups());
    return list;
  }

  @Override
  public List<Department> getUserDepartments(final Long id) {
    final User user = getUserById(id);
    final List<Department> list = departmentDao.getListByIdentityList(user.getDepartments());
    return list;
  }

  @Override
  public List<DepartmentGroup> getUserDepartmentGroups(final Long id) {
    final User user = getUserById(id);
    final List<DepartmentGroup> list = departmentGroupDao.getListByIdentityList(user.getDepartmentGroups());
    return list;
  }

  @Override
  public List<User> getUserDeputies(final Long id) {
    final User user = getUserById(id);
    final List<User> list = userDao.getListByIdentityList(user.getDeputies());
    return list;
  }

  @Override
  public User save(final User model) {
    if (model.isNew()) {
      model.increaseVersion();
      return userDao.create(model);
    }

    final User exists = userDao.getById(model.getId());
    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("User with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return userDao.update(model);
  }

  @Override
  public List<User> getCompanyUsers(final Long companyId) {

    return userDao.getListByCompanyId(companyId);
  }

}

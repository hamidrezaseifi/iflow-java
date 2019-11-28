package com.pth.iflow.core.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.service.IDepartmentGroupService;
import com.pth.iflow.core.storage.dao.exception.IFlowOptimisticLockException;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;

@Service
public class DepartmentGroupService implements IDepartmentGroupService {

  private final IDepartmentGroupDao departmentGroupDao;
  private final IUserDao            userDao;

  public DepartmentGroupService(@Autowired final IDepartmentGroupDao departmentGroupDao, @Autowired final IUserDao userDao) {
    this.departmentGroupDao = departmentGroupDao;
    this.userDao = userDao;
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
  public List<DepartmentGroupEntity> getListByDepartmentIdentity(final String departmentIdentity) {
    // TODO Auto-generated method stub
    return this.departmentGroupDao.getListByDepartmentIdentity(departmentIdentity);
  }

  @Override
  public DepartmentGroupEntity save(final DepartmentGroupEntity model) {
    if (model.isNew()) {
      model.increaseVersion();
      return departmentGroupDao.create(model);
    }

    final DepartmentGroupEntity exists = departmentGroupDao.getById(model.getId());
    if (exists.getVersion() > model.getVersion()) {
      throw new IFlowOptimisticLockException("DepartmentGroup with id " + model.getId() + " is old!");
    }

    model.setVersion(model.getVersion() + 1);

    return departmentGroupDao.update(model);
  }

  @Override
  public List<User> getAllUserListByDepartmentGroupId(final String identity) {
    final DepartmentGroupEntity departmentGroup = getByIdentity(identity);
    final Set<String> idList = departmentGroupDao.getAllUserIdentityListByDepartmentGroupId(departmentGroup.getId());

    return userDao.getListByIdentityList(idList);

  }

}

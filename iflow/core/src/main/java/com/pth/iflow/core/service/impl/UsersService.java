package com.pth.iflow.core.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.service.interfaces.IUsersService;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentDao;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;
import com.pth.iflow.core.storage.dao.interfaces.IUserGroupDao;

@Service
public class UsersService implements IUsersService {

  private final ICompanyDao         companyDao;
  private final IUserDao            userDao;
  private final IUserGroupDao       userGroupDao;
  private final IDepartmentDao      departmentDao;
  private final IDepartmentGroupDao departmentGroupDao;

  public UsersService(@Autowired final ICompanyDao companyDao, @Autowired final IUserDao userDao,
      @Autowired final IUserGroupDao userGroupDao, @Autowired final IDepartmentDao departmentDao,
      @Autowired final IDepartmentGroupDao departmentGroupDao) {
    this.companyDao = companyDao;
    this.userDao = userDao;
    this.userGroupDao = userGroupDao;
    this.departmentDao = departmentDao;
    this.departmentGroupDao = departmentGroupDao;
  }

  @Override
  public UserEntity getUserByEmail(final String email) {

    return userDao.getByEmail(email);
  }

  @Override
  public List<UserGroupEntity> getUserGroups(final String email) {
    final UserEntity user = getUserByEmail(email);
    ;

    final List<UserGroupEntity> list = userGroupDao
        .getListByIdList(user.getGroups().stream().map(uug -> uug.getUserGroupId()).collect(Collectors.toSet()));
    return list;
  }

  @Override
  public List<DepartmentEntity> getUserDepartments(final String email) {
    final UserEntity user = getUserByEmail(email);
    final List<DepartmentEntity> list = user.getDepartments().stream().map(ud -> ud.getDepartment()).collect(Collectors.toList());
    return list;
  }

  @Override
  public List<DepartmentGroupEntity> getUserDepartmentGroups(final String email) {
    final UserEntity user = getUserByEmail(email);
    final List<DepartmentGroupEntity> list = user.getDepartmentGroups().stream().map(ud -> ud.getDepartmentGroup())
        .collect(Collectors.toList());
    return list;
  }

  @Override
  public List<UserEntity> getUserDeputies(final String email) {
    final UserEntity user = getUserByEmail(email);
    final List<UserEntity> list = user.getDeputies().stream().map(ud -> ud.getDeputy()).collect(Collectors.toList());
    return list;
  }

  @Override
  public UserEntity save(final UserEntity model) {
    if (model.isNew()) {
      model.increaseVersion();
      return userDao.create(model);
    }

    final UserEntity exists = userDao.getById(model.getId());
    model.verifyVersion(exists);

    return userDao.update(model);
  }

  @Override
  public List<UserEntity> getCompanyUsers(final String companyIdentity) {

    return userDao.getListByCompanyIdentity(companyIdentity);
  }

  @Override
  public ProfileResponse getProfileResponseByEmail(final String email) {
    final UserEntity user = this.getUserByEmail(email);
    final CompanyEntity company = companyDao.getByIdentity(user.getCompany().getIdentity());

    return new ProfileResponse(user, company, this.getUserDepartments(email), this.getUserGroups(email), "sot-set");
  }

}

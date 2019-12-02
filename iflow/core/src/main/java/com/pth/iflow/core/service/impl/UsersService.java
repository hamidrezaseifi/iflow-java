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
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;
import com.pth.iflow.core.storage.dao.interfaces.IUserGroupDao;

@Service
public class UsersService implements IUsersService {

  private final ICompanyDao   companyDao;
  private final IUserDao      userDao;
  private final IUserGroupDao userGroupDao;

  public UsersService(@Autowired final ICompanyDao companyDao,
                      @Autowired final IUserDao userDao,
                      @Autowired final IUserGroupDao userGroupDao) {
    this.companyDao = companyDao;
    this.userDao = userDao;
    this.userGroupDao = userGroupDao;

  }

  @Override
  public UserEntity getUserByEmail(final String email) {

    return userDao.getByIdentity(email);
  }

  @Override
  public List<UserGroupEntity> getUserGroups(final String email) {
    final UserEntity user = getUserByEmail(email);;

    final List<UserGroupEntity> list = userGroupDao
                                                   .getListByIdList(user.getGroups()
                                                                        .stream()
                                                                        .map(uug -> uug.getUserGroupId())
                                                                        .collect(Collectors.toSet()));
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
    final List<DepartmentGroupEntity> list = user.getDepartmentGroups()
                                                 .stream()
                                                 .map(ud -> ud.getDepartmentGroup())
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

      return userDao.create(model);
    }

    final UserEntity exists = userDao.getByIdentity(model.getIdentity());
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

  @Override
  public List<UserEntity> getAllUserIdentityListByDepartmentIdentity(final String identity) throws IFlowStorageException {

    return userDao.getAllUserIdentityListByDepartmentId(identity);
  }

  @Override
  public List<UserEntity> getAllUserIdentityListByDepartmentGroupIdentity(final String identity) throws IFlowStorageException {

    return userDao.getAllUserIdentityListByDepartmentGroupId(identity);
  }

  protected UserEntity prepareSavingModel(final UserEntity model) {
    return model;
  }
}

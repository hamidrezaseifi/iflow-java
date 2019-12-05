package com.pth.iflow.core.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.common.edo.models.CompanyProfileEdo;
import com.pth.iflow.common.edo.models.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.core.helper.CoreDataHelper;
import com.pth.iflow.core.model.CompanyProfile;
import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.ICompanyService;
import com.pth.iflow.core.service.interfaces.IDepartmentService;
import com.pth.iflow.core.service.interfaces.IUserGroupService;
import com.pth.iflow.core.service.interfaces.IUsersService;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentDao;
import com.pth.iflow.core.storage.dao.interfaces.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.interfaces.IUserDao;
import com.pth.iflow.core.storage.dao.interfaces.IUserGroupDao;

@Service
public class UsersService extends CoreModelEdoMapperService<UserEntity, UserEdo> implements IUsersService {

  private final ICompanyDao         companyDao;
  private final IUserDao            userDao;
  private final IUserGroupDao       userGroupDao;
  private final IDepartmentDao      departmentDao;
  private final IDepartmentGroupDao departmentGroupDao;

  public UsersService(@Autowired final ICompanyDao companyDao,
                      @Autowired final IUserDao userDao,
                      @Autowired final IUserGroupDao userGroupDao,
                      @Autowired final IDepartmentDao departmentDao,
                      @Autowired final IDepartmentGroupDao departmentGroupDao) {
    this.companyDao = companyDao;
    this.userDao = userDao;
    this.userGroupDao = userGroupDao;
    this.departmentDao = departmentDao;
    this.departmentGroupDao = departmentGroupDao;

  }

  @Override
  public UserEntity getUserByIdentity(final String email) {

    return userDao.getByIdentity(email);
  }

  @Override
  public List<UserGroupEntity> getUserGroups(final String email) {
    final UserEntity user = getUserByIdentity(email);;

    final List<UserGroupEntity> list = userGroupDao
                                                   .getListByIdList(user.getGroups()
                                                                        .stream()
                                                                        .map(uug -> uug.getUserGroupId())
                                                                        .collect(Collectors.toSet()));
    return list;
  }

  @Override
  public List<DepartmentEntity> getUserDepartments(final String email) {
    final UserEntity user = getUserByIdentity(email);
    final List<DepartmentEntity> list = user.getDepartments().stream().map(ud -> ud.getDepartment()).collect(Collectors.toList());
    return list;
  }

  @Override
  public List<DepartmentGroupEntity> getUserDepartmentGroups(final String email) {
    final UserEntity user = getUserByIdentity(email);
    final List<DepartmentGroupEntity> list = user.getDepartmentGroups()
                                                 .stream()
                                                 .map(ud -> ud.getDepartmentGroup())
                                                 .collect(Collectors.toList());
    return list;
  }

  @Override
  public List<UserEntity> getUserDeputies(final String email) {
    final UserEntity user = getUserByIdentity(email);
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
    final UserEntity user = this.getUserByIdentity(email);
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

  @Override
  public UserEntity fromEdo(final UserEdo edo) throws IFlowMessageConversionFailureException {
    validateCustomer(edo);

    final UserEntity model = new UserEntity();

    model.setFirstName(edo.getFirstName());
    model.setLastName(edo.getLastName());
    model.setPermission(edo.getPermission());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setEmail(edo.getEmail());
    model.setBirthDate(CoreDataHelper.fromLocalDate(edo.getBirthDate()));
    model.getCompany().setIdentity(edo.getCompanyIdentity());
    model.setGroups(userGroupDao.getListByIdentityList(edo.getGroups()));
    model.setDepartments(departmentDao.getListByIdentityList(edo.getDepartments()));
    model.setDepartmentGroups(departmentGroupDao.getListByIdentityList(edo.getDepartmentGroups()));
    model.setDeputies(userDao.getListByIdentityList(edo.getDeputies()));
    model.setRolesFromIntegerList(edo.getRoles());

    return model;
  }

  @Override
  public UserEdo toEdo(final UserEntity model) {
    final UserEdo edo = new UserEdo();
    edo.setFirstName(model.getFirstName());
    edo.setLastName(model.getLastName());
    edo.setPermission(model.getPermission());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());
    edo.setEmail(model.getEmail());
    edo.setBirthDate(model.getBirthDate().toLocalDate());
    edo.setCompanyIdentity(model.getCompany().getIdentity());
    edo.setGroups(model.getGroups().stream().map(g -> g.getUserGroup().getIdentity()).collect(Collectors.toSet()));
    edo.setDepartments(model.getDepartments().stream().map(g -> g.getDepartment().getIdentity()).collect(Collectors.toSet()));
    edo.setDepartmentGroups(
                            model.getDepartmentGroups()
                                 .stream()
                                 .map(g -> g.getDepartmentGroup().getIdentity())
                                 .collect(Collectors.toSet()));
    edo.setDeputies(model.getDeputies().stream().map(g -> g.getDeputy().getIdentity()).collect(Collectors.toSet()));
    edo.setRoles(model.getRoles().stream().map(g -> g.getRole()).collect(Collectors.toSet()));

    return edo;
  }

  @Override
  public ProfileResponseEdo toProfileResponseEdo(final ProfileResponse model) {
    return new ProfileResponseEdo(toEdo(model.getUser()), toCompanyProfileEdo(model.getCompanyProfile()), model.getSessionid());
  }

  public CompanyProfileEdo toCompanyProfileEdo(final CompanyProfile model) {

    final IUserGroupService groupService = new UserGroupService(null);
    final IDepartmentService departmentService = new DepartmentService(null);
    final ICompanyService companyService = new CompanyService(null);

    final CompanyProfileEdo edo = new CompanyProfileEdo(companyService.toEdo(model.getCompany()),
                                                        departmentService.toEdoList(model.getDepartments()),
                                                        groupService.toEdoList(model.getUserGroups()));

    return edo;
  }

  @Override
  public List<UserEntity> getUserListByIdentityList(final Set<String> identityList) throws IFlowStorageException {

    return userDao.getListByIdentityList(identityList);
  }

}

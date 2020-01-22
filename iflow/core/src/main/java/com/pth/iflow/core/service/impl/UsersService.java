package com.pth.iflow.core.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.CompanyProfileEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowTypeControllerEdo;
import com.pth.iflow.common.models.edo.ProfileResponseEdo;
import com.pth.iflow.common.models.edo.UserDepartmentEdo;
import com.pth.iflow.common.models.edo.UserDepartmentGroupEdo;
import com.pth.iflow.common.models.edo.UserEdo;
import com.pth.iflow.common.models.helper.IdentityModel;
import com.pth.iflow.core.helper.CoreDataHelper;
import com.pth.iflow.core.model.CompanyProfile;
import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowTypeControllerEntity;
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
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;

@Service
public class UsersService extends CoreModelEdoMapperService<UserEntity, UserEdo> implements IUsersService {

  private final ICompanyDao companyDao;
  private final IUserDao userDao;
  private final IUserGroupDao userGroupDao;
  private final IDepartmentDao departmentDao;
  private final IDepartmentGroupDao departmentGroupDao;
  private final IWorkflowTypeDao workflowTypeDao;

  public UsersService(@Autowired final ICompanyDao companyDao, @Autowired final IUserDao userDao,
      @Autowired final IUserGroupDao userGroupDao,
      @Autowired final IDepartmentDao departmentDao, @Autowired final IDepartmentGroupDao departmentGroupDao,
      @Autowired final IWorkflowTypeDao workflowTypeDao) {

    this.companyDao = companyDao;
    this.userDao = userDao;
    this.userGroupDao = userGroupDao;
    this.departmentDao = departmentDao;
    this.departmentGroupDao = departmentGroupDao;
    this.workflowTypeDao = workflowTypeDao;

  }

  @Override
  public UserEntity getUserByIdentity(final String identity) {

    return userDao.getByIdentity(identity);
  }

  @Override
  public UserEntity getUserByEmail(final String email) {

    return userDao.getByEmail(email);
  }

  @Override
  public List<UserGroupEntity> getUserGroups(final String email) {

    final UserEntity user = getUserByIdentity(email);

    return user.getGroups().stream().collect(Collectors.toList());
  }

  @Override
  public List<DepartmentEntity> getUserDepartments(final String email) {

    final UserEntity user = getUserByIdentity(email);
    return user.getDepartments().stream().collect(Collectors.toList());
  }

  @Override
  public List<DepartmentGroupEntity> getUserDepartmentGroups(final String email) {

    final UserEntity user = getUserByIdentity(email);
    return user.getDepartmentGroups().stream().collect(Collectors.toList());
  }

  @Override
  public List<UserEntity> getUserDeputies(final String email) {

    final UserEntity user = getUserByIdentity(email);

    return user.getDeputies().stream().collect(Collectors.toList());
  }

  @Override
  public UserEntity save(final UserEntity model) {

    if (model.isNew()) {

      final UserEntity lastUser = userDao.getLastIdentity(model.getCompanyId());
      final String lastIdentity = lastUser != null ? lastUser.getIdentity() : "";

      model.generateUserIdentity(lastIdentity);

      return userDao.create(model);
    }

    final UserEntity exists = userDao.getByIdentity(model.getIdentity());
    model.verifyVersion(exists);

    return userDao.update(model);
  }

  @Override
  public void delete(final UserEntity model) {

    final UserEntity exists = userDao.getByIdentity(model.getIdentity());
    userDao.deleteById(exists.getId());

  }

  @Override
  public List<UserEntity> getCompanyUsers(final String companyIdentity) {

    return userDao.getListByCompanyIdentity(companyIdentity);
  }

  @Override
  public ProfileResponse getProfileResponseByEmail(final String email) {

    final UserEntity user = this.getUserByEmail(email);
    final CompanyEntity company = companyDao.getByIdentity(user.getCompany().getIdentity());

    return new ProfileResponse(user, company, user.getDepartments().stream().collect(Collectors.toList()),
        user.getGroups().stream().collect(Collectors.toList()), "sot-set");
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

    model.setId(IdentityModel.isIdentityNew(edo.getIdentity()) ? null : userDao.getByIdentity(edo.getIdentity()).getId());
    model.setFirstName(edo.getFirstName());
    model.setLastName(edo.getLastName());
    model.setPermission(edo.getPermission());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setEmail(edo.getEmail());
    model.setBirthDate(CoreDataHelper.fromLocalDate(edo.getBirthDate()));
    model.setCompany(companyDao.getByIdentity(edo.getCompanyIdentity()));
    model.setCompanyId(model.getCompany().getId());
    model.setGroups(userGroupDao.getListByIdentityList(edo.getGroups()));
    model.setDeputies(userDao.getListByIdentityList(edo.getDeputies()));
    model.setIdentity(edo.getIdentity());

    for (final UserDepartmentEdo userDepartmentEdo : edo.getUserDepartments()) {
      model.addUserDepartment(departmentDao.getByIdentity(userDepartmentEdo.getDepartmentIdentity()), userDepartmentEdo.getMemberType());
    }

    for (final UserDepartmentGroupEdo userDepartmentGroupEdo : edo.getUserDepartmentGroups()) {
      model
          .addUserDepartmentGroup(departmentGroupDao.getByIdentity(userDepartmentGroupEdo.getDepartmentGroupIdentity()),
              userDepartmentGroupEdo.getMemberType());
    }

    return model;
  }

  @Override
  public UserEdo toEdo(final UserEntity model) {

    if (model == null) {
      return null;
    }
    final UserEdo edo = new UserEdo();
    edo.setFirstName(model.getFirstName());
    edo.setLastName(model.getLastName());
    edo.setPermission(model.getPermission());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());
    edo.setEmail(model.getEmail());
    edo.setBirthDate(model.getBirthDate().toLocalDate());
    edo.setCompanyIdentity(model.getCompany().getIdentity());
    edo.setGroups(model.getGroups().stream().map(g -> g.getIdentity()).collect(Collectors.toSet()));

    edo
        .setUserDepartments(model
            .getUserDepartments()
            .stream()
            .map(g -> new UserDepartmentEdo(g.getDepartment().getIdentity(), g.getMemberType()))
            .collect(Collectors.toSet()));

    edo
        .setUserDepartmentGroups(model
            .getUserDepartmentGroups()
            .stream()
            .map(g -> new UserDepartmentGroupEdo(g.getDepartmentGroup().getIdentity(), g.getMemberType()))
            .collect(Collectors.toSet()));

    edo.setDeputies(model.getDeputies().stream().map(g -> g.getIdentity()).collect(Collectors.toSet()));
    edo.setRoles(model.getRoles().stream().map(r -> r.getId().intValue()).collect(Collectors.toSet()));
    edo.setIdentity(model.getIdentity());

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

    final List<CompanyWorkflowTypeControllerEntity> workflowTypeControllers = companyDao
        .readCompanyWorkflowTypeController(model.getCompany().getId());

    final List<CompanyWorkflowTypeControllerEdo> workflowTypeControllerEdoList = workflowTypeControllers
        .stream()
        .map(wtc -> extractCompanyWorkflowTypeControllerEdo(wtc))
        .collect(Collectors.toList());

    final CompanyProfileEdo edo = new CompanyProfileEdo(companyService.toEdo(model.getCompany()),
        departmentService.toEdoList(model.getDepartments()), groupService.toEdoList(model.getUserGroups()), workflowTypeControllerEdoList);

    return edo;
  }

  private CompanyWorkflowTypeControllerEdo extractCompanyWorkflowTypeControllerEdo(final CompanyWorkflowTypeControllerEntity wtc) {

    final CompanyWorkflowTypeControllerEdo workflowTypeControllerEdo = new CompanyWorkflowTypeControllerEdo(
        workflowTypeDao.getById(wtc.getId().getWorkflowTypeId()).getIdentity(),
        userDao.getById(wtc.getId().getUserId()).getIdentity(),
        wtc.getId().getPriority());

    return workflowTypeControllerEdo;
  }

  @Override
  public List<UserEntity> getUserListByIdentityList(final Set<String> identityList) throws IFlowStorageException {

    return userDao.getListByIdentityList(identityList);
  }

}

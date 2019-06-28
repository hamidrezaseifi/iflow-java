package com.pth.iflow.core.model.cahced;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.storage.dao.ICompanyDao;
import com.pth.iflow.core.storage.dao.IDepartmentDao;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.IUserDao;
import com.pth.iflow.core.storage.dao.IUserGroupDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;

public class CompanyCached extends Company implements ICachedModel {

  private final Set<UserCached> users = new HashSet<>();
  private final Set<DepartmentCached> departments = new HashSet<>();
  private final Set<WorkflowTypeCached> workflowTypes = new HashSet<>();
  private final Set<UserGroupCached> userGroups = new HashSet<>();

  private final ICompanyDao companyDao;
  private final IUserDao userDao;
  private final IUserGroupDao userGroupDao;
  private final IDepartmentDao departmentDao;
  private final IDepartmentGroupDao departmentGroupDao;
  private final IWorkflowTypeDao workflowTypeDao;
  private final IWorkflowTypeStepDao workflowTypeStepDao;

  public CompanyCached(@Autowired final ICompanyDao companyDao, @Autowired final IUserDao userDao,
      @Autowired final IUserGroupDao userGroupDao, @Autowired final IDepartmentDao departmentDao,
      @Autowired final IDepartmentGroupDao departmentGroupDao, @Autowired final IWorkflowTypeDao workflowTypeDao,
      @Autowired final IWorkflowTypeStepDao workflowTypeStepDao) {
    this.companyDao = companyDao;
    this.userDao = userDao;
    this.userGroupDao = userGroupDao;
    this.departmentDao = departmentDao;
    this.departmentGroupDao = departmentGroupDao;
    this.workflowTypeDao = workflowTypeDao;
    this.workflowTypeStepDao = workflowTypeStepDao;

  }

  public Set<UserCached> getUsers() {
    return users;
  }

  public void setUsers(final List<UserCached> users) {
    setUsers(users.stream().collect(Collectors.toSet()));
  }

  public void addUser(final UserCached model) {
    users.add(model);
  }

  public void setUsers(final Set<UserCached> users) {
    this.users.clear();
    if (users != null) {
      this.users.addAll(users);
    }
  }

  public Set<UserGroupCached> getGroups() {
    return userGroups;
  }

  public void setGroups(final List<UserGroupCached> userGroups) {
    setGroups(userGroups.stream().collect(Collectors.toSet()));
  }

  public void addGroup(final UserGroupCached model) {
    userGroups.add(model);
  }

  public void setGroups(final Set<UserGroupCached> userGroups) {
    this.userGroups.clear();
    if (userGroups != null) {
      this.userGroups.addAll(userGroups);
    }
  }

  public Set<DepartmentCached> getDepartments() {
    return departments;
  }

  public void addDepartment(final DepartmentCached model) {
    departments.add(model);
  }

  public void setDepartments(final List<DepartmentCached> departments) {
    setDepartments(departments.stream().collect(Collectors.toSet()));
  }

  public void setDepartments(final Set<DepartmentCached> departments) {
    this.departments.clear();
    if (departments != null) {
      this.departments.addAll(departments);
    }
  }

  public Set<WorkflowTypeCached> getWorkflowTypes() {
    return workflowTypes;
  }

  public void addWorkflowType(final WorkflowTypeCached deputy) {
    workflowTypes.add(deputy);
  }

  public void setWorkflowTypes(final List<WorkflowTypeCached> workflowTypes) {
    setWorkflowTypes(workflowTypes.stream().collect(Collectors.toSet()));
  }

  public void setWorkflowTypes(final Set<WorkflowTypeCached> workflowTypes) {
    this.workflowTypes.clear();
    if (workflowTypes != null) {
      this.workflowTypes.addAll(workflowTypes);
    }
  }

  @Override
  public void reload() {

    if (!isNew()) {
      this.fromExists(companyDao.getById(getId()));

      reloadUserCashed();
      reloadUserGroupCasheds();
      reloadDepartmentCashed();
      reloadWorkflowTypeCashed();
    }

  }

  protected void reloadDepartmentCashed() {
    this.departments.clear();
    for (final Long itemId : departmentIds) {
      addDepartment(loadDepartmentCashed(itemId));
    }
  }

  protected void reloadUserCashed() {
    this.users.clear();
    for (final Long itemId : userIds) {
      addUser(loadUserCashed(itemId));
    }
  }

  protected void reloadWorkflowTypeCashed() {
    this.workflowTypes.clear();
    for (final Long itemId : workflowTypeIds) {
      addWorkflowType(loadWorkflowTypeCashed(itemId));
    }
  }

  protected void reloadUserGroupCasheds() {
    this.userGroups.clear();
    for (final Long groupId : groupIds) {
      addGroup(loadUserGroupCached(groupId));
    }
  }

  protected UserGroupCached loadUserGroupCached(final Long itemId) {
    final UserGroupCached cashed = new UserGroupCached(userGroupDao);
    cashed.setId(itemId);
    cashed.reload();
    return cashed;
  }

  protected WorkflowTypeCached loadWorkflowTypeCashed(final Long groupId) {
    final WorkflowTypeCached cashed = new WorkflowTypeCached(workflowTypeDao, workflowTypeStepDao);
    cashed.setId(groupId);
    cashed.reload();
    return cashed;
  }

  protected DepartmentCached loadDepartmentCashed(final Long itemId) {
    final DepartmentCached cashed = new DepartmentCached(departmentDao, departmentGroupDao);
    cashed.setId(itemId);
    cashed.reload();
    return cashed;
  }

  protected UserCached loadUserCashed(final Long itemId) {
    final UserCached cashed = new UserCached(userDao, userGroupDao, departmentDao, departmentGroupDao, workflowTypeDao,
        workflowTypeStepDao);
    cashed.setId(itemId);
    cashed.reload();
    return cashed;
  }
}

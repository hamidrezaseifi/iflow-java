package com.pth.iflow.core.model.cahced;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.pth.iflow.core.model.User;
import com.pth.iflow.core.storage.dao.IDepartmentDao;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;
import com.pth.iflow.core.storage.dao.IUserDao;
import com.pth.iflow.core.storage.dao.IUserGroupDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;

public class UserCached extends User implements ICachedModel {

  private final Set<UserGroupCached> groups = new HashSet<>();
  private final Set<DepartmentCached> departments = new HashSet<>();
  private final Set<DepartmentGroupCached> departmentGroups = new HashSet<>();
  private final Set<UserCached> deputies = new HashSet<>();

  private final IUserDao userDao;
  private final IUserGroupDao userGroupDao;
  private final IDepartmentDao departmentDao;
  private final IDepartmentGroupDao departmentGroupDao;
  private final IWorkflowTypeDao workflowTypeDao;
  private final IWorkflowTypeStepDao workflowTypeStepDao;

  public UserCached(@Autowired final IUserDao userDao, @Autowired final IUserGroupDao userGroupDao,
      @Autowired final IDepartmentDao departmentDao, @Autowired final IDepartmentGroupDao departmentGroupDao,
      @Autowired final IWorkflowTypeDao workflowTypeDao, @Autowired final IWorkflowTypeStepDao workflowTypeStepDao) {
    this.userDao = userDao;
    this.userGroupDao = userGroupDao;
    this.departmentDao = departmentDao;
    this.departmentGroupDao = departmentGroupDao;
    this.workflowTypeDao = workflowTypeDao;
    this.workflowTypeStepDao = workflowTypeStepDao;

  }

  public Set<UserGroupCached> getGroups() {
    return groups;
  }

  public void setGroups(final List<UserGroupCached> groups) {
    setGroups(groups.stream().collect(Collectors.toSet()));
  }

  public void addGroup(final UserGroupCached model) {
    groups.add(model);
  }

  public void setGroups(final Set<UserGroupCached> groups) {
    this.groups.clear();
    if (groups != null) {
      this.groups.addAll(groups);
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

  public Set<DepartmentGroupCached> getDepartmentGroups() {
    return departmentGroups;
  }

  public void addDepartmentGroup(final DepartmentGroupCached model) {
    departmentGroups.add(model);
  }

  public void setDepartmentGroups(final List<DepartmentGroupCached> departmentGroups) {
    setDepartmentGroups(departmentGroups.stream().collect(Collectors.toSet()));
  }

  public void setDepartmentGroups(final Set<DepartmentGroupCached> departmentGroups) {
    this.departmentGroups.clear();
    if (departmentGroups != null) {
      this.departmentGroups.addAll(departmentGroups);
    }
  }

  public Set<UserCached> getDeputies() {
    return deputies;
  }

  public void addDeputy(final UserCached deputy) {
    deputies.add(deputy);
  }

  public void setDeputies(final List<UserCached> deputies) {
    setDeputies(deputies.stream().collect(Collectors.toSet()));
  }

  public void setDeputies(final Set<UserCached> deputies) {
    this.deputies.clear();
    if (deputies != null) {
      this.deputies.addAll(deputies);
    }
  }

  @Override
  public void reload() {

    if (!isNew()) {
      this.fromExists(userDao.getById(getId()));

      reloadUserGroupCasheds();
      reloadDepartmentCashed();
      reloadDepartmentGroupCashed();
      reloadDeputyCashed();
    }

  }

  protected void reloadDepartmentCashed() {
    this.departments.clear();
    for (final Long itemId : departmentIds) {
      addDepartment(loadDepartmentCashed(itemId));
    }
  }

  protected void reloadDeputyCashed() {
    this.deputies.clear();
    for (final Long itemId : deputyIds) {
      addDeputy(loadDeputyCashed(itemId));
    }
  }

  protected void reloadDepartmentGroupCashed() {
    this.departmentGroups.clear();
    for (final Long itemId : departmentGroupIds) {
      addDepartmentGroup(loadDepartmentGroupCashed(itemId));
    }
  }

  protected void reloadUserGroupCasheds() {
    this.groups.clear();
    for (final Long groupId : groupIds) {
      addGroup(loadUserGroupCached(groupId));
    }
  }

  protected UserGroupCached loadUserGroupCached(final Long itemId) {
    final UserGroupCached depGrp = new UserGroupCached(userGroupDao);
    depGrp.setId(itemId);
    depGrp.reload();
    return depGrp;
  }

  protected DepartmentGroupCached loadDepartmentGroupCashed(final Long groupId) {
    final DepartmentGroupCached depGrp = new DepartmentGroupCached(departmentGroupDao);
    depGrp.setId(groupId);
    depGrp.reload();
    return depGrp;
  }

  protected DepartmentCached loadDepartmentCashed(final Long itemId) {
    final DepartmentCached depGrp = new DepartmentCached(departmentDao, departmentGroupDao);
    depGrp.setId(itemId);
    depGrp.reload();
    return depGrp;
  }

  protected UserCached loadDeputyCashed(final Long itemId) {
    final UserCached depGrp = new UserCached(userDao, userGroupDao, departmentDao, departmentGroupDao, workflowTypeDao,
        workflowTypeStepDao);
    depGrp.setId(itemId);
    depGrp.reload();
    return depGrp;
  }

}

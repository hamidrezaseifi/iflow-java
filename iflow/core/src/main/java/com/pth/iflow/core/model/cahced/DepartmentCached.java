package com.pth.iflow.core.model.cahced;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.storage.dao.IDepartmentDao;
import com.pth.iflow.core.storage.dao.IDepartmentGroupDao;

public class DepartmentCached extends Department implements ICachedModel {

  protected Set<DepartmentGroupCached> groups = new HashSet<>();

  private final IDepartmentDao departmentDao;
  private final IDepartmentGroupDao departmentGroupDao;

  public DepartmentCached(@Autowired final IDepartmentDao departmentDao, @Autowired final IDepartmentGroupDao departmentGroupDao) {
    this.departmentDao = departmentDao;
    this.departmentGroupDao = departmentGroupDao;

  }

  public Set<DepartmentGroupCached> getGroups() {
    return groups;
  }

  public void setGroups(final List<DepartmentGroupCached> groups) {
    setGroups(groups.stream().collect(Collectors.toSet()));
  }

  public void addGroup(final DepartmentGroupCached model) {
    groups.add(model);
  }

  public void setGroups(final Set<DepartmentGroupCached> groups) {
    this.groups.clear();
    if (groups != null) {
      this.groups.addAll(groups);
    }
  }

  @Override
  public void reload() {

    if (!isNew()) {
      this.fromExists(departmentDao.getById(getId()));
      this.groups.clear();
      for (final Long groupId : groupIds) {
        addGroup(loadDepartmentGroupCashed(groupId));
      }
    }

  }

  protected DepartmentGroupCached loadDepartmentGroupCashed(final Long groupId) {
    final DepartmentGroupCached depGrp = new DepartmentGroupCached(departmentGroupDao);
    depGrp.setId(groupId);
    depGrp.reload();
    return depGrp;
  }
}

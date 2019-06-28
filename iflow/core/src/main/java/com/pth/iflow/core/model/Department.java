package com.pth.iflow.core.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pth.iflow.common.edo.models.DepartmentEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;

public class Department extends ModelMapperBase<DepartmentEdo, Department> {

  protected Long id;
  protected Long companyId;
  protected String title;
  protected Integer status;
  protected Integer version;
  protected LocalDateTime createdAt;
  protected LocalDateTime updatedAt;
  protected final Set<Long> groupIds = new HashSet<>();

  @Override
  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getCompanyId() {
    return this.companyId;
  }

  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(final Integer status) {
    this.status = status;
  }

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Set<Long> getGroupIds() {
    return this.groupIds;
  }

  public void setGroupIds(final Set<Long> groupIds) {
    this.groupIds.clear();
    if (groupIds != null) {
      this.groupIds.addAll(groupIds);
    }
  }

  public void setGroupIds(final List<Long> groupIds) {
    this.groupIds.clear();
    if (groupIds != null) {
      this.groupIds.addAll(groupIds);
    }
  }

  public void addGroupId(final Long groupId) {
    this.groupIds.add(groupId);
  }

  @Override
  public DepartmentEdo toEdo() {
    final DepartmentEdo edo = new DepartmentEdo();
    edo.setTitle(this.title);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setCompanyId(this.companyId);
    edo.setGroups(this.groupIds);

    return edo;
  }

  @Override
  public Department fromEdo(final DepartmentEdo edo) {
    final Department model = new Department();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    model.setGroupIds(edo.getGroups());

    return model;
  }

  @Override
  public void fromExists(final Department exist) {
    setTitle(exist.getTitle());
    setStatus(exist.getStatus());
    setId(exist.getId());
    setCompanyId(exist.getCompanyId());
    setGroupIds(exist.getGroupIds());
    setVersion(exist.getVersion());
    setCreatedAt(exist.getCreatedAt());
    setUpdatedAt(exist.getUpdatedAt());
  }

}

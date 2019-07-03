package com.pth.iflow.core.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pth.iflow.common.edo.models.DepartmentEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;

public class Department extends ModelMapperBase<DepartmentEdo, Department> {

  private Long id;
  private Long companyId;
  private String title;
  private Integer status;
  private Integer version;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private final Set<Long> groups = new HashSet<>();

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

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
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

  public Set<Long> getGroups() {
    return this.groups;
  }

  public void setGroups(final Set<Long> groups) {
    this.groups.clear();
    if (groups != null) {
      this.groups.addAll(groups);
    }
  }

  public void setGroups(final List<Long> groups) {
    this.groups.clear();
    if (groups != null) {
      this.groups.addAll(groups);
    }
  }

  public void addGroup(final Long groupId) {
    this.groups.add(groupId);
  }

  @Override
  public DepartmentEdo toEdo() {
    final DepartmentEdo edo = new DepartmentEdo();
    edo.setTitle(this.title);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setCompanyId(this.companyId);
    edo.setGroups(this.groups);
    edo.setVersion(version);

    return edo;
  }

  @Override
  public Department fromEdo(final DepartmentEdo edo) {
    final Department model = new Department();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    model.setGroups(edo.getGroups());
    model.setVersion(edo.getVersion());

    return model;
  }

}

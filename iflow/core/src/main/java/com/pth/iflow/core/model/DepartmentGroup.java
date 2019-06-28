package com.pth.iflow.core.model;

import java.time.LocalDateTime;

import com.pth.iflow.common.edo.models.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;

public class DepartmentGroup extends ModelMapperBase<DepartmentGroupEdo, DepartmentGroup> {

  protected Long id;
  protected Long departmentId;
  protected String title;
  protected Integer status;
  protected Integer version;
  protected LocalDateTime createdAt;
  protected LocalDateTime updatedAt;

  @Override
  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getDepartmentId() {
    return this.departmentId;
  }

  public void setDepartmentId(final Long departmentId) {
    this.departmentId = departmentId;
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

  @Override
  public DepartmentGroupEdo toEdo() {
    final DepartmentGroupEdo edo = new DepartmentGroupEdo();
    edo.setTitle(this.title);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setDepartmentId(this.departmentId);

    return edo;
  }

  @Override
  public DepartmentGroup fromEdo(final DepartmentGroupEdo edo) {
    final DepartmentGroup model = new DepartmentGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setDepartmentId(edo.getDepartmentId());

    return model;
  }

  @Override
  public void fromExists(final DepartmentGroup exist) {
    setTitle(exist.getTitle());
    setStatus(exist.getStatus());
    setId(exist.getId());
    setDepartmentId(exist.getDepartmentId());
    setVersion(exist.getVersion());
    setCreatedAt(exist.getCreatedAt());
    setUpdatedAt(exist.getUpdatedAt());
  }

}

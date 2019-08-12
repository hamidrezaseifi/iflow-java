package com.pth.iflow.workflow.models;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.DepartmentGroupEdo;

public class DepartmentGroup extends ModelMapperBase<DepartmentGroupEdo, DepartmentGroup> {

  private Long    id;
  private Long    departmentId;
  private String  title;
  private Integer status;
  private Integer version;

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

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  @Override
  public DepartmentGroupEdo toEdo() {
    final DepartmentGroupEdo edo = new DepartmentGroupEdo();
    edo.setTitle(this.title);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setDepartmentId(this.departmentId);
    edo.setVersion(version);

    return edo;
  }

  @Override
  public DepartmentGroup fromEdo(final DepartmentGroupEdo edo) {
    final DepartmentGroup model = new DepartmentGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setDepartmentId(edo.getDepartmentId());
    model.setVersion(edo.getVersion());

    return model;
  }

}

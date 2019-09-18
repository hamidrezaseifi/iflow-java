package com.pth.iflow.profile.model;

import com.pth.iflow.common.edo.models.base.DataModelBase;
import com.pth.iflow.common.edo.models.xml.DepartmentGroupEdo;

public class DepartmentGroup extends DataModelBase<DepartmentGroupEdo, DepartmentGroup> {

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

}

package com.pth.iflow.workflow.models;

import com.pth.iflow.common.edo.models.helper.IdentityModel;

public class DepartmentGroup extends IdentityModel {

  private String  identity;
  private String  departmentIdentity;
  private String  title;
  private Integer status;
  private Integer version;

  public String getDepartmentIdentity() {
    return departmentIdentity;
  }

  public void setDepartmentIdentity(final String departmentIdentity) {
    this.departmentIdentity = departmentIdentity;
  }

  @Override
  public String getIdentity() {
    return identity;
  }

  @Override
  public void setIdentity(final String identity) {
    this.identity = identity;
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

}

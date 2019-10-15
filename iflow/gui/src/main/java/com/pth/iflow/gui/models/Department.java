package com.pth.iflow.gui.models;

import java.util.ArrayList;
import java.util.List;
import com.pth.iflow.common.edo.models.helper.IdentityModel;

public class Department extends IdentityModel {

  private String  companyIdentity;
  private String  identity;
  private String  title;
  private Integer status;
  private Integer version;

  private final List<DepartmentGroup> departmentGroups = new ArrayList<>();

  @Override
  public String getIdentity() {
    return identity;
  }

  @Override
  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public String getCompanyIdentity() {
    return companyIdentity;
  }

  public void setCompanyIdentity(final String companyIdentity) {
    this.companyIdentity = companyIdentity;
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

  public List<DepartmentGroup> getDepartmentGroups() {
    return this.departmentGroups;
  }

  public void setDepartmentGroups(final List<DepartmentGroup> groups) {
    this.departmentGroups.clear();
    if (groups != null) {
      this.departmentGroups.addAll(groups);
    }
  }

  public void addDepartmentGroup(final DepartmentGroup group) {
    this.departmentGroups.add(group);
  }

}

package com.pth.iflow.backend.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.DepartmentEdo;
import com.pth.iflow.common.edo.models.base.DataModelBase;

public class BackendDepartment extends DataModelBase<DepartmentEdo, BackendDepartment> {

  private Long                               id;
  private Long                               companyId;
  private String                             title;
  private Integer                            status;
  private Integer                            version;
  private final List<BackendDepartmentGroup> departmentGroups = new ArrayList<>();

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

  public List<BackendDepartmentGroup> getDepartmentGroups() {
    return this.departmentGroups;
  }

  public void setDepartmentGroups(final List<BackendDepartmentGroup> groups) {
    this.departmentGroups.clear();
    if (groups != null) {
      this.departmentGroups.addAll(groups);
    }
  }

  public void addDepartmentGroup(final BackendDepartmentGroup group) {
    this.departmentGroups.add(group);
  }

}

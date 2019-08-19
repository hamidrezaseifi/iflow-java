package com.pth.iflow.backend.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.DepartmentEdo;

public class BackendDepartment extends ModelMapperBase<DepartmentEdo, BackendDepartment> {

  private Long                        id;
  private Long                        companyId;
  private String                      title;
  private Integer                     status;
  private Integer                     version;
  private final List<BackendDepartmentGroup> departmentGroups = new ArrayList<>();

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

  @Override
  public DepartmentEdo toEdo() {
    final DepartmentEdo edo = new DepartmentEdo();
    edo.setTitle(this.title);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setCompanyId(this.companyId);
    edo.setDepartmentGroups(ModelMapperBase.toEdoList(this.departmentGroups));
    edo.setVersion(this.version);

    return edo;
  }

  @Override
  public BackendDepartment fromEdo(final DepartmentEdo edo) {
    final BackendDepartment model = new BackendDepartment();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    model.setDepartmentGroups(new BackendDepartmentGroup().fromEdoList(edo.getDepartmentGroups()));
    model.setVersion(edo.getVersion());

    return model;
  }

}

package com.pth.iflow.core.model;

import com.pth.iflow.common.edo.models.DepartmentGroupEdo;

public class DepartmentGroup extends ModelMapperBase<DepartmentGroupEdo, DepartmentGroup> {
  private Long id;
  private Long departmentId;
  private String title;
  private Integer status;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getDerpartmentId() {
    return departmentId;
  }

  public void setDerpartmentId(final Long workflowId) {
    this.departmentId = workflowId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(final Integer status) {
    this.status = status;
  }

  @Override
  public DepartmentGroupEdo toEdo() {
    final DepartmentGroupEdo edo = new DepartmentGroupEdo();
    edo.setTitle(title);
    edo.setStatus(status);
    edo.setId(id);
    edo.setDerpartmentId(departmentId);

    return edo;
  }

  @Override
  public DepartmentGroup fromEdo(final DepartmentGroupEdo edo) {
    final DepartmentGroup model = new DepartmentGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setDerpartmentId(edo.getDerpartmentId());

    return model;
  }

}

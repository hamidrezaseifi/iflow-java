package com.pth.iflow.core.model;

import com.pth.iflow.common.edo.models.DerpartmentGroupEdo;

public class DerpartmentGroup {
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

  public DerpartmentGroupEdo toEdo() {
    final DerpartmentGroupEdo edo = new DerpartmentGroupEdo();
    edo.setTitle(title);
    edo.setStatus(status);
    edo.setId(id);
    edo.setDerpartmentId(departmentId);

    return edo;
  }

  public static DerpartmentGroup fromEdo(final DerpartmentGroupEdo edo) {
    final DerpartmentGroup model = new DerpartmentGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setDerpartmentId(edo.getDerpartmentId());

    return model;
  }

}

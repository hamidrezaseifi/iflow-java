package com.pth.iflow.common.edo.models;

public class DepartmentGroupEdo {
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

}

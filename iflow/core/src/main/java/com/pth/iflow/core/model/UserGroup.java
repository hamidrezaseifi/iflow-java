package com.pth.iflow.core.model;

import com.pth.iflow.common.edo.models.UserGroupEdo;

public class UserGroup extends ModelMapperBase<UserGroupEdo, UserGroup> {
  private Long id;
  private Long companyId;
  private String title;
  private Integer status;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
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
  public UserGroupEdo toEdo() {
    final UserGroupEdo edo = new UserGroupEdo();
    edo.setTitle(title);
    edo.setStatus(status);
    edo.setId(id);
    edo.setCompanyId(companyId);

    return edo;
  }

  @Override
  public UserGroup fromEdo(final UserGroupEdo edo) {
    final UserGroup model = new UserGroup();

    model.setTitle(edo.getTitle());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());

    return model;
  }

}

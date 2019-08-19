package com.pth.iflow.backend.models;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.UserGroupEdo;

public class GuiUserGroup extends ModelMapperBase<UserGroupEdo, GuiUserGroup> {

  private Long    id;

  private Long    companyId;

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

  @Override
  public UserGroupEdo toEdo() {
    final UserGroupEdo edo = new UserGroupEdo();
    edo.setCompanyId(this.companyId);
    edo.setId(this.id);
    edo.setStatus(this.status);
    edo.setTitle(this.title);
    edo.setVersion(this.version);

    return edo;
  }

  @Override
  public GuiUserGroup fromEdo(final UserGroupEdo edo) {
    final GuiUserGroup model = new GuiUserGroup();
    model.setCompanyId(edo.getCompanyId());
    model.setId(edo.getId());
    model.setStatus(edo.getStatus());
    model.setTitle(edo.getTitle());
    model.setVersion(edo.getVersion());

    return model;
  }

}

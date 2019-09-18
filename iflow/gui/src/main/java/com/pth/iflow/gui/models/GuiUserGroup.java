package com.pth.iflow.gui.models;

import com.pth.iflow.common.edo.models.base.DataModelBase;
import com.pth.iflow.common.edo.models.xml.UserGroupEdo;

public class GuiUserGroup extends DataModelBase<UserGroupEdo, GuiUserGroup> {

  private Long id;

  private Long companyId;

  private String title;

  private Integer status;

  private Integer version;

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

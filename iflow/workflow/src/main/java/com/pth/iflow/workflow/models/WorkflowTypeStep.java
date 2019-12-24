package com.pth.iflow.workflow.models;

import com.pth.iflow.common.models.helper.IdentityModel;

public class WorkflowTypeStep extends IdentityModel {

  private String  identity;
  private String  title;
  private Integer stepIndex;
  private String  viewName;
  private Integer expireDays;
  private String  comments;
  private Integer status;
  private Integer version;

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

  /**
   * @return the stepIndex
   */
  public Integer getStepIndex() {
    return this.stepIndex;
  }

  /**
   * @param stepIndex the stepIndex to set
   */
  public void setStepIndex(final Integer stepIndex) {
    this.stepIndex = stepIndex;
  }

  public String getViewName() {
    return this.viewName;
  }

  public void setViewName(final String viewName) {
    this.viewName = viewName;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
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

  public Integer getExpireDays() {
    return expireDays;
  }

  public void setExpireDays(final Integer expireDays) {
    this.expireDays = expireDays;
  }

}

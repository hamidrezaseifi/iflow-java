package com.pth.iflow.common.edo.models;

public class WorkflowActionEdo {

  private Long id;
  private Long workflowId;
  private Long createdBy;
  private String action;
  private Long oldStep;
  private Long newStep;
  private String comments;
  private Integer status;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowId() {
    return workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public String getAction() {
    return action;
  }

  public void setAction(final String action) {
    this.action = action;
  }

  public Long getOldStep() {
    return oldStep;
  }

  public void setOldStep(final Long oldStep) {
    this.oldStep = oldStep;
  }

  public Long getNewStep() {
    return newStep;
  }

  public void setNewStep(final Long newStep) {
    this.newStep = newStep;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
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

}

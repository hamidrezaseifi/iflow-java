package com.pth.iflow.common.edo.models;

public class WorkflowEdo {

  private Long id;
  private Long workflowTypeId;
  private Long currentStep;
  private Long controller;
  private Long createdBy;
  private String title;
  private String comments;
  private Integer status;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowTypeId() {
    return workflowTypeId;
  }

  public void setWorkflowTypeId(final Long workflowTypeId) {
    this.workflowTypeId = workflowTypeId;
  }

  public Long getCurrentStep() {
    return currentStep;
  }

  public void setCurrentStep(final Long currentStep) {
    this.currentStep = currentStep;
  }

  public Long getController() {
    return controller;
  }

  public void setController(final Long controller) {
    this.controller = controller;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(final String title) {
    this.title = title;
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

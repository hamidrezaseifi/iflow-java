package com.pth.iflow.core.model;

import java.time.LocalDateTime;

import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;

public class Workflow extends ModelMapperBase<WorkflowEdo, Workflow> {

  private Long id;
  private Long workflowTypeId;
  private Long currentStep;
  private Long controller;
  private Long createdBy;
  private String title;
  private String comments;
  private Integer status;
  private Integer version;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

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

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean isNew() {
    return id == null || id <= 0;
  }

  @Override
  public WorkflowEdo toEdo() {
    final WorkflowEdo edo = new WorkflowEdo();
    edo.setTitle(this.title);
    edo.setComments(this.comments);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setController(controller);
    edo.setCurrentStep(currentStep);
    edo.setCreatedBy(createdBy);
    edo.setWorkflowTypeId(workflowTypeId);

    return edo;
  }

  @Override
  public Workflow fromEdo(final WorkflowEdo edo) {
    final Workflow model = new Workflow();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setController(edo.getController());
    model.setCurrentStep(edo.getCurrentStep());
    model.setCreatedBy(edo.getCreatedBy());
    model.setWorkflowTypeId(edo.getWorkflowTypeId());

    return model;
  }

}

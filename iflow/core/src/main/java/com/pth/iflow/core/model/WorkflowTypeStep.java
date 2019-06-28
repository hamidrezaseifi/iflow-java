package com.pth.iflow.core.model;

import java.time.LocalDateTime;

import com.pth.iflow.common.edo.models.WorkflowTypeStepEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;

public class WorkflowTypeStep extends ModelMapperBase<WorkflowTypeStepEdo, WorkflowTypeStep> {

  protected Long id;
  protected Long workflowTypeId;
  protected String title;
  protected String comments;
  protected Integer status;
  protected Integer version;
  protected LocalDateTime createdAt;
  protected LocalDateTime updatedAt;

  @Override
  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowTypeId() {
    return this.workflowTypeId;
  }

  public void setWorkflowTypeId(final Long workflowTypeId) {
    this.workflowTypeId = workflowTypeId;
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
  public WorkflowTypeStepEdo toEdo() {
    final WorkflowTypeStepEdo edo = new WorkflowTypeStepEdo();
    edo.setTitle(this.title);
    edo.setComments(this.comments);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setWorkflowTypeId(this.workflowTypeId);

    return edo;
  }

  @Override
  public WorkflowTypeStep fromEdo(final WorkflowTypeStepEdo edo) {
    final WorkflowTypeStep model = new WorkflowTypeStep();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setWorkflowTypeId(edo.getWorkflowTypeId());

    return model;
  }

  @Override
  public void fromExists(final WorkflowTypeStep exist) {
    setTitle(exist.getTitle());
    setComments(exist.getComments());
    setStatus(exist.getStatus());
    setId(exist.getId());
    setWorkflowTypeId(exist.getWorkflowTypeId());
    setVersion(exist.getVersion());
    setCreatedAt(exist.getCreatedAt());
    setUpdatedAt(exist.getUpdatedAt());
  }

}

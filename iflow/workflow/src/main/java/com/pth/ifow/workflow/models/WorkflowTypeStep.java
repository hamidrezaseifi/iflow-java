package com.pth.ifow.workflow.models;

import java.time.LocalDateTime;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.json.WorkflowTypeStepJsonEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepEdo;

public class WorkflowTypeStep extends ModelMapperBase<WorkflowTypeStepEdo, WorkflowTypeStepJsonEdo, WorkflowTypeStep> {

  private Long          id;
  private Long          workflowTypeId;
  private String        title;
  private Integer       stepIndex;
  private String        comments;
  private Integer       status;
  private Integer       version;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

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

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
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

  public boolean isAfterStep(final WorkflowTypeStep other) {
    return stepIndex > other.getStepIndex();
  }

  public boolean isBeforeStep(final WorkflowTypeStep other) {
    return stepIndex < other.getStepIndex();
  }

  public boolean isTheSameStep(final WorkflowTypeStep other) {
    return stepIndex == other.getStepIndex();
  }

  @Override
  public WorkflowTypeStepEdo toEdo() {
    final WorkflowTypeStepEdo edo = new WorkflowTypeStepEdo();
    edo.setStepIndex(this.stepIndex);
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

    model.setStepIndex(edo.getStepIndex());
    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setWorkflowTypeId(edo.getWorkflowTypeId());

    return model;
  }

  @Override
  public WorkflowTypeStep fromJsonEdo(final WorkflowTypeStepJsonEdo edo) {
    final WorkflowTypeStep model = new WorkflowTypeStep();

    model.setStepIndex(edo.getStepIndex());
    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setWorkflowTypeId(edo.getWorkflowTypeId());

    return model;
  }

  @Override
  public WorkflowTypeStepJsonEdo toJsonEdo() {
    final WorkflowTypeStepJsonEdo edo = new WorkflowTypeStepJsonEdo();
    edo.setStepIndex(this.stepIndex);
    edo.setTitle(this.title);
    edo.setComments(this.comments);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setWorkflowTypeId(this.workflowTypeId);

    return edo;
  }

}

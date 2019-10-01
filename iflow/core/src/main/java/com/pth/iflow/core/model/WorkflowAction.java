package com.pth.iflow.core.model;

import java.time.LocalDateTime;

import com.pth.iflow.common.edo.models.base.DataModelBase;

public class WorkflowAction extends DataModelBase {

  private Long          id;
  private Long          workflowId;
  private Long          createdBy;
  private String        action;
  private Long          assignTo;
  private Long          oldStep;
  private Long          newStep;
  private Long          nextAssign;
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

  public Long getWorkflowId() {
    return this.workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public String getAction() {
    return this.action;
  }

  public void setAction(final String action) {
    this.action = action;
  }

  public Long getOldStep() {
    return this.oldStep;
  }

  public void setOldStep(final Long oldStep) {
    this.oldStep = oldStep;
  }

  public Long getNewStep() {
    return this.newStep;
  }

  public void setNewStep(final Long newStep) {
    this.newStep = newStep;
  }

  public Long getNextAssign() {
    return this.nextAssign;
  }

  public void setNextAssign(final Long nextAssign) {
    this.nextAssign = nextAssign;
  }

  public Long getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  public Long getAssignTo() {
    return this.assignTo;
  }

  public void setAssignTo(final Long assignTo) {
    this.assignTo = assignTo;
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

}

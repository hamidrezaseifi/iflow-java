package com.pth.iflow.workflow.models;

import java.time.LocalDateTime;

public class WorkflowAction {

  private Long          id;
  private String        identity;
  private Long          workflowId;
  private Long          assignTo;
  private Long          currentStepId;
  private String        assignToIdentity;
  private String        currentStepIdentity;
  private String        comments;
  private Integer       status;
  private Integer       version;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getIdentity() {
    return identity;
  }

  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public Long getWorkflowId() {
    return this.workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public Long getAssignTo() {
    return assignTo;
  }

  public void setAssignTo(final Long assignTo) {
    this.assignTo = assignTo;
  }

  public Long getCurrentStepId() {
    return currentStepId;
  }

  public void setCurrentStepId(final Long currentStepId) {
    this.currentStepId = currentStepId;
  }

  public String getAssignToIdentity() {
    return assignToIdentity;
  }

  public void setAssignToIdentity(final String assignToIdentity) {
    this.assignToIdentity = assignToIdentity;
  }

  public String getCurrentStepIdentity() {
    return currentStepIdentity;
  }

  public void setCurrentStepIdentity(final String currentStepIdIdentity) {
    this.currentStepIdentity = currentStepIdIdentity;
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

}

package com.pth.iflow.workflow.models;

import java.time.LocalDateTime;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;

public class WorkflowMessage {

  private Long                   id;

  private Workflow               workflow;

  private String                 workflowIdentity;

  private String                 stepIdentity;

  private String                 userIdentity;

  private String                 createdByIdentity;

  private Long                   stepId;

  private Long                   userId;

  private String                 message;

  private Long                   createdBy;

  private EWorkflowMessageType   messageType;

  private EWorkflowMessageStatus status;

  private Integer                version;

  private Integer                expireDays;

  private LocalDateTime          createdAt;

  private LocalDateTime          updatedAt;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Workflow getWorkflow() {
    return workflow;
  }

  public void setWorkflow(final Workflow workflow) {
    this.workflow = workflow;
  }

  public String getWorkflowIdentity() {
    return workflowIdentity;
  }

  public void setWorkflowIdentity(final String workflowIdentity) {
    this.workflowIdentity = workflowIdentity;
  }

  public String getStepIdentity() {
    return stepIdentity;
  }

  public void setStepIdentity(final String stepIdentity) {
    this.stepIdentity = stepIdentity;
  }

  public String getUserIdentity() {
    return userIdentity;
  }

  public void setUserIdentity(final String userIdentity) {
    this.userIdentity = userIdentity;
  }

  public Long getStepId() {
    return stepId;
  }

  public void setStepId(final Long stepId) {
    this.stepId = stepId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  public String getCreatedByIdentity() {
    return createdByIdentity;
  }

  public void setCreatedByIdentity(final String createdByIdentity) {
    this.createdByIdentity = createdByIdentity;
  }

  public EWorkflowMessageType getMessageType() {
    return messageType;
  }

  public void setMessageType(final EWorkflowMessageType messageType) {
    this.messageType = messageType;
  }

  public EWorkflowMessageStatus getStatus() {
    return this.status;
  }

  public void setStatus(final EWorkflowMessageStatus status) {
    this.status = status;
  }

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  public boolean isExpired() {
    return this.createdAt.plusDays(this.expireDays).isAfter(LocalDateTime.now());
  }

  public boolean isNotExpired() {
    return this.isExpired() == false;
  }

  public Integer getExpireDays() {
    return this.expireDays;
  }

  public void setExpireDays(final Integer expireDays) {
    this.expireDays = expireDays;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

}

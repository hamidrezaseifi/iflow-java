package com.pth.iflow.core.model;

import java.time.LocalDateTime;

import com.pth.iflow.common.edo.models.base.DataModelBase;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;

public class WorkflowMessage extends DataModelBase {

  private Long                 id;

  private Long                 workflowId;

  private Long                 userId;

  private Long                 createdBy;

  private EWorkflowMessageStatus status;

  private Integer              version;

  private LocalDateTime        createdAt;

  private LocalDateTime        updatedAt;

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

  public Long getUserId() {
    return this.userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  public EWorkflowMessageStatus getStatus() {
    return this.status;
  }

  public void setStatus(final EWorkflowMessageStatus status) {
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
    return createdAt;
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

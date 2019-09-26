package com.pth.iflow.gui.models;

import java.time.LocalDateTime;
import com.pth.iflow.common.edo.models.base.DataModelBase;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;

public class GuiWorkflowMessage extends DataModelBase {

  private Long id;

  private Long workflowId;

  private Long userId;

  private String message;

  private Long createdBy;

  private EWorkflowMessageType messageType;

  private EWorkflowMessageStatus status;

  private Integer version;

  private LocalDateTime expired;

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

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public Long getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
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

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  public LocalDateTime getExpired() {
    return expired;
  }

  public void setExpired(final LocalDateTime expired) {
    this.expired = expired;
  }

}

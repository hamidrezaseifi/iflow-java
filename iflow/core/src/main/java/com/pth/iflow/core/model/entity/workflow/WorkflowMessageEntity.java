package com.pth.iflow.core.model.entity.workflow;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.core.storage.dao.helper.EntityIdentityHelper;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@EntityListeners(EntityListener.class)
@Table(name = "workflow_message")
public class WorkflowMessageEntity extends EntityIdentityHelper {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long    id;

  @Column(name = "workflow_id")
  private Long    workflowId;

  @Column(name = "step_id")
  private Long    stepId;

  @Column(name = "user_id")
  private Long    userId;

  @Column(name = "message")
  private String  message;

  @Column(name = "created_by")
  private Long    createdBy;

  @Column(name = "message_type")
  private Integer messageType;

  @Column(name = "status")
  private Integer status;

  @Column(name = "version")
  private Integer version;

  @Column(name = "expire_days")
  private Integer expireDays;

  @CreationTimestamp
  @Column(name = "created_at")
  private Date    createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date    updatedAt;

  public WorkflowMessageEntity() {

  }

  @Override
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

  public Integer getMessageType() {
    return messageType;
  }

  public EWorkflowMessageType getMessageTypeEnum() {
    return EWorkflowMessageType.ofValue(messageType);
  }

  public void setMessageType(final Integer messageType) {
    this.messageType = messageType;
  }

  public void setMessageTypeEnum(final EWorkflowMessageType messageType) {
    this.messageType = messageType.getValue();
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(final Integer status) {
    this.status = status;
  }

  public EWorkflowMessageStatus getStatusEnum() {
    return EWorkflowMessageStatus.ofValue(status);
  }

  public void setStatusEnum(final EWorkflowMessageStatus status) {
    this.status = status.getValue();
  }

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  public Integer getExpireDays() {
    return this.expireDays;
  }

  public void setExpireDays(final Integer expireDays) {
    this.expireDays = expireDays;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(final Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String getIdentity() {

    return "";
  }

  @Override
  public void setIdentity(final String identity) {

  }

  @Override
  public String getIdentityPreffix() {

    return "";
  }

  @Override
  public void increaseVersion() {
    version += 1;
  }

  public void updateFromExists(final WorkflowMessageEntity exists) {
    if (exists == null) {
      return;
    }
    this.createdBy = exists.createdBy;
    this.expireDays = exists.expireDays;
    this.id = exists.id;
    this.message = exists.message;
    this.messageType = exists.messageType;
    this.status = exists.status;
    this.version = exists.version;
    this.stepId = exists.stepId;
    this.userId = exists.userId;
    this.workflowId = exists.workflowId;

  }
}

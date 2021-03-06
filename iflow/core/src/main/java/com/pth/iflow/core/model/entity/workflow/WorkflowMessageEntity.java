package com.pth.iflow.core.model.entity.workflow;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.metamodel.SingularAttribute;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.helper.EntityIdentityHelper;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@EntityListeners(EntityListener.class)
@Table(name = "workflow_message")
public class WorkflowMessageEntity extends EntityIdentityHelper {

  private static final long serialVersionUID = -3112387006573750725L;

  public static volatile SingularAttribute<WorkflowEntity, Long> workflowAttr;
  public static volatile SingularAttribute<WorkflowTypeStepEntity, Long> stepAttr;
  public static volatile SingularAttribute<UserEntity, Long> userAttr;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "workflow_id")
  private Long workflowId;

  @Column(name = "step_id")
  private Long stepId;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "message")
  private String message;

  @Column(name = "created_by")
  private Long createdById;

  @Column(name = "message_type")
  private Integer messageType;

  @Column(name = "status")
  private Integer status;

  @Column(name = "version")
  private Integer version;

  @Column(name = "expire_days")
  private Integer expireDays;

  @CreationTimestamp
  @Column(name = "created_at", insertable = false, updatable = false)
  private Date createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", insertable = false, updatable = false)
  private Date updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workflow_id", nullable = false, insertable = false, updatable = false)
  private WorkflowEntity workflow;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "step_id", nullable = false, insertable = false, updatable = false)
  private WorkflowTypeStepEntity step;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
  private UserEntity user;

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

  public Long getCreatedById() {

    return createdById;
  }

  public void setCreatedById(final Long createdBy) {

    this.createdById = createdBy;
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
    this.createdById = exists.createdById;
    this.expireDays = exists.expireDays;
    this.message = exists.message;
    this.messageType = exists.messageType;
    this.status = exists.status;
    this.version = exists.version;
    this.stepId = exists.stepId;
    this.userId = exists.userId;
    this.workflowId = exists.workflowId;

  }

}

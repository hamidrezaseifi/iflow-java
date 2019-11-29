package com.pth.iflow.core.model.entity.workflow;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.helper.EntityHelper;

@Entity
@Table(name = "workflow_message")
public class WorkflowMessageEntity extends EntityHelper {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                   id;

  // @Column(name = "workflow_id")
  // private Long workflowId;

  @Column(name = "step_id")
  private Long                   stepId;

  @Column(name = "user_id")
  private Long                   userId;

  @Column(name = "message")
  private String                 message;

  @Column(name = "created_by")
  private Long                   createdBy;

  @Column(name = "message_type")
  private Integer                messageType;

  @Column(name = "status")
  private Integer                status;

  @Column(name = "version")
  private Integer                version;

  @Column(name = "expire_days")
  private Integer                expireDays;

  @Column(name = "created_at", insertable = false, updatable = false)
  private Date                   createdAt;

  @Column(name = "updated_at", insertable = false, updatable = false)
  private Date                   updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "step_id", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private WorkflowTypeStepEntity step;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private UserEntity             user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "created_by", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private UserEntity             createdByUser;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workflow_id", insertable = false, updatable = false)
  private WorkflowEntity         workflow;

  public WorkflowMessageEntity() {
    step = new WorkflowTypeStepEntity();
    user = new UserEntity();
    createdByUser = new UserEntity();
    workflow = new WorkflowEntity();

  }

  @Override
  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  /*
   * public Long getWorkflowId() { return workflowId; }
   *
   * public void setWorkflowId(final Long workflowId) { this.workflowId =
   * workflowId; }
   */

  public String getWorkflowIdentity() {
    return workflow.getIdentity();
  }

  public String getStepIdentity() {
    return step.getIdentity();
  }

  public String getUserIdentity() {
    return user.getIdentity();
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
    return createdByUser.getIdentity();
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

  public WorkflowTypeStepEntity getStep() {
    return step;
  }

  public void setStep(final WorkflowTypeStepEntity step) {
    this.step = step;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(final UserEntity user) {
    this.user = user;
  }

  public UserEntity getCreatedByUser() {
    return createdByUser;
  }

  public void setCreatedByUser(final UserEntity createdByUser) {
    this.createdByUser = createdByUser;
  }

  public WorkflowEntity getWorkflow() {
    return workflow;
  }

  public void setWorkflow(final WorkflowEntity workflow) {
    this.workflow = workflow;
  }

}

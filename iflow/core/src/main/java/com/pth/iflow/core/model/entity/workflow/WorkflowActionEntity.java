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

import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.helper.EntityHelper;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@Table(name = "workflow_actions")
@EntityListeners(EntityListener.class)
public class WorkflowActionEntity extends EntityHelper {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                   id;

  @Column(name = "identity")
  private String                 identity;

  // @Column(name = "workflow_id")
  // private Long workflowId;

  @Column(name = "assign_to")
  private Long                   assignTo;

  @Column(name = "current_step_id")
  private Long                   currentStepId;

  @Column(name = "comments")
  private String                 comments;

  @Column(name = "status")
  private Integer                status;

  @Column(name = "version")
  private Integer                version;

  @Column(name = "created_at", insertable = false, updatable = false)
  private Date                   createdAt;

  @Column(name = "updated_at", insertable = false, updatable = false)
  private Date                   updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "assign_to", insertable = false, updatable = false)
  private UserEntity             assignToUser;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "current_step_id", insertable = false, updatable = false)
  private WorkflowTypeStepEntity currentStep;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workflow_id", insertable = false, updatable = false)
  private WorkflowEntity         workflow;

  public WorkflowActionEntity() {
    currentStep = new WorkflowTypeStepEntity();
    assignToUser = new UserEntity();
    assignTo = 0L;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  @Override
  public String getIdentity() {
    return identity;
  }

  @Override
  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  /*
   * public Long getWorkflowId() { return this.workflowId; }
   *
   * public void setWorkflowId(final Long workflowId) { this.workflowId =
   * workflowId; }
   */

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
    return assignToUser == null ? EIdentity.NOT_SET.getIdentity() : assignToUser.getIdentity();
  }

  public String getCurrentStepIdentity() {
    return currentStep.getIdentity();
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

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(final Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public UserEntity getAssignToUser() {
    return assignToUser;
  }

  public void setAssignToUser(final UserEntity assignToUser) {
    this.assignToUser = assignToUser;
  }

  public WorkflowTypeStepEntity getCurrentStep() {
    return currentStep;
  }

  public void setCurrentStep(final WorkflowTypeStepEntity currentStep) {
    this.currentStep = currentStep;
  }

  public WorkflowEntity getWorkflow() {
    return workflow;
  }

  public void setWorkflow(final WorkflowEntity workflow) {
    this.workflow = workflow;
  }

  @Override
  public String getIdentityPreffix() {

    return "wa";
  }

}

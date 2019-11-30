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
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.helper.EntityIdentityHelper;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@Table(name = "workflow_actions")
@EntityListeners(EntityListener.class)
public class WorkflowActionEntity extends EntityIdentityHelper {

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

  @CreationTimestamp
  @Column(name = "created_at")
  private Date                   createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date                   updatedAt;

  @Fetch(FetchMode.JOIN)
  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "assign_to", nullable = true, insertable = false, updatable = false)
  @NotFound(action = NotFoundAction.IGNORE)
  private UserEntity             assignToUser;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "current_step_id", insertable = false, updatable = false)
  private WorkflowTypeStepEntity currentStep;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workflow_id", insertable = false, updatable = false)
  private WorkflowEntity         workflow;

  @Transient
  private String                 assignToEdoIdentity;

  @Transient
  private String                 currentStepEdoIdentity;

  public WorkflowActionEntity() {

    // workflow = new WorkflowEntity();
    assignTo = 0L;
  }

  public WorkflowActionEntity(final String assignToEdoIdentity, final String currentStepEdoIdentity) {

    this.assignToEdoIdentity = assignToEdoIdentity;
    this.currentStepEdoIdentity = currentStepEdoIdentity;

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

  // public String getCurrentStepIdentity() {
  // return currentStep.getIdentity();
  // }

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

  public String getAssignToIdentity() {
    return assignToUser == null ? EIdentity.NOT_SET.getIdentity() : assignToUser.getIdentity();
  }

  public String getAssignToEdoIdentity() {
    return assignToEdoIdentity;
  }

  public String getCurrentStepEdoIdentity() {
    return currentStepEdoIdentity;
  }

  @Override
  public String getIdentityPreffix() {

    return "wa";
  }

  public void updateFromExists(final WorkflowActionEntity exists) {
    if (exists == null) {
      return;
    }

    this.comments = exists.comments;
    this.assignTo = exists.assignTo;
    this.currentStepId = exists.currentStepId;
    this.status = exists.status;
    this.version = exists.version;

  }

  @Override
  public void increaseVersion() {
    version += 1;
    workflow.increaseVersion();
  }
}

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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.core.model.entity.UserEntity;

@Entity
@Table(name = "workflow_actions")
public class WorkflowActionEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                   id;

  @Column(name = "comments")
  private String                 comments;

  @Column(name = "status")
  private Integer                status;

  @CreationTimestamp
  @Column(name = "created_at")
  private Date                   createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date                   updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workflow_id", nullable = false)
  private WorkflowEntity         workflowEntity;

  @ManyToOne
  @JoinColumn(name = "assign_to")
  private UserEntity             assignToUser;

  @ManyToOne
  @JoinColumn(name = "current_step_id")
  private WorkflowTypeStepEntity currentStep;

  public WorkflowActionEntity() {

    assignToUser = new UserEntity();
    assignToUser.setId(0L);

    currentStep = new WorkflowTypeStepEntity();

  }

  public WorkflowActionEntity(final String assignToEdoIdentity, final String currentStepEdoIdentity) {

    assignToUser = new UserEntity();
    assignToUser.setId(0L);
    assignToUser.setIdentity(assignToEdoIdentity);

    currentStep = new WorkflowTypeStepEntity();
    currentStep.setIdentity(currentStepEdoIdentity);

  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
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

  public String getAssignToIdentity() {
    return assignToUser == null ? EIdentity.NOT_SET.getIdentity() : assignToUser.getIdentity();
  }

  public String getAssignToEdoIdentity() {
    return assignToUser.getIdentity();
  }

  public String getCurrentStepEdoIdentity() {
    return currentStep.getIdentity();
  }

  public String getCurrentStepIdentity() {
    return currentStep.getIdentity();
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

  public WorkflowEntity getWorkflowEntity() {
    return workflowEntity;
  }

  public void setWorkflowEntity(final WorkflowEntity workflowEntity) {
    this.workflowEntity = workflowEntity;
  }

}

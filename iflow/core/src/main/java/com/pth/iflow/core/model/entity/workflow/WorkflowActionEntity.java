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
import javax.persistence.Transient;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "workflow_actions")
public class WorkflowActionEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "comments")
  private String comments;

  @Column(name = "assign_to")
  private Long assignToId;

  @Column(name = "current_step_id")
  private Long currentStepId;

  @Column(name = "status")
  private Integer status;

  @CreationTimestamp
  @Column(name = "created_at")
  private Date createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workflow_id", nullable = false)
  private WorkflowEntity workflowEntity;

  @Transient
  private final String currentStepIdentity;

  @Transient
  private final String assignToIdentity;

  public WorkflowActionEntity() {

    assignToId = 0L;

    this.currentStepIdentity = "";
    this.assignToIdentity = "";

  }

  public WorkflowActionEntity(final String assignToEdoIdentity, final String currentStepEdoIdentity) {

    assignToId = 0L;

    this.currentStepIdentity = currentStepEdoIdentity;
    this.assignToIdentity = assignToEdoIdentity;

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

  public Long getCurrentStepId() {
    return currentStepId;
  }

  public void setCurrentStepId(final Long currentStepId) {
    this.currentStepId = currentStepId;
  }

  public Long getAssignToId() {
    return assignToId;
  }

  public void setAssignToId(final Long assignToId) {
    this.assignToId = assignToId;
  }

  public String getCurrentStepIdentity() {
    return currentStepIdentity;
  }

  public String getAssignToIdentity() {
    return assignToIdentity;
  }

  public WorkflowEntity getWorkflowEntity() {
    return workflowEntity;
  }

  public void setWorkflowEntity(final WorkflowEntity workflowEntity) {
    this.workflowEntity = workflowEntity;
  }

}

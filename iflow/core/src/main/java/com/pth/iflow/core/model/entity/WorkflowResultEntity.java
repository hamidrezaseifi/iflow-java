package com.pth.iflow.core.model.entity;

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

import com.pth.iflow.common.enums.EWorkflowStatus;

@Entity
@Table(name = "workflow")
public class WorkflowResultEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                   id;

  @Column(name = "identity")
  private String                 identity;
//id, identity, workflow_type_id, current_step, status, comments, controller, created_by, version, created_at, updated_at
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workflow_type_id", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private WorkflowTypeEntity     workflowType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "current_step", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private WorkflowTypeStepEntity currentStep;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "controller", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private UserEntity             controller;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "created_by", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private UserEntity             createdBy;

  @Column(name = "status")
  private EWorkflowStatus        status;

  public WorkflowResultEntity() {

  }

  public String getIdentity() {
    return this.identity;
  }

  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public WorkflowTypeEntity getWorkflowType() {
    return workflowType;
  }

  public void setWorkflowType(final WorkflowTypeEntity workflowType) {
    this.workflowType = workflowType;
  }

  public WorkflowTypeStepEntity getCurrentStep() {
    return currentStep;
  }

  public void setCurrentStep(final WorkflowTypeStepEntity currentStep) {
    this.currentStep = currentStep;
  }

  public UserEntity getController() {
    return controller;
  }

  public void setController(final UserEntity controller) {
    this.controller = controller;
  }

  public UserEntity getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(final UserEntity createdBy) {
    this.createdBy = createdBy;
  }

  public EWorkflowStatus getStatus() {
    return this.status;
  }

  public void setStatus(final Integer status) {
    this.status = EWorkflowStatus.ofValue(status);
  }

  public void setStatus(final EWorkflowStatus status) {
    this.status = status;
  }
}

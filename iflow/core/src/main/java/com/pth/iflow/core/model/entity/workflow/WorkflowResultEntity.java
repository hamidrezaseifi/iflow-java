package com.pth.iflow.core.model.entity.workflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Subselect;
import com.pth.iflow.core.model.entity.UserEntity;

@Entity
@Subselect("SELECT " + "workflow.*, workflow_type.identity as workflow_type_identity, steps.identity as current_step_identity, "
    + "controlleruser.email as controller_identity,createdbyuser.email as createdby_identity  \r\n"
    + "FROM                                                                                   \r\n"
    + "(((workflow inner join workflow_type on workflow_type.id = workflow.workflow_type_id) \r\n"
    + "inner join workflow_type_step steps on steps.id = workflow.current_step)\r\n"
    + "left outer join users controlleruser on controlleruser.id = workflow.controller)\r\n"
    + "left outer join users createdbyuser on createdbyuser.id = workflow.created_by ")
public class WorkflowResultEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                   id;

  @Column(name = "identity")
  private String                 identity;

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

  @Column(name = "workflow_type_identity")
  private String                 workflowTypeIdentity;

  @Column(name = "current_step_identity")
  private String                 currentStepIdentity;

  @Column(name = "controller_identity")
  private String                 controllerIdentity;

  @Column(name = "createdby_identity")
  private String                 createdByIdentity;

  @Column(name = "status")
  private Integer                status;

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

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(final Integer status) {
    this.status = status;
  }

  public String getWorkflowTypeIdentity() {
    return workflowTypeIdentity;
  }

  public void setWorkflowTypeIdentity(final String workflowTypeIdentity) {
    this.workflowTypeIdentity = workflowTypeIdentity;
  }

  public String getCurrentStepIdentity() {
    return currentStepIdentity;
  }

  public void setCurrentStepIdentity(final String currentStepIdentity) {
    this.currentStepIdentity = currentStepIdentity;
  }

  public String getControllerIdentity() {
    return controllerIdentity;
  }

  public void setControllerIdentity(final String controllerIdentity) {
    this.controllerIdentity = controllerIdentity;
  }

  public String getCreatedByIdentity() {
    return createdByIdentity;
  }

  public void setCreatedByIdentity(final String createdByIdentity) {
    this.createdByIdentity = createdByIdentity;
  }

}

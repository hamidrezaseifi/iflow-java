package com.pth.iflow.workflow.models;

import com.pth.iflow.common.edo.models.base.WorkflowActionModelBase;
import com.pth.iflow.common.enums.EWorkflowActionStatus;

public class WorkflowAction extends WorkflowActionModelBase {

  private Long                  id;
  private Long                  workflowId;
  private Long                  assignTo;
  private Long                  currentStepId;
  private WorkflowTypeStep      currentStep;
  private String                comments;
  private EWorkflowActionStatus status;
  private Integer               version;

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

  public Long getAssignTo() {
    return this.assignTo;
  }

  public boolean isAssigned() {
    return (this.assignTo != null) && (this.assignTo > 0);
  }

  public void setAssignTo(final Long assignTo) {
    this.assignTo = assignTo;
  }

  public Long getCurrentStepId() {
    return currentStepId;
  }

  public void setCurrentStepId(final Long currectStepId) {
    this.currentStepId = currectStepId;
  }

  public WorkflowTypeStep getCurrentStep() {
    return currentStep;
  }

  public void setCurrentStep(final WorkflowTypeStep currentStep) {
    this.currentStep = currentStep;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  @Override
  public Integer getStatusInt() {
    return this.status.getValue();
  }

  public EWorkflowActionStatus getStatus() {
    return this.status;
  }

  public void setStatus(final EWorkflowActionStatus status) {
    this.status = status;
  }

  public void setStatus(final Integer status) {
    this.status = EWorkflowActionStatus.ofValue(status);
  }

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

}

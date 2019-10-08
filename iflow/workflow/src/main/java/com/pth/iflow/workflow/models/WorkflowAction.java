package com.pth.iflow.workflow.models;

import com.pth.iflow.common.enums.EWorkflowActionStatus;

public class WorkflowAction {

  private Long                  assignTo;
  private Long                  currentStepId;
  private WorkflowTypeStep      currentStep;
  private String                comments;
  private EWorkflowActionStatus status;
  private Integer               version;

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

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  public boolean getIsActive() {
    return EWorkflowActionStatus.getIsActive(this.getStatusInt());
  }
}

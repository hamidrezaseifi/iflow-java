package com.pth.iflow.workflow.models;

import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.models.helper.IdentityModel;

public class WorkflowAction {

  private String                assignToIdentity;
  private String                currentStepIdentity;
  private String                comments;
  private EWorkflowActionStatus status;

  private WorkflowTypeStep      currentStep;
  private User                  assignToUser;

  public String getAssignToIdentity() {
    return assignToIdentity;
  }

  public void setAssignToIdentity(final String assignToIdentity) {
    this.assignToIdentity = assignToIdentity;
  }

  public String getCurrentStepIdentity() {
    return currentStepIdentity;
  }

  public void setCurrentStepIdentity(final String currentStepIdIdentity) {
    this.currentStepIdentity = currentStepIdIdentity;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public EWorkflowActionStatus getStatus() {
    return this.status;
  }

  public void setStatus(final int status) {
    this.status = EWorkflowActionStatus.ofValue(status);
  }

  public void setStatus(final EWorkflowActionStatus status) {
    this.status = status;
  }

  public boolean isAssigned() {
    return IdentityModel.isIdentityNew(this.assignToIdentity) == false;
  }

  public boolean getIsActive() {
    return EWorkflowActionStatus.getIsActive(this.getStatus().getValue());
  }

  public WorkflowTypeStep getCurrentStep() {
    return currentStep;
  }

  public void setCurrentStep(final WorkflowTypeStep currentStep) {
    this.currentStep = currentStep;
  }

  public User getAssignToUser() {
    return assignToUser;
  }

  public void setAssignToUser(final User assignToUser) {
    this.assignToUser = assignToUser;
  }

}

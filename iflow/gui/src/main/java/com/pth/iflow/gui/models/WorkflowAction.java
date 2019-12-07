package com.pth.iflow.gui.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.pth.iflow.common.edo.models.helper.IdentityModel;
import com.pth.iflow.common.enums.EWorkflowActionStatus;

@JsonIgnoreProperties(value = { "running" })
public class WorkflowAction {

  private String                workflowIdentity;
  private String                assignToIdentity;
  private String                currentStepIdentity;
  private String                comments;
  private EWorkflowActionStatus status;

  private WorkflowTypeStep      currentStep;
  private User                  assignToUser;

  public String getWorkflowIdentity() {
    return this.workflowIdentity;
  }

  public void setWorkflowIdentity(final String workflowIdentity) {
    this.workflowIdentity = workflowIdentity;
  }

  public String getAssignToIdentity() {
    return this.assignToIdentity;
  }

  public void setAssignToIdentity(final String assignToIdentity) {
    this.assignToIdentity = assignToIdentity;
  }

  public String getCurrentStepIdentity() {
    return this.currentStepIdentity;
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

  @JsonSetter
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
    return this.currentStep;
  }

  public void setCurrentStep(final WorkflowTypeStep currentStep) {
    this.currentStep = currentStep;
  }

  public User getAssignToUser() {
    return this.assignToUser;
  }

  public void setAssignToUser(final User assignToUser) {
    this.assignToUser = assignToUser;
  }

  public String getAssignToUserName() {
    return this.assignToUser != null ? this.assignToUser.getIdentity() : "";
  }

  public boolean isAssignTo(final String userIdentity) {

    return IdentityModel.areSameIdentity(this.assignToIdentity, userIdentity);
  }

}

package com.pth.iflow.gui.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.pth.iflow.common.edo.models.helper.IdentityModel;
import com.pth.iflow.common.enums.EWorkflowActionStatus;

@JsonIgnoreProperties(value = { "running" })
public class WorkflowAction extends IdentityModel {

  private String                identity;
  private String                workflowIdentity;
  private String                assignToIdentity;
  private String                currentStepIdentity;
  private String                comments;
  private EWorkflowActionStatus status;
  private Integer               version;

  private WorkflowTypeStep currentStep;
  private User             assignToUser;
  private Workflow         workflow;

  @Override
  public String getIdentity() {
    return identity;
  }

  @Override
  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public String getWorkflowIdentity() {
    return workflowIdentity;
  }

  public void setWorkflowIdentity(final String workflowIdentity) {
    this.workflowIdentity = workflowIdentity;
  }

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

  @JsonSetter
  public void setStatus(final EWorkflowActionStatus status) {
    this.status = status;
  }

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  public boolean isAssigned() {
    return isIdentityNew(this.assignToIdentity) == false;
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

  public Workflow getWorkflow() {
    return workflow;
  }

  public void setWorkflow(final Workflow workflow) {
    this.workflow = workflow;
  }

  public String getAssignToUserName() {
    return this.assignToUser != null ? this.assignToUser.getIdentity() : "";
  }

  public boolean isAssignTo(final String userIdentity) {

    return IdentityModel.areSameIdentity(this.assignToIdentity, userIdentity);
  }

}

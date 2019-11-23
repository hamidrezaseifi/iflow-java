package com.pth.iflow.gui.models.workflow;

import com.pth.iflow.common.enums.EWorkflowStatus;

public class WorkflowResult {

  private String          identity;
  private String          workflowTypeIdentity;
  private String          currentStepIdentity;
  private String          controllerIdentity;
  private String          createdByIdentity;
  private EWorkflowStatus status;

  public WorkflowResult() {

  }

  public String getIdentity() {
    return this.identity;
  }

  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public String getWorkflowTypeIdentity() {
    return this.workflowTypeIdentity;
  }

  public void setWorkflowTypeIdentity(final String workflowTypeIdentity) {
    this.workflowTypeIdentity = workflowTypeIdentity;
  }

  public String getCurrentStepIdentity() {
    return this.currentStepIdentity;
  }

  public void setCurrentStepIdentity(final String currentStepIdentity) {
    this.currentStepIdentity = currentStepIdentity;
  }

  public String getControllerIdentity() {
    return this.controllerIdentity;
  }

  public void setControllerIdentity(final String controllerIdentity) {
    this.controllerIdentity = controllerIdentity;
  }

  public String getCreatedByIdentity() {
    return this.createdByIdentity;
  }

  public void setCreatedByIdentity(final String createdByIdentity) {
    this.createdByIdentity = createdByIdentity;
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

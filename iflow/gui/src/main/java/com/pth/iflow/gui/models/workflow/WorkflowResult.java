package com.pth.iflow.gui.models.workflow;

public class WorkflowResult {

  private String workflowIdentity;

  private String workflowTypeIdentity;

  public WorkflowResult() {

  }

  public WorkflowResult(final String workflowIdentity, final String workflowTypeIdentity) {
    this.workflowIdentity = workflowIdentity;
    this.workflowTypeIdentity = workflowTypeIdentity;
  }

  public String getWorkflowIdentity() {
    return this.workflowIdentity;
  }

  public void setWorkflowIdentity(final String workflowIdentity) {
    this.workflowIdentity = workflowIdentity;
  }

  public String getWorkflowTypeIdentity() {
    return this.workflowTypeIdentity;
  }

  public void setWorkflowTypeIdentity(final String workflowTypeIdentity) {
    this.workflowTypeIdentity = workflowTypeIdentity;
  }

}

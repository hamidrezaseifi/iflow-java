package com.pth.iflow.workflow.models.workflow.testthree;

import com.pth.iflow.workflow.models.workflow.Workflow;

public class TestThreeTaskWorkflow {

  private String   workflowIdentity;
  private Workflow workflow;

  public String getWorkflowIdentity() {
    return workflowIdentity;
  }

  public void setWorkflowIdentity(final String workflowIdentity) {
    this.workflowIdentity = workflowIdentity;
  }

  public Workflow getWorkflow() {
    return workflow;
  }

  public void setWorkflow(final Workflow workflow) {
    this.workflow = workflow;
  }
}

package com.pth.iflow.workflow.models;

import java.util.ArrayList;
import java.util.List;

public class WorkflowCreateRequest {

  private Workflow         workflow;

  private List<AssignItem> assigns = new ArrayList<>();

  public WorkflowCreateRequest() {

  }

  public WorkflowCreateRequest(final Workflow workflow, final List<AssignItem> assigns) {
    this.setWorkflow(workflow);
    this.setAssigns(assigns);
  }

  /**
   * @return the workflow
   */
  public Workflow getWorkflow() {
    return this.workflow;
  }

  /**
   * @param workflow the workflow to set
   */
  public void setWorkflow(final Workflow workflow) {
    this.workflow = workflow;
  }

  /**
   * @return the assignedUsers
   */
  public List<AssignItem> getAssigns() {
    return this.assigns;
  }

  /**
   * @param assignedUsers the assignedUsers to set
   */
  public void setAssigns(final List<AssignItem> assigns) {
    this.assigns = new ArrayList<>();
    if (assigns != null) {
      this.assigns.addAll(assigns);
    }
  }

}

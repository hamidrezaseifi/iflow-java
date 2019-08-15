package com.pth.iflow.workflow.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.xml.WorkflowCreateRequestEdo;

public class WorkflowCreateRequest {

  private Workflow workflow;

  private List<Long> assignedUsers = new ArrayList<>();

  public WorkflowCreateRequest() {

  }

  public WorkflowCreateRequest(final Workflow workflow, final List<Long> assignedUsers) {
    setWorkflow(workflow);
    setAssignedUsers(assignedUsers);
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
  public List<Long> getAssignedUsers() {
    return this.assignedUsers;
  }

  /**
   * @param assignedUsers the assignedUsers to set
   */
  public void setAssignedUsers(final List<Long> assignedUsers) {
    this.assignedUsers = new ArrayList<>();
    if (assignedUsers != null) {
      this.assignedUsers.addAll(assignedUsers);
    }
  }

  public WorkflowCreateRequestEdo toEdo() {
    final WorkflowCreateRequestEdo edo = new WorkflowCreateRequestEdo(this.workflow.toEdo(), this.assignedUsers);

    return edo;
  }

  public WorkflowCreateRequest fromEdo(final WorkflowCreateRequestEdo edo) {
    final WorkflowCreateRequest model = new WorkflowCreateRequest(new Workflow().fromEdo(edo.getWorkflow()),
                                                                  edo.getAssignedUsers());

    return model;
  }
}

package com.pth.iflow.backend.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.xml.WorkflowCreateRequestEdo;

public class BackendWorkflowCreateRequest {

  private BackendWorkflow workflow;

  private final List<Long> assigns = new ArrayList<>();

  public BackendWorkflowCreateRequest() {

  }

  public BackendWorkflowCreateRequest(final BackendWorkflow workflow) {
    super();
    this.setWorkflow(workflow);
  }

  public BackendWorkflowCreateRequest(final BackendWorkflow workflow, final List<Long> assigns) {
    super();
    this.setWorkflow(workflow);
    this.setAssigns(assigns);
  }

  /**
   * @return the workflow
   */
  public BackendWorkflow getWorkflow() {
    return this.workflow;
  }

  /**
   * @param workflow the workflow to set
   */
  public void setWorkflow(final BackendWorkflow workflow) {
    this.workflow = workflow;
  }

  /**
   * @return the assigns
   */
  public List<Long> getAssigns() {
    return this.assigns;
  }

  /**
   * @param assigns the assigns to set
   */
  public void setAssigns(final List<Long> assigns) {
    this.assigns.clear();
    if (assigns != null) {
      this.assigns.addAll(assigns);
    }
  }

  public WorkflowCreateRequestEdo toEdo() {
    final WorkflowCreateRequestEdo edo = new WorkflowCreateRequestEdo(this.workflow.toEdo(), this.assigns);

    return edo;
  }

  public BackendWorkflowCreateRequest fromEdo(final WorkflowCreateRequestEdo edo) {
    final BackendWorkflowCreateRequest model = new BackendWorkflowCreateRequest(new BackendWorkflow().fromEdo(edo.getWorkflow()),
                                                                                edo.getAssignedUsers());

    return model;
  }

}

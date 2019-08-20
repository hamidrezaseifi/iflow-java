package com.pth.iflow.gui.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.xml.WorkflowCreateRequestEdo;

public class GuiWorkflowCreateRequest {

  private GuiWorkflow workflow;

  private final List<Long> assigns = new ArrayList<>();

  public GuiWorkflowCreateRequest() {

  }

  public GuiWorkflowCreateRequest(final GuiWorkflow workflow) {
    super();
    this.setWorkflow(workflow);
  }

  public GuiWorkflowCreateRequest(final GuiWorkflow workflow, final List<Long> assigns) {
    super();
    this.setWorkflow(workflow);
    this.setAssigns(assigns);
  }

  /**
   * @return the workflow
   */
  public GuiWorkflow getWorkflow() {
    return this.workflow;
  }

  /**
   * @param workflow the workflow to set
   */
  public void setWorkflow(final GuiWorkflow workflow) {
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

}
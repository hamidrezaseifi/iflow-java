package com.pth.iflow.gui.models;

import java.util.ArrayList;
import java.util.List;

public class GuiWorkflowCreateRequest {

  private GuiWorkflow      workflow;

  private final List<Long> assigns = new ArrayList<>();

  private String           sessionKey;

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

  /**
   * @return the sessionKey
   */
  public String getSessionKey() {
    return this.sessionKey;
  }

  /**
   * @param sessionKey the sessionKey to set
   */
  public void setSessionKey(final String sessionKey) {
    this.sessionKey = sessionKey;
  }

}

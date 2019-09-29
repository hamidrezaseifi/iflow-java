package com.pth.iflow.gui.models;

import java.util.ArrayList;
import java.util.List;

public class GuiWorkflowCreateRequest {

  private GuiWorkflow workflow;

  private Integer expireDays;

  private final List<GuiAssignItem> assigns = new ArrayList<>();

  private String sessionKey;

  public GuiWorkflowCreateRequest() {

  }

  public static GuiWorkflowCreateRequest generateNew(final GuiWorkflow workflow) {
    final GuiWorkflowCreateRequest request = new GuiWorkflowCreateRequest();

    request.setWorkflow(workflow);
    request.setExpireDays(15);

    return request;
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

  public Integer getExpireDays() {
    return this.expireDays;
  }

  public void setExpireDays(final Integer expireDays) {
    this.expireDays = expireDays;
  }

  /**
   * @return the assigns
   */
  public List<GuiAssignItem> getAssigns() {
    return this.assigns;
  }

  /**
   * @param assigns the assigns to set
   */
  public void setAssigns(final List<GuiAssignItem> assigns) {
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

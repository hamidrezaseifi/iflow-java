package com.pth.iflow.workflow.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.enums.EWorkflowProcessCommand;

public class WorkflowSaveRequest {

  private Workflow                workflow;

  private Integer                 expireDays;

  private List<AssignItem>        assigns = new ArrayList<>();

  private EWorkflowProcessCommand command;

  public WorkflowSaveRequest() {

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

  public Integer getExpireDays() {
    return this.expireDays;
  }

  public void setExpireDays(final Integer expireDays) {
    this.expireDays = expireDays;
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

  public EWorkflowProcessCommand getCommand() {
    return this.command;
  }

  public void setCommand(final EWorkflowProcessCommand command) {
    this.command = command;
  }

}

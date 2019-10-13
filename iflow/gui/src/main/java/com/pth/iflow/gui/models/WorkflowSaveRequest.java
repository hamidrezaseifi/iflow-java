package com.pth.iflow.gui.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;

public class WorkflowSaveRequest {

  private Workflow                workflow;

  private Integer                 expireDays;

  private final List<AssignItem>  assigns = new ArrayList<>();

  private String                  sessionKey;

  private EWorkflowProcessCommand command;

  public WorkflowSaveRequest() {

  }

  public static WorkflowSaveRequest generateNewWihExpireDays(final Workflow workflow, final int expireDays) {
    final WorkflowSaveRequest request = new WorkflowSaveRequest();

    request.setWorkflow(workflow);
    request.setExpireDays(expireDays);
    request.setCommand(EWorkflowProcessCommand.CREATE);

    return request;
  }

  public static WorkflowSaveRequest generateNewNoExpireDays(final Workflow workflow) {
    final WorkflowSaveRequest request = new WorkflowSaveRequest();

    request.setWorkflow(workflow);
    request.setExpireDays(0);
    request.setCommand(EWorkflowProcessCommand.CREATE);

    return request;
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
   * @return the assigns
   */
  public List<AssignItem> getAssigns() {
    return this.assigns;
  }

  /**
   * @param assigns the assigns to set
   */
  public void setAssigns(final List<AssignItem> assigns) {
    this.assigns.clear();
    if (assigns != null) {
      this.assigns.addAll(assigns);
    }
  }

  /**
   * @param assigns the assigns to set
   */
  public void setAssignUser(final String userId) {
    this.assigns.clear();
    this.assigns.add(new AssignItem(userId, EAssignType.USER));
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

  public EWorkflowProcessCommand getCommand() {
    return this.command;
  }

  public void setCommand(final EWorkflowProcessCommand command) {
    this.command = command;
  }

}

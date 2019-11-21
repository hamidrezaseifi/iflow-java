package com.pth.iflow.gui.models.workflow.singletask;

import java.util.ArrayList;
import java.util.List;
import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.gui.models.AssignItem;
import com.pth.iflow.gui.models.workflow.IWorkflowSaveRequest;

public class SingleTaskWorkflowSaveRequest implements IWorkflowSaveRequest<SingleTaskWorkflow> {

  private SingleTaskWorkflow      workflow;
  private Integer                 expireDays;
  private List<AssignItem>        assigns = new ArrayList<>();
  private EWorkflowProcessCommand command;
  private String                  sessionKey;

  public SingleTaskWorkflowSaveRequest() {

  }

  /**
   * @return the workflow
   */
  @Override
  public SingleTaskWorkflow getWorkflow() {
    return this.workflow;
  }

  /**
   * @param workflow the workflow to set
   */
  @Override
  public void setWorkflow(final SingleTaskWorkflow workflow) {
    this.workflow = workflow;
  }

  @Override
  public Integer getExpireDays() {
    return this.expireDays;
  }

  public void setExpireDays(final Integer expireDays) {
    this.expireDays = expireDays;
  }

  /**
   * @return the assignedUsers
   */
  @Override
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

  @Override
  public EWorkflowProcessCommand getCommand() {
    return this.command;
  }

  @Override
  public boolean isAssignCommand() {
    return this.command == EWorkflowProcessCommand.ASSIGN;
  }

  @Override
  public boolean isArchiveCommand() {
    return this.command == EWorkflowProcessCommand.ARCHIVE;
  }

  @Override
  public boolean isCreateCommand() {
    return this.command == EWorkflowProcessCommand.CREATE;
  }

  @Override
  public boolean isDoneCommand() {
    return this.command == EWorkflowProcessCommand.DONE;
  }

  @Override
  public boolean isSaveCommand() {
    return this.command == EWorkflowProcessCommand.SAVE;
  }

  public void setCommand(final EWorkflowProcessCommand command) {
    this.command = command;
  }

  public static SingleTaskWorkflowSaveRequest generateNewNoExpireDays(final SingleTaskWorkflow workflow) {
    final SingleTaskWorkflowSaveRequest request = new SingleTaskWorkflowSaveRequest();

    request.setWorkflow(workflow);
    request.setExpireDays(0);
    request.setCommand(EWorkflowProcessCommand.CREATE);

    return request;
  }

  @Override
  public String getSessionKey() {
    return sessionKey;
  }

  @Override
  public void setSessionKey(final String sessionKey) {
    this.sessionKey = sessionKey;
  }

  @Override
  public void setAssignUser(final String userId) {
    this.assigns.clear();
    this.assigns.add(new AssignItem(userId, EAssignType.USER));
  }
}

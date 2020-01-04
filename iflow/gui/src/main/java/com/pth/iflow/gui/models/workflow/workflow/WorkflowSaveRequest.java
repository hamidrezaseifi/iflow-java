package com.pth.iflow.gui.models.workflow.workflow;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.gui.models.AssignItem;
import com.pth.iflow.gui.models.UploadededFile;
import com.pth.iflow.gui.models.workflow.IWorkflowSaveRequest;

public class WorkflowSaveRequest implements IWorkflowSaveRequest<Workflow> {

  private Workflow workflow;
  private Integer expireDays;
  private List<AssignItem> assigns = new ArrayList<>();
  private EWorkflowProcessCommand command;
  private List<UploadededFile> uploadedFiles = new ArrayList<>();

  public WorkflowSaveRequest() {

  }

  /**
   * @return the workflow
   */
  @Override
  public Workflow getWorkflow() {

    return this.workflow;
  }

  /**
   * @param workflow the workflow to set
   */
  @Override
  public void setWorkflow(final Workflow workflow) {

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

  public static WorkflowSaveRequest generateNewNoExpireDays(final Workflow workflow) {

    final WorkflowSaveRequest request = new WorkflowSaveRequest();

    request.setWorkflow(workflow);
    request.setExpireDays(0);
    request.setCommand(EWorkflowProcessCommand.CREATE);

    return request;
  }

  public static WorkflowSaveRequest generateNewWihExpireDays(final Workflow workflow, final int expireDays) {

    final WorkflowSaveRequest request = new WorkflowSaveRequest();

    request.setWorkflow(workflow);
    request.setExpireDays(expireDays);
    request.setCommand(EWorkflowProcessCommand.CREATE);

    return request;
  }

  @Override
  public List<UploadededFile> getUploadedFiles() {

    return this.uploadedFiles;
  }

  @Override
  public void setUploadedFiles(final List<UploadededFile> uploadedFiles) {

    this.uploadedFiles = uploadedFiles;
  }

  @Override
  public void setAssignUser(final String userId) {

    this.assigns.clear();
    this.assigns.add(new AssignItem(userId, EAssignType.USER));
  }
}

package com.pth.iflow.gui.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pth.iflow.common.enums.EWorkflowStatus;

@JsonIgnoreProperties(value = { "isAssignTo" })
public class GuiWorkflow {

  private Long                          id;
  private Long                          workflowTypeId;
  private GuiWorkflowType               workflowType;
  private GuiWorkflowTypeStep           currentStep;
  private Long                          currentStepId;
  private Long                          controller;
  private GuiUser                       controllerUser;
  private Long                          createdBy;
  private GuiUser                       createdByUser;
  private Long                          assignTo;
  private GuiUser                       assignToUser;
  private String                        title;
  private String                        comments;
  private EWorkflowStatus               status;
  private Integer                       version;

  private final List<GuiWorkflowFile>   files   = new ArrayList<>();
  private final List<GuiWorkflowAction> actions = new ArrayList<>();

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowTypeId() {
    return this.workflowTypeId;
  }

  public void setWorkflowTypeId(final Long workflowTypeId) {
    this.workflowTypeId = workflowTypeId;
  }

  /**
   * @return the workflowType
   */
  public GuiWorkflowType getWorkflowType() {
    return this.workflowType;
  }

  /**
   * @param workflowType the workflowType to set
   */
  public void setWorkflowType(final GuiWorkflowType workflowType) {
    this.workflowType = workflowType;
  }

  public GuiWorkflowTypeStep getCurrentStep() {
    return this.currentStep;
  }

  public void setCurrentStep(final GuiWorkflowTypeStep currentStep) {
    this.currentStep = currentStep;
  }

  public Long getCurrentStepId() {
    return this.currentStepId;
  }

  public void setCurrentStepId(final Long currentStepId) {
    this.currentStepId = currentStepId;
  }

  public Long getController() {
    return this.controller;
  }

  public void setController(final Long controller) {
    this.controller = controller;
  }

  /**
   * @return the controllerUser
   */
  public GuiUser getControllerUser() {
    return this.controllerUser;
  }

  /**
   * @param controllerUser the controllerUser to set
   */
  public void setControllerUser(final GuiUser controllerUser) {
    this.controllerUser = controllerUser;
  }

  public Long getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * @return the createdByUser
   */
  public GuiUser getCreatedByUser() {
    return this.createdByUser;
  }

  /**
   * @param createdByUser the createdByUser to set
   */
  public void setCreatedByUser(final GuiUser createdByUser) {
    this.createdByUser = createdByUser;
  }

  public Long getAssignTo() {
    return this.assignTo;
  }

  public boolean isAssignTo(final Long userId) {
    return this.assignTo == userId;
  }

  public void setAssignTo(final Long assignTo) {
    this.assignTo = assignTo;
  }

  /**
   * @return the assignToUser
   */
  public GuiUser getAssignToUser() {
    return this.assignToUser;
  }

  /**
   * @param assignToUser the assignToUser to set
   */
  public void setAssignToUser(final GuiUser assignToUser) {
    this.assignToUser = assignToUser;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public EWorkflowStatus getStatus() {
    return this.status;
  }

  public void setStatus(final EWorkflowStatus status) {
    this.status = status;
  }

  public void setStatusInt(final Integer status) {
    this.status = EWorkflowStatus.ofValue(status);
  }

  public Integer getStatusInt() {
    return this.status.getValue().intValue();
  }

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  public List<GuiWorkflowFile> getFiles() {
    return this.files;
  }

  public GuiWorkflowFile getFileById(final Long fileId) {

    for (final GuiWorkflowFile file : this.files) {
      if (file.getId().equals(fileId)) {
        return file;
      }
    }
    return null;
  }

  public void setFiles(final List<GuiWorkflowFile> files) {
    this.files.clear();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  public void addFile(final GuiWorkflowFile file) {
    file.setWorkflowId(this.getId());
    this.files.add(file);
  }

  public GuiWorkflowFile addNewFile(final String path, final Long userId, final String title, final String extention,
      final String comments) {
    final GuiWorkflowFile wfile = new GuiWorkflowFile();
    wfile.setActiveFilePath(path);
    wfile.setActiveFileVersion(1);
    wfile.setComments(comments);
    wfile.setCreatedBy(userId);
    wfile.setExtention(extention);

    wfile.setStatus(1);
    wfile.setTitle(title);

    wfile.addNewFileVersion(path, 1, userId, comments);

    this.addFile(wfile);

    return wfile;
  }

  public List<GuiWorkflowAction> getActions() {
    return this.actions;
  }

  public void setActions(final List<GuiWorkflowAction> actions) {
    this.actions.clear();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }

  public void addAction(final GuiWorkflowAction action) {
    action.setWorkflowId(this.getId());
    this.actions.add(action);
  }

  public boolean isAfterStep(final GuiWorkflow other) {
    return this.currentStep.isAfterStep(other.getCurrentStep());
  }

  public boolean isBeforeStep(final GuiWorkflow other) {
    return this.currentStep.isBeforeStep(other.getCurrentStep());
  }

  public boolean isTheSameStep(final GuiWorkflow other) {
    return this.currentStep.isTheSameStep(other.getCurrentStep());
  }

  public boolean isAfter(final GuiWorkflowTypeStep step) {
    return this.currentStep.isAfterStep(step);
  }

  public boolean isBefore(final GuiWorkflowTypeStep step) {
    return this.currentStep.isBeforeStep(step);
  }

  public boolean isTheSame(final GuiWorkflowTypeStep step) {
    return this.currentStep.isTheSameStep(step);
  }

  public boolean getIsNew() {
    return (this.getId() == null) || (this.getId() <= 0);
  }

  public boolean isInitializing() {
    return this.getIsNew() && (this.getStatus() == EWorkflowStatus.INITIALIZE);
  }

  public boolean getHasActiveAction() {

    return this.getActiveAction() != null;
  }

  public GuiWorkflowAction getActiveAction() {
    for (final GuiWorkflowAction action : this.getActions()) {
      if (action.getIsActive() == true) {
        return action;
      }
    }
    return null;
  }

  public boolean getIsDone() {
    return this.status == EWorkflowStatus.DONE;
  }

  public boolean getIsArchived() {
    return this.status == EWorkflowStatus.ARCHIVED;
  }

  public boolean getIsError() {
    return this.status == EWorkflowStatus.ERROR;
  }

  public boolean getIsOpen() {
    return (this.assignTo != null) && (this.assignTo > 0) && (this.status == EWorkflowStatus.ASSIGNED);
  }

  public static GuiWorkflow generateInitial(final Long creatorId) {
    final GuiWorkflow newWorkflow = new GuiWorkflow();
    newWorkflow.setStatus(EWorkflowStatus.INITIALIZE);
    newWorkflow.setAssignTo(0L);
    newWorkflow.setCreatedBy(creatorId);
    newWorkflow.setController(0L);
    newWorkflow.setCurrentStepId(0L);
    newWorkflow.setId(0L);
    newWorkflow.setTitle("");
    newWorkflow.setVersion(0);
    newWorkflow.setWorkflowTypeId(0L);
    newWorkflow.setComments("");

    return newWorkflow;
  }
}

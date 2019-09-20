package com.pth.iflow.backend.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.base.DataModelBase;
import com.pth.iflow.common.enums.EWorkflowStatus;

public class BackendWorkflow extends DataModelBase {

  private Long                              id;
  private Long                              workflowTypeId;
  private BackendWorkflowTypeStep           currentStep;
  private Long                              currentStepId;
  private Long                              controller;
  private Long                              createdBy;
  private Long                              assignTo;
  private String                            title;
  private String                            comments;
  private EWorkflowStatus                   status;
  private Integer                           version;
  private Boolean                           nextAssign;
  private String                            command;

  private final List<BackendWorkflowFile>   files   = new ArrayList<>();
  private final List<BackendWorkflowAction> actions = new ArrayList<>();

  @Override
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

  public BackendWorkflowTypeStep getCurrentStep() {
    return this.currentStep;
  }

  public void setCurrentStep(final BackendWorkflowTypeStep currentStep) {
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

  public Long getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  public Long getAssignTo() {
    return this.assignTo;
  }

  public boolean isAssigned() {
    return (this.assignTo != null) && (this.assignTo > 0);
  }

  public void setAssignTo(final Long assignTo) {
    this.assignTo = assignTo;
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

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  public Boolean getNextAssign() {
    return this.nextAssign;
  }

  public void setNextAssign(final Boolean nextAssign) {
    this.nextAssign = nextAssign;
  }

  public List<BackendWorkflowFile> getFiles() {
    return this.files;
  }

  public void setFiles(final List<BackendWorkflowFile> files) {
    this.files.clear();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  public List<BackendWorkflowAction> getActions() {
    return this.actions;
  }

  public void setActions(final List<BackendWorkflowAction> actions) {
    this.actions.clear();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }

  public boolean isAfterStep(final BackendWorkflow other) {
    return this.currentStep.isAfterStep(other.getCurrentStep());
  }

  public boolean isBeforeStep(final BackendWorkflow other) {
    return this.currentStep.isBeforeStep(other.getCurrentStep());
  }

  public boolean isTheSameStep(final BackendWorkflow other) {
    return this.currentStep.isTheSameStep(other.getCurrentStep());
  }

  public boolean isAfter(final BackendWorkflowTypeStep step) {
    return this.currentStep.isAfterStep(step);
  }

  public boolean isBefore(final BackendWorkflowTypeStep step) {
    return this.currentStep.isBeforeStep(step);
  }

  public boolean isTheSame(final BackendWorkflowTypeStep step) {
    return this.currentStep.isTheSameStep(step);
  }

  public boolean isInitializing() {
    return this.isNew() && (this.getStatus() == EWorkflowStatus.INITIALIZE);
  }

  @Override
  public boolean isNew() {
    return (this.id == null) || (this.id <= 0);
  }

  public String getCommand() {
    return this.command;
  }

  public void setCommand(final String command) {
    this.command = command;
  }

}

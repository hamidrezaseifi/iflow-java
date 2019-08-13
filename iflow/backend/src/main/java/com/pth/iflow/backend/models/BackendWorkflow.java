package com.pth.iflow.backend.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.enums.EWorkflowStatus;

public class BackendWorkflow extends ModelMapperBase<WorkflowEdo, BackendWorkflow> {

  private Long                    id;
  private Long                    workflowTypeId;
  private BackendWorkflowTypeStep currentStep;
  private Long                    currentStepId;
  private Long                    controller;
  private Long                    createdBy;
  private Long                    assignTo;
  private String                  title;
  private String                  comments;
  private EWorkflowStatus         status;
  private Integer                 version;

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
    return isNew() && (getStatus() == EWorkflowStatus.INITIALIZE);
  }

  @Override
  public WorkflowEdo toEdo() {
    final WorkflowEdo edo = new WorkflowEdo();
    edo.setTitle(this.title);
    edo.setComments(this.comments);
    edo.setStatus(this.getStatusInt());
    edo.setId(this.id);
    edo.setController(this.controller);
    edo.setCurrentStep(this.currentStep.toEdo());
    edo.setCurrentStepId(this.currentStepId);
    edo.setCreatedBy(this.createdBy);
    edo.setWorkflowTypeId(this.workflowTypeId);
    edo.setVersion(this.version);
    edo.setAssignTo(this.assignTo);

    edo.setFiles(BackendWorkflowFile.toEdoList(this.files));
    edo.setActions(BackendWorkflowAction.toEdoList(this.actions));

    return edo;
  }

  @Override
  public BackendWorkflow fromEdo(final WorkflowEdo edo) {
    if (edo == null) {
      return null;
    }
    final BackendWorkflow model = new BackendWorkflow();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatusInt(edo.getStatus());
    model.setId(edo.getId());
    model.setController(edo.getController());
    model.setCurrentStep(new BackendWorkflowTypeStep().fromEdo(edo.getCurrentStep()));
    model.setCurrentStepId(edo.getCurrentStepId());
    model.setCreatedBy(edo.getCreatedBy());
    model.setWorkflowTypeId(edo.getWorkflowTypeId());
    model.setVersion(edo.getVersion());
    model.setAssignTo(edo.getAssignTo());

    model.setFiles(new BackendWorkflowFile().fromEdoList(edo.getFiles()));
    model.setActions(new BackendWorkflowAction().fromEdoList(edo.getActions()));

    return model;
  }

}

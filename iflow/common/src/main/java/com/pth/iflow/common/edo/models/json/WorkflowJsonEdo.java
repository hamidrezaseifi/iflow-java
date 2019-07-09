package com.pth.iflow.common.edo.models.json;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

public class WorkflowJsonEdo {

  private Long                       id;

  @NotNull
  private Long                       workflowTypeId;

  @NotNull
  private WorkflowTypeStepJsonEdo    currentStep;

  private Long                       currentStepId;

  private Long                       controller;

  private Long                       createdBy;

  private Long                       assignTo;

  @NotNull
  private String                     title;

  private String                     comments;

  @NotNull
  private Integer                    status;

  @NotNull
  private Integer                    version;

  private Set<WorkflowFileJsonEdo>   files   = new HashSet<>();

  private Set<WorkflowActionJsonEdo> actions = new HashSet<>();

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowTypeId() {
    return workflowTypeId;
  }

  public void setWorkflowTypeId(final Long workflowTypeId) {
    this.workflowTypeId = workflowTypeId;
  }

  public WorkflowTypeStepJsonEdo getCurrentStep() {
    return currentStep;
  }

  public void setCurrentStep(final WorkflowTypeStepJsonEdo currentStep) {
    this.currentStep = currentStep;
  }

  public Long getCurrentStepId() {
    return currentStepId;
  }

  public void setCurrentStepId(final Long currentStepId) {
    this.currentStepId = currentStepId;
  }

  public Long getController() {
    return controller;
  }

  public void setController(final Long controller) {
    this.controller = controller;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  public Long getAssignTo() {
    return assignTo;
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

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(final Integer status) {
    this.status = status;
  }

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  public Set<WorkflowFileJsonEdo> getFiles() {
    return files;
  }

  public void setFilesList(final List<WorkflowFileJsonEdo> files) {
    final Set<WorkflowFileJsonEdo> fileSet = files != null ? files.stream().collect(Collectors.toSet()) : new HashSet<>();
    setFiles(fileSet);
  }

  public void setFiles(final Set<WorkflowFileJsonEdo> files) {
    this.files = new HashSet<>();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  public Set<WorkflowActionJsonEdo> getActions() {
    return actions;
  }

  public void setActionsList(final List<WorkflowActionJsonEdo> actions) {
    final Set<WorkflowActionJsonEdo> actionSet = actions != null ? actions.stream().collect(Collectors.toSet()) : new HashSet<>();
    setActions(actionSet);
  }

  public void setActions(final Set<WorkflowActionJsonEdo> actions) {
    this.actions = new HashSet<>();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }

}

package com.pth.iflow.common.edo.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WorkflowEdo {

  private Long id;
  private Long workflowTypeId;
  private Long currentStep;
  private Long controller;
  private Long createdBy;
  private String title;
  private String comments;
  private Integer status;
  private Integer version;

  private Set<WorkflowFileEdo> files = new HashSet<>();
  private Set<WorkflowActionEdo> actions = new HashSet<>();

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

  public Long getCurrentStep() {
    return currentStep;
  }

  public void setCurrentStep(final Long currentStep) {
    this.currentStep = currentStep;
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

  public Set<WorkflowFileEdo> getFiles() {
    return files;
  }

  public void setFiles(final List<WorkflowFileEdo> files) {
    setFiles(files.stream().collect(Collectors.toSet()));
  }

  public void setFiles(final Set<WorkflowFileEdo> files) {
    this.files = new HashSet<>();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  public Set<WorkflowActionEdo> getActions() {
    return actions;
  }

  public void setActions(final List<WorkflowActionEdo> actions) {
    setActions(actions.stream().collect(Collectors.toSet()));
  }

  public void setActions(final Set<WorkflowActionEdo> actions) {
    this.actions = new HashSet<>();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }

}

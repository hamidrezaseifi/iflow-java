package com.pth.iflow.core.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;

public class Workflow extends ModelMapperBase<WorkflowEdo, Workflow> {

  private Long id;
  private Long workflowTypeId;
  private Long currentStep;
  private Long controller;
  private Long createdBy;
  private String title;
  private String comments;
  private Integer status;
  private Integer version;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private Set<WorkflowFile> files = new HashSet<>();
  private Set<WorkflowAction> actions = new HashSet<>();

  @Override
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

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Set<WorkflowFile> getFiles() {
    return files;
  }

  public void setFiles(final List<WorkflowFile> files) {
    setFiles(files.stream().collect(Collectors.toSet()));
  }

  public void setFiles(final Set<WorkflowFile> files) {
    this.files = new HashSet<>();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  public Set<WorkflowAction> getActions() {
    return actions;
  }

  public void setActions(final List<WorkflowAction> actions) {
    setActions(actions.stream().collect(Collectors.toSet()));
  }

  public void setActions(final Set<WorkflowAction> actions) {
    this.actions = new HashSet<>();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }

  @Override
  public WorkflowEdo toEdo() {
    final WorkflowEdo edo = new WorkflowEdo();
    edo.setTitle(this.title);
    edo.setComments(this.comments);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setController(controller);
    edo.setCurrentStep(currentStep);
    edo.setCreatedBy(createdBy);
    edo.setWorkflowTypeId(workflowTypeId);
    edo.setVersion(version);

    edo.setFiles(ModelMapperBase.toEdoList(files));
    edo.setActions(ModelMapperBase.toEdoList(actions));

    return edo;
  }

  @Override
  public Workflow fromEdo(final WorkflowEdo edo) {
    final Workflow model = new Workflow();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setController(edo.getController());
    model.setCurrentStep(edo.getCurrentStep());
    model.setCreatedBy(edo.getCreatedBy());
    model.setWorkflowTypeId(edo.getWorkflowTypeId());
    model.setVersion(edo.getVersion());

    model.setFiles(new WorkflowFile().fromEdoList(edo.getFiles()));
    model.setActions(new WorkflowAction().fromEdoList(edo.getActions()));

    return model;
  }

}

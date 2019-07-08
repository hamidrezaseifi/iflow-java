package com.pth.ifow.workflow.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.enums.EWorkflowStatus;

public class Workflow extends ModelMapperBase<WorkflowEdo, Workflow> {

  private Long id;
  private Long workflowTypeId;
  private WorkflowTypeStep currentStep;
  private Long controller;
  private Long createdBy;
  private Long assignTo;
  private String title;
  private String comments;
  private EWorkflowStatus status;
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

  public WorkflowTypeStep getCurrentStep() {
    return currentStep;
  }

  public void setCurrentStep(final WorkflowTypeStep currentStep) {
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

  public EWorkflowStatus getStatus() {
    return this.status;
  }

  public void setStatus(final Integer status) {
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

  public boolean isAfterStep(final Workflow other) {
    return currentStep.isAfterStep(other.getCurrentStep());
  }

  public boolean isBeforeStep(final Workflow other) {
    return currentStep.isBeforeStep(other.getCurrentStep());
  }

  public boolean isTheSameStep(final Workflow other) {
    return currentStep.isTheSameStep(other.getCurrentStep());
  }

  public boolean isAfter(final WorkflowTypeStep step) {
    return currentStep.isAfterStep(step);
  }

  public boolean isBefore(final WorkflowTypeStep step) {
    return currentStep.isBeforeStep(step);
  }

  public boolean isTheSame(final WorkflowTypeStep step) {
    return currentStep.isTheSameStep(step);
  }

  @Override
  public WorkflowEdo toEdo() {
    final WorkflowEdo edo = new WorkflowEdo();
    edo.setTitle(this.title);
    edo.setComments(this.comments);
    edo.setStatus(this.getStatusInt());
    edo.setId(this.id);
    edo.setController(controller);
    edo.setCurrentStep(currentStep.toEdo());
    edo.setCreatedBy(createdBy);
    edo.setWorkflowTypeId(workflowTypeId);
    edo.setVersion(version);
    edo.setAssignTo(assignTo);

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
    model.setCurrentStep(new WorkflowTypeStep().fromEdo(edo.getCurrentStep()));
    model.setCreatedBy(edo.getCreatedBy());
    model.setWorkflowTypeId(edo.getWorkflowTypeId());
    model.setVersion(edo.getVersion());
    model.setAssignTo(edo.getAssignTo());

    model.setFiles(new WorkflowFile().fromEdoList(edo.getFiles()));
    model.setActions(new WorkflowAction().fromEdoList(edo.getActions()));

    return model;
  }

}

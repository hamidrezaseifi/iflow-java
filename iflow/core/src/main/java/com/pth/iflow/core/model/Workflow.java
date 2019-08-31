package com.pth.iflow.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.base.DataModelBase;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.enums.EWorkflowStatus;

public class Workflow extends DataModelBase<WorkflowEdo, Workflow> {

  private Long                       id;
  private Long                       workflowTypeId;
  private WorkflowTypeStep           currentStep;
  private Long                       controller;
  private Long                       createdBy;
  private Long                       assignTo;
  private String                     title;
  private String                     comments;
  private EWorkflowStatus            status;
  private Integer                    version;
  private LocalDateTime              createdAt;
  private LocalDateTime              updatedAt;
  private Boolean                    nextAssign;

  private final List<WorkflowFile>   files   = new ArrayList<>();
  private final List<WorkflowAction> actions = new ArrayList<>();

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

  public WorkflowTypeStep getCurrentStep() {
    return this.currentStep;
  }

  public void setCurrentStep(final WorkflowTypeStep currentStep) {
    this.currentStep = currentStep;
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

  public Integer getStatusInt() {
    return this.status.getValue().intValue();
  }

  public void setStatus(final Integer status) {
    this.status = EWorkflowStatus.ofValue(status);
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

  public List<WorkflowFile> getFiles() {
    return this.files;
  }

  public void setFiles(final List<WorkflowFile> files) {
    this.files.clear();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  public List<WorkflowAction> getActions() {
    return this.actions;
  }

  public void setActions(final List<WorkflowAction> actions) {
    this.actions.clear();
    if (actions != null) {
      this.actions.addAll(actions);
    }
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
    edo.setCurrentStepId(this.currentStep != null ? this.currentStep.getId() : null);
    edo.setCreatedBy(this.createdBy);
    edo.setWorkflowTypeId(this.workflowTypeId);
    edo.setVersion(this.version);
    edo.setNextAssign(this.nextAssign);
    edo.setAssignTo(this.assignTo);

    edo.setFiles(ModelMapperBase.toEdoList(this.files));
    edo.setActions(ModelMapperBase.toEdoList(this.actions));

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
    model.setNextAssign(edo.getNextAssign());
    model.setAssignTo(edo.getAssignTo());

    model.setFiles(new WorkflowFile().fromEdoList(edo.getFiles()));
    model.setActions(new WorkflowAction().fromEdoList(edo.getActions()));

    return model;
  }

}

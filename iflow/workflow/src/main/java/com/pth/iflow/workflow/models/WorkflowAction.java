package com.pth.iflow.workflow.models;

import com.pth.iflow.common.edo.models.base.WorkflowActionModelBase;
import com.pth.iflow.common.edo.models.xml.WorkflowActionEdo;
import com.pth.iflow.common.enums.EWorkflowActionStatus;

public class WorkflowAction extends WorkflowActionModelBase<WorkflowActionEdo, WorkflowAction> {

  private Long    id;
  private Long    workflowId;
  private Long    createdBy;
  private String  action;
  private Long    oldStep;
  private Long    newStep;
  private Long    nextAssign;
  private String  comments;
  private Integer status;
  private Integer version;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowId() {
    return this.workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public String getAction() {
    return this.action;
  }

  public void setAction(final String action) {
    this.action = action;
  }

  public Long getOldStep() {
    return this.oldStep;
  }

  public void setOldStep(final Long oldStep) {
    this.oldStep = oldStep;
  }

  public Long getNewStep() {
    return this.newStep;
  }

  public void setNewStep(final Long newStep) {
    this.newStep = newStep;
  }

  public Long getNextAssign() {
    return this.nextAssign;
  }

  public void setNextAssign(final Long nextAssign) {
    this.nextAssign = nextAssign;
  }

  public boolean hasNextAssign() {
    return this.nextAssign != null && this.nextAssign > 0;
  }

  public Long getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  @Override
  public Integer getStatusInt() {
    return this.status;
  }

  public EWorkflowActionStatus getStatus() {
    return EWorkflowActionStatus.ofValue(this.status);
  }

  public boolean isStatusSavingRequest() {
    return this.getStatus() == EWorkflowActionStatus.SAVING_REQUEST;
  }

  public boolean isStatusDoneRequest() {
    return this.getStatus() == EWorkflowActionStatus.DONE_REQUEST;
  }

  public boolean isStatusRequest() {
    return this.isStatusSavingRequest() || this.isStatusDoneRequest();
  }

  public void setStatus(final EWorkflowActionStatus status) {
    this.status = status.getValue().intValue();
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

  @Override
  public WorkflowActionEdo toEdo() {
    final WorkflowActionEdo edo = new WorkflowActionEdo();
    edo.setAction(this.action);
    edo.setComments(this.comments);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setCreatedBy(this.createdBy);
    edo.setOldStep(this.oldStep);
    edo.setNewStep(this.newStep);
    edo.setNextAssign(this.nextAssign);
    edo.setWorkflowId(this.workflowId);
    edo.setVersion(this.version);

    return edo;
  }

  @Override
  public WorkflowAction fromEdo(final WorkflowActionEdo edo) {
    if (edo == null) {
      return null;
    }

    final WorkflowAction model = new WorkflowAction();

    model.setAction(edo.getAction());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCreatedBy(edo.getCreatedBy());
    model.setOldStep(edo.getOldStep());
    model.setNewStep(edo.getNewStep());
    model.setNextAssign(edo.getNextAssign());
    model.setWorkflowId(edo.getWorkflowId());
    model.setVersion(edo.getVersion());

    return model;
  }

}

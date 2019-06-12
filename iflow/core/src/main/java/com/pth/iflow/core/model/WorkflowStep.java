package com.pth.iflow.core.model;

import com.pth.iflow.common.edo.models.WorkflowStepEdo;

public class WorkflowStep extends ModelBase<WorkflowStepEdo> {
  private Long id;
  private Long workflowId;
  private String title;
  private String comments;
  private Integer status;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowId() {
    return workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(final Integer status) {
    this.status = status;
  }

  @Override
  public WorkflowStepEdo toEdo() {
    final WorkflowStepEdo edo = new WorkflowStepEdo();
    edo.setTitle(title);
    edo.setComments(comments);
    edo.setStatus(status);
    edo.setId(id);
    edo.setWorkflowId(workflowId);

    return edo;
  }

  public static WorkflowStep fromEdo(final WorkflowStepEdo edo) {
    final WorkflowStep model = new WorkflowStep();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setWorkflowId(edo.getWorkflowId());

    return model;
  }

}

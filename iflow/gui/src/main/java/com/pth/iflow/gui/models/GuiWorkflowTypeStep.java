package com.pth.iflow.gui.models;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepEdo;

public class GuiWorkflowTypeStep extends ModelMapperBase<WorkflowTypeStepEdo, GuiWorkflowTypeStep> {

  private Long    id;
  private Long    workflowTypeId;
  private String  title;
  private Integer stepIndex;
  private String  viewName;
  private String  comments;
  private Integer status;
  private Integer version;

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

  public String getTitle() {
    return this.title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  /**
   * @return the stepIndex
   */
  public Integer getStepIndex() {
    return this.stepIndex;
  }

  /**
   * @param stepIndex the stepIndex to set
   */
  public void setStepIndex(final Integer stepIndex) {
    this.stepIndex = stepIndex;
  }

  public String getViewName() {
    return this.viewName;
  }

  public void setViewName(final String viewName) {
    this.viewName = viewName;
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

  public boolean isAfterStep(final GuiWorkflowTypeStep other) {
    return this.stepIndex > other.getStepIndex();
  }

  public boolean isBeforeStep(final GuiWorkflowTypeStep other) {
    return this.stepIndex < other.getStepIndex();
  }

  public boolean isTheSameStep(final GuiWorkflowTypeStep other) {
    return this.stepIndex == other.getStepIndex();
  }

  @Override
  public WorkflowTypeStepEdo toEdo() {
    final WorkflowTypeStepEdo edo = new WorkflowTypeStepEdo();
    edo.setStepIndex(this.stepIndex);
    edo.setViewName(this.viewName);
    edo.setTitle(this.title);
    edo.setComments(this.comments);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setWorkflowTypeId(this.workflowTypeId);
    edo.setVersion(this.version);

    return edo;
  }

  @Override
  public GuiWorkflowTypeStep fromEdo(final WorkflowTypeStepEdo edo) {
    if (edo == null) {
      return null;
    }
    final GuiWorkflowTypeStep model = new GuiWorkflowTypeStep();

    model.setStepIndex(edo.getStepIndex());
    model.setViewName(edo.getViewName());
    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setId(edo.getId());
    model.setWorkflowTypeId(edo.getWorkflowTypeId());

    return model;
  }

}

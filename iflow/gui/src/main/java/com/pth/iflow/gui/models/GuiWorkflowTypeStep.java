package com.pth.iflow.gui.models;

import com.pth.iflow.common.edo.models.base.DataModelBase;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepEdo;

public class GuiWorkflowTypeStep extends DataModelBase<WorkflowTypeStepEdo, GuiWorkflowTypeStep> {

  private Long    id;
  private Long    workflowTypeId;
  private String  title;
  private Integer stepIndex;
  private String  viewName;
  private String  comments;
  private Integer status;
  private Integer version;

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

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
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

}

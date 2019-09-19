package com.pth.iflow.gui.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pth.iflow.common.edo.models.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.base.WorkflowActionModelBase;
import com.pth.iflow.common.enums.EWorkflowActionStatus;

@JsonIgnoreProperties(value = { "running" })
public class GuiWorkflowAction extends WorkflowActionModelBase<WorkflowActionEdo, GuiWorkflowAction> {

  private Long                  id;
  private Long                  workflowId;
  private Long                  createdBy;
  private GuiUser               createdByUser;
  private String                action;
  private Long                  oldStep;
  private GuiWorkflowTypeStep   oldStepObject;
  private Long                  newStep;
  private GuiWorkflowTypeStep   newStepObject;
  private Long                  nextAssign;
  private String                comments;
  private EWorkflowActionStatus status;
  private Integer               version;

  @Override
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

  /**
   * @return the oldStepStep
   */
  public GuiWorkflowTypeStep getOldStepObject() {
    return this.oldStepObject;
  }

  /**
   * @param oldStepStep the oldStepStep to set
   */
  public void setOldStepObject(final GuiWorkflowTypeStep oldStepObject) {
    this.oldStepObject = oldStepObject;
  }

  public Long getNewStep() {
    return this.newStep;
  }

  public void setNewStep(final Long newStep) {
    this.newStep = newStep;
  }

  /**
   * @return the newStepObject
   */
  public GuiWorkflowTypeStep getNewStepObject() {
    return this.newStepObject;
  }

  /**
   * @param newStepObject the newStepObject to set
   */
  public void setNewStepObject(final GuiWorkflowTypeStep newStepObject) {
    this.newStepObject = newStepObject;
  }

  public Long getNextAssign() {
    return this.nextAssign;
  }

  public void setNextAssign(final Long nextAssign) {
    this.nextAssign = nextAssign;
  }

  public Long getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * @return the createdByUser
   */
  public GuiUser getCreatedByUser() {
    return this.createdByUser;
  }

  /**
   * @param createdByUser the createdByUser to set
   */
  public void setCreatedByUser(final GuiUser createdByUser) {
    this.createdByUser = createdByUser;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public EWorkflowActionStatus getStatus() {
    return this.status;
  }

  @Override
  public Integer getStatusInt() {
    return this.status.getValue().intValue();
  }

  public void setStatus(final EWorkflowActionStatus status) {
    this.status = status;
  }

  public void setStatusInt(final Integer status) {
    this.status = EWorkflowActionStatus.ofValue(status);
  }

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  public static GuiWorkflowAction createNewAction(final GuiWorkflow workflow, final Long createdBy,
      final EWorkflowActionStatus status) {
    final GuiWorkflowAction action = new GuiWorkflowAction();
    action.setCreatedBy(createdBy);
    action.setNewStep(null);
    action.setOldStep(workflow.getCurrentStepId());
    action.setStatus(status);
    action.setWorkflowId(workflow.getId());
    action.setComments("comments");
    action.setAction("action");
    return action;
  }

}

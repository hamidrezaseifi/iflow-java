package com.pth.iflow.gui.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pth.iflow.common.edo.models.base.WorkflowActionModelBase;
import com.pth.iflow.common.edo.models.xml.WorkflowActionEdo;
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
    edo.setStatus(this.getStatusInt());
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
  public GuiWorkflowAction fromEdo(final WorkflowActionEdo edo) {
    if (edo == null) {
      return null;
    }

    final GuiWorkflowAction model = new GuiWorkflowAction();

    model.setAction(edo.getAction());
    model.setComments(edo.getComments());
    model.setStatusInt(edo.getStatus());
    model.setId(edo.getId());
    model.setCreatedBy(edo.getCreatedBy());
    model.setOldStep(edo.getOldStep());
    model.setNewStep(edo.getNewStep());
    model.setNextAssign(edo.getNextAssign());
    model.setWorkflowId(edo.getWorkflowId());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static GuiWorkflowAction createNewAction(final GuiWorkflow workflow,
                                                  final Long createdBy,
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

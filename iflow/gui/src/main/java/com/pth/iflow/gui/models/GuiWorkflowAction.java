package com.pth.iflow.gui.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pth.iflow.common.enums.EWorkflowActionStatus;

@JsonIgnoreProperties(value = { "running" })
public class GuiWorkflowAction {

  private Long                  assignTo;
  private GuiUser               assignToUser;
  private String                assignToUserName;
  private Long                  currentStepId;
  private GuiWorkflowTypeStep   currentStep;
  private String                comments;
  private EWorkflowActionStatus status;
  private Integer               version;

  public Long getAssignTo() {
    return this.assignTo;
  }

  public boolean isAssignTo(final Long userId) {
    return this.assignTo == userId;
  }

  public void setAssignTo(final Long assignTo) {
    this.assignTo = assignTo;
  }

  /**
   * @return the assignToUser
   */
  public GuiUser getAssignToUser() {
    return this.assignToUser;
  }

  /**
   * @param assignToUser the assignToUser to set
   */
  public void setAssignToUser(final GuiUser assignToUser) {
    this.assignToUser = assignToUser;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public Long getCurrentStepId() {
    return this.currentStepId;
  }

  public void setCurrentStepId(final Long currentStepId) {
    this.currentStepId = currentStepId;
  }

  public GuiWorkflowTypeStep getCurrentStep() {
    return this.currentStep;
  }

  public void setCurrentStep(final GuiWorkflowTypeStep currentStep) {
    this.currentStep = currentStep;
  }

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  public EWorkflowActionStatus getStatus() {
    return this.status;
  }

  public Integer getStatusInt() {
    return this.status.getValue().intValue();
  }

  public void setStatus(final EWorkflowActionStatus status) {
    this.status = status;
  }

  public void setStatusInt(final Integer status) {
    this.status = EWorkflowActionStatus.ofValue(status);
  }

  public String getAssignToUserName() {
    return this.assignToUserName;
  }

  public void setAssignToUserName(final String assignToUserName) {
    this.assignToUserName = assignToUserName;
  }

  public boolean getIsActive() {
    return EWorkflowActionStatus.getIsActive(this.getStatusInt());
  }
}

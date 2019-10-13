package com.pth.iflow.gui.models;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pth.iflow.common.edo.models.helper.IdentityModel;
import com.pth.iflow.common.enums.EWorkflowActionStatus;

@JsonIgnoreProperties(value = { "running" })
public class WorkflowAction extends IdentityModel {

  private String                identity;
  private String                assignToIdentity;
  private User                  assignToUser;
  private String                assignToUserName;
  private String                currentStepIdentity;
  private WorkflowTypeStep      currentStep;
  private String                comments;
  private EWorkflowActionStatus status;
  private Integer               version;

  @Override
  public String getIdentity() {
    return this.identity;
  }

  @Override
  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  /**
   * @return the assignToUser
   */
  public User getAssignToUser() {
    return this.assignToUser;
  }

  /**
   * @param assignToUser the assignToUser to set
   */
  public void setAssignToUser(final User assignToUser) {
    this.assignToUser = assignToUser;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public String getAssignToIdentity() {
    return this.assignToIdentity;
  }

  public void setAssignToIdentity(final String assignToIdentity) {
    this.assignToIdentity = assignToIdentity;
  }

  public String getCurrentStepIdentity() {
    return this.currentStepIdentity;
  }

  public void setCurrentStepIdentity(final String currentStepIdentity) {
    this.currentStepIdentity = currentStepIdentity;
  }

  public WorkflowTypeStep getCurrentStep() {
    return this.currentStep;
  }

  public void setCurrentStep(final WorkflowTypeStep currentStep) {
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

  public boolean isAssignTo(final String userIdentity) {

    return (StringUtils.isEmpty(userIdentity) && StringUtils.isEmpty(this.assignToIdentity))
        || this.assignToIdentity.equals(userIdentity);
  }
}

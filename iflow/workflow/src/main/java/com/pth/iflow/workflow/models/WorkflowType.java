package com.pth.iflow.workflow.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.helper.IdentityModel;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;

public class WorkflowType extends IdentityModel {

  private String                       identity;
  private String                       companyIdentity;
  private String                       baseTypeIdentity;
  private String                       title;
  private String                       comments;
  private Integer                      status;
  private Boolean                      sendToController;
  private EWorkflowTypeAssignType      assignType;
  private Boolean                      increaseStepAutomatic;
  private Boolean                      allowAssign;
  private Integer                      version;
  private final List<WorkflowTypeStep> steps = new ArrayList<>();

  @Override
  public String getIdentity() {
    return identity;
  }

  @Override
  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public String getCompanyIdentity() {
    return companyIdentity;
  }

  public void setCompanyIdentity(final String companyIdentity) {
    this.companyIdentity = companyIdentity;
  }

  public String getBaseTypeIdentity() {
    return baseTypeIdentity;
  }

  public void setBaseTypeIdentity(final String baseTypeIdentity) {
    this.baseTypeIdentity = baseTypeIdentity;
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

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(final Integer status) {
    this.status = status;
  }

  public Boolean getSendToController() {
    return this.sendToController;
  }

  public void setSendToController(final Boolean sendToController) {
    this.sendToController = sendToController;
  }

  public EWorkflowTypeAssignType geAssignType() {
    return this.assignType;
  }

  public void setAssignType(final EWorkflowTypeAssignType assignType) {
    this.assignType = assignType;
  }

  public Boolean getIncreaseStepAutomatic() {
    return this.increaseStepAutomatic;
  }

  public void setIncreaseStepAutomatic(final Boolean increaseStepAutomatic) {
    this.increaseStepAutomatic = increaseStepAutomatic;
  }

  public Boolean getAllowAssign() {
    return this.allowAssign;
  }

  public void setAllowAssign(final Boolean allowAssign) {
    this.allowAssign = allowAssign;
  }

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  public List<WorkflowTypeStep> getSteps() {
    return this.steps;
  }

  public void setSteps(final List<WorkflowTypeStep> steps) {
    this.steps.clear();
    if (steps != null) {
      this.steps.addAll(steps);
    }
  }

  public void addStep(final WorkflowTypeStep stepId) {
    this.steps.add(stepId);
  }

  public boolean isAssignTypeManual() {
    return this.assignType == EWorkflowTypeAssignType.MANUAL;
  }

  public boolean isAssignTypeOffering() {
    return this.assignType == EWorkflowTypeAssignType.OFFER;
  }

}

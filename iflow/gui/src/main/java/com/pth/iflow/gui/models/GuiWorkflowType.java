package com.pth.iflow.gui.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;

public class GuiWorkflowType {

  private String                          identity;
  private String                          companyIdentity;
  private Long                            baseTypeId;
  private String                          title;
  private String                          comments;
  private Integer                         status;
  private Boolean                         sendToController;
  private EWorkflowTypeAssignType         assignType;
  private Boolean                         increaseStepAutomatic;
  private Boolean                         allowAssign;
  private Integer                         version;
  private final List<GuiWorkflowTypeStep> steps = new ArrayList<>();

  public String getIdentity() {
    return this.identity;
  }

  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public String getCompanyIdentity() {
    return this.companyIdentity;
  }

  public void setCompanyIdentity(final String companyIdentity) {
    this.companyIdentity = companyIdentity;
  }

  /**
   * @return the baseTypeId
   */
  public Long getBaseTypeId() {
    return this.baseTypeId;
  }

  /**
   * @param baseTypeId the baseTypeId to set
   */
  public void setBaseTypeId(final Long baseTypeId) {
    this.baseTypeId = baseTypeId;
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

  @JsonProperty(value = "isAssignTypeManual")
  public boolean geIsAssignTypeManual() {
    return this.assignType == EWorkflowTypeAssignType.MANUAL;
  }

  @JsonProperty(value = "isAssignTypeOffering")
  public boolean geIsAssignTypeOffering() {
    return this.assignType == EWorkflowTypeAssignType.OFFER;
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

  public List<GuiWorkflowTypeStep> getSteps() {
    return this.steps;
  }

  public void setSteps(final List<GuiWorkflowTypeStep> steps) {
    this.steps.clear();
    if (steps != null) {
      this.steps.addAll(steps);
    }
  }

  public void addStep(final GuiWorkflowTypeStep stepId) {
    this.steps.add(stepId);
  }

}

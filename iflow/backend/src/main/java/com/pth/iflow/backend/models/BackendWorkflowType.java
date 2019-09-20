package com.pth.iflow.backend.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.base.DataModelBase;

public class BackendWorkflowType extends DataModelBase {

  private Long                                id;
  private Long                                companyId;
  private Long                                baseTypeId;
  private String                              title;
  private String                              comments;
  private Integer                             status;
  private Boolean                             sendToController;
  private Boolean                             manualAssign;
  private Boolean                             increaseStepAutomatic;
  private Boolean                             allowAssign;
  private Integer                             version;
  private final List<BackendWorkflowTypeStep> steps = new ArrayList<>();

  @Override
  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getCompanyId() {
    return this.companyId;
  }

  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
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

  public Boolean getManualAssign() {
    return this.manualAssign;
  }

  public void setManualAssign(final Boolean manualAssign) {
    this.manualAssign = manualAssign;
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

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  public List<BackendWorkflowTypeStep> getSteps() {
    return this.steps;
  }

  public void setSteps(final List<BackendWorkflowTypeStep> steps) {
    this.steps.clear();
    if (steps != null) {
      this.steps.addAll(steps);
    }
  }

  public void addStep(final BackendWorkflowTypeStep stepId) {
    this.steps.add(stepId);
  }

  @Override
  public boolean isNew() {
    return (this.id == null) || (this.id <= 0);
  }

}

package com.pth.iflow.core.model;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.core.model.helper.CoreModelHelper;
import com.pth.iflow.core.model.helper.ICoreIdentityModel;

public class WorkflowType extends CoreModelHelper implements ICoreIdentityModel {

  private Long                              id;
  private String                            identity;
  private Long                              companyId;
  private String                            companyIdentity;
  private Long                              baseTypeId;
  private String                            title;
  private String                            comments;
  private Integer                           status;
  private Boolean                           sendToController;
  private EWorkflowTypeAssignType           assignType;
  private Boolean                           increaseStepAutomatic;
  private Boolean                           allowAssign;
  private Integer                           version;
  private LocalDateTime                     createdAt;
  private LocalDateTime                     updatedAt;
  private final Set<WorkflowTypeStep> steps = new HashSet<>();

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(final Long id) {
    this.id = id;
  }

  @Override
  public String getIdentity() {
    return identity;
  }

  @Override
  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public Long getCompanyId() {
    return this.companyId;
  }

  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
  }

  public String getCompanyIdentity() {
    return companyIdentity;
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

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Set<WorkflowTypeStep> getSteps() {
    return this.steps;
  }

  public void setSteps(final Set<WorkflowTypeStep> steps) {
    this.steps.clear();
    if (steps != null) {
      this.steps.addAll(steps);
    }
  }

  public void addStep(final WorkflowTypeStep stepId) {
    this.steps.add(stepId);
  }

}

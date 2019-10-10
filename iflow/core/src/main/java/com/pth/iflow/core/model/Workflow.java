package com.pth.iflow.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.pth.iflow.common.enums.EWorkflowIdentity;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.core.model.helper.CoreModelHelper;
import com.pth.iflow.core.model.helper.ICoreIdentityModel;

public class Workflow extends CoreModelHelper implements ICoreIdentityModel {

  private Long             id;
  private String           identity;
  private WorkflowType     workflowType;
  private WorkflowTypeStep currentStep;
  private User             controller;
  private User             createdBy;
  private String           comments;
  private EWorkflowStatus  status;
  private Integer          version;
  private LocalDateTime    createdAt;
  private LocalDateTime    updatedAt;

  private String workflowTypeIdentity;
  private String currentStepIdentity;
  private String controllerIdentity;
  private String createdByIdentity;

  private final List<WorkflowFile>   files   = new ArrayList<>();
  private final List<WorkflowAction> actions = new ArrayList<>();

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

  public boolean isIdentityNotSet() {
    return EWorkflowIdentity.NOT_SET.getName().equals(getIdentity());
  }

  public WorkflowType getWorkflowType() {
    return workflowType;
  }

  public void setWorkflowType(final WorkflowType workflowType) {
    this.workflowType = workflowType;
  }

  public WorkflowTypeStep getCurrentStep() {
    return currentStep;
  }

  public void setCurrentStep(final WorkflowTypeStep currentStep) {
    this.currentStep = currentStep;
  }

  public User getController() {
    return controller;
  }

  public void setController(final User controller) {
    this.controller = controller;
  }

  public User getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(final User createdBy) {
    this.createdBy = createdBy;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public EWorkflowStatus getStatus() {
    return this.status;
  }

  public Integer getStatusInt() {
    return this.status.getValue().intValue();
  }

  public void setStatus(final Integer status) {
    this.status = EWorkflowStatus.ofValue(status);
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

  public List<WorkflowFile> getFiles() {
    return this.files;
  }

  public void setFiles(final List<WorkflowFile> files) {
    this.files.clear();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  public List<WorkflowAction> getActions() {
    return this.actions;
  }

  public void setActions(final List<WorkflowAction> actions) {
    this.actions.clear();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }

  public String getWorkflowTypeIdentity() {
    return workflowTypeIdentity;
  }

  public void setWorkflowTypeIdentity(final String workflowTypeIdentity) {
    this.workflowTypeIdentity = workflowTypeIdentity;
  }

  public String getCurrentStepIdentity() {
    return currentStepIdentity;
  }

  public void setCurrentStepIdentity(final String currentStepIdentity) {
    this.currentStepIdentity = currentStepIdentity;
  }

  public String getControllerIdentity() {
    return controllerIdentity;
  }

  public void setControllerIdentity(final String controllerIdentity) {
    this.controllerIdentity = controllerIdentity;
  }

  public String getCreatedByIdentity() {
    return createdByIdentity;
  }

  public void setCreatedByIdentity(final String createdByIdentity) {
    this.createdByIdentity = createdByIdentity;
  }

}

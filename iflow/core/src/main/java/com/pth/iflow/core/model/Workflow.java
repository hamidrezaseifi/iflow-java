package com.pth.iflow.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.pth.iflow.common.edo.models.base.DataModelBase;
import com.pth.iflow.common.enums.EWorkflowStatus;

public class Workflow extends DataModelBase {

  private Long            id;
  private String          identity;
  private Long            workflowTypeId;
  private Long            currentStepId;
  private Long            controller;
  private Long            createdBy;
  private String          comments;
  private EWorkflowStatus status;
  private Integer         version;
  private LocalDateTime   createdAt;
  private LocalDateTime   updatedAt;

  private final List<WorkflowFile>   files   = new ArrayList<>();
  private final List<WorkflowAction> actions = new ArrayList<>();

  @Override
  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getIdentity() {
    return identity;
  }

  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public Long getWorkflowTypeId() {
    return this.workflowTypeId;
  }

  public void setWorkflowTypeId(final Long workflowTypeId) {
    this.workflowTypeId = workflowTypeId;
  }

  public Long getCurrentStepId() {
    return currentStepId;
  }

  public void setCurrentStepId(final Long currentStepId) {
    this.currentStepId = currentStepId;
  }

  public Long getController() {
    return this.controller;
  }

  public void setController(final Long controller) {
    this.controller = controller;
  }

  public Long getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
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

}

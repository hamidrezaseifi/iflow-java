package com.pth.iflow.core.model.workflow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.pth.iflow.common.enums.EWorkflowIdentity;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.core.model.helper.CoreModelHelper;
import com.pth.iflow.core.model.helper.ICoreIdentityModel;
import com.pth.iflow.core.model.workflow.sub.WorkflowAction;
import com.pth.iflow.core.model.workflow.sub.WorkflowFile;

public class SingleTaskWorkflow extends CoreModelHelper implements ICoreIdentityModel, IWorkflow {

  private Long            id;
  private String          identity;
  private String          comments;
  private EWorkflowStatus status;
  private Integer         version;
  private LocalDateTime   createdAt;
  private LocalDateTime   updatedAt;

  private String currentStepIdentity;
  private String controllerIdentity;
  private String createdByIdentity;

  private Long currentStepId;
  private Long controllerId;
  private Long createdById;
  private Long workflowTypeId;

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

  @Override
  public boolean isIdentityNotSet() {
    return EWorkflowIdentity.NOT_SET.getIdentity().equals(getIdentity());
  }

  @Override
  public String getComments() {
    return this.comments;
  }

  @Override
  public void setComments(final String comments) {
    this.comments = comments;
  }

  @Override
  public EWorkflowStatus getStatus() {
    return this.status;
  }

  @Override
  public Integer getStatusInt() {
    return this.status.getValue().intValue();
  }

  @Override
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

  @Override
  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  @Override
  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  @Override
  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public List<WorkflowFile> getFiles() {
    return this.files;
  }

  @Override
  public void setFiles(final List<WorkflowFile> files) {
    this.files.clear();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  @Override
  public List<WorkflowAction> getActions() {
    return this.actions;
  }

  @Override
  public void setActions(final List<WorkflowAction> actions) {
    this.actions.clear();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }

  @Override
  public String getWorkflowTypeIdentity() {
    return EWorkflowType.SINGLE_TASK_WORKFLOW_TYPE.getIdentity();
  }

  @Override
  public String getCurrentStepIdentity() {
    return currentStepIdentity;
  }

  @Override
  public void setCurrentStepIdentity(final String currentStepIdentity) {
    this.currentStepIdentity = currentStepIdentity;
  }

  @Override
  public String getControllerIdentity() {
    return controllerIdentity;
  }

  @Override
  public void setControllerIdentity(final String controllerIdentity) {
    this.controllerIdentity = controllerIdentity;
  }

  @Override
  public String getCreatedByIdentity() {
    return createdByIdentity;
  }

  @Override
  public void setCreatedByIdentity(final String createdByIdentity) {
    this.createdByIdentity = createdByIdentity;
  }

  @Override
  public Long getCurrentStepId() {
    return currentStepId;
  }

  @Override
  public void setCurrentStepId(final Long currentStepId) {
    this.currentStepId = currentStepId;
  }

  @Override
  public Long getControllerId() {
    return controllerId;
  }

  @Override
  public void setControllerId(final Long controllerId) {
    this.controllerId = controllerId;
  }

  @Override
  public Long getCreatedById() {
    return createdById;
  }

  @Override
  public void setCreatedById(final Long createdById) {
    this.createdById = createdById;
  }

  @Override
  public Long getWorkflowTypeId() {
    return workflowTypeId;
  }

  @Override
  public void setWorkflowTypeId(final Long workflowTypeId) {
    this.workflowTypeId = workflowTypeId;
  }
}

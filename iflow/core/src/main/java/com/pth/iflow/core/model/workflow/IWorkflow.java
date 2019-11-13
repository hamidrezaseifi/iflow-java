package com.pth.iflow.core.model.workflow;

import java.time.LocalDateTime;
import java.util.List;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.core.model.workflow.sub.WorkflowAction;
import com.pth.iflow.core.model.workflow.sub.WorkflowFile;

public interface IWorkflow {

  Long getId();

  void setId(Long id);

  String getIdentity();

  void setIdentity(String identity);

  boolean isIdentityNotSet();

  String getComments();

  void setComments(String comments);

  EWorkflowStatus getStatus();

  Integer getStatusInt();

  void setStatus(Integer status);

  Integer getVersion();

  void setVersion(Integer version);

  LocalDateTime getCreatedAt();

  void setCreatedAt(LocalDateTime createdAt);

  LocalDateTime getUpdatedAt();

  void setUpdatedAt(LocalDateTime updatedAt);

  List<WorkflowFile> getFiles();

  void setFiles(List<WorkflowFile> files);

  List<WorkflowAction> getActions();

  void setActions(List<WorkflowAction> actions);

  String getWorkflowTypeIdentity();

  String getCurrentStepIdentity();

  void setCurrentStepIdentity(String currentStepIdentity);

  String getControllerIdentity();

  void setControllerIdentity(String controllerIdentity);

  String getCreatedByIdentity();

  void setCreatedByIdentity(String createdByIdentity);

  public Long getCurrentStepId();

  public void setCurrentStepId(final Long currentStepId);

  public Long getControllerId();

  public void setControllerId(final Long controllerId);

  public Long getCreatedById();

  public void setCreatedById(final Long createdById);

  public Long getWorkflowTypeId();

  public void setWorkflowTypeId(final Long workflowTypeId);
}

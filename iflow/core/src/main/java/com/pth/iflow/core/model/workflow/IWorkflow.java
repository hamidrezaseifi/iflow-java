package com.pth.iflow.core.model.workflow;

import java.time.LocalDateTime;
import java.util.List;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.workflow.sub.WorkflowAction;
import com.pth.iflow.core.model.workflow.sub.WorkflowFile;
import com.pth.iflow.core.model.workflow.sub.WorkflowType;
import com.pth.iflow.core.model.workflow.sub.WorkflowTypeStep;

public interface IWorkflow {

  Long getId();

  void setId(Long id);

  String getIdentity();

  void setIdentity(String identity);

  boolean isIdentityNotSet();

  WorkflowType getWorkflowType();

  void setWorkflowType(WorkflowType workflowType);

  WorkflowTypeStep getCurrentStep();

  void setCurrentStep(WorkflowTypeStep currentStep);

  User getController();

  void setController(User controller);

  User getCreatedBy();

  void setCreatedBy(User createdBy);

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

  void setWorkflowTypeIdentity(String workflowTypeIdentity);

  String getCurrentStepIdentity();

  void setCurrentStepIdentity(String currentStepIdentity);

  String getControllerIdentity();

  void setControllerIdentity(String controllerIdentity);

  String getCreatedByIdentity();

  void setCreatedByIdentity(String createdByIdentity);

}

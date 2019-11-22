package com.pth.iflow.common.edo.models.base;

import java.util.List;

import com.pth.iflow.common.edo.models.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.WorkflowFileEdo;

public interface IWorkflowEdoBase {

  String getIdentity();

  void setIdentity(String identity);

  String getCurrentStepIdentity();

  void setCurrentStepIdentity(String currentStepIdentity);

  String getControllerIdentity();

  void setControllerIdentity(String controllerIdentity);

  String getCreatedByIdentity();

  void setCreatedByIdentity(String createdByIdentity);

  String getComments();

  void setComments(String comments);

  Integer getStatus();

  void setStatus(Integer status);

  Integer getVersion();

  void setVersion(Integer version);

  List<WorkflowFileEdo> getFiles();

  void setFiles(List<WorkflowFileEdo> files);

  List<WorkflowActionEdo> getActions();

  void setActions(List<WorkflowActionEdo> actions);

  public String getWorkflowType();

}

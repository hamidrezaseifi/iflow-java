package com.pth.iflow.gui.models.workflow;

import java.util.List;

import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.WorkflowAction;
import com.pth.iflow.gui.models.WorkflowFile;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.WorkflowTypeStep;

public interface IWorkflow {

  public WorkflowType getWorkflowType();

  public void setWorkflowType(final WorkflowType workflowType);

  public WorkflowTypeStep getCurrentStep();

  public void setCurrentStep(final WorkflowTypeStep currentStep);

  public String getComments();

  public void setComments(final String comments);

  public int getVersion();

  public void setVersion(final int version);

  public List<WorkflowFile> getFiles();

  public WorkflowFile getFileByIdentity(final String fileIdentity);

  public void setFiles(final List<WorkflowFile> files);

  public List<WorkflowAction> getActions();

  public void setActions(final List<WorkflowAction> actions);

  public String getCurrentStepIdentity();

  public void setCurrentStepIdentity(final String currentStepIdentity);

  public String getControllerIdentity();

  public void setControllerIdentity(final String controllerIdentity);

  public String getCreatedByIdentity();

  public void setCreatedByIdentity(final String createdByIdentity);

  public WorkflowAction getActiveAction();

  public boolean isAssigned();

  public boolean isMeAssigned();

  public boolean isLoggedUserController();

  public boolean isLoggedUserControllerAndDone();

  public boolean isInitializing();

  public void addAction(final WorkflowAction action);

  public String getWorkflowTypeIdentity();

  public boolean getHasActiveAction();

  public void setCreatedByUser(User createdByUser);

  public void setControllerUser(User controllerUser);

  public void setCurrentUserIdentity(String currentUserIdentity);

  public WorkflowFile addNewFile(String generateSavingFilePathPreffix, String identity2, String title, String fileExtention,
      String comments);

  public String getIdentity();

  public int getStatusInt();

  public int getCurrentStepIndex();

  public boolean getIsLastStep();

  public boolean getCanSave();

  public boolean getCanDone();

  public boolean getCanArchive();

  public boolean getIsDone();

  public boolean getCanAssign();

  public boolean getCanEdit();

}

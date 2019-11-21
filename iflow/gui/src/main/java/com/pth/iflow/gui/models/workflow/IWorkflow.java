package com.pth.iflow.gui.models.workflow;

import java.util.List;
import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.WorkflowAction;
import com.pth.iflow.gui.models.WorkflowFile;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.WorkflowTypeStep;

public interface IWorkflow {

  public String getIdentity();

  public void setIdentity(final String identity);

  public boolean isIdentityNotSet();

  public WorkflowType getWorkflowType();

  public void setWorkflowType(final WorkflowType workflowType);

  public WorkflowTypeStep getCurrentStep();

  public void setCurrentStep(final WorkflowTypeStep currentStep);

  public String getComments();

  public void setComments(final String comments);

  public EWorkflowStatus getStatus();

  public Integer getStatusInt();

  public void setStatus(final Integer status);

  public void setStatus(final EWorkflowStatus status);

  public Integer getVersion();

  public void setVersion(final Integer version);

  public List<WorkflowFile> getFiles();

  public void setFiles(final List<WorkflowFile> files);

  public List<WorkflowAction> getActions();

  public boolean hasAction();

  public void setActions(final List<WorkflowAction> actions);

  public abstract EWorkflowType getWorkflowTypeEnum();

  public String getCurrentStepIdentity();

  public void setCurrentStepIdentity(final String currentStepIdentity);

  public boolean isCurrentStepIdentity(final String stepIdentity);

  public String getControllerIdentity();

  public void setControllerIdentity(final String controllerIdentity);

  public String getCreatedByIdentity();

  public void setCreatedByIdentity(final String createdByIdentity);

  public boolean hasActiveAction();

  public WorkflowAction getActiveAction();

  public WorkflowAction getLastAction();

  public boolean isAssigned();

  public void setActiveActionAssignTo(final String userIdentity);

  public void setActiveActionStatus(final EWorkflowActionStatus status);

  public boolean isInitializing();

  public boolean isOffering();

  public boolean isArchived();

  public boolean isAssignedStatus();

  public boolean isDone();

  public boolean hasController();

  public boolean hasCreatedBy();

  public boolean hasWorkflowType();

  public void addAction(final WorkflowAction action);

  public String getWorkflowTypeIdentity();

  public boolean isNew();

  public boolean getHasActiveAction();

  public WorkflowFile getFileByIdentity(String identity);

  public void setCreatedByUser(User createdByUser);

  public void setControllerUser(User controllerUser);

  public void setCurrentUserIdentity(String currentUserIdentity);

}

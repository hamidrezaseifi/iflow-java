package com.pth.iflow.gui.models.workflow;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.gui.models.WorkflowAction;
import com.pth.iflow.gui.models.WorkflowFile;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.WorkflowTypeStep;

public class WorkflowResult {

  private String                     identity;
  private String                     workflowTypeIdentity;
  private String                     currentStepIdentity;
  private String                     controllerIdentity;
  private String                     createdByIdentity;
  private EWorkflowStatus            status;

  private WorkflowType               workflowType;
  private WorkflowTypeStep           currentStep;

  private final List<WorkflowFile>   files   = new ArrayList<>();
  private final List<WorkflowAction> actions = new ArrayList<>();

  private String                     currentUserIdentity;

  public WorkflowResult() {

  }

  public String getIdentity() {
    return this.identity;
  }

  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public String getWorkflowTypeIdentity() {
    return this.workflowTypeIdentity;
  }

  public void setWorkflowTypeIdentity(final String workflowTypeIdentity) {
    this.workflowTypeIdentity = workflowTypeIdentity;
  }

  public String getCurrentStepIdentity() {
    return this.currentStepIdentity;
  }

  public void setCurrentStepIdentity(final String currentStepIdentity) {
    this.currentStepIdentity = currentStepIdentity;
  }

  public String getControllerIdentity() {
    return this.controllerIdentity;
  }

  public void setControllerIdentity(final String controllerIdentity) {
    this.controllerIdentity = controllerIdentity;
  }

  public String getCreatedByIdentity() {
    return this.createdByIdentity;
  }

  public void setCreatedByIdentity(final String createdByIdentity) {
    this.createdByIdentity = createdByIdentity;
  }

  public EWorkflowStatus getStatus() {
    return this.status;
  }

  public void setStatus(final Integer status) {
    this.status = EWorkflowStatus.ofValue(status);
  }

  public void setStatus(final EWorkflowStatus status) {
    this.status = status;
  }

  public WorkflowType getWorkflowType() {
    return this.workflowType;
  }

  public void setWorkflowType(final WorkflowType workflowType) {
    this.workflowType = workflowType;
  }

  public WorkflowTypeStep getCurrentStep() {
    return this.currentStep;
  }

  public void setCurrentStep(final WorkflowTypeStep currentStep) {
    this.currentStep = currentStep;
  }

  public List<WorkflowFile> getFiles() {
    return this.files;
  }

  public List<WorkflowAction> getActions() {
    return this.actions;
  }

  public void setFiles(final List<WorkflowFile> files) {
    this.files.clear();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  public void addFile(final WorkflowFile file) {
    this.files.add(file);
  }

  public void setActions(final List<WorkflowAction> actions) {
    this.actions.clear();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }

  public void addAction(final WorkflowAction action) {
    this.actions.add(action);
  }

  public boolean getHasActiveAction() {

    return this.getActiveAction() != null;
  }

  public WorkflowAction getActiveAction() {
    for (final WorkflowAction action : this.getActions()) {
      if (action.getIsActive() == true) {
        return action;
      }
    }
    return null;
  }

  public String getAssignToUserFullName() {
    if (this.getHasActiveAction()) {
      return this.getActiveAction().getAssignToUserName();
    }
    return "";
  }

  public boolean isAfter(final WorkflowTypeStep step) {
    return this.currentStep.isAfterStep(step);
  }

  public boolean isBefore(final WorkflowTypeStep step) {
    return this.currentStep.isBeforeStep(step);
  }

  public boolean isTheSame(final WorkflowTypeStep step) {
    return this.currentStep.isTheSameStep(step);
  }

  public boolean isInitializing() {
    return (this.getStatus() == EWorkflowStatus.INITIALIZE);
  }

  public boolean isAssigned() {
    return (this.getStatus() == EWorkflowStatus.ASSIGNED);
  }

  public boolean isMeAssigned() {
    return this.isAssigned() && (this.getHasActiveAction() && this.getActiveAction().isAssignTo(this.currentUserIdentity));
  }

  public boolean isNotAssigned() {
    return this.isAssigned() == false;
  }

  public String getCurrentUserIdentity() {
    return this.currentUserIdentity;
  }

  public void setCurrentUserIdentity(final String currentUserIdentity) {
    this.currentUserIdentity = currentUserIdentity;
  }
}

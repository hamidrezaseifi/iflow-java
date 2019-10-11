package com.pth.iflow.workflow.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.pth.iflow.common.edo.models.helper.IdentityModel;
import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowIdentity;
import com.pth.iflow.common.enums.EWorkflowStatus;

public class Workflow extends IdentityModel {

  private String                     identity;
  private WorkflowType               workflowType;
  private WorkflowTypeStep           currentStep;
  private User                       controller;
  private User                       createdBy;
  private String                     comments;
  private EWorkflowStatus            status;
  private Integer                    version;

  private String                     workflowTypeIdentity;
  private String                     currentStepIdentity;
  private String                     controllerIdentity;
  private String                     createdByIdentity;

  private final List<WorkflowFile>   files   = new ArrayList<>();
  private final List<WorkflowAction> actions = new ArrayList<>();

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

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
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

  public boolean hasAction() {
    return this.actions.isEmpty() == false;
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

  public boolean isCurrentStepIdentity(final String stepIdentity) {
    return currentStepIdentity.equals(stepIdentity);
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

  public boolean hasActiveAction() {

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

  public WorkflowAction getLastAction() {

    if (hasAction() == false) {
      return null;
    }

    final List<WorkflowAction> astinList = this.getActions();
    astinList.sort(new Comparator<WorkflowAction>() {

      @Override
      public int compare(final WorkflowAction action1, final WorkflowAction action2) {

        return action1.getCurrentStep().getStepIndex() > action2.getCurrentStep().getStepIndex() ? 1
            : action1.getCurrentStep().getStepIndex() < action2.getCurrentStep().getStepIndex() ? -1 : 0;
      }
    });

    return astinList.get(astinList.size() - 1);
  }

  public boolean isAssigned() {
    return this.hasActiveAction() && this.getActiveAction().isAssigned();
  }

  public void setActiveActionAssignTo(final String userIdentity) {
    this.getActiveAction().setAssignToIdentity(userIdentity);
  }

  public void setActiveActionStatus(final EWorkflowActionStatus status) {
    this.getActiveAction().setStatus(status);
  }

}

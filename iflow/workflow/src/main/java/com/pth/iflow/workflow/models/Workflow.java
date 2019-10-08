package com.pth.iflow.workflow.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.pth.iflow.common.edo.models.base.DataModelBase;
import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowStatus;

public class Workflow extends DataModelBase {

  private Long             id;
  private String           identity;
  private Long             workflowTypeId;
  private WorkflowType     workflowType;
  private WorkflowTypeStep currentStep;
  private Long             currentStepId;
  private Long             controller;
  private Long             createdBy;
  private String           comments;
  private EWorkflowStatus  status;
  private Integer          version;

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

  public WorkflowType getWorkflowType() {
    return workflowType;
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

  public Long getCurrentStepId() {
    return this.currentStepId;
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

  public void setStatus(final EWorkflowStatus status) {
    this.status = status;
  }

  public void setStatusInt(final Integer status) {
    this.status = EWorkflowStatus.ofValue(status);
  }

  public Integer getStatusInt() {
    return this.status.getValue().intValue();
  }

  public boolean isStatusArchive() {
    return this.status == EWorkflowStatus.ARCHIVED;
  }

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
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

  public void addAction(final WorkflowAction action) {
    this.actions.add(action);

  }

  public boolean isAfterStep(final Workflow other) {
    return this.currentStep.isAfterStep(other.getCurrentStep());
  }

  public boolean isBeforeStep(final Workflow other) {
    return this.currentStep.isBeforeStep(other.getCurrentStep());
  }

  public boolean isTheSameStep(final Workflow other) {
    return this.currentStep.isTheSameStep(other.getCurrentStep());
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
    return this.isNew() && (this.getStatus() == EWorkflowStatus.INITIALIZE);
  }

  public boolean isOffering() {
    return this.getStatus() == EWorkflowStatus.OFFERING;
  }

  public boolean isDone() {
    return this.getStatus() == EWorkflowStatus.DONE;
  }

  public boolean isArchived() {
    return this.getStatus() == EWorkflowStatus.ARCHIVED;
  }

  @Override
  public boolean isNew() {
    return (this.getId() == null) || (this.getId() <= 0);
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
                                                                                                 : action1.getCurrentStep()
                                                                                                          .getStepIndex() < action2.getCurrentStep()
                                                                                                                                   .getStepIndex() ? -1
                                                                                                                                                   : 0;
      }
    });

    return astinList.get(astinList.size() - 1);
  }

  public boolean isAssigned() {
    return this.hasActiveAction() && this.getActiveAction().isAssigned();
  }

  public void setActiveActionAssignTo(final Long userId) {
    this.getActiveAction().setAssignTo(userId);
  }

  public void setActiveActionStatus(final EWorkflowActionStatus status) {
    this.getActiveAction().setStatus(status);
  }

}

package com.pth.iflow.workflow.models.workflow.singletask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.pth.iflow.common.edo.models.helper.IdentityModel;
import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowIdentity;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowFile;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;
import com.pth.iflow.workflow.models.base.IWorkflow;

public class SingleTaskWorkflow extends IdentityModel implements IWorkflow {

  private String           identity;
  private WorkflowType     workflowType;
  private WorkflowTypeStep currentStep;
  private String           comments;
  private EWorkflowStatus  status;
  private Integer          version;

  private String currentStepIdentity;
  private String controllerIdentity;
  private String createdByIdentity;

  private final List<WorkflowFile>   files   = new ArrayList<>();
  private final List<WorkflowAction> actions = new ArrayList<>();

  @Override
  public EWorkflowType getWorkflowTypeEnum() {
    return EWorkflowType.INVOICE_WORKFLOW_TYPE;
  }

  @Override
  public String getWorkflowTypeIdentity() {
    return getWorkflowTypeEnum().getName();
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
    return EWorkflowIdentity.NOT_SET.getName().equals(getIdentity());
  }

  @Override
  public WorkflowType getWorkflowType() {
    return workflowType;
  }

  @Override
  public void setWorkflowType(final WorkflowType workflowType) {
    this.workflowType = workflowType;
  }

  @Override
  public WorkflowTypeStep getCurrentStep() {
    return currentStep;
  }

  @Override
  public void setCurrentStep(final WorkflowTypeStep currentStep) {
    this.currentStep = currentStep;
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
  public void setStatus(final EWorkflowStatus status) {
    this.status = status;
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
  public boolean hasAction() {
    return this.actions.isEmpty() == false;
  }

  @Override
  public void setActions(final List<WorkflowAction> actions) {
    this.actions.clear();
    if (actions != null) {
      this.actions.addAll(actions);
    }
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
  public boolean isCurrentStepIdentity(final String stepIdentity) {
    return currentStepIdentity.equals(stepIdentity);
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
  public boolean hasActiveAction() {

    return this.getActiveAction() != null;
  }

  @Override
  public WorkflowAction getActiveAction() {
    for (final WorkflowAction action : this.getActions()) {
      if (action.getIsActive() == true) {
        return action;
      }
    }
    return null;
  }

  @Override
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

  @Override
  public boolean isAssigned() {
    return this.hasActiveAction() && this.getActiveAction().isAssigned();
  }

  @Override
  public void setActiveActionAssignTo(final String userIdentity) {
    this.getActiveAction().setAssignToIdentity(userIdentity);
  }

  @Override
  public void setActiveActionStatus(final EWorkflowActionStatus status) {
    this.getActiveAction().setStatus(status);
  }

  @Override
  public boolean isInitializing() {
    return EWorkflowStatus.INITIALIZE.equals(this.status);
  }

  @Override
  public boolean isOffering() {
    return EWorkflowStatus.OFFERING.equals(this.status);
  }

  @Override
  public boolean isArchived() {
    return EWorkflowStatus.ARCHIVED.equals(this.status);
  }

  @Override
  public boolean isAssignedStatus() {
    return EWorkflowStatus.ASSIGNED.equals(this.status);
  }

  @Override
  public boolean isDone() {
    return EWorkflowStatus.DONE.equals(this.status);
  }

  @Override
  public boolean hasController() {
    return StringUtils.isNoneEmpty(this.controllerIdentity);
  }

  @Override
  public boolean hasCreatedBy() {
    return StringUtils.isNoneEmpty(this.createdByIdentity);
  }

  @Override
  public boolean hasWorkflowType() {
    return this.workflowType != null;
  }

  @Override
  public void addAction(final WorkflowAction action) {
    action.setWorkflowIdentity(this.identity);
    this.actions.add(action);
  }

  @Override
  public boolean isNew() {
    return IdentityModel.isIdentityNew(this.getIdentity());
  }
}

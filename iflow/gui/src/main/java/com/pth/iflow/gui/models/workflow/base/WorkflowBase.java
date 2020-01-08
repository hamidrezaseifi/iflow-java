package com.pth.iflow.gui.models.workflow.base;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.common.models.helper.IdentityModel;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.WorkflowAction;
import com.pth.iflow.gui.models.WorkflowFile;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.WorkflowTypeStep;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflow;

public class WorkflowBase extends IdentityModel implements IWorkflow {

  private String identity;
  private String companyIdentity;

  private String workflowTypeIdentity;
  private WorkflowType workflowType;
  private WorkflowTypeStep currentStep;
  private String currentStepIdentity;
  private String controllerIdentity;
  private User controllerUser;
  private String createdByIdentity;
  private User createdByUser;
  private String comments;
  private EWorkflowStatus status;
  private int version;
  private String currentUserIdentity;

  private final List<WorkflowFile> files = new ArrayList<>();
  private final List<WorkflowAction> actions = new ArrayList<>();

  @Override
  public String getIdentity() {

    return this.identity;
  }

  @Override
  public void setIdentity(final String identity) {

    this.identity = identity;
  }

  public EWorkflowType getWorkflowTypeEnum() {

    return EWorkflowType.valueFromIdentity(this.workflowTypeIdentity);
  }

  @Override
  public String getWorkflowTypeIdentity() {

    return this.workflowTypeIdentity;
  }

  public void setWorkflowTypeIdentity(final String workflowTypeIdentity) {

    this.workflowTypeIdentity = workflowTypeIdentity;
  }

  @Override
  public String getCompanyIdentity() {

    return this.companyIdentity;
  }

  @Override
  public void setCompanyIdentity(final String companyIdentity) {

    this.companyIdentity = companyIdentity;
  }

  @Override
  public WorkflowType getWorkflowType() {

    return this.workflowType;
  }

  /**
   * @param workflowType the workflowType to set
   */

  @Override
  public void setWorkflowType(final WorkflowType workflowType) {

    this.workflowType = workflowType;
  }

  @Override
  public WorkflowTypeStep getCurrentStep() {

    return this.currentStep;
  }

  @Override
  public void setCurrentStep(final WorkflowTypeStep currentStep) {

    this.currentStep = currentStep;
  }

  @Override
  public String getCurrentStepIdentity() {

    return this.currentStepIdentity;
  }

  @Override
  public void setCurrentStepIdentity(final String currentStepIdentity) {

    this.currentStepIdentity = currentStepIdentity;
  }

  @Override
  public String getControllerIdentity() {

    return this.controllerIdentity;
  }

  @Override
  public void setControllerIdentity(final String controllerIdentity) {

    this.controllerIdentity = controllerIdentity;
  }

  /**
   * @return the controllerUser
   */
  public User getControllerUser() {

    return this.controllerUser;
  }

  /**
   * @param controllerUser the controllerUser to set
   */

  @Override
  public void setControllerUser(final User controllerUser) {

    this.controllerUser = controllerUser;
  }

  @Override
  public String getCreatedByIdentity() {

    return this.createdByIdentity;
  }

  @Override
  public void setCreatedByIdentity(final String createdByIdentity) {

    this.createdByIdentity = createdByIdentity;
  }

  /**
   * @return the createdByUser
   */
  public User getCreatedByUser() {

    return this.createdByUser;
  }

  /**
   * @param createdByUser the createdByUser to set
   */

  @Override
  public void setCreatedByUser(final User createdByUser) {

    this.createdByUser = createdByUser;
  }

  @Override
  public String getComments() {

    return this.comments;
  }

  @Override
  public void setComments(final String comments) {

    this.comments = comments;
  }

  public EWorkflowStatus getStatus() {

    return this.status;
  }

  @JsonSetter
  public void setStatus(final EWorkflowStatus status) {

    this.status = status;
  }

  public void setStatus(final int status) {

    this.status = EWorkflowStatus.ofValue(status);
  }

  public void setStatusInt(final int status) {

    this.status = EWorkflowStatus.ofValue(status);
  }

  @Override
  public int getStatusInt() {

    return this.status.getValue().intValue();
  }

  @Override
  public int getVersion() {

    return this.version;
  }

  @Override
  public void setVersion(final int version) {

    this.version = version;
  }

  @Override
  public List<WorkflowFile> getFiles() {

    return this.files;
  }

  @Override
  public WorkflowFile getFileByIdentity(final String fileIdentity) {

    for (final WorkflowFile file : this.files) {
      if (file.getIdentity().equals(fileIdentity)) {
        return file;
      }
    }
    return null;
  }

  @Override
  public void setFiles(final List<WorkflowFile> files) {

    this.files.clear();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  @Override
  public void clearFiles() {

    this.files.clear();
  }

  public void addFile(final WorkflowFile file) {

    this.files.add(file);
  }

  @Override
  public WorkflowFile addNewFile(final String path, final String userId, final String title, final String extention,
      final String comments) {

    final WorkflowFile wfile = new WorkflowFile();
    wfile.setActiveFilePath(path);
    wfile.setActiveFileVersion(1);
    wfile.setComments(comments);
    wfile.setCreatedByIdentity(userId);
    wfile.setExtention(extention);

    wfile.setStatus(1);
    wfile.setTitle(title);

    wfile.addNewFileVersion(path, 1, userId, comments);

    this.addFile(wfile);

    return wfile;
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
  public void addAction(final WorkflowAction action) {

    this.actions.add(action);
  }

  public String getCurrentUserIdentity() {

    return this.currentUserIdentity;
  }

  @Override
  public void setCurrentUserIdentity(final String currentUserIdentity) {

    this.currentUserIdentity = currentUserIdentity;
  }

  public boolean isAfterStep(final InvoiceWorkflow other) {

    return this.currentStep.isAfterStep(other.getCurrentStep());
  }

  public boolean isBeforeStep(final InvoiceWorkflow other) {

    return this.currentStep.isBeforeStep(other.getCurrentStep());
  }

  public boolean isTheSameStep(final InvoiceWorkflow other) {

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

  @Override
  public boolean isInitializing() {

    return (this.getStatus() == EWorkflowStatus.INITIALIZE);
  }

  @Override
  public boolean isAssigned() {

    return (this.getStatus() == EWorkflowStatus.ASSIGNED);
  }

  @Override
  public boolean isMeAssigned() {

    return (this.isAssigned() || this.isInitializing())
        && (this.getHasActiveAction() && this.getActiveAction().isAssignTo(this.currentUserIdentity));
  }

  @Override
  public boolean isLoggedUserController() {

    return this.controllerIdentity.equals(this.currentUserIdentity);
  }

  @Override
  public boolean isLoggedUserControllerAndDone() {

    return this.controllerIdentity.equals(this.currentUserIdentity) && this.getIsDone();
  }

  public boolean isNotAssigned() {

    return this.isAssigned() == false;
  }

  @Override
  public boolean getHasActiveAction() {

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
  public boolean getIsDone() {

    return this.status == EWorkflowStatus.DONE;
  }

  public boolean getIsArchived() {

    return this.status == EWorkflowStatus.ARCHIVED;
  }

  public boolean getIsError() {

    return this.status == EWorkflowStatus.ERROR;
  }

  public boolean getIsOpen() {

    return (this.status == EWorkflowStatus.ASSIGNED);
  }

  public String getAssignToUserFullName() {

    if (this.getHasActiveAction()) {
      return this.getActiveAction().getAssignToUserName();
    }
    return "";
  }

  @Override
  public int getCurrentStepIndex() {

    if (this.currentStep != null) {
      return this.currentStep.getStepIndex();
    }

    if (this.getHasActiveAction()) {
      return this.getActiveAction().getCurrentStep().getStepIndex();
    }

    if (this.workflowType != null) {
      return this.workflowType.getSteps().get(0).getStepIndex();
    }

    return 0;
  }

  @Override
  public boolean getIsLastStep() {

    if (this.workflowType != null) {
      return this.getLastStep().getStepIndex() == this.getCurrentStepIndex();
    }
    return false;
  }

  private WorkflowTypeStep getLastStep() {

    if (this.workflowType != null) {
      return this.workflowType.getSteps().get(this.workflowType.getSteps().size() - 1);
    }
    return null;
  }

  @Override
  public boolean getCanSave() {

    return (this.getIsLastStep() == false || this.getIsDone() == false) && this.getIsArchived() == false;
  }

  @Override
  public boolean getCanDone() {

    return this.getIsDone() == false && this.getIsArchived() == false;
  }

  @Override
  public boolean getCanArchive() {

    return this.getIsLastStep() && this.getIsDone() && this.getIsArchived() == false;
  }

  @Override
  public boolean getCanAssign() {

    return this.getIsLastStep() == false;
  }

  @Override
  public boolean getCanEdit() {

    return this.isMeAssigned() || this.isLoggedUserControllerAndDone();
  }

}

package com.pth.iflow.gui.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pth.iflow.common.edo.models.helper.IdentityModel;
import com.pth.iflow.common.enums.EWorkflowIdentity;
import com.pth.iflow.common.enums.EWorkflowStatus;

@JsonIgnoreProperties(value = { "isAssignTo" })
public class Workflow extends IdentityModel {

  private String                     identity;
  private String                     workflowTypeIdentity;
  private WorkflowType               workflowType;
  private WorkflowTypeStep           currentStep;
  private String                     currentStepIdentity;
  private String                     controllerIdentity;
  private User                       controllerUser;
  private String                     createdByIdentity;
  private User                       createdByUser;
  private String                     comments;
  private EWorkflowStatus            status;
  private Integer                    version;
  private String                     currentUserIdentity;

  private final List<WorkflowFile>   files   = new ArrayList<>();
  private final List<WorkflowAction> actions = new ArrayList<>();

  @Override
  public String getIdentity() {
    return this.identity;
  }

  @Override
  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public String getWorkflowTypeIdentity() {
    return this.workflowTypeIdentity;
  }

  public void setWorkflowTypeIdentity(final String workflowTypeIdentity) {
    this.workflowTypeIdentity = workflowTypeIdentity;
  }

  /**
   * @return the workflowType
   */
  public WorkflowType getWorkflowType() {
    return this.workflowType;
  }

  /**
   * @param workflowType the workflowType to set
   */
  public void setWorkflowType(final WorkflowType workflowType) {
    this.workflowType = workflowType;
  }

  public WorkflowTypeStep getCurrentStep() {
    return this.currentStep;
  }

  public void setCurrentStep(final WorkflowTypeStep currentStep) {
    this.currentStep = currentStep;
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

  /**
   * @return the controllerUser
   */
  public User getControllerUser() {
    return this.controllerUser;
  }

  /**
   * @param controllerUser the controllerUser to set
   */
  public void setControllerUser(final User controllerUser) {
    this.controllerUser = controllerUser;
  }

  public String getCreatedByIdentity() {
    return this.createdByIdentity;
  }

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
  public void setCreatedByUser(final User createdByUser) {
    this.createdByUser = createdByUser;
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

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  public List<WorkflowFile> getFiles() {
    return this.files;
  }

  public WorkflowFile getFileByIdentity(final String fileIdentity) {

    for (final WorkflowFile file : this.files) {
      if (file.getIdentity().equals(fileIdentity)) {
        return file;
      }
    }
    return null;
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

  public List<WorkflowAction> getActions() {
    return this.actions;
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

  public String getCurrentUserIdentity() {
    return this.currentUserIdentity;
  }

  public void setCurrentUserIdentity(final String currentUserIdentity) {
    this.currentUserIdentity = currentUserIdentity;
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

  public static Workflow generateInitial(final String creatorId) {
    final Workflow newWorkflow = new Workflow();
    newWorkflow.setStatus(EWorkflowStatus.INITIALIZE);
    newWorkflow.setCreatedByIdentity(creatorId);
    newWorkflow.setControllerIdentity("");
    newWorkflow.setCurrentStepIdentity("");
    newWorkflow.setVersion(0);
    newWorkflow.setWorkflowTypeIdentity("");
    newWorkflow.setComments("");
    newWorkflow.setIdentity(EWorkflowIdentity.NOT_SET.getName());

    return newWorkflow;
  }
}

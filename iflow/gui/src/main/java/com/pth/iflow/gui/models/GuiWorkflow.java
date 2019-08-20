package com.pth.iflow.gui.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowListEdo;
import com.pth.iflow.common.enums.EWorkflowStatus;

public class GuiWorkflow {

  private Long                id;
  private Long                workflowTypeId;
  private GuiWorkflowType     workflowType;
  private GuiWorkflowTypeStep currentStep;
  private Long                currentStepId;
  private Long                controller;
  private GuiUser             controllerUser;
  private Long                createdBy;
  private GuiUser             createdByUser;
  private Long                assignTo;
  private GuiUser             assignToUser;
  private String              title;
  private String              comments;
  private EWorkflowStatus     status;
  private Integer             version;

  private final List<GuiWorkflowFile>   files   = new ArrayList<>();
  private final List<GuiWorkflowAction> actions = new ArrayList<>();

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowTypeId() {
    return this.workflowTypeId;
  }

  public void setWorkflowTypeId(final Long workflowTypeId) {
    this.workflowTypeId = workflowTypeId;
  }

  /**
   * @return the workflowType
   */
  public GuiWorkflowType getWorkflowType() {
    return this.workflowType;
  }

  /**
   * @param workflowType the workflowType to set
   */
  public void setWorkflowType(final GuiWorkflowType workflowType) {
    this.workflowType = workflowType;
  }

  public GuiWorkflowTypeStep getCurrentStep() {
    return this.currentStep;
  }

  public void setCurrentStep(final GuiWorkflowTypeStep currentStep) {
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

  /**
   * @return the controllerUser
   */
  public GuiUser getControllerUser() {
    return this.controllerUser;
  }

  /**
   * @param controllerUser the controllerUser to set
   */
  public void setControllerUser(final GuiUser controllerUser) {
    this.controllerUser = controllerUser;
  }

  public Long getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * @return the createdByUser
   */
  public GuiUser getCreatedByUser() {
    return this.createdByUser;
  }

  /**
   * @param createdByUser the createdByUser to set
   */
  public void setCreatedByUser(final GuiUser createdByUser) {
    this.createdByUser = createdByUser;
  }

  public Long getAssignTo() {
    return this.assignTo;
  }

  public boolean isAssigned() {
    return (this.assignTo != null) && (this.assignTo > 0);
  }

  public void setAssignTo(final Long assignTo) {
    this.assignTo = assignTo;
  }

  /**
   * @return the assignToUser
   */
  public GuiUser getAssignToUser() {
    return this.assignToUser;
  }

  /**
   * @param assignToUser the assignToUser to set
   */
  public void setAssignToUser(final GuiUser assignToUser) {
    this.assignToUser = assignToUser;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(final String title) {
    this.title = title;
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

  public List<GuiWorkflowFile> getFiles() {
    return this.files;
  }

  public void setFiles(final List<GuiWorkflowFile> files) {
    this.files.clear();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  public List<GuiWorkflowAction> getActions() {
    return this.actions;
  }

  public void setActions(final List<GuiWorkflowAction> actions) {
    this.actions.clear();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }

  public boolean isAfterStep(final GuiWorkflow other) {
    return this.currentStep.isAfterStep(other.getCurrentStep());
  }

  public boolean isBeforeStep(final GuiWorkflow other) {
    return this.currentStep.isBeforeStep(other.getCurrentStep());
  }

  public boolean isTheSameStep(final GuiWorkflow other) {
    return this.currentStep.isTheSameStep(other.getCurrentStep());
  }

  public boolean isAfter(final GuiWorkflowTypeStep step) {
    return this.currentStep.isAfterStep(step);
  }

  public boolean isBefore(final GuiWorkflowTypeStep step) {
    return this.currentStep.isBeforeStep(step);
  }

  public boolean isTheSame(final GuiWorkflowTypeStep step) {
    return this.currentStep.isTheSameStep(step);
  }

  public boolean getIsNew() {
    return (getId() == null) || (getId() <= 0);
  }

  public boolean isInitializing() {
    return this.getIsNew() && (this.getStatus() == EWorkflowStatus.INITIALIZE);
  }

  public WorkflowEdo toEdo() {
    final WorkflowEdo edo = new WorkflowEdo();
    edo.setTitle(this.title);
    edo.setComments(this.comments);
    edo.setStatus(this.getStatusInt());
    edo.setId(this.id);
    edo.setController(this.controller);
    edo.setCurrentStep(this.currentStep != null ? this.currentStep.toEdo() : null);
    edo.setCurrentStepId(this.currentStepId);
    edo.setCreatedBy(this.createdBy);
    edo.setWorkflowTypeId(this.workflowTypeId);
    edo.setVersion(this.version);
    edo.setAssignTo(this.assignTo);

    edo.setFiles(ModelMapperBase.toEdoList(this.files));
    edo.setActions(ModelMapperBase.toEdoList(this.actions));

    return edo;
  }

  public static GuiWorkflow fromEdo(final WorkflowEdo edo) {
    if (edo == null) {
      return null;
    }
    final GuiWorkflow model = new GuiWorkflow();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatusInt(edo.getStatus());
    model.setId(edo.getId());
    model.setController(edo.getController());
    model.setCurrentStep(edo.getCurrentStep() != null ? new GuiWorkflowTypeStep().fromEdo(edo.getCurrentStep()) : null);
    model.setCurrentStepId(edo.getCurrentStepId());
    model.setCreatedBy(edo.getCreatedBy());
    model.setWorkflowTypeId(edo.getWorkflowTypeId());
    model.setVersion(edo.getVersion());
    model.setAssignTo(edo.getAssignTo());

    model.setFiles(new GuiWorkflowFile().fromEdoList(edo.getFiles()));
    model.setActions(new GuiWorkflowAction().fromEdoList(edo.getActions()));

    return model;
  }

  public static List<GuiWorkflow> fromEdoList(final List<WorkflowEdo> edoList) {
    if (edoList == null) {
      return null;
    }
    return edoList.stream().map(m -> GuiWorkflow.fromEdo(m)).collect(Collectors.toList());
  }

  public static List<WorkflowEdo> toEdoList(final List<GuiWorkflow> list) {
    if (list == null) {
      return null;
    }
    return list.stream().map(m -> m.toEdo()).collect(Collectors.toList());
  }

  public static List<GuiWorkflow> fromEdoList(final WorkflowListEdo edoList) {
    if (edoList == null) {
      return null;
    }
    return edoList.getWorkflows().stream().map(m -> GuiWorkflow.fromEdo(m)).collect(Collectors.toList());
  }

  public static GuiWorkflow generateInitial(final Long creatorId) {
    final GuiWorkflow newWorkflow = new GuiWorkflow();
    newWorkflow.setStatus(EWorkflowStatus.INITIALIZE);
    newWorkflow.setAssignTo(0L);
    newWorkflow.setCreatedBy(creatorId);
    newWorkflow.setController(0L);
    newWorkflow.setCurrentStepId(0L);
    newWorkflow.setId(0L);
    newWorkflow.setTitle("");
    newWorkflow.setVersion(0);
    newWorkflow.setWorkflowTypeId(0L);
    newWorkflow.setComments("");

    return newWorkflow;
  }
}

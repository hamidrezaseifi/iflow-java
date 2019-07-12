package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkflowEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkflowEdo {

  @XmlElement(name = "ID")
  private Long                    id;

  @NotNull
  @XmlElement(name = "WorkflowTypeId")
  private Long                    workflowTypeId;

  @NotNull
  @XmlElement(name = "CurrentStep")
  private WorkflowTypeStepEdo     currentStep;

  @XmlElement(name = "CurrentStepId")
  private Long                    currentStepId;

  @XmlElement(name = "Controller")
  private Long                    controller;

  @XmlElement(name = "CreatedBy")
  private Long                    createdBy;

  @XmlElement(name = "AssignTo")
  private Long                    assignTo;

  @NotNull
  @XmlElement(name = "Title")
  private String                  title;

  @XmlElement(name = "Comments")
  private String                  comments;

  @NotNull
  @XmlElement(name = "Status")
  private Integer                 status;

  @NotNull
  @XmlElement(name = "Version")
  private Integer                 version;

  @XmlElementWrapper(name = "WorkflowFileList")
  @XmlElement(name = "WorkflowFile")
  private List<WorkflowFileEdo>   files   = new ArrayList<>();

  @XmlElementWrapper(name = "WorkflowActionList")
  @XmlElement(name = "WorkflowAction")
  private List<WorkflowActionEdo> actions = new ArrayList<>();

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

  public WorkflowTypeStepEdo getCurrentStep() {
    return this.currentStep;
  }

  public void setCurrentStep(final WorkflowTypeStepEdo currentStep) {
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

  public Long getAssignTo() {
    return this.assignTo;
  }

  public void setAssignTo(final Long assignTo) {
    this.assignTo = assignTo;
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

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(final Integer status) {
    this.status = status;
  }

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  public List<WorkflowFileEdo> getFiles() {
    return this.files;
  }

  public void setFiles(final List<WorkflowFileEdo> files) {
    this.files = new ArrayList<>();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  public List<WorkflowActionEdo> getActions() {
    return this.actions;
  }

  public void setActions(final List<WorkflowActionEdo> actions) {
    this.actions = new ArrayList<>();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }

}

package com.pth.iflow.common.edo.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonSetter;

@XmlRootElement(name = "WorkflowEdo")
public class WorkflowEdo {

  @XmlElement(name = "ID")
  private Long                   id;

  @NotNull
  @XmlElement(name = "WorkflowTypeId")
  private Long                   workflowTypeId;

  @NotNull
  @XmlElement(name = "CurrentStep")
  private WorkflowTypeStepEdo    currentStep;

  @XmlElement(name = "CurrentStepId")
  private Long                   currentStepId;

  @XmlElement(name = "Controller")
  private Long                   controller;

  @XmlElement(name = "CreatedBy")
  private Long                   createdBy;

  @XmlElement(name = "AssignTo")
  private Long                   assignTo;

  @NotNull
  @XmlElement(name = "Title")
  private String                 title;

  @XmlElement(name = "Comments")
  private String                 comments;

  @NotNull
  @XmlElement(name = "Status")
  private Integer                status;

  @NotNull
  @XmlElement(name = "Version")
  private Integer                version;

  @XmlElementWrapper(name = "FileList")
  @XmlElement(name = "File")
  private Set<WorkflowFileEdo>   files   = new HashSet<>();

  @XmlElementWrapper(name = "ActionList")
  @XmlElement(name = "Action")
  private Set<WorkflowActionEdo> actions = new HashSet<>();

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowTypeId() {
    return workflowTypeId;
  }

  public void setWorkflowTypeId(final Long workflowTypeId) {
    this.workflowTypeId = workflowTypeId;
  }

  public WorkflowTypeStepEdo getCurrentStep() {
    return currentStep;
  }

  public void setCurrentStep(final WorkflowTypeStepEdo currentStep) {
    this.currentStep = currentStep;
  }

  public Long getCurrentStepId() {
    return currentStepId;
  }

  public void setCurrentStepId(final Long currentStepId) {
    this.currentStepId = currentStepId;
  }

  public Long getController() {
    return controller;
  }

  public void setController(final Long controller) {
    this.controller = controller;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  public Long getAssignTo() {
    return assignTo;
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

  public Set<WorkflowFileEdo> getFiles() {
    return files;
  }

  @JsonSetter
  public void setFiles(final List<WorkflowFileEdo> files) {
    final Set<WorkflowFileEdo> fileSet = files != null ? files.stream().collect(Collectors.toSet()) : new HashSet<>();
    setFiles(fileSet);
  }

  public void setFiles(final Set<WorkflowFileEdo> files) {
    this.files = new HashSet<>();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  public Set<WorkflowActionEdo> getActions() {
    return actions;
  }

  @JsonSetter
  public void setActions(final List<WorkflowActionEdo> actions) {
    final Set<WorkflowActionEdo> actionSet = actions != null ? actions.stream().collect(Collectors.toSet()) : new HashSet<>();
    setActions(actionSet);
  }

  public void setActions(final Set<WorkflowActionEdo> actions) {
    this.actions = new HashSet<>();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }

}

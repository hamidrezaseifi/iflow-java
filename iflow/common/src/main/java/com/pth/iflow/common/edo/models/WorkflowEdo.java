package com.pth.iflow.common.edo.models;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "Workflow", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "Workflow" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowEdo {

  @NotNull(message = "Identity is not allowed to be null!")
  @XmlElement(name = "Identity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String identity;

  @NotNull(message = "WorkflowTypeId is not allowed to be null!")
  @XmlElement(name = "WorkflowTypeId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long workflowTypeId;

  @XmlElement(name = "CurrentStepId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long currentStepId;

  @XmlElement(name = "Controller", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long controller;

  @XmlElement(name = "CreatedBy", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long createdBy;

  @XmlElement(name = "Comments", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String comments;

  @NotNull(message = "Status is not allowed to be null!")
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer status;

  @NotNull(message = "Version is not allowed to be null!")
  @XmlElement(name = "Version", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer version;

  @NotNull(message = "WorkflowFileEdo is not allowed to be null!")
  @XmlElementWrapper(name = "WorkflowFileList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "WorkflowFile", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private List<WorkflowFileEdo> files = new ArrayList<>();

  @NotNull(message = "WorkflowActionList is not allowed to be null!")
  @XmlElementWrapper(name = "WorkflowActionList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "WorkflowAction", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private List<WorkflowActionEdo> actions = new ArrayList<>();

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

  @JsonSetter
  public void setFiles(final List<WorkflowFileEdo> files) {
    this.files = new ArrayList<>();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  public List<WorkflowActionEdo> getActions() {
    return this.actions;
  }

  @JsonSetter
  public void setActions(final List<WorkflowActionEdo> actions) {
    this.actions = new ArrayList<>();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }

}

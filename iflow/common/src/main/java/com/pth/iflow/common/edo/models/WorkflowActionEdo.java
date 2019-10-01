package com.pth.iflow.common.edo.models;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;
import com.pth.iflow.common.enums.EWorkflowActionStatus;

@XmlRootElement(name = "WorkflowAction", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowAction" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowActionEdo {

  @XmlElement(name = "ID", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long    id;

  @NotNull
  @XmlElement(name = "WorkflowId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long    workflowId;

  @XmlElement(name = "CreatedBy", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long    createdBy;

  @NotNull
  @XmlElement(name = "Action", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String  action;

  @XmlElement(name = "AssignTo", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long    assignTo;

  @XmlElement(name = "OldStep", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long    oldStep;

  @XmlElement(name = "NewStep", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long    newStep;

  @XmlElement(name = "NextAssign", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long    nextAssign;

  @XmlElement(name = "Comments", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String  comments;

  @NotNull
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer status;

  @NotNull
  @XmlElement(name = "Version", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer version;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowId() {
    return this.workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public String getAction() {
    return this.action;
  }

  public void setAction(final String action) {
    this.action = action;
  }

  public Long getOldStep() {
    return this.oldStep;
  }

  public void setOldStep(final Long oldStep) {
    this.oldStep = oldStep;
  }

  public Long getNewStep() {
    return this.newStep;
  }

  public void setNewStep(final Long newStep) {
    this.newStep = newStep;
  }

  public Long getNextAssign() {
    return this.nextAssign;
  }

  public void setNextAssign(final Long nextAssign) {
    this.nextAssign = nextAssign;
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

  public boolean getIsActive() {
    return EWorkflowActionStatus.getIsActive(this.status);
  }

}

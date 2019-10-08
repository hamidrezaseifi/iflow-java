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

  @XmlElement(name = "AssignTo", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long assignTo;

  @NotNull(message = "CurrectStepId must not be null")
  @XmlElement(name = "CurrectStepId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long currectStepId;

  @XmlElement(name = "Comments", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String comments;

  @NotNull(message = "Status must not be null")
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer status;

  @NotNull(message = "Version must not be null")
  @XmlElement(name = "Version", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer version;

  public Long getCurrentStepId() {
    return this.currectStepId;
  }

  public void setCurrentStepId(final Long currectStepId) {
    this.currectStepId = currectStepId;
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

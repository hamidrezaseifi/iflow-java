package com.pth.iflow.common.edo.models.workflow.results;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "WorkflowResult", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowResult" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowResultEdo {

  @NotNull(message = "Identity is not allowed to be null!")
  @XmlElement(name = "Identity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String  identity;

  @NotNull(message = "WorkflowTypeIdentity is not allowed to be null!")
  @XmlElement(name = "WorkflowTypeIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String  workflowTypeIdentity;

  @XmlElement(name = "CurrentStepIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String  currentStepIdentity;

  @XmlElement(name = "ControllerIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String  controllerIdentity;

  @XmlElement(name = "CreatedByIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String  createdByIdentity;

  @NotNull(message = "Status is not allowed to be null!")
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer status;

  public WorkflowResultEdo() {

  }

  public String getIdentity() {
    return this.identity;
  }

  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public String getWorkflowTypeIdentity() {
    return this.workflowTypeIdentity;
  }

  public void setWorkflowTypeIdentity(final String workflowTypeIdentity) {
    this.workflowTypeIdentity = workflowTypeIdentity;
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

  public String getCreatedByIdentity() {
    return this.createdByIdentity;
  }

  public void setCreatedByIdentity(final String createdByIdentity) {
    this.createdByIdentity = createdByIdentity;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(final Integer status) {
    this.status = status;
  }

}

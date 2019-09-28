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

@XmlRootElement(name = "WorkflowCreateRequest", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowCreateRequest" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowCreateRequestEdo {

  @NotNull(message = "Workflow must not be null")
  @XmlElement(name = "Workflow", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private WorkflowEdo         workflow;

  @NotNull(message = "ExpireDays must not be null")
  @XmlElement(name = "ExpireDays", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer             expireDays;

  @NotNull(message = "AssignedList must not be null")
  @XmlElementWrapper(name = "AssignedList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "AssignedList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private List<AssignItemEdo> assigns = new ArrayList<>();

  public WorkflowCreateRequestEdo() {

  }

  /**
   * @return the workflow
   */
  public WorkflowEdo getWorkflow() {
    return this.workflow;
  }

  /**
   * @param workflow the workflow to set
   */
  public void setWorkflow(final WorkflowEdo workflow) {
    this.workflow = workflow;
  }

  public Integer getExpireDays() {
    return this.expireDays;
  }

  public void setExpireDays(final Integer expireDays) {
    this.expireDays = expireDays;
  }

  public List<AssignItemEdo> getAssigns() {
    return this.assigns;
  }

  /**
   * @param assignedUsers the assignedUsers to set
   */
  @JsonSetter
  public void setAssigns(final List<AssignItemEdo> assigns) {
    this.assigns = new ArrayList<>();
    if (assigns != null) {
      this.assigns.addAll(assigns);
    }
  }

}

package com.pth.iflow.common.edo.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "WorkflowList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowListEdo {

  @NotNull
  @XmlElementWrapper(name = "WorkflowList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "Workflow", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final Set<WorkflowEdo> workflows = new HashSet<>();

  public WorkflowListEdo() {

  }

  public WorkflowListEdo(final Set<WorkflowEdo> workflows) {
    this.setWorkflows(workflows);
  }

  public Set<WorkflowEdo> getWorkflows() {
    return this.workflows;
  }

  @JsonSetter
  public void setWorkflows(final Set<WorkflowEdo> workflows) {
    this.workflows.clear();
    if (workflows != null) {
      this.workflows.addAll(workflows);
    }
  }

}

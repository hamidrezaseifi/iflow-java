package com.pth.iflow.common.edo.models.workflow.results;

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

@XmlRootElement(name = "WorkflowResultList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowResultList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowResultListEdo {

  @NotNull
  @XmlElementWrapper(name = "WorkflowResultList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "WorkflowResult", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<WorkflowResultEdo> workflows = new ArrayList<>();

  public WorkflowResultListEdo() {

  }

  public WorkflowResultListEdo(final List<WorkflowResultEdo> workflows) {
    this.setWorkflows(workflows);
  }

  public List<WorkflowResultEdo> getWorkflows() {
    return this.workflows;
  }

  @JsonSetter
  public void setWorkflows(final List<WorkflowResultEdo> workflows) {
    this.workflows.clear();
    if (workflows != null) {
      this.workflows.addAll(workflows);
    }
  }

}

package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "WorkflowTypeStepList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowTypeStepList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowTypeStepListEdo {

  @XmlElementWrapper(name = "WorkflowTypeStepList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "WorkflowTypeStepEdo", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<WorkflowTypeStepEdo> workflowTypeSteps = new ArrayList<>();

  public WorkflowTypeStepListEdo() {

  }

  public WorkflowTypeStepListEdo(final List<WorkflowTypeStepEdo> workflowTypes) {
    this.setWorkflowTypeSteps(workflowTypes);
  }

  public List<WorkflowTypeStepEdo> getWorkflowTypeSteps() {
    return this.workflowTypeSteps;
  }

  public void setWorkflowTypeSteps(final List<WorkflowTypeStepEdo> workflowTypeSteps) {
    this.workflowTypeSteps.clear();
    if (workflowTypeSteps != null) {
      this.workflowTypeSteps.addAll(workflowTypeSteps);
    }
  }

}

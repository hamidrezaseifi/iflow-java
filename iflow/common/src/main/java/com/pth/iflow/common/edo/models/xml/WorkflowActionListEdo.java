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

@XmlRootElement(name = "WorkflowActionList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowActionList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowActionListEdo {

  @XmlElementWrapper(name = "WorkflowActionList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "WorkflowAction", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<WorkflowActionEdo> workflowActions = new ArrayList<>();

  public WorkflowActionListEdo() {

  }

  public WorkflowActionListEdo(final List<WorkflowActionEdo> workflowActions) {
    this.setWorkflowActions(workflowActions);
  }

  public List<WorkflowActionEdo> getWorkflowActions() {
    return this.workflowActions;
  }

  public void setWorkflowActions(final List<WorkflowActionEdo> workflowActions) {
    this.workflowActions.clear();
    if (workflowActions != null) {
      this.workflowActions.addAll(workflowActions);
    }
  }

}
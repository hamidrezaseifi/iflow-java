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

@XmlRootElement(name = "WorkflowMessageList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowMessageList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowMessageListEdo {

  @NotNull
  @XmlElementWrapper(name = "WorkflowMessageList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "WorkflowMessage", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final Set<WorkflowMessageEdo> workflowMessages = new HashSet<>();

  public WorkflowMessageListEdo() {

  }

  public WorkflowMessageListEdo(final Set<WorkflowMessageEdo> workflowMessages) {
    this.setWorkflowMessages(workflowMessages);
  }

  public Set<WorkflowMessageEdo> getWorkflowMessages() {
    return this.workflowMessages;
  }

  @JsonSetter
  public void setWorkflowMessages(final Set<WorkflowMessageEdo> workflowMessages) {
    this.workflowMessages.clear();
    if (workflowMessages != null) {
      this.workflowMessages.addAll(workflowMessages);
    }
  }

}

package com.pth.iflow.common.edo.models.workflow.testthreetask;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;
import com.pth.iflow.common.edo.models.workflow.WorkflowEdo;
import com.pth.iflow.common.enums.EWorkflowType;

@XmlRootElement(name = "TestThreeTaskWorkflow", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "TestThreeTaskWorkflow" + IFlowJaxbDefinition.TYPE_PREFIX)
public class TestThreeTaskWorkflowEdo {

  @NotNull(message = "Workflow is not allowed to be null!")
  @XmlElement(name = "Workflow", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private WorkflowEdo workflow;

  public WorkflowEdo getWorkflow() {
    return this.workflow;
  }

  public void setWorkflow(final WorkflowEdo workflow) {
    workflow.setWorkflowTypeIdentity(EWorkflowType.TESTTHREE_TASK_WORKFLOW_TYPE.getIdentity());
    this.workflow = workflow;
  }

}

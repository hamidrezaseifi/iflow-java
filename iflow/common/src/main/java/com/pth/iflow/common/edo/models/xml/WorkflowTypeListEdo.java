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

@XmlRootElement(name = "WorkflowTypeList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowTypeList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowTypeListEdo {

  @XmlElementWrapper(name = "WorkflowTypeList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "WorkflowTypeEdo", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<WorkflowTypeEdo> workflowTypes = new ArrayList<>();

  public WorkflowTypeListEdo() {

  }

  public WorkflowTypeListEdo(final List<WorkflowTypeEdo> workflowTypes) {
    this.setWorkflowTypes(workflowTypes);
  }

  public List<WorkflowTypeEdo> getWorkflowTypes() {
    return this.workflowTypes;
  }

  public void setWorkflowTypes(final List<WorkflowTypeEdo> workflowTypes) {
    this.workflowTypes.clear();
    if (workflowTypes != null) {
      this.workflowTypes.addAll(workflowTypes);
    }
  }

}

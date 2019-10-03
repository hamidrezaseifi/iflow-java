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

@XmlRootElement(name = "WorkflowSearchFilter", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowSearchFilter" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowSearchFilterEdo {

  @NotNull(message = "AssignedUserId must not be null")
  @XmlElementWrapper(name = "AssignedUserIdList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "AssignedUserId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private List<Long>    assignedUserIdList  = new ArrayList<>();

  @NotNull(message = "StatusList must not be null")
  @XmlElementWrapper(name = "StatusList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private List<Integer> statusList          = new ArrayList<>();

  @NotNull(message = "WorkflowTypeIdList must not be null")
  @XmlElementWrapper(name = "WorkflowTypeIdList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "WorkflowTypeId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private List<Long>    workflowTypeIdList  = new ArrayList<>();

  @NotNull(message = "WorkflowStepIdList must not be null")
  @XmlElementWrapper(name = "WorkflowStepIdList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "WorkflowStepId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private List<Long>    workflowStepeIdList = new ArrayList<>();

  public List<Long> getAssignedUserIdList() {
    return this.assignedUserIdList;
  }

  @JsonSetter
  public void setAssignedUserIdList(final List<Long> assignedUserIdList) {
    this.assignedUserIdList = new ArrayList<>();
    if (assignedUserIdList != null) {
      this.assignedUserIdList.addAll(assignedUserIdList);
    }
  }

  public List<Integer> getStatusList() {
    return this.statusList;
  }

  @JsonSetter
  public void setStatusList(final List<Integer> statusList) {
    this.statusList = new ArrayList<>();
    if (statusList != null) {
      this.statusList.addAll(statusList);
    }
  }

  public List<Long> getWorkflowTypeIdList() {
    return this.workflowTypeIdList;
  }

  @JsonSetter
  public void setWorkflowTypeIdList(final List<Long> workflowTypeIdList) {
    this.workflowTypeIdList = new ArrayList<>();
    if (workflowTypeIdList != null) {
      this.workflowTypeIdList.addAll(workflowTypeIdList);
    }
  }

  public List<Long> getWorkflowStepeIdList() {
    return this.workflowStepeIdList;
  }

  @JsonSetter
  public void setWorkflowStepeIdList(final List<Long> workflowStepeIdList) {
    this.workflowStepeIdList = new ArrayList<>();
    if (workflowStepeIdList != null) {
      this.workflowStepeIdList.addAll(workflowStepeIdList);
    }
  }

}

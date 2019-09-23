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

  @NotNull
  @XmlElement(name = "Workflow", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private WorkflowEdo workflow;

  @NotNull
  @XmlElementWrapper(name = "AssignedUserIdList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "AssignedUserId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private List<Long>  assignedUsers = new ArrayList<>();

  public WorkflowCreateRequestEdo() {

  }

  public WorkflowCreateRequestEdo(final WorkflowEdo workflow, final List<Long> assignedUsers) {
    this.setWorkflow(workflow);
    this.setAssignedUsers(assignedUsers);
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

  /**
   * @return the assignedUsers
   */
  public List<Long> getAssignedUsers() {
    return this.assignedUsers;
  }

  /**
   * @param assignedUsers the assignedUsers to set
   */
  @JsonSetter
  public void setAssignedUsers(final List<Long> assignedUsers) {
    this.assignedUsers = new ArrayList<>();
    if (assignedUsers != null) {
      this.assignedUsers.addAll(assignedUsers);
    }
  }

}

package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkflowActionListEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkflowActionListEdo {

  @XmlElementWrapper(name = "WorkflowActionList")
  @XmlElement(name = "WorkflowActionEdo")
  private final List<WorkflowActionEdo> workflowActions = new ArrayList<>();

  public WorkflowActionListEdo() {

  }

  public WorkflowActionListEdo(final List<WorkflowActionEdo> workflowActions) {
    setWorkflowActions(workflowActions);
  }

  public List<WorkflowActionEdo> getWorkflowActions() {
    return workflowActions;
  }

  public void setWorkflowActions(final List<WorkflowActionEdo> workflowActions) {
    this.workflowActions.clear();
    if (workflowActions != null) {
      this.workflowActions.addAll(workflowActions);
    }
  }

}

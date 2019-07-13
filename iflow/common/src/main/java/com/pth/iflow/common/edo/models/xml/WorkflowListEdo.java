package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkflowListEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkflowListEdo {

  @XmlElementWrapper(name = "WorkflowList")
  @XmlElement(name = "WorkflowEdo")
  private final List<WorkflowEdo> workflows = new ArrayList<>();

  public WorkflowListEdo() {

  }

  public WorkflowListEdo(final List<WorkflowEdo> workflows) {
    setWorkflows(workflows);
  }

  public List<WorkflowEdo> getWorkflows() {
    return workflows;
  }

  public void setWorkflows(final List<WorkflowEdo> workflows) {
    this.workflows.clear();
    if (workflows != null) {
      this.workflows.addAll(workflows);
    }
  }

}

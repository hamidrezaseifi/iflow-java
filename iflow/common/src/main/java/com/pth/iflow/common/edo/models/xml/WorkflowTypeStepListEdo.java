package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkflowTypeStepListEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkflowTypeStepListEdo {

  @XmlElementWrapper(name = "WorkflowTypeStepList")
  @XmlElement(name = "WorkflowTypeStepEdo")
  private final List<WorkflowTypeStepEdo> workflowTypeSteps = new ArrayList<>();

  public WorkflowTypeStepListEdo() {

  }

  public WorkflowTypeStepListEdo(final List<WorkflowTypeStepEdo> workflowTypes) {
    setWorkflowTypeSteps(workflowTypes);
  }

  public List<WorkflowTypeStepEdo> getWorkflowTypeSteps() {
    return workflowTypeSteps;
  }

  public void setWorkflowTypeSteps(final List<WorkflowTypeStepEdo> workflowTypeSteps) {
    this.workflowTypeSteps.clear();
    if (workflowTypeSteps != null) {
      this.workflowTypeSteps.addAll(workflowTypeSteps);
    }
  }

}

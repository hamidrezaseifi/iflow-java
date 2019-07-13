package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkflowTypeListEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkflowTypeListEdo {

  @XmlElementWrapper(name = "WorkflowTypeList")
  @XmlElement(name = "WorkflowTypeEdo")
  private final List<WorkflowTypeEdo> workflowTypes = new ArrayList<>();

  public WorkflowTypeListEdo() {

  }

  public WorkflowTypeListEdo(final List<WorkflowTypeEdo> workflowTypes) {
    setWorkflowTypes(workflowTypes);
  }

  public List<WorkflowTypeEdo> getWorkflowTypes() {
    return workflowTypes;
  }

  public void setWorkflowTypes(final List<WorkflowTypeEdo> workflowTypes) {
    this.workflowTypes.clear();
    if (workflowTypes != null) {
      this.workflowTypes.addAll(workflowTypes);
    }
  }

}

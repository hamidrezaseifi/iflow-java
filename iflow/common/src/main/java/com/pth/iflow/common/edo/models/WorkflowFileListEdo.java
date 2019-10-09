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

@XmlRootElement(name = "WorkflowFileList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowFileList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowFileListEdo {

  @NotNull
  @XmlElementWrapper(name = "WorkflowFileList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "WorkflowFile", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final Set<WorkflowFileEdo> workflowFiles = new HashSet<>();

  public WorkflowFileListEdo() {

  }

  public WorkflowFileListEdo(final Set<WorkflowFileEdo> workflowFiles) {
    this.setWorkflowFiles(workflowFiles);
  }

  public Set<WorkflowFileEdo> getWorkflowFiles() {
    return this.workflowFiles;
  }

  @JsonSetter
  public void setWorkflowFiles(final Set<WorkflowFileEdo> workflowFiles) {
    this.workflowFiles.clear();
    if (workflowFiles != null) {
      this.workflowFiles.addAll(workflowFiles);
    }
  }

}

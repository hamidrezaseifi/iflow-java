package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkflowFileListEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkflowFileListEdo {

  @XmlElementWrapper(name = "WorkflowFileList")
  @XmlElement(name = "WorkflowFileEdo")
  private final List<WorkflowFileEdo> workflowFiles = new ArrayList<>();

  public WorkflowFileListEdo() {

  }

  public WorkflowFileListEdo(final List<WorkflowFileEdo> workflowFiles) {
    setWorkflowFiles(workflowFiles);
  }

  public List<WorkflowFileEdo> getWorkflowFiles() {
    return workflowFiles;
  }

  public void setWorkflowFiles(final List<WorkflowFileEdo> workflowFiles) {
    this.workflowFiles.clear();
    if (workflowFiles != null) {
      this.workflowFiles.addAll(workflowFiles);
    }
  }

}

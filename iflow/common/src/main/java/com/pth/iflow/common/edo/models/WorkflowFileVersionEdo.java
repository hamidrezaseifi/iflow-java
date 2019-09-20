package com.pth.iflow.common.edo.models;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "WorkflowFileVersion", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowFileVersion" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowFileVersionEdo {

  @XmlElement(name = "ID", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long    id;

  @NotNull
  @XmlElement(name = "WorkflowFileId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long    workflowFileId;

  @XmlElement(name = "CreatedBy", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long    createdBy;

  @NotNull
  @XmlElement(name = "FilePath", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String  filePath;

  @XmlElement(name = "Comments", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String  comments;

  @NotNull
  @XmlElement(name = "FileVersion", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer fileVersion;

  @NotNull
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer status;

  @NotNull
  @XmlElement(name = "Version", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer version;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowFileId() {
    return this.workflowFileId;
  }

  public void setWorkflowFileId(final Long workflowFileId) {
    this.workflowFileId = workflowFileId;
  }

  public String getFilePath() {
    return this.filePath;
  }

  public void setFilePath(final String filePath) {
    this.filePath = filePath;
  }

  public Long getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public Integer getFileVersion() {
    return this.fileVersion;
  }

  public void setFileVersion(final Integer fileVersion) {
    this.fileVersion = fileVersion;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(final Integer status) {
    this.status = status;
  }

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

}

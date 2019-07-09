package com.pth.iflow.common.edo.models;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkflowFileVersionEdo")
public class WorkflowFileVersionEdo {

  @XmlElement(name = "ID")
  private Long    id;

  @NotNull
  @XmlElement(name = "ID")
  private Long    workflowFileId;

  @XmlElement(name = "ID")
  private Long    createdBy;

  @NotNull
  @XmlElement(name = "ID")
  private String  filePath;

  @XmlElement(name = "ID")
  private String  comments;

  @NotNull
  @XmlElement(name = "ID")
  private Integer fileVersion;

  @NotNull
  @XmlElement(name = "ID")
  private Integer status;

  @NotNull
  @XmlElement(name = "ID")
  private Integer version;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowFileId() {
    return workflowFileId;
  }

  public void setWorkflowFileId(final Long workflowFileId) {
    this.workflowFileId = workflowFileId;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(final String filePath) {
    this.filePath = filePath;
  }

  public Long getCreatedBy() {
    return createdBy;
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
    return fileVersion;
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

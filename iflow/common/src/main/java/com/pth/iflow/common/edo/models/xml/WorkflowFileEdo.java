package com.pth.iflow.common.edo.models.xml;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkflowFileEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkflowFileEdo {

  @XmlElement(name = "ID")
  private Long id;

  @NotNull
  @XmlElement(name = "WorkflowId")
  private Long workflowId;

  @XmlElement(name = "CreatedBy")
  private Long createdBy;

  @NotNull
  @XmlElement(name = "Title")
  private String title;

  @XmlElement(name = "ActiveFilePath")
  private String activeFilePath;

  @XmlElement(name = "ActiveFileVersion")
  private Integer activeFileVersion;

  @XmlElement(name = "Comments")
  private String comments;

  @NotNull
  @XmlElement(name = "Status")
  private Integer status;

  @NotNull
  @XmlElement(name = "Version")
  private Integer version;

  @XmlElementWrapper(name = "FileVersionList")
  @XmlElement(name = "FileVersion")
  private List<WorkflowFileVersionEdo> fileVersions = new ArrayList<>();

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowId() {
    return this.workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public String getActiveFilePath() {
    return this.activeFilePath;
  }

  public void setActiveFilePath(final String filePath) {
    this.activeFilePath = filePath;
  }

  public Long getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public Integer getActiveFileVersion() {
    return this.activeFileVersion;
  }

  public void setActiveFileVersion(final Integer fileVersion) {
    this.activeFileVersion = fileVersion;
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

  public List<WorkflowFileVersionEdo> getFileVersions() {
    return this.fileVersions;
  }

  public void setFileVersions(final List<WorkflowFileVersionEdo> fileVersions) {
    this.fileVersions = new ArrayList<>();
    if (fileVersions != null) {
      this.fileVersions.addAll(fileVersions);
    }
  }

}

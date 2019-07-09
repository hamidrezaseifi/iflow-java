package com.pth.iflow.common.edo.models.json;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.pth.iflow.common.edo.models.xml.WorkflowFileVersionEdo;

public class WorkflowFileJsonEdo {

  private Long                        id;

  @NotNull
  private Long                        workflowId;

  private Long                        createdBy;

  @NotNull
  private String                      title;

  private String                      activeFilePath;

  private Integer                     activeFileVersion;

  private String                      comments;

  @NotNull
  private Integer                     status;

  @NotNull
  private Integer                     version;

  private Set<WorkflowFileVersionEdo> fileVersions = new HashSet<>();

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowId() {
    return workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public String getActiveFilePath() {
    return activeFilePath;
  }

  public void setActiveFilePath(final String filePath) {
    this.activeFilePath = filePath;
  }

  public Long getCreatedBy() {
    return createdBy;
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
    return activeFileVersion;
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

  public Set<WorkflowFileVersionEdo> getFileVersions() {
    return fileVersions;
  }

  public void setFileVersionsList(final List<WorkflowFileVersionEdo> fileVersions) {
    final Set<WorkflowFileVersionEdo> fileVersionSet = fileVersions != null ? fileVersions.stream().collect(Collectors.toSet())
        : new HashSet<>();
    setFileVersions(fileVersionSet);
  }

  public void setFileVersions(final Set<WorkflowFileVersionEdo> fileVersions) {
    this.fileVersions = new HashSet<>();
    if (fileVersions != null) {
      this.fileVersions.addAll(fileVersions);
    }
  }

}

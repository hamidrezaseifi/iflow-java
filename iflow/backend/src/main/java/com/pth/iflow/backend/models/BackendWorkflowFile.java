package com.pth.iflow.backend.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.base.DataModelBase;

public class BackendWorkflowFile extends DataModelBase<WorkflowFileEdo, BackendWorkflowFile> {

  private Long                                   id;
  private Long                                   workflowId;
  private Long                                   createdBy;
  private String                                 title;
  private String                                 extention;
  private String                                 activeFilePath;
  private String                                 comments;
  private Integer                                activeFileVersion;
  private Integer                                status;
  private Integer                                version;
  private final List<BackendWorkflowFileVersion> fileVersions = new ArrayList<>();

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

  public String getExtention() {
    return this.extention;
  }

  public void setExtention(final String extention) {
    this.extention = extention;
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

  public List<BackendWorkflowFileVersion> getFileVersions() {
    return this.fileVersions;
  }

  public void setFileVersions(final List<BackendWorkflowFileVersion> fileVersions) {
    this.fileVersions.clear();
    if (fileVersions != null) {
      this.fileVersions.addAll(fileVersions);
    }
  }

}

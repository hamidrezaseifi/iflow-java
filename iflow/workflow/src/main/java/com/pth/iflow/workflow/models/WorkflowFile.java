package com.pth.iflow.workflow.models;

import java.util.ArrayList;
import java.util.List;

public class WorkflowFile {

  private String                          createdByIdentity;
  private String                          title;
  private String                          extention;
  private String                          activeFilePath;
  private String                          comments;
  private Integer                         activeFileVersion;
  private Integer                         status;
  private final List<WorkflowFileVersion> fileVersions = new ArrayList<>();

  public String getCreatedByIdentity() {
    return createdByIdentity;
  }

  public void setCreatedByIdentity(final String createdByIdentity) {
    this.createdByIdentity = createdByIdentity;
  }

  public String getActiveFilePath() {
    return this.activeFilePath;
  }

  public void setActiveFilePath(final String filePath) {
    this.activeFilePath = filePath;
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

  public List<WorkflowFileVersion> getFileVersions() {
    return this.fileVersions;
  }

  public void setFileVersions(final List<WorkflowFileVersion> fileVersions) {
    this.fileVersions.clear();
    if (fileVersions != null) {
      this.fileVersions.addAll(fileVersions);
    }
  }

}

package com.pth.iflow.gui.models;

public class WorkflowFileVersion {

  private User    createdBy;
  private String  createdByIdentity;
  private String  filePath;
  private String  comments;
  private Integer fileVersion;
  private Integer status;

  public String getFilePath() {
    return this.filePath;
  }

  public void setFilePath(final String filePath) {
    this.filePath = filePath;
  }

  public User getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final User createdBy) {
    this.createdBy = createdBy;
  }

  public String getCreatedByIdentity() {
    return this.createdByIdentity;
  }

  public void setCreatedByIdentity(final String createdByIdentity) {
    this.createdByIdentity = createdByIdentity;
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

}

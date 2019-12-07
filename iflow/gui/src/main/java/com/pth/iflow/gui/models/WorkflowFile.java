package com.pth.iflow.gui.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.helper.IdentityModel;

public class WorkflowFile extends IdentityModel {

  private String                          identity;
  private String                          workflowIdentity;
  private String                          createdByIdentity;
  private String                          title;
  private String                          extention;
  private String                          activeFilePath;
  private String                          comments;
  private Integer                         activeFileVersion;
  private Integer                         status;
  private final List<WorkflowFileVersion> fileVersions = new ArrayList<>();

  public String getIdentity() {
    return this.identity;
  }

  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public String getWorkflowIdentity() {
    return this.workflowIdentity;
  }

  public void setWorkflowIdentity(final String workflowIdentity) {
    this.workflowIdentity = workflowIdentity;
  }

  public String getCreatedByIdentity() {
    return this.createdByIdentity;
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

  public void addFileVersion(final WorkflowFileVersion fileVersion) {
    this.fileVersions.add(fileVersion);

  }

  public WorkflowFileVersion addNewFileVersion(final String filePath, final int version, final String userId, final String comments) {
    final WorkflowFileVersion fileVersion = new WorkflowFileVersion();
    fileVersion.setComments(comments);
    fileVersion.setCreatedByIdentity(userId);
    fileVersion.setFilePath(filePath);
    fileVersion.setFileVersion(version);
    fileVersion.setStatus(1);

    this.fileVersions.add(fileVersion);

    return fileVersion;
  }

}

package com.pth.iflow.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.pth.iflow.core.model.helper.CoreModelHelper;
import com.pth.iflow.core.model.helper.ICoreIdentityModel;

public class WorkflowFile extends CoreModelHelper implements ICoreIdentityModel {

  private Long                            id;
  private String                          identity;
  private Long                            workflowId;
  private Long                            createdBy;
  private String                          title;
  private String                          extention;
  private String                          activeFilePath;
  private String                          comments;
  private Integer                         activeFileVersion;
  private Integer                         status;
  private Integer                         version;
  private LocalDateTime                   createdAt;
  private LocalDateTime                   updatedAt;
  private final List<WorkflowFileVersion> fileVersions = new ArrayList<>();

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(final Long id) {
    this.id = id;
  }

  @Override
  public String getIdentity() {
    return identity;
  }

  @Override
  public void setIdentity(final String identity) {
    this.identity = identity;
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

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
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

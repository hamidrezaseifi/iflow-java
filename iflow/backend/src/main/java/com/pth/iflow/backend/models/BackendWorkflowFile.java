package com.pth.iflow.backend.models;

import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.WorkflowFileEdo;

public class BackendWorkflowFile extends ModelMapperBase<WorkflowFileEdo, BackendWorkflowFile> {

  private Long                            id;
  private Long                            workflowId;
  private Long                            createdBy;
  private String                          title;
  private String                          activeFilePath;
  private String                          comments;
  private Integer                         activeFileVersion;
  private Integer                         status;
  private Integer                         version;
  private final List<BackendWorkflowFileVersion> fileVersions = new ArrayList<>();

  @Override
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

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
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

  @Override
  public WorkflowFileEdo toEdo() {
    final WorkflowFileEdo edo = new WorkflowFileEdo();
    edo.setTitle(this.title);
    edo.setComments(this.comments);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setCreatedBy(this.createdBy);
    edo.setActiveFilePath(this.activeFilePath);
    edo.setActiveFileVersion(this.activeFileVersion);
    edo.setWorkflowId(this.workflowId);
    edo.setVersion(this.version);

    edo.setFileVersions(BackendWorkflowFileVersion.toEdoList(this.fileVersions));

    return edo;
  }

  @Override
  public BackendWorkflowFile fromEdo(final WorkflowFileEdo edo) {
    if (edo == null) {
      return null;
    }
    
    final BackendWorkflowFile model = new BackendWorkflowFile();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCreatedBy(edo.getCreatedBy());
    model.setActiveFilePath(edo.getActiveFilePath());
    model.setActiveFileVersion(edo.getActiveFileVersion());
    model.setWorkflowId(edo.getWorkflowId());
    model.setVersion(edo.getVersion());

    model.setFileVersions(new BackendWorkflowFileVersion().fromEdoList(edo.getFileVersions()));

    return model;
  }

}

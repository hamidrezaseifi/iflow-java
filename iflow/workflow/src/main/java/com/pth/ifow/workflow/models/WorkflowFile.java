package com.pth.ifow.workflow.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.common.edo.models.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;

public class WorkflowFile extends ModelMapperBase<WorkflowFileEdo, WorkflowFile> {

  private Long id;
  private Long workflowId;
  private Long createdBy;
  private String title;
  private String activeFilePath;
  private String comments;
  private Integer activeFileVersion;
  private Integer status;
  private Integer version;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private Set<WorkflowFileVersion> fileVersions = new HashSet<>();

  @Override
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

  public Set<WorkflowFileVersion> getFileVersions() {
    return fileVersions;
  }

  public void setFileVersions(final List<WorkflowFileVersion> fileVersions) {
    setFileVersions(fileVersions.stream().collect(Collectors.toSet()));
  }

  public void setFileVersions(final Set<WorkflowFileVersion> fileVersions) {
    this.fileVersions = new HashSet<>();
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
    edo.setCreatedBy(createdBy);
    edo.setActiveFilePath(activeFilePath);
    edo.setActiveFileVersion(activeFileVersion);
    edo.setWorkflowId(workflowId);
    edo.setVersion(version);

    edo.setFileVersionsList(ModelMapperBase.toEdoList(fileVersions));

    return edo;
  }

  @Override
  public WorkflowFile fromEdo(final WorkflowFileEdo edo) {
    final WorkflowFile model = new WorkflowFile();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCreatedBy(edo.getCreatedBy());
    model.setActiveFilePath(edo.getActiveFilePath());
    model.setActiveFileVersion(edo.getActiveFileVersion());
    model.setWorkflowId(edo.getWorkflowId());
    model.setVersion(edo.getVersion());

    model.setFileVersions(new WorkflowFileVersion().fromEdoList(edo.getFileVersions()));

    return model;
  }

}

package com.pth.ifow.workflow.models;

import java.time.LocalDateTime;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.json.WorkflowFileVersionJsonEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowFileVersionEdo;

public class WorkflowFileVersion extends ModelMapperBase<WorkflowFileVersionEdo, WorkflowFileVersionJsonEdo, WorkflowFileVersion> {

  private Long          id;
  private Long          workflowFileId;
  private Long          createdBy;
  private String        filePath;
  private String        comments;
  private Integer       fileVersion;
  private Integer       status;
  private Integer       version;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @Override
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

  @Override
  public WorkflowFileVersionEdo toEdo() {
    final WorkflowFileVersionEdo edo = new WorkflowFileVersionEdo();
    edo.setComments(this.comments);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setCreatedBy(createdBy);
    edo.setFilePath(filePath);
    edo.setFileVersion(fileVersion);
    edo.setWorkflowFileId(workflowFileId);
    edo.setVersion(version);

    return edo;
  }

  @Override
  public WorkflowFileVersion fromEdo(final WorkflowFileVersionEdo edo) {
    final WorkflowFileVersion model = new WorkflowFileVersion();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCreatedBy(edo.getCreatedBy());
    model.setFilePath(edo.getFilePath());
    model.setFileVersion(edo.getFileVersion());
    model.setWorkflowFileId(edo.getWorkflowFileId());
    model.setVersion(edo.getVersion());

    return model;
  }

  @Override
  public WorkflowFileVersionJsonEdo toJsonEdo() {
    final WorkflowFileVersionJsonEdo edo = new WorkflowFileVersionJsonEdo();
    edo.setComments(this.comments);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setCreatedBy(createdBy);
    edo.setFilePath(filePath);
    edo.setFileVersion(fileVersion);
    edo.setWorkflowFileId(workflowFileId);
    edo.setVersion(version);

    return edo;
  }

  @Override
  public WorkflowFileVersion fromJsonEdo(final WorkflowFileVersionJsonEdo edo) {
    final WorkflowFileVersion model = new WorkflowFileVersion();

    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCreatedBy(edo.getCreatedBy());
    model.setFilePath(edo.getFilePath());
    model.setFileVersion(edo.getFileVersion());
    model.setWorkflowFileId(edo.getWorkflowFileId());
    model.setVersion(edo.getVersion());

    return model;
  }

}

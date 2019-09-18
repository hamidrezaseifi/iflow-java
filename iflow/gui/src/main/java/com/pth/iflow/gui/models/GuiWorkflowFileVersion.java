package com.pth.iflow.gui.models;

import com.pth.iflow.common.edo.models.base.DataModelBase;
import com.pth.iflow.common.edo.models.xml.WorkflowFileVersionEdo;

public class GuiWorkflowFileVersion extends DataModelBase<WorkflowFileVersionEdo, GuiWorkflowFileVersion> {

  private Long    id;
  private Long    workflowFileId;
  private Long    createdBy;
  private String  filePath;
  private String  comments;
  private Integer fileVersion;
  private Integer status;
  private Integer version;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowFileId() {
    return this.workflowFileId;
  }

  public void setWorkflowFileId(final Long workflowFileId) {
    this.workflowFileId = workflowFileId;
  }

  public String getFilePath() {
    return this.filePath;
  }

  public void setFilePath(final String filePath) {
    this.filePath = filePath;
  }

  public Long getCreatedBy() {
    return this.createdBy;
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

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

  @Override
  public WorkflowFileVersionEdo toEdo() {
    final WorkflowFileVersionEdo edo = new WorkflowFileVersionEdo();
    edo.setComments(this.comments);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setCreatedBy(this.createdBy);
    edo.setFilePath(this.filePath);
    edo.setFileVersion(this.fileVersion);
    edo.setWorkflowFileId(this.workflowFileId);
    edo.setVersion(this.version);

    return edo;
  }

  @Override
  public GuiWorkflowFileVersion fromEdo(final WorkflowFileVersionEdo edo) {
    if (edo == null) {
      return null;
    }

    final GuiWorkflowFileVersion model = new GuiWorkflowFileVersion();

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

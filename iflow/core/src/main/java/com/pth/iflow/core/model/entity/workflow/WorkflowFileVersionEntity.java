package com.pth.iflow.core.model.entity.workflow;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "workflow_files_versions")
public class WorkflowFileVersionEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "filepath")
  private String filePath;

  @Column(name = "file_version")
  private Integer fileVersion;

  @Column(name = "created_by")
  private Long createdByUserId;

  @Column(name = "comments")
  private String comments;

  @Column(name = "status")
  private Integer status;

  @CreationTimestamp
  @Column(name = "created_at", insertable = false, updatable = false)
  private Date createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", insertable = false, updatable = false)
  private Date updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workflow_file_id", nullable = false)
  private WorkflowFileEntity workflowFileEntity;

  public WorkflowFileVersionEntity() {

  }

  public Long getId() {

    return this.id;
  }

  public void setId(final Long id) {

    this.id = id;
  }

  public String getFilePath() {

    return this.filePath;
  }

  public void setFilePath(final String filePath) {

    this.filePath = filePath;
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

  public Date getCreatedAt() {

    return this.createdAt;
  }

  public void setCreatedAt(final Date createdAt) {

    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {

    return this.updatedAt;
  }

  public void setUpdatedAt(final Date updatedAt) {

    this.updatedAt = updatedAt;
  }

  public Long getCreatedByUserId() {

    return createdByUserId;
  }

  public void setCreatedByUserId(final Long createdByUserId) {

    this.createdByUserId = createdByUserId;
  }

  public WorkflowFileEntity getWorkflowFileEntity() {

    return workflowFileEntity;
  }

  public void setWorkflowFileEntity(final WorkflowFileEntity workflowFileEntity) {

    this.workflowFileEntity = workflowFileEntity;
  }

}

package com.pth.iflow.core.model.entity.workflow;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.helper.EntityIdentityHelper;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@Table(name = "workflow_files_versions")
@EntityListeners(EntityListener.class)
public class WorkflowFileVersionEntity extends EntityIdentityHelper {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long               id;

  // @Column(name = "workflow_file_id")
  // private Long workflowFileId;

  @Column(name = "created_by")
  private Long               createdById;

  @Column(name = "filepath")
  private String             filePath;

  @Column(name = "file_version")
  private Integer            fileVersion;

  @Column(name = "comments")
  private String             comments;

  @Column(name = "status")
  private Integer            status;

  @Column(name = "version")
  private Integer            version;

  @CreationTimestamp
  @Column(name = "created_at")
  private Date               createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date               updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "created_by", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private UserEntity         createdByUser;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workflow_file_id", insertable = false, updatable = false)
  private WorkflowFileEntity workflowFile;

  public WorkflowFileVersionEntity() {
    createdByUser = new UserEntity();

  }

  @Override
  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  /*
   * public Long getWorkflowFileId() { return this.workflowFileId; }
   *
   * public void setWorkflowFileId(final Long workflowFileId) {
   * this.workflowFileId = workflowFileId; }
   */

  public String getFilePath() {
    return this.filePath;
  }

  public void setFilePath(final String filePath) {
    this.filePath = filePath;
  }

  public Long getCreatedById() {
    return createdById;
  }

  public void setCreatedById(final Long createdById) {
    this.createdById = createdById;
  }

  public UserEntity getCreatedByUser() {
    return createdByUser;
  }

  public void setCreatedByUser(final UserEntity createdBy) {
    this.createdByUser = createdBy;
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

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
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

  public void updateFromExists(final WorkflowFileVersionEntity exists) {
    if (exists == null) {
      return;
    }
    this.comments = exists.comments;
    this.createdById = exists.createdById;
    this.filePath = exists.filePath;
    this.fileVersion = exists.fileVersion;
    this.status = exists.status;
    this.version = exists.version;

  }

  @Override
  public String getIdentity() {

    return "";
  }

  @Override
  public void setIdentity(final String identity) {

  }

  @Override
  public String getIdentityPreffix() {
    return "wfv";
  }

  @Override
  public void increaseVersion() {
    version += 1;
    workflowFile.increaseVersion();
  }
}

package com.pth.iflow.core.model.entity.workflow;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.pth.iflow.core.storage.dao.helper.EntityIdentityHelper;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@Table(name = "workflow_files")
@EntityListeners(EntityListener.class)
public class WorkflowFileEntity extends EntityIdentityHelper {

  private static final long serialVersionUID = 8579770798642238402L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "identity")
  private String identity;

  @Column(name = "title")
  private String title;

  @Column(name = "extention")
  private String extention;

  @Column(name = "active_filepath")
  private String activeFilePath;

  @Column(name = "active_version")
  private Integer activeFileVersion;

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

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "workflowFileEntity", fetch = FetchType.EAGER)
  private final List<WorkflowFileVersionEntity> fileVersions = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workflow_id", nullable = false)
  private WorkflowEntity workflowEntity;

  public WorkflowFileEntity() {

  }

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

  public Long getCreatedByUserId() {

    return createdByUserId;
  }

  public void setCreatedByUserId(final Long createdByUserId) {

    this.createdByUserId = createdByUserId;
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

  public List<WorkflowFileVersionEntity> getFileVersions() {

    return this.fileVersions;
  }

  public void setFileVersions(final List<WorkflowFileVersionEntity> fileVersions) {

    this.fileVersions.clear();
    if (fileVersions != null) {
      for (final WorkflowFileVersionEntity fileVer : fileVersions) {
        fileVer.setWorkflowFileEntity(this);
        this.fileVersions.add(fileVer);
      }
    }
  }

  public WorkflowEntity getWorkflowEntity() {

    return workflowEntity;
  }

  public void setWorkflowEntity(final WorkflowEntity workflowEntity) {

    this.workflowEntity = workflowEntity;
  }

  @Override
  public void setVersion(final Integer version) {

  }

  @Override
  public Integer getVersion() {

    return 0;
  }

  @Override
  public void increaseVersion() {

  }

  @Override
  public String getIdentityPreffix() {

    return "wf";
  }

}

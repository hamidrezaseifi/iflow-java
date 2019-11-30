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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.storage.dao.helper.EntityHelper;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@Table(name = "workflow_files")
@EntityListeners(EntityListener.class)
public class WorkflowFileEntity extends EntityHelper {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                                  id;

  @Column(name = "identity")
  private String                                identity;

  // @Column(name = "workflow_id")
  // private Long workflowId;

  @Column(name = "title")
  private String                                title;

  @Column(name = "extention")
  private String                                extention;

  @Column(name = "active_filepath")
  private String                                activeFilePath;

  @Column(name = "active_version")
  private Integer                               activeFileVersion;

  @Column(name = "created_by")
  private Long                                  createdById;

  @Column(name = "comments")
  private String                                comments;

  @Column(name = "status")
  private Integer                               status;

  @Column(name = "version")
  private Integer                               version;

  @Column(name = "created_at", insertable = false, updatable = false)
  private Date                                  createdAt;

  @Column(name = "updated_at", insertable = false, updatable = false)
  private Date                                  updatedAt;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "workflow_file_id", nullable = false)
  private final List<WorkflowFileVersionEntity> fileVersions = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "created_by", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private UserEntity                            createdByUser;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workflow_id", insertable = false, updatable = false)
  private WorkflowEntity                        workflow;

  public WorkflowFileEntity() {
    createdByUser = new UserEntity();
    workflow = new WorkflowEntity();
  }

  @Override
  public Long getId() {
    return this.id;
  }

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

  /*
   * public Long getWorkflowId() { return this.workflowId; }
   *
   * public void setWorkflowId(final Long workflowId) { this.workflowId =
   * workflowId; }
   */

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

  public List<WorkflowFileVersionEntity> getFileVersions() {
    return this.fileVersions;
  }

  public void setFileVersions(final List<WorkflowFileVersionEntity> fileVersions) {
    this.fileVersions.clear();
    if (fileVersions != null) {
      this.fileVersions.addAll(fileVersions);
    }
  }

  public WorkflowEntity getWorkflow() {
    return workflow;
  }

  public void setWorkflow(final WorkflowEntity workflow) {
    this.workflow = workflow;
  }

  @Override
  public String getIdentityPreffix() {
    return "wf";
  }

}

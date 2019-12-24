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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.core.storage.dao.helper.EntityIdentityHelper;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@EntityListeners(EntityListener.class)
@Table(name = "workflow")
public class WorkflowEntity extends EntityIdentityHelper {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                             id;

  @Column(name = "identity")
  private String                           identity;

  @Column(name = "controller")
  private Long                             controllerId;

  @Column(name = "created_by")
  private Long                             createdById;

  @Column(name = "workflow_type_id")
  private Long                             workflowTypeId;

  @Column(name = "current_step")
  private Long                             currentStepId;

  @Column(name = "comments")
  private String                           comments;

  @Column(name = "status")
  private Integer                          status;

  @Column(name = "version")
  private Integer                          version;

  @CreationTimestamp
  @Column(name = "created_at", insertable = false, updatable = false)
  private Date                             createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", insertable = false, updatable = false)
  private Date                             updatedAt;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "workflowEntity", fetch = FetchType.EAGER)
  // @JoinColumn(name = "workflow_id")
  @Fetch(value = FetchMode.SUBSELECT)
  private final List<WorkflowFileEntity>   files   = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "workflowEntity", fetch = FetchType.EAGER)
  // @JoinColumn(name = "workflow_id")
  @Fetch(value = FetchMode.SUBSELECT)
  private final List<WorkflowActionEntity> actions = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workflow_type_id", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private WorkflowTypeEntity               workflowType;

  public WorkflowEntity() {

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

  public boolean isIdentityNotSet() {
    return EIdentity.NOT_SET.getIdentity().equals(getIdentity());
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
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

  public List<WorkflowFileEntity> getFiles() {
    return this.files;
  }

  public void setFiles(final List<WorkflowFileEntity> files) {
    this.files.clear();
    if (files != null) {
      for (final WorkflowFileEntity file : files) {
        file.setWorkflowEntity(this);
        this.files.add(file);
      }
    }
  }

  public List<WorkflowActionEntity> getActions() {
    return this.actions;
  }

  public void setActions(final List<WorkflowActionEntity> actions) {
    this.actions.clear();
    if (actions != null) {
      for (final WorkflowActionEntity action : actions) {
        action.setWorkflowEntity(this);
        this.actions.add(action);
      }

    }
  }

  @Override
  public String getIdentityPreffix() {
    return "w";
  }

  public Long getControllerId() {
    return controllerId;
  }

  public void setControllerId(final Long controllerId) {
    this.controllerId = controllerId;
  }

  public Long getCreatedById() {
    return createdById;
  }

  public void setCreatedById(final Long createdById) {
    this.createdById = createdById;
  }

  public Long getWorkflowTypeId() {
    return workflowTypeId;
  }

  public void setWorkflowTypeId(final Long workflowTypeId) {
    this.workflowTypeId = workflowTypeId;
  }

  public Long getCurrentStepId() {
    return currentStepId;
  }

  public void setCurrentStepId(final Long currentStepId) {
    this.currentStepId = currentStepId;
  }

  public WorkflowTypeEntity getWorkflowType() {
    return workflowType;
  }

  @Override
  public void increaseVersion() {
    version += 1;

  }
}

package com.pth.iflow.core.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workflow_type_step")
public class WorkflowTypeStepEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long    id;

  @Column(name = "identity")
  private String  identity;

  @Column(name = "workflow_type_id")
  private Long    workflowTypeId;

  @Column(name = "title")
  private String  title;

  @Column(name = "step_index")
  private Integer stepIndex;

  @Column(name = "view_name")
  private String  viewName;

  @Column(name = "expire_days")
  private Integer expireDays;

  @Column(name = "commecnts")
  private String  comments;

  @Column(name = "status")
  private Integer status;

  @Column(name = "version")
  private Integer version;

  @Column(name = "created_at")
  private Date    createdAt;

  @Column(name = "updated_at")
  private Date    updatedAt;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowTypeId() {
    return this.workflowTypeId;
  }

  public String getIdentity() {
    return identity;
  }

  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public void setWorkflowTypeId(final Long workflowTypeId) {
    this.workflowTypeId = workflowTypeId;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  /**
   * @return the stepIndex
   */
  public Integer getStepIndex() {
    return this.stepIndex;
  }

  /**
   * @param stepIndex the stepIndex to set
   */
  public void setStepIndex(final Integer stepIndex) {
    this.stepIndex = stepIndex;
  }

  public String getViewName() {
    return this.viewName;
  }

  public void setViewName(final String viewName) {
    this.viewName = viewName;
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

  public Integer getVersion() {
    return this.version;
  }

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

  public Integer getExpireDays() {
    return expireDays;
  }

  public void setExpireDays(final Integer expireDays) {
    this.expireDays = expireDays;
  }

}
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Subselect;

import com.pth.iflow.core.model.entity.UserEntity;

@Entity
@Subselect("select workflow_actions.*,steps.identity as current_step_identity, users.email as assign_to_identity from \r\n"
    + "(workflow_actions inner join workflow_type_step steps on steps.id = workflow_actions.current_step_id)\r\n"
    + " left outer join users on users.id = workflow_actions.assign_to ")
@Table(name = "workflow_actions")
public class WorkflowActionEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                   id;

  @Column(name = "identity")
  private String                 identity;

  @Column(name = "workflow_id")
  private Long                   workflowId;

  @Column(name = "assign_to")
  private Long                   assignTo;

  @Column(name = "current_step_id")
  private Long                   currentStepId;

  @Column(name = "comments")
  private String                 comments;

  @Column(name = "status")
  private Integer                status;

  @Column(name = "version")
  private Integer                version;

  @Column(name = "created_at")
  private Date                   createdAt;

  @Column(name = "updated_at")
  private Date                   updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "assign_to", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private UserEntity             assignToUser;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "current_step_id", insertable = false, updatable = false)
  @Fetch(FetchMode.JOIN)
  private WorkflowTypeStepEntity currentStep;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getIdentity() {
    return identity;
  }

  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public Long getWorkflowId() {
    return this.workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public Long getAssignTo() {
    return assignTo;
  }

  public void setAssignTo(final Long assignTo) {
    this.assignTo = assignTo;
  }

  public Long getCurrentStepId() {
    return currentStepId;
  }

  public void setCurrentStepId(final Long currentStepId) {
    this.currentStepId = currentStepId;
  }

  public String getAssignToIdentity() {
    return assignToUser.getIdentity();
  }

  public String getCurrentStepIdentity() {
    return currentStep.getIdentity();
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

}

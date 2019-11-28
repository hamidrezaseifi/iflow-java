package com.pth.iflow.core.model.entity.workflow;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Subselect;
import com.pth.iflow.common.enums.EWorkflowIdentity;
import com.pth.iflow.core.model.helper.CoreModelHelper;

@Entity
@Subselect("select workflow.* ,steps.identity as current_step_identity, controllerusers.email as controller_identity, "
           + "createdbyusers.email as createdby_identity, workflow_type.identity as workflow_type_identity from"
           + "(((workflow inner join workflow_type_step steps on steps.id = workflow.current_step)"
           + "inner join users controllerusers on controllerusers.id = workflow.controller)"
           + "inner join workflow_type on workflow_type.id = workflow.workflow_type_id)"
           + "inner join users createdbyusers on createdbyusers.id = workflow.created_by")
public class WorkflowEntity extends CoreModelHelper {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "identity")
  private String identity;

  @Column(name = "workflow_type_id")
  private Long workflowTypeId;

  @Column(name = "current_step_identity")
  private String currentStepIdentity;

  @Column(name = "controller_identity")
  private String controllerIdentity;

  @Column(name = "createdby_identity")
  private String createdByIdentity;

  @Column(name = "workflow_type_identity")
  private String workflowTypeIdentity;

  @Column(name = "current_step")
  private Long currentStepId;

  @Column(name = "controller")
  private Long controllerId;

  @Column(name = "created_by")
  private Long createdById;

  @Column(name = "comments")
  private String comments;

  @Column(name = "status")
  private Integer status;

  @Column(name = "version")
  private Integer version;

  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "workflow_id")
  private final List<WorkflowFileEntity> files = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "workflow_id")
  private final List<WorkflowActionEntity> actions = new ArrayList<>();

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(final Long id) {
    this.id = id;
  }

  public String getIdentity() {
    return identity;
  }

  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public boolean isIdentityNotSet() {
    return EWorkflowIdentity.NOT_SET.getIdentity().equals(getIdentity());
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
      this.files.addAll(files);
    }
  }

  public List<WorkflowActionEntity> getActions() {
    return this.actions;
  }

  public void setActions(final List<WorkflowActionEntity> actions) {
    this.actions.clear();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }

  public String getWorkflowTypeIdentity() {
    return workflowTypeIdentity;
  }

  public void setWorkflowTypeIdentity(final String workflowTypeIdentity) {
    this.workflowTypeIdentity = workflowTypeIdentity;
  }

  public String getCurrentStepIdentity() {
    return currentStepIdentity;
  }

  public void setCurrentStepIdentity(final String currentStepIdentity) {
    this.currentStepIdentity = currentStepIdentity;
  }

  public String getControllerIdentity() {
    return controllerIdentity;
  }

  public void setControllerIdentity(final String controllerIdentity) {
    this.controllerIdentity = controllerIdentity;
  }

  public String getCreatedByIdentity() {
    return createdByIdentity;
  }

  public void setCreatedByIdentity(final String createdByIdentity) {
    this.createdByIdentity = createdByIdentity;
  }

  public Long getCurrentStepId() {
    return currentStepId;
  }

  public void setCurrentStepId(final Long currentStepId) {
    this.currentStepId = currentStepId;
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

}

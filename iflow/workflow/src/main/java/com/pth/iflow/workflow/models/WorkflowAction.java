package com.pth.iflow.workflow.models;

import java.time.LocalDateTime;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.WorkflowActionEdo;

public class WorkflowAction extends ModelMapperBase<WorkflowActionEdo, WorkflowAction> {
  
  private Long          id;
  private Long          workflowId;
  private Long          createdBy;
  private String        action;
  private Long          oldStep;
  private Long          newStep;
  private String        comments;
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
  
  public Long getWorkflowId() {
    return this.workflowId;
  }
  
  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }
  
  public String getAction() {
    return this.action;
  }
  
  public void setAction(final String action) {
    this.action = action;
  }
  
  public Long getOldStep() {
    return this.oldStep;
  }
  
  public void setOldStep(final Long oldStep) {
    this.oldStep = oldStep;
  }
  
  public Long getNewStep() {
    return this.newStep;
  }
  
  public void setNewStep(final Long newStep) {
    this.newStep = newStep;
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
  public WorkflowActionEdo toEdo() {
    final WorkflowActionEdo edo = new WorkflowActionEdo();
    edo.setAction(this.action);
    edo.setComments(this.comments);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setCreatedBy(this.createdBy);
    edo.setOldStep(this.oldStep);
    edo.setNewStep(this.newStep);
    edo.setWorkflowId(this.workflowId);
    edo.setVersion(this.version);
    
    return edo;
  }
  
  @Override
  public WorkflowAction fromEdo(final WorkflowActionEdo edo) {
    if (edo == null) {
      return null;
    }
    
    final WorkflowAction model = new WorkflowAction();
    
    model.setAction(edo.getAction());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCreatedBy(edo.getCreatedBy());
    model.setOldStep(edo.getOldStep());
    model.setNewStep(edo.getNewStep());
    model.setWorkflowId(edo.getWorkflowId());
    model.setVersion(edo.getVersion());
    
    return model;
  }
  
}

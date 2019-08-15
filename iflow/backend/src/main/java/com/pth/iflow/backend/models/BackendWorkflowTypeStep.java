package com.pth.iflow.backend.models;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepEdo;

public class BackendWorkflowTypeStep extends ModelMapperBase<WorkflowTypeStepEdo, BackendWorkflowTypeStep> {
  
  private Long    id;
  private Long    workflowTypeId;
  private String  title;
  private Integer stepIndex;
  private String  comments;
  private Integer status;
  private Integer version;
  
  @Override
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id;
  }
  
  public Long getWorkflowTypeId() {
    return this.workflowTypeId;
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
  
  public boolean isAfterStep(final BackendWorkflowTypeStep other) {
    return this.stepIndex > other.getStepIndex();
  }
  
  public boolean isBeforeStep(final BackendWorkflowTypeStep other) {
    return this.stepIndex < other.getStepIndex();
  }
  
  public boolean isTheSameStep(final BackendWorkflowTypeStep other) {
    return this.stepIndex == other.getStepIndex();
  }
  
  @Override
  public WorkflowTypeStepEdo toEdo() {
    final WorkflowTypeStepEdo edo = new WorkflowTypeStepEdo();
    edo.setStepIndex(this.stepIndex);
    edo.setTitle(this.title);
    edo.setComments(this.comments);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setWorkflowTypeId(this.workflowTypeId);
    edo.setVersion(this.version);
    
    return edo;
  }
  
  @Override
  public BackendWorkflowTypeStep fromEdo(final WorkflowTypeStepEdo edo) {
    if (edo == null) {
      return null;
    }
    final BackendWorkflowTypeStep model = new BackendWorkflowTypeStep();
    
    model.setStepIndex(edo.getStepIndex());
    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setId(edo.getId());
    model.setWorkflowTypeId(edo.getWorkflowTypeId());
    
    return model;
  }

}
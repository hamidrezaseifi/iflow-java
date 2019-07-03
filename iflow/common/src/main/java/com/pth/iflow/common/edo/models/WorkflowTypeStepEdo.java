package com.pth.iflow.common.edo.models;

public class WorkflowTypeStepEdo {
  
  private Long    id;
  private Long    workflowTypeId;
  private String  title;
  private String  comments;
  private Integer status;
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id;
  }
  
  public Long getWorkflowTypeId() {
    return this.workflowTypeId;
  }
  
  public void setWorkflowTypeId(final Long workflowId) {
    this.workflowTypeId = workflowId;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(final String title) {
    this.title = title;
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
  
}
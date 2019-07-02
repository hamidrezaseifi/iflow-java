package com.pth.iflow.common.edo.models;

import java.util.HashSet;
import java.util.Set;

public class WorkflowTypeEdo {
  
  private Long            id;
  private Long            companyId;
  private Long            baseTypeId;
  private String          title;
  private String          comments;
  private Integer         status;
  private final Set<Long> steps = new HashSet<>();
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id;
  }
  
  public Long getCompanyId() {
    return this.companyId;
  }
  
  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
  }
  
  /**
   * @return the baseTypeId
   */
  public Long getBaseTypeId() {
    return this.baseTypeId;
  }
  
  /**
   * @param baseTypeId the baseTypeId to set
   */
  public void setBaseTypeId(final Long baseTypeId) {
    this.baseTypeId = baseTypeId;
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
  
  public Set<Long> getSteps() {
    return this.steps;
  }
  
  public void setSteps(final Set<Long> steps) {
    this.steps.clear();
    if (steps != null) {
      this.steps.addAll(steps);
    }
  }
  
  public void addStep(final Long stepId) {
    this.steps.add(stepId);
  }
}

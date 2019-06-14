package com.pth.iflow.core.model;

import java.util.HashSet;
import java.util.Set;

import com.pth.iflow.common.edo.models.WorkflowEdo;

public class Workflow extends ModelBase<WorkflowEdo> {
  private Long id;
  private Long companyId;
  private String title;
  private String comments;
  private Integer status;
  private final Set<Integer> steps = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(final Long companyId) {
    this.companyId = companyId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(final Integer status) {
    this.status = status;
  }

  public Set<Integer> getSteps() {
    return steps;
  }

  public void setSteps(final Set<Integer> steps) {
    this.steps.clear();
    if (steps != null) {
      this.steps.addAll(steps);
    }
  }

  public void addStep(final Integer stepId) {
    this.steps.add(stepId);
  }

  @Override
  public WorkflowEdo toEdo() {
    final WorkflowEdo edo = new WorkflowEdo();
    edo.setTitle(title);
    edo.setComments(comments);
    edo.setStatus(status);
    edo.setId(id);
    edo.setCompanyId(companyId);
    edo.setSteps(steps);

    return edo;
  }

  public static Workflow fromEdo(final WorkflowEdo edo) {
    final Workflow model = new Workflow();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    model.setSteps(edo.getSteps());

    return model;
  }

  @Override
  public void initFromEdo(final WorkflowEdo edo) {
    setTitle(edo.getTitle());
    setComments(edo.getComments());
    setStatus(edo.getStatus());
    setId(edo.getId());
    setCompanyId(edo.getCompanyId());
    setSteps(edo.getSteps());
  }

}

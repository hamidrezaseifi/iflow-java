package com.pth.iflow.core.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.common.edo.models.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;

public class WorkflowType extends ModelMapperBase<WorkflowTypeEdo, WorkflowType> {

  protected Long id;
  protected Long companyId;
  protected Long baseTypeId;
  protected String title;
  protected String comments;
  protected Integer status;
  protected Integer version;
  protected LocalDateTime createdAt;
  protected LocalDateTime updatedAt;
  protected final Set<Long> stepIds = new HashSet<>();

  @Override
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

  public Integer getVersion() {
    return this.version;
  }

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

  public Set<Long> getStepIds() {
    return this.stepIds;
  }

  public void setStepIds(final Set<Long> stepIds) {
    this.stepIds.clear();
    if (stepIds != null) {
      this.stepIds.addAll(stepIds);
    }
  }

  public void setStepIds(final List<Long> stepIds) {
    setStepIds(stepIds.stream().collect(Collectors.toSet()));
  }

  public void addStepId(final Long stepId) {
    this.stepIds.add(stepId);
  }

  @Override
  public WorkflowTypeEdo toEdo() {
    final WorkflowTypeEdo edo = new WorkflowTypeEdo();
    edo.setTitle(this.title);
    edo.setComments(this.comments);
    edo.setStatus(this.status);
    edo.setId(this.id);
    edo.setCompanyId(this.companyId);
    edo.setBaseTypeId(this.baseTypeId);
    edo.setSteps(this.stepIds);

    return edo;
  }

  @Override
  public WorkflowType fromEdo(final WorkflowTypeEdo edo) {
    final WorkflowType model = new WorkflowType();

    model.setTitle(edo.getTitle());
    model.setComments(edo.getComments());
    model.setStatus(edo.getStatus());
    model.setId(edo.getId());
    model.setCompanyId(edo.getCompanyId());
    model.setBaseTypeId(edo.getBaseTypeId());
    model.setStepIds(edo.getSteps());

    return model;
  }

  @Override
  public void fromExists(final WorkflowType exist) {
    setTitle(exist.getTitle());
    setComments(exist.getComments());
    setStatus(exist.getStatus());
    setId(exist.getId());
    setCompanyId(exist.getCompanyId());
    setBaseTypeId(exist.getBaseTypeId());
    setStepIds(exist.getStepIds());
    setVersion(exist.getVersion());
    setCreatedAt(exist.getCreatedAt());
    setUpdatedAt(exist.getUpdatedAt());

  }

}

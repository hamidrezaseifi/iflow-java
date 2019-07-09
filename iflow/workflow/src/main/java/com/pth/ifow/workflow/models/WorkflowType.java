package com.pth.ifow.workflow.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeEdo;

public class WorkflowType extends ModelMapperBase<WorkflowTypeEdo, WorkflowType> {

  private Long id;
  private Long companyId;
  private Long baseTypeId;
  private String title;
  private String comments;
  private Integer status;
  private Boolean sendToController;
  private Boolean manualAssign;
  private Boolean increaseStepAutomatic;
  private Integer version;
  private final Set<WorkflowTypeStep> steps = new HashSet<>();

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

  public Boolean getSendToController() {
    return sendToController;
  }

  public void setSendToController(final Boolean sendToController) {
    this.sendToController = sendToController;
  }

  public Boolean getManualAssign() {
    return manualAssign;
  }

  public void setManualAssign(final Boolean manualAssign) {
    this.manualAssign = manualAssign;
  }

  public Boolean getIncreaseStepAutomatic() {
    return increaseStepAutomatic;
  }

  public void setIncreaseStepAutomatic(final Boolean increaseStepAutomatic) {
    this.increaseStepAutomatic = increaseStepAutomatic;
  }

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  public Set<WorkflowTypeStep> getSteps() {
    return this.steps;
  }

  public void setSteps(final Set<WorkflowTypeStep> steps) {
    this.steps.clear();
    if (steps != null) {
      this.steps.addAll(steps);
    }
  }

  public void setSteps(final List<WorkflowTypeStep> steps) {
    setSteps(steps.stream().collect(Collectors.toSet()));
  }

  public void addStep(final WorkflowTypeStep stepId) {
    this.steps.add(stepId);
  }

  @Override
  public boolean isNew() {
    return id == null || id <= 0;
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
    edo.setSendToController(sendToController);
    edo.setManualAssign(manualAssign);
    edo.setIncreaseStepAutomatic(increaseStepAutomatic);
    edo.setSteps(ModelMapperBase.toEdoList(this.steps).stream().collect(Collectors.toSet()));
    edo.setVersion(version);

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
    model.setSendToController(edo.getSendToController());
    model.setManualAssign(edo.getManualAssign());
    model.setIncreaseStepAutomatic(edo.getIncreaseStepAutomatic());
    model.setVersion(edo.getVersion());
    model.setSteps(new WorkflowTypeStep().fromEdoList(edo.getSteps()));

    return model;
  }

}

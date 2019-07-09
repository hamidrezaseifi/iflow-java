package com.pth.iflow.common.edo.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkflowTypeEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkflowTypeEdo {

  @XmlElement(name = "ID")
  private Long                           id;

  @NotNull
  @XmlElement(name = "CompanyId")
  private Long                           companyId;

  @NotNull
  @XmlElement(name = "BaseTypeId")
  private Long                           baseTypeId;

  @NotNull
  @XmlElement(name = "Title")
  private String                         title;

  @XmlElement(name = "Comments")
  private String                         comments;

  @NotNull
  @XmlElement(name = "Status")
  private Integer                        status;

  @NotNull
  @XmlElement(name = "Version")
  private Integer                        version;

  @NotNull
  @XmlElement(name = "SendToController")
  private Boolean                        sendToController;

  @NotNull
  @XmlElement(name = "ManualAssign")
  private Boolean                        manualAssign;

  @NotNull
  @XmlElement(name = "IncreaseStepAutomatic")
  private Boolean                        increaseStepAutomatic;

  @XmlElementWrapper(name = "StepList")
  @XmlElement(name = "Steps")
  private final Set<WorkflowTypeStepEdo> steps = new HashSet<>();

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

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
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

  public Set<WorkflowTypeStepEdo> getSteps() {
    return this.steps;
  }

  public void setSteps(final Set<WorkflowTypeStepEdo> steps) {
    this.steps.clear();
    if (steps != null) {
      this.steps.addAll(steps);
    }
  }

  public void addStep(final WorkflowTypeStepEdo stepId) {
    this.steps.add(stepId);
  }
}

package com.pth.iflow.common.edo.models.xml;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkflowActionEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkflowActionEdo {

  @XmlElement(name = "ID")
  private Long    id;

  @NotNull
  @XmlElement(name = "WorkflowId")
  private Long    workflowId;

  @XmlElement(name = "CreatedBy")
  private Long    createdBy;

  @NotNull
  @XmlElement(name = "Action")
  private String  action;

  @XmlElement(name = "OldStep")
  private Long    oldStep;

  @XmlElement(name = "NewStep")
  private Long    newStep;

  @XmlElement(name = "Comments")
  private String  comments;

  @NotNull
  @XmlElement(name = "Status")
  private Integer status;

  @NotNull
  @XmlElement(name = "Version")
  private Integer version;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowId() {
    return workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public String getAction() {
    return action;
  }

  public void setAction(final String action) {
    this.action = action;
  }

  public Long getOldStep() {
    return oldStep;
  }

  public void setOldStep(final Long oldStep) {
    this.oldStep = oldStep;
  }

  public Long getNewStep() {
    return newStep;
  }

  public void setNewStep(final Long newStep) {
    this.newStep = newStep;
  }

  public Long getCreatedBy() {
    return createdBy;
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

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

}

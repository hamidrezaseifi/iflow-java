package com.pth.iflow.common.edo.models.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkflowTypeStepEdo")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkflowTypeStepEdo {

  @XmlElement(name = "ID")
  private Long    id;

  @XmlElement(name = "WorkflowTypeId")
  private Long    workflowTypeId;

  @XmlElement(name = "Title")
  private String  title;

  @XmlElement(name = "StepIndex")
  private Integer stepIndex;

  @XmlElement(name = "Comments")
  private String  comments;

  @XmlElement(name = "Status")
  private Integer status;

  @XmlElement(name = "Version")
  private Integer version;

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

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(final Integer version) {
    this.version = version;
  }

}

package com.pth.iflow.common.edo.models;

import java.util.Set;
import java.util.HashSet;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;
import com.pth.iflow.common.edo.models.validation.AEnumValueValidator;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;

@XmlRootElement(name = "WorkflowType", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowType" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowTypeEdo {

  @XmlElement(name = "Identity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String                               identity;

  @NotNull
  @XmlElement(name = "CompanyIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String                               companyIdentity;

  @NotNull
  @XmlElement(name = "BaseTypeId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long                                 baseTypeId;

  @NotNull
  @XmlElement(name = "Title", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String                               title;

  @XmlElement(name = "Comments", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String                               comments;

  @NotNull
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer                              status;

  @NotNull
  @XmlElement(name = "Version", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer                              version;

  @NotNull
  @XmlElement(name = "SendToController", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Boolean                              sendToController;

  @NotNull
  @AEnumValueValidator(enumClazz = EWorkflowTypeAssignType.class)
  @XmlElement(name = "AssignType", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer                              assignType;

  @NotNull
  @XmlElement(name = "IncreaseStepAutomatic", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Boolean                              increaseStepAutomatic;

  @NotNull
  @XmlElement(name = "AllowAssign", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Boolean                              allowAssign;

  @NotNull
  @XmlElementWrapper(name = "WorkflowTypeStepList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "WorkflowTypeStep", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final Set<WorkflowTypeStepEdo> steps = new HashSet<>();

  public String getIdentity() {
    return this.identity;
  }

  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public String getCompanyIdentity() {
    return this.companyIdentity;
  }

  public void setCompanyIdentity(final String companyIdentity) {
    this.companyIdentity = companyIdentity;
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
    return this.sendToController;
  }

  public void setSendToController(final Boolean sendToController) {
    this.sendToController = sendToController;
  }

  public Integer getAssignType() {
    return this.assignType;
  }

  public void setAssignType(final Integer assignType) {
    this.assignType = assignType;
  }

  public Boolean getIncreaseStepAutomatic() {
    return this.increaseStepAutomatic;
  }

  public void setIncreaseStepAutomatic(final Boolean increaseStepAutomatic) {
    this.increaseStepAutomatic = increaseStepAutomatic;
  }

  public Boolean getAllowAssign() {
    return this.allowAssign;
  }

  public void setAllowAssign(final Boolean allowAssign) {
    this.allowAssign = allowAssign;
  }

  public Set<WorkflowTypeStepEdo> getSteps() {
    return this.steps;
  }

  @JsonSetter
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

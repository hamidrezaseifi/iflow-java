package com.pth.iflow.common.edo.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;
import com.pth.iflow.common.edo.models.helper.IsoFormats;
import com.pth.iflow.common.edo.models.helper.LocalDateTimeEdoAdapter;
import com.pth.iflow.common.edo.models.validation.AEnumValueValidator;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;

@XmlRootElement(name = "WorkflowMessage", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowMessage" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowMessageEdo {

  @XmlElement(name = "ID", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long          id;

  @NotNull(message = "workflowId must not be null")
  @XmlElement(name = "WorkflowId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long          workflowId;

  @NotNull(message = "UserId must not be null")
  @XmlElement(name = "UserId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long          userId;

  @XmlElement(name = "Message", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String        message;

  @NotNull(message = "CreatedBy must not be null")
  @XmlElement(name = "CreatedBy", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long          createdBy;

  @NotNull(message = "MessageType must not be null")
  @AEnumValueValidator(enumClazz = EWorkflowMessageType.class)
  @XmlElement(name = "MessageType", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer       messageType;

  @NotNull(message = "status must not be null")
  @AEnumValueValidator(enumClazz = EWorkflowMessageStatus.class)
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer       status;

  @NotNull(message = "version must not be null")
  @XmlElement(name = "Version", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer       version;

  @XmlElement(name = "ExpireDays", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @NotNull(message = "expired must not be null")
  private Integer       expireDays;

  @XmlJavaTypeAdapter(LocalDateTimeEdoAdapter.class)
  @JsonFormat(pattern = IsoFormats.DATETIME_FORMAT_ISO)
  @XmlSchemaType(name = "dateTime")
  @XmlElement(name = "CreatedAt", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private LocalDateTime createdAt;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getWorkflowId() {
    return this.workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public Long getUserId() {
    return this.userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public Long getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  public Integer getMessageType() {
    return this.messageType;
  }

  public void setMessageType(final Integer messageType) {
    this.messageType = messageType;
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

  public Integer getExpireDays() {
    return this.expireDays;
  }

  public void setExpireDays(final Integer expireDays) {
    this.expireDays = expireDays;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

}

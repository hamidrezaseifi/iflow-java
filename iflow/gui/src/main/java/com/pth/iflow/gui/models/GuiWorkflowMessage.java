package com.pth.iflow.gui.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.pth.iflow.common.edo.models.base.DataModelBase;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;

public class GuiWorkflowMessage extends DataModelBase {

  private Long                   id;

  private Long                   workflowId;

  private GuiWorkflow            workflow;

  private Long                   stepId;

  private GuiWorkflowTypeStep    step;

  private Long                   userId;

  private String                 message;

  private Long                   createdBy;

  private EWorkflowMessageType   messageType;

  private EWorkflowMessageStatus status;

  private Integer                version;

  private Integer                expireDays;

  private LocalDateTime          createdAt;

  @Override
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

  public Long getStepId() {
    return this.stepId;
  }

  public void setStepId(final Long stepId) {
    this.stepId = stepId;
  }

  public GuiWorkflowTypeStep getStep() {
    return this.step;
  }

  public void setStep(final GuiWorkflowTypeStep step) {
    this.step = step;
  }

  public GuiWorkflow getWorkflow() {
    return this.workflow;
  }

  public void setWorkflow(final GuiWorkflow workflow) {
    this.workflow = workflow;
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

  public EWorkflowMessageType getMessageType() {
    return this.messageType;
  }

  public void setMessageType(final EWorkflowMessageType messageType) {
    this.messageType = messageType;
  }

  public EWorkflowMessageStatus getStatus() {
    return this.status;
  }

  public boolean isOffering() {
    return this.status == EWorkflowMessageStatus.OFFERING;
  }

  public void setStatus(final EWorkflowMessageStatus status) {
    this.status = status;
  }

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  public boolean isExpired() {
    return this.createdAt.plusDays(this.expireDays).isAfter(LocalDateTime.now());
  }

  public boolean isNotExpired() {
    return this.isExpired() == false;
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

  public String getCreatedAtString() {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");
    return this.createdAt.format(formatter);
  }

  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public int getRemainingDays() {
    final LocalDate deadline = this.createdAt.plusDays(this.expireDays).toLocalDate();
    final Period p = LocalDate.now().until(deadline);

    return p.getDays();
  }

}

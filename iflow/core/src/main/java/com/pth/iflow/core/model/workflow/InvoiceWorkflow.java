package com.pth.iflow.core.model.workflow;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.pth.iflow.common.enums.EInvoiceType;
import com.pth.iflow.common.enums.EWorkflowIdentity;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.core.model.helper.CoreModelHelper;
import com.pth.iflow.core.model.helper.ICoreIdentityModel;
import com.pth.iflow.core.model.workflow.sub.WorkflowAction;
import com.pth.iflow.core.model.workflow.sub.WorkflowFile;

public class InvoiceWorkflow extends CoreModelHelper implements ICoreIdentityModel, IWorkflow {

  private Long            id;
  private String          identity;
  private String          comments;
  private EWorkflowStatus status;
  private Integer         version;
  private LocalDateTime   createdAt;
  private LocalDateTime   updatedAt;

  private String currentStepIdentity;
  private String controllerIdentity;
  private String createdByIdentity;

  private Long currentStepId;
  private Long controllerId;
  private Long createdById;
  private Long workflowTypeId;

  private final List<WorkflowFile>   files   = new ArrayList<>();
  private final List<WorkflowAction> actions = new ArrayList<>();

  private String sender;

  private String registerNumber;

  private LocalDate invoceDate;

  private String partnerCode;

  private String vendorNumber;

  private String vendorName;

  private Boolean isDirectDebitPermission;

  private EInvoiceType invoiceType;

  private LocalDate discountEnterDate;

  private Integer discountDeadline;

  private Double discountRate;

  private LocalDate discountDate;

  private Double paymentAmount;

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(final Long id) {
    this.id = id;
  }

  @Override
  public String getIdentity() {
    return identity;
  }

  @Override
  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  @Override
  public boolean isIdentityNotSet() {
    return EWorkflowIdentity.NOT_SET.getIdentity().equals(getIdentity());
  }

  @Override
  public String getComments() {
    return this.comments;
  }

  @Override
  public void setComments(final String comments) {
    this.comments = comments;
  }

  @Override
  public EWorkflowStatus getStatus() {
    return this.status;
  }

  @Override
  public Integer getStatusInt() {
    return this.status.getValue().intValue();
  }

  @Override
  public void setStatus(final Integer status) {
    this.status = EWorkflowStatus.ofValue(status);
  }

  @Override
  public Integer getVersion() {
    return this.version;
  }

  @Override
  public void setVersion(final Integer version) {
    this.version = version;
  }

  @Override
  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  @Override
  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  @Override
  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public List<WorkflowFile> getFiles() {
    return this.files;
  }

  @Override
  public void setFiles(final List<WorkflowFile> files) {
    this.files.clear();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  @Override
  public List<WorkflowAction> getActions() {
    return this.actions;
  }

  @Override
  public void setActions(final List<WorkflowAction> actions) {
    this.actions.clear();
    if (actions != null) {
      this.actions.addAll(actions);
    }
  }

  @Override
  public String getWorkflowTypeIdentity() {
    return EWorkflowType.INVOICE_WORKFLOW_TYPE.getIdentity();
  }

  @Override
  public String getCurrentStepIdentity() {
    return currentStepIdentity;
  }

  @Override
  public void setCurrentStepIdentity(final String currentStepIdentity) {
    this.currentStepIdentity = currentStepIdentity;
  }

  @Override
  public String getControllerIdentity() {
    return controllerIdentity;
  }

  @Override
  public void setControllerIdentity(final String controllerIdentity) {
    this.controllerIdentity = controllerIdentity;
  }

  @Override
  public String getCreatedByIdentity() {
    return createdByIdentity;
  }

  @Override
  public void setCreatedByIdentity(final String createdByIdentity) {
    this.createdByIdentity = createdByIdentity;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(final String sender) {
    this.sender = sender;
  }

  public String getRegisterNumber() {
    return registerNumber;
  }

  public void setRegisterNumber(final String registerNumber) {
    this.registerNumber = registerNumber;
  }

  public LocalDate getInvoceDate() {
    return invoceDate;
  }

  public void setInvoceDate(final LocalDate invoceDate) {
    this.invoceDate = invoceDate;
  }

  public String getPartnerCode() {
    return partnerCode;
  }

  public void setPartnerCode(final String partnerCode) {
    this.partnerCode = partnerCode;
  }

  public String getVendorNumber() {
    return vendorNumber;
  }

  public void setVendorNumber(final String vendorNumber) {
    this.vendorNumber = vendorNumber;
  }

  public String getVendorName() {
    return vendorName;
  }

  public void setVendorName(final String vendorName) {
    this.vendorName = vendorName;
  }

  public Boolean getIsDirectDebitPermission() {
    return isDirectDebitPermission;
  }

  public void setIsDirectDebitPermission(final Boolean isDirectDebit) {
    this.isDirectDebitPermission = isDirectDebit;
  }

  public EInvoiceType getInvoiceType() {
    return invoiceType;
  }

  public void setInvoiceType(final EInvoiceType invoiceType) {
    this.invoiceType = invoiceType;
  }

  public void setInvoiceType(final Integer invoiceType) {
    this.invoiceType = EInvoiceType.ofValue(invoiceType);
  }

  public LocalDate getDiscountEnterDate() {
    return discountEnterDate;
  }

  public void setDiscountEnterDate(final LocalDate discountEnterDate) {
    this.discountEnterDate = discountEnterDate;
  }

  public Integer getDiscountDeadline() {
    return discountDeadline;
  }

  public void setDiscountDeadline(final Integer discountDeadline) {
    this.discountDeadline = discountDeadline;
  }

  public Double getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(final Double discountRate) {
    this.discountRate = discountRate;
  }

  public LocalDate getDiscountDate() {
    return discountDate;
  }

  public void setDiscountDate(final LocalDate discountDate) {
    this.discountDate = discountDate;
  }

  public Double getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(final Double paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  @Override
  public Long getCurrentStepId() {
    return currentStepId;
  }

  @Override
  public void setCurrentStepId(final Long currentStepId) {
    this.currentStepId = currentStepId;
  }

  @Override
  public Long getControllerId() {
    return controllerId;
  }

  @Override
  public void setControllerId(final Long controllerId) {
    this.controllerId = controllerId;
  }

  @Override
  public Long getCreatedById() {
    return createdById;
  }

  @Override
  public void setCreatedById(final Long createdById) {
    this.createdById = createdById;
  }

  @Override
  public Long getWorkflowTypeId() {
    return workflowTypeId;
  }

  @Override
  public void setWorkflowTypeId(final Long workflowTypeId) {
    this.workflowTypeId = workflowTypeId;
  }

}

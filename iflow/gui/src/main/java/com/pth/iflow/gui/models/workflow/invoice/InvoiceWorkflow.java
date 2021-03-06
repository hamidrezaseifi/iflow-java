package com.pth.iflow.gui.models.workflow.invoice;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.common.enums.EInvoiceType;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.gui.helper.GuiDateDeserializer;
import com.pth.iflow.gui.helper.GuiDateSerializer;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.base.WorkflowBase;

@JsonIgnoreProperties(value = { "isAssignTo" })
public class InvoiceWorkflow extends WorkflowBase implements IWorkflow {

  private String sender;

  private String registerNumber;

  @JsonDeserialize(using = GuiDateDeserializer.class)
  @JsonSerialize(using = GuiDateSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
  private LocalDate invocieDate;

  private String partnerCode;

  private String vendorNumber;

  private String vendorName;

  private Boolean isDirectDebitPermission;

  private EInvoiceType invoiceType;

  @JsonDeserialize(using = GuiDateDeserializer.class)
  @JsonSerialize(using = GuiDateSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
  private LocalDate discountEnterDate;

  private Integer discountDeadline;

  private Double discountRate;

  @JsonDeserialize(using = GuiDateDeserializer.class)
  @JsonSerialize(using = GuiDateSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
  private LocalDate discountDate;

  private Double paymentAmount;

  @Override
  public EWorkflowType getWorkflowTypeEnum() {

    return EWorkflowType.INVOICE_WORKFLOW_TYPE;
  }

  @Override
  public String getWorkflowTypeIdentity() {

    return this.getWorkflowTypeEnum().getIdentity();
  }

  public String getSender() {

    return this.sender;
  }

  public void setSender(final String sender) {

    this.sender = sender;
  }

  public String getRegisterNumber() {

    return this.registerNumber;
  }

  public void setRegisterNumber(final String registerNumber) {

    this.registerNumber = registerNumber;
  }

  public LocalDate getInvoiceDate() {

    return this.invocieDate;
  }

  public void setInvoiceDate(final LocalDate invocieDate) {

    this.invocieDate = invocieDate;
  }

  public String getPartnerCode() {

    return this.partnerCode;
  }

  public void setPartnerCode(final String partnerCode) {

    this.partnerCode = partnerCode;
  }

  public String getVendorNumber() {

    return this.vendorNumber;
  }

  public void setVendorNumber(final String vendorNumber) {

    this.vendorNumber = vendorNumber;
  }

  public String getVendorName() {

    return this.vendorName;
  }

  public void setVendorName(final String vendorName) {

    this.vendorName = vendorName;
  }

  public Boolean getIsDirectDebitPermission() {

    return this.isDirectDebitPermission;
  }

  public void setIsDirectDebitPermission(final Boolean isDirectDebitPermission) {

    this.isDirectDebitPermission = isDirectDebitPermission;
  }

  public EInvoiceType getInvoiceType() {

    return this.invoiceType;
  }

  public void setInvoiceType(final EInvoiceType invoiceType) {

    this.invoiceType = invoiceType;
  }

  public LocalDate getDiscountEnterDate() {

    return this.discountEnterDate;
  }

  public void setDiscountEnterDate(final LocalDate discountEnterDate) {

    this.discountEnterDate = discountEnterDate;
  }

  public Integer getDiscountDeadline() {

    return this.discountDeadline;
  }

  public void setDiscountDeadline(final Integer discountDeadline) {

    this.discountDeadline = discountDeadline;
  }

  public Double getDiscountRate() {

    return this.discountRate;
  }

  public void setDiscountRate(final Double discountRate) {

    this.discountRate = discountRate;
  }

  public LocalDate getDiscountDate() {

    return this.discountDate;
  }

  public void setDiscountDate(final LocalDate discountDate) {

    this.discountDate = discountDate;
  }

  public Double getPaymentAmount() {

    return this.paymentAmount;
  }

  public void setPaymentAmount(final Double paymentAmount) {

    this.paymentAmount = paymentAmount;
  }

  public static InvoiceWorkflow generateInitial(final String creatorId) {

    final InvoiceWorkflow newWorkflow = new InvoiceWorkflow();
    newWorkflow.setStatus(EWorkflowStatus.INITIALIZE);
    newWorkflow.setCreatedByIdentity(creatorId);
    newWorkflow.setControllerIdentity("");
    newWorkflow.setCurrentStepIdentity("");
    newWorkflow.setVersion(0);
    newWorkflow.setComments("");
    newWorkflow.setIdentity(EIdentity.NOT_SET.getIdentity());
    newWorkflow.setInvoiceDate(LocalDate.now());

    return newWorkflow;
  }

}

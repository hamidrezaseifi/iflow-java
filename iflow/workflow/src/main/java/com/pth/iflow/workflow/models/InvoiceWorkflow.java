package com.pth.iflow.workflow.models;

import java.time.LocalDateTime;
import com.pth.iflow.common.enums.EInvoiceType;
import com.pth.iflow.common.enums.EWorkflowType;

public class InvoiceWorkflow extends Workflow {

  private String sender;

  private String registerNumber;

  private LocalDateTime invoceDate;

  private String partnerCode;

  private String vendorNumber;

  private String vendorName;

  private Boolean isDirectDebit;

  private EInvoiceType invoiceType;

  private LocalDateTime discountEnterDate;

  private Integer discountDeadline;

  private Double discountRate;

  private LocalDateTime discountDate;

  private Double paymentAmount;

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

  public LocalDateTime getInvoceDate() {
    return invoceDate;
  }

  public void setInvoceDate(final LocalDateTime invoceDate) {
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

  public Boolean getIsDirectDebit() {
    return isDirectDebit;
  }

  public void setIsDirectDebit(final Boolean isDirectDebit) {
    this.isDirectDebit = isDirectDebit;
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

  public LocalDateTime getDiscountEnterDate() {
    return discountEnterDate;
  }

  public void setDiscountEnterDate(final LocalDateTime discountEnterDate) {
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

  public LocalDateTime getDiscountDate() {
    return discountDate;
  }

  public void setDiscountDate(final LocalDateTime discountDate) {
    this.discountDate = discountDate;
  }

  public Double getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(final Double paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  @Override
  public EWorkflowType getWorkflowTypeEnum() {
    return EWorkflowType.INVOICE_WORKFLOW_TYPE;
  }

}

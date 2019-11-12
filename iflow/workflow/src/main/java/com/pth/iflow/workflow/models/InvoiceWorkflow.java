package com.pth.iflow.workflow.models;

import java.time.LocalDate;
import com.pth.iflow.common.enums.EInvoiceType;
import com.pth.iflow.common.enums.EWorkflowType;

public class InvoiceWorkflow extends Workflow {

  private String sender;

  private String registerNumber;

  private LocalDate invoceDate;

  private String partnerCode;

  private String vendorNumber;

  private String vendorName;

  private Boolean isDirectDebit;

  private EInvoiceType invoiceType;

  private LocalDate discountEnterDate;

  private Integer discountDeadline;

  private Double discountRate;

  private LocalDate discountDate;

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
  public EWorkflowType getWorkflowTypeEnum() {
    return EWorkflowType.INVOICE_WORKFLOW_TYPE;
  }

  @Override
  public String getWorkflowTypeIdentity() {
    return getWorkflowTypeEnum().getName();
  }

}

package com.pth.iflow.core.model.entity.workflow;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.pth.iflow.common.enums.EInvoiceType;

@Entity
@Table(name = "invoice_workflow")
public class InvoiceWorkflowEntity {

  @Id
  @Column(name = "workflow_id")
  private Long           workflowId;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "workflowId")
  private WorkflowEntity workflow;

  @Column(name = "sender")
  private String         sender;

  @Column(name = "ext_reg_number")
  private String         registerNumber;

  @Column(name = "invoce_date")
  private Date           invoceDate;

  @Column(name = "partner_code")
  private String         partnerCode;

  @Column(name = "vendor_number")
  private String         vendorNumber;

  @Column(name = "vendor_name")
  private String         vendorName;

  @Column(name = "direct_debit_permission")
  private Boolean        isDirectDebitPermission;

  @Column(name = "invoice_type")
  private Integer        invoiceType;

  @Column(name = "discount_enter")
  private Date           discountEnterDate;

  @Column(name = "discount_deadline")
  private Integer        discountDeadline;

  @Column(name = "discount_rate")
  private Double         discountRate;

  @Column(name = "discount_date")
  private Date           discountDate;

  @Column(name = "payment_amount")
  private Double         paymentAmount;

  public InvoiceWorkflowEntity() {

  }

  public Long getWorkflowId() {
    return workflowId;
  }

  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  public WorkflowEntity getWorkflow() {
    return workflow;
  }

  public void setWorkflow(final WorkflowEntity workflow) {
    this.workflow = workflow;
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

  public Date getInvoceDate() {
    return invoceDate;
  }

  public void setInvoceDate(final Date invoceDate) {
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

  public Integer getInvoiceType() {
    return invoiceType;
  }

  public EInvoiceType getInvoiceTypeEnum() {
    return EInvoiceType.ofValue(invoiceType);
  }

  public void setInvoiceType(final EInvoiceType invoiceType) {
    this.invoiceType = invoiceType.getValue();
  }

  public void setInvoiceType(final Integer invoiceType) {
    this.invoiceType = invoiceType;
  }

  public Date getDiscountEnterDate() {
    return discountEnterDate;
  }

  public void setDiscountEnterDate(final Date discountEnterDate) {
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

  public Date getDiscountDate() {
    return discountDate;
  }

  public void setDiscountDate(final Date discountDate) {
    this.discountDate = discountDate;
  }

  public Double getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(final Double paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public boolean isNew() {

    return workflow.isNew();
  }

  public void verifyVersion(final InvoiceWorkflowEntity exists) {
    workflow.verifyVersion(exists.getWorkflow());
  }

  public void updateFromExists(final InvoiceWorkflowEntity exists) {
    if (exists == null) {
      return;
    }

    this.workflow.updateFromExists(exists.workflow);

    this.discountDate = exists.discountDate;
    this.discountDeadline = exists.discountDeadline;
    this.discountEnterDate = exists.discountEnterDate;
    this.discountRate = exists.discountRate;
    this.invoceDate = exists.invoceDate;
    this.invoiceType = exists.invoiceType;
    this.isDirectDebitPermission = exists.isDirectDebitPermission;
    this.partnerCode = exists.partnerCode;
    this.paymentAmount = exists.paymentAmount;
    this.registerNumber = exists.registerNumber;
    this.sender = exists.sender;
    this.vendorName = exists.vendorName;
    this.vendorNumber = exists.vendorNumber;

  }
}

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
import com.pth.iflow.common.enums.EInvoiceType;
import com.pth.iflow.common.enums.EWorkflowType;

@XmlRootElement(name = "InvoiceWorkflow", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "Workflow" + IFlowJaxbDefinition.TYPE_PREFIX)
public class InvoiceWorkflowEdo extends WorkflowEdo {

  @NotNull(message = "Sender is not allowed to be null!")
  @XmlElement(name = "Sender", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String sender;

  @NotNull(message = "RegisterNumber is not allowed to be null!")
  @XmlElement(name = "RegisterNumber", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String registerNumber;

  @NotNull(message = "InvoceDate is not allowed to be null!")
  @XmlJavaTypeAdapter(LocalDateTimeEdoAdapter.class)
  @JsonFormat(pattern = IsoFormats.DATETIME_FORMAT_ISO)
  @XmlSchemaType(name = "dateTime")
  @XmlElement(name = "InvoceDate", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private LocalDateTime invoceDate;

  @NotNull(message = "PartnerCode is not allowed to be null!")
  @XmlElement(name = "PartnerCode", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String partnerCode;

  @NotNull(message = "VendorNumber is not allowed to be null!")
  @XmlElement(name = "VendorNumber", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String vendorNumber;

  @NotNull(message = "vendorName is not allowed to be null!")
  @XmlElement(name = "VendorName", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String vendorName;

  @NotNull(message = "IsDirectDebit is not allowed to be null!")
  @XmlElement(name = "IsDirectDebit", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Boolean isDirectDebit;

  @NotNull(message = "InvoiceType must not be null")
  @AEnumValueValidator(enumClazz = EInvoiceType.class)
  @XmlElement(name = "InvoiceType", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer invoiceType;

  @NotNull(message = "DiscountEnterDate is not allowed to be null!")
  @XmlJavaTypeAdapter(LocalDateTimeEdoAdapter.class)
  @JsonFormat(pattern = IsoFormats.DATETIME_FORMAT_ISO)
  @XmlSchemaType(name = "dateTime")
  @XmlElement(name = "DiscountEnterDate", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private LocalDateTime discountEnterDate;

  @NotNull(message = "DiscountDeadline is not allowed to be null!")
  @XmlElement(name = "DiscountDeadline", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer discountDeadline;

  @NotNull(message = "DiscountRate is not allowed to be null!")
  @XmlElement(name = "DiscountRate", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Double discountRate;

  @NotNull(message = "DiscountDate is not allowed to be null!")
  @XmlJavaTypeAdapter(LocalDateTimeEdoAdapter.class)
  @JsonFormat(pattern = IsoFormats.DATETIME_FORMAT_ISO)
  @XmlSchemaType(name = "dateTime")
  @XmlElement(name = "DiscountDate", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private LocalDateTime discountDate;

  @NotNull(message = "PaymentAmount is not allowed to be null!")
  @XmlElement(name = "PaymentAmount", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
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

  public Integer getInvoiceType() {
    return invoiceType;
  }

  public void setInvoiceType(final Integer invoiceType) {
    this.invoiceType = invoiceType;
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
  public String getWorkflowType() {
    return EWorkflowType.INVOICE_WORKFLOW_TYPE.getName();
  }

}

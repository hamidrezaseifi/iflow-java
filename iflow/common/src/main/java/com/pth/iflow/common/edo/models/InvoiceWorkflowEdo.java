package com.pth.iflow.common.edo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;
import com.pth.iflow.common.edo.models.base.IWorkflowBaseEdo;
import com.pth.iflow.common.edo.models.helper.IsoFormats;
import com.pth.iflow.common.edo.models.helper.LocalDateEdoAdapter;
import com.pth.iflow.common.edo.models.validation.AEnumValueValidator;
import com.pth.iflow.common.enums.EInvoiceType;
import com.pth.iflow.common.enums.EWorkflowType;

@XmlRootElement(name = "InvoiceWorkflow", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "InvoiceWorkflow" + IFlowJaxbDefinition.TYPE_PREFIX)
public class InvoiceWorkflowEdo implements IWorkflowBaseEdo {

  @NotNull(message = "Identity is not allowed to be null!")
  @XmlElement(name = "Identity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String identity;

  @XmlElement(name = "CurrentStepIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String currentStepIdentity;

  @XmlElement(name = "ControllerIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String controllerIdentity;

  @XmlElement(name = "CreatedByIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String createdByIdentity;

  @XmlElement(name = "Comments", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String comments;

  @NotNull(message = "Status is not allowed to be null!")
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer status;

  @NotNull(message = "Version is not allowed to be null!")
  @XmlElement(name = "Version", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer version;

  @NotNull(message = "WorkflowFileEdo is not allowed to be null!")
  @XmlElementWrapper(name = "WorkflowFileSet", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "WorkflowFile", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private List<WorkflowFileEdo> files = new ArrayList<>();

  @NotNull(message = "WorkflowActionSet is not allowed to be null!")
  @XmlElementWrapper(name = "WorkflowActionSet", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "WorkflowAction", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private List<WorkflowActionEdo> actions = new ArrayList<>();

  @NotNull(message = "Sender is not allowed to be null!")
  @XmlElement(name = "Sender", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String sender;

  @NotNull(message = "RegisterNumber is not allowed to be null!")
  @XmlElement(name = "RegisterNumber", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String registerNumber;

  @NotNull(message = "InvoceDate is not allowed to be null!")
  @XmlJavaTypeAdapter(LocalDateEdoAdapter.class)
  @JsonFormat(pattern = IsoFormats.DATE_FORMAT_ISO)
  @XmlSchemaType(name = "dateTime")
  @XmlElement(name = "InvoceDate", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private LocalDate invoceDate;

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
  private Boolean isDirectDebitPermission;

  @NotNull(message = "InvoiceType must not be null")
  @AEnumValueValidator(enumClazz = EInvoiceType.class)
  @XmlElement(name = "InvoiceType", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer invoiceType;

  @NotNull(message = "DiscountEnterDate is not allowed to be null!")
  @XmlJavaTypeAdapter(LocalDateEdoAdapter.class)
  @JsonFormat(pattern = IsoFormats.DATE_FORMAT_ISO)
  @XmlSchemaType(name = "dateTime")
  @XmlElement(name = "DiscountEnterDate", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private LocalDate discountEnterDate;

  @NotNull(message = "DiscountDeadline is not allowed to be null!")
  @XmlElement(name = "DiscountDeadline", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer discountDeadline;

  @NotNull(message = "DiscountRate is not allowed to be null!")
  @XmlElement(name = "DiscountRate", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Double discountRate;

  @NotNull(message = "DiscountDate is not allowed to be null!")
  @XmlJavaTypeAdapter(LocalDateEdoAdapter.class)
  @JsonFormat(pattern = IsoFormats.DATE_FORMAT_ISO)
  @XmlSchemaType(name = "dateTime")
  @XmlElement(name = "DiscountDate", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private LocalDate discountDate;

  @NotNull(message = "PaymentAmount is not allowed to be null!")
  @XmlElement(name = "PaymentAmount", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Double paymentAmount;

  public String getIdentity() {
    return this.identity;
  }

  public void setIdentity(final String identity) {
    this.identity = identity;
  }

  public String getCurrentStepIdentity() {
    return this.currentStepIdentity;
  }

  public void setCurrentStepIdentity(final String currentStepIdentity) {
    this.currentStepIdentity = currentStepIdentity;
  }

  public String getControllerIdentity() {
    return this.controllerIdentity;
  }

  public void setControllerIdentity(final String controllerIdentity) {
    this.controllerIdentity = controllerIdentity;
  }

  public String getCreatedByIdentity() {
    return this.createdByIdentity;
  }

  public void setCreatedByIdentity(final String createdByIdentity) {
    this.createdByIdentity = createdByIdentity;
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

  public List<WorkflowFileEdo> getFiles() {
    return this.files;
  }

  @JsonSetter
  public void setFiles(final List<WorkflowFileEdo> files) {
    this.files = new ArrayList<>();
    if (files != null) {
      this.files.addAll(files);
    }
  }

  public List<WorkflowActionEdo> getActions() {
    return this.actions;
  }

  @JsonSetter
  public void setActions(final List<WorkflowActionEdo> actions) {
    this.actions = new ArrayList<>();
    if (actions != null) {
      this.actions.addAll(actions);
    }
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

  public LocalDate getInvoceDate() {
    return this.invoceDate;
  }

  public void setInvoceDate(final LocalDate invoceDate) {
    this.invoceDate = invoceDate;
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

  public void setIsDirectDebitPermission(final Boolean isDirectDebit) {
    this.isDirectDebitPermission = isDirectDebit;
  }

  public Integer getInvoiceType() {
    return this.invoiceType;
  }

  public void setInvoiceType(final Integer invoiceType) {
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

  @Override
  public String getWorkflowType() {
    return EWorkflowType.INVOICE_WORKFLOW_TYPE.getName();
  }

}

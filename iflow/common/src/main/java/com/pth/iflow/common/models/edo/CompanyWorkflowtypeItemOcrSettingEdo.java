package com.pth.iflow.common.models.edo;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "CompanyWorkflowtypeItemOcrSetting", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "CompanyWorkflowtypeItemOcrSetting" + IFlowJaxbDefinition.TYPE_PREFIX)
public class CompanyWorkflowtypeItemOcrSettingEdo {

  @NotNull(message = "CompanyIdentity must not be null")
  @XmlElement(name = "CompanyIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String companyIdentity;

  @NotNull(message = "WorkflowTypeIdentity must not be null")
  @XmlElement(name = "WorkflowTypeIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String workflowTypeIdentity;

  @NotNull(message = "PropertyName must not be null")
  @XmlElement(name = "PropertyName", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String propertyName;

  @XmlElement(name = "Value", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String value;

  @NotNull
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer status;

  @NotNull
  @XmlElement(name = "Version", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer version;

  public String getCompanyIdentity() {

    return this.companyIdentity;
  }

  public void setCompanyIdentity(final String companyIdentity) {

    this.companyIdentity = companyIdentity;
  }

  public String getWorkflowTypeIdentity() {

    return this.workflowTypeIdentity;
  }

  public void setWorkflowTypeIdentity(final String workflowIdentity) {

    this.workflowTypeIdentity = workflowIdentity;
  }

  public String getPropertyName() {

    return this.propertyName;
  }

  public void setPropertyName(final String propertyName) {

    this.propertyName = propertyName;
  }

  public String getValue() {

    return this.value;
  }

  public void setValue(final String value) {

    this.value = value;
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

}

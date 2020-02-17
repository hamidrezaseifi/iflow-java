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

  @NotNull(message = "WorkflowIdentity must not be null")
  @XmlElement(name = "WorkflowIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String workflowIdentity;

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

  public String getWorkflowIdentity() {

    return this.workflowIdentity;
  }

  public void setWorkflowIdentity(final String workflowIdentity) {

    this.workflowIdentity = workflowIdentity;
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

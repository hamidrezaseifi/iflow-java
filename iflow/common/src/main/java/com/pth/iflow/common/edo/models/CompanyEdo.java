package com.pth.iflow.common.edo.models;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "Company", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "Company" + IFlowJaxbDefinition.TYPE_PREFIX)
public class CompanyEdo {

  @XmlElement(name = "ID", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long    id;

  @XmlElement(name = "IdentifyId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String  identifyid;

  @NotNull
  @XmlElement(name = "CompanyName", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String  companyName;

  @NotNull
  @XmlElement(name = "Status", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer status;

  @NotNull
  @XmlElement(name = "Version", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Integer version;

  public CompanyEdo() {

  }

  /**
   * @return the id
   */
  public Long getId() {
    return this.id;
  }

  /**
   * @param id the id to set
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * @return the identifyid
   */
  public String getIdentifyid() {
    return this.identifyid;
  }

  /**
   * @param identifyid the identifyid to set
   */
  public void setIdentifyid(final String identifyid) {
    this.identifyid = identifyid;
  }

  /**
   * @return the companyName
   */
  public String getCompanyName() {
    return this.companyName;
  }

  /**
   * @param companyName the companyName to set
   */
  public void setCompanyName(final String companyName) {
    this.companyName = companyName;
  }

  /**
   * @return the status
   */
  public Integer getStatus() {
    return this.status;
  }

  /**
   * @param status the status to set
   */
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

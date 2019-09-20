package com.pth.iflow.common.edo.models;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "UserAuthenticationRequest", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "UserAuthenticationRequest" + IFlowJaxbDefinition.TYPE_PREFIX)
public class UserAuthenticationRequestEdo {

  @NotNull
  @XmlElement(name = "Email", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String email;

  @NotNull
  @XmlElement(name = "Password", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String password;

  @NotNull
  @XmlElement(name = "CompanyIdentity", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String companyIdentity;

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getCompanyIdentity() {
    return this.companyIdentity;
  }

  public void setCompanyIdentity(final String companyIdentity) {
    this.companyIdentity = companyIdentity;
  }

}

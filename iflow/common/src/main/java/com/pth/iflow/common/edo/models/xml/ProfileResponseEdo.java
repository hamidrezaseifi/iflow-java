package com.pth.iflow.common.edo.models.xml;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "ProfileResponse", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "ProfileResponse" + IFlowJaxbDefinition.TYPE_PREFIX)
public class ProfileResponseEdo {

  @NotNull
  @XmlElement(name = "User", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private UserEdo    user;

  @NotNull
  @XmlElement(name = "Company", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private CompanyEdo company;

  @NotNull
  @XmlElement(name = "Sessionid", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String     sessionid;

  public ProfileResponseEdo() {
    this.user = null;
    this.company = null;
    this.sessionid = "";
  }

  public ProfileResponseEdo(final UserEdo user, final CompanyEdo company, final String sessionid) {
    this.user = user;
    this.company = company;
    this.sessionid = sessionid;
  }

  public UserEdo getUser() {
    return this.user;
  }

  public void setUser(final UserEdo user) {
    this.user = user;
  }

  public CompanyEdo getCompany() {
    return this.company;
  }

  public void setCompany(final CompanyEdo company) {
    this.company = company;
  }

  public String getSessionid() {
    return this.sessionid;
  }

  public void setSessionid(final String sessionid) {
    this.sessionid = sessionid;
  }

}

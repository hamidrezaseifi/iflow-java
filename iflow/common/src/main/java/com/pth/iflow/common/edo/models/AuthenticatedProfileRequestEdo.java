package com.pth.iflow.common.edo.models;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "AuthenticatedProfileRequest", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "AuthenticatedProfileRequest" + IFlowJaxbDefinition.TYPE_PREFIX)
public class AuthenticatedProfileRequestEdo {

  @NotNull
  @XmlElement(name = "Email", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String email;

  @NotNull
  @XmlElement(name = "Token", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String token;

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getToken() {
    return this.token;
  }

  public void setToken(final String token) {
    this.token = token;
  }

}

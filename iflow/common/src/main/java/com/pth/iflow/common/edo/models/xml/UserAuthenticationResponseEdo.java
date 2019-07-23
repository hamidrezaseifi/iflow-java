package com.pth.iflow.common.edo.models.xml;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "UserAuthenticationResponse", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "UserAuthenticationResponse" + IFlowJaxbDefinition.TYPE_PREFIX)
public class UserAuthenticationResponseEdo {

  @NotNull
  @XmlElement(name = "Email", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String email;

  @NotNull
  @XmlElement(name = "Token", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String token;

  @NotNull
  @XmlElement(name = "SessionId", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private String sessionid;

  @NotNull
  @XmlElement(name = "Created", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long   created;

  @NotNull
  @XmlElement(name = "LastAccess", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private Long   lastAccess;

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * @return the token
   */
  public String getToken() {
    return this.token;
  }

  /**
   * @param token the token to set
   */
  public void setToken(final String token) {
    this.token = token;
  }

  /**
   * @return the sessionid
   */
  public String getSessionid() {
    return this.sessionid;
  }

  /**
   * @param sessionid the sessionid to set
   */
  public void setSessionid(final String sessionid) {
    this.sessionid = sessionid;
  }

  /**
   * @return the created
   */
  public Long getCreated() {
    return this.created;
  }

  /**
   * @param created the created to set
   */
  public void setCreated(final Long created) {
    this.created = created;
  }

  /**
   * @return the lastAccess
   */
  public Long getLastAccess() {
    return this.lastAccess;
  }

  /**
   * @param lastAccess the lastAccess to set
   */
  public void setLastAccess(final Long lastAccess) {
    this.lastAccess = lastAccess;
  }

}

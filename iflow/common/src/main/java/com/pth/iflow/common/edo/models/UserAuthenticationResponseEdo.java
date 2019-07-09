package com.pth.iflow.common.edo.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserAuthenticationResponseEdo")
public class UserAuthenticationResponseEdo {

  @NotNull
  @XmlElement(name = "Email")
  private String        email;

  @NotNull
  @XmlElement(name = "Token")
  private String        token;

  @NotNull
  @XmlElement(name = "Sessionid")
  private String        sessionid;

  @NotNull
  @XmlElement(name = "Created")
  private LocalDateTime created;

  @NotNull
  @XmlElement(name = "LastAccess")
  private LocalDateTime lastAccess;

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * @return the token
   */
  public String getToken() {
    return token;
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
    return sessionid;
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
  public LocalDateTime getCreated() {
    return created;
  }

  /**
   * @param created the created to set
   */
  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  /**
   * @return the lastAccess
   */
  public LocalDateTime getLastAccess() {
    return lastAccess;
  }

  /**
   * @param lastAccess the lastAccess to set
   */
  public void setLastAccess(final LocalDateTime lastAccess) {
    this.lastAccess = lastAccess;
  }

}

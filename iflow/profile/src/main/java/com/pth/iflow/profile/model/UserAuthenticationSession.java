package com.pth.iflow.profile.model;

import java.util.Date;

import com.pth.iflow.common.edo.models.xml.UserAuthenticationResponseEdo;

public class UserAuthenticationSession {

  private String    email;
  private String    token;
  private String    sessionid;
  private Long      created;
  private Long      lastAccess;
  private final int ageLimit;
  private boolean   isFixedSession;

  public UserAuthenticationSession(final int ageLimit) {
    System.currentTimeMillis();

    this.created = System.currentTimeMillis();

    this.lastAccess = System.currentTimeMillis();
    this.ageLimit = ageLimit;
  }

  public String getEmail() {
    return this.email;
  }

  public UserAuthenticationSession setEmail(final String email) {
    this.email = email;
    return this;
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
  public UserAuthenticationSession setToken(final String token) {
    this.token = token;
    return this;
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
  public UserAuthenticationSession setSessionid(final String sessionid) {
    this.sessionid = sessionid;
    return this;
  }

  /**
   * @return the created
   */
  public Date getCreated() {
    return new Date(this.created);
  }

  /**
   * @param created the created to set
   */
  public void setCreated(final Date created) {
    this.created = created.getTime();
  }

  /**
   * @return the lastAccess
   */
  public Date getLastAccess() {
    return new Date(this.lastAccess);
  }

  /**
   * @return the isFixedSession
   */
  public boolean isFixedSession() {
    return this.isFixedSession;
  }

  /**
   * @param isFixedSession the isFixedSession to set
   */
  public void setFixedSession(final boolean isFixedSession) {
    this.isFixedSession = isFixedSession;
  }

  /**
   * update lastAccess
   *
   * @return the lastAccess
   */
  public Date update() {
    this.lastAccess = System.currentTimeMillis();
    return new Date(this.lastAccess);
  }

  /**
   * check the session timeout
   *
   * @return boolean
   */
  public boolean isValid() {
    return this.isFixedSession || isExpired();
  }

  private boolean isExpired() {
    return (this.lastAccess + (this.ageLimit * 1000)) > System.currentTimeMillis();
  }

  /**
   * @param lastAccess the lastAccess to set
   */
  public void setLastAccess(final Date lastAccess) {
    this.lastAccess = lastAccess.getTime();
  }

  public UserAuthenticationResponseEdo toEdo() {
    final UserAuthenticationResponseEdo edo = new UserAuthenticationResponseEdo();
    edo.setSessionid(this.sessionid);
    edo.setToken(this.token);
    edo.setEmail(this.email);
    edo.setCreated(this.created);
    edo.setLastAccess(this.lastAccess);

    return edo;
  }

}

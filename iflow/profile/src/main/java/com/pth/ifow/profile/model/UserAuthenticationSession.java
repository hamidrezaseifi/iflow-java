package com.pth.ifow.profile.model;

import java.time.LocalDateTime;

import com.pth.iflow.common.edo.models.xml.UserAuthenticationResponseEdo;

public class UserAuthenticationSession {
  private String email;
  private String token;
  private String sessionid;
  private LocalDateTime created;
  private LocalDateTime lastAccess;
  private final int ageLimit;

  public UserAuthenticationSession(final int ageLimit) {
    created = LocalDateTime.now();
    lastAccess = LocalDateTime.now();
    this.ageLimit = ageLimit;
  }

  public String getEmail() {
    return email;
  }

  public UserAuthenticationSession setEmail(final String email) {
    this.email = email;
    return this;
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
  public UserAuthenticationSession setToken(final String token) {
    this.token = token;
    return this;
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
  public UserAuthenticationSession setSessionid(final String sessionid) {
    this.sessionid = sessionid;
    return this;
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
   * update lastAccess
   *
   * @return the lastAccess
   */
  public LocalDateTime update() {
    lastAccess = LocalDateTime.now();
    return lastAccess;
  }

  /**
   * check the session timeout
   *
   * @return boolean
   */
  public boolean isValid() {
    return lastAccess.plusSeconds(ageLimit).isAfter(LocalDateTime.now());
  }

  /**
   * @param lastAccess the lastAccess to set
   */
  public void setLastAccess(final LocalDateTime lastAccess) {
    this.lastAccess = lastAccess;
  }

  public UserAuthenticationResponseEdo toEdo() {
    final UserAuthenticationResponseEdo edo = new UserAuthenticationResponseEdo();
    edo.setSessionid(sessionid);
    edo.setToken(token);
    edo.setEmail(email);
    edo.setCreated(created);
    edo.setLastAccess(lastAccess);

    return edo;
  }

}

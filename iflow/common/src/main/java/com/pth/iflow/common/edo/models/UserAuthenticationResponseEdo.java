package com.pth.iflow.common.edo.models;

import java.time.LocalDateTime;

public class UserAuthenticationResponseEdo {
  private UserEdo user;
  private CompanyEdo company;
  private String token;
  private String sessionid;
  private LocalDateTime created;
  private LocalDateTime lastAccess;

  /**
   * @return the user
   */
  public UserEdo getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(final UserEdo user) {
    this.user = user;
  }

  /**
   * @return the company
   */
  public CompanyEdo getCompany() {
    return company;
  }

  /**
   * @param company the company to set
   */
  public void setCompany(final CompanyEdo company) {
    this.company = company;
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

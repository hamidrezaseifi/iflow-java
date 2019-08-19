package com.pth.iflow.gui.models;

import com.pth.iflow.common.edo.models.xml.UserAuthenticationResponseEdo;

public class GuiUserAuthenticationResponse {

  private String email;

  private String token;

  private String sessionid;

  private Long   created;

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

  public UserAuthenticationResponseEdo toEdo() {
    final UserAuthenticationResponseEdo edo = new UserAuthenticationResponseEdo();
    edo.setCreated(this.created);
    edo.setEmail(this.email);
    edo.setLastAccess(this.lastAccess);
    edo.setSessionid(this.sessionid);
    edo.setToken(this.token);
    return edo;
  }

  public static GuiUserAuthenticationResponse fromEdo(final UserAuthenticationResponseEdo edo) {
    final GuiUserAuthenticationResponse model = new GuiUserAuthenticationResponse();
    model.setCreated(edo.getCreated());
    model.setEmail(edo.getEmail());
    model.setLastAccess(edo.getLastAccess());
    model.setSessionid(edo.getSessionid());
    model.setToken(edo.getToken());
    return model;
  }

}

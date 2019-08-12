package com.pth.iflow.backend.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class BackendAuthenticationToken extends UsernamePasswordAuthenticationToken {

  /**
   *
   */
  private static final long serialVersionUID = -7341854439748304108L;

  private final String username;
  private final String companyId;
  private final String token;
  private final String sessionId;

  public BackendAuthenticationToken(final String username, final String companyid, final String token, final String sessionid) {
    super(username, "fakepass");

    this.username = username;
    this.companyId = companyid;
    this.token = token;
    this.sessionId = sessionid;
  }

  @Override
  public Object getPrincipal() {
    return this.username;
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  /**
   * @return the username
   */
  public String getUsername() {
    return this.username;
  }

  /**
   * @return the companyId
   */
  public String getCompanyId() {
    return this.companyId;
  }

  /**
   * @return the token
   */
  public String getToken() {
    return this.token;
  }

  /**
   * @return the sessionId
   */
  public String getSessionId() {
    return this.sessionId;
  }
}

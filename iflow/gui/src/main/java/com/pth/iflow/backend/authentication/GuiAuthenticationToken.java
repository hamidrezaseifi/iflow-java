package com.pth.iflow.backend.authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class GuiAuthenticationToken extends UsernamePasswordAuthenticationToken {

  /**
   *
   */
  private static final long serialVersionUID = -7341854439748304108L;

  private final String                 username;
  private final String                 companyId;
  private final String                 token;
  private final String                 sessionId;
  private final List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

  public GuiAuthenticationToken(final String username, final String companyid, final String token, final String sessionid) {
    super(username, "fakepass");

    this.username = username;
    this.companyId = companyid;
    this.token = token;
    this.sessionId = sessionid;
  }

  public GuiAuthenticationToken(final String username,
                                    final String companyid,
                                    final String token,
                                    final String sessionid,
                                    final List<GrantedAuthority> grantedAuthorities) {
    super(username, "fakepass", grantedAuthorities);

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

  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    return this.grantedAuthorities;
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

  /**
   * @param grantedAuthorities the grantedAuthorities to set
   */
  public void setGrantedAuthorities(final List<GrantedAuthority> grantedAuthorities) {
    this.grantedAuthorities.clear();
    this.grantedAuthorities.addAll(grantedAuthorities);
  }

}

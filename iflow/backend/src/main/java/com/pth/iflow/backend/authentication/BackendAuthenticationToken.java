package com.pth.iflow.backend.authentication;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.pth.iflow.backend.models.BackendCompany;
import com.pth.iflow.backend.models.BackendUser;

public class BackendAuthenticationToken extends UsernamePasswordAuthenticationToken {

  /**
   *
   */
  private static final long    serialVersionUID = -7341854439748304108L;
  private final BackendUser    user;
  private final BackendCompany company;

  public BackendAuthenticationToken(final BackendUser user, final BackendCompany company) {
    super(user.getEmail(), "fakepass", user.getAuthorities());

    this.user = user;
    this.company = company;
  }

  public BackendUser getUser() {
    return this.user;
  }

  public BackendCompany getCompany() {
    return this.company;
  }

  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    return this.user.getAuthorities();
  }

  @Override
  public Object getPrincipal() {
    return this.user.getEmail();
  }

  @Override
  public Object getCredentials() {
    return null;
  }
}

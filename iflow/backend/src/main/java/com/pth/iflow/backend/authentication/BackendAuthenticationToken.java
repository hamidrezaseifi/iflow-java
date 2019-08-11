package com.pth.iflow.backend.authentication;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.pth.iflow.backend.models.ui.UiUser;

public class BackendAuthenticationToken extends UsernamePasswordAuthenticationToken {

  /**
   *
   */
  private static final long serialVersionUID = -7341854439748304108L;
  private final UiUser      user;

  public BackendAuthenticationToken(final UiUser user) {
    super(user.getEmail(), "fakepass", user.getAuthorities());

    this.user = user;
  }

  public UiUser getUser() {
    return this.user;
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

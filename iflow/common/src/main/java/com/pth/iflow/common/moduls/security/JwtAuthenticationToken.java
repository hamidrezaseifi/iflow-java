package com.pth.iflow.common.moduls.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

  public JwtAuthenticationToken(final Object principal, final String jwtToken) {

    super(principal,"");
    this.setDetails(jwtToken);
    // TODO Auto-generated constructor stub
  }

  public String getToken() {

    return this.getDetails().toString();
  }
}

package com.pth.iflow.common.moduls.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class JwtRestRemoteAuthenticationManager implements AuthenticationProvider {

  private final IJwtTokenProvider jwtTokenProvider;

  public JwtRestRemoteAuthenticationManager(@Autowired final IJwtTokenProvider jwtTokenProvider) {

    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

    if (authentication instanceof UsernamePasswordAuthenticationToken) {

      final String token = authentication.getDetails().toString();

      final UsernamePasswordAuthenticationToken tokenAuthentication = this.jwtTokenProvider.getAuthentication(token);

      SecurityContext ctx = SecurityContextHolder.getContext();
      if (ctx == null) {
        ctx = SecurityContextHolder.createEmptyContext();
      }

      ctx.setAuthentication(tokenAuthentication);

      return tokenAuthentication;
    }

    return null;

  }

  @Override
  public boolean supports(final Class<?> authentication) {

    return true;
  }
}

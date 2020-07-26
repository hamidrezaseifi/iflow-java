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

  private final IJwtRemoteTokenProvider jwtRemoteTokenProvider;

  public JwtRestRemoteAuthenticationManager(@Autowired final IJwtRemoteTokenProvider jwtRemoteTokenProvider) {

    this.jwtRemoteTokenProvider = jwtRemoteTokenProvider;
  }

  @Override
  public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

    if (authentication instanceof UsernamePasswordAuthenticationToken) {

      final String token = authentication.getDetails().toString();

      final UsernamePasswordAuthenticationToken tokenAuthentication = this.jwtRemoteTokenProvider.getAuthentication(token);

      if (tokenAuthentication != null) {
        SecurityContext ctx = SecurityContextHolder.getContext();
        if (ctx == null) {
          ctx = SecurityContextHolder.createEmptyContext();
        }

        ctx.setAuthentication(tokenAuthentication);
      }

      return tokenAuthentication;
    }

    return null;

  }

  @Override
  public boolean supports(final Class<?> authentication) {

    return true;
  }
}

package com.pth.iflow.common.moduls.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.GenericFilterBean;

public class JWTAuthorizationFilter extends GenericFilterBean {

  public JWTAuthorizationFilter() {

  }

  @Override
  public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain filterChain)
      throws IOException, ServletException {

    final String token = this.resolveToken((HttpServletRequest) req);
    if (token != null) {
      final Authentication auth = this.getAuthentication("temp", token);

      if (auth != null) {
        SecurityContextHolder.getContext().setAuthentication(auth);
      }
    }
    filterChain.doFilter(req, res);
  }

  public String resolveToken(final HttpServletRequest req) {

    final String bearerToken = req.getHeader("Authorization");
    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7, bearerToken.length());
    }
    return null;
  }

  public Authentication getAuthentication(final String userName, final String token) {

    final String[] roleArr = {};

    UserBuilder builder = null;

    builder = org.springframework.security.core.userdetails.User.withUsername(userName);
    builder.password(userName);
    builder.roles(roleArr);

    final UserDetails userDetails = builder.build();

    final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
        "");
    usernamePasswordAuthenticationToken.setDetails(token);

    return usernamePasswordAuthenticationToken;
  }

}

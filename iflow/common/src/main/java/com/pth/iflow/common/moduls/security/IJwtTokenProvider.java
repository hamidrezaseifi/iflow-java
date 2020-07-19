package com.pth.iflow.common.moduls.security;

import java.util.Date;
import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface IJwtTokenProvider {

  String createToken(String username, Set<Integer> roles);

  UsernamePasswordAuthenticationToken getAuthentication(String token);

  String getUsername(String token);

  Date getTokenExpireDate(String token);

  Date getTokenIssuedDate(String token);

  boolean validateToken(final String token);

}

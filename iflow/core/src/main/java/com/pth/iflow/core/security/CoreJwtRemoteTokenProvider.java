package com.pth.iflow.core.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.pth.iflow.common.moduls.security.IJwtRemoteTokenProvider;


public class CoreJwtRemoteTokenProvider implements IJwtRemoteTokenProvider {

  public CoreJwtRemoteTokenProvider() {

    // TODO Auto-generated constructor stub
  }

  @Override
  public UsernamePasswordAuthenticationToken getAuthentication(String token) {

    // TODO Auto-generated method stub
    return null;
  }

}

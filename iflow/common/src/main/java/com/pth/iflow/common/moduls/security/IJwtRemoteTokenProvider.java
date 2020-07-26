package com.pth.iflow.common.moduls.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface IJwtRemoteTokenProvider {

  UsernamePasswordAuthenticationToken getAuthentication(String token);

}

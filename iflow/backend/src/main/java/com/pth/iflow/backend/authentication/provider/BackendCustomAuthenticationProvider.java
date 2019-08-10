package com.pth.iflow.backend.authentication.provider;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.pth.iflow.backend.configurations.BackendConfiguration;

@Component
public class BackendCustomAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  BackendConfiguration backendConfiguration;

  @Autowired
  private IUserHandler userHandler;

  @PostConstruct
  private void init() {

  }

  @Override
  public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

    if (authentication instanceof UsernamePasswordAuthenticationToken
        && authentication.getDetails() instanceof FBUiAuthenticationDetails) {

      final String username = authentication.getName();
      final String password = authentication.getCredentials().toString();
      final String companyid = ((FBUiAuthenticationDetails) authentication.getDetails()).getCompanyid();

      final GuiUserFull authUser = this.userHandler.authenticateUser(username, password, companyid);

      if (authUser != null) {

        return new FBAuthenticationToken(authUser);
      }
    }

    return null;

  }

  @Override
  public boolean supports(final Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}

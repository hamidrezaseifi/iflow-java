package com.pth.iflow.backend.authentication.provider;

import java.net.MalformedURLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.pth.iflow.backend.authentication.BackendAuthenticationDetails;
import com.pth.iflow.backend.authentication.BackendAuthenticationToken;
import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.backend.models.UserAuthenticationResponse;
import com.pth.iflow.backend.services.IProfileValidator;

@Component
public class BackendCustomAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  private IProfileValidator profileValidator;

  @PostConstruct
  private void init() {

  }

  @Override
  public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

    if ((authentication instanceof UsernamePasswordAuthenticationToken)
        && (authentication.getDetails() instanceof BackendAuthenticationDetails)) {

      final String username = authentication.getName();
      final String password = authentication.getCredentials().toString();
      final String companyid = ((BackendAuthenticationDetails) authentication.getDetails()).getCompanyid();

      UserAuthenticationResponse authResponse = null;
      try {
        authResponse = this.profileValidator.authenticate(username, password, companyid);
      }
      catch (final BackendCustomizedException e) {

      }
      catch (final MalformedURLException e) {

      }

      if (authResponse != null) {

        return new BackendAuthenticationToken(username, companyid, authResponse.getToken(), authResponse.getSessionid());

      }
    }

    return null;

  }

  @Override
  public boolean supports(final Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}

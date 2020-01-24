package com.pth.iflow.gui.authentication.provider;

import java.net.MalformedURLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.authentication.GuiAuthenticationDetails;
import com.pth.iflow.gui.authentication.GuiAuthenticationToken;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.UserAuthenticationResponse;
import com.pth.iflow.gui.services.IProfileAccess;

@Component
public class GuiCustomAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  private IProfileAccess profileValidator;

  @PostConstruct
  private void init() {

  }

  @Override
  public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

    if ((authentication instanceof UsernamePasswordAuthenticationToken)
        && (authentication.getDetails() instanceof GuiAuthenticationDetails)) {

      final String username = authentication.getName();
      final String password = authentication.getCredentials().toString();
      final String companyid = ((GuiAuthenticationDetails) authentication.getDetails()).getCompanyid();

      UserAuthenticationResponse authResponse = null;
      try {
        authResponse = this.profileValidator.authenticate(username, password, companyid);
      }
      catch (final GuiCustomizedException e) {

      }
      catch (final MalformedURLException e) {

      }
      catch (final IFlowMessageConversionFailureException e) {

      }

      if (authResponse != null) {

        return new GuiAuthenticationToken(authResponse.getUserIdentity(), companyid, authResponse.getToken(), authResponse.getSessionid());

      }
    }

    return null;

  }

  @Override
  public boolean supports(final Class<?> authentication) {

    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}

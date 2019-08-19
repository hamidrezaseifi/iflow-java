package com.pth.iflow.backend.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.pth.iflow.backend.configurations.BackendSecurityConfigurations;

@Component
public class BackendAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response,
      final AuthenticationException ex) throws IOException, ServletException {
    final String url = BackendAuthenticationErrorUrlCreator.getErrorUrl("auth",
        request.getParameter(BackendSecurityConfigurations.USERNAME_FIELD_NAME),
        request.getParameter(BackendSecurityConfigurations.PASSWORD_FIELD_NAME),
        request.getParameter(BackendSecurityConfigurations.COMPANYID_FIELD_NAME));

    this.getRedirectStrategy().sendRedirect(request, response, url);
  }

}

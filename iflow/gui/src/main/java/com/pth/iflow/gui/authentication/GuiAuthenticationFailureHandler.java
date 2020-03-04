package com.pth.iflow.gui.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.pth.iflow.gui.configurations.GuiSecurityConfigurations;

@Component
public class GuiAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response,
      final AuthenticationException ex) throws IOException, ServletException {

    final String url = GuiAuthenticationErrorUrlCreator
        .getErrorUrl("auth",
            request.getParameter(GuiSecurityConfigurations.USERNAME_FIELD_NAME),
            request.getParameter(GuiSecurityConfigurations.PASSWORD_FIELD_NAME),
            request.getParameter(GuiSecurityConfigurations.COMPANYID_FIELD_NAME));

    this.getRedirectStrategy().sendRedirect(request, response, url);
  }

}

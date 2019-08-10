package com.pth.iflow.backend.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.pth.iflow.backend.configurations.BackendSecurityConfigurations;

@Component
public class BackendAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Autowired
  private BackendSessionUserService sessionUserService;

  @Override
  public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication auth)
      throws IOException, ServletException {

    if (auth instanceof BackendAuthenticationToken == true) {

      final BackendAuthenticationToken tbToken = (BackendAuthenticationToken) auth;

      String url = BackendSecurityConfigurations.ROOT_URL;

      if (tbToken.getUser().isEnabled() == false) {
        url = BackendAuthenticationErrorUrlCreator.getErrorUrl("access",
            request.getParameter(BackendSecurityConfigurations.USERNAME_FIELD_NAME),
            request.getParameter(BackendSecurityConfigurations.PASSWORD_FIELD_NAME),
            request.getParameter(BackendSecurityConfigurations.COMPANYID_FIELD_NAME));
      } else {

        if (this.sessionUserService.authorizeUser(tbToken, request.getSession(), true) == null) {

          url = BackendAuthenticationErrorUrlCreator.getErrorUrl("access",
              request.getParameter(BackendSecurityConfigurations.USERNAME_FIELD_NAME),
              request.getParameter(BackendSecurityConfigurations.PASSWORD_FIELD_NAME),
              request.getParameter(BackendSecurityConfigurations.COMPANYID_FIELD_NAME));
        }

        if (tbToken.getDetails() instanceof BackendAuthenticationDetails) {
          final String companyid = ((BackendAuthenticationDetails) tbToken.getDetails()).getCompanyid();
          final Cookie companyIndCookie = new Cookie(BackendSecurityConfigurations.COMPANYINDICATOR_COOKIE_KEY, companyid);
          companyIndCookie.setMaxAge(10 * 365 * 24 * 60 * 60);
          response.addCookie(companyIndCookie);
        }

      }

      this.getRedirectStrategy().sendRedirect(request, response, url);
    }

  }

}

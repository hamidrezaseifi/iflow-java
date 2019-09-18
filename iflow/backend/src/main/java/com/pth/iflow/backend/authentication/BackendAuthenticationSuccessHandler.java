package com.pth.iflow.backend.authentication;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.pth.iflow.backend.configurations.BackendSecurityConfigurations;
import com.pth.iflow.backend.models.BackendCompanyProfile;
import com.pth.iflow.backend.models.BackendUser;
import com.pth.iflow.backend.models.ProfileResponse;
import com.pth.iflow.backend.services.IProfileAccess;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;

@Component
public class BackendAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Autowired
  private BackendSessionUserService sessionUserService;

  @Autowired
  private IProfileAccess profileValidator;

  @Override
  public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication auth) throws IOException, ServletException {

    if ((auth instanceof BackendAuthenticationToken) == true) {

      final BackendAuthenticationToken tbToken = (BackendAuthenticationToken) auth;

      String url = BackendSecurityConfigurations.ROOT_URL;

      ProfileResponse profileResponse = null;
      try {
        profileResponse = this.profileValidator.readProfile(tbToken.getUsername(), tbToken.getToken());
      }
      catch (IFlowMessageConversionFailureException | MalformedURLException e) {
      }

      if (profileResponse == null) {
      }
      else {

        final BackendUser user = profileResponse.getUser();
        final BackendCompanyProfile companyProfile = profileResponse.getCompanyProfile();

        final BackendAuthenticationToken newToken = new BackendAuthenticationToken(tbToken.getUsername(),
                                                                                   tbToken.getCompanyId(),
                                                                                   tbToken.getToken(),
                                                                                   tbToken.getSessionId(),
                                                                                   user.getAuthorities());

        if (user.isEnabled() == false) {
          url = BackendAuthenticationErrorUrlCreator.getErrorUrl("access",
                                                                 request.getParameter(BackendSecurityConfigurations.USERNAME_FIELD_NAME),
                                                                 request.getParameter(BackendSecurityConfigurations.PASSWORD_FIELD_NAME),
                                                                 request.getParameter(BackendSecurityConfigurations.COMPANYID_FIELD_NAME));
        }
        else {

          if (this.sessionUserService.authorizeUser(newToken, user, companyProfile, request.getSession(), true) == null) {

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
      }

      this.getRedirectStrategy().sendRedirect(request, response, url);
    }

  }

}

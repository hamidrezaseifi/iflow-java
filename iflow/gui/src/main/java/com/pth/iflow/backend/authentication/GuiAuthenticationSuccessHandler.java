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

import com.pth.iflow.backend.configurations.GuiSecurityConfigurations;
import com.pth.iflow.backend.exceptions.GuiCustomizedException;
import com.pth.iflow.backend.models.GuiCompanyProfile;
import com.pth.iflow.backend.models.GuidUser;
import com.pth.iflow.backend.models.ProfileResponse;
import com.pth.iflow.backend.services.IProfileAccess;

@Component
public class GuiAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Autowired
  private GuiSessionUserService sessionUserService;

  @Autowired
  private IProfileAccess         profileValidator;

  @Override
  public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication auth)
      throws IOException, ServletException {

    if ((auth instanceof GuiAuthenticationToken) == true) {

      final GuiAuthenticationToken tbToken = (GuiAuthenticationToken) auth;

      String url = GuiSecurityConfigurations.ROOT_URL;

      ProfileResponse profileResponse = null;
      try {
        profileResponse = this.profileValidator.readProfile(tbToken.getUsername(), tbToken.getToken());
      } catch (GuiCustomizedException | MalformedURLException e) {
      }

      if (profileResponse == null) {
      } else {

        final GuidUser user = profileResponse.getUser();
        final GuiCompanyProfile companyProfile = profileResponse.getCompanyProfile();

        final GuiAuthenticationToken newToken = new GuiAuthenticationToken(tbToken.getUsername(), tbToken.getCompanyId(),
            tbToken.getToken(), tbToken.getSessionId(), user.getAuthorities());

        if (user.isEnabled() == false) {
          url = GuiAuthenticationErrorUrlCreator.getErrorUrl("access",
              request.getParameter(GuiSecurityConfigurations.USERNAME_FIELD_NAME),
              request.getParameter(GuiSecurityConfigurations.PASSWORD_FIELD_NAME),
              request.getParameter(GuiSecurityConfigurations.COMPANYID_FIELD_NAME));
        } else {

          if (this.sessionUserService.authorizeUser(newToken, user, companyProfile, request.getSession(), true) == null) {

            url = GuiAuthenticationErrorUrlCreator.getErrorUrl("access",
                request.getParameter(GuiSecurityConfigurations.USERNAME_FIELD_NAME),
                request.getParameter(GuiSecurityConfigurations.PASSWORD_FIELD_NAME),
                request.getParameter(GuiSecurityConfigurations.COMPANYID_FIELD_NAME));
          }

          if (tbToken.getDetails() instanceof GuiAuthenticationDetails) {
            final String companyid = ((GuiAuthenticationDetails) tbToken.getDetails()).getCompanyid();
            final Cookie companyIndCookie = new Cookie(GuiSecurityConfigurations.COMPANYINDICATOR_COOKIE_KEY, companyid);
            companyIndCookie.setMaxAge(10 * 365 * 24 * 60 * 60);
            response.addCookie(companyIndCookie);
          }

        }
      }

      this.getRedirectStrategy().sendRedirect(request, response, url);
    }

  }

}

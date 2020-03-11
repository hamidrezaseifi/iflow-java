package com.pth.iflow.gui.authentication;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.configurations.GuiSecurityConfigurations;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.ProfileResponse;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.services.IProfileAccess;
import com.pth.iflow.gui.services.IWorkflowMessageHanlder;

@Component
public class GuiAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  private static final Logger logger = LoggerFactory.getLogger(GuiAuthenticationSuccessHandler.class);

  @Autowired
  private GuiSessionUserService sessionUserService;

  @Autowired
  private IProfileAccess profileValidator;

  @Autowired
  private IWorkflowMessageHanlder workflowMessageHanlder;

  @Override
  public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication auth)
      throws IOException, ServletException {

    if ((auth instanceof GuiAuthenticationToken) == true) {

      final GuiAuthenticationToken tbToken = (GuiAuthenticationToken) auth;

      String url = request.getParameter("returnUrl");

      ProfileResponse profileResponse = null;
      try {
        profileResponse = this.profileValidator.readProfile(tbToken.getIdentity(), tbToken.getToken());
      }
      catch (GuiCustomizedException | MalformedURLException | IFlowMessageConversionFailureException e) {
        logger.error("Error in reading user profile.", e);

      }

      if (profileResponse == null) {
      }
      else {

        final User user = profileResponse.getUser();

        final GuiAuthenticationToken newToken = new GuiAuthenticationToken(tbToken.getIdentity(), tbToken.getCompanyId(),
            tbToken.getToken(), tbToken.getSessionId(), user.getAuthorities());

        if (user.isEnabled() == false) {
          url = GuiAuthenticationErrorUrlCreator
              .getErrorUrl("access",
                  request.getParameter(GuiSecurityConfigurations.USERNAME_FIELD_NAME),
                  request.getParameter(GuiSecurityConfigurations.PASSWORD_FIELD_NAME),
                  request.getParameter(GuiSecurityConfigurations.COMPANYID_FIELD_NAME));
        }
        else {

          if (this.sessionUserService.authorizeUser(newToken, profileResponse, request.getSession(), true) == null) {

            url = GuiAuthenticationErrorUrlCreator
                .getErrorUrl("access",
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

      try {
        this.workflowMessageHanlder.callUserMessageReset(false);
      }
      catch (GuiCustomizedException | IFlowMessageConversionFailureException e) {
        logger.error("Error in calling user message reset in profile.", e);
      }

      this.getRedirectStrategy().sendRedirect(request, response, url);
    }

  }

}

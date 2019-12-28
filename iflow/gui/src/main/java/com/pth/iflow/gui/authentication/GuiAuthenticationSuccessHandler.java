package com.pth.iflow.gui.authentication;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.configurations.GuiSecurityConfigurations;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.CompanyProfile;
import com.pth.iflow.gui.models.ProfileResponse;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.services.IMessagesHelper;
import com.pth.iflow.gui.services.IProfileAccess;

@Component
public class GuiAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  private static final Logger logger = LoggerFactory.getLogger(GuiAuthenticationSuccessHandler.class);

  @Autowired
  private GuiSessionUserService sessionUserService;

  @Autowired
  private IProfileAccess profileValidator;

  @Autowired
  private IMessagesHelper messages;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication auth)
      throws IOException, ServletException {

    if ((auth instanceof GuiAuthenticationToken) == true) {

      final GuiAuthenticationToken tbToken = (GuiAuthenticationToken) auth;

      ProfileResponse profileResponse = null;
      try {
        profileResponse = this.profileValidator.readProfile(tbToken.getUsername(), tbToken.getToken());
      }
      catch (GuiCustomizedException | MalformedURLException | IFlowMessageConversionFailureException e) {
        logger.error("Error in reading user profile.", e);

      }

      final Map<String, Object> data = new HashMap<>();
      data.put("timestamp", Calendar.getInstance().getTime());
      data.put("exception", "");
      data.put("message", "");
      data.put("res", "ok");
      data.put("user", null);

      if (profileResponse == null) {
        data.put("exception", "no response");
        data.put("message", this.messages.get("common.invalidlogin"));
        data.put("res", "failed");

      }
      else {

        final User user = profileResponse.getUser();
        final CompanyProfile companyProfile = profileResponse.getCompanyProfile();

        final GuiAuthenticationToken newToken = new GuiAuthenticationToken(tbToken.getUsername(), tbToken.getCompanyId(),
            tbToken.getToken(), tbToken.getSessionId(), user.getAuthorities());

        if (user.isEnabled() == false) {

          data.put("exception", "user disabled");
          data.put("message", this.messages.get("common.noaccesssite"));
          data.put("res", "failed");
        }
        else {

          if (this.sessionUserService.authorizeUser(newToken, user, companyProfile, request.getSession(), true) == null) {

            data.put("exception", "not authorized");
            data.put("message", this.messages.get("common.noaccesssite"));
            data.put("res", "failed");
          }

          if (tbToken.getDetails() instanceof GuiAuthenticationDetails) {
            final String companyid = ((GuiAuthenticationDetails) tbToken.getDetails()).getCompanyid();
            final Cookie companyIndCookie = new Cookie(GuiSecurityConfigurations.COMPANYINDICATOR_COOKIE_KEY, companyid);
            companyIndCookie.setMaxAge(10 * 365 * 24 * 60 * 60);
            response.addCookie(companyIndCookie);
            data.put("res", "ok");
            data.put("user", user);
          }

        }
      }

      response.getOutputStream().println(this.objectMapper.writeValueAsString(data));

    }

  }

}

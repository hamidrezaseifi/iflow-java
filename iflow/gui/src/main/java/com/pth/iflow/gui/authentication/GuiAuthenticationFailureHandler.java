package com.pth.iflow.gui.authentication;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pth.iflow.gui.configurations.GuiSecurityConfigurations;
import com.pth.iflow.gui.services.IMessagesHelper;

@Component
public class GuiAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  @Autowired
  private IMessagesHelper messages;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException ex) throws IOException, ServletException {
    final String url = GuiAuthenticationErrorUrlCreator.getErrorUrl("auth",
                                                                    request.getParameter(GuiSecurityConfigurations.USERNAME_FIELD_NAME),
                                                                    request.getParameter(GuiSecurityConfigurations.PASSWORD_FIELD_NAME),
                                                                    request.getParameter(GuiSecurityConfigurations.COMPANYID_FIELD_NAME));

    final Map<String, Object> data = new HashMap<>();
    data.put("timestamp", Calendar.getInstance().getTime());
    data.put("exception", ex.getMessage());
    data.put("message", this.messages.get("common.invalidlogin"));
    data.put("res", "failed");

    response.getOutputStream().println(objectMapper.writeValueAsString(data));

    // this.getRedirectStrategy().sendRedirect(request, response, url);
  }

}

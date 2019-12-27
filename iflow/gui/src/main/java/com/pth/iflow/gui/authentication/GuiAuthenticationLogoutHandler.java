package com.pth.iflow.gui.authentication;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class GuiAuthenticationLogoutHandler implements LogoutSuccessHandler {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public void onLogoutSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication)
      throws IOException, ServletException {
    // TODO Auto-generated method stub

    final Map<String, Object> data = new HashMap<>();
    data.put("timestamp", Calendar.getInstance().getTime());
    data.put("exception", "");
    data.put("message", "");
    data.put("res", "ok");
    data.put("user", null);

    response.getOutputStream().println(this.objectMapper.writeValueAsString(data));
  }

}

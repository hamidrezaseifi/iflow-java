package com.pth.iflow.gui.controller.page;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.gui.configurations.GuiSecurityConfigurations;
import com.pth.iflow.gui.services.IMessagesHelper;

/**
 * controller class to manage rest api for static page lihe home ans about and ...
 *
 * @author rezasei
 *
 */
@Controller
@RequestMapping(path = "/auth")
public class AuthenticationController {

  @Autowired
  private IMessagesHelper messages;

  @GetMapping("/login")
  public String showLogin(@CookieValue(
      value = GuiSecurityConfigurations.COMPANYINDICATOR_COOKIE_KEY, defaultValue = ""
  ) final String companyIndicator, final Model model, final HttpServletRequest request) throws ServletException, UnsupportedEncodingException {

    return "ang/index";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = "/testloginmsg", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public Map<String, String> testLoginMsg() {

    final Map<String, String> data = new HashMap<>();
    data.put("timestamp", Calendar.getInstance().getTime().toString());
    data.put("exception", "exxxxxx");
    data.put("message", "mmmmmmmmmmmmm");
    data.put("res", "failed");

    return data;
  }

}

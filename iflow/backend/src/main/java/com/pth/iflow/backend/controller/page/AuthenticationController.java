package com.pth.iflow.backend.controller.page;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pth.iflow.backend.authentication.BackendAuthenticationErrorUrlCreator;
import com.pth.iflow.backend.configurations.BackendSecurityConfigurations;
import com.pth.iflow.backend.services.impl.MessagesHelper;

/**
 * controller class to manage rest api for static page lihe home ans about and
 * ...
 *
 * @author rezasei
 *
 */
@Controller
@RequestMapping(path = "/auth")
public class AuthenticationController {

  @Autowired
  private MessagesHelper messages;

  @GetMapping("/login")
  public String showLogin(
      @CookieValue(value = BackendSecurityConfigurations.COMPANYINDICATOR_COOKIE_KEY, defaultValue = "") final String companyIndicator,
      final Model model, final HttpServletRequest request) throws ServletException, UnsupportedEncodingException {

    String message = "";
    String username = "";
    String company = companyIndicator;
    final String password = "";

    if (request.getParameter("error") != null) {

      final Map<String, String> params = BackendAuthenticationErrorUrlCreator.decodeErrorUrl(request.getParameter("error"));

      if (params.get("err").equals("auth")) {
        message = this.messages.get("common.invalidlogin");
      }
      if (params.get("err").equals("access")) {
        message = this.messages.get("common.noaccesssite");
      }

      username = params.get("u");
      company = params.get("c");
      // no password in error url // password = params.get("u");

    }

    model.addAttribute("username", username);
    model.addAttribute("password", password);
    model.addAttribute("companyid", company);

    model.addAttribute("logginMessage", message);
    model.addAttribute("rooturl", BackendSecurityConfigurations.ROOT_URL);

    return "auth/login";
  }

}
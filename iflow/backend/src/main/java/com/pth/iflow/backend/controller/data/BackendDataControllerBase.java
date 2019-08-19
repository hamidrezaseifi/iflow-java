package com.pth.iflow.backend.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pth.iflow.backend.configurations.BackendSecurityConfigurations;
import com.pth.iflow.backend.models.BackendCompany;
import com.pth.iflow.backend.models.BackendUser;
import com.pth.iflow.backend.models.ui.BackendSessionUserInfo;

@Controller
public class BackendDataControllerBase {

  @Autowired
  private BackendSessionUserInfo sessionUserInfo;

  protected String getCurrentRelativeUrl() {
    ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
    final String root = builder.build().toUriString();
    builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
    String path = builder.build().toUriString();
    path = path.replace(root, "");

    return path;
  }

  @ModelAttribute
  public void addAttributes(final Model model, final HttpSession session, final HttpServletResponse response,
      final HttpServletRequest request) throws Exception {

    if (this.sessionUserInfo == null || !this.sessionUserInfo.isValid()) {
      response.sendRedirect(BackendSecurityConfigurations.LOGIN_URL);

    }

  }

  protected BackendSessionUserInfo getSessionUserInfo() {

    return this.sessionUserInfo;
  }

  protected BackendUser getLoggedUser() {

    return this.sessionUserInfo.getUser();
  }

  protected BackendCompany getLoggedCompany() {

    return this.sessionUserInfo.getCompanyProfile().getCompany();
  }

  protected String getLoggedToken() {

    return this.sessionUserInfo.getToken();
  }

  protected String getLoggedSessionId() {

    return this.sessionUserInfo.getSessionId();
  }

}

package com.pth.iflow.gui.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.pth.iflow.gui.configurations.GuiSecurityConfigurations;
import com.pth.iflow.gui.models.GuiCompany;
import com.pth.iflow.gui.models.GuiUser;
import com.pth.iflow.gui.models.ui.GuiSessionUserInfo;
import com.pth.iflow.gui.services.IWorkflowMessageHanlder;

@Controller
public class GuiDataControllerBase {

  @Autowired
  private GuiSessionUserInfo sessionUserInfo;

  @Autowired
  private IWorkflowMessageHanlder workflowMessageHanlder;

  protected String getCurrentRelativeUrl() {
    ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
    final String root = builder.build().toUriString();
    builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
    String path = builder.build().toUriString();
    path = path.replace(root, "");

    return path;
  }

  @ModelAttribute
  public void addAttributes(final Model model, final HttpSession session, final HttpServletResponse response, final HttpServletRequest request) throws Exception {

    if (this.sessionUserInfo == null || !this.sessionUserInfo.isValid()) {
      response.sendRedirect(GuiSecurityConfigurations.LOGIN_URL);

    }

  }

  protected GuiSessionUserInfo getSessionUserInfo() {

    return this.sessionUserInfo;
  }

  protected GuiUser getLoggedUser() {

    return this.sessionUserInfo.getUser();
  }

  protected GuiCompany getLoggedCompany() {

    return this.sessionUserInfo.getCompanyProfile().getCompany();
  }

  protected String getLoggedToken() {

    return this.sessionUserInfo.getToken();
  }

  protected String getLoggedSessionId() {

    return this.sessionUserInfo.getSessionId();
  }

  public IWorkflowMessageHanlder getWorkflowMessageHanlder() {
    return workflowMessageHanlder;
  }

}

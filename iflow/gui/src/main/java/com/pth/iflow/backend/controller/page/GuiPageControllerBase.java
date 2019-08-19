package com.pth.iflow.backend.controller.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pth.iflow.backend.configurations.GuiSecurityConfigurations;
import com.pth.iflow.backend.models.GuiCompany;
import com.pth.iflow.backend.models.GuiUser;
import com.pth.iflow.backend.models.ui.GuiSessionUserInfo;
import com.pth.iflow.backend.models.ui.UiMenuItem;
import com.pth.iflow.backend.services.IBreadCrumbLoader;
import com.pth.iflow.backend.services.UiMenuService;

@Controller
public class GuiPageControllerBase {

  @Autowired
  private IBreadCrumbLoader      breadCrumbLoader;

  @Autowired
  private UiMenuService          menuService;

  @Autowired
  private GuiSessionUserInfo sessionUserInfo;

  protected List<UiMenuItem> getMenus() {
    return this.menuService.getAllMenus();

  }

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
      response.sendRedirect(GuiSecurityConfigurations.LOGIN_URL);

    }

    final String currentRelatedUrl = this.getCurrentRelativeUrl();

    model.addAttribute("pageMenuList", this.getMenus());
    model.addAttribute("breadCrumb", this.breadCrumbLoader.getBreadCrumbList(currentRelatedUrl));
    model.addAttribute("isLogged", this.getSessionUserInfo().isLoggedIn());
    model.addAttribute("loggedUser", this.getSessionUserInfo());

    model.addAttribute("url", currentRelatedUrl);

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

}

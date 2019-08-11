package com.pth.iflow.backend.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pth.iflow.backend.models.ui.UiMenuItem;
import com.pth.iflow.backend.models.ui.UiSessionUserInfo;
import com.pth.iflow.backend.models.ui.UiUser;
import com.pth.iflow.backend.models.ui.enums.EUiUserRole;
import com.pth.iflow.backend.services.IBreadCrumbLoader;
import com.pth.iflow.backend.services.UiMenuService;

@Controller
public class UiControllerBase {

  @Autowired
  private IBreadCrumbLoader breadCrumbLoader;

  @Autowired
  private UiMenuService     menuService;

  private UiSessionUserInfo sessionUserInfo = null;

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

    final String currentRelatedUrl = this.getCurrentRelativeUrl();

    model.addAttribute("pageMenuList", this.getMenus());
    model.addAttribute("breadCrumb", this.breadCrumbLoader.getBreadCrumbList(currentRelatedUrl));
    model.addAttribute("isLogged", true);
    model.addAttribute("loggedUser", this.getSessionUserInfo());

    model.addAttribute("url", currentRelatedUrl);

  }

  protected UiSessionUserInfo getSessionUserInfo() {
    if (this.sessionUserInfo == null) {
      final UiUser user = UiUser.generateTestUser("test", "fname", "lname", Arrays.asList(EUiUserRole.ADMIN, EUiUserRole.VIEWER));
      this.sessionUserInfo = new UiSessionUserInfo(user);
    }

    return this.sessionUserInfo;
  }

}

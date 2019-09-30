package com.pth.iflow.gui.controller.page;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.pth.iflow.gui.configurations.GuiSecurityConfigurations;
import com.pth.iflow.gui.controller.GuiLogedControllerBase;
import com.pth.iflow.gui.models.ui.UiMenuItem;
import com.pth.iflow.gui.services.IBreadCrumbLoader;
import com.pth.iflow.gui.services.UiMenuService;

@Controller
public class GuiPageControllerBase extends GuiLogedControllerBase {

  @Autowired
  private IBreadCrumbLoader breadCrumbLoader;

  @Autowired
  private UiMenuService menuService;

  protected List<UiMenuItem> getMenus() {
    return this.menuService.getAllMenus();

  }

  @Override
  protected String getCurrentRelativeUrl() {
    ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
    final String root = builder.build().toUriString();
    builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
    String path = builder.build().toUriString();
    path = path.replace(root, "");

    return path;
  }

  @Override
  @ModelAttribute
  public void addAttributes(final Model model, final HttpSession session, final HttpServletResponse response, final HttpServletRequest request) throws Exception {

    if (this.getSessionUserInfo() == null || !this.getSessionUserInfo().isValid()) {
      response.sendRedirect(GuiSecurityConfigurations.LOGIN_URL);

    }

    final String currentRelatedUrl = this.getCurrentRelativeUrl();

    model.addAttribute("pageMenuList", this.getMenus());
    model.addAttribute("breadCrumb", this.breadCrumbLoader.getBreadCrumbList(currentRelatedUrl));
    model.addAttribute("isLogged", this.getSessionUserInfo().isLoggedIn());
    model.addAttribute("loggedUser", this.getSessionUserInfo());

    model.addAttribute("url", currentRelatedUrl);

  }

}

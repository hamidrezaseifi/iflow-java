package com.pth.iflow.gui.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pth.iflow.gui.controller.GuiLogedControllerBase;
import com.pth.iflow.gui.exceptions.GuiSessionException;

@Controller
public class GuiDataControllerBase extends GuiLogedControllerBase {

  @Override
  protected String getCurrentRelativeUrl() {
    ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
    final String                root    = builder.build().toUriString();
    builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
    String path = builder.build().toUriString();
    path = path.replace(root, "");

    return path;
  }

  @ModelAttribute
  public void addAttributes(final Model model, final HttpSession session, final HttpServletResponse response, final HttpServletRequest request)
      throws Exception {

    if (this.getSessionUserInfo() == null || !this.getSessionUserInfo().isValid()) {
      throw new GuiSessionException("Not logged in!");

    }

  }

}

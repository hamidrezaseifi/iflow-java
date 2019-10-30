package com.pth.iflow.gui.controller.exception;

import java.util.List;

import javax.servlet.RequestDispatcher;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.models.ui.UiMenuItem;
import com.pth.iflow.gui.services.IBreadCrumbLoader;
import com.pth.iflow.gui.services.UiMenuService;

@Controller
@ControllerAdvice
public class GlobalExceptionHandler /* implements ErrorController */ {

  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @Autowired
  private IBreadCrumbLoader   breadCrumbLoader;

  @Autowired
  private UiMenuService       menuService;

  @Autowired
  private SessionUserInfo  sessionUserInfo;

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

  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseStatus(HttpStatus.OK)
  public ModelAndView handleNoHandlerFoundException(final Model model, final NoHandlerFoundException ex) {

    this.prepareViewModel(model);

    return new ModelAndView("/site/invalid-request", "exceptionMsg", "NoHandlerFoundException msg: " + ex.toString());
  }

  @ExceptionHandler(GuiCustomizedException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public GuiCustomizedException handleGuiCustomizedException(final Model model, final GuiCustomizedException ex) {

    return ex;
  }

  // @RequestMapping("/error")
  public String handleError(final Model model, final HttpServletRequest request) {
    final Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    final Object fwuri = request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);

    String viewName = "site/invalid-request";
    if (status != null) {
      final Integer statusCode = Integer.valueOf(status.toString());
      if (statusCode == 404) {
        viewName = "site/invalid-request";
      }
    }

    this.prepareViewModel(model);

    return viewName;
  }

  // @Override
  public String getErrorPath1() {
    return "/error";
  }

  private void prepareViewModel(final Model model) {
    final String currentRelatedUrl = this.getCurrentRelativeUrl();

    model.addAttribute("pageMenuList", this.getMenus());
    model.addAttribute("breadCrumb", this.breadCrumbLoader.getBreadCrumbList(currentRelatedUrl));
    model.addAttribute("isLogged", this.sessionUserInfo.isLoggedIn());
    model.addAttribute("loggedUser", this.sessionUserInfo);

    model.addAttribute("url", currentRelatedUrl);
  }

}

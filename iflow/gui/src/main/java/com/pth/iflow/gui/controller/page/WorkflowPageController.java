package com.pth.iflow.gui.controller.page;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.gui.exceptions.GuiCustomizedException;

@Controller
@RequestMapping(value = "/workflow")
public class WorkflowPageController extends GuiPageControllerBase {

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/", "/list" })
  public String showWorkflowList(final Model model) throws GuiCustomizedException, MalformedURLException {

    return "workflow/index";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/create" })
  public String showWorkflowCreate(final Model model) throws GuiCustomizedException, MalformedURLException {

    return "workflow/create";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/edit/{workflowId}" })
  public String showWorkflowEdit(final Model model,
                                 @PathVariable(required = false) final Long workflowId,
                                 final HttpServletResponse response) throws GuiCustomizedException,
                                                                     IOException {

    final Long iWorkflowId = (workflowId != null) && (workflowId > 0) ? workflowId : 0;
    if (iWorkflowId == 0) {
      response.sendRedirect("/site/invalid-request");
    }

    model.addAttribute("workflowId", iWorkflowId);
    return "workflow/edit";
  }

}

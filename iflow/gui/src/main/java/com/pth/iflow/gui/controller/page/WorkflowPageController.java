package com.pth.iflow.gui.controller.page;

import java.net.MalformedURLException;

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
  public String showWorkflowEdit(final Model model, @PathVariable final Long workflowId) throws GuiCustomizedException,
                                                                                         MalformedURLException {

    model.addAttribute("workflowId", workflowId);
    return "workflow/edit";
  }

}

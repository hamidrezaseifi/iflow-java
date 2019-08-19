package com.pth.iflow.backend.controller.page;

import java.net.MalformedURLException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.backend.exceptions.BackendCustomizedException;

@Controller
@RequestMapping(value = "/workflow")
public class WorkflowController extends BackendPageControllerBase {

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/", "/list" })
  public String list(final Model model) throws BackendCustomizedException, MalformedURLException {

    return "workflow/index";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/create" })
  public String showWorkflowCreate(final Model model) throws BackendCustomizedException, MalformedURLException {

    return "workflow/create";
  }

}

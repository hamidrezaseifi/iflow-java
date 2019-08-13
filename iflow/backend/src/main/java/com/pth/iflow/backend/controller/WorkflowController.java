package com.pth.iflow.backend.controller;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.backend.models.WorkflowType;
import com.pth.iflow.backend.services.IWorkflowAccess;

@Controller
@RequestMapping(value = "/workflow")
public class WorkflowController extends BackendControllerBase {

  @Autowired
  private IWorkflowAccess workflowAccess;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/", "/list" })
  public String list(final Model model) throws BackendCustomizedException, MalformedURLException {

    final List<WorkflowType> workflowTypeList = this.workflowAccess.readWorkflowTypeList(this.getLoggedCompany().getId(),
                                                                                         this.getLoggedToken());

    model.addAttribute("workflowTypeList", workflowTypeList);

    return "workflow/index";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/create" })
  public String showWorkflowCreate(final Model model) throws BackendCustomizedException, MalformedURLException {

    final List<WorkflowType> workflowTypeList = this.workflowAccess.readWorkflowTypeList(this.getLoggedCompany().getId(),
                                                                                         this.getLoggedToken());

    model.addAttribute("workflowTypeList", workflowTypeList);

    return "workflow/create";
  }

}

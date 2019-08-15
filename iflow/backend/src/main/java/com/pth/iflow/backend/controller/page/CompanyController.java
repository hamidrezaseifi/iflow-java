package com.pth.iflow.backend.controller.page;

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
import com.pth.iflow.backend.models.BackendWorkflowType;
import com.pth.iflow.backend.services.IWorkflowAccess;

@Controller
@RequestMapping(value = "/companies")
public class CompanyController extends BackendPageControllerBase {

  @Autowired
  private IWorkflowAccess workflowAccess;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/", "/list" })
  public String list() {

    return "company/index";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/workflowtype" })
  public String showWorkflowTypeList(final Model model) throws BackendCustomizedException, MalformedURLException {

    final List<BackendWorkflowType> workflowTypeList = this.workflowAccess.readWorkflowTypeList(this.getLoggedCompany().getId(),
        this.getLoggedToken());

    model.addAttribute("workflowTypeList", workflowTypeList);

    return "company/workflowtype";
  }

}
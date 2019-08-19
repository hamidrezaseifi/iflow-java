package com.pth.iflow.gui.controller.page;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.services.IWorkflowAccess;

@Controller
@RequestMapping(value = "/companies")
public class CompanyController extends GuiPageControllerBase {

  @Autowired
  private IWorkflowAccess workflowAccess;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/", "/list" })
  public String list() {

    return "company/index";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/workflowtype" })
  public String showWorkflowTypeList(final Model model) throws GuiCustomizedException, MalformedURLException {

    final List<GuiWorkflowType> workflowTypeList = this.workflowAccess.readWorkflowTypeList(this.getLoggedCompany().getId());

    model.addAttribute("workflowTypeList", workflowTypeList);

    return "company/workflowtype";
  }

}

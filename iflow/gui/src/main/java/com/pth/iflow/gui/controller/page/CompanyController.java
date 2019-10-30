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

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.services.IWorkflowHandler;

@Controller
@RequestMapping(value = "/companies")
public class CompanyController extends GuiPageControllerBase {

  @Autowired
  private IWorkflowHandler workflowHandler;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/", "/list", "index" })
  public String showCompanyIndex() {

    return "company/index";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/workflowtype" })
  public String showWorkflowTypeList(final Model model)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<WorkflowType> workflowTypeList = this.workflowHandler.readWorkflowTypeList(this.getLoggedCompany().getIdentity());

    model.addAttribute("workflowTypeList", workflowTypeList);

    return "company/workflowtype";
  }

}

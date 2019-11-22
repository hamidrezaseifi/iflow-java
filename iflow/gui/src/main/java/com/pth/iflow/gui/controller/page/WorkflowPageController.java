package com.pth.iflow.gui.controller.page;

import java.net.MalformedURLException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
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
  public String showCreateWorkflow(final Model model, @PathVariable(required = false) final String workflowTypeIdentity)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    model.addAttribute("UserAssign", EAssignType.USER.getIdentity());
    model.addAttribute("DepartmentAssign", EAssignType.DEPARTMENT.getIdentity());
    model.addAttribute("DepartmentGroupAssign", EAssignType.DEPARTMENTGROUP.getIdentity());
    model.addAttribute("WorkflowTyoeList", this.getAllWorkflowTypes());

    if (StringUtils.isEmpty(workflowTypeIdentity)) {
      return "workflow/create";
    } else {
      return this.getWorkflowTypeByIdentity(workflowTypeIdentity).getSteps().get(0).getViewName();
    }

  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/invalid-message" })
  public String showInvalidMessage(final Model model) throws GuiCustomizedException, MalformedURLException {

    return "workflow/invalid-message";
  }

}

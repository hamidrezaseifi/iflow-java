package com.pth.iflow.backend.controller;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.backend.models.BackendUser;
import com.pth.iflow.backend.models.BackendWorkflowType;
import com.pth.iflow.backend.services.IUserAccess;
import com.pth.iflow.backend.services.IWorkflowAccess;

@Controller
@RequestMapping(value = "/workflow")
public class WorkflowController extends BackendControllerBase {

  @Autowired
  private IWorkflowAccess workflowAccess;

  @Autowired
  private IUserAccess userAccess;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/", "/list" })
  public String list(final Model model) throws BackendCustomizedException, MalformedURLException {

    final List<BackendWorkflowType> workflowTypeList = this.workflowAccess.readWorkflowTypeList(this.getLoggedCompany().getId(),
                                                                                                this.getLoggedToken());

    model.addAttribute("workflowTypeList", workflowTypeList);

    return "workflow/index";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/create" })
  public String showWorkflowCreate(final Model model) throws BackendCustomizedException, MalformedURLException {

    final List<BackendWorkflowType> workflowTypeList = this.workflowAccess.readWorkflowTypeList(this.getLoggedCompany().getId(),
                                                                                                this.getLoggedToken());

    model.addAttribute("workflowTypeList", workflowTypeList);

    return "workflow/create";
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/data/workflowtypes" })
  @ResponseBody
  public List<BackendWorkflowType> listWorkflowtypes() throws BackendCustomizedException, MalformedURLException {

    final List<BackendWorkflowType> workflowTypeList = this.workflowAccess.readWorkflowTypeList(this.getLoggedCompany().getId(),
                                                                                                this.getLoggedToken());

    return workflowTypeList;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/data/companyusers" })
  @ResponseBody
  public List<BackendUser> listCompanyUsers() throws BackendCustomizedException, MalformedURLException {

    final List<BackendUser> userList = this.userAccess.readCompanyUserList(this.getLoggedCompany().getId(),
                                                                           this.getLoggedToken());

    return userList;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/data/workflowcreate/init" })
  @ResponseBody
  public Map<String, Object> loadWorkflowCreateData() throws BackendCustomizedException, MalformedURLException {

    final Map<String, Object> map = new HashMap<>();

    final List<BackendUser> userList = this.userAccess.readCompanyUserList(this.getLoggedCompany().getId(),
                                                                           this.getLoggedToken());
    final List<BackendWorkflowType> workflowTypeList = this.workflowAccess.readWorkflowTypeList(this.getLoggedCompany().getId(),
                                                                                                this.getLoggedToken());

    map.put("users", userList);
    map.put("workflowTypes", workflowTypeList);

    return map;
  }

}

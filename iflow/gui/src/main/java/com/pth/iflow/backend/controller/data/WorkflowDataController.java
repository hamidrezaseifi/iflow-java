package com.pth.iflow.backend.controller.data;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.backend.exceptions.GuiCustomizedException;
import com.pth.iflow.backend.models.GuidUser;
import com.pth.iflow.backend.models.GuiWorkflow;
import com.pth.iflow.backend.models.GuiWorkflowCreateRequest;
import com.pth.iflow.backend.models.GuiWorkflowType;
import com.pth.iflow.backend.services.IUserAccess;
import com.pth.iflow.backend.services.IWorkflowAccess;
import com.pth.iflow.common.enums.EWorkflowStatus;

@Controller
@RequestMapping(value = "/workflow/data")
public class WorkflowDataController extends GuiDataControllerBase {

  @Autowired
  private IWorkflowAccess workflowAccess;

  @Autowired
  private IUserAccess     userAccess;

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowtypes" })
  @ResponseBody
  public List<GuiWorkflowType> listWorkflowtypes() throws GuiCustomizedException, MalformedURLException {

    final List<GuiWorkflowType> workflowTypeList = this.workflowAccess.readWorkflowTypeList(this.getLoggedCompany().getId());

    return workflowTypeList;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/companyusers" })
  @ResponseBody
  public List<GuidUser> listCompanyUsers() throws GuiCustomizedException, MalformedURLException {

    final List<GuidUser> userList = this.userAccess.readCompanyUserList(this.getLoggedCompany().getId());

    return userList;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowcreate/init" })
  @ResponseBody
  public Map<String, Object> loadWorkflowCreateData() throws GuiCustomizedException, MalformedURLException {

    final Map<String, Object> map = new HashMap<>();

    final List<GuidUser> userList = this.userAccess.readCompanyUserList(this.getLoggedCompany().getId());
    final List<GuiWorkflowType> workflowTypeList = this.workflowAccess.readWorkflowTypeList(this.getLoggedCompany().getId());

    final GuiWorkflow newWorkflow = new GuiWorkflow();
    newWorkflow.setStatus(EWorkflowStatus.INITIALIZE);
    newWorkflow.setAssignTo(0L);
    newWorkflow.setCreatedBy(this.getLoggedUser().getId());
    newWorkflow.setController(0L);
    newWorkflow.setCurrentStepId(0L);
    newWorkflow.setId(0L);
    newWorkflow.setTitle("");
    newWorkflow.setVersion(0);
    newWorkflow.setWorkflowTypeId(0L);
    newWorkflow.setComments("");

    final GuiWorkflowCreateRequest workflowReq = new GuiWorkflowCreateRequest(newWorkflow);

    map.put("users", userList);
    map.put("workflowTypes", workflowTypeList);
    map.put("workflowCreateRequest", workflowReq);

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowcreate/create" })
  @ResponseBody
  public void createWorkflow(@RequestBody final GuiWorkflowCreateRequest createRequest)
      throws GuiCustomizedException, MalformedURLException {

    this.workflowAccess.createWorkflow(createRequest);

  }

}

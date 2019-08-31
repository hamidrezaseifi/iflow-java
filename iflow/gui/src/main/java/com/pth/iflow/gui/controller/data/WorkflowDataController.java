package com.pth.iflow.gui.controller.data;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiUser;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowCreateRequest;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.services.IUserAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;

@Controller
@RequestMapping(value = "/workflow/data")
public class WorkflowDataController extends GuiDataControllerBase {

  @Autowired
  private IWorkflowHandler workflowHandler;

  @Autowired
  private IUserAccess      userAccess;

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowlist/init" })
  @ResponseBody
  public Map<String, Object> loadWorkflowInitialData() throws GuiCustomizedException, MalformedURLException {

    final Map<String, Object> map = new HashMap<>();

    final List<GuiWorkflowType> workflowTypeList = this.workflowHandler.readWorkflowTypeList(this.getLoggedCompany().getId());
    final GuiWorkflowSearchFilter workflowSearchFilter = GuiWorkflowSearchFilter.generateNew();

    map.put("workflowTypes", workflowTypeList);
    map.put("newSearchFilter", workflowSearchFilter);

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowlist/search" })
  @ResponseBody
  public List<GuiWorkflow> searchWorkflows(@RequestBody final GuiWorkflowSearchFilter workflowSearchFilter)
      throws GuiCustomizedException, MalformedURLException {

    if (workflowSearchFilter.isMeAssigned()) {
      workflowSearchFilter.setAssignedUserIdList(Arrays.asList(this.getLoggedUser().getId()));
    }

    final List<GuiWorkflow> workflowList = this.workflowHandler.searchWorkflow(workflowSearchFilter);

    return workflowList;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/companyusers" })
  @ResponseBody
  public List<GuiUser> listCompanyUsers() throws GuiCustomizedException, MalformedURLException {

    final List<GuiUser> userList = this.userAccess.getCompanyUserList(this.getLoggedCompany().getId());

    return userList;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowcreate/init" })
  @ResponseBody
  public Map<String, Object> loadWorkflowCreateData() throws GuiCustomizedException, MalformedURLException {

    final Map<String, Object> map = new HashMap<>();

    final List<GuiUser> userList = this.userAccess.getCompanyUserList(this.getLoggedCompany().getId());
    final List<GuiWorkflowType> workflowTypeList = this.workflowHandler.readWorkflowTypeList(this.getLoggedCompany().getId());

    final GuiWorkflow newWorkflow = GuiWorkflow.generateInitial(this.getLoggedUser().getId());

    final GuiWorkflowCreateRequest workflowReq = new GuiWorkflowCreateRequest(newWorkflow);

    map.put("users", userList);
    map.put("workflowTypes", workflowTypeList);
    map.put("workflowCreateRequest", workflowReq);

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflow/edit/{workflowId}" })
  @ResponseBody
  public Map<String, Object> loadWorkflowEditData(@PathVariable final Long workflowId)
      throws GuiCustomizedException, MalformedURLException {

    final Map<String, Object> map = new HashMap<>();

    final List<GuiUser> userList = this.userAccess.getCompanyUserList(this.getLoggedCompany().getId());

    final GuiWorkflow workflow = this.workflowHandler.readWorkflow(workflowId);

    final GuiWorkflowType workflowType = this.getSessionUserInfo().getWorkflowTypeById(workflow.getWorkflowTypeId());

    map.put("users", userList);
    map.put("workflow", workflow);
    map.put("workflowType", workflowType);

    return map;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/workflowcreate/create" })
  @ResponseBody
  public void createWorkflow(@RequestBody final GuiWorkflowCreateRequest createRequest)
      throws GuiCustomizedException, MalformedURLException {

    this.workflowHandler.createWorkflow(createRequest);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/workflow/save" })
  @ResponseBody
  public void saveWorkflow(@RequestBody final GuiWorkflow workflow) throws GuiCustomizedException, MalformedURLException {
    workflow.getActiveAction().setStatus(EWorkflowActionStatus.SAVING_REQUEST);
    workflow.getActiveAction().setNewStep(workflow.getCurrentStepId());

    this.workflowHandler.saveWorkflow(workflow);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/workflow/archive" })
  @ResponseBody
  public void archiveWorkflow(@RequestBody final GuiWorkflow workflow) throws GuiCustomizedException, MalformedURLException {
    workflow.getActiveAction().setStatus(EWorkflowActionStatus.DONE_REQUEST);
    workflow.getActiveAction().setNewStep(workflow.getCurrentStepId());
    workflow.getActions().remove(workflow.getActiveAction());
    workflow.setStatus(EWorkflowStatus.ARCHIVED);

    this.workflowHandler.saveWorkflow(workflow);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/workflow/done" })
  @ResponseBody
  public void makeDoneWorkflow(@RequestBody final GuiWorkflow workflow) throws GuiCustomizedException, MalformedURLException {
    workflow.getActiveAction().setStatus(EWorkflowActionStatus.DONE_REQUEST);
    workflow.getActiveAction().setNewStep(workflow.getCurrentStepId());

    this.workflowHandler.saveWorkflow(workflow);

  }

}

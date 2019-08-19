package com.pth.iflow.gui.controller.data;

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

import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowCreateRequest;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.models.GuiUser;
import com.pth.iflow.gui.services.IUserAccess;
import com.pth.iflow.gui.services.IWorkflowAccess;
import com.pth.iflow.common.enums.EWorkflowStatus;

@Controller
@RequestMapping(value = "/workflow/data")
public class WorkflowDataController extends GuiDataControllerBase {

  @Autowired
  private IWorkflowAccess workflowAccess;

  @Autowired
  private IUserAccess userAccess;

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowlist/init" })
  @ResponseBody
  public Map<String, Object> loadWorkflowInitialData() throws GuiCustomizedException, MalformedURLException {

    final Map<String, Object> map = new HashMap<>();

    final List<GuiWorkflowType> workflowTypeList = this.workflowAccess.readWorkflowTypeList(this.getLoggedCompany().getId());
    final GuiWorkflowSearchFilter workflowSearchFilter = new GuiWorkflowSearchFilter();

    map.put("workflowTypes", workflowTypeList);
    map.put("newSearchFilter", workflowSearchFilter);

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowlist/search" })
  @ResponseBody
  public List<GuiWorkflow> searchWorkflows(@RequestBody final GuiWorkflowSearchFilter workflowSearchFilter) throws GuiCustomizedException,
                                                                                                            MalformedURLException {

    final List<GuiWorkflow> workflowList = this.workflowAccess.searchWorkflow(workflowSearchFilter);

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
                                                                                        throws GuiCustomizedException,
                                                                                        MalformedURLException {

    this.workflowAccess.createWorkflow(createRequest);

  }

}

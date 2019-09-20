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
import com.pth.iflow.backend.models.BackendUser;
import com.pth.iflow.backend.models.BackendWorkflow;
import com.pth.iflow.backend.models.BackendWorkflowCreateRequest;
import com.pth.iflow.backend.models.BackendWorkflowType;
import com.pth.iflow.backend.services.IUserAccess;
import com.pth.iflow.backend.services.IWorkflowAccess;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;

@Controller
@RequestMapping(value = "/workflow/data")
public class WorkflowDataController extends BackendDataControllerBase {

  @Autowired
  private IWorkflowAccess workflowAccess;

  @Autowired
  private IUserAccess userAccess;

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowtypes" })
  @ResponseBody
  public List<BackendWorkflowType> listWorkflowtypes() throws IFlowMessageConversionFailureException, MalformedURLException {

    final List<BackendWorkflowType> workflowTypeList = this.workflowAccess.readWorkflowTypeList(this.getLoggedCompany().getId());

    return workflowTypeList;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/companyusers" })
  @ResponseBody
  public List<BackendUser> listCompanyUsers() throws IFlowMessageConversionFailureException, MalformedURLException {

    final List<BackendUser> userList = this.userAccess.readCompanyUserList(this.getLoggedCompany().getId());

    return userList;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowcreate/init" })
  @ResponseBody
  public Map<String, Object> loadWorkflowCreateData() throws IFlowMessageConversionFailureException, MalformedURLException {

    final Map<String, Object> map = new HashMap<>();

    final List<BackendUser> userList = this.userAccess.readCompanyUserList(this.getLoggedCompany().getId());
    final List<BackendWorkflowType> workflowTypeList = this.workflowAccess.readWorkflowTypeList(this.getLoggedCompany().getId());

    final BackendWorkflow newWorkflow = new BackendWorkflow();
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

    final BackendWorkflowCreateRequest workflowReq = new BackendWorkflowCreateRequest(newWorkflow);

    map.put("users", userList);
    map.put("workflowTypes", workflowTypeList);
    map.put("workflowCreateRequest", workflowReq);

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowcreate/create" })
  @ResponseBody
  public void createWorkflow(@RequestBody final BackendWorkflowCreateRequest createRequest) throws IFlowMessageConversionFailureException, MalformedURLException {

    this.workflowAccess.createWorkflow(createRequest);

  }

}

package com.pth.iflow.gui.controller.data.workflow;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.controller.data.GuiDataControllerBase;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.CompanyWorkflowTypeController;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.IWorkflowSaveRequest;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IWorkflowHandler;

@Controller
public abstract class WorkflowDataControllerBase<W extends IWorkflow, WS extends IWorkflowSaveRequest<W>> extends GuiDataControllerBase {

  @Autowired
  private IWorkflowHandler<W, WS> workflowHandler;

  @Autowired
  protected IUploadFileManager uploadFileManager;

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/initcreate" })
  @ResponseBody
  public Map<String, Object> loadWorkflowCreateData()
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();

    final W newWorkflow = this.generateInitialWorkflow(this.getLoggedUser().getIdentity());

    this.setWorkflowController(newWorkflow);

    final WS workflowReq = this
        .generateInitialWorkflowSaveRequest(newWorkflow,
            newWorkflow.getHasActiveAction() ? newWorkflow.getActiveAction().getCurrentStep().getExpireDays() : 15);

    map.put("workflowSaveRequest", workflowReq);

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/initedit/{workflowIdentity}" })
  @ResponseBody
  public Map<String, Object> loadWorkflowEditData(@PathVariable final String workflowIdentity)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();

    final W workflow = this.workflowHandler.readWorkflow(workflowIdentity);

    final Integer expireDays = workflow.getHasActiveAction() ? workflow.getActiveAction().getCurrentStep().getExpireDays() : 0;

    final WS saveRequest = this.generateInitialWorkflowSaveRequest(workflow, expireDays);

    this.setWorkflowController(workflow);

    map.put("workflowSaveRequest", saveRequest);

    return map;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/create" })
  @ResponseBody
  public List<W> createWorkflow(@RequestBody final WS createRequest, final HttpSession session)
      throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {

    createRequest.getWorkflow().setCompanyIdentity(this.getLoggedCompany().getIdentity());

    this.setWorkflowController(createRequest.getWorkflow());

    return this.workflowHandler.createWorkflow(createRequest);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/save" })
  @ResponseBody
  public void saveWorkflow(@RequestBody final WS saveRequest, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    saveRequest.getWorkflow().setCompanyIdentity(this.getLoggedCompany().getIdentity());

    this.setWorkflowController(saveRequest.getWorkflow());

    this.workflowHandler.saveWorkflow(saveRequest);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/archive" })
  @ResponseBody
  public void archiveWorkflow(@RequestBody final W workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    this.setWorkflowController(workflow);

    this.workflowHandler.archiveWorkflow(workflow);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/done" })
  @ResponseBody
  public void makeDoneWorkflow(@RequestBody final WS saveRequest, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    saveRequest.getWorkflow().setCompanyIdentity(this.getLoggedCompany().getIdentity());

    this.setWorkflowController(saveRequest.getWorkflow());

    this.workflowHandler.doneWorkflow(saveRequest);

  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/assign/{workflowIdentity}" })
  @ResponseBody
  public W assignWorkflow(@PathVariable final String workflowIdentity)
      throws GuiCustomizedException, IFlowMessageConversionFailureException, IOException {

    final W workflow = this.workflowHandler.assignWorkflow(workflowIdentity);

    this.setWorkflowController(workflow);

    return workflow;
  }

  private void setWorkflowController(final W newWorkflow) {

    final List<CompanyWorkflowTypeController> workflowTypeControllers = this
        .getSessionUserInfo()
        .getControllerForWorkflowType(newWorkflow.getWorkflowTypeIdentity());

    if (workflowTypeControllers == null || workflowTypeControllers.isEmpty()) {
      throw new GuiCustomizedException("Invalid-Company-Setting:Workflow-Controller-Not-Found!");
    }

    newWorkflow.setControllerIdentity(workflowTypeControllers.get(0).getUserIdentity());
  }

  protected abstract W generateInitialWorkflow(String userIdentity);

  protected abstract WS generateInitialWorkflowSaveRequest(W workflow, int expireDays);

}

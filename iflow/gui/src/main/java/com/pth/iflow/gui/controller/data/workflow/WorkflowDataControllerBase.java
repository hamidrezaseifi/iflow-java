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
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.IWorkflowSaveRequest;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IUserAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;

@Controller
public abstract class WorkflowDataControllerBase<W extends IWorkflow, WS extends IWorkflowSaveRequest<W>> extends GuiDataControllerBase {

  @Autowired
  private IWorkflowHandler<W, WS> workflowHandler;

  @Autowired
  private IUserAccess userAccess;

  @Autowired
  protected IUploadFileManager uploadFileManager;

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/initcreate" })
  @ResponseBody
  public Map<String, Object> loadWorkflowCreateData()
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();

    final W newWorkflow = this.generateInitialWorkflow(this.getLoggedUser().getIdentity());

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

    map.put("workflowSaveRequest", saveRequest);

    return map;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/create" })
  @ResponseBody
  public List<W> createWorkflow(@RequestBody final WS createRequest, final HttpSession session)
      throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {

    return this.workflowHandler.createWorkflow(createRequest);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/save" })
  @ResponseBody
  public void saveWorkflow(@RequestBody final W workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    this.workflowHandler.saveWorkflow(workflow);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/archive" })
  @ResponseBody
  public void archiveWorkflow(@RequestBody final W workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    this.workflowHandler.archiveWorkflow(workflow);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/done" })
  @ResponseBody
  public void makeDoneWorkflow(@RequestBody final WS saveRequest, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    this.workflowHandler.doneWorkflow(saveRequest);

  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/assign/{workflowIdentity}" })
  @ResponseBody
  public W assignWorkflow(@PathVariable final String workflowIdentity)
      throws GuiCustomizedException, IFlowMessageConversionFailureException, IOException {

    final W workflow = this.workflowHandler.assignWorkflow(workflowIdentity);

    return workflow;
  }

  protected abstract W generateInitialWorkflow(String userIdentity);

  protected abstract WS generateInitialWorkflowSaveRequest(W workflow, int expireDays);

}

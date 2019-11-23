package com.pth.iflow.gui.controller.data.workflow;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.rest.IflowRestPaths.GuiModule;
import com.pth.iflow.gui.controller.data.GuiDataControllerBase;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.services.IWorkflowSearchAccess;

@Controller
@RequestMapping(value = GuiModule.WORKFLOWGENERAL_DATA_BASE)
public abstract class WorkflowSearchController extends GuiDataControllerBase {

  @Autowired
  private IWorkflowSearchAccess workflowSearchAccess;

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/search" })
  @ResponseBody
  public List<W> searchWorkflows(@RequestBody final WorkflowSearchFilter workflowSearchFilter)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    if (workflowSearchFilter.isMeAssigned()) {
      workflowSearchFilter.addAssignedUserIdentity(this.getLoggedUser().getIdentity());
    }

    final List<W> workflowList = this.workflowSearchAccess.searchWorkflow(workflowSearchFilter);

    return workflowList;
  }

}

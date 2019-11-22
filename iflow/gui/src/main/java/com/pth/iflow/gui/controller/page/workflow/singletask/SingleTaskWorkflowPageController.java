package com.pth.iflow.gui.controller.page.workflow.singletask;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pth.iflow.common.rest.IflowRestPaths.GuiModule;
import com.pth.iflow.gui.controller.page.workflow.WorkflowPageControllerBase;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflowSaveRequest;

@Controller
@RequestMapping(value = GuiModule.SINGLETASKWORKFLOW_PAGE_BASE)
public class SingleTaskWorkflowPageController extends WorkflowPageControllerBase<SingleTaskWorkflow, SingleTaskWorkflowSaveRequest> {

  @Override
  protected String getCreateView() {
    return "workflow/singletask/create";
  }

  @Override
  protected String getEditView() {
    return "workflow/singletask/edit";
  }

}

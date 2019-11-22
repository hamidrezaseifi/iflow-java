package com.pth.iflow.gui.controller.page.workflow.threetask;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pth.iflow.common.rest.IflowRestPaths.GuiModule;
import com.pth.iflow.gui.controller.page.workflow.WorkflowPageControllerBase;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflowSaveRequest;

@Controller
@RequestMapping(value = GuiModule.TESTTHREETASKWORKFLOW_PAGE_BASE)
public class TestThreeTaskWorkflowPageController
    extends WorkflowPageControllerBase<TestThreeTaskWorkflow, TestThreeTaskWorkflowSaveRequest> {

  @Override
  protected String getCreateView() {
    return "workflow/testthreetask/create";
  }

  @Override
  protected String getEditView() {
    return "workflow/testthreetask/edit";
  }

}

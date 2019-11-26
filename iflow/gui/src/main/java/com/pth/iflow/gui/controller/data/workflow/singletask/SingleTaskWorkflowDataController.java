package com.pth.iflow.gui.controller.data.workflow.singletask;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.common.rest.IflowRestPaths.GuiModule;
import com.pth.iflow.gui.controller.data.workflow.WorkflowDataControllerBase;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflowSaveRequest;

@Controller
@RequestMapping(value = GuiModule.SINGLETASKWORKFLOW_DATA_BASE)
public class SingleTaskWorkflowDataController extends WorkflowDataControllerBase<SingleTaskWorkflow, SingleTaskWorkflowSaveRequest> {

  @Override
  protected SingleTaskWorkflow generateInitialWorkflow(final String userIdentity) {

    final SingleTaskWorkflow workflow = SingleTaskWorkflow.generateInitial(userIdentity);
    workflow.setWorkflowType(this.getWorkflowTypeByEnumType(EWorkflowType.SINGLE_TASK_WORKFLOW_TYPE));
    return workflow;

  }

  @Override
  protected SingleTaskWorkflowSaveRequest generateInitialWorkflowSaveRequest(final SingleTaskWorkflow workflow, final int expireDays) {
    return SingleTaskWorkflowSaveRequest.generateNewWihExpireDays(workflow, expireDays);
  }

}

package com.pth.iflow.gui.controller.data.workflow.threetask;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.common.rest.IflowRestPaths.GuiModule;
import com.pth.iflow.gui.controller.data.workflow.WorkflowDataControllerBase;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflowSaveRequest;

@Controller
@RequestMapping(value = GuiModule.TESTTHREETASKWORKFLOW_DATA_BASE)
public class TestThreeTaskWorkflowDataController
    extends WorkflowDataControllerBase<TestThreeTaskWorkflow, TestThreeTaskWorkflowSaveRequest> {

  @Override
  protected TestThreeTaskWorkflow generateInitialWorkflow(final String userIdentity) {

    final TestThreeTaskWorkflow workflow = TestThreeTaskWorkflow.generateInitial(userIdentity);
    workflow.setWorkflowType(this.getWorkflowTypeByEnumType(EWorkflowType.TESTTHREE_TASK_WORKFLOW_TYPE));
    return workflow;
  }

  @Override
  protected TestThreeTaskWorkflowSaveRequest generateInitialWorkflowSaveRequest(final TestThreeTaskWorkflow workflow,
      final int expireDays) {
    return TestThreeTaskWorkflowSaveRequest.generateNewWihExpireDays(workflow, expireDays);
  }

}

package com.pth.iflow.workflow.bl.strategies.save;

import java.net.MalformedURLException;

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class AssignWorkflowStrategy extends AbstractSaveWorkflowStrategy {

  public AssignWorkflowStrategy(final WorkflowSaveRequest processingWorkflowSaveRequest, final String token,
      final IWorkflowDataService workflowDataService) {
    super(processingWorkflowSaveRequest, token, workflowDataService);

  }

  @Override
  public Workflow process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    if (this.processingWorkflow.hasAction() == false) {
      final WorkflowAction action = initialFirstStep();

      processingWorkflow.addAction(action);
    }

    if (this.processingWorkflow.hasActiveAction() == false) {
      final WorkflowAction action = initialNextStep();
      if (action != null) {
        processingWorkflow.addAction(action);
      }
    }

    if (this.processingWorkflow.hasActiveAction() == false) {
      throw new IFlowCustomeException("The workflow has no active action id:" + this.processingWorkflow.getId(),
          EIFlowErrorType.INVALID_WORKFLOW_STATUS);

    }

    if (processingWorkflowSaveRequest.getAssigns().isEmpty()
        || processingWorkflowSaveRequest.getAssigns().get(0).getItemType() != EAssignType.USER) {
      throw new IFlowCustomeException("Invalid assign list or item", EIFlowErrorType.INVALID_WORKFLOW_ASSIGN_LIST);

    }

    this.processingWorkflow.setActiveActionAssignTo(processingWorkflowSaveRequest.getAssigns().get(0).getItemId());

    // this.validateWorkflowCurrectStep(this.processingWorkflow, this.workflowType);
    // this.validateWorkflowAssignedUser(this.processingWorkflow,
    // this.workflowType);

    // this.activeAction.setStatus(EWorkflowActionStatus.OPEN);

    return this.saveWorkflow(this.processingWorkflow);

  }

}

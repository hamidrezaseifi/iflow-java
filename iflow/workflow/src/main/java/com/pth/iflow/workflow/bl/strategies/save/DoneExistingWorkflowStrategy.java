package com.pth.iflow.workflow.bl.strategies.save;

import java.net.MalformedURLException;

import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class DoneExistingWorkflowStrategy extends AbstractSaveWorkflowStrategy {

  public DoneExistingWorkflowStrategy(final WorkflowSaveRequest processingWorkflowSaveRequest, final String token,
      final IWorkflowDataService workflowDataService) {
    super(processingWorkflowSaveRequest, token, workflowDataService);

  }

  @Override
  public Workflow process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    if (this.processingWorkflow.isAssigned() == false) {
      throw new IFlowCustomeException("The workflow is not assigned id:" + this.processingWorkflow.getId(),
          EIFlowErrorType.INVALID_WORKFLOW_STATUS);

    }

    if (this.processingWorkflow.hasActiveAction() == false) {
      throw new IFlowCustomeException("The workflow has no active action id:" + this.processingWorkflow.getId(),
          EIFlowErrorType.INVALID_WORKFLOW_STATUS);

    }

    this.validateWorkflowCurrectStep(this.processingWorkflow, this.workflowType);
    this.validateWorkflowAssignedUser(this.processingWorkflow, this.workflowType);

    this.activeAction.setStatus(EWorkflowActionStatus.DONE);

    // this.selectWorkflowNextAssigned(this.processingWorkflow, this.workflowType,
    // this.activeAction);
    this.selectWorkflowNextStep(this.processingWorkflow, this.workflowType, this.activeAction);
    // this.setAssignToControllerAfterLastStep(this.processingWorkflow,
    // this.workflowType, this.activeAction);

    return this.saveWorkflow(this.processingWorkflow);

  }

}

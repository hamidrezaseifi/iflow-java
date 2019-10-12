package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class ChangeWorkflowOfferStatusToAssignForUserAndWorkflowInCoreStep extends AbstractWorkflowSaveStrategyStep {

  public ChangeWorkflowOfferStatusToAssignForUserAndWorkflowInCoreStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final WorkflowSaveRequest processingWorkflowSaveRequest = this.getWorkflowSaveStrategy().getProcessingWorkflowSaveRequest();
    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getSavedSingleWorkflow();
    final String userId = processingWorkflowSaveRequest.getAssigns().get(0).getItemIdentity();

    this.getWorkflowSaveStrategy().updateUserAndWorkflowMessageStatus(processingWorkflow.getIdentity(),
        processingWorkflow.getCurrentStepIdentity(), userId, EWorkflowMessageStatus.ASSIGNED);

  }

  @Override
  public boolean shouldProcess() {
    return true;
  }

}

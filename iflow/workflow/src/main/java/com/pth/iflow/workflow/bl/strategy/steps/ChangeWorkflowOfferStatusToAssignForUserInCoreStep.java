package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class ChangeWorkflowOfferStatusToAssignForUserInCoreStep extends AbstractWorkflowSaveStrategyStep {

  public ChangeWorkflowOfferStatusToAssignForUserInCoreStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getSavedSingleWorkflow();
    final WorkflowSaveRequest processingWorkflowSaveRequest = this.getWorkflowSaveStrategy().getProcessingWorkflowSaveRequest();

    final Long userId = processingWorkflowSaveRequest.getAssigns().get(0).getItemId();

    this.getWorkflowSaveStrategy().changeUserWorkflowMessageStatus(processingWorkflow.getId(), userId, EWorkflowMessageStatus.CLOSED);

  }

  @Override
  public boolean shouldProcess() {
    return true;
  }

}

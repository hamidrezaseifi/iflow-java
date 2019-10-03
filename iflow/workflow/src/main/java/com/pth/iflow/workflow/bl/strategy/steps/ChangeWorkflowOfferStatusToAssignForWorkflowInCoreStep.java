package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;

public class ChangeWorkflowOfferStatusToAssignForWorkflowInCoreStep extends AbstractWorkflowSaveStrategyStep {

  public ChangeWorkflowOfferStatusToAssignForWorkflowInCoreStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getSavedSingleWorkflow();

    this.getWorkflowSaveStrategy().changeWorkflowMessageStatus(processingWorkflow.getId(), EWorkflowMessageStatus.CLOSED);

    processNextStepIfExists();
  }

}

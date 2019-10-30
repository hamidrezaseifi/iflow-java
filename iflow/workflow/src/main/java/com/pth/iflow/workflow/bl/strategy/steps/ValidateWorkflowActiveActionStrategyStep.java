package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;

public class ValidateWorkflowActiveActionStrategyStep extends AbstractWorkflowSaveStrategyStep {

  public ValidateWorkflowActiveActionStrategyStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getProcessingWorkflow();

    if (processingWorkflow.hasActiveAction() == false) {
      throw new WorkflowCustomizedException("The workflow has no active action identity:" + processingWorkflow.getIdentity(),
          EIFlowErrorType.INVALID_WORKFLOW_STATUS);

    }

  }

  @Override
  public boolean shouldProcess() {
    return true;
  }

}

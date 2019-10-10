package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;

public class ValidateWorkflowDetailStrategyStep extends AbstractWorkflowSaveStrategyStep {

  public ValidateWorkflowDetailStrategyStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getProcessingWorkflow();

    if (processingWorkflow.getController() == null || processingWorkflow.getController() <= 0) {

      throw new IFlowCustomeException("Invalid workflow controller!", EIFlowErrorType.INVALID_WORKFLOW_DETAIL);
    }

    if (processingWorkflow.getCreatedBy() == null || processingWorkflow.getCreatedBy() <= 0) {

      throw new IFlowCustomeException("Invalid workflow CreatedBy!", EIFlowErrorType.INVALID_WORKFLOW_DETAIL);
    }

    if (processingWorkflow.getWorkflowTypeId() == null || processingWorkflow.getWorkflowTypeId() <= 0) {

      throw new IFlowCustomeException("Invalid workflow WorkflowType!", EIFlowErrorType.INVALID_WORKFLOW_DETAIL);
    }

    if (processingWorkflow.getCurrentStep() == null) {

      throw new IFlowCustomeException("Unknown processingWorkflow step id:" + processingWorkflow.getId(),
          EIFlowErrorType.UNKNOWN_WORKFLOW_TYPE_STEP);
    }

  }

  @Override
  public boolean shouldProcess() {
    return true;
  }

}
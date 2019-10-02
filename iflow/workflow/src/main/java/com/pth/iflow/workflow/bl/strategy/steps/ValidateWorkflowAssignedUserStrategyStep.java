package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;

public class ValidateWorkflowAssignedUserStrategyStep extends AbstractWorkflowSaveStrategyStep {

  public ValidateWorkflowAssignedUserStrategyStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getProcessingWorkflow();

    if (processingWorkflow.getActiveAction().getAssignTo() == null || processingWorkflow.getActiveAction().getAssignTo() < 1) {
      throw new IFlowCustomeException("The workflow has not been assigned id:" + processingWorkflow.getId(),
                                      EIFlowErrorType.UNKNOWN_WORKFLOW_ASSIGN);

    }

    processNextStepIfExists();
  }

}

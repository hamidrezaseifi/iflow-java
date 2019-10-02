package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

public class ValidateCurrentStepExistsInWorkflowTypeStrategyStep extends AbstractWorkflowSaveStrategyStep {

  public ValidateCurrentStepExistsInWorkflowTypeStrategyStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getProcessingWorkflow();
    final WorkflowType processingWorkflowType = this.getWorkflowSaveStrategy().getProcessingWorkflowType();

    final boolean isValid = this.validateCurrentStepExistsInWorkflowType(processingWorkflow.getCurrentStep(), processingWorkflowType);
    if (isValid == false) {

      throw new IFlowCustomeException("Invalid workflow step id:" + processingWorkflow.getId(), EIFlowErrorType.INVALID_WORKFLOW_STEP);

    }

    processNextStepIfExists();
  }

  private boolean validateCurrentStepExistsInWorkflowType(final WorkflowTypeStep step, final WorkflowType workflowType) {

    for (final WorkflowTypeStep typeStep : workflowType.getSteps()) {
      if (typeStep.getId() == step.getId()) {
        return true;
      }
    }

    return false;
  }

}

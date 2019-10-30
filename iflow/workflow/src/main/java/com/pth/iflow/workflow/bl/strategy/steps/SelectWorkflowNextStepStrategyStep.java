package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

public class SelectWorkflowNextStepStrategyStep extends AbstractWorkflowSaveStrategyStep {

  public SelectWorkflowNextStepStrategyStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getProcessingWorkflow();
    final WorkflowType processingWorkflowType = this.getWorkflowSaveStrategy().getProcessingWorkflowType();

    final WorkflowTypeStep nextStep = this.getWorkflowSaveStrategy().findNextStep(processingWorkflowType, processingWorkflow);
    if (nextStep == null) {
      throw new WorkflowCustomizedException(String.format("Invalid workflow step id:%s", processingWorkflow.getIdentity()),
          EIFlowErrorType.INVALID_WORKFLOW_STEP);
    }

    processingWorkflow.setCurrentStep(nextStep);
    processingWorkflow.setCurrentStepIdentity(nextStep.getIdentity());

  }

  @Override
  public boolean shouldProcess() {
    return true;
  }

}

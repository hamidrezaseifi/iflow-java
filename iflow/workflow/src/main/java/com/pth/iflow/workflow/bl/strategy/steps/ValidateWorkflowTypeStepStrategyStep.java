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

public class ValidateWorkflowTypeStepStrategyStep extends AbstractWorkflowSaveStrategyStep {

  public ValidateWorkflowTypeStepStrategyStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getProcessingWorkflow();
    final WorkflowType processingWorkflowType = this.getWorkflowSaveStrategy().getProcessingWorkflowType();

    if (processingWorkflow.getCurrentStep() == null) {

      this.setWorkflowCurrectStep(processingWorkflow, processingWorkflowType);
    }

    if (processingWorkflow.getCurrentStep() == null) {

      throw new IFlowCustomeException("Unknown processingWorkflow step identity:" + processingWorkflow.getIdentity(),
          EIFlowErrorType.UNKNOWN_WORKFLOW_TYPE_STEP);
    }

    this.getWorkflowSaveStrategy().validateCurrentStepExistsInWorkflowType(processingWorkflow, processingWorkflowType);

  }

  private void setWorkflowCurrectStep(final Workflow workflow, final WorkflowType workflowType) {

    if (workflow.isInitializing() || workflow.isOffering()) {
      final WorkflowTypeStep firstStep = this.getWorkflowSaveStrategy().findFirstStep(workflowType);
      if (firstStep != null) {
        workflow.setCurrentStep(firstStep);
        workflow.setCurrentStepIdentity(firstStep.getIdentity());
      }
    }

  }

  @Override
  public boolean shouldProcess() {
    return true;
  }

}

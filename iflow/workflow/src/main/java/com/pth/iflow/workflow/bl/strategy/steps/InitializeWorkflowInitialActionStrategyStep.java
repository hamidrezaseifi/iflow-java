package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;

public class InitializeWorkflowInitialActionStrategyStep extends AbstractWorkflowSaveStrategyStep {

  public InitializeWorkflowInitialActionStrategyStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getProcessingWorkflow();

    if (processingWorkflow.hasAction() == false) {
      final WorkflowAction action = this.getWorkflowSaveStrategy().initialFirstStep(processingWorkflow);

      processingWorkflow.addAction(action);
      processingWorkflow.setCurrentStepId(action.getCurrentStepId());
      processingWorkflow.setCurrentStep(action.getCurrentStep());
    }

  }

  @Override
  public boolean shouldProcess() {
    return true;
  }

}

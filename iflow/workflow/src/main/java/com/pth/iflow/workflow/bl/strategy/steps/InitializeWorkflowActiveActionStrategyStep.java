package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;

public class InitializeWorkflowActiveActionStrategyStep extends AbstractWorkflowSaveStrategyStep {

  public InitializeWorkflowActiveActionStrategyStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getProcessingWorkflow();

    if (processingWorkflow.hasActiveAction() == false) {
      final WorkflowAction action = this.getWorkflowSaveStrategy().initialNextStep(processingWorkflow);
      if (action != null) {
        processingWorkflow.addAction(action);
      }
    }

    processNextStepIfExists();
  }

}

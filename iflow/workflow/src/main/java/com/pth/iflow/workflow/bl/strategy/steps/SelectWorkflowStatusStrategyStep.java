package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;

import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowType;

public class SelectWorkflowStatusStrategyStep extends AbstractWorkflowSaveStrategyStep {

  public SelectWorkflowStatusStrategyStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final AbstractWorkflowSaveStrategy strategy = this.getWorkflowSaveStrategy();
    final Workflow processingWorkflow = strategy.getProcessingWorkflow();
    final WorkflowType processingWorkflowType = strategy.getProcessingWorkflowType();
    final WorkflowAction activeAction = strategy.getActiveAction();

    if (strategy.IsWorkflowCurrectStepChanged() == false) {
      if (strategy.isLastStep(processingWorkflowType, processingWorkflow.getCurrentStep())) {
        processingWorkflow.setStatus(EWorkflowStatus.DONE);
      }
    } else {
      if (activeAction.isAssigned() == false) {
        processingWorkflow.setStatus(EWorkflowStatus.NOT_ASSIGNED);
      }
    }

  }

  @Override
  public boolean shouldProcess() {
    return true;
  }

}

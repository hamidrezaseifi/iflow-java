package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategyStep;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;

public abstract class AbstractWorkflowSaveStrategyStep implements IWorkflowSaveStrategyStep {

  private final AbstractWorkflowSaveStrategy workflowSaveStrategy;

  public AbstractWorkflowSaveStrategyStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    this.workflowSaveStrategy = workflowSaveStrategy;
  }

  public boolean hasNextStep(final IWorkflowSaveStrategyStep currentStep) {
    return workflowSaveStrategy.hasNextStep(currentStep);
  }

  public IWorkflowSaveStrategyStep getNextStep(final IWorkflowSaveStrategyStep currentStep) {
    return workflowSaveStrategy.getNextStep(currentStep);
  }

  public AbstractWorkflowSaveStrategy getWorkflowSaveStrategy() {
    return workflowSaveStrategy;
  }

  public void processNextStepIfExists() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    if (hasNextStep(this)) {
      getNextStep(this).process();
    }
  }

}

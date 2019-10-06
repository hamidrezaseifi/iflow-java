package com.pth.iflow.workflow.bl.strategy.steps;

import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategyStep;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;

public abstract class AbstractWorkflowSaveStrategyStep implements IWorkflowSaveStrategyStep {

  private final AbstractWorkflowSaveStrategy workflowSaveStrategy;

  public AbstractWorkflowSaveStrategyStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    this.workflowSaveStrategy = workflowSaveStrategy;
  }

  public boolean hasNextStep(final IWorkflowSaveStrategyStep currentStep) {
    return workflowSaveStrategy.hasNextStep(currentStep);
  }

  public AbstractWorkflowSaveStrategy getWorkflowSaveStrategy() {
    return workflowSaveStrategy;
  }

}

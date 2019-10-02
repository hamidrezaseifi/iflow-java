package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;

public class SaveWorkflowInCoreStep extends AbstractWorkflowSaveStrategyStep {

  public SaveWorkflowInCoreStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getProcessingWorkflow();

    final Workflow savedWorkflow = this.getWorkflowSaveStrategy().saveWorkflow(processingWorkflow);

    this.getWorkflowSaveStrategy().setProcessingWorkflow(savedWorkflow);

    this.getWorkflowSaveStrategy().setSavedSingleWorkflow(savedWorkflow);

    processNextStepIfExists();
  }

}

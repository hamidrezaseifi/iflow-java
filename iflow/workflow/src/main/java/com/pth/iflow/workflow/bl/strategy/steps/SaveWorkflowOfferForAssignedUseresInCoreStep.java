package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowType;

public class SaveWorkflowOfferForAssignedUseresInCoreStep extends AbstractWorkflowSaveStrategyStep {

  public SaveWorkflowOfferForAssignedUseresInCoreStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getSavedSingleWorkflow();

    for (final Long userId : this.getWorkflowSaveStrategy().getAssignedUsers()) {
      this.getWorkflowSaveStrategy().createWorkflowMessage(processingWorkflow.getId(), processingWorkflow.getCreatedBy(), userId);
    }

  }

  @Override
  public boolean shouldProcess() {
    final WorkflowType processingWorkflowType = this.getWorkflowSaveStrategy().getProcessingWorkflowType();
    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getProcessingWorkflow();

    if (processingWorkflow.isDone() || processingWorkflow.isArchived()) {
      return false;
    }

    return processingWorkflowType.isAssignTypeOffering();
  }

}

package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;

public class ChangeWorkflowOfferStatusToCloseForWorkflowInCoreStep extends AbstractWorkflowSaveStrategyStep {

  public ChangeWorkflowOfferStatusToCloseForWorkflowInCoreStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getSavedSingleWorkflow();
    final WorkflowAction prevAction = this.getWorkflowSaveStrategy().getPrevActiveAction();
    final Long stepId = prevAction != null ? prevAction.getCurrentStepId() : processingWorkflow.getCurrentStepId();

    this.getWorkflowSaveStrategy().updateWorkflowMessageStatus(processingWorkflow.getId(), stepId, EWorkflowMessageStatus.CLOSED);

  }

  @Override
  public boolean shouldProcess() {
    return true;
  }

}

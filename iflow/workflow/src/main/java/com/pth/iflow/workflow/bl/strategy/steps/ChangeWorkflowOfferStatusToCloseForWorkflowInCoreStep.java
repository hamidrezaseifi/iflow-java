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
    final String stepId = prevAction != null ? prevAction.getCurrentStepIdentity() : processingWorkflow.getCurrentStepIdentity();

    this.getWorkflowSaveStrategy().updateWorkflowMessageStatus(processingWorkflow.getIdentity(), stepId,
        EWorkflowMessageStatus.CLOSED);

  }

  @Override
  public boolean shouldProcess() {
    return true;
  }

}

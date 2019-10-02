package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;
import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowAction;

public class PrepareDoneActiveActionStep extends AbstractWorkflowSaveStrategyStep {

  public PrepareDoneActiveActionStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final WorkflowAction activeAction = this.getWorkflowSaveStrategy().getActiveAction();

    activeAction.setStatus(EWorkflowActionStatus.DONE);

    processNextStepIfExists();
  }

}

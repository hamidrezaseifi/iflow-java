package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;

public class SendWorkflowOffersToProfileStep extends AbstractWorkflowSaveStrategyStep {

  public SendWorkflowOffersToProfileStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    this.getWorkflowSaveStrategy().resetUserListCachData(this.getWorkflowSaveStrategy().getWorkflowType().getCompanyId(),
        this.getWorkflowSaveStrategy().getAssignedUsers());

    processNextStepIfExists();
  }

}

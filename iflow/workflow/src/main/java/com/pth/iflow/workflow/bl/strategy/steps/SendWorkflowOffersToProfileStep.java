package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowType;

public class SendWorkflowOffersToProfileStep extends AbstractWorkflowSaveStrategyStep {

  public SendWorkflowOffersToProfileStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Long companyId = this.getWorkflowSaveStrategy().getProcessingWorkflowType().getCompanyId();
    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getSavedSingleWorkflow();

    this.getWorkflowSaveStrategy().resetWorkflowtCachData(companyId, processingWorkflow.getId());

  }

  @Override
  public boolean shouldProcess() {
    final WorkflowType processingWorkflowType = this.getWorkflowSaveStrategy().getProcessingWorkflowType();

    return processingWorkflowType.isAssignTypeOffering();
  }

}

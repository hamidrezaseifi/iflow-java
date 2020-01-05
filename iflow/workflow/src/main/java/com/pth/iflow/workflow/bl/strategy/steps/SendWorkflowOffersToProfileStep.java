package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.base.IWorkflow;

public class SendWorkflowOffersToProfileStep<W extends IWorkflow> extends AbstractWorkflowSaveStrategyStep<W> {

  public SendWorkflowOffersToProfileStep(final AbstractWorkflowSaveStrategy<W> workflowSaveStrategy) {

    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final String companyIdentity = this.getWorkflowSaveStrategy().getProcessingWorkflow().getCompanyIdentity();
    final W processingWorkflow = this.getWorkflowSaveStrategy().getSavedSingleWorkflow();

    this.getWorkflowSaveStrategy().resetWorkflowtCachData(companyIdentity, processingWorkflow.getIdentity());

  }

  @Override
  public boolean shouldProcess() {

    final WorkflowType processingWorkflowType = this.getWorkflowSaveStrategy().getProcessingWorkflowType();

    return processingWorkflowType.isAssignTypeOffering();
  }

}

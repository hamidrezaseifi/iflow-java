package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;

public class SaveWorkflowForAssignedUseresInCoreStep extends AbstractWorkflowSaveStrategyStep {

  public SaveWorkflowForAssignedUseresInCoreStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getProcessingWorkflow();

    final List<Workflow> result = new ArrayList<>();

    for (final String userIdentity : this.getWorkflowSaveStrategy().getAssignedUsers()) {
      processingWorkflow.setActiveActionAssignTo(userIdentity);

      final Workflow savedWorkflow = this.getWorkflowSaveStrategy().saveWorkflow(processingWorkflow);
      result.add(savedWorkflow);
    }

    this.getWorkflowSaveStrategy().setSavedWorkflowList(result);

  }

  @Override
  public boolean shouldProcess() {
    return true;
  }

}

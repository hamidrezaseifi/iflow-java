package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class AssignWorkflowActiveActionStrategyStep extends AbstractWorkflowSaveStrategyStep {

  public AssignWorkflowActiveActionStrategyStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Workflow processingWorkflow = this.getWorkflowSaveStrategy().getProcessingWorkflow();
    final WorkflowSaveRequest processingWorkflowSaveRequest = this.getWorkflowSaveStrategy().getProcessingWorkflowSaveRequest();

    processingWorkflow.setActiveActionAssignTo(processingWorkflowSaveRequest.getAssigns().get(0).getItemId());

    processNextStepIfExists();
  }

}

package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class ValidateAssignInSaveRequestStrategyStep extends AbstractWorkflowSaveStrategyStep {

  public ValidateAssignInSaveRequestStrategyStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final WorkflowSaveRequest processingWorkflowSaveRequest = this.getWorkflowSaveStrategy().getProcessingWorkflowSaveRequest();

    if (processingWorkflowSaveRequest.getAssigns().isEmpty()) {
      throw new IFlowCustomeException("No assign by workflow create", EIFlowErrorType.NO_WORKFLOW_ASSIGN_CREATE_STRATEGY);
    }

    processNextStepIfExists();
  }

}

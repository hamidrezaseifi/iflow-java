package com.pth.iflow.workflow.bl.strategy.steps;

import java.net.MalformedURLException;

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.strategy.strategies.AbstractWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class ValidateSingleUserAssignInSaveRequestStrategyStep extends AbstractWorkflowSaveStrategyStep {

  public ValidateSingleUserAssignInSaveRequestStrategyStep(final AbstractWorkflowSaveStrategy workflowSaveStrategy) {
    super(workflowSaveStrategy);

  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final WorkflowSaveRequest processingWorkflowSaveRequest = this.getWorkflowSaveStrategy().getProcessingWorkflowSaveRequest();

    if (processingWorkflowSaveRequest.getAssigns().size() != 1
        || processingWorkflowSaveRequest.getAssigns().get(0).getItemType() != EAssignType.USER) {
      throw new IFlowCustomeException("Invalid assign list or item", EIFlowErrorType.INVALID_WORKFLOW_ASSIGN_LIST);

    }

  }

  @Override
  public boolean shouldProcess() {
    return true;
  }

}

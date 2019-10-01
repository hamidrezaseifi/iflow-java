package com.pth.iflow.workflow.bl.strategies.save;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class SaveNewWorkflowStrategy extends AbstractSaveWorkflowStrategy {

  public SaveNewWorkflowStrategy(final WorkflowSaveRequest processingWorkflowSaveRequest, final String token,
      final IWorkflowDataService workflowDataService) {
    super(processingWorkflowSaveRequest, token, workflowDataService);

  }

  @Override
  public Workflow process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    if (this.processingWorkflow.isNew() == false) {
      throw new IFlowCustomeException("invalid new workflow status id:" + this.processingWorkflow.getId(),
          EIFlowErrorType.INVALID_WORKFLOW_STATUS);

    }

    this.validateWorkflowCurrectStep(this.processingWorkflow, this.workflowType);
    this.validateWorkflowAssignedUser(this.processingWorkflow, this.workflowType);

    return this.saveWorkflow(this.processingWorkflow);
  }

}

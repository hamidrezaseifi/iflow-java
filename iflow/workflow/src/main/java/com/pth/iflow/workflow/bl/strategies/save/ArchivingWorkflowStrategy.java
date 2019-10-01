package com.pth.iflow.workflow.bl.strategies.save;

import java.net.MalformedURLException;

import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class ArchivingWorkflowStrategy extends AbstractSaveWorkflowStrategy {

  public ArchivingWorkflowStrategy(final WorkflowSaveRequest processingWorkflowSaveRequest, final String token,
      final IWorkflowDataService workflowDataService) {
    super(processingWorkflowSaveRequest, token, workflowDataService);

  }

  @Override
  public Workflow process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    this.processingWorkflow.setStatus(EWorkflowStatus.ARCHIVED);
    this.validateWorkflowCurrectStep(this.processingWorkflow, this.workflowType);
    this.validateWorkflowAssignedUser(this.processingWorkflow, this.workflowType);

    return this.saveWorkflow(this.processingWorkflow);
  }

}

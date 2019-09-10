package com.pth.iflow.workflow.bl.strategies.save;

import java.net.MalformedURLException;

import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowType;

public class SaveExistingWorkflowStrategy extends AbstractSaveWorkflowStrategy {

  public SaveExistingWorkflowStrategy(final Workflow processingWorkflow, final WorkflowType workflowType, final String token,
      final WorkflowAction activeAction, final IWorkflowDataService workflowDataService) {
    super(processingWorkflow, workflowType, token, activeAction, workflowDataService);

  }

  @Override
  public Workflow process() throws WorkflowCustomizedException, MalformedURLException {

    this.validateWorkflowCurrectStep(this.processingWorkflow, this.workflowType);
    this.validateWorkflowAssignedUser(this.processingWorkflow, this.workflowType);

    this.activeAction.setStatus(EWorkflowActionStatus.OPEN);

    return this.saveWorkflow(this.processingWorkflow);

  }

}

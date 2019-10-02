package com.pth.iflow.workflow.bl.strategy.strategies;

import java.net.MalformedURLException;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.ICachDataDataService;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategy.IWorkStrategyFactory;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class SaveNewWorkflowStrategy extends AbstractWorkflowSaveStrategy {

  public SaveNewWorkflowStrategy(final WorkflowSaveRequest workflowSaveRequest,
                                 final String token,
                                 final IWorkStrategyFactory workStrategyFactory,
                                 final IDepartmentDataService departmentDataService,
                                 final IWorkflowMessageDataService workflowMessageDataService,
                                 final ICachDataDataService cachDataDataService,
                                 final IWorkflowDataService workflowDataService) {
    super(workflowSaveRequest,
          token,
          workStrategyFactory,
          departmentDataService,
          workflowMessageDataService,
          cachDataDataService,
          workflowDataService);

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

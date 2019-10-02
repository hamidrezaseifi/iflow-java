package com.pth.iflow.workflow.bl.strategy.strategies;

import java.net.MalformedURLException;
import com.pth.iflow.common.enums.EWorkflowActionStatus;
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

public class DoneExistingWorkflowStrategy extends AbstractWorkflowSaveStrategy {

  public DoneExistingWorkflowStrategy(final WorkflowSaveRequest workflowCreateRequest,
                                      final String token,
                                      final IWorkStrategyFactory workStrategyFactory,
                                      final IDepartmentDataService departmentDataService,
                                      final IWorkflowMessageDataService workflowMessageDataService,
                                      final ICachDataDataService cachDataDataService,
                                      final IWorkflowDataService workflowDataService) {
    super(workflowCreateRequest,
          token,
          workStrategyFactory,
          departmentDataService,
          workflowMessageDataService,
          cachDataDataService,
          workflowDataService);

  }

  @Override
  public Workflow process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    if (this.processingWorkflow.isAssigned() == false) {
      throw new IFlowCustomeException("The workflow is not assigned id:" + this.processingWorkflow.getId(),
                                      EIFlowErrorType.INVALID_WORKFLOW_STATUS);

    }

    if (this.processingWorkflow.hasActiveAction() == false) {
      throw new IFlowCustomeException("The workflow has no active action id:" + this.processingWorkflow.getId(),
                                      EIFlowErrorType.INVALID_WORKFLOW_STATUS);

    }

    this.validateWorkflowCurrectStep(this.processingWorkflow, this.processingWorkflowType);
    this.validateWorkflowAssignedUser(this.processingWorkflow, this.processingWorkflowType);

    this.activeAction.setStatus(EWorkflowActionStatus.DONE);

    // this.selectWorkflowNextAssigned(this.processingWorkflow, this.workflowType,
    // this.activeAction);
    this.selectWorkflowNextStep(this.processingWorkflow, this.processingWorkflowType, this.activeAction);
    // this.setAssignToControllerAfterLastStep(this.processingWorkflow,
    // this.workflowType, this.activeAction);

    return this.saveWorkflow(this.processingWorkflow);

  }

}

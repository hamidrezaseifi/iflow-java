package com.pth.iflow.workflow.bl.strategy.strategies;

import java.net.MalformedURLException;
import com.pth.iflow.common.enums.EAssignType;
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
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class AssignWorkflowStrategy extends AbstractWorkflowSaveStrategy {

  public AssignWorkflowStrategy(final WorkflowSaveRequest workflowCreateRequest,
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

    if (this.processingWorkflow.hasAction() == false) {
      final WorkflowAction action = initialFirstStep();

      processingWorkflow.addAction(action);
    }

    if (this.processingWorkflow.hasActiveAction() == false) {
      final WorkflowAction action = initialNextStep();
      if (action != null) {
        processingWorkflow.addAction(action);
      }
    }

    if (this.processingWorkflow.hasActiveAction() == false) {
      throw new IFlowCustomeException("The workflow has no active action id:" + this.processingWorkflow.getId(),
                                      EIFlowErrorType.INVALID_WORKFLOW_STATUS);

    }

    if (processingWorkflowSaveRequest.getAssigns().isEmpty()
        || processingWorkflowSaveRequest.getAssigns().get(0).getItemType() != EAssignType.USER) {
      throw new IFlowCustomeException("Invalid assign list or item", EIFlowErrorType.INVALID_WORKFLOW_ASSIGN_LIST);

    }

    this.processingWorkflow.setActiveActionAssignTo(processingWorkflowSaveRequest.getAssigns().get(0).getItemId());

    // this.validateWorkflowCurrectStep(this.processingWorkflow, this.workflowType);
    // this.validateWorkflowAssignedUser(this.processingWorkflow,
    // this.workflowType);

    // this.activeAction.setStatus(EWorkflowActionStatus.OPEN);

    return this.saveWorkflow(this.processingWorkflow);

  }

}

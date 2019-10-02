package com.pth.iflow.workflow.bl.strategy.strategies;

import java.net.MalformedURLException;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.ICachDataDataService;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategy.IWorkStrategyFactory;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

public class ArchivingWorkflowStrategy extends AbstractWorkflowSaveStrategy {

  public ArchivingWorkflowStrategy(final WorkflowSaveRequest workflowCreateRequest,
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
    this.processingWorkflow.setStatus(EWorkflowStatus.ARCHIVED);
    this.validateWorkflowCurrectStep(this.processingWorkflow, this.workflowType);
    this.validateWorkflowAssignedUser(this.processingWorkflow, this.workflowType);

    return this.saveWorkflow(this.processingWorkflow);
  }

}

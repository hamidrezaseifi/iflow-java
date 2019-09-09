package com.pth.iflow.workflow.bl.strategies;

import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.bl.strategies.impl.ArchivingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.impl.DoneExistingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.impl.SaveExistingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.impl.SaveNewWorkflowStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowType;

@Service
public class WorkStrategyFactory implements IWorkStrategyFactory {

  private static final Logger            logger = LoggerFactory.getLogger(WorkStrategyFactory.class);

  private final IWorkflowDataService     workflowDataService;

  private final IWorkflowTypeDataService workflowTypeDataService;

  public WorkStrategyFactory(@Autowired final IWorkflowDataService workflowDataService,
      @Autowired final IWorkflowTypeDataService workflowTypeDataService) {
    this.workflowDataService = workflowDataService;
    this.workflowTypeDataService = workflowTypeDataService;

  }

  /*
   * (non-Javadoc)
   *
   * @see
   * com.pth.iflow.workflow.bl.strategies.IWorkStrategyFactory#selectWorkStrategy(
   * com.pth.iflow.workflow.models.Workflow)
   */
  @Override
  public IWorkflowStrategy selectWorkStrategy(final Workflow processingWorkflow, final String token)
      throws WorkflowCustomizedException, MalformedURLException {

    final WorkflowType workflowType = this.workflowTypeDataService.getById(processingWorkflow.getWorkflowTypeId(), token);
    final WorkflowAction activeAction = processingWorkflow.hasActiveAction() ? processingWorkflow.getActiveAction() : null;

    final IWorkflowStrategy strategy = null;

    if (processingWorkflow.isNew()) {
      return new SaveNewWorkflowStrategy(processingWorkflow, workflowType, token, activeAction, this.workflowDataService);
    }

    if (processingWorkflow.isStatusArchive()) {
      return new ArchivingWorkflowStrategy(processingWorkflow, workflowType, token, activeAction, this.workflowDataService);
    }

    if (processingWorkflow.isAssigned() && processingWorkflow.hasActiveAction() && (activeAction.isStatusSavingRequest())) {
      return new SaveExistingWorkflowStrategy(processingWorkflow, workflowType, token, activeAction, this.workflowDataService);
    }

    if (processingWorkflow.isAssigned() && processingWorkflow.hasActiveAction() && (activeAction.isStatusDoneRequest())) {

      return new DoneExistingWorkflowStrategy(processingWorkflow, workflowType, token, activeAction, this.workflowDataService);
    }

    throw new IFlowCustomeException("Unknown workflow strategy id:" + processingWorkflow.getId(),
        EIFlowErrorType.UNKNOWN_WORKFLOW_STRATEGY);

  }
}

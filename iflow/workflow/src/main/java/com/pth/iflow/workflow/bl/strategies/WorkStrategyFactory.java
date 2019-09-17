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
import com.pth.iflow.workflow.bl.strategies.create.CreateManualAssignWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.save.ArchivingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.save.DoneExistingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.save.SaveExistingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.save.SaveNewWorkflowStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowCreateRequest;
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
  public ISaveWorkflowStrategy selectSaveWorkStrategy(final Workflow processingWorkflow, final String token)
      throws WorkflowCustomizedException, MalformedURLException {

    logger.debug("selecting save strategy for workflow");
    final WorkflowType workflowType = this.workflowTypeDataService.getById(processingWorkflow.getWorkflowTypeId(), token);
    final WorkflowAction activeAction = processingWorkflow.hasActiveAction() ? processingWorkflow.getActiveAction() : null;

    if (processingWorkflow.isNew()) {
      logger.debug("The SaveNewWorkflowStrategy is selected for workflow");
      return new SaveNewWorkflowStrategy(processingWorkflow, workflowType, token, activeAction, this.workflowDataService);
    }

    if (processingWorkflow.isStatusArchive()) {
      logger.debug("The ArchivingWorkflowStrategy is selected for workflow");
      return new ArchivingWorkflowStrategy(processingWorkflow, workflowType, token, activeAction, this.workflowDataService);
    }

    if (processingWorkflow.isAssigned() && processingWorkflow.hasActiveAction() && (activeAction.isStatusSavingRequest())) {
      logger.debug("The SaveExistingWorkflowStrategy is selected for workflow");
      return new SaveExistingWorkflowStrategy(processingWorkflow, workflowType, token, activeAction, this.workflowDataService);
    }

    if (processingWorkflow.isAssigned() && processingWorkflow.hasActiveAction() && (activeAction.isStatusDoneRequest())) {
      logger.debug("The DoneExistingWorkflowStrategy is selected for workflow");
      return new DoneExistingWorkflowStrategy(processingWorkflow, workflowType, token, activeAction, this.workflowDataService);
    }

    throw new IFlowCustomeException("Unknown workflow save strategy id:" + processingWorkflow.getId(),
        EIFlowErrorType.UNKNOWN_WORKFLOW_SAVE_STRATEGY);

  }

  @Override
  public ICreateWorkflowStrategy selectCreateWorkStrategy(final WorkflowCreateRequest workflowCreateRequest, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("selecting create strategy for workflow create request");

    final WorkflowType workflowType = this.workflowTypeDataService.getById(workflowCreateRequest.getWorkflow().getWorkflowTypeId(),
        token);

    if (workflowType.getManualAssign() == Boolean.TRUE) {
      return new CreateManualAssignWorkflowStrategy(workflowCreateRequest, token, this);
    }

    throw new IFlowCustomeException("Unknown workflow create strategy ", EIFlowErrorType.UNKNOWN_WORKFLOW_CREATE_STRATEGY);
  }
}

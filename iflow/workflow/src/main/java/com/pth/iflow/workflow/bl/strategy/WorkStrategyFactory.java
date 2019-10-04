package com.pth.iflow.workflow.bl.strategy;

import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IProfileCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategy.strategies.ArchivingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.AssignWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.CreateManualAssignWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.CreateOfferlAssignWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.DoneExistingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.SaveExistingWorkflowStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

@Service
public class WorkStrategyFactory implements IWorkStrategyFactory {

  private static final Logger               logger = LoggerFactory.getLogger(WorkStrategyFactory.class);

  private final IWorkflowDataService        workflowDataService;

  private final IDepartmentDataService      departmentDataService;

  private final IWorkflowMessageDataService workflowMessageDataService;

  private final IProfileCachDataDataService cachDataDataService;

  public WorkStrategyFactory(@Autowired final IWorkflowDataService workflowDataService,
      @Autowired final IDepartmentDataService departmentDataService,
      @Autowired final IWorkflowMessageDataService workflowMessageDataService,
      @Autowired final IProfileCachDataDataService cachDataDataService) {
    this.workflowDataService = workflowDataService;
    this.departmentDataService = departmentDataService;
    this.workflowMessageDataService = workflowMessageDataService;
    this.cachDataDataService = cachDataDataService;

  }

  /*
   * (non-Javadoc)
   *
   * @see
   * com.pth.iflow.workflow.bl.strategies.IWorkStrategyFactory#selectWorkStrategy(
   * com.pth.iflow.workflow.models.Workflow)
   */
  @Override
  public IWorkflowSaveStrategy selectWorkStrategy(final WorkflowSaveRequest workflowSaveRequest, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("selecting save strategy for workflow");

    if (workflowSaveRequest.getCommand() == EWorkflowProcessCommand.CREATE) {
      if (workflowSaveRequest.getWorkflow().getWorkflowType().isAssignTypeManual()) {
        return new CreateManualAssignWorkflowStrategy(workflowSaveRequest, token,

            departmentDataService, workflowMessageDataService, cachDataDataService, workflowDataService);
      }

      if (workflowSaveRequest.getWorkflow().getWorkflowType().isAssignTypeOffering()) {
        return new CreateOfferlAssignWorkflowStrategy(workflowSaveRequest, token,

            departmentDataService, workflowMessageDataService, cachDataDataService, workflowDataService);
      }
    }

    if (workflowSaveRequest.getCommand() == EWorkflowProcessCommand.ARCHIVE) {
      logger.debug("The ArchivingWorkflowStrategy is selected for workflow");
      return new ArchivingWorkflowStrategy(workflowSaveRequest, token,

          departmentDataService, workflowMessageDataService, cachDataDataService, workflowDataService);
    }

    if (workflowSaveRequest.getCommand() == EWorkflowProcessCommand.SAVE) {
      logger.debug("The SaveExistingWorkflowStrategy is selected for workflow");
      return new SaveExistingWorkflowStrategy(workflowSaveRequest, token,

          departmentDataService, workflowMessageDataService, cachDataDataService, workflowDataService);
    }

    if (workflowSaveRequest.getCommand() == EWorkflowProcessCommand.ASSIGN) {
      logger.debug("The AssignWorkflowStrategy is selected for workflow");
      return new AssignWorkflowStrategy(workflowSaveRequest, token,

          departmentDataService, workflowMessageDataService, cachDataDataService, workflowDataService);
    }

    if (workflowSaveRequest.getCommand() == EWorkflowProcessCommand.DONE) {
      logger.debug("The DoneExistingWorkflowStrategy is selected for workflow");
      return new DoneExistingWorkflowStrategy(workflowSaveRequest, token,

          departmentDataService, workflowMessageDataService, cachDataDataService, workflowDataService);
    }

    throw new IFlowCustomeException("Unknown workflow strategy ", EIFlowErrorType.UNKNOWN_WORKFLOW_STRATEGY);
  }
}

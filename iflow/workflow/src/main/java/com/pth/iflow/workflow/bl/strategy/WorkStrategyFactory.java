package com.pth.iflow.workflow.bl.strategy;

import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IProfileCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowPrepare;
import com.pth.iflow.workflow.bl.strategy.strategies.ArchivingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.AssignWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.CreateManualAssignWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.CreateOfferlAssignWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.DoneExistingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.SaveExistingWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.validation.ArchivingWorkflowValidationStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.validation.AssignWorkflowValidationStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.validation.CreateManualAssignWorkflowValidationStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.validation.CreateOfferlAssignWorkflowValidationStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.validation.DoneExistingWorkflowValidationStrategy;
import com.pth.iflow.workflow.bl.strategy.strategies.validation.SaveExistingWorkflowValidationStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;

@Service
public class WorkStrategyFactory implements IWorkStrategyFactory {

  private static final Logger               logger = LoggerFactory.getLogger(WorkStrategyFactory.class);

  private final IWorkflowDataService        workflowDataService;

  private final IDepartmentDataService      departmentDataService;

  private final IWorkflowMessageDataService workflowMessageDataService;

  private final IProfileCachDataDataService cachDataDataService;

  private final IWorkflowPrepare            workflowPrepare;

  public WorkStrategyFactory(@Autowired final IWorkflowDataService workflowDataService,
      @Autowired final IDepartmentDataService departmentDataService,
      @Autowired final IWorkflowMessageDataService workflowMessageDataService,
      @Autowired final IProfileCachDataDataService cachDataDataService, @Autowired final IWorkflowPrepare workflowPrepare) {
    this.workflowDataService = workflowDataService;
    this.departmentDataService = departmentDataService;
    this.workflowMessageDataService = workflowMessageDataService;
    this.cachDataDataService = cachDataDataService;
    this.workflowPrepare = workflowPrepare;

  }

  @Override
  public IWorkflowSaveStrategy selectSaveWorkStrategy(final WorkflowSaveRequest workflowSaveRequest, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("selecting save strategy for workflow");

    if (workflowSaveRequest.isCreateCommand()) {
      if (workflowSaveRequest.getWorkflow().getWorkflowType().isAssignTypeManual()) {
        logger.debug("The CreateManualAssignWorkflowStrategy is selected for workflow save");
        return new CreateManualAssignWorkflowStrategy(workflowSaveRequest, token, departmentDataService, workflowMessageDataService,
            cachDataDataService, workflowDataService, workflowPrepare);
      }

      if (workflowSaveRequest.getWorkflow().getWorkflowType().isAssignTypeOffering()) {
        logger.debug("The CreateOfferlAssignWorkflowStrategy is selected for workflow save");
        return new CreateOfferlAssignWorkflowStrategy(workflowSaveRequest, token, departmentDataService, workflowMessageDataService,
            cachDataDataService, workflowDataService, workflowPrepare);
      }
    }

    if (workflowSaveRequest.isArchiveCommand()) {
      logger.debug("The ArchivingWorkflowStrategy is selected for workflow save");
      return new ArchivingWorkflowStrategy(workflowSaveRequest, token, departmentDataService, workflowMessageDataService,
          cachDataDataService, workflowDataService, workflowPrepare);
    }

    if (workflowSaveRequest.isSaveCommand()) {
      logger.debug("The SaveExistingWorkflowStrategy is selected for workflow save");
      return new SaveExistingWorkflowStrategy(workflowSaveRequest, token, departmentDataService, workflowMessageDataService,
          cachDataDataService, workflowDataService, workflowPrepare);
    }

    if (workflowSaveRequest.isAssignCommand()) {
      logger.debug("The AssignWorkflowStrategy is selected for workflow save");
      return new AssignWorkflowStrategy(workflowSaveRequest, token, departmentDataService, workflowMessageDataService,
          cachDataDataService, workflowDataService, workflowPrepare);
    }

    if (workflowSaveRequest.isDoneCommand()) {
      logger.debug("The DoneExistingWorkflowStrategy is selected for workflow save");
      return new DoneExistingWorkflowStrategy(workflowSaveRequest, token, departmentDataService, workflowMessageDataService,
          cachDataDataService, workflowDataService, workflowPrepare);
    }

    throw new WorkflowCustomizedException("Unknown workflow save strategy ", EIFlowErrorType.UNKNOWN_WORKFLOW_STRATEGY);
  }

  @Override
  public IWorkflowSaveStrategy selectValidationWorkStrategy(final WorkflowSaveRequest workflowSaveRequest, final String token)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("selecting validation strategy for workflow");

    if (workflowSaveRequest.isCreateCommand()) {
      if (workflowSaveRequest.getWorkflow().getWorkflowType().isAssignTypeManual()) {
        logger.debug("The CreateManualAssignWorkflowValidationStrategy is selected for workflow validation");
        return new CreateManualAssignWorkflowValidationStrategy(workflowSaveRequest, token, departmentDataService,
            workflowMessageDataService, cachDataDataService, workflowDataService, workflowPrepare);
      }

      if (workflowSaveRequest.getWorkflow().getWorkflowType().isAssignTypeOffering()) {
        logger.debug("The CreateOfferlAssignWorkflowValidationStrategy is selected for workflow validation");
        return new CreateOfferlAssignWorkflowValidationStrategy(workflowSaveRequest, token, departmentDataService,
            workflowMessageDataService, cachDataDataService, workflowDataService, workflowPrepare);
      }
    }

    if (workflowSaveRequest.isArchiveCommand()) {
      logger.debug("The ArchivingWorkflowValidationStrategy is selected for workflow validation");
      return new ArchivingWorkflowValidationStrategy(workflowSaveRequest, token, departmentDataService, workflowMessageDataService,
          cachDataDataService, workflowDataService, workflowPrepare);
    }

    if (workflowSaveRequest.isSaveCommand()) {
      logger.debug("The SaveExistingWorkflowValidationStrategy is selected for workflow validation");
      return new SaveExistingWorkflowValidationStrategy(workflowSaveRequest, token, departmentDataService, workflowMessageDataService,
          cachDataDataService, workflowDataService, workflowPrepare);
    }

    if (workflowSaveRequest.isAssignCommand()) {
      logger.debug("The AssignWorkflowValidationStrategy is selected for workflow validation");
      return new AssignWorkflowValidationStrategy(workflowSaveRequest, token, departmentDataService, workflowMessageDataService,
          cachDataDataService, workflowDataService, workflowPrepare);
    }

    if (workflowSaveRequest.isDoneCommand()) {
      logger.debug("The DoneExistingWorkflowValidationStrategy is selected for workflow validation");
      return new DoneExistingWorkflowValidationStrategy(workflowSaveRequest, token, departmentDataService, workflowMessageDataService,
          cachDataDataService, workflowDataService, workflowPrepare);
    }

    throw new WorkflowCustomizedException("Unknown workflow validation strategy ", EIFlowErrorType.UNKNOWN_WORKFLOW_STRATEGY);
  }
}

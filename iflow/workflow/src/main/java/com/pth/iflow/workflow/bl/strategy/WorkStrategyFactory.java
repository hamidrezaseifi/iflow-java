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
import com.pth.iflow.workflow.models.base.IWorkflow;
import com.pth.iflow.workflow.models.base.IWorkflowSaveRequest;

@Service
public class WorkStrategyFactory<W extends IWorkflow> implements IWorkStrategyFactory<W> {

  private static final Logger logger = LoggerFactory.getLogger(WorkStrategyFactory.class);

  private final IWorkflowDataService<W> invoiceWorkflowDataService;

  private final IDepartmentDataService departmentDataService;

  private final IWorkflowMessageDataService workflowMessageDataService;

  private final IProfileCachDataDataService cachDataDataService;

  private final IWorkflowPrepare<W> invoiceWorkflowPrepare;

  public WorkStrategyFactory(@Autowired final IWorkflowDataService<W> workflowDataService,
                             @Autowired final IDepartmentDataService departmentDataService,
                             @Autowired final IWorkflowMessageDataService workflowMessageDataService,
                             @Autowired final IProfileCachDataDataService cachDataDataService,
                             @Autowired final IWorkflowPrepare<W> invoiceWorkflowPrepare) {
    this.invoiceWorkflowDataService = workflowDataService;
    this.departmentDataService = departmentDataService;
    this.workflowMessageDataService = workflowMessageDataService;
    this.cachDataDataService = cachDataDataService;
    this.invoiceWorkflowPrepare = invoiceWorkflowPrepare;

  }

  @Override
  public IWorkflowSaveStrategy<W> selectSaveWorkStrategy(final IWorkflowSaveRequest<W> workflowSaveRequest, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("selecting save strategy for workflow");

    if (workflowSaveRequest.isCreateCommand()) {
      if (workflowSaveRequest.getWorkflow().getWorkflowType().isAssignTypeManual()) {
        logger.debug("The CreateManualAssignWorkflowStrategy is selected for workflow save");
        return new CreateManualAssignWorkflowStrategy<W>(workflowSaveRequest,
                                                         token,
                                                         departmentDataService,
                                                         workflowMessageDataService,
                                                         cachDataDataService,
                                                         invoiceWorkflowDataService,
                                                         invoiceWorkflowPrepare);
      }

      if (workflowSaveRequest.getWorkflow().getWorkflowType().isAssignTypeOffering()) {
        logger.debug("The CreateOfferlAssignWorkflowStrategy is selected for workflow save");
        return new CreateOfferlAssignWorkflowStrategy<W>(workflowSaveRequest,
                                                         token,
                                                         departmentDataService,
                                                         workflowMessageDataService,
                                                         cachDataDataService,
                                                         invoiceWorkflowDataService,
                                                         invoiceWorkflowPrepare);
      }
    }

    if (workflowSaveRequest.isArchiveCommand()) {
      logger.debug("The ArchivingWorkflowStrategy is selected for workflow save");
      return new ArchivingWorkflowStrategy<W>(workflowSaveRequest,
                                              token,
                                              departmentDataService,
                                              workflowMessageDataService,
                                              cachDataDataService,
                                              invoiceWorkflowDataService,
                                              invoiceWorkflowPrepare);
    }

    if (workflowSaveRequest.isSaveCommand()) {
      logger.debug("The SaveExistingWorkflowStrategy is selected for workflow save");
      return new SaveExistingWorkflowStrategy<W>(workflowSaveRequest,
                                                 token,
                                                 departmentDataService,
                                                 workflowMessageDataService,
                                                 cachDataDataService,
                                                 invoiceWorkflowDataService,
                                                 invoiceWorkflowPrepare);
    }

    if (workflowSaveRequest.isAssignCommand()) {
      logger.debug("The AssignWorkflowStrategy is selected for workflow save");
      return new AssignWorkflowStrategy<W>(workflowSaveRequest,
                                           token,
                                           departmentDataService,
                                           workflowMessageDataService,
                                           cachDataDataService,
                                           invoiceWorkflowDataService,
                                           invoiceWorkflowPrepare);
    }

    if (workflowSaveRequest.isDoneCommand()) {
      logger.debug("The DoneExistingWorkflowStrategy is selected for workflow save");
      return new DoneExistingWorkflowStrategy<W>(workflowSaveRequest,
                                                 token,
                                                 departmentDataService,
                                                 workflowMessageDataService,
                                                 cachDataDataService,
                                                 invoiceWorkflowDataService,
                                                 invoiceWorkflowPrepare);
    }

    throw new WorkflowCustomizedException("Unknown workflow save strategy ", EIFlowErrorType.UNKNOWN_WORKFLOW_STRATEGY);
  }

  @Override
  public IWorkflowSaveStrategy<W> selectValidationWorkStrategy(final IWorkflowSaveRequest<W> workflowSaveRequest, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("selecting validation strategy for workflow");

    if (workflowSaveRequest.isCreateCommand()) {
      if (workflowSaveRequest.getWorkflow().getWorkflowType().isAssignTypeManual()) {
        logger.debug("The CreateManualAssignWorkflowValidationStrategy is selected for workflow validation");
        return new CreateManualAssignWorkflowValidationStrategy<W>(workflowSaveRequest,
                                                                   token,
                                                                   departmentDataService,
                                                                   workflowMessageDataService,
                                                                   cachDataDataService,
                                                                   invoiceWorkflowDataService,
                                                                   invoiceWorkflowPrepare);
      }

      if (workflowSaveRequest.getWorkflow().getWorkflowType().isAssignTypeOffering()) {
        logger.debug("The CreateOfferlAssignWorkflowValidationStrategy is selected for workflow validation");
        return new CreateOfferlAssignWorkflowValidationStrategy<W>(workflowSaveRequest,
                                                                   token,
                                                                   departmentDataService,
                                                                   workflowMessageDataService,
                                                                   cachDataDataService,
                                                                   invoiceWorkflowDataService,
                                                                   invoiceWorkflowPrepare);
      }
    }

    if (workflowSaveRequest.isArchiveCommand()) {
      logger.debug("The ArchivingWorkflowValidationStrategy is selected for workflow validation");
      return new ArchivingWorkflowValidationStrategy<W>(workflowSaveRequest,
                                                        token,
                                                        departmentDataService,
                                                        workflowMessageDataService,
                                                        cachDataDataService,
                                                        invoiceWorkflowDataService,
                                                        invoiceWorkflowPrepare);
    }

    if (workflowSaveRequest.isSaveCommand()) {
      logger.debug("The SaveExistingWorkflowValidationStrategy is selected for workflow validation");
      return new SaveExistingWorkflowValidationStrategy<W>(workflowSaveRequest,
                                                           token,
                                                           departmentDataService,
                                                           workflowMessageDataService,
                                                           cachDataDataService,
                                                           invoiceWorkflowDataService,
                                                           invoiceWorkflowPrepare);
    }

    if (workflowSaveRequest.isAssignCommand()) {
      logger.debug("The AssignWorkflowValidationStrategy is selected for workflow validation");
      return new AssignWorkflowValidationStrategy<W>(workflowSaveRequest,
                                                     token,
                                                     departmentDataService,
                                                     workflowMessageDataService,
                                                     cachDataDataService,
                                                     invoiceWorkflowDataService,
                                                     invoiceWorkflowPrepare);
    }

    if (workflowSaveRequest.isDoneCommand()) {
      logger.debug("The DoneExistingWorkflowValidationStrategy is selected for workflow validation");
      return new DoneExistingWorkflowValidationStrategy<W>(workflowSaveRequest,
                                                           token,
                                                           departmentDataService,
                                                           workflowMessageDataService,
                                                           cachDataDataService,
                                                           invoiceWorkflowDataService,
                                                           invoiceWorkflowPrepare);
    }

    throw new WorkflowCustomizedException("Unknown workflow validation strategy ", EIFlowErrorType.UNKNOWN_WORKFLOW_STRATEGY);
  }
}

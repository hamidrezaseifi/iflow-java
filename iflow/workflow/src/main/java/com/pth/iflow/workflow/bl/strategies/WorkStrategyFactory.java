package com.pth.iflow.workflow.bl.strategies;

import java.net.MalformedURLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.common.enums.EWorkflowProcessCommand;
import com.pth.iflow.common.enums.EWorkflowTypeAssignType;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.ICachDataDataService;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.bl.strategies.create.CreateManualAssignWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.create.CreateOfferlAssignWorkflowStrategy;
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

  private static final Logger logger = LoggerFactory.getLogger(WorkStrategyFactory.class);

  private final IWorkflowDataService workflowDataService;

  private final IWorkflowTypeDataService workflowTypeDataService;

  private final IDepartmentDataService departmentDataService;

  private final IWorkflowMessageDataService workflowMessageDataService;

  private final ICachDataDataService cachDataDataService;

  public WorkStrategyFactory(@Autowired final IWorkflowDataService workflowDataService,
                             @Autowired final IWorkflowTypeDataService workflowTypeDataService,
                             @Autowired final IDepartmentDataService departmentDataService,
                             @Autowired final IWorkflowMessageDataService workflowMessageDataService,
                             @Autowired final ICachDataDataService cachDataDataService) {
    this.workflowDataService = workflowDataService;
    this.workflowTypeDataService = workflowTypeDataService;
    this.departmentDataService = departmentDataService;
    this.workflowMessageDataService = workflowMessageDataService;
    this.cachDataDataService = cachDataDataService;

  }

  /*
   * (non-Javadoc)
   *
   * @see com.pth.iflow.workflow.bl.strategies.IWorkStrategyFactory#selectWorkStrategy( com.pth.iflow.workflow.models.Workflow)
   */
  @Override
  public ISaveWorkflowStrategy selectSaveWorkStrategy(final Workflow processingWorkflow, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("selecting save strategy for workflow");
    final WorkflowType workflowType = this.workflowTypeDataService.getById(processingWorkflow.getWorkflowTypeId(), token);
    final WorkflowAction activeAction = processingWorkflow.hasActiveAction() ? processingWorkflow.getActiveAction() : null;

    if (processingWorkflow.getCommand() == EWorkflowProcessCommand.CREATE) {
      logger.debug("The SaveNewWorkflowStrategy is selected for workflow");
      return new SaveNewWorkflowStrategy(processingWorkflow, workflowType, token, activeAction, this.workflowDataService);
    }

    if (processingWorkflow.getCommand() == EWorkflowProcessCommand.ARCHIVE) {
      logger.debug("The ArchivingWorkflowStrategy is selected for workflow");
      return new ArchivingWorkflowStrategy(processingWorkflow, workflowType, token, activeAction, this.workflowDataService);
    }

    if (processingWorkflow.getCommand() == EWorkflowProcessCommand.SAVE) {
      logger.debug("The SaveExistingWorkflowStrategy is selected for workflow");
      return new SaveExistingWorkflowStrategy(processingWorkflow, workflowType, token, activeAction, this.workflowDataService);
    }

    if (processingWorkflow.getCommand() == EWorkflowProcessCommand.DONE) {
      logger.debug("The DoneExistingWorkflowStrategy is selected for workflow");
      return new DoneExistingWorkflowStrategy(processingWorkflow, workflowType, token, activeAction, this.workflowDataService);
    }

    throw new IFlowCustomeException("Unknown workflow save strategy id:" + processingWorkflow.getId(),
                                    EIFlowErrorType.UNKNOWN_WORKFLOW_SAVE_STRATEGY);

  }

  @Override
  public ICreateWorkflowStrategy selectCreateWorkStrategy(final WorkflowCreateRequest workflowCreateRequest, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("selecting create strategy for workflow create request");

    final WorkflowType workflowType = this.workflowTypeDataService.getById(workflowCreateRequest.getWorkflow().getWorkflowTypeId(),
                                                                           token);

    if (workflowType.geAssignType() == EWorkflowTypeAssignType.MANUAL) {
      return new CreateManualAssignWorkflowStrategy(workflowCreateRequest,
                                                    token,
                                                    this,
                                                    departmentDataService,
                                                    workflowMessageDataService,
                                                    cachDataDataService,
                                                    workflowType);
    }

    if (workflowType.geAssignType() == EWorkflowTypeAssignType.OFFER) {
      return new CreateOfferlAssignWorkflowStrategy(workflowCreateRequest,
                                                    token,
                                                    this,
                                                    departmentDataService,
                                                    workflowMessageDataService,
                                                    cachDataDataService,
                                                    workflowType);
    }

    throw new IFlowCustomeException("Unknown workflow create strategy ", EIFlowErrorType.UNKNOWN_WORKFLOW_CREATE_STRATEGY);
  }
}

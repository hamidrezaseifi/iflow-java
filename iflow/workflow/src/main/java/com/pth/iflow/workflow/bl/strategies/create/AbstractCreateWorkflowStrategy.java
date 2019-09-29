package com.pth.iflow.workflow.bl.strategies.create;

import java.net.MalformedURLException;
import java.util.Set;

import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.ICachDataDataService;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategies.ICreateWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.ISaveWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategies.IWorkStrategyFactory;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowCreateRequest;
import com.pth.iflow.workflow.models.WorkflowMessage;
import com.pth.iflow.workflow.models.WorkflowType;

public abstract class AbstractCreateWorkflowStrategy implements ICreateWorkflowStrategy {

  private final WorkflowCreateRequest       workflowCreateRequest;
  private final WorkflowType                workflowType;
  private final String                      token;
  private final IWorkStrategyFactory        workStrategyFactory;
  private final IDepartmentDataService      departmentDataService;
  private final IWorkflowMessageDataService workflowMessageDataService;
  private final ICachDataDataService        cachDataDataService;

  public AbstractCreateWorkflowStrategy(final WorkflowCreateRequest workflowCreateRequest, final String token,
      final IWorkStrategyFactory workStrategyFactory, final IDepartmentDataService departmentDataService,
      final IWorkflowMessageDataService workflowMessageDataService, final ICachDataDataService cachDataDataService,
      final WorkflowType workflowType) {
    super();
    this.workflowCreateRequest = workflowCreateRequest;
    this.token = token;
    this.workStrategyFactory = workStrategyFactory;
    this.departmentDataService = departmentDataService;
    this.workflowMessageDataService = workflowMessageDataService;
    this.cachDataDataService = cachDataDataService;
    this.workflowType = workflowType;
  }

  protected Workflow saveWorkflow(final Workflow workflow)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    final ISaveWorkflowStrategy saveWorkflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(workflow, this.token);

    final Workflow savedWorkflow = saveWorkflowStrategy.process();

    return savedWorkflow;
  }

  public WorkflowCreateRequest getWorkflowCreateRequest() {
    return workflowCreateRequest;
  }

  public WorkflowType getWorkflowType() {
    return workflowType;
  }

  public String getToken() {
    return token;
  }

  public IWorkStrategyFactory getWorkStrategyFactory() {
    return workStrategyFactory;
  }

  public IDepartmentDataService getDepartmentDataService() {
    return departmentDataService;
  }

  public IWorkflowMessageDataService getWorkflowMessageDataService() {
    return workflowMessageDataService;
  }

  protected void verifyAssigns() {
    if (this.getWorkflowCreateRequest().getAssigns().isEmpty()) {
      throw new IFlowCustomeException("No assign by workflow create", EIFlowErrorType.NO_WORKFLOW_ASSIGN_CREATE_STRATEGY);
    }
  }

  protected void createWorkflowMessage(final Long workflowId, final Long createdById, final Long userId)
      throws MalformedURLException, IFlowMessageConversionFailureException {
    final WorkflowMessage message = new WorkflowMessage();
    message.setCreatedBy(createdById);
    message.setExpireDays(this.getWorkflowCreateRequest().getExpireDays());
    message.setMessage("Offering Workflow Message");
    message.setMessageType(EWorkflowMessageType.OFFERING_WORKFLOW);
    message.setStatus(EWorkflowMessageStatus.OFFERING);
    message.setUserId(userId);
    message.setWorkflowId(workflowId);
    message.setVersion(1);
    getWorkflowMessageDataService().save(message, this.getToken());
  }

  protected void resetUserCachData(final Long companyId, final Long userId)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    cachDataDataService.resetCachDataForUser(companyId, userId, token);
  }

  protected void resetUserListCachData(final Long companyId, final Set<Long> userIdList)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    cachDataDataService.resetCachDataForUserList(companyId, userIdList, token);
  }

}

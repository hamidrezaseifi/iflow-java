package com.pth.iflow.workflow.bl.strategy.strategies;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.ICachDataDataService;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategy.IWorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategy;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategyStep;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.AssignItem;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowMessage;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

public abstract class AbstractWorkflowSaveStrategy implements IWorkflowSaveStrategy {

  private final IWorkStrategyFactory        workStrategyFactory;
  private final IDepartmentDataService      departmentDataService;
  private final IWorkflowMessageDataService workflowMessageDataService;
  private final ICachDataDataService        cachDataDataService;
  private final IWorkflowDataService        workflowDataService;

  protected final WorkflowSaveRequest processingWorkflowSaveRequest;
  protected final WorkflowType        processingWorkflowType;
  protected final String              token;
  protected final WorkflowAction      activeAction;

  protected final List<IWorkflowSaveStrategyStep> steps = new ArrayList<>();

  protected final List<Workflow> savedWorkflowList = new ArrayList<>();

  protected Workflow savedSingleWorkflow = null;

  public AbstractWorkflowSaveStrategy(final WorkflowSaveRequest workflowCreateRequest,
                                      final String token,
                                      final IWorkStrategyFactory workStrategyFactory,
                                      final IDepartmentDataService departmentDataService,
                                      final IWorkflowMessageDataService workflowMessageDataService,
                                      final ICachDataDataService cachDataDataService,
                                      final IWorkflowDataService workflowDataService) {
    super();
    this.processingWorkflowSaveRequest = workflowCreateRequest;
    this.token = token;
    this.workStrategyFactory = workStrategyFactory;
    this.departmentDataService = departmentDataService;
    this.workflowMessageDataService = workflowMessageDataService;
    this.workflowDataService = workflowDataService;
    this.cachDataDataService = cachDataDataService;
    this.processingWorkflowType = workflowCreateRequest.getWorkflow().getWorkflowType();
    this.activeAction = workflowCreateRequest.getWorkflow().getActiveAction();
  }

  protected Workflow saveWorkflow1(final WorkflowSaveRequest saveRequest) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    final IWorkflowSaveStrategy saveWorkflowStrategy = this.workStrategyFactory.selectWorkStrategy(saveRequest, this.token);

    // final Workflow savedWorkflow = saveWorkflowStrategy.process();

    return null;
  }

  public WorkflowType getWorkflowType() {
    return processingWorkflowType;
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
    if (this.processingWorkflowSaveRequest.getAssigns().isEmpty()) {
      throw new IFlowCustomeException("No assign by workflow create", EIFlowErrorType.NO_WORKFLOW_ASSIGN_CREATE_STRATEGY);
    }
  }

  protected void createWorkflowMessage(final Long workflowId, final Long createdById, final Long userId) throws MalformedURLException, IFlowMessageConversionFailureException {
    final WorkflowMessage message = new WorkflowMessage();
    message.setCreatedBy(createdById);
    message.setExpireDays(this.processingWorkflowSaveRequest.getExpireDays());
    message.setMessage("Offering Workflow Message");
    message.setMessageType(EWorkflowMessageType.OFFERING_WORKFLOW);
    message.setStatus(EWorkflowMessageStatus.OFFERING);
    message.setUserId(userId);
    message.setWorkflowId(workflowId);
    message.setVersion(1);
    getWorkflowMessageDataService().save(message, this.getToken());
  }

  protected void resetUserCachData(final Long companyId, final Long userId) throws MalformedURLException, IFlowMessageConversionFailureException {

    cachDataDataService.resetCachDataForUser(companyId, userId, token);
  }

  protected void resetUserListCachData(final Long companyId, final Set<Long> userIdList) throws MalformedURLException, IFlowMessageConversionFailureException {

    cachDataDataService.resetCachDataForUserList(companyId, userIdList, token);
  }

  protected WorkflowSaveRequest creaeOneAssignedWorkflowSaveRequest(final Workflow workflow, final Long userId) {
    final WorkflowSaveRequest saveRequest = new WorkflowSaveRequest();
    saveRequest.setWorkflow(workflow);
    final AssignItem assignItem = new AssignItem(userId, EAssignType.USER);
    saveRequest.setAssigns(Arrays.asList(assignItem));
    saveRequest.setExpireDays(1);
    return saveRequest;
  }

  protected WorkflowSaveRequest creaeNotAssignedWorkflowSaveRequest(final Workflow workflow) {
    final WorkflowSaveRequest saveRequest = new WorkflowSaveRequest();
    saveRequest.setWorkflow(workflow);
    saveRequest.setAssigns(Arrays.asList());
    saveRequest.setExpireDays(1);
    return saveRequest;
  }

  public Workflow saveWorkflow(final Workflow workflow) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    final Workflow savedWorkflow = this.workflowDataService.save(workflow, this.token);

    return savedWorkflow;
  }

  protected void validateWorkflowCurrectStep(final Workflow workflow, final WorkflowType workflowType) throws MalformedURLException {

    if (workflow.getCurrentStep() == null) {

      if ((workflow.getCurrentStepId() != null) && (workflow.getCurrentStepId() > 0)) {
        this.setWorkflowCurrectStepFromCurrectStepId(workflow, workflowType);
      }
      else {
        this.setworkflowCurrectStep(workflow, workflowType);
      }
    }

    if (workflow.getCurrentStep() == null) {

      throw new IFlowCustomeException("Unknown workflow step id:" + workflow.getId(), EIFlowErrorType.UNKNOWN_WORKFLOW_TYPE_STEP);
    }

    this.validateCurrentStepExistsInWorkflowType(workflow, workflowType);

  }

  protected void validateWorkflowAssignedUser(final Workflow workflow, final WorkflowType workflowType) {

    if (workflow.isAssigned() == false) {
      // throw new IFlowCustomeException("Unknown workflow assigned user id:" +
      // workflow.getId(),
      // EIFlowErrorType.UNKNOWN_WORKFLOW_ASSIGN);
    }
  }

  private void setworkflowCurrectStep(final Workflow workflow, final WorkflowType workflowType) {
    if ((workflow.getCurrentStepId() == null) || (workflow.getCurrentStepId() <= 0)) {
      if (workflow.isInitializing() || workflow.isOffering()) {
        final WorkflowTypeStep firstStep = this.findFirstStep(workflowType);
        if (firstStep != null) {
          workflow.setCurrentStep(firstStep);
          workflow.setCurrentStepId(firstStep.getId());
        }

      }
    }
  }

  public WorkflowTypeStep findFirstStep(final WorkflowType workflowType) {
    final List<WorkflowTypeStep> steps = this.getSortedStepsList(workflowType);

    return steps.size() > 0 ? steps.get(0) : null;
  }

  private Map<Long, WorkflowTypeStep> getIdKeySteps(final WorkflowType workflowType) {
    final Map<Long, WorkflowTypeStep> map = workflowType.getSteps()
                                                        .stream()
                                                        .collect(Collectors.toMap(step -> step.getId(), step -> step));

    return map;
  }

  private Map<Integer, WorkflowTypeStep> getIndexKeySteps(final WorkflowType workflowType) {
    final Map<Integer, WorkflowTypeStep> map = workflowType.getSteps()
                                                           .stream()
                                                           .collect(Collectors.toMap(step -> step.getStepIndex(), step -> step));

    return map;
  }

  private List<Integer> getSortedStepIndexs(final WorkflowType workflowType) {
    final List<Integer> list = workflowType.getSteps().stream().map(step -> step.getStepIndex()).sorted().collect(Collectors.toList());

    return list;
  }

  private WorkflowTypeStep findNextStep(final WorkflowType workflowType, final Workflow workflow) {

    final WorkflowTypeStep currectStep = workflow.getLastAction().getCurrentStep();

    final Map<Integer, WorkflowTypeStep> steps = this.getIndexKeySteps(workflowType);
    final List<Integer> sortedIndexes = getSortedStepIndexs(workflowType);

    final Integer stepIndex = sortedIndexes.indexOf(currectStep.getStepIndex());
    final Integer nextStepIndex = stepIndex + 1;
    return nextStepIndex < sortedIndexes.size() ? steps.get(nextStepIndex) : currectStep;

  }

  private boolean isLastStep(final WorkflowType workflowType, final WorkflowTypeStep step) {
    final WorkflowTypeStep lastStep = this.findLastStep(workflowType);

    return step.getStepIndex() == lastStep.getStepIndex();
  }

  private WorkflowTypeStep findLastStep(final WorkflowType workflowType) {
    final List<WorkflowTypeStep> steps = this.getSortedStepsList(workflowType);

    return steps.size() > 0 ? steps.get(steps.size() - 1) : null;
  }

  private List<WorkflowTypeStep> getSortedStepsList(final WorkflowType workflowType) {

    final List<WorkflowTypeStep> list = workflowType.getSteps().stream().sorted(new Comparator<WorkflowTypeStep>() {

      @Override
      public int compare(final WorkflowTypeStep o1, final WorkflowTypeStep o2) {

        return o1.getStepIndex() > o2.getStepIndex() ? 1 : o1.getStepIndex() == o2.getStepIndex() ? 0 : -1;
      }
    }).collect(Collectors.toList());

    return list;
  }

  private void setWorkflowCurrectStepFromCurrectStepId(final Workflow workflow, final WorkflowType workflowType) throws MalformedURLException {
    if (workflow.getCurrentStep() == null) {
      if ((workflow.getCurrentStepId() != null) && (workflow.getCurrentStepId() > 0)) {

        final Long stepId = workflow.getCurrentStepId();
        final WorkflowTypeStep foundStep = this.findWorkflowStepinWorkflowTypeById(workflowType, stepId);

        workflow.setCurrentStep(foundStep);
      }
    }
  }

  public WorkflowTypeStep findWorkflowStepinWorkflowTypeById(final WorkflowType workflowType, final Long stepId) {
    WorkflowTypeStep foundStep = null;
    for (final WorkflowTypeStep step : workflowType.getSteps()) {
      if (step.getId() == stepId) {
        foundStep = step;
        break;
      }
    }
    return foundStep;
  }

  public void validateCurrentStepExistsInWorkflowType(final Workflow newWorkflow, final WorkflowType workflowType) {
    final List<Long> stepIdList = this.getWorkflowTypeIdList(workflowType);

    if (stepIdList.contains(newWorkflow.getCurrentStep().getId()) == false) {
      throw new IFlowCustomeException("Invalid workflow step id:" + newWorkflow.getId(), EIFlowErrorType.INVALID_WORKFLOW_STEP);
    }
  }

  private List<Long> getWorkflowTypeIdList(final WorkflowType workflowType) {
    return workflowType.getSteps().stream().map(step -> step.getId()).collect(Collectors.toList());
  }

  protected void selectWorkflowNextStep(final Workflow newWorkflow, final WorkflowType workflowType, final WorkflowAction activeAction) {

    final WorkflowTypeStep nextStep = this.findNextStep(workflowType, newWorkflow);
    if (nextStep == null) {
      throw new IFlowCustomeException("Invalid workflow step id:" + newWorkflow.getId(), EIFlowErrorType.INVALID_WORKFLOW_STEP);
    }

    newWorkflow.setCurrentStep(nextStep);
    newWorkflow.setCurrentStepId(nextStep.getId());

    if (this.isLastStep(workflowType, nextStep)) {
      newWorkflow.setStatus(EWorkflowStatus.DONE);
    }

  }

  protected WorkflowAction initialFirstStep() {
    final WorkflowTypeStep firstStep = this.findFirstStep(this.processingWorkflowSaveRequest.getWorkflow().getWorkflowType());

    final WorkflowAction action = new WorkflowAction();
    action.setAction("action");
    action.setAssignTo(0L);
    action.setComments("");
    action.setCreatedBy(this.processingWorkflowSaveRequest.getWorkflow().getCreatedBy());
    action.setCurrentStep(firstStep);
    action.setCurrentStepId(firstStep.getId());
    action.setStatus(EWorkflowActionStatus.INITIALIZE);
    action.setVersion(1);
    action.setWorkflowId(this.processingWorkflowSaveRequest.getWorkflow().getId());
    return action;
  }

  protected WorkflowAction initialNextStep() {

    final WorkflowTypeStep nextStep = this.findNextStep(processingWorkflowType, getProcessingWorkflow());

    if (nextStep != null) {
      final WorkflowAction action = new WorkflowAction();
      action.setAction("action");
      action.setAssignTo(0L);
      action.setComments("");
      action.setCreatedBy(this.processingWorkflowSaveRequest.getWorkflow().getCreatedBy());
      action.setCurrentStep(nextStep);
      action.setCurrentStepId(nextStep.getId());
      action.setStatus(EWorkflowActionStatus.INITIALIZE);
      action.setVersion(1);
      action.setWorkflowId(this.processingWorkflowSaveRequest.getWorkflow().getId());
      return action;
    }
    return null;
  }

  public boolean hasNextStep(final IWorkflowSaveStrategyStep currentStep) {
    final int index = steps.indexOf(currentStep);
    return index < steps.size() - 1;
  }

  public IWorkflowSaveStrategyStep getNextStep(final IWorkflowSaveStrategyStep currentStep) {
    final int index = currentStep != null ? steps.indexOf(currentStep) : -1;
    return steps.get(index + 1);
  }

  public IWorkflowSaveStrategyStep getFirstStep() {
    return steps.get(0);
  }

  public WorkflowSaveRequest getProcessingWorkflowSaveRequest() {
    return processingWorkflowSaveRequest;
  }

  public Workflow getProcessingWorkflow() {
    return processingWorkflowSaveRequest.getWorkflow();
  }

  public void setProcessingWorkflow(final Workflow workflow) {
    processingWorkflowSaveRequest.setWorkflow(workflow);
  }

  public WorkflowAction getActiveAction() {
    return activeAction;
  }

  public WorkflowType getProcessingWorkflowType() {
    return processingWorkflowType;
  }

  public IWorkflowDataService getWorkflowDataService() {
    return workflowDataService;
  }

  public Workflow getSavedSingleWorkflow() {
    return savedSingleWorkflow;
  }

  public void setSavedSingleWorkflow(final Workflow savedSingleWorkflow) {
    this.savedSingleWorkflow = savedSingleWorkflow;
  }

}

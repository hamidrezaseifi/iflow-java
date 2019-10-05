package com.pth.iflow.workflow.bl.strategy.strategies;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.enums.EWorkflowMessageType;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IProfileCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategy;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategyStep;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.User;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowMessage;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

public abstract class AbstractWorkflowSaveStrategy implements IWorkflowSaveStrategy {

  private final IDepartmentDataService            departmentDataService;
  private final IWorkflowMessageDataService       workflowMessageDataService;
  private final IProfileCachDataDataService       profileCachDataDataService;
  private final IWorkflowDataService              workflowDataService;

  protected final WorkflowSaveRequest             processingWorkflowSaveRequest;
  protected final String                          token;
  protected final WorkflowAction                  prevActiveAction;
  protected final Workflow                        existsingWorkflow;

  protected final List<IWorkflowSaveStrategyStep> steps               = new ArrayList<>();

  protected final List<Workflow>                  savedWorkflowList   = new ArrayList<>();

  protected Workflow                              savedSingleWorkflow = null;

  private final Set<Long>                         assignedUsers       = new HashSet<>();

  public AbstractWorkflowSaveStrategy(final WorkflowSaveRequest workflowCreateRequest, final String token,
      final IDepartmentDataService departmentDataService, final IWorkflowMessageDataService workflowMessageDataService,
      final IProfileCachDataDataService profileCachDataDataService, final IWorkflowDataService workflowDataService)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    super();
    this.processingWorkflowSaveRequest = workflowCreateRequest;
    this.token = token;
    this.departmentDataService = departmentDataService;
    this.workflowMessageDataService = workflowMessageDataService;
    this.workflowDataService = workflowDataService;
    this.profileCachDataDataService = profileCachDataDataService;
    this.prevActiveAction = workflowCreateRequest.getWorkflow().getActiveAction();

    this.existsingWorkflow = getProcessingWorkflow().isNew() ? null
        : workflowDataService.getById(getProcessingWorkflow().getId(), token);

    this.setup();
  }

  public String getToken() {
    return token;
  }

  public IDepartmentDataService getDepartmentDataService() {
    return departmentDataService;
  }

  public IWorkflowMessageDataService getWorkflowMessageDataService() {
    return workflowMessageDataService;
  }

  public void createWorkflowMessage(final Long workflowId, final Long stepId, final Long createdById, final Long userId)
      throws MalformedURLException, IFlowMessageConversionFailureException {
    final WorkflowMessage message = new WorkflowMessage();
    message.setCreatedBy(createdById);
    message.setExpireDays(this.processingWorkflowSaveRequest.getExpireDays());
    message.setMessage("Offering Workflow Message");
    message.setMessageType(EWorkflowMessageType.OFFERING_WORKFLOW);
    message.setStatus(EWorkflowMessageStatus.OFFERING);
    message.setUserId(userId);
    message.setWorkflowId(workflowId);
    message.setStepId(stepId);
    message.setVersion(1);
    getWorkflowMessageDataService().save(message, this.getToken());
  }

  public void updateWorkflowMessageStatus(final Long workflowId, final Long stepId, final EWorkflowMessageStatus status)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    workflowMessageDataService.updateWorkflowMessageStatus(workflowId, stepId, status, this.getToken());
  }

  public void updateUserAndWorkflowMessageStatus(final Long workflowId, final Long stepId, final Long userId,
      final EWorkflowMessageStatus status) throws MalformedURLException, IFlowMessageConversionFailureException {

    workflowMessageDataService.updateUserAndWorkflowMessageStatus(workflowId, stepId, userId, status, this.getToken());
  }

  public void resetUserListCachData(final Long companyId, final Set<Long> userIdList)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    profileCachDataDataService.resetCachDataForUserList(companyId, userIdList, token);
  }

  public void resetWorkflowtCachData(final Long companyId, final Long workflowId)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    profileCachDataDataService.resetCachDataForWorkflow(companyId, workflowId, token);
  }

  public Workflow saveWorkflow(final Workflow workflow)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    final Workflow savedWorkflow = this.workflowDataService.save(workflow, this.token);

    return savedWorkflow;
  }

  public WorkflowTypeStep findFirstStep(final WorkflowType workflowType) {
    final List<WorkflowTypeStep> steps = this.getSortedStepsList(workflowType);

    return steps.size() > 0 ? steps.get(0) : null;
  }

  private Map<Integer, WorkflowTypeStep> getIndexKeySteps(final WorkflowType workflowType) {
    final Map<Integer, WorkflowTypeStep> map = workflowType.getSteps().stream()
        .collect(Collectors.toMap(step -> step.getStepIndex(), step -> step));

    return map;
  }

  private List<Integer> getSortedStepIndexs(final WorkflowType workflowType) {
    final List<Integer> list = workflowType.getSteps().stream().map(step -> step.getStepIndex()).sorted().collect(Collectors.toList());

    return list;
  }

  public WorkflowTypeStep findNextStep(final WorkflowType workflowType, final Workflow workflow) {

    final WorkflowTypeStep currectStep = workflow.getLastAction().getCurrentStep();

    final Map<Integer, WorkflowTypeStep> steps = this.getIndexKeySteps(workflowType);
    final List<Integer> sortedIndexes = getSortedStepIndexs(workflowType);

    final int stepIndexInList = sortedIndexes.indexOf(currectStep.getStepIndex());
    int nextStepIndexList = stepIndexInList + 1;
    nextStepIndexList = stepIndexInList < sortedIndexes.size() - 1 ? stepIndexInList + 1 : stepIndexInList;
    final Integer nextStepIndex = sortedIndexes.get(nextStepIndexList);

    return steps.get(nextStepIndex);

  }

  public boolean isLastStep(final WorkflowType workflowType, final WorkflowTypeStep step) {
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

  public WorkflowAction initialFirstStep(final Workflow workflow) {
    final WorkflowTypeStep firstStep = this.findFirstStep(workflow.getWorkflowType());

    final WorkflowAction action = new WorkflowAction();
    action.setAssignTo(0L);
    action.setComments("");
    action.setCurrentStep(firstStep);
    action.setCurrentStepId(firstStep.getId());
    action.setStatus(EWorkflowActionStatus.INITIALIZE);
    action.setVersion(1);
    action.setWorkflowId(workflow.getId());
    return action;
  }

  public WorkflowAction initialNextStep(final Workflow workflow) {

    final WorkflowTypeStep nextStep = this.findNextStep(workflow.getWorkflowType(), getProcessingWorkflow());

    if (nextStep != null) {
      final WorkflowAction action = new WorkflowAction();
      action.setAssignTo(0L);
      action.setComments("");
      action.setCurrentStep(nextStep);
      action.setCurrentStepId(nextStep.getId());
      action.setStatus(EWorkflowActionStatus.INITIALIZE);
      action.setVersion(1);
      action.setWorkflowId(workflow.getId());
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
    return processingWorkflowSaveRequest.getWorkflow().getActiveAction();
  }

  public WorkflowAction getPrevActiveAction() {
    return prevActiveAction;
  }

  public WorkflowType getProcessingWorkflowType() {
    return processingWorkflowSaveRequest.getWorkflow().getWorkflowType();
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

  public List<Workflow> getSavedWorkflowList() {
    return savedWorkflowList;
  }

  public void setSavedWorkflowList(final Collection<Workflow> savedWorkflowList) {
    this.savedWorkflowList.clear();
    if (savedWorkflowList != null) {
      this.savedWorkflowList.addAll(savedWorkflowList);
    }
  }

  public List<User> getDepartmentUserList(final Long departmentId)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    return departmentDataService.getUserListByDepartmentId(departmentId, this.getToken());
  }

  public List<User> getDepartmentGroupUserList(final Long departmentGroupId)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    return departmentDataService.getUserListByDepartmentGroupId(departmentGroupId, this.getToken());
  }

  public Set<Long> getAssignedUsers() {
    return assignedUsers;
  }

  public void setAssignedUsers(final Collection<Long> assignedUsers) {
    this.assignedUsers.clear();
    if (assignedUsers != null) {
      this.assignedUsers.addAll(assignedUsers);
    }
  }

  @Override
  public void process() throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    for (int stepProcessIndex = 0; stepProcessIndex < steps.size(); stepProcessIndex++) {
      final IWorkflowSaveStrategyStep processStep = steps.get(stepProcessIndex);

      if (processStep.shouldProcess()) {
        processStep.process();
      }
    }

  }

  @Override
  public Workflow getSingleProceedWorkflow() {
    return getSavedSingleWorkflow();
  }

  @Override
  public List<Workflow> getProceedWorkflowList() {
    return getSavedWorkflowList();
  }

  public boolean IsWorkflowCurrectStepChanged() {
    final Workflow processingWorkflow = getProcessingWorkflow();

    return existsingWorkflow == null || processingWorkflow.getCurrentStepId() != existsingWorkflow.getCurrentStepId();
  }
}

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
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IDepartmentDataService;
import com.pth.iflow.workflow.bl.IGuiCachDataDataService;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowMessageDataService;
import com.pth.iflow.workflow.bl.IWorkflowPrepare;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategy;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategyStep;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.User;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowMessage;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;
import com.pth.iflow.workflow.models.base.IWorkflow;
import com.pth.iflow.workflow.models.base.IWorkflowSaveRequest;

public abstract class AbstractWorkflowSaveStrategy<W extends IWorkflow> implements IWorkflowSaveStrategy<W> {

  private final IDepartmentDataService            departmentDataService;
  private final IWorkflowMessageDataService       workflowMessageDataService;
  private final IGuiCachDataDataService       profileCachDataDataService;
  private final IWorkflowDataService<W>           workflowDataService;
  private final IWorkflowPrepare<W>               workflowPrepare;

  protected final IWorkflowSaveRequest<W>         processingWorkflowSaveRequest;
  protected final String                          token;
  protected final WorkflowAction                  prevActiveAction;
  protected final W                               existsingWorkflow;

  protected final List<IWorkflowSaveStrategyStep> steps                 = new ArrayList<>();

  protected final List<W>                         savedWorkflowList     = new ArrayList<>();

  protected W                                     savedSingleWorkflow   = null;

  private final Set<String>                       assignedUsersIdentity = new HashSet<>();

  public AbstractWorkflowSaveStrategy(final IWorkflowSaveRequest<W> workflowCreateRequest, final String token,
      final IDepartmentDataService departmentDataService, final IWorkflowMessageDataService workflowMessageDataService,
      final IGuiCachDataDataService profileCachDataDataService, final IWorkflowDataService<W> workflowDataService,
      final IWorkflowPrepare<W> workflowPrepare)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    this.departmentDataService = departmentDataService;
    this.workflowMessageDataService = workflowMessageDataService;
    this.workflowDataService = workflowDataService;
    this.profileCachDataDataService = profileCachDataDataService;
    this.workflowPrepare = workflowPrepare;

    this.processingWorkflowSaveRequest = workflowCreateRequest;
    this.token = token;
    this.prevActiveAction = workflowCreateRequest.getWorkflow().getActiveAction();

    this.existsingWorkflow = getProcessingWorkflow().isNew() ? null
        : workflowDataService.getByIdentity(getProcessingWorkflow().getIdentity(), token);

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

  public void createWorkflowMessage(final W workflow, final String userIdentity)
      throws MalformedURLException, IFlowMessageConversionFailureException {
    final WorkflowMessage message = new WorkflowMessage();
    message.setCreatedByIdentity(workflow.getCreatedByIdentity());
    message.setExpireDays(this.processingWorkflowSaveRequest.getExpireDays());
    message.setMessage("Offering Workflow Message");
    message.setMessageType(EWorkflowMessageType.OFFERING_WORKFLOW);
    message.setStatus(EWorkflowMessageStatus.OFFERING);
    message.setUserIdentity(userIdentity);
    message.setWorkflowIdentity(workflow.getIdentity());
    message.setStepIdentity(workflow.getCurrentStepIdentity());
    message.setVersion(1);
    getWorkflowMessageDataService().save(message, this.getToken());
  }

  public void updateWorkflowMessageStatus(final String workflowIdentity, final String stepIdentity, final EWorkflowMessageStatus status)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    workflowMessageDataService.updateWorkflowMessageStatus(workflowIdentity, stepIdentity, status, this.getToken());
  }

  public void updateUserAndWorkflowMessageStatus(final String workflowIdentity, final String stepIdentity, final String userIdentity,
      final EWorkflowMessageStatus status) throws MalformedURLException, IFlowMessageConversionFailureException {

    workflowMessageDataService.updateUserAndWorkflowMessageStatus(workflowIdentity, stepIdentity, userIdentity, status, this.getToken());
  }

  public void resetUserListCachData(final String companyIdentity, final Set<String> userIdentityList)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    profileCachDataDataService.resetCachDataForUserList(companyIdentity, userIdentityList, token);
  }

  public void resetWorkflowtCachData(final String companyIdentity, final String workflowIdentity)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    profileCachDataDataService.resetCachDataForWorkflow(companyIdentity, workflowIdentity, token);
  }

  public W saveWorkflow(final W workflow) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    final W savedWorkflow = this.workflowDataService.save(workflow, this.token);

    return prepareWorkflow(savedWorkflow);
  }

  public WorkflowTypeStep findFirstStep(final WorkflowType workflowType) {
    final List<WorkflowTypeStep> steps = this.getSortedStepsList(workflowType);

    return steps.size() > 0 ? steps.get(0) : null;
  }

  private Map<Integer, WorkflowTypeStep> getIndexKeySteps(final WorkflowType workflowType) {
    final Map<Integer,
        WorkflowTypeStep> map = workflowType.getSteps().stream().collect(Collectors.toMap(step -> step.getStepIndex(), step -> step));

    return map;
  }

  private List<Integer> getSortedStepIndexs(final WorkflowType workflowType) {
    final List<Integer> list = workflowType.getSteps().stream().map(step -> step.getStepIndex()).sorted().collect(Collectors.toList());

    return list;
  }

  public WorkflowTypeStep findNextStep(final WorkflowType workflowType, final W workflow) {

    final WorkflowTypeStep               currectStep       = workflow.getLastAction().getCurrentStep();

    final Map<Integer, WorkflowTypeStep> steps             = this.getIndexKeySteps(workflowType);
    final List<Integer>                  sortedIndexes     = getSortedStepIndexs(workflowType);

    final int                            stepIndexInList   = sortedIndexes.indexOf(currectStep.getStepIndex());
    int                                  nextStepIndexList = stepIndexInList + 1;
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

  public WorkflowTypeStep findWorkflowStepinWorkflowTypeById(final WorkflowType workflowType, final String stepIdentity) {
    WorkflowTypeStep foundStep = null;
    for (final WorkflowTypeStep step : workflowType.getSteps()) {
      if (step.getIdentity() == stepIdentity) {
        foundStep = step;
        break;
      }
    }
    return foundStep;
  }

  public void validateCurrentStepExistsInWorkflowType(final W newWorkflow, final WorkflowType workflowType) {
    final List<String> stepIdList = this.getWorkflowTypeIdList(workflowType);

    if (stepIdList.contains(newWorkflow.getCurrentStep().getIdentity()) == false) {
      throw new WorkflowCustomizedException("Invalid workflow step id:" + newWorkflow.getIdentity(), EIFlowErrorType.INVALID_WORKFLOW_STEP);
    }
  }

  private List<String> getWorkflowTypeIdList(final WorkflowType workflowType) {
    return workflowType.getSteps().stream().map(step -> step.getIdentity()).collect(Collectors.toList());
  }

  public WorkflowAction getInitialStepAction(final W workflow) {
    final WorkflowTypeStep firstStep = this.findFirstStep(workflow.getWorkflowType());

    final WorkflowAction   action    = new WorkflowAction();
    action.setAssignToIdentity("");
    action.setComments("");
    action.setCurrentStep(firstStep);
    action.setCurrentStepIdentity(firstStep.getIdentity());
    action.setStatus(EWorkflowActionStatus.INITIALIZE);

    return action;
  }

  public WorkflowAction initialNextStep(final W workflow) {

    final WorkflowTypeStep nextStep = this.findNextStep(workflow.getWorkflowType(), getProcessingWorkflow());

    if (nextStep != null) {
      final WorkflowAction action = new WorkflowAction();
      action.setAssignToIdentity("");
      action.setComments("");
      action.setCurrentStep(nextStep);
      action.setCurrentStepIdentity(nextStep.getIdentity());
      action.setStatus(EWorkflowActionStatus.INITIALIZE);
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

  public IWorkflowSaveRequest<W> getProcessingWorkflowSaveRequest() {
    return processingWorkflowSaveRequest;
  }

  public W getProcessingWorkflow() {
    return processingWorkflowSaveRequest.getWorkflow();
  }

  public void setProcessingWorkflow(final W workflow) {
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

  public IWorkflowDataService<W> getWorkflowDataService() {
    return workflowDataService;
  }

  public W getSavedSingleWorkflow() {
    return savedSingleWorkflow;
  }

  public void setSavedSingleWorkflow(final W savedSingleWorkflow) {
    this.savedSingleWorkflow = savedSingleWorkflow;
  }

  public List<W> getSavedWorkflowList() {
    return savedWorkflowList;
  }

  public void setSavedWorkflowList(final Collection<W> savedWorkflowList) {
    this.savedWorkflowList.clear();
    if (savedWorkflowList != null) {
      this.savedWorkflowList.addAll(savedWorkflowList);
    }
  }

  public List<User> getDepartmentUserList(final String departmentIdentity)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    return departmentDataService.getUserListByDepartmentIdentity(departmentIdentity, this.getToken());
  }

  public List<User> getDepartmentGroupUserList(final String departmentGroupIdentity)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    return departmentDataService.getUserListByDepartmentGroupIdentity(departmentGroupIdentity, this.getToken());
  }

  public Set<String> getAssignedUsers() {
    return assignedUsersIdentity;
  }

  public void setAssignedUsers(final Collection<String> assignedUsers) {
    this.assignedUsersIdentity.clear();
    if (assignedUsers != null) {
      this.assignedUsersIdentity.addAll(assignedUsers);
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
  public W getSingleProceedWorkflow() {
    return getSavedSingleWorkflow();
  }

  @Override
  public List<W> getProceedWorkflowList() {
    return getSavedWorkflowList();
  }

  public boolean IsWorkflowCurrectStepChanged() {
    final W processingWorkflow = getProcessingWorkflow();

    return existsingWorkflow == null || processingWorkflow.isCurrentStepIdentity(existsingWorkflow.getCurrentStepIdentity()) == false;
  }

  public W prepareWorkflow(final W workflow) throws MalformedURLException, IFlowMessageConversionFailureException {
    return workflowPrepare.prepareWorkflow(this.token, workflow);
  }

  public List<W> prepareWorkflowList(final List<W> workflowList) throws MalformedURLException, IFlowMessageConversionFailureException {
    return workflowPrepare.prepareWorkflowList(this.token, workflowList);
  }
}

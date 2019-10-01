package com.pth.iflow.workflow.bl.strategies.save;

import java.net.MalformedURLException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.strategies.ISaveWorkflowStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

public abstract class AbstractSaveWorkflowStrategy implements ISaveWorkflowStrategy {

  protected final WorkflowSaveRequest processingWorkflowSaveRequest;
  protected final Workflow            processingWorkflow;
  protected final WorkflowType        workflowType;
  protected final String              token;
  protected final WorkflowAction      activeAction;
  private final IWorkflowDataService  workflowDataService;

  public AbstractSaveWorkflowStrategy(final WorkflowSaveRequest processingWorkflowSaveRequest, final String token,
      final IWorkflowDataService workflowDataService) {
    super();
    this.processingWorkflowSaveRequest = processingWorkflowSaveRequest;
    this.processingWorkflow = processingWorkflowSaveRequest.getWorkflow();
    this.workflowType = processingWorkflowSaveRequest.getWorkflow().getWorkflowType();
    this.token = token;
    this.activeAction = processingWorkflow.hasActiveAction() ? processingWorkflow.getActiveAction() : null;
    this.workflowDataService = workflowDataService;
  }

  protected Workflow saveWorkflow(final Workflow workflow)
      throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    final Workflow savedWorkflow = this.workflowDataService.save(workflow, this.token);

    return savedWorkflow;
  }

  protected void validateWorkflowCurrectStep(final Workflow workflow, final WorkflowType workflowType) throws MalformedURLException {

    if (workflow.getCurrentStep() == null) {

      if ((workflow.getCurrentStepId() != null) && (workflow.getCurrentStepId() > 0)) {
        this.setWorkflowCurrectStepFromCurrectStepId(workflow, workflowType);
      } else {
        this.setworkflowCurrectStep(workflow, workflowType);
      }
    }

    if (workflow.getCurrentStep() == null) {

      throw new IFlowCustomeException("Unknown workflow step id:" + workflow.getId(), EIFlowErrorType.UNKNOWN_WORKFLOW_STEP);
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

  private WorkflowTypeStep findFirstStep(final WorkflowType workflowType) {
    final List<WorkflowTypeStep> steps = this.getSortedStepsList(workflowType);

    return steps.size() > 0 ? steps.get(0) : null;
  }

  private Map<Long, WorkflowTypeStep> getIdKeySteps(final WorkflowType workflowType) {
    final Map<Long, WorkflowTypeStep> map = workflowType.getSteps().stream()
        .collect(Collectors.toMap(step -> step.getId(), step -> step));

    return map;
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

  private void setWorkflowCurrectStepFromCurrectStepId(final Workflow workflow, final WorkflowType workflowType)
      throws MalformedURLException {
    if (workflow.getCurrentStep() == null) {
      if ((workflow.getCurrentStepId() != null) && (workflow.getCurrentStepId() > 0)) {

        final Long stepId = workflow.getCurrentStepId();
        final WorkflowTypeStep foundStep = this.findWorkflowStepinWorkflowTypeById(workflowType, stepId);

        workflow.setCurrentStep(foundStep);
      }
    }
  }

  private WorkflowTypeStep findWorkflowStepinWorkflowTypeById(final WorkflowType workflowType, final Long stepId) {
    WorkflowTypeStep foundStep = null;
    for (final WorkflowTypeStep step : workflowType.getSteps()) {
      if (step.getId() == stepId) {
        foundStep = step;
        break;
      }
    }
    return foundStep;
  }

  private void validateCurrentStepExistsInWorkflowType(final Workflow newWorkflow, final WorkflowType workflowType) {
    final List<Long> stepIdList = this.getWorkflowTypeIdList(workflowType);

    if (stepIdList.contains(newWorkflow.getCurrentStep().getId()) == false) {
      throw new IFlowCustomeException("Invalid workflow step id:" + newWorkflow.getId(), EIFlowErrorType.INVALID_WORKFLOW_STEP);
    }
  }

  private List<Long> getWorkflowTypeIdList(final WorkflowType workflowType) {
    return workflowType.getSteps().stream().map(step -> step.getId()).collect(Collectors.toList());
  }

  protected void selectWorkflowNextStep(final Workflow newWorkflow, final WorkflowType workflowType,
      final WorkflowAction activeAction) {

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

    final WorkflowTypeStep nextStep = this.findNextStep(workflowType, processingWorkflow);

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

}

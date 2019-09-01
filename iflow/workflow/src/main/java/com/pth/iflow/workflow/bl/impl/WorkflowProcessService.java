package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.iflow.workflow.bl.ITokenValidator;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowCreateRequest;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

@Service
public class WorkflowProcessService implements IWorkflowProcessService {

  private static final Logger            logger = LoggerFactory.getLogger(WorkflowProcessService.class);

  private final IWorkflowDataService     workflowDataService;

  private final IWorkflowTypeDataService workflowTypeDataService;

  private final ITokenValidator          tokenValidator;

  public WorkflowProcessService(@Autowired final IWorkflowDataService workflowDataService,
      @Autowired final IWorkflowTypeDataService workflowTypeDataService, @Autowired final ITokenValidator tokenValidator) {

    this.workflowDataService = workflowDataService;
    this.workflowTypeDataService = workflowTypeDataService;
    this.tokenValidator = tokenValidator;
  }

  @Override
  public List<Workflow> create(final WorkflowCreateRequest model, final String token)
      throws WorkflowCustomizedException, MalformedURLException {

    final Workflow workflow = model.getWorkflow();
    workflow.setStatus(EWorkflowStatus.ASSIGNED);

    final List<Workflow> result = new ArrayList<>();

    for (final Long assignedId : model.getAssignedUsers()) {
      workflow.setAssignTo(assignedId);
      result.add(this.save(workflow, token));
    }

    return this.prepareWorkflowList(token, result);
  }

  @Override
  public Workflow save(final Workflow newWorkflow, final String token) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Saving workflow {} with token {}", newWorkflow.getTitle(), token);
    this.tokenCanSaveWorkflow(newWorkflow, token);

    final WorkflowType workflowType = this.workflowTypeDataService.getById(newWorkflow.getWorkflowTypeId(), token);

    this.validateWorkflowCurrectStep(newWorkflow, workflowType);

    this.validateWorkflowAssignedUser(newWorkflow, workflowType);

    if (newWorkflow.isNew()) {

      return this.saveNewWorkflow(newWorkflow, token);
    }

    if (newWorkflow.isStatusArchive()) {

      return this.saveExistsWorkflow(newWorkflow, token);
    }

    final WorkflowAction activeAction = newWorkflow.hasActiveAction() ? newWorkflow.getActiveAction() : null;

    if (newWorkflow.isAssigned() && newWorkflow.hasActiveAction() && (activeAction.isStatusSavingRequest())) {

      activeAction.setStatus(EWorkflowActionStatus.OPEN);
      return this.saveExistsWorkflow(newWorkflow, token);
    }

    if (newWorkflow.isAssigned() && newWorkflow.hasActiveAction() && (activeAction.isStatusDoneRequest())) {

      activeAction.setStatus(EWorkflowActionStatus.DONE);

      this.selectWorkflowNextAssigned(newWorkflow, workflowType, activeAction);
      this.selectWorkflowNextStep(newWorkflow, workflowType, activeAction);

      return this.saveExistsWorkflow(newWorkflow, token);
    }

    // final Workflow existsWorkflow = getById(newWorkflow.getId(), token);

    throw new IFlowCustomeException("Unknown workflow status id:" + newWorkflow.getId(), EIFlowErrorType.UNKNOWN_WORKFLOW_STATUS);
  }

  @Override
  public Workflow getById(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("get workflow by id {} with token {}", id, token);

    this.tokenCanReadWorkflow(id, token);
    final Workflow workflow = this.workflowDataService.getById(id, token);

    return this.prepareWorkflow(token, workflow);
  }

  @Override
  public List<Workflow> getListByTypeId(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("get workflow by  type id {} with token {}", id, token);

    final List<Workflow> list = this.workflowDataService.getListByTypeId(id, token);
    this.tokenCanReadWorkflowList(list.stream().map(w -> w.getId()).collect(Collectors.toList()), token);

    return this.prepareWorkflowList(token, list);
  }

  @Override
  public List<Workflow> getListForUser(final Long id, final int status, final String token)
      throws WorkflowCustomizedException, MalformedURLException {

    logger.debug("get workflow assigned to user id {} and has status {} with token {}", id, status, token);

    final List<Workflow> list = this.workflowDataService.getListForUser(id, status, token);
    this.tokenCanReadWorkflowList(list.stream().map(w -> w.getId()).collect(Collectors.toList()), token);

    return this.prepareWorkflowList(token, list);
  }

  @Override
  public List<Workflow> getListByIdList(final List<Long> idList, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("get workflow list by id list {} with token {}", idList, token);

    this.tokenCanReadWorkflowList(idList, token);

    final List<Workflow> list = this.workflowDataService.getListByIdList(idList, token);

    return this.prepareWorkflowList(token, list);
  }

  @Override
  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("search workflow with token {}", token);

    this.tokenCanSearchWorkflowList(workflowSearchFilter, token);

    final List<Workflow> list = this.workflowDataService.search(workflowSearchFilter, token);

    return this.prepareWorkflowList(token, list);
  }

  private boolean tokenCanReadWorkflow(final Long workflowId, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    // TODO token read access must be implemented

    this.tokenValidator.isTokenValid(token);

    return true;
  }

  private boolean tokenCanSaveWorkflow(final Workflow model, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    // TODO token save access must be implemented
    this.tokenValidator.isTokenValid(token);
    return true;
  }

  private boolean tokenCanReadWorkflowList(final List<Long> list, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    // TODO token read access must be implemented
    this.tokenValidator.isTokenValid(token);
    return true;
  }

  private boolean tokenCanSearchWorkflowList(final WorkflowSearchFilter workflowSearchFilter, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    // TODO token read access must be implemented
    this.tokenValidator.isTokenValid(token);
    return true;
  }

  private Workflow saveNewWorkflow(final Workflow model, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    // TODO process New Workflow must be implemented

    final Workflow savedWorkflow = this.workflowDataService.save(model, token);

    return savedWorkflow;
  }

  private Workflow saveExistsWorkflow(final Workflow model, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    // TODO process New Workflow must be implemented

    final Workflow savedWorkflow = this.workflowDataService.save(model, token);

    return savedWorkflow;
  }

  private void selectWorkflowNextStep(final Workflow newWorkflow, final WorkflowType workflowType, final WorkflowAction activeAction) {

    final WorkflowTypeStep nextStep = this.findNextStep(workflowType, newWorkflow, activeAction);
    if (nextStep == null) {
      throw new IFlowCustomeException("Invalid workflow step id:" + newWorkflow.getId(), EIFlowErrorType.INVALID_WORKFLOW_STEP);
    }

    newWorkflow.setCurrentStep(nextStep);
    newWorkflow.setCurrentStepId(nextStep.getId());

    if (this.isLastStep(workflowType, nextStep)) {
      newWorkflow.setStatus(EWorkflowStatus.DONE);
    }

  }

  private void selectWorkflowNextAssigned(final Workflow newWorkflow, final WorkflowType workflowType,
      final WorkflowAction activeAction) {

    /*
     * TODO: implements select next assigned for workflow based on new step
     */

    this.assignWorkflowToUser(newWorkflow, 0L);

    if (workflowType.getSendToController().booleanValue() == true) {
      this.assignWorkflowToUser(newWorkflow, newWorkflow.getController());
    } else {

      if (this.setAssignToControllerAfterLastStep(newWorkflow, workflowType, activeAction) == false) {
        if (workflowType.getAllowAssign() && activeAction.hasNextAssign()) {
          this.assignWorkflowToUser(newWorkflow, activeAction.getNextAssign());
        }
      }

    }

  }

  private void assignWorkflowToUser(final Workflow newWorkflow, final Long userId) {
    newWorkflow.setAssignTo(userId);
    newWorkflow.setStatus(userId == null || userId == 0 ? EWorkflowStatus.NOT_ASSIGNED : EWorkflowStatus.ASSIGNED);
  }

  private boolean setAssignToControllerAfterLastStep(final Workflow newWorkflow, final WorkflowType workflowType,
      final WorkflowAction activeAction) {
    final WorkflowTypeStep lastStep = this.findLastStep(workflowType);
    if (lastStep.getStepIndex() == newWorkflow.getCurrentStep().getStepIndex()) {
      newWorkflow.setAssignTo(newWorkflow.getController());
      return true;
    }
    return false;
  }

  private void selectWorkflowNextAssignedUser(final Workflow newWorkflow, final WorkflowType workflowType) {

    if (newWorkflow.isInitializing()) {
      if (newWorkflow.isAssigned()) {
        return;
      }
    }

  }

  private LinkedHashMap<Integer, WorkflowTypeStep> getSortedSteps(final WorkflowType workflowType) {
    final Map<Integer, WorkflowTypeStep> map = workflowType.getSteps().stream()
        .collect(Collectors.toMap(step -> step.getStepIndex(), step -> step));

    final LinkedHashMap<Integer, WorkflowTypeStep> steps = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

    return steps;
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

  private List<Integer> getSortedStepsIndexList(final WorkflowType workflowType) {

    final List<WorkflowTypeStep> list = this.getSortedStepsList(workflowType);

    return list.stream().map(s -> s.getStepIndex()).sorted().collect(Collectors.toList());
  }

  private Map<Long, WorkflowTypeStep> getIdKeySteps(final WorkflowType workflowType) {
    final Map<Long, WorkflowTypeStep> map = workflowType.getSteps().stream()
        .collect(Collectors.toMap(step -> step.getId(), step -> step));

    return map;
  }

  private WorkflowTypeStep findNextStep(final WorkflowType workflowType, final Workflow newWorkflow,
      final WorkflowAction activeAction) {

    final Long newStepIdFromActiveAction = activeAction.getNewStep();

    final Map<Long, WorkflowTypeStep> steps = this.getIdKeySteps(workflowType);

    if (steps.keySet().contains(newStepIdFromActiveAction)) {
      return steps.get(newStepIdFromActiveAction);
    }

    /*
     * Integer foundId = -1; Integer lastId = -1; for (final Iterator<Integer> i =
     * steps.keySet().iterator(); i.hasNext();) { lastId = i.next(); if ((lastId ==
     * currentStep.getStepIndex()) && i.hasNext()) { foundId = i.next(); break; } }
     *
     * return foundId > -1 ? steps.get(foundId) : steps.get(lastId);
     */
    return null;
  }

  private WorkflowTypeStep findFirstStep(final WorkflowType workflowType) {
    final List<WorkflowTypeStep> steps = this.getSortedStepsList(workflowType);

    return steps.size() > 0 ? steps.get(0) : null;
  }

  private WorkflowTypeStep findLastStep(final WorkflowType workflowType) {
    final List<WorkflowTypeStep> steps = this.getSortedStepsList(workflowType);

    return steps.size() > 0 ? steps.get(steps.size() - 1) : null;
  }

  private boolean isLastStep(final WorkflowType workflowType, final WorkflowTypeStep step) {
    final WorkflowTypeStep lastStep = this.findLastStep(workflowType);

    return step.getStepIndex() == lastStep.getStepIndex();
  }

  private List<Long> getWorkflowTypeIdList(final WorkflowType workflowType) {
    return workflowType.getSteps().stream().map(step -> step.getId()).collect(Collectors.toList());
  }

  private void validateWorkflowAssignedUser(final Workflow newWorkflow, final WorkflowType workflowType) {

    if (workflowType.getManualAssign().booleanValue() == false) {
      this.selectWorkflowNextAssignedUser(newWorkflow, workflowType);
    }

    if (newWorkflow.isAssigned() == false) {
      throw new IFlowCustomeException("Unknown workflow assigned user id:" + newWorkflow.getId(),
          EIFlowErrorType.UNKNOWN_WORKFLOW_ASSIGN);
    }
  }

  private void validateWorkflowCurrectStep(final Workflow newWorkflow, final WorkflowType workflowType) throws MalformedURLException {

    if (newWorkflow.getCurrentStep() == null) {

      this.setNewWorkflowCurrectStep(newWorkflow, workflowType);

      this.setWorkflowCurrectStepFromCurrectStepId(newWorkflow, workflowType);

    }

    if (newWorkflow.getCurrentStep() == null) {

      throw new IFlowCustomeException("Unknown workflow step id:" + newWorkflow.getId(), EIFlowErrorType.UNKNOWN_WORKFLOW_STEP);
    }

    this.validateCurrentStepExistsInWorkflowType(newWorkflow, workflowType);

  }

  private void validateCurrentStepExistsInWorkflowType(final Workflow newWorkflow, final WorkflowType workflowType) {
    final List<Long> stepIdList = this.getWorkflowTypeIdList(workflowType);

    if (stepIdList.contains(newWorkflow.getCurrentStep().getId()) == false) {
      throw new IFlowCustomeException("Invalid workflow step id:" + newWorkflow.getId(), EIFlowErrorType.INVALID_WORKFLOW_STEP);
    }
  }

  private void setWorkflowCurrectStepFromCurrectStepId(final Workflow newWorkflow, final WorkflowType workflowType)
      throws MalformedURLException {
    if (newWorkflow.getCurrentStep() == null) {
      if ((newWorkflow.getCurrentStepId() != null) && (newWorkflow.getCurrentStepId() > 0)) {

        final Long stepId = newWorkflow.getCurrentStepId();
        final WorkflowTypeStep foundStep = this.findWorkflowStepinWorkflowTypeById(workflowType, stepId);

        newWorkflow.setCurrentStep(foundStep);
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

  private void setNewWorkflowCurrectStep(final Workflow newWorkflow, final WorkflowType workflowType) {
    if ((newWorkflow.getCurrentStepId() == null) || (newWorkflow.getCurrentStepId() <= 0)) {
      if (newWorkflow.isInitializing()) {
        final WorkflowTypeStep firstStep = this.findFirstStep(workflowType);
        if (firstStep != null) {
          newWorkflow.setCurrentStep(firstStep);
          newWorkflow.setCurrentStepId(firstStep.getId());
        }

      }
    }
  }

  private Workflow prepareWorkflow(final String token, final Workflow workflow) throws MalformedURLException {
    final WorkflowType workflowType = this.workflowTypeDataService.getById(workflow.getWorkflowTypeId(), token);
    final List<Integer> stepIndexList = this.getSortedStepsIndexList(workflowType);
    final int index = stepIndexList.indexOf(workflow.getCurrentStep().getStepIndex());

    workflow.setNextAssign(index < stepIndexList.size() - 2);

    return workflow;
  }

  private List<Workflow> prepareWorkflowList(final String token, final List<Workflow> workflowList) throws MalformedURLException {
    final List<Workflow> list = new ArrayList<>();
    if (workflowList != null) {
      for (final Workflow workflow : workflowList) {
        list.add(this.prepareWorkflow(token, workflow));
      }

    }

    return list;
  }

}

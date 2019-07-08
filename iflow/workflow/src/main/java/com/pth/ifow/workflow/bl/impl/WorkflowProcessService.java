package com.pth.ifow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.enums.EWorkflowStatus;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowCustomeException;
import com.pth.ifow.workflow.bl.IWorkflowDataService;
import com.pth.ifow.workflow.bl.IWorkflowProcessService;
import com.pth.ifow.workflow.bl.IWorkflowTypeDataService;
import com.pth.ifow.workflow.config.WorkflowConfiguration;
import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.Workflow;
import com.pth.ifow.workflow.models.WorkflowType;
import com.pth.ifow.workflow.models.WorkflowTypeStep;

@Service
public class WorkflowProcessService implements IWorkflowProcessService {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowProcessService.class);

  private final IWorkflowDataService workflowDataService;

  private final IWorkflowTypeDataService workflowTypeService;

  public WorkflowProcessService(@Autowired final IWorkflowDataService workflowDataService,
      @Autowired final IWorkflowTypeDataService workflowTypeService,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {

    this.workflowDataService = workflowDataService;
    this.workflowTypeService = workflowTypeService;
  }

  @Override
  public Workflow save(final Workflow newWorkflow, final String token) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Saving workflow {} with token {}", newWorkflow.getTitle(), token);
    tokenCanSaveWorkflow(newWorkflow, token);

    if (newWorkflow.isNew()) {
      return processNewWorkflow(newWorkflow);
    }

    if (newWorkflow.getStatus() == EWorkflowStatus.ASSIGNED) {
      return processNewWorkflow(newWorkflow);
    }

    final WorkflowType workflowType = workflowTypeService.getById(newWorkflow.getWorkflowTypeId());

    final Workflow existsWorkflow = getById(newWorkflow.getId(), token);

    if (newWorkflow.getStatus() == EWorkflowStatus.DONE) {

      if (workflowType.getIncreaseStepAutomatic().booleanValue() == true) {
        selectWorkflowNextStep(newWorkflow, workflowType);

      }

      if (workflowType.getManualAssign().booleanValue() == false) {

        selectWorkflowAssignedUser(newWorkflow, workflowType);

      }

      return processNewWorkflow(newWorkflow);
    }

    throw new IFlowCustomeException("Unknown workflow status id:" + newWorkflow.getId(), EIFlowErrorType.UNKNOWN_WORKFLOW_STATUS);
  }

  @Override
  public Workflow getById(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("get workflow by id {} with token {}", id, token);

    tokenCanReadWorkflow(id, token);
    return this.workflowDataService.getById(id);
  }

  @Override
  public List<Workflow> getListByTypeId(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("get workflow by  type id {} with token {}", id, token);

    final List<Workflow> list = this.workflowDataService.getListByTypeId(id);
    tokenCanReadWorkflowList(list.stream().map(w -> w.getId()).collect(Collectors.toList()), token);

    return list;
  }

  @Override
  public List<Workflow> getListForUser(final Long id, final int status, final String token)
      throws WorkflowCustomizedException, MalformedURLException {

    logger.debug("get workflow assigned to user id {} and has status {} with token {}", id, status, token);

    final List<Workflow> list = this.workflowDataService.getListForUser(id, status);
    tokenCanReadWorkflowList(list.stream().map(w -> w.getId()).collect(Collectors.toList()), token);

    return list;
  }

  @Override
  public List<Workflow> getListByIdList(final List<Long> idList, final String token)
      throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("get workflow list by id list {} with token {}", idList, token);

    tokenCanReadWorkflowList(idList, token);

    final List<Workflow> list = this.workflowDataService.getListByIdList(idList);

    return list;
  }

  private boolean tokenCanReadWorkflow(final Long workflowId, final String token) {
    // TODO token read access must be implemented
    return true;
  }

  private boolean tokenCanSaveWorkflow(final Workflow model, final String token) {
    // TODO token save access must be implemented
    return true;
  }

  private boolean tokenCanReadWorkflowList(final List<Long> list, final String token) {
    // TODO token read access must be implemented
    return true;
  }

  private Workflow processNewWorkflow(final Workflow model) throws WorkflowCustomizedException, MalformedURLException {
    // TODO process New Workflow must be implemented

    final Workflow savedWorkflow = this.workflowDataService.save(model);

    return savedWorkflow;
  }

  private void selectWorkflowNextStep(final Workflow newWorkflow, final WorkflowType workflowType) {
    final LinkedHashMap<Integer, WorkflowTypeStep> steps = getSortedSteps(workflowType);

    final WorkflowTypeStep nextStep = findNextStep(steps, newWorkflow.getCurrentStep());
    newWorkflow.setCurrentStep(nextStep);
  }

  private void selectWorkflowAssignedUser(final Workflow newWorkflow, final WorkflowType workflowType) {
    if (workflowType.getSendToController().booleanValue() == true) {
      newWorkflow.setAssignTo(newWorkflow.getController());
    } else {

    }
  }

  private LinkedHashMap<Integer, WorkflowTypeStep> getSortedSteps(final WorkflowType workflowType) {
    final Map<Integer, WorkflowTypeStep> map = workflowType.getSteps().stream()
        .collect(Collectors.toMap(step -> step.getStepIndex(), step -> step));

    final LinkedHashMap<Integer, WorkflowTypeStep> steps = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

    return steps;
  }

  private WorkflowTypeStep findNextStep(final LinkedHashMap<Integer, WorkflowTypeStep> map, final WorkflowTypeStep currentStep) {

    Integer foundId = -1;
    Integer lastId = -1;
    for (final Iterator<Integer> i = map.keySet().iterator(); i.hasNext();) {
      lastId = i.next();
      if (lastId == currentStep.getStepIndex() && i.hasNext()) {
        foundId = i.next();
        break;
      }
    }

    return foundId > -1 ? map.get(foundId) : map.get(lastId);
  }

}

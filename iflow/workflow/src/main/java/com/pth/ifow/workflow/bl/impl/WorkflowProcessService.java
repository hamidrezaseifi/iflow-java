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
import com.pth.ifow.workflow.bl.IWorkflowTypeStepDataService;
import com.pth.ifow.workflow.config.WorkflowConfiguration;
import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.Workflow;
import com.pth.ifow.workflow.models.WorkflowType;
import com.pth.ifow.workflow.models.WorkflowTypeStep;

@Service
public class WorkflowProcessService implements IWorkflowProcessService {
  
  private static final Logger logger = LoggerFactory.getLogger(WorkflowProcessService.class);
  
  private final IWorkflowDataService workflowDataService;
  
  private final IWorkflowTypeDataService workflowTypeDataService;
  
  private final IWorkflowTypeStepDataService workflowTypeStepDataService;
  
  public WorkflowProcessService(@Autowired final IWorkflowDataService workflowDataService,
      @Autowired final IWorkflowTypeDataService workflowTypeDataService,
      @Autowired final IWorkflowTypeStepDataService workflowTypeStepDataService,
      @Autowired final WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig) {
    
    this.workflowDataService = workflowDataService;
    this.workflowTypeDataService = workflowTypeDataService;
    this.workflowTypeStepDataService = workflowTypeStepDataService;
  }
  
  @Override
  public Workflow save(final Workflow newWorkflow, final String token) throws WorkflowCustomizedException, MalformedURLException {
    logger.debug("Saving workflow {} with token {}", newWorkflow.getTitle(), token);
    tokenCanSaveWorkflow(newWorkflow, token);
    
    final WorkflowType workflowType = this.workflowTypeDataService.getById(newWorkflow.getWorkflowTypeId());
    
    validateWorkflowCurrectStep(newWorkflow, workflowType);
    
    validateWorkflowAssignedUser(newWorkflow, workflowType);
    
    if (newWorkflow.isNew()) {
      
      return processNewWorkflow(newWorkflow);
    }
    
    if (newWorkflow.getStatus() == EWorkflowStatus.ASSIGNED) {
      return processNewWorkflow(newWorkflow);
    }
    
    // final Workflow existsWorkflow = getById(newWorkflow.getId(), token);
    
    if (newWorkflow.getStatus() == EWorkflowStatus.DONE) {
      
      if (workflowType.getIncreaseStepAutomatic().booleanValue() == true) {
        selectWorkflowNextStep(newWorkflow, workflowType);
        
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
    
    final WorkflowTypeStep nextStep = findNextStep(workflowType, newWorkflow.getCurrentStep());
    newWorkflow.setCurrentStep(nextStep);
  }
  
  private void selectWorkflowNextAssignedUser(final Workflow newWorkflow, final WorkflowType workflowType) {
    
    if (newWorkflow.isInitializing()) {
      if (newWorkflow.isAssigned()) {
        return;
      }
    }
    
    if ((newWorkflow.getStatus() == EWorkflowStatus.DONE) && (workflowType.getSendToController().booleanValue() == true)) {
      newWorkflow.setAssignTo(newWorkflow.getController());
    }
    else {
      
    }
  }
  
  private LinkedHashMap<Integer, WorkflowTypeStep> getSortedSteps(final WorkflowType workflowType) {
    final Map<Integer, WorkflowTypeStep> map = workflowType.getSteps().stream()
        .collect(Collectors.toMap(step -> step.getStepIndex(), step -> step));
    
    final LinkedHashMap<Integer, WorkflowTypeStep> steps = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    
    return steps;
  }
  
  private WorkflowTypeStep findNextStep(final WorkflowType workflowType, final WorkflowTypeStep currentStep) {
    
    final LinkedHashMap<Integer, WorkflowTypeStep> steps = getSortedSteps(workflowType);
    
    Integer foundId = -1;
    Integer lastId = -1;
    for (final Iterator<Integer> i = steps.keySet().iterator(); i.hasNext();) {
      lastId = i.next();
      if ((lastId == currentStep.getStepIndex()) && i.hasNext()) {
        foundId = i.next();
        break;
      }
    }
    
    return foundId > -1 ? steps.get(foundId) : steps.get(lastId);
  }
  
  private WorkflowTypeStep findFirstStep(final WorkflowType workflowType) {
    final LinkedHashMap<Integer, WorkflowTypeStep> steps = getSortedSteps(workflowType);
    
    Integer foundId = -1;
    if (steps.keySet().iterator().hasNext()) {
      foundId = steps.keySet().iterator().next();
      
    }
    
    return foundId > -1 ? steps.get(foundId) : null;
  }
  
  private List<Long> getWorkflowTypeIdList(final WorkflowType workflowType) {
    return workflowType.getSteps().stream().map(step -> step.getId()).collect(Collectors.toList());
  }
  
  private void validateWorkflowAssignedUser(final Workflow newWorkflow, final WorkflowType workflowType) {
    
    if (workflowType.getManualAssign().booleanValue() == false) {
      selectWorkflowNextAssignedUser(newWorkflow, workflowType);
    }
    
    if (newWorkflow.isAssigned() == false) {
      throw new IFlowCustomeException("Unknown workflow assigned user id:" + newWorkflow.getId(),
          EIFlowErrorType.UNKNOWN_WORKFLOW_ASSIGN);
    }
  }
  
  private void validateWorkflowCurrectStep(final Workflow newWorkflow, final WorkflowType workflowType) throws MalformedURLException {
    
    if (newWorkflow.getCurrentStep() == null) {
      
      setNewWorkflowCurrectStep(newWorkflow, workflowType);
      
      setWorkflowCurrectStepFromCurrectStepId(newWorkflow);
      
    }
    
    if (newWorkflow.getCurrentStep() == null) {
      
      throw new IFlowCustomeException("Unknown workflow step id:" + newWorkflow.getId(), EIFlowErrorType.UNKNOWN_WORKFLOW_STEP);
    }
    
    validateCurrentStepExistsInWorkflowType(newWorkflow, workflowType);
    
  }
  
  private void validateCurrentStepExistsInWorkflowType(final Workflow newWorkflow, final WorkflowType workflowType) {
    final List<Long> stepIdList = getWorkflowTypeIdList(workflowType);
    
    if (stepIdList.contains(newWorkflow.getCurrentStep().getId()) == false) {
      throw new IFlowCustomeException("Invalid workflow step id:" + newWorkflow.getId(), EIFlowErrorType.INVALID_WORKFLOW_STEP);
    }
  }
  
  private void setWorkflowCurrectStepFromCurrectStepId(final Workflow newWorkflow) throws MalformedURLException {
    if ((newWorkflow.getCurrentStepId() != null) && (newWorkflow.getCurrentStepId() > 0)) {
      newWorkflow.setCurrentStep(this.workflowTypeStepDataService.getById(newWorkflow.getCurrentStepId()));
    }
  }
  
  private void setNewWorkflowCurrectStep(final Workflow newWorkflow, final WorkflowType workflowType) {
    if ((newWorkflow.getCurrentStepId() == null) || (newWorkflow.getCurrentStepId() <= 0)) {
      if (newWorkflow.isInitializing()) {
        final WorkflowTypeStep firstStep = findFirstStep(workflowType);
        if (firstStep != null) {
          newWorkflow.setCurrentStep(firstStep);
          newWorkflow.setCurrentStepId(firstStep.getId());
        }
        
      }
    }
  }
}

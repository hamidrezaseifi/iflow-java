package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.ITokenValidator;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.bl.strategy.ISaveWorkflowStrategy;
import com.pth.iflow.workflow.bl.strategy.IWorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
import com.pth.iflow.workflow.models.WorkflowAction;
import com.pth.iflow.workflow.models.WorkflowSaveRequest;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.WorkflowType;
import com.pth.iflow.workflow.models.WorkflowTypeStep;

@Service
public class WorkflowProcessService implements IWorkflowProcessService {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowProcessService.class);

  private final IWorkflowDataService workflowDataService;

  private final IWorkflowTypeDataService workflowTypeDataService;

  private final ITokenValidator tokenValidator;

  private final IWorkStrategyFactory workStrategyFactory;

  public WorkflowProcessService(@Autowired final IWorkflowDataService workflowDataService,
                                @Autowired final IWorkflowTypeDataService workflowTypeDataService,
                                @Autowired final ITokenValidator tokenValidator,
                                @Autowired final IWorkStrategyFactory workStrategyFactory) {

    this.workflowDataService = workflowDataService;
    this.workflowTypeDataService = workflowTypeDataService;
    this.tokenValidator = tokenValidator;
    this.workStrategyFactory = workStrategyFactory;
  }

  @Override
  public List<Workflow> create(final WorkflowSaveRequest model, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    prepareWorkflow(token, model.getWorkflow());

    final IWorkflowSaveStrategy createWorkflowStrategy = this.workStrategyFactory.selectCreateWorkStrategy(model, token);

    final List<Workflow> result = createWorkflowStrategy.process();

    return this.prepareWorkflowList(token, result);
  }

  @Override
  public Workflow save(final WorkflowSaveRequest request, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Saving workflow with token {}", token);
    this.tokenCanSaveWorkflow(request.getWorkflow(), token);

    final ISaveWorkflowStrategy strategy = this.workStrategyFactory.selectWorkStrategy(request, token);

    final Workflow result = strategy.process();

    return result;
  }

  @Override
  public Workflow getById(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("get workflow by id {} with token {}", id, token);

    this.tokenCanReadWorkflow(id, token);
    final Workflow workflow = this.workflowDataService.getById(id, token);

    return this.prepareWorkflow(token, workflow);
  }

  @Override
  public List<Workflow> getListByTypeId(final Long id, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("get workflow by  type id {} with token {}", id, token);

    final List<Workflow> list = this.workflowDataService.getListByTypeId(id, token);
    this.tokenCanReadWorkflowList(list.stream().map(w -> w.getId()).collect(Collectors.toList()), token);

    return this.prepareWorkflowList(token, list);
  }

  @Override
  public List<Workflow> getListForUser(final Long id, final int status, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("get workflow assigned to user id {} and has status {} with token {}", id, status, token);

    final List<Workflow> list = this.workflowDataService.getListForUser(id, status, token);
    this.tokenCanReadWorkflowList(list.stream().map(w -> w.getId()).collect(Collectors.toList()), token);

    return this.prepareWorkflowList(token, list);
  }

  @Override
  public List<Workflow> getListByIdList(final List<Long> idList, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("get workflow list by id list {} with token {}", idList, token);

    this.tokenCanReadWorkflowList(idList, token);

    final List<Workflow> list = this.workflowDataService.getListByIdList(idList, token);

    return this.prepareWorkflowList(token, list);
  }

  @Override
  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("search workflow with token {}", token);

    this.tokenCanSearchWorkflowList(workflowSearchFilter, token);

    final List<Workflow> list = this.workflowDataService.search(workflowSearchFilter, token);

    return this.prepareWorkflowList(token, list);
  }

  private boolean tokenCanReadWorkflow(final Long workflowId, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    // TODO token read access must be implemented

    this.tokenValidator.isTokenValid(token);

    return true;
  }

  private boolean tokenCanSaveWorkflow(final Workflow model, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    // TODO token save access must be implemented
    this.tokenValidator.isTokenValid(token);
    return true;
  }

  private boolean tokenCanReadWorkflowList(final List<Long> list, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    // TODO token read access must be implemented
    this.tokenValidator.isTokenValid(token);
    return true;
  }

  private boolean tokenCanSearchWorkflowList(final WorkflowSearchFilter workflowSearchFilter, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    // TODO token read access must be implemented
    this.tokenValidator.isTokenValid(token);
    return true;
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

  private Map<Long, WorkflowTypeStep> getIdMapedSteps(final WorkflowType workflowType) {

    final Map<Long, WorkflowTypeStep> list = workflowType.getSteps().stream().collect(Collectors.toMap(s -> s.getId(), s -> s));

    return list;
  }

  private Map<Integer, WorkflowTypeStep> getIndexMapedSteps(final WorkflowType workflowType) {

    final Map<Integer, WorkflowTypeStep> list = workflowType.getSteps()
                                                            .stream()
                                                            .collect(Collectors.toMap(s -> s.getStepIndex(), s -> s));

    return list;
  }

  private List<Integer> getSortedStepsIndexList(final WorkflowType workflowType) {

    final List<WorkflowTypeStep> list = this.getSortedStepsList(workflowType);

    return list.stream().map(s -> s.getStepIndex()).sorted().collect(Collectors.toList());
  }

  private Workflow prepareWorkflow(final String token, final Workflow workflow) throws MalformedURLException, IFlowMessageConversionFailureException {
    final WorkflowType workflowType = this.workflowTypeDataService.getById(workflow.getWorkflowTypeId(), token);

    workflow.setWorkflowType(workflowType);

    final Map<Long, WorkflowTypeStep> map = getIdMapedSteps(workflowType);

    workflow.setCurrentStep(map.containsKey(workflow.getCurrentStepId()) ? map.get(workflow.getCurrentStepId()) : null);
    for (final WorkflowAction action : workflow.getActions()) {
      action.setCurrentStep(map.containsKey(action.getCurrentStepId()) ? map.get(action.getCurrentStepId()) : null);
    }

    return workflow;
  }

  private List<Workflow> prepareWorkflowList(final String token, final List<Workflow> workflowList) throws MalformedURLException, IFlowMessageConversionFailureException {
    final List<Workflow> list = new ArrayList<>();
    if (workflowList != null) {
      for (final Workflow workflow : workflowList) {
        list.add(this.prepareWorkflow(token, workflow));
      }

    }

    return list;
  }

}

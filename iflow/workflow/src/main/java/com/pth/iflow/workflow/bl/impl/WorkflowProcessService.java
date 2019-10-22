package com.pth.iflow.workflow.bl.impl;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.workflow.bl.ITokenValidator;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.IWorkflowPrepare;
import com.pth.iflow.workflow.bl.IWorkflowProcessService;
import com.pth.iflow.workflow.bl.IWorkflowTypeDataService;
import com.pth.iflow.workflow.bl.strategy.IWorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.Workflow;
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

  private final IWorkflowPrepare workflowPrepare;

  public WorkflowProcessService(@Autowired final IWorkflowDataService workflowDataService,
                                @Autowired final IWorkflowTypeDataService workflowTypeDataService,
                                @Autowired final ITokenValidator tokenValidator,
                                @Autowired final IWorkStrategyFactory workStrategyFactory,
                                @Autowired final IWorkflowPrepare workflowPrepare) {

    this.workflowDataService = workflowDataService;
    this.workflowTypeDataService = workflowTypeDataService;
    this.tokenValidator = tokenValidator;
    this.workStrategyFactory = workStrategyFactory;
    this.workflowPrepare = workflowPrepare;
  }

  @Override
  public List<Workflow> create(final WorkflowSaveRequest request, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    validate(request, token);

    final IWorkflowSaveStrategy workflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(request, token);

    workflowStrategy.process();

    final List<Workflow> result = workflowStrategy.getProceedWorkflowList();

    return workflowPrepare.prepareWorkflowList(token, result);
  }

  @Override
  public Workflow save(final WorkflowSaveRequest request, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Saving workflow with token {}", token);
    this.tokenCanSaveWorkflow(request.getWorkflow(), token);

    validate(request, token);

    final IWorkflowSaveStrategy workflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(request, token);

    workflowStrategy.process();

    final Workflow result = workflowStrategy.getSingleProceedWorkflow();

    return result;
  }

  @Override
  public void validate(final WorkflowSaveRequest request, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    workflowPrepare.prepareWorkflow(token, request.getWorkflow());

    final IWorkflowSaveStrategy workflowStrategy = this.workStrategyFactory.selectValidationWorkStrategy(request, token);

    workflowStrategy.process();
  }

  @Override
  public Workflow getByIdentity(final String identity, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("get workflow by id {} with token {}", identity, token);

    this.tokenCanReadWorkflow(identity, token);
    final Workflow workflow = this.workflowDataService.getByIdentity(identity, token);

    return workflowPrepare.prepareWorkflow(token, workflow);
  }

  @Override
  public List<Workflow> getListByTypeIdentity(final String identity, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("get workflow by  type id {} with token {}", identity, token);

    final List<Workflow> list = this.workflowDataService.getListByTypeIdentity(identity, token);
    this.tokenCanReadWorkflowList(list.stream().map(w -> w.getIdentity()).collect(Collectors.toSet()), token);

    return workflowPrepare.prepareWorkflowList(token, list);
  }

  @Override
  public List<Workflow> getListForUser(final String identity, final int status, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("get workflow assigned to user id {} and has status {} with token {}", identity, status, token);

    final List<Workflow> list = this.workflowDataService.getListForUser(identity, status, token);
    this.tokenCanReadWorkflowList(list.stream().map(w -> w.getIdentity()).collect(Collectors.toSet()), token);

    return workflowPrepare.prepareWorkflowList(token, list);
  }

  @Override
  public List<Workflow> getListByIdentityList(final Set<String> identityList, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("get workflow list by id list with token {}", token);

    this.tokenCanReadWorkflowList(identityList, token);

    final List<Workflow> list = this.workflowDataService.getListByIdentityList(identityList, token);

    return workflowPrepare.prepareWorkflowList(token, list);
  }

  @Override
  public List<Workflow> search(final WorkflowSearchFilter workflowSearchFilter, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("search workflow with token {}", token);

    this.tokenCanSearchWorkflowList(workflowSearchFilter, token);

    final List<Workflow> list = this.workflowDataService.search(workflowSearchFilter, token);

    return workflowPrepare.prepareWorkflowList(token, list);
  }

  private boolean tokenCanReadWorkflow(final String workflowId, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    // TODO token read access must be implemented

    this.tokenValidator.isTokenValid(token);

    return true;
  }

  private boolean tokenCanSaveWorkflow(final Workflow model, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    // TODO token save access must be implemented
    this.tokenValidator.isTokenValid(token);
    return true;
  }

  private boolean tokenCanReadWorkflowList(final Set<String> list, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    // TODO token read access must be implemented
    this.tokenValidator.isTokenValid(token);
    return true;
  }

  private boolean tokenCanSearchWorkflowList(final WorkflowSearchFilter workflowSearchFilter, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    // TODO token read access must be implemented
    this.tokenValidator.isTokenValid(token);
    return true;
  }

  private Map<String, WorkflowTypeStep> getIdMapedSteps(final WorkflowType workflowType) {

    final Map<String, WorkflowTypeStep> list = workflowType.getSteps()
                                                           .stream()
                                                           .collect(Collectors.toMap(s -> s.getIdentity(), s -> s));

    return list;
  }

}

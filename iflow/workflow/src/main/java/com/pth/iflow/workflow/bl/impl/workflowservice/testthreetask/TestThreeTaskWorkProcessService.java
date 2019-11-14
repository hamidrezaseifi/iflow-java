package com.pth.iflow.workflow.bl.impl.workflowservice.testthreetask;

import java.net.MalformedURLException;
import java.util.List;
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
import com.pth.iflow.workflow.bl.strategy.IWorkStrategyFactory;
import com.pth.iflow.workflow.bl.strategy.IWorkflowSaveStrategy;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.WorkflowSearchFilter;
import com.pth.iflow.workflow.models.base.IWorkflowSaveRequest;
import com.pth.iflow.workflow.models.workflow.testthree.TestThreeTaskWorkflow;

@Service
public class TestThreeTaskWorkProcessService implements IWorkflowProcessService<TestThreeTaskWorkflow> {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  private final IWorkflowDataService<TestThreeTaskWorkflow> wrkflowDataService;

  private final ITokenValidator tokenValidator;

  private final IWorkStrategyFactory<TestThreeTaskWorkflow> workStrategyFactory;

  private final IWorkflowPrepare<TestThreeTaskWorkflow> workflowPrepare;

  public TestThreeTaskWorkProcessService(@Autowired final IWorkflowDataService<TestThreeTaskWorkflow> workflowDataService,
                                         @Autowired final ITokenValidator tokenValidator,
                                         @Autowired final IWorkStrategyFactory<TestThreeTaskWorkflow> workStrategyFactory,
                                         @Autowired final IWorkflowPrepare<TestThreeTaskWorkflow> workflowPrepare) {

    this.wrkflowDataService = workflowDataService;
    this.tokenValidator = tokenValidator;
    this.workStrategyFactory = workStrategyFactory;
    this.workflowPrepare = workflowPrepare;
  }

  @Override
  public List<TestThreeTaskWorkflow> create(final IWorkflowSaveRequest<TestThreeTaskWorkflow> request, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    validate(request, token);

    final IWorkflowSaveStrategy<TestThreeTaskWorkflow> workflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(request, token);

    workflowStrategy.process();

    final List<TestThreeTaskWorkflow> result = workflowStrategy.getProceedWorkflowList();

    return workflowPrepare.prepareWorkflowList(token, result);
  }

  @Override
  public TestThreeTaskWorkflow save(final IWorkflowSaveRequest<TestThreeTaskWorkflow> request, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("Saving workflow with token {}", token);
    this.tokenCanSaveWorkflow(request.getWorkflow(), token);

    validate(request, token);

    final IWorkflowSaveStrategy<TestThreeTaskWorkflow> workflowStrategy = this.workStrategyFactory.selectSaveWorkStrategy(request, token);

    workflowStrategy.process();

    final TestThreeTaskWorkflow result = workflowStrategy.getSingleProceedWorkflow();

    return result;
  }

  @Override
  public void validate(final IWorkflowSaveRequest<TestThreeTaskWorkflow> request, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    workflowPrepare.prepareWorkflow(token, request.getWorkflow());

    final IWorkflowSaveStrategy<TestThreeTaskWorkflow> workflowStrategy =
                                                                        this.workStrategyFactory.selectValidationWorkStrategy(request,
                                                                                                                              token);

    workflowStrategy.process();
  }

  @Override
  public TestThreeTaskWorkflow getByIdentity(final String identity, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("get workflow by id {} with token {}", identity, token);

    this.tokenCanReadWorkflow(identity, token);
    final TestThreeTaskWorkflow workflow = this.wrkflowDataService.getByIdentity(identity, token);

    return workflowPrepare.prepareWorkflow(token, workflow);
  }

  @Override
  public List<TestThreeTaskWorkflow> getListForUser(final String identity, final int status, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    logger.debug("get workflow assigned to user id {} and has status {} with token {}", identity, status, token);

    final List<TestThreeTaskWorkflow> list = this.wrkflowDataService.getListForUser(identity, status, token);
    this.tokenCanReadWorkflowList(list.stream().map(w -> w.getIdentity()).collect(Collectors.toSet()), token);

    return workflowPrepare.prepareWorkflowList(token, list);
  }

  @Override
  public List<TestThreeTaskWorkflow> getListByIdentityList(final Set<String> identityList, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("get workflow list by id list with token {}", token);

    this.tokenCanReadWorkflowList(identityList, token);

    final List<TestThreeTaskWorkflow> list = this.wrkflowDataService.getListByIdentityList(identityList, token);

    return workflowPrepare.prepareWorkflowList(token, list);
  }

  @Override
  public List<TestThreeTaskWorkflow> search(final WorkflowSearchFilter workflowSearchFilter, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    logger.debug("search workflow with token {}", token);

    this.tokenCanSearchWorkflowList(workflowSearchFilter, token);

    final List<TestThreeTaskWorkflow> list = this.wrkflowDataService.search(workflowSearchFilter, token);

    return workflowPrepare.prepareWorkflowList(token, list);
  }

  private boolean tokenCanReadWorkflow(final String workflowId, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    // TODO token read access must be implemented

    this.tokenValidator.isTokenValid(token);

    return true;
  }

  private boolean tokenCanSaveWorkflow(final TestThreeTaskWorkflow model, final String token) throws WorkflowCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
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

}
